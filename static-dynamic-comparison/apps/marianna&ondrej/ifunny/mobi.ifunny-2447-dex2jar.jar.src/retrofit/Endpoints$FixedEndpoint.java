package retrofit;

class Endpoints$FixedEndpoint
        implements Endpoint {
    private final String apiUrl;
    private final String name;

    Endpoints$FixedEndpoint(String paramString1, String paramString2) {
        this.apiUrl = paramString1;
        this.name = paramString2;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.apiUrl;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Endpoints$FixedEndpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */