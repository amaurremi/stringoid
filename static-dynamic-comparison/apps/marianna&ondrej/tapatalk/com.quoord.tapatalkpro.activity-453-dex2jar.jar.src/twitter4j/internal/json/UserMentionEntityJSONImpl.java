package twitter4j.internal.json;

import twitter4j.TwitterException;
import twitter4j.UserMentionEntity;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class UserMentionEntityJSONImpl
        extends EntityIndex
        implements UserMentionEntity {
    private static final long serialVersionUID = 6580431141350059702L;
    private long id;
    private String name;
    private String screenName;

    UserMentionEntityJSONImpl() {
    }

    UserMentionEntityJSONImpl(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {
        setStart(paramInt1);
        setEnd(paramInt2);
        this.name = paramString1;
        this.screenName = paramString2;
        this.id = paramLong;
    }

    UserMentionEntityJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        init(paramJSONObject);
    }

    private void init(JSONObject paramJSONObject)
            throws TwitterException {
        try {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("indices");
            setStart(localJSONArray.getInt(0));
            setEnd(localJSONArray.getInt(1));
            if (!paramJSONObject.isNull("name")) {
                this.name = paramJSONObject.getString("name");
            }
            if (!paramJSONObject.isNull("screen_name")) {
                this.screenName = paramJSONObject.getString("screen_name");
            }
            this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
            return;
        } catch (JSONException paramJSONObject) {
            throw new TwitterException(paramJSONObject);
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (UserMentionEntityJSONImpl) paramObject;
            if (this.id != ((UserMentionEntityJSONImpl) paramObject).id) {
                return false;
            }
            if (this.name != null) {
                if (this.name.equals(((UserMentionEntityJSONImpl) paramObject).name)) {
                }
            } else {
                while (((UserMentionEntityJSONImpl) paramObject).name != null) {
                    return false;
                }
            }
            if (this.screenName == null) {
                break;
            }
        } while (this.screenName.equals(((UserMentionEntityJSONImpl) paramObject).screenName));
        for (; ; ) {
            return false;
            if (((UserMentionEntityJSONImpl) paramObject).screenName == null) {
                break;
            }
        }
    }

    public int getEnd() {
        return super.getEnd();
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public int getStart() {
        return super.getStart();
    }

    public String getText() {
        return this.screenName;
    }

    public int hashCode() {
        int j = 0;
        if (this.name != null) {
        }
        for (int i = this.name.hashCode(); ; i = 0) {
            if (this.screenName != null) {
                j = this.screenName.hashCode();
            }
            return (i * 31 + j) * 31 + (int) (this.id ^ this.id >>> 32);
        }
    }

    public String toString() {
        return "UserMentionEntityJSONImpl{name='" + this.name + '\'' + ", screenName='" + this.screenName + '\'' + ", id=" + this.id + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/UserMentionEntityJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */