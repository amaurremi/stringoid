package mobi.ifunny.gallery;

import android.os.Bundle;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;
import java.util.Map;

import mobi.ifunny.d;
import mobi.ifunny.e;
import mobi.ifunny.h;
import mobi.ifunny.main.a.b;
import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Feeds;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.cache.IFunnyCache;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public class f
        extends ah<IFunnyFeed> {
    private static final String b = f.class.getSimpleName();

    protected int a(Bundle paramBundle) {
        return e.b.a.a;
    }

    protected j a(q paramq, Bundle paramBundle, Map<String, Bundle> paramMap) {
        return new j(paramq, e.b.a, paramMap);
    }

    protected void a(int paramInt, IFunnyFeed paramIFunnyFeed) {
        int k = 0;
        List localList = paramIFunnyFeed.getList();
        h localh = h.a();
        Object localObject = localh.a("pref.first.featured", null);
        String str1 = localh.a("pref.prev.first.featured", null);
        d.c(b, "Prefs firstId " + (String) localObject + " prevFirstId " + str1);
        if (paramInt == 0) {
            String str2 = ((IFunny) localList.get(0)).id;
            if (!TextUtils.equals((CharSequence) localObject, str2)) {
                localh.b("pref.prev.first.featured", (String) localObject);
                localh.b("pref.first.featured", str2);
                d.c(b, "New featured firstId " + str2 + " prevFirstId " + (String) localObject);
            }
        }
        for (; ; ) {
            int i;
            if ((Features.isMeanwhileTurnedOn()) && (!TextUtils.isEmpty((CharSequence) localObject))) {
                i = 0;
            }
            for (; ; ) {
                int j = k;
                if (i < localList.size()) {
                    if (TextUtils.equals((CharSequence) localObject, ((IFunny) localList.get(i)).id)) {
                        d.c(b, "finded prevFirstId at position " + i);
                        j = 1;
                    }
                } else {
                    if (j != 0) {
                        localObject = new IFunny();
                        ((IFunny) localObject).type = "_meanwhile";
                        localList.add(i, localObject);
                    }
                    super.a(paramInt, paramIFunnyFeed);
                    return;
                }
                i += 1;
            }
            localObject = str1;
        }
    }

    protected void a(Bundle paramBundle, int paramInt) {
        e.b.a.a = paramInt;
    }

    protected void a(Bundle paramBundle, j paramj) {
        e.b.a = paramj.d();
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<IFunnyFeed, GalleryFragment> paramRestHttpHandler) {
        IFunnyRestRequest.Feeds.getFeatured(this, p(), 20, paramString1, paramString2, paramRestHttpHandler);
    }

    protected String b() {
        return getString(2131689715);
    }

    protected boolean c() {
        return true;
    }

    public String d() {
        return "FeaturedFeed";
    }

    public String e() {
        return "feed_featured";
    }

    protected String f() {
        return "feat";
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

    protected boolean k() {
        return false;
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenu.findItem(2131493393).setIcon(2130837879);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        a(b.b);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */