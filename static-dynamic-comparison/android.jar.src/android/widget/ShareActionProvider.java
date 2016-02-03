/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Intent;

/*    */
/*    */ public class ShareActionProvider extends android.view.ActionProvider {
    /*    */   public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /*    */
/*    */
    public ShareActionProvider(android.content.Context context) {
/*  9 */
        super((android.content.Context) null);
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.view.View onCreateActionView() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean hasSubMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onPrepareSubMenu(android.view.SubMenu subMenu) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setShareHistoryFileName(String shareHistoryFile) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setShareIntent(Intent shareIntent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnShareTargetSelectedListener
/*    */ {
        /*    */
        public abstract boolean onShareTargetSelected(ShareActionProvider paramShareActionProvider, Intent paramIntent);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/ShareActionProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */