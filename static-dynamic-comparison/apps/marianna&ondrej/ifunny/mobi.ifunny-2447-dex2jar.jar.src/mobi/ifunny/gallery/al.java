package mobi.ifunny.gallery;

import android.os.Bundle;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

import mobi.ifunny.e;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunny.Source;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Timelines;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.util.cache.IFunnyCache;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public class al
        extends ah<IFunnyFeed> {
    private static final String b = al.class.getSimpleName();

    protected int a(Bundle paramBundle) {
        return e.b.c.a;
    }

    protected j a(q paramq, Bundle paramBundle, Map<String, Bundle> paramMap) {
        return new j(paramq, e.b.c, paramMap);
    }

    protected void a(Bundle paramBundle, int paramInt) {
        e.b.c.a = paramInt;
    }

    protected void a(Bundle paramBundle, j paramj) {
        e.b.c = paramj.d();
    }

    protected void a(View paramView) {
        ((TextView) paramView.findViewById(2131493094)).setText(2131689654);
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<IFunnyFeed, GalleryFragment> paramRestHttpHandler) {
        if (!l.a().h()) {
            paramRestHttpHandler.onSuccessCallback(this, new IFunnyFeed());
            return;
        }
        IFunnyRestRequest.Timelines.getSubscriptions(this, p(), 20, paramString1, paramString2, paramRestHttpHandler);
    }

    protected boolean a(IFunny paramIFunny1, IFunny paramIFunny2) {
        if (super.a(paramIFunny1, paramIFunny2)) {
        }
        while ((paramIFunny1.hasSource()) && ((TextUtils.equals(paramIFunny1.source.id, paramIFunny2.id)) || ((paramIFunny2.hasSource()) && (TextUtils.equals(paramIFunny1.source.id, paramIFunny2.source.id))))) {
            return true;
        }
        return false;
    }

    protected String b() {
        return getString(2131689716);
    }

    protected boolean c() {
        return true;
    }

    public String d() {
        return "SubscriptionsFeed";
    }

    public String e() {
        return "feed_subscriptions";
    }

    protected String f() {
        return "subs";
    }

    protected int h() {
        return 1;
    }

    protected boolean m() {
        return true;
    }

    protected void r() {
        if (o().getCount() == 0) {
            a(t.c);
            return;
        }
        super.r();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */