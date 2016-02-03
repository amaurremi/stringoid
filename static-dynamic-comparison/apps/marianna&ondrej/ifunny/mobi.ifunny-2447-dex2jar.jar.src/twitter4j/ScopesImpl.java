package twitter4j;

public class ScopesImpl
        implements Scopes {
    private final String[] placeIds;

    ScopesImpl() {
        this.placeIds = new String[0];
    }

    public ScopesImpl(String[] paramArrayOfString) {
        this.placeIds = paramArrayOfString;
    }

    public String[] getPlaceIds() {
        return this.placeIds;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/ScopesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */