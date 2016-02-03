package twitter4j.internal.async;

public abstract interface Dispatcher {
    public abstract void invokeLater(Runnable paramRunnable);

    public abstract void shutdown();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/async/Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */