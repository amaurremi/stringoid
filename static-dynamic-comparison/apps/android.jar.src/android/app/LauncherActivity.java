/*    */
package android.app;
/*    */ 
/*    */

import android.graphics.drawable.Drawable;

/*    */
/*    */ public abstract class LauncherActivity extends ListActivity {
    public static class ListItem {
        public android.content.pm.ResolveInfo resolveInfo;

        /*    */
/*  7 */
        public ListItem() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public CharSequence label;
        /*    */     public Drawable icon;
        /*    */     public String packageName;
        /*    */     public String className;
        /*    */     public android.os.Bundle extras;
/*    */
    }

    /*    */
/*    */   public class IconResizer {
        /* 17 */
        public IconResizer() {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public Drawable createIconThumbnail(Drawable icon) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 20 */
    public LauncherActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onCreate(android.os.Bundle icicle) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setTitle(CharSequence title) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setTitle(int titleId) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected void onSetContentView() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    protected android.content.Intent intentForPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    protected ListItem itemForPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    protected android.content.Intent getTargetIntent() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected java.util.List<android.content.pm.ResolveInfo> onQueryPackageManager(android.content.Intent queryIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public java.util.List<ListItem> makeListItems() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/LauncherActivity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */