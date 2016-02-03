package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.IFunnyFeed;

final class IFunnyRestRequest$Users$GetMySmilesCallable
        extends RestCallable<IFunnyFeed> {
    private final Retrofit.RestInterface caller;
    private final int limit;
    private final String next;
    private final String prev;

    public IFunnyRestRequest$Users$GetMySmilesCallable(Retrofit.RestInterface paramRestInterface, int paramInt, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.limit = paramInt;
        this.prev = paramString1;
        this.next = paramString2;
    }

    public RestResponse<IFunnyFeed> call() {
        return this.caller.getMySmiles(this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$GetMySmilesCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */