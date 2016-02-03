package twitter4j.json;

import java.util.Map;

import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.OEmbed;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Relationship;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import twitter4j.UserList;

public final class DataObjectFactory {
    private DataObjectFactory() {
        throw new AssertionError("not intended to be instantiated.");
    }

    public static AccountTotals createAccountTotals(String paramString) {
        return TwitterObjectFactory.createAccountTotals(paramString);
    }

    public static Category createCategory(String paramString) {
        return TwitterObjectFactory.createCategory(paramString);
    }

    public static DirectMessage createDirectMessage(String paramString) {
        return TwitterObjectFactory.createDirectMessage(paramString);
    }

    public static IDs createIDs(String paramString) {
        return TwitterObjectFactory.createIDs(paramString);
    }

    public static Location createLocation(String paramString) {
        return TwitterObjectFactory.createLocation(paramString);
    }

    public static OEmbed createOEmbed(String paramString) {
        return TwitterObjectFactory.createOEmbed(paramString);
    }

    public static Object createObject(String paramString) {
        return TwitterObjectFactory.createObject(paramString);
    }

    public static Place createPlace(String paramString) {
        return TwitterObjectFactory.createPlace(paramString);
    }

    public static Map<String, RateLimitStatus> createRateLimitStatus(String paramString) {
        return TwitterObjectFactory.createRateLimitStatus(paramString);
    }

    public static Relationship createRelationship(String paramString) {
        return TwitterObjectFactory.createRelationship(paramString);
    }

    public static SavedSearch createSavedSearch(String paramString) {
        return TwitterObjectFactory.createSavedSearch(paramString);
    }

    public static Status createStatus(String paramString) {
        return TwitterObjectFactory.createStatus(paramString);
    }

    public static Trend createTrend(String paramString) {
        return TwitterObjectFactory.createTrend(paramString);
    }

    public static Trends createTrends(String paramString) {
        return TwitterObjectFactory.createTrends(paramString);
    }

    public static User createUser(String paramString) {
        return TwitterObjectFactory.createUser(paramString);
    }

    public static UserList createUserList(String paramString) {
        return TwitterObjectFactory.createUserList(paramString);
    }

    public static String getRawJSON(Object paramObject) {
        return TwitterObjectFactory.getRawJSON(paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/json/DataObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */