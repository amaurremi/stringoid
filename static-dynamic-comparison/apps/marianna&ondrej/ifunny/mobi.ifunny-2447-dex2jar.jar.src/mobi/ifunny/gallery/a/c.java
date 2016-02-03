package mobi.ifunny.gallery.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import mobi.ifunny.k.z;
import mobi.ifunny.rest.content.IFunny;

public class c<V extends Drawable>
        extends i<V, IFunny, z<V, IFunny, d>> {
    public c(Context paramContext) {
        super(paramContext);
    }

    protected void a(z<V, IFunny, d> paramz, V paramV) {
        super.b(paramz, paramV);
        paramV = (IFunny) paramz.a;
        if (!paramV.isAbused()) {
            if (paramV.isVideoContent()) {
                ((d) paramz.b).a.setVisibility(0);
            }
            if (paramV.isGifContent()) {
                ((d) paramz.b).b.setVisibility(0);
            }
            if ((!paramV.hasSource()) && (paramV.isFeatured())) {
                ((d) paramz.b).c.setVisibility(0);
            }
            if (paramV.hasSource()) {
                ((d) paramz.b).d.setVisibility(0);
            }
        }
    }

    public void b(z<V, IFunny, d> paramz, V paramV) {
        super.a(paramz, paramV);
        ((d) paramz.b).a.setVisibility(4);
        ((d) paramz.b).b.setVisibility(4);
        ((d) paramz.b).c.setVisibility(4);
        ((d) paramz.b).d.setVisibility(4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */