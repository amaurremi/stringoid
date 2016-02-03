package twitter4j.management;

public abstract interface InvocationStatistics {
    public abstract long getAverageTime();

    public abstract long getCallCount();

    public abstract long getErrorCount();

    public abstract String getName();

    public abstract long getTotalTime();

    public abstract void reset();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/management/InvocationStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */