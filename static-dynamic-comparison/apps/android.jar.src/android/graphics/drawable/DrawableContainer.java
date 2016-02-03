/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.graphics.Rect;

/*    */
/*    */ public class DrawableContainer extends Drawable
/*    */ implements Drawable.Callback
/*    */ {
    /*    */   public static abstract class DrawableContainerState extends Drawable.ConstantState {
        /*  9 */     DrawableContainerState() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public int getChangingConfigurations() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public final int addChild(Drawable dr) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public final int getChildCount() {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public final Drawable[] getChildren() {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public final void setVariablePadding(boolean variable) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public final Rect getConstantPadding() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public final void setConstantSize(boolean constant) {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public final boolean isConstantSize() {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public final int getConstantWidth() {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public final int getConstantHeight() {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public final int getConstantMinimumWidth() {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public final int getConstantMinimumHeight() {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        protected void computeConstantSize() {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public final void setEnterFadeDuration(int duration) {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public final int getEnterFadeDuration() {
            throw new RuntimeException("Stub!");
        }

        /* 25 */
        public final void setExitFadeDuration(int duration) {
            throw new RuntimeException("Stub!");
        }

        /* 26 */
        public final int getExitFadeDuration() {
            throw new RuntimeException("Stub!");
        }

        /* 27 */
        public final int getOpacity() {
            throw new RuntimeException("Stub!");
        }

        /* 28 */
        public final boolean isStateful() {
            throw new RuntimeException("Stub!");
        }

        /* 29 */
        public void growArray(int oldSize, int newSize) {
            throw new RuntimeException("Stub!");
        }

        /* 30 */
        public synchronized boolean canConstantState() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 32 */
    public DrawableContainer() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean getPadding(Rect padding) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setDither(boolean dither) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setColorFilter(android.graphics.ColorFilter cf) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setEnterFadeDuration(int ms) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setExitFadeDuration(int ms) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    protected void onBoundsChange(Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean isStateful() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void jumpToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    protected boolean onStateChange(int[] state) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    protected boolean onLevelChange(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public int getIntrinsicWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public int getIntrinsicHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public int getMinimumWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public int getMinimumHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void invalidateDrawable(Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void unscheduleDrawable(Drawable who, Runnable what) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public boolean setVisible(boolean visible, boolean restart) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public int getOpacity() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public boolean selectDrawable(int idx) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public Drawable getCurrent() {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public Drawable.ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    protected void setConstantState(DrawableContainerState state) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/DrawableContainer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */