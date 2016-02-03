package twitter4j.api;

import twitter4j.ResponseList;

public abstract interface SuggestedUsersResources
{
  public abstract ResponseList getMemberSuggestions(String paramString);
  
  public abstract ResponseList getSuggestedUserCategories();
  
  public abstract ResponseList getUserSuggestions(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/SuggestedUsersResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */