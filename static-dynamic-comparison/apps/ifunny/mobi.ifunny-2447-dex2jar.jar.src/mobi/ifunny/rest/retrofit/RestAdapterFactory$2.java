package mobi.ifunny.rest.retrofit;

final class RestAdapterFactory$2
        implements BaseRestAdapter.RestAuthenticator {
    RestAdapterFactory$2(Authenticator paramAuthenticator) {
    }

    public String getAuthString() {
        return this.val$authenticator.getBasicAuthenticator();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/RestAdapterFactory$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */