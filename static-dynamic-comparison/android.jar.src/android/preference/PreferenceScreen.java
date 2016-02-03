/*    */
package android.preference;
/*    */ 
/*    */

import android.os.Parcelable;

/*    */
/*    */ public final class PreferenceScreen extends PreferenceGroup implements android.widget.AdapterView.OnItemClickListener, android.content.DialogInterface.OnDismissListener {
    /*  6 */   PreferenceScreen() {
        super((android.content.Context) null, (android.util.AttributeSet) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public android.widget.ListAdapter getRootAdapter() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected android.widget.ListAdapter onCreateRootAdapter() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void bind(android.widget.ListView listView) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected void onClick() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onDismiss(android.content.DialogInterface dialog) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public android.app.Dialog getDialog() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onItemClick(android.widget.AdapterView parent, android.view.View view, int position, long id) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    protected boolean isOnSameScreenAsChildren() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void onRestoreInstanceState(Parcelable state) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/PreferenceScreen.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */