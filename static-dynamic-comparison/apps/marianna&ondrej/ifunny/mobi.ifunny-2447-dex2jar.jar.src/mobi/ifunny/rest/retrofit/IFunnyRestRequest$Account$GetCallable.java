package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.User;

final class IFunnyRestRequest$Account$GetCallable
        extends RestCallable<User> {
    private final Retrofit.RestInterface caller;

    private IFunnyRestRequest$Account$GetCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<User> call() {
        return this.caller.getAccount();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$GetCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */