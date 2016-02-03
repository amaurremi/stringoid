package twitter4j;

import java.util.Map;

public final class TwitterObjectFactory {
    private static final ThreadLocal<Map> rawJsonMap = new TwitterObjectFactory
    .1();
    private static boolean registeredAtleastOnce = false;

    private TwitterObjectFactory() {
        throw new AssertionError("not intended to be instantiated.");
    }

    static void clearThreadLocalMap() {
        ((Map) rawJsonMap.get()).clear();
    }

    public static AccountTotals createAccountTotals(String paramString) {
        try {
            paramString = new AccountTotalsJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static Category createCategory(String paramString) {
        try {
            paramString = new CategoryJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static DirectMessage createDirectMessage(String paramString) {
        try {
            paramString = new DirectMessageJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static IDs createIDs(String paramString) {
        return new IDsJSONImpl(paramString);
    }

    public static Location createLocation(String paramString) {
        try {
            paramString = new LocationJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static OEmbed createOEmbed(String paramString) {
        try {
            paramString = new OEmbedJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static Object createObject(String paramString) {
        try {
            paramString = new JSONObject(paramString);
            JSONObjectType.Type localType = JSONObjectType.determine(paramString);
            switch (TwitterObjectFactory .2.$SwitchMap$twitter4j$JSONObjectType$Type[localType.ordinal()])
            {
                case 1:
                    return registerJSONObject(new DirectMessageJSONImpl(paramString.getJSONObject("direct_message")), paramString);
            }
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
        return registerJSONObject(new StatusJSONImpl(paramString), paramString);
        return registerJSONObject(new DirectMessageJSONImpl(paramString.getJSONObject("direct_message")), paramString);
        paramString = registerJSONObject(new StatusDeletionNoticeImpl(paramString.getJSONObject("delete").getJSONObject("status")), paramString);
        return paramString;
        return paramString;
    }

    public static Place createPlace(String paramString) {
        try {
            paramString = new PlaceJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static Map<String, RateLimitStatus> createRateLimitStatus(String paramString) {
        try {
            paramString = RateLimitStatusJSONImpl.createRateLimitStatuses(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static Relationship createRelationship(String paramString) {
        try {
            paramString = new RelationshipJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static SavedSearch createSavedSearch(String paramString) {
        try {
            paramString = new SavedSearchJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static Status createStatus(String paramString) {
        try {
            paramString = new StatusJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static Trend createTrend(String paramString) {
        try {
            paramString = new TrendJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static Trends createTrends(String paramString) {
        return new TrendsJSONImpl(paramString);
    }

    public static User createUser(String paramString) {
        try {
            paramString = new UserJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static UserList createUserList(String paramString) {
        try {
            paramString = new UserListJSONImpl(new JSONObject(paramString));
            return paramString;
        } catch (JSONException paramString) {
            throw new TwitterException(paramString);
        }
    }

    public static String getRawJSON(Object paramObject) {
        if (!registeredAtleastOnce) {
            throw new IllegalStateException("Apparently jsonStoreEnabled is not set to true.");
        }
        paramObject = ((Map) rawJsonMap.get()).get(paramObject);
        if ((paramObject instanceof String)) {
            return (String) paramObject;
        }
        if (paramObject != null) {
            return paramObject.toString();
        }
        return null;
    }

    static <T> T registerJSONObject(T paramT, Object paramObject) {
        registeredAtleastOnce = true;
        ((Map) rawJsonMap.get()).put(paramT, paramObject);
        return paramT;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TwitterObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */