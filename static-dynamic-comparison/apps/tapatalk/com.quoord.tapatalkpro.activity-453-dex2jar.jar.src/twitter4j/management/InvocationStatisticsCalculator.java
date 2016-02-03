package twitter4j.management;

public class InvocationStatisticsCalculator
        implements InvocationStatistics {
    private long callCount;
    private long errorCount;
    private int index;
    private String name;
    private long[] times;
    private long totalTime;

    public InvocationStatisticsCalculator(String paramString, int paramInt) {
        this.name = paramString;
        this.times = new long[paramInt];
    }

    /* Error */
    public long getAverageTime() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 30	twitter4j/management/InvocationStatisticsCalculator:callCount	J
        //   6: l2i
        //   7: invokestatic 36	java/lang/Math:abs	(I)I
        //   10: aload_0
        //   11: getfield 25	twitter4j/management/InvocationStatisticsCalculator:times	[J
        //   14: arraylength
        //   15: invokestatic 40	java/lang/Math:min	(II)I
        //   18: istore_2
        //   19: iload_2
        //   20: ifne +9 -> 29
        //   23: lconst_0
        //   24: lstore_3
        //   25: aload_0
        //   26: monitorexit
        //   27: lload_3
        //   28: lreturn
        //   29: lconst_0
        //   30: lstore_3
        //   31: iconst_0
        //   32: istore_1
        //   33: iload_1
        //   34: iload_2
        //   35: if_icmpge +19 -> 54
        //   38: lload_3
        //   39: aload_0
        //   40: getfield 25	twitter4j/management/InvocationStatisticsCalculator:times	[J
        //   43: iload_1
        //   44: laload
        //   45: ladd
        //   46: lstore_3
        //   47: iload_1
        //   48: iconst_1
        //   49: iadd
        //   50: istore_1
        //   51: goto -18 -> 33
        //   54: lload_3
        //   55: iload_2
        //   56: i2l
        //   57: ldiv
        //   58: lstore_3
        //   59: goto -34 -> 25
        //   62: astore 5
        //   64: aload_0
        //   65: monitorexit
        //   66: aload 5
        //   68: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	69	0	this	InvocationStatisticsCalculator
        //   32	19	1	i	int
        //   18	38	2	j	int
        //   24	35	3	l	long
        //   62	5	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	19	62	finally
        //   38	47	62	finally
        //   54	59	62	finally
    }

    public long getCallCount() {
        return this.callCount;
    }

    public long getErrorCount() {
        return this.errorCount;
    }

    public String getName() {
        return this.name;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    void increment(long paramLong, boolean paramBoolean) {
        long l1 = 1L;
        this.callCount += 1L;
        long l2 = this.errorCount;
        if (paramBoolean) {
            l1 = 0L;
        }
        this.errorCount = (l1 + l2);
        this.totalTime += paramLong;
        this.times[this.index] = paramLong;
        int i = this.index + 1;
        this.index = i;
        if (i >= this.times.length) {
            this.index = 0;
        }
    }

    public void reset() {
        try {
            this.callCount = 0L;
            this.errorCount = 0L;
            this.totalTime = 0L;
            this.times = new long[this.times.length];
            this.index = 0;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("calls=").append(getCallCount()).append(",").append("errors=").append(getErrorCount()).append(",").append("totalTime=").append(getTotalTime()).append(",").append("avgTime=").append(getAverageTime());
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/management/InvocationStatisticsCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */