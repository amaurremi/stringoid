package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Account$PutCallable
        extends RestCallable<Void> {
    private final String about;
    private final Retrofit.RestInterface caller;
    private final String nick;

    private IFunnyRestRequest$Account$PutCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.nick = paramString1;
        this.about = paramString2;
    }

    public RestResponse<Void> call() {
        return this.caller.putAccount(this.nick, this.about);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$PutCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */