package mobi.ifunny.gallery.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.view.View;
import mobi.ifunny.gallery.am;
import mobi.ifunny.k.f;
import mobi.ifunny.util.r;

public class i<V extends Drawable, D extends am, Req extends f<V, D>>
        extends mobi.ifunny.k.i<V, Req> {
    public i(Context paramContext) {
        super(paramContext);
        a(d() / 2);
    }

    protected Drawable a(Resources paramResources) {
        return paramResources.getDrawable(2130837940);
    }

    protected Drawable a(Resources paramResources, int paramInt) {
        return new ColorDrawable(paramInt);
    }

    public void a(Req paramReq, V paramV) {
    }

    public void a(Req paramReq, boolean paramBoolean) {
        Object localObject = (am) paramReq.a;
        View localView = paramReq.b();
        paramReq = localView.getResources();
        if (paramBoolean) {
            localView.setVisibility(0);
            int i = r.c(((am) localObject).getThumbPlaceholderColor());
            if (i == 0) {
                localObject = localView.getBackground();
                if ((localObject != null) && ((localObject instanceof LevelListDrawable))) {
                    paramReq = (Req) localObject;
                    if (((Drawable) localObject).getLevel() != 0) {
                        ((Drawable) localObject).setVisible(true, true);
                    }
                } else {
                    paramReq = a(paramReq);
                }
                paramReq.setLevel(r.b(1, 6));
                localView.setBackgroundDrawable(paramReq);
                return;
            }
            localView.setBackgroundDrawable(a(paramReq, i));
            return;
        }
        localView.setVisibility(4);
    }

    protected boolean b() {
        return true;
    }

    protected boolean c() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */