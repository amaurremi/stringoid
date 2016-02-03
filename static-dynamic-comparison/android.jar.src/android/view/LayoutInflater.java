/*    */
package android.view;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import org.xmlpull.v1.XmlPullParser;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class LayoutInflater
/*    */ {
    /* 18 */
    protected LayoutInflater(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected LayoutInflater(LayoutInflater original, Context newContext) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static LayoutInflater from(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract LayoutInflater cloneInContext(Context paramContext);

    /* 22 */
    public Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final Factory getFactory() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final Factory2 getFactory2() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setFactory(Factory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setFactory2(Factory2 factory) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public Filter getFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setFilter(Filter filter) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public View inflate(int resource, ViewGroup root) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public View inflate(XmlPullParser parser, ViewGroup root) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public final View createView(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    protected View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    protected View onCreateView(View parent, String name, AttributeSet attrs) throws ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface Factory2
/*    */ extends LayoutInflater.Factory
/*    */ {
        /*    */
        public abstract View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet);
/*    */
    }

    /*    */
/*    */   public static abstract interface Factory
/*    */ {
        /*    */
        public abstract View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet);
/*    */
    }

    /*    */
/*    */   public static abstract interface Filter
/*    */ {
        /*    */
        public abstract boolean onLoadClass(Class paramClass);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/LayoutInflater.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */