package cn.byhieg.arithmetic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weizhaoquan on 2019/03/20.
 */

public class SlidingWindow {

    private AtomicInteger[] timeSlices;
    /* 队列的总长度  */
    private final int timeSliceSize;
    /* 每个时间片的时长 */
    private final long timeMillisPerSlice;
    /* 窗口长度 */
    private final int windowSize;

    /* 当前所使用的时间片位置 */
    private AtomicInteger cursor = new AtomicInteger(0);

    public static enum Time {
        MILLISECONDS(1),
        SECONDS(1000),
        MINUTES(SECONDS.getMillis() * 60),
        HOURS(MINUTES.getMillis() * 60),
        DAYS(HOURS.getMillis() * 24),
        WEEKS(DAYS.getMillis() * 7);

        private long millis;

        Time(long millis) {
            this.millis = millis;
        }

        public long getMillis() {
            return millis;
        }
    }

    public SlidingWindow(int windowSize, Time timeSlice) {
        this.timeMillisPerSlice = timeSlice.millis;
        this.windowSize = windowSize;
        // 保证存储在至少两个window
        this.timeSliceSize = windowSize * 2 + 1;

        init();
    }

    /**
     * 初始化
     */
    private void init() {
        AtomicInteger[] localTimeSlices = new AtomicInteger[timeSliceSize];
        for (int i = 0; i < timeSliceSize; i++) {
            localTimeSlices[i] = new AtomicInteger(0);
        }
        timeSlices = localTimeSlices;
    }

    private int locationIndex() {
        long time = System.currentTimeMillis();
        return (int) ((time / timeMillisPerSlice) % timeSliceSize);
    }

    /**
     * <p>对时间片计数+1，并返回窗口中所有的计数总和
     * <p>该方法只要调用就一定会对某个时间片进行+1
     * @return
     */
    public int incrementAndSum() {
        int index = locationIndex();
        int sum = 0;
        // cursor等于index，返回true
        // cursor不等于index，返回false，并会将cursor设置为index
        int oldCursor = cursor.getAndSet(index);
        if (oldCursor == index) {
            // 在当前时间片里继续+1
            sum += timeSlices[index].incrementAndGet();
        } else {
            //轮到新的时间片，置0，可能有其它线程也置了该值，容许
            timeSlices[index].set(0);
            // 清零，访问量不大时会有时间片跳跃的情况
            clearBetween(oldCursor, index);

            sum += timeSlices[index].incrementAndGet();
        }

        for (int i = 1; i < windowSize; i++) {
            sum += timeSlices[(index - i + timeSliceSize) % timeSliceSize].get();
        }
        return sum;
    }

    /**
     * 判断是否允许进行访问，未超过阈值的话才会对某个时间片+1
     * @param threshold
     * @return
     */
    public boolean allow(int threshold) {
        int index = locationIndex();
        int sum = 0;
        int oldCursor = cursor.getAndSet(index);
        if (oldCursor != index) {
            timeSlices[index].set(0);
            clearBetween(oldCursor, index);
        }
        for (int i = 0; i < windowSize; i++) {
            sum += timeSlices[(index - i + timeSliceSize) % timeSliceSize].get();
        }

        // 阈值判断
        if (sum < threshold) {
            // 未超过阈值才+1
            timeSlices[index].incrementAndGet();
            return true;
        }
        return false;
    }

    /**
     * <p>将fromIndex~toIndex之间的时间片计数都清零
     * <p>极端情况下，当循环队列已经走了超过1个timeSliceSize以上，这里的清零并不能如期望的进行
     * @param fromIndex 不包含
     * @param toIndex 不包含
     */
    private void clearBetween(int fromIndex, int toIndex) {
        for (int index = (fromIndex + 1) % timeSliceSize; index != toIndex; index = (index + 1) % timeSliceSize) {
            timeSlices[index].set(0);
        }
    }

    public static void main(String[] args) {
        SlidingWindow window = new SlidingWindow(5, Time.MILLISECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.println(window.allow(7));
        }
    }
}