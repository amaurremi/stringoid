package mobi.ifunny.main;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.ifunny.b.c;
import mobi.ifunny.b.g;
import mobi.ifunny.rest.Features.RateTexts;

class d
        implements View.OnClickListener {
    private final com.a.a.a a;
    private final IFunnyMenuActivity b;
    private final Features.RateTexts c;

    d(com.a.a.a parama, IFunnyMenuActivity paramIFunnyMenuActivity, Features.RateTexts paramRateTexts) {
        this.a = parama;
        this.b = paramIFunnyMenuActivity;
        this.c = paramRateTexts;
    }

    public void onClick(View paramView) {
        this.a.c();
        switch (paramView.getId()) {
            default:
                return;
            case 2131493278:
                mobi.ifunny.j.a.a(this.c.title, this.c.message, this.c.ok, this.c.never, this.c.later).a(this.b.f(), IFunnyMenuActivity.r());
                g.a(this.b, "rate_app", "alert_show");
                c.a(this.b, "rate_app", "alert_show");
                return;
        }
        IFunnyMenuActivity.a(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */