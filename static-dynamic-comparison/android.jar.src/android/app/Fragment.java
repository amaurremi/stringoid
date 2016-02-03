/*    */
package android.app;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*    */ public class Fragment
/*    */ implements android.content.ComponentCallbacks2, android.view.View.OnCreateContextMenuListener {
    /*    */   public static class SavedState implements android.os.Parcelable {
        /*  8 */     SavedState() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public void writeToParcel(android.os.Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/* 12 */     public static final android.os.Parcelable.ClassLoaderCreator<SavedState> CREATOR = null;
/*    */
    }

    /*    */
/*    */   public static class InstantiationException
/*    */ extends android.util.AndroidRuntimeException {
        /* 17 */
        public InstantiationException(String msg, Exception cause) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 19 */
    public Fragment() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static Fragment instantiate(android.content.Context context, String fname) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static Fragment instantiate(android.content.Context context, String fname, Bundle args) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public final boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final int getId() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public final String getTag() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setArguments(Bundle args) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public final Bundle getArguments() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setInitialSavedState(SavedState state) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setTargetFragment(Fragment fragment, int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public final Fragment getTargetFragment() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public final int getTargetRequestCode() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public final Activity getActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public final android.content.res.Resources getResources() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public final CharSequence getText(int resId) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public final String getString(int resId) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public final String getString(int resId, Object... formatArgs) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public final FragmentManager getFragmentManager() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public final boolean isAdded() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public final boolean isDetached() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public final boolean isRemoving() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public final boolean isInLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public final boolean isResumed() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public final boolean isVisible() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public final boolean isHidden() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void onHiddenChanged(boolean hidden) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void setRetainInstance(boolean retain) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public final boolean getRetainInstance() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void setHasOptionsMenu(boolean hasMenu) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void setMenuVisibility(boolean menuVisible) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void setUserVisibleHint(boolean isVisibleToUser) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public boolean getUserVisibleHint() {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public LoaderManager getLoaderManager() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void startActivity(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void startActivity(android.content.Intent intent, Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void startActivityForResult(android.content.Intent intent, int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void startActivityForResult(android.content.Intent intent, int requestCode, Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 60 */ public void onInflate(android.util.AttributeSet attrs, Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void onInflate(Activity activity, android.util.AttributeSet attrs, Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void onAttach(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public android.animation.Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void onCreate(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void onViewCreated(android.view.View view, Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public android.view.View getView() {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public void onActivityCreated(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public void onResume() {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public void onSaveInstanceState(Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    public void onPause() {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    public void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 75 */
    public void onLowMemory() {
        throw new RuntimeException("Stub!");
    }

    /* 76 */
    public void onTrimMemory(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 77 */
    public void onDestroyView() {
        throw new RuntimeException("Stub!");
    }

    /* 78 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 79 */
    public void onDetach() {
        throw new RuntimeException("Stub!");
    }

    /* 80 */
    public void onCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater inflater) {
        throw new RuntimeException("Stub!");
    }

    /* 81 */
    public void onPrepareOptionsMenu(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 82 */
    public void onDestroyOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 83 */
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /* 84 */
    public void onOptionsMenuClosed(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 85 */
    public void onCreateContextMenu(android.view.ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        throw new RuntimeException("Stub!");
    }

    /* 86 */
    public void registerForContextMenu(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 87 */
    public void unregisterForContextMenu(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 88 */
    public boolean onContextItemSelected(android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /* 89 */
    public void dump(String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/Fragment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */