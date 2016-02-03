/*   */
package android.view;
/*   */

import android.graphics.Canvas;

/*   */
/*   */ public abstract interface SurfaceHolder {
    public static abstract interface Callback2 extends SurfaceHolder.Callback {
        public abstract void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder);
    }

    /*   */   public static abstract interface Callback {
        public abstract void surfaceCreated(SurfaceHolder paramSurfaceHolder);

        /*   */
        public abstract void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3);

        /* 7 */
        public abstract void surfaceDestroyed(SurfaceHolder paramSurfaceHolder);
    }

    public static class BadSurfaceTypeException extends RuntimeException {
        public BadSurfaceTypeException() {
            throw new RuntimeException("Stub!");
        }

        /* 8 */
        public BadSurfaceTypeException(String name) {
            throw new RuntimeException("Stub!");
        }
/*   */
    }

    /*   */
/*   */
    @Deprecated
/*   */ public static final int SURFACE_TYPE_NORMAL = 0;
    /*   */
    @Deprecated
/*   */ public static final int SURFACE_TYPE_HARDWARE = 1;
    /*   */
    @Deprecated
/*   */ public static final int SURFACE_TYPE_GPU = 2;
    /*   */
    @Deprecated
/*   */ public static final int SURFACE_TYPE_PUSH_BUFFERS = 3;

    /*   */
    public abstract void addCallback(Callback paramCallback);

    /*   */
/*   */
    public abstract void removeCallback(Callback paramCallback);

    /*   */
/*   */
    public abstract boolean isCreating();

    /*   */
/*   */
    @Deprecated
/*   */ public abstract void setType(int paramInt);

    /*   */
/*   */
    public abstract void setFixedSize(int paramInt1, int paramInt2);

    /*   */
/*   */
    public abstract void setSizeFromLayout();

    /*   */
/*   */
    public abstract void setFormat(int paramInt);

    /*   */
/*   */
    public abstract void setKeepScreenOn(boolean paramBoolean);

    /*   */
/*   */
    public abstract Canvas lockCanvas();

    /*   */
/*   */
    public abstract Canvas lockCanvas(android.graphics.Rect paramRect);

    /*   */
/*   */
    public abstract void unlockCanvasAndPost(Canvas paramCanvas);

    /*   */
/*   */
    public abstract android.graphics.Rect getSurfaceFrame();

    /*   */
/*   */
    public abstract Surface getSurface();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/SurfaceHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */