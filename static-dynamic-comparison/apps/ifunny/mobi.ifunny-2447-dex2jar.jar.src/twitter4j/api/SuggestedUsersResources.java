package twitter4j.api;

import twitter4j.Category;
import twitter4j.ResponseList;
import twitter4j.User;

public abstract interface SuggestedUsersResources {
    public abstract ResponseList<User> getMemberSuggestions(String paramString);

    public abstract ResponseList<Category> getSuggestedUserCategories();

    public abstract ResponseList<User> getUserSuggestions(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/SuggestedUsersResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */