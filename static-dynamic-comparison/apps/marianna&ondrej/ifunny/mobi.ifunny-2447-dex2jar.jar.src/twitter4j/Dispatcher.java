package twitter4j;

public abstract interface Dispatcher {
    public abstract void invokeLater(Runnable paramRunnable);

    public abstract void shutdown();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */