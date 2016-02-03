package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$SetRunningTestCallable
        extends RestCallable<Void> {
    private Retrofit.RestInterface caller;
    private String info;
    private String runningTest;

    private IFunnyRestRequest$SetRunningTestCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.runningTest = paramString1;
        this.info = paramString2;
    }

    public RestResponse<Void> call() {
        return this.caller.setRunningTest(this.runningTest, this.info);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$SetRunningTestCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */