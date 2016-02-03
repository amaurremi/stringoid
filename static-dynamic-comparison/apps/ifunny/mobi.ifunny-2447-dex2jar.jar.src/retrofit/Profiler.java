package retrofit;

public abstract interface Profiler<T> {
    public abstract void afterCall(Profiler.RequestInformation paramRequestInformation, long paramLong, int paramInt, T paramT);

    public abstract T beforeCall();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Profiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */