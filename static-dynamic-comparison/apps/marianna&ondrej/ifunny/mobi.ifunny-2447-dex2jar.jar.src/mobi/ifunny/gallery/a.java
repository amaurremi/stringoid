package mobi.ifunny.gallery;

import android.os.Bundle;
import android.support.v4.app.q;

import java.util.Map;

import mobi.ifunny.e;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Feeds;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.cache.IFunnyCache;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public class a
        extends ah<IFunnyFeed> {
    private static final String b = a.class.getSimpleName();

    protected int a(Bundle paramBundle) {
        return e.b.b.a;
    }

    protected j a(q paramq, Bundle paramBundle, Map<String, Bundle> paramMap) {
        return new j(paramq, e.b.b, paramMap);
    }

    protected void a(Bundle paramBundle, int paramInt) {
        e.b.b.a = paramInt;
    }

    protected void a(Bundle paramBundle, j paramj) {
        e.b.b = paramj.d();
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<IFunnyFeed, GalleryFragment> paramRestHttpHandler) {
        IFunnyRestRequest.Feeds.getCollective(this, p(), 20, paramString1, paramString2, paramRestHttpHandler);
    }

    protected String b() {
        return getString(2131689713);
    }

    protected boolean c() {
        return true;
    }

    public String d() {
        return "CollectiveFeed";
    }

    public String e() {
        return "feed_collective";
    }

    protected String f() {
        return "coll";
    }

    public boolean g() {
        return true;
    }

    protected int h() {
        return 1;
    }

    public boolean i() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */