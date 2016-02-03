package twitter4j;

public final class JSONObjectType {
    private static final Logger logger = Logger.getLogger(JSONObjectType.class);

    public static JSONObjectType.Type determine(JSONObject paramJSONObject) {
        if (!paramJSONObject.isNull("sender")) {
            return JSONObjectType.Type.SENDER;
        }
        if (!paramJSONObject.isNull("text")) {
            return JSONObjectType.Type.STATUS;
        }
        if (!paramJSONObject.isNull("direct_message")) {
            return JSONObjectType.Type.DIRECT_MESSAGE;
        }
        if (!paramJSONObject.isNull("delete")) {
            return JSONObjectType.Type.DELETE;
        }
        if (!paramJSONObject.isNull("limit")) {
            return JSONObjectType.Type.LIMIT;
        }
        if (!paramJSONObject.isNull("warning")) {
            return JSONObjectType.Type.STALL_WARNING;
        }
        if (!paramJSONObject.isNull("scrub_geo")) {
            return JSONObjectType.Type.SCRUB_GEO;
        }
        if (!paramJSONObject.isNull("friends")) {
            return JSONObjectType.Type.FRIENDS;
        }
        if (!paramJSONObject.isNull("event")) {
            try {
                Object localObject = paramJSONObject.getString("event");
                if ("favorite".equals(localObject)) {
                    return JSONObjectType.Type.FAVORITE;
                }
                if ("unfavorite".equals(localObject)) {
                    return JSONObjectType.Type.UNFAVORITE;
                }
                if ("follow".equals(localObject)) {
                    return JSONObjectType.Type.FOLLOW;
                }
                if ("unfollow".equals(localObject)) {
                    return JSONObjectType.Type.UNFOLLOW;
                }
                if (((String) localObject).startsWith("list")) {
                    if ("list_member_added".equals(localObject)) {
                        return JSONObjectType.Type.USER_LIST_MEMBER_ADDED;
                    }
                    if ("list_member_removed".equals(localObject)) {
                        return JSONObjectType.Type.USER_LIST_MEMBER_DELETED;
                    }
                    if ("list_user_subscribed".equals(localObject)) {
                        return JSONObjectType.Type.USER_LIST_SUBSCRIBED;
                    }
                    if ("list_user_unsubscribed".equals(localObject)) {
                        return JSONObjectType.Type.USER_LIST_UNSUBSCRIBED;
                    }
                    if ("list_created".equals(localObject)) {
                        return JSONObjectType.Type.USER_LIST_CREATED;
                    }
                    if ("list_updated".equals(localObject)) {
                        return JSONObjectType.Type.USER_LIST_UPDATED;
                    }
                    if ("list_destroyed".equals(localObject)) {
                        return JSONObjectType.Type.USER_LIST_DESTROYED;
                    }
                } else {
                    if ("user_update".equals(localObject)) {
                        return JSONObjectType.Type.USER_UPDATE;
                    }
                    if ("block".equals(localObject)) {
                        return JSONObjectType.Type.BLOCK;
                    }
                    if ("unblock".equals(localObject)) {
                        localObject = JSONObjectType.Type.UNBLOCK;
                        return (JSONObjectType.Type) localObject;
                    }
                }
            } catch (JSONException localJSONException) {
            }
        }
        try {
            logger.warn("Failed to get event element: ", paramJSONObject.toString(2));
            do {
                return JSONObjectType.Type.UNKNOWN;
            } while (paramJSONObject.isNull("disconnect"));
            return JSONObjectType.Type.DISCONNECTION;
        } catch (JSONException paramJSONObject) {
            for (; ; ) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/JSONObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */