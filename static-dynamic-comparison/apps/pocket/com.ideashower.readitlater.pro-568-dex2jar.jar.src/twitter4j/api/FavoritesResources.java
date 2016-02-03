package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;

public abstract interface FavoritesResources
{
  public abstract Status createFavorite(long paramLong);
  
  public abstract Status destroyFavorite(long paramLong);
  
  public abstract ResponseList getFavorites();
  
  public abstract ResponseList getFavorites(long paramLong);
  
  public abstract ResponseList getFavorites(long paramLong, Paging paramPaging);
  
  public abstract ResponseList getFavorites(String paramString);
  
  public abstract ResponseList getFavorites(String paramString, Paging paramPaging);
  
  public abstract ResponseList getFavorites(Paging paramPaging);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/FavoritesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */