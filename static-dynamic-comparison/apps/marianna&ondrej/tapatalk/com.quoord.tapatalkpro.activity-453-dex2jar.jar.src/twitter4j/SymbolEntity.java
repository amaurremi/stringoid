package twitter4j;

import java.io.Serializable;

public abstract interface SymbolEntity
        extends TweetEntity, Serializable {
    public abstract int getEnd();

    public abstract int getStart();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/SymbolEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */