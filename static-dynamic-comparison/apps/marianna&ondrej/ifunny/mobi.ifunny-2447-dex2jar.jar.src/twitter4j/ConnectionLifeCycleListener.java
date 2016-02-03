package twitter4j;

public abstract interface ConnectionLifeCycleListener {
    public abstract void onCleanUp();

    public abstract void onConnect();

    public abstract void onDisconnect();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/ConnectionLifeCycleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */