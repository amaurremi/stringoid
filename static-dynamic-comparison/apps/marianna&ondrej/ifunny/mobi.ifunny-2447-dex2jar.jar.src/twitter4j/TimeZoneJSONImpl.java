package twitter4j;

public class TimeZoneJSONImpl
        implements TimeZone {
    private static final long serialVersionUID = 81958969762484144L;
    private final String NAME;
    private final String TZINFO_NAME;
    private final int UTC_OFFSET;

    TimeZoneJSONImpl(JSONObject paramJSONObject) {
        try {
            this.UTC_OFFSET = ParseUtil.getInt("utc_offset", paramJSONObject);
            this.NAME = paramJSONObject.getString("name");
            this.TZINFO_NAME = paramJSONObject.getString("tzinfo_name");
            return;
        } catch (JSONException paramJSONObject) {
            throw new TwitterException(paramJSONObject);
        }
    }

    public String getName() {
        return this.NAME;
    }

    public String tzinfoName() {
        return this.TZINFO_NAME;
    }

    public int utcOffset() {
        return this.UTC_OFFSET;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TimeZoneJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */