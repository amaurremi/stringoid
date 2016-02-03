package mobi.ifunny.k;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class f<V extends Drawable, D>
        extends l<V> {
    public D a;

    public f(ImageView paramImageView, View paramView, String paramString, D paramD) {
        this(paramImageView, paramView, paramString, null, paramD);
    }

    public f(ImageView paramImageView, View paramView, String paramString1, String paramString2, D paramD) {
        super(paramImageView, paramView, paramString1, paramString2);
        this.a = paramD;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */