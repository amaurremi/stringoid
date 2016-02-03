package mobi.ifunny.k;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import mobi.ifunny.util.a.a;

public class l<V extends Drawable> {
    private r<V> a;
    private Animator b;
    private ImageView c;
    private View d;

    public l(ImageView paramImageView, View paramView, String paramString1, String paramString2) {
        this(paramImageView, paramView, new a(paramString1), paramString2);
    }

    public l(ImageView paramImageView, View paramView, a parama, String paramString) {
        this.a = new r(parama, paramString);
        this.c = paramImageView;
        this.d = paramView;
    }

    public ImageView a() {
        return this.c;
    }

    public void a(Animator paramAnimator) {
        this.b = paramAnimator;
    }

    public View b() {
        return this.d;
    }

    public r<V> c() {
        return this.a;
    }

    public Animator d() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */