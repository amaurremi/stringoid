/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public abstract class ResourceCursorAdapter extends CursorAdapter {
    @Deprecated
/*  6 */ public ResourceCursorAdapter(Context context, int layout, android.database.Cursor c) {
        super((Context) null, (android.database.Cursor) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ResourceCursorAdapter(Context context, int layout, android.database.Cursor c, boolean autoRequery) {
        super((Context) null, (android.database.Cursor) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public ResourceCursorAdapter(Context context, int layout, android.database.Cursor c, int flags) {
        super((Context) null, (android.database.Cursor) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public android.view.View newView(Context context, android.database.Cursor cursor, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public android.view.View newDropDownView(Context context, android.database.Cursor cursor, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setViewResource(int layout) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setDropDownViewResource(int dropDownLayout) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ResourceCursorAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */