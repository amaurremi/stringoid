package twitter4j.api;

import twitter4j.ResponseList;
import twitter4j.SavedSearch;

public abstract interface SavedSearchesResources
{
  public abstract SavedSearch createSavedSearch(String paramString);
  
  public abstract SavedSearch destroySavedSearch(int paramInt);
  
  public abstract ResponseList getSavedSearches();
  
  public abstract SavedSearch showSavedSearch(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/SavedSearchesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */