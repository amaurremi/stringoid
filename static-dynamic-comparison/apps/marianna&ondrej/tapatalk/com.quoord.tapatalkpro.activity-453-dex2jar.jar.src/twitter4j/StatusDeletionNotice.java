package twitter4j;

import java.io.Serializable;

public abstract interface StatusDeletionNotice
        extends Comparable<StatusDeletionNotice>, Serializable {
    public abstract long getStatusId();

    public abstract long getUserId();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/StatusDeletionNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */