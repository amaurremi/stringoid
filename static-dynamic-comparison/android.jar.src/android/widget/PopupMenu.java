/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.view.Menu;
/*    */ import android.view.MenuItem;
/*    */ import android.view.View;

/*    */
/*    */ 
/*    */ 
/*    */ public class PopupMenu
/*    */ {
    /* 12 */
    public PopupMenu(Context context, View anchor) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Menu getMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.view.MenuInflater getMenuInflater() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void inflate(int menuRes) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void show() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void dismiss() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setOnDismissListener(OnDismissListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnMenuItemClickListener
/*    */ {
        /*    */
        public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnDismissListener
/*    */ {
        /*    */
        public abstract void onDismiss(PopupMenu paramPopupMenu);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/PopupMenu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */