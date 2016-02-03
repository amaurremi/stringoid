/*    */
package android.view;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public class ContextThemeWrapper extends android.content.ContextWrapper {
    public ContextThemeWrapper() {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ContextThemeWrapper(Context base, int themeres) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected void attachBaseContext(Context newBase) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setTheme(int resid) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public android.content.res.Resources.Theme getTheme() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Object getSystemService(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void onApplyThemeResource(android.content.res.Resources.Theme theme, int resid, boolean first) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/ContextThemeWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */