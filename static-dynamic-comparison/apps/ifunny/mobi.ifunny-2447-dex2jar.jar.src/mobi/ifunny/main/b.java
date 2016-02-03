package mobi.ifunny.main;

import mobi.ifunny.rest.retrofit.RestNotification.Counters;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class b
        extends SimpleRestHttpHandler<RestNotification.Counters, IFunnyMenuActivity> {
    public void a(IFunnyMenuActivity paramIFunnyMenuActivity, RestNotification.Counters paramCounters) {
        paramIFunnyMenuActivity.b(paramCounters);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */