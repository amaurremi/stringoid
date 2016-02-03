package mobi.ifunny.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.mopub.mobileads.MoPubView;
import mobi.ifunny.d;

public class a
        extends b {
    private static final String a = a.class.getSimpleName();
    private MoPubView b;

    private String d(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 2131689727; ; i = 2131689729) {
            return this.b.getContext().getString(i);
        }
    }

    public void a() {
        this.b.destroy();
        super.a();
    }

    public void a(View paramView) {
        super.a(paramView);
        this.b = ((MoPubView) paramView.findViewById(2131492869));
        if (this.b == null) {
            throw new IllegalStateException();
        }
        mobi.ifunny.f.b localb = mobi.ifunny.f.a.a(paramView.getContext());
        d.c(a, "Detected ad size in dp " + localb.a() + "x" + localb.b());
        int i = (int) TypedValue.applyDimension(1, localb.b(), paramView.getContext().getResources().getDisplayMetrics());
        paramView = this.b.getLayoutParams();
        paramView.height = i;
        this.b.setLayoutParams(paramView);
        this.b.setAdUnitId(d(true));
        this.b.loadAd();
    }

    protected void a(boolean paramBoolean) {
    }

    public void b() {
        this.b.pause();
        super.b();
    }

    public void b(boolean paramBoolean) {
        this.b.setAdUnitId(d(paramBoolean));
    }

    public void c() {
        this.b.resume();
        super.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */