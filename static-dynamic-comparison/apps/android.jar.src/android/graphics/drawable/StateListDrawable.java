/*    */
package android.graphics.drawable;
/*    */ 
/*    */

import org.xmlpull.v1.XmlPullParser;

/*    */
/*  5 */ public class StateListDrawable extends DrawableContainer {
    public StateListDrawable() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void addState(int[] stateSet, Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public boolean isStateful() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected boolean onStateChange(int[] stateSet) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void inflate(android.content.res.Resources r, XmlPullParser parser, android.util.AttributeSet attrs) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/drawable/StateListDrawable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */