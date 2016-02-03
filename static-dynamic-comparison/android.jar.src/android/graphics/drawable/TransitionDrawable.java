/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import android.graphics.Canvas;

/*    */
/*    */ public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {
    /*  6 */
    public TransitionDrawable(Drawable[] layers) {
        super((Drawable[]) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void startTransition(int durationMillis) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void resetTransition() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void reverseTransition(int duration) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void draw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setCrossFadeEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean isCrossFadeEnabled() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/TransitionDrawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */