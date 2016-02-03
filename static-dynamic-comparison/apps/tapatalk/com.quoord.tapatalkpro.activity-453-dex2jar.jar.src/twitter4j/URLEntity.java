package twitter4j;

import java.io.Serializable;

public abstract interface URLEntity
        extends TweetEntity, Serializable {
    public abstract String getDisplayURL();

    public abstract int getEnd();

    public abstract String getExpandedURL();

    public abstract int getStart();

    public abstract String getText();

    public abstract String getURL();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/URLEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */