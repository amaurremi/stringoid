package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.User;

final class IFunnyRestRequest$Users$GetByNickCallable
        extends RestCallable<User> {
    private Retrofit.RestInterface caller;
    private String nick;

    private IFunnyRestRequest$Users$GetByNickCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.nick = paramString;
    }

    public RestResponse<User> call() {
        return this.caller.getByNick(this.nick);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$GetByNickCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */