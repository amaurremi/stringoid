/*    */
package android.text.method;
/*    */ 
/*    */

import android.text.Spannable;

/*    */
/*  5 */ public class BaseMovementMethod implements MovementMethod {
    public BaseMovementMethod() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public boolean canSelectArbitrarily() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void initialize(android.widget.TextView widget, Spannable text) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean onKeyDown(android.widget.TextView widget, Spannable text, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean onKeyOther(android.widget.TextView widget, Spannable text, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean onKeyUp(android.widget.TextView widget, Spannable text, int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onTakeFocus(android.widget.TextView widget, Spannable text, int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean onTouchEvent(android.widget.TextView widget, Spannable text, android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean onTrackballEvent(android.widget.TextView widget, Spannable text, android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean onGenericMotionEvent(android.widget.TextView widget, Spannable text, android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected int getMovementMetaState(Spannable buffer, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected boolean handleMovementKey(android.widget.TextView widget, Spannable buffer, int keyCode, int movementMetaState, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected boolean left(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected boolean right(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected boolean up(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected boolean down(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected boolean pageUp(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected boolean pageDown(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected boolean top(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected boolean bottom(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected boolean lineStart(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    protected boolean lineEnd(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    protected boolean home(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    protected boolean end(android.widget.TextView widget, Spannable buffer) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/method/BaseMovementMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */