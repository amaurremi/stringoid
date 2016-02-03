package mobi.ifunny.main;

import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import mobi.ifunny.a.c;

public abstract class h
        extends mobi.ifunny.l.a
        implements c, mobi.ifunny.popup.b {
    private static final String o = h.class.getSimpleName();
    private TransitionDrawable p;
    private int q;
    private mobi.ifunny.a.b r;

    public void a_(boolean paramBoolean) {
        this.r.b(paramBoolean);
    }

    public void b(boolean paramBoolean) {
        this.r.c(paramBoolean);
    }

    public void n() {
        this.p.startTransition(this.q);
    }

    public void o() {
        this.p.reverseTransition(this.q);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903134);
        this.p = ((TransitionDrawable) ((FrameLayout) ButterKnife.findById(this, 2131493008)).getForeground());
        this.q = getResources().getInteger(17694720);
        this.r = new mobi.ifunny.a.a();
        this.r.a(findViewById(2131492867));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.p = null;
        this.r.a();
    }

    protected void onPause() {
        super.onPause();
        this.r.b();
    }

    protected void onResume() {
        super.onResume();
        this.r.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */