package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Stats$CollectStatsCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface collectStats;
    private final String data;

    public IFunnyRestRequest$Stats$CollectStatsCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.collectStats = paramRestInterface;
        this.data = paramString;
    }

    public RestResponse<Void> call() {
        return this.collectStats.collectStats(this.data);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Stats$CollectStatsCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */