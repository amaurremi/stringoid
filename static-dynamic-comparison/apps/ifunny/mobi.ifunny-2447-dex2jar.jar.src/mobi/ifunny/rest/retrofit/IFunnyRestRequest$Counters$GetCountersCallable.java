package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Counters$GetCountersCallable
        extends RestCallable<RestNotification.Counters> {
    private final Retrofit.RestInterface caller;

    public IFunnyRestRequest$Counters$GetCountersCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<RestNotification.Counters> call() {
        return this.caller.getCounters();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Counters$GetCountersCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */