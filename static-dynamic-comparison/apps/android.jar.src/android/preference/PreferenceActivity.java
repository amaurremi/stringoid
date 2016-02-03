/*    */
package android.preference;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*    */ public abstract class PreferenceActivity extends android.app.ListActivity implements PreferenceFragment.OnPreferenceStartFragmentCallback {
    public static final String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";
    /*    */   public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";
    /*    */   public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";

    /*    */
/*  9 */   public static final class Header implements android.os.Parcelable {
        public Header() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public CharSequence getTitle(android.content.res.Resources res) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public CharSequence getSummary(android.content.res.Resources res) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public CharSequence getBreadCrumbTitle(android.content.res.Resources res) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public CharSequence getBreadCrumbShortTitle(android.content.res.Resources res) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public void writeToParcel(android.os.Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public void readFromParcel(android.os.Parcel in) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public long id;
        /*    */     public int titleRes;
        /*    */     public CharSequence title;
        /*    */     public int summaryRes;
        /*    */     public CharSequence summary;
        /*    */     public int breadCrumbTitleRes;
        /*    */     public CharSequence breadCrumbTitle;
        /*    */     public int breadCrumbShortTitleRes;
        /*    */     public CharSequence breadCrumbShortTitle;
        /*    */     public int iconRes;
        /*    */     public String fragment;
        /*    */     public Bundle fragmentArguments;
        /*    */     public android.content.Intent intent;
        /*    */     public Bundle extras;
        /* 32 */     public static final android.os.Parcelable.Creator<Header> CREATOR = null;
    }

    /*    */
/* 34 */
    public PreferenceActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    protected void onCreate(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean hasHeaders() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean isMultiPane() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean onIsMultiPane() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean onIsHidingHeaders() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public Header onGetInitialHeader() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public Header onGetNewHeader() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void onBuildHeaders(java.util.List<Header> target) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void invalidateHeaders() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void loadHeadersFromResource(int resid, java.util.List<Header> target) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void setListFooter(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    protected void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    protected void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    protected void onSaveInstanceState(Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    protected void onRestoreInstanceState(Bundle state) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void onContentChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void onHeaderClick(Header header, int position) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public android.content.Intent onBuildStartFragmentIntent(String fragmentName, Bundle args, int titleRes, int shortTitleRes) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void startWithFragment(String fragmentName, Bundle args, android.app.Fragment resultTo, int resultRequestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void startWithFragment(String fragmentName, Bundle args, android.app.Fragment resultTo, int resultRequestCode, int titleRes, int shortTitleRes) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void showBreadCrumbs(CharSequence title, CharSequence shortTitle) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void setParentTitle(CharSequence title, CharSequence shortTitle, android.view.View.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public void switchToHeader(String fragmentName, Bundle args) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public void switchToHeader(Header header) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void startPreferenceFragment(android.app.Fragment fragment, boolean push) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void startPreferencePanel(String fragmentClass, Bundle args, int titleRes, CharSequence titleText, android.app.Fragment resultTo, int resultRequestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public void finishPreferencePanel(android.app.Fragment caller, int resultCode, android.content.Intent resultData) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 66 */ public PreferenceManager getPreferenceManager() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 68 */ public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 70 */ public PreferenceScreen getPreferenceScreen() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 72 */ public void addPreferencesFromIntent(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 74 */ public void addPreferencesFromResource(int preferencesResId) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 76 */ public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 78 */ public Preference findPreference(CharSequence key) {
        throw new RuntimeException("Stub!");
    }

    /* 79 */
    protected void onNewIntent(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String EXTRA_SHOW_FRAGMENT_SHORT_TITLE = ":android:show_fragment_short_title";
    /*    */   public static final String EXTRA_NO_HEADERS = ":android:no_headers";
    /*    */   public static final long HEADER_ID_UNDEFINED = -1L;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/PreferenceActivity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */