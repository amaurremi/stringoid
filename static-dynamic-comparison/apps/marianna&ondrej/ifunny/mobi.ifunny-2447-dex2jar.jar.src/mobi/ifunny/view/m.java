package mobi.ifunny.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class m
        implements Drawable.Callback {
    private m(ImageViewEx paramImageViewEx) {
    }

    public void invalidateDrawable(Drawable paramDrawable) {
        this.a.invalidate();
    }

    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
        this.a.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
    }

    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
        this.a.unscheduleDrawable(paramDrawable, paramRunnable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */