package twitter4j;

import java.io.Serializable;
import java.util.Date;

public abstract interface SavedSearch
        extends Serializable, Comparable<SavedSearch>, TwitterResponse {
    public abstract Date getCreatedAt();

    public abstract int getId();

    public abstract String getName();

    public abstract int getPosition();

    public abstract String getQuery();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/SavedSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */