/*    */
package android.app;
/*    */ 
/*    */

import android.os.Bundle;
/*    */ import java.io.FileDescriptor;
/*    */ import java.io.PrintWriter;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FragmentManager
/*    */ {
    /*    */   public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /*    */
/* 17 */
    public FragmentManager() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract FragmentTransaction beginTransaction();

    /*    */
    public abstract boolean executePendingTransactions();

    /*    */
    public abstract Fragment findFragmentById(int paramInt);

    /*    */
    public abstract Fragment findFragmentByTag(String paramString);

    /*    */
    public abstract void popBackStack();

    /*    */
    public abstract boolean popBackStackImmediate();

    /*    */
    public abstract void popBackStack(String paramString, int paramInt);

    /*    */
    public abstract boolean popBackStackImmediate(String paramString, int paramInt);

    /*    */
    public abstract void popBackStack(int paramInt1, int paramInt2);

    /*    */
    public abstract boolean popBackStackImmediate(int paramInt1, int paramInt2);

    /*    */
    public abstract int getBackStackEntryCount();

    /*    */
    public abstract BackStackEntry getBackStackEntryAt(int paramInt);

    /*    */
    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener paramOnBackStackChangedListener);

    /*    */
    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener paramOnBackStackChangedListener);

    /*    */
    public abstract void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment);

    /*    */
    public abstract Fragment getFragment(Bundle paramBundle, String paramString);

    /*    */
    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment);

    /*    */
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

    /* 36 */
    public static void enableDebugLogging(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void invalidateOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnBackStackChangedListener
/*    */ {
        /*    */
        public abstract void onBackStackChanged();
/*    */
    }

    /*    */
/*    */   public static abstract interface BackStackEntry
/*    */ {
        /*    */
        public abstract int getId();

        /*    */
/*    */
        public abstract String getName();

        /*    */
/*    */
        public abstract int getBreadCrumbTitleRes();

        /*    */
/*    */
        public abstract int getBreadCrumbShortTitleRes();

        /*    */
/*    */
        public abstract CharSequence getBreadCrumbTitle();

        /*    */
/*    */
        public abstract CharSequence getBreadCrumbShortTitle();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/FragmentManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */