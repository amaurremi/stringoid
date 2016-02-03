package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;

public abstract interface FavoritesResources {
    public abstract Status createFavorite(long paramLong);

    public abstract Status destroyFavorite(long paramLong);

    public abstract ResponseList<Status> getFavorites();

    public abstract ResponseList<Status> getFavorites(long paramLong);

    public abstract ResponseList<Status> getFavorites(long paramLong, Paging paramPaging);

    public abstract ResponseList<Status> getFavorites(String paramString);

    public abstract ResponseList<Status> getFavorites(String paramString, Paging paramPaging);

    public abstract ResponseList<Status> getFavorites(Paging paramPaging);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/FavoritesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */