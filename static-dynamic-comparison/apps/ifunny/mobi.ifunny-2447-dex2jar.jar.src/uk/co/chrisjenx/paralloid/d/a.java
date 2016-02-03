package uk.co.chrisjenx.paralloid.d;

import android.view.View;
import uk.co.chrisjenx.paralloid.c.c;

public final class a {
    public static void a(View paramView, int paramInt1, int paramInt2, c paramc, float paramFloat) {
        if ((paramView == null) || (paramc == null)) {
            return;
        }
        paramc = paramc.a(paramInt1, paramInt2, paramFloat);
        paramView.scrollTo(paramc[0], paramc[1]);
    }

    public static void a(uk.co.chrisjenx.paralloid.a.a parama, int paramInt1, int paramInt2) {
        if (parama == null) {
            return;
        }
        parama.a(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/chrisjenx/paralloid/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */