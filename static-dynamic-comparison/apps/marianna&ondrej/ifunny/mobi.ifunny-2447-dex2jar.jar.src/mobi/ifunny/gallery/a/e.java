package mobi.ifunny.gallery.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

import java.util.Arrays;

import mobi.ifunny.gallery.am;
import mobi.ifunny.k.f;

public class e<V extends Drawable, D extends am, Req extends f<V, D>>
        extends i<V, D, Req> {
    public e(Context paramContext) {
        super(paramContext);
    }

    protected Drawable a(Resources paramResources) {
        return paramResources.getDrawable(2130837864);
    }

    protected Drawable a(Resources paramResources, int paramInt) {
        float f = paramResources.getDimensionPixelSize(2131427482);
        paramResources = new float[8];
        Arrays.fill(paramResources, f);
        paramResources = new ShapeDrawable(new RoundRectShape(paramResources, null, null));
        paramResources.getPaint().setColor(paramInt);
        return paramResources;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */