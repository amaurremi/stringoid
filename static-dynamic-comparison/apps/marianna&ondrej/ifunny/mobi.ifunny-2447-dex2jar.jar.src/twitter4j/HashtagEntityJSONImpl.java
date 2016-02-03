package twitter4j;

class HashtagEntityJSONImpl
        extends EntityIndex
        implements HashtagEntity, SymbolEntity {
    private static final long serialVersionUID = -5317828991902848906L;
    private String text;

    HashtagEntityJSONImpl() {
    }

    HashtagEntityJSONImpl(int paramInt1, int paramInt2, String paramString) {
        setStart(paramInt1);
        setEnd(paramInt2);
        this.text = paramString;
    }

    HashtagEntityJSONImpl(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    private void init(JSONObject paramJSONObject) {
        try {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("indices");
            setStart(localJSONArray.getInt(0));
            setEnd(localJSONArray.getInt(1));
            if (!paramJSONObject.isNull("text")) {
                this.text = paramJSONObject.getString("text");
            }
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
            paramObject = (HashtagEntityJSONImpl) paramObject;
            if (this.text == null) {
                break;
            }
        } while (this.text.equals(((HashtagEntityJSONImpl) paramObject).text));
        for (; ; ) {
            return false;
            if (((HashtagEntityJSONImpl) paramObject).text == null) {
                break;
            }
        }
    }

    public int getEnd() {
        return super.getEnd();
    }

    public int getStart() {
        return super.getStart();
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        if (this.text != null) {
            return this.text.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "HashtagEntityJSONImpl{text='" + this.text + '\'' + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/HashtagEntityJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */