package twitter4j.conf;

public abstract interface ConfigurationFactory {
    public abstract void dispose();

    public abstract Configuration getInstance();

    public abstract Configuration getInstance(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/conf/ConfigurationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */