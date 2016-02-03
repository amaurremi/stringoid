package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.NickAvailability;

public class IFunnyRestRequest$Users$CheckNickCallable
        extends RestCallable<NickAvailability> {
    private final Retrofit.RestInterface caller;
    private final String nick;

    public IFunnyRestRequest$Users$CheckNickCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.nick = paramString;
    }

    public RestResponse<NickAvailability> call() {
        return this.caller.checkNick(this.nick);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$CheckNickCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */