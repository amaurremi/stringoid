package mobi.ifunny.k;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class z<T extends Drawable, D, V extends y<D>>
        extends f<T, D> {
    public V b;

    public z(ImageView paramImageView, View paramView, String paramString1, String paramString2, V paramV) {
        super(paramImageView, paramView, paramString1, paramString2, paramV.e);
        this.b = paramV;
    }

    public z(ImageView paramImageView, View paramView, String paramString, V paramV) {
        this(paramImageView, paramView, paramString, null, paramV);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */