package mobi.ifunny.gallery;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import mobi.ifunny.a.c;
import mobi.ifunny.d;
import mobi.ifunny.fragment.n;
import mobi.ifunny.gallery.fragment.m;
import mobi.ifunny.popup.b;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.search.f;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public class GalleryActivity
        extends mobi.ifunny.l.a
        implements c, b {
    public static final String o = GalleryFragment.class.getSimpleName();
    public static final String p = n.class.getSimpleName();
    private static final String q = GalleryActivity.class.getSimpleName();
    private static IFunnyCache.ListEntry r;
    private static final RestHttpHandler<IFunny, GalleryActivity> w = new i();
    @InjectView(2131493254)
    View progressView;
    private m s = m.a;
    private TransitionDrawable t;
    private int u;
    private mobi.ifunny.a.a v;

    private void a(int paramInt, Bundle paramBundle, IFunnyCache.ListEntry paramListEntry) {
        Object localObject = null;
        switch (paramInt) {
        }
        while (localObject == null) {
            return;
            localObject = new a();
            continue;
            localObject = new an();
            continue;
            localObject = new aj();
            continue;
            localObject = new f();
            continue;
            localObject = new ai();
        }
        ((GalleryFragment) localObject).setArguments(paramBundle);
        if (paramListEntry != null) {
            ((GalleryFragment) localObject).a(paramListEntry);
        }
        paramBundle = f().a();
        paramBundle.b(2131493009, (Fragment) localObject, o);
        paramBundle.b();
    }

    private void a(IFunny paramIFunny) {
        Object localObject = (HashMap) getIntent().getExtras().getSerializable("ARG_OPTION_ARGS");
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("ARG_OPTION_ARGS", (Serializable) localObject);
        localObject = new IFunnyList();
        ((IFunnyList) localObject).items.add(paramIFunny);
        paramIFunny = new IFunnyCache.ListEntry();
        paramIFunny.a((IFunnyList) localObject);
        paramIFunny.a = 0;
        a(14, localBundle, paramIFunny);
    }

    public static void a(IFunnyCache.ListEntry paramListEntry) {
        r = paramListEntry;
    }

    private void p() {
        this.progressView.setVisibility(0);
    }

    private void q() {
        this.progressView.setVisibility(8);
    }

    public void a_(boolean paramBoolean) {
        this.v.b(paramBoolean);
    }

    public void b(boolean paramBoolean) {
        this.v.c(paramBoolean);
    }

    public void n() {
        this.t.startTransition(this.u);
    }

    public void o() {
        this.t.reverseTransition(this.u);
    }

    public void onBackPressed() {
        GalleryFragment localGalleryFragment = (GalleryFragment) f().a(o);
        if ((localGalleryFragment != null) && (localGalleryFragment.q())) {
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903114);
        ButterKnife.inject(this);
        this.t = ((TransitionDrawable) ((FrameLayout) findViewById(2131493008)).getForeground());
        this.u = getResources().getInteger(17694720);
        this.v = new mobi.ifunny.a.a();
        this.v.a(findViewById(2131492867));
        Object localObject1 = getIntent();
        Object localObject2 = ((Intent) localObject1).getExtras();
        localObject1 = ((Intent) localObject1).getData();
        int i;
        if (localObject1 == null) {
            if (paramBundle == null) {
                i = ((Bundle) localObject2).getInt("intent.gallery.type", 0);
                if ((i != 14) || (r != null)) {
                    break label158;
                }
                paramBundle = ((Bundle) localObject2).getString("intent.content.id");
                IFunnyRestRequest.Content.getContent(this, "rest.getContent" + paramBundle, paramBundle, w);
                r = null;
            }
        }
        for (; ; ) {
            return;
            label158:
            a(i, (Bundle) localObject2, r);
            break;
            String str;
            try {
                localObject2 = ((Uri) localObject1).getHost();
                str = ((Uri) localObject1).getQueryParameter("cid");
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("cid parameter is undefined");
                }
            } catch (Exception paramBundle) {
                d.c(q, "Can not parse data uri " + localObject1, paramBundle);
                Toast.makeText(this, getString(2131689608), 0).show();
                finish();
                return;
            }
            if (TextUtils.equals((CharSequence) localObject2, "content")) {
                this.s = m.a;
                IFunnyRestRequest.Content.getContent(this, "rest.getContent" + str, str, w);
            }
            while (paramBundle == null) {
                paramBundle = f().a();
                paramBundle.a(2131493009, new n(), p);
                paramBundle.b();
                return;
                if (!TextUtils.equals((CharSequence) localObject2, "comments")) {
                    break label387;
                }
                this.s = m.b;
                IFunnyRestRequest.Content.getContent(this, "rest.getContent" + str, str, w);
            }
        }
        label387:
        throw new IllegalArgumentException("Unknown host " + (String) localObject2);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.v.a();
    }

    protected void onPause() {
        super.onPause();
        this.v.b();
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        this.s = ((m) paramBundle.getSerializable("state.content.state"));
    }

    protected void onResume() {
        super.onResume();
        this.v.c();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("state.content.state", this.s);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/GalleryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */