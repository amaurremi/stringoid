package twitter4j.api;

import twitter4j.ResponseList;
import twitter4j.SavedSearch;

public abstract interface SavedSearchesResources {
    public abstract SavedSearch createSavedSearch(String paramString);

    public abstract SavedSearch destroySavedSearch(int paramInt);

    public abstract ResponseList<SavedSearch> getSavedSearches();

    public abstract SavedSearch showSavedSearch(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/SavedSearchesResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */