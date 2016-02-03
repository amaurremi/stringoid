package mobi.ifunny.gallery;

import android.os.Bundle;
import android.support.v4.app.q;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Map;

import mobi.ifunny.e;
import mobi.ifunny.main.a.b;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Feeds;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.cache.IFunnyCache;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public class ak
        extends ah<IFunnyFeed> {
    private static final String b = ak.class.getSimpleName();

    protected int a(Bundle paramBundle) {
        return e.b.d.a;
    }

    protected j a(q paramq, Bundle paramBundle, Map<String, Bundle> paramMap) {
        return new j(paramq, e.b.d, paramMap);
    }

    protected void a(Bundle paramBundle, int paramInt) {
        e.b.d.a = paramInt;
    }

    protected void a(Bundle paramBundle, j paramj) {
        e.b.d = paramj.d();
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<IFunnyFeed, GalleryFragment> paramRestHttpHandler) {
        IFunnyRestRequest.Feeds.getPopular(this, p(), 20, paramString1, paramString2, paramRestHttpHandler);
    }

    protected String b() {
        return getString(2131689715);
    }

    protected boolean c() {
        return true;
    }

    public String d() {
        return "PopularFeed";
    }

    public String e() {
        return "feed_popular";
    }

    protected String f() {
        return "popu";
    }

    protected int h() {
        return 1;
    }

    public boolean i() {
        return true;
    }

    protected boolean j() {
        return true;
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenu.findItem(2131493393).setIcon(2130837880);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        a(b.a, true);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */