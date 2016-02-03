package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class DrawableCompat {
    static final DrawableImpl IMPL = new BaseDrawableImpl();

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            IMPL = new KitKatDrawableImpl();
            return;
        }
        if (i >= 11) {
            IMPL = new HoneycombDrawableImpl();
            return;
        }
    }

    public static boolean isAutoMirrored(Drawable paramDrawable) {
        return IMPL.isAutoMirrored(paramDrawable);
    }

    public static void jumpToCurrentState(Drawable paramDrawable) {
        IMPL.jumpToCurrentState(paramDrawable);
    }

    public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {
        IMPL.setAutoMirrored(paramDrawable, paramBoolean);
    }

    static class BaseDrawableImpl
            implements DrawableCompat.DrawableImpl {
        public boolean isAutoMirrored(Drawable paramDrawable) {
            return false;
        }

        public void jumpToCurrentState(Drawable paramDrawable) {
        }

        public void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {
        }
    }

    static abstract interface DrawableImpl {
        public abstract boolean isAutoMirrored(Drawable paramDrawable);

        public abstract void jumpToCurrentState(Drawable paramDrawable);

        public abstract void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean);
    }

    static class HoneycombDrawableImpl
            extends DrawableCompat.BaseDrawableImpl {
        public void jumpToCurrentState(Drawable paramDrawable) {
            DrawableCompatHoneycomb.jumpToCurrentState(paramDrawable);
        }
    }

    static class KitKatDrawableImpl
            extends DrawableCompat.HoneycombDrawableImpl {
        public boolean isAutoMirrored(Drawable paramDrawable) {
            return DrawableCompatKitKat.isAutoMirrored(paramDrawable);
        }

        public void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {
            DrawableCompatKitKat.setAutoMirrored(paramDrawable, paramBoolean);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/graphics/drawable/DrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */