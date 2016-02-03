package twitter4j;

import java.io.Serializable;

public abstract interface OEmbed
        extends TwitterResponse, Serializable {
    public abstract String getAuthorName();

    public abstract String getAuthorURL();

    public abstract long getCacheAge();

    public abstract String getHtml();

    public abstract String getURL();

    public abstract String getVersion();

    public abstract int getWidth();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/OEmbed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */