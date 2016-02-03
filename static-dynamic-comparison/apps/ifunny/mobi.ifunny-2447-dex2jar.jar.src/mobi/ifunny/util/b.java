package mobi.ifunny.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

public class b {
    public static void a(ImageView paramImageView) {
        a(paramImageView, paramImageView.getResources().getInteger(17694720));
    }

    public static void a(ImageView paramImageView, int paramInt) {
        paramImageView.setAlpha(0.1F);
        paramImageView.animate().setDuration(paramInt).alpha(1.0F);
    }

    public static void a(ImageView paramImageView, Drawable paramDrawable) {
        a(paramImageView, paramDrawable, paramImageView.getResources().getInteger(17694720));
    }

    public static void a(ImageView paramImageView, Drawable paramDrawable, int paramInt) {
        paramImageView.setImageDrawable(paramDrawable);
        a(paramImageView, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */