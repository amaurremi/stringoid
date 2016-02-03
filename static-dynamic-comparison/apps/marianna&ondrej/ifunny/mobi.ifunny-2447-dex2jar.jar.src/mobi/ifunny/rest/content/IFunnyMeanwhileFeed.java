package mobi.ifunny.rest.content;

import mobi.ifunny.rest.retrofit.IFunnyGsonConverter.OnCreatedByGsonListener;

public class IFunnyMeanwhileFeed
        extends IFunnyFeed
        implements IFunnyGsonConverter.OnCreatedByGsonListener {
    public void onCreatedByGson() {
        getPaging().hasNext = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunnyMeanwhileFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */