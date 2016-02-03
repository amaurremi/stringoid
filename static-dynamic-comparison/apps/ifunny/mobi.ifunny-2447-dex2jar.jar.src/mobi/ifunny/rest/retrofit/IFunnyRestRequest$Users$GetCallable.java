package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.User;

final class IFunnyRestRequest$Users$GetCallable
        extends RestCallable<User> {
    private final Retrofit.RestInterface caller;
    private final String id;

    private IFunnyRestRequest$Users$GetCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.id = paramString;
    }

    public RestResponse<User> call() {
        return this.caller.getUser(this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$GetCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */