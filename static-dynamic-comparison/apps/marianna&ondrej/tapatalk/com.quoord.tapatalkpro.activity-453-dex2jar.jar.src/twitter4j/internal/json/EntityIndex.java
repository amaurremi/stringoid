package twitter4j.internal.json;

import java.io.Serializable;

abstract class EntityIndex
        implements Comparable<EntityIndex>, Serializable {
    private static final long serialVersionUID = 3864336402689899384L;
    private int end = -1;
    private int start = -1;

    public int compareTo(EntityIndex paramEntityIndex) {
        long l = this.start - paramEntityIndex.start;
        if (l < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (l > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) l;
    }

    int getEnd() {
        return this.end;
    }

    int getStart() {
        return this.start;
    }

    void setEnd(int paramInt) {
        this.end = paramInt;
    }

    void setStart(int paramInt) {
        this.start = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/EntityIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */