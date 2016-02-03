/*     */
package android.app;
/*     */ 
/*     */

import android.content.Intent;

/*     */
/*     */ public class Activity extends android.view.ContextThemeWrapper implements android.view.LayoutInflater.Factory2, android.view.Window.Callback, android.view.KeyEvent.Callback, android.view.View.OnCreateContextMenuListener, android.content.ComponentCallbacks2 {
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = -1;

    /*   6 */
    public Activity() {
        throw new RuntimeException("Stub!");
    }

    /*   7 */
    public Intent getIntent() {
        throw new RuntimeException("Stub!");
    }

    /*   8 */
    public void setIntent(Intent newIntent) {
        throw new RuntimeException("Stub!");
    }

    /*   9 */
    public final Application getApplication() {
        throw new RuntimeException("Stub!");
    }

    /*  10 */
    public final boolean isChild() {
        throw new RuntimeException("Stub!");
    }

    /*  11 */
    public final Activity getParent() {
        throw new RuntimeException("Stub!");
    }

    /*  12 */
    public android.view.WindowManager getWindowManager() {
        throw new RuntimeException("Stub!");
    }

    /*  13 */
    public android.view.Window getWindow() {
        throw new RuntimeException("Stub!");
    }

    /*  14 */
    public LoaderManager getLoaderManager() {
        throw new RuntimeException("Stub!");
    }

    /*  15 */
    public android.view.View getCurrentFocus() {
        throw new RuntimeException("Stub!");
    }

    /*  16 */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /*  17 */
    protected void onRestoreInstanceState(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /*  18 */
    protected void onPostCreate(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /*  19 */
    protected void onStart() {
        throw new RuntimeException("Stub!");
    }

    /*  20 */
    protected void onRestart() {
        throw new RuntimeException("Stub!");
    }

    /*  21 */
    protected void onResume() {
        throw new RuntimeException("Stub!");
    }

    /*  22 */
    protected void onPostResume() {
        throw new RuntimeException("Stub!");
    }

    /*  23 */
    protected void onNewIntent(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*  24 */
    protected void onSaveInstanceState(android.os.Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /*  25 */
    protected void onPause() {
        throw new RuntimeException("Stub!");
    }

    /*  26 */
    protected void onUserLeaveHint() {
        throw new RuntimeException("Stub!");
    }

    /*  27 */
    public boolean onCreateThumbnail(android.graphics.Bitmap outBitmap, android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /*  28 */
    public CharSequence onCreateDescription() {
        throw new RuntimeException("Stub!");
    }

    /*  29 */
    protected void onStop() {
        throw new RuntimeException("Stub!");
    }

    /*  30 */
    protected void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /*  31 */
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /*  32 */
    public int getChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  34 */ public Object getLastNonConfigurationInstance() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  36 */ public Object onRetainNonConfigurationInstance() {
        throw new RuntimeException("Stub!");
    }

    /*  37 */
    public void onLowMemory() {
        throw new RuntimeException("Stub!");
    }

    /*  38 */
    public void onTrimMemory(int level) {
        throw new RuntimeException("Stub!");
    }

    /*  39 */
    public FragmentManager getFragmentManager() {
        throw new RuntimeException("Stub!");
    }

    /*  40 */
    public void onAttachFragment(Fragment fragment) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  42 */ public final android.database.Cursor managedQuery(android.net.Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  44 */ public void startManagingCursor(android.database.Cursor c) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  46 */ public void stopManagingCursor(android.database.Cursor c) {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public android.view.View findViewById(int id) {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public ActionBar getActionBar() {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public void setContentView(int layoutResID) {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public void setContentView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public void setFinishOnTouchOutside(boolean finish) {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public final void setDefaultKeyMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  56 */
    public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  59 */
    public void onBackPressed() {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public boolean onKeyShortcut(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public boolean onTouchEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public boolean onTrackballEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public boolean onGenericMotionEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public void onUserInteraction() {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public void onContentChanged() {
        throw new RuntimeException("Stub!");
    }

    /*  67 */
    public void onWindowFocusChanged(boolean hasFocus) {
        throw new RuntimeException("Stub!");
    }

    /*  68 */
    public void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /*  69 */
    public void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public boolean hasWindowFocus() {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public boolean dispatchTouchEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /*  74 */
    public boolean dispatchTrackballEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /*  76 */
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  77 */
    public android.view.View onCreatePanelView(int featureId) {
        throw new RuntimeException("Stub!");
    }

    /*  78 */
    public boolean onCreatePanelMenu(int featureId, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*  79 */
    public boolean onPreparePanel(int featureId, android.view.View view, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public boolean onMenuOpened(int featureId, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public boolean onMenuItemSelected(int featureId, android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public void onPanelClosed(int featureId, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    public void invalidateOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /*  84 */
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public boolean onNavigateUp() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public boolean onNavigateUpFromChild(Activity child) {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public void onOptionsMenuClosed(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public void openOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public void closeOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public void onCreateContextMenu(android.view.ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public void registerForContextMenu(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public void unregisterForContextMenu(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public void openContextMenu(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public void closeContextMenu() {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public boolean onContextItemSelected(android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public void onContextMenuClosed(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 102 */ protected Dialog onCreateDialog(int id) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 104 */ protected Dialog onCreateDialog(int id, android.os.Bundle args) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 106 */ protected void onPrepareDialog(int id, Dialog dialog) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 108 */ protected void onPrepareDialog(int id, Dialog dialog, android.os.Bundle args) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 110 */ public final void showDialog(int id) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 112 */ public final boolean showDialog(int id, android.os.Bundle args) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 114 */ public final void dismissDialog(int id) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 116 */ public final void removeDialog(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public boolean onSearchRequested() {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    public void startSearch(String initialQuery, boolean selectInitialQuery, android.os.Bundle appSearchData, boolean globalSearch) {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public void triggerSearch(String query, android.os.Bundle appSearchData) {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public void takeKeyEvents(boolean get) {
        throw new RuntimeException("Stub!");
    }

    /* 121 */
    public final boolean requestWindowFeature(int featureId) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    public final void setFeatureDrawableResource(int featureId, int resId) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    public final void setFeatureDrawableUri(int featureId, android.net.Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    public final void setFeatureDrawable(int featureId, android.graphics.drawable.Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 126 */
    public android.view.LayoutInflater getLayoutInflater() {
        throw new RuntimeException("Stub!");
    }

    /* 127 */
    public android.view.MenuInflater getMenuInflater() {
        throw new RuntimeException("Stub!");
    }

    /* 128 */
    protected void onApplyThemeResource(android.content.res.Resources.Theme theme, int resid, boolean first) {
        throw new RuntimeException("Stub!");
    }

    /* 129 */
    public void startActivityForResult(Intent intent, int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 130 */
    public void startActivityForResult(Intent intent, int requestCode, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 131 */
    public void startIntentSenderForResult(android.content.IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public void startIntentSenderForResult(android.content.IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    public void startActivity(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public void startActivity(Intent intent, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public void startActivities(Intent[] intents) {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    public void startActivities(Intent[] intents, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 137 */
    public void startIntentSender(android.content.IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    public void startIntentSender(android.content.IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 139 */
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 140 */
    public boolean startActivityIfNeeded(Intent intent, int requestCode, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 141 */
    public boolean startNextMatchingActivity(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    public boolean startNextMatchingActivity(Intent intent, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    public void startActivityFromChild(Activity child, Intent intent, int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 144 */
    public void startActivityFromChild(Activity child, Intent intent, int requestCode, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 145 */
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 147 */
    public void startIntentSenderFromChild(Activity child, android.content.IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 148 */
    public void startIntentSenderFromChild(Activity child, android.content.IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 149 */
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    public final void setResult(int resultCode) {
        throw new RuntimeException("Stub!");
    }

    /* 151 */
    public final void setResult(int resultCode, Intent data) {
        throw new RuntimeException("Stub!");
    }

    /* 152 */
    public String getCallingPackage() {
        throw new RuntimeException("Stub!");
    }

    /* 153 */
    public android.content.ComponentName getCallingActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 154 */
    public void setVisible(boolean visible) {
        throw new RuntimeException("Stub!");
    }

    /* 155 */
    public boolean isFinishing() {
        throw new RuntimeException("Stub!");
    }

    /* 156 */
    public boolean isChangingConfigurations() {
        throw new RuntimeException("Stub!");
    }

    /* 157 */
    public void recreate() {
        throw new RuntimeException("Stub!");
    }

    /* 158 */
    public void finish() {
        throw new RuntimeException("Stub!");
    }

    /* 159 */
    public void finishAffinity() {
        throw new RuntimeException("Stub!");
    }

    /* 160 */
    public void finishFromChild(Activity child) {
        throw new RuntimeException("Stub!");
    }

    /* 161 */
    public void finishActivity(int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 162 */
    public void finishActivityFromChild(Activity child, int requestCode) {
        throw new RuntimeException("Stub!");
    }

    /* 163 */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        throw new RuntimeException("Stub!");
    }

    /* 164 */
    public PendingIntent createPendingResult(int requestCode, Intent data, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 165 */
    public void setRequestedOrientation(int requestedOrientation) {
        throw new RuntimeException("Stub!");
    }

    /* 166 */
    public int getRequestedOrientation() {
        throw new RuntimeException("Stub!");
    }

    /* 167 */
    public int getTaskId() {
        throw new RuntimeException("Stub!");
    }

    /* 168 */
    public boolean isTaskRoot() {
        throw new RuntimeException("Stub!");
    }

    /* 169 */
    public boolean moveTaskToBack(boolean nonRoot) {
        throw new RuntimeException("Stub!");
    }

    /* 170 */
    public String getLocalClassName() {
        throw new RuntimeException("Stub!");
    }

    /* 171 */
    public android.content.ComponentName getComponentName() {
        throw new RuntimeException("Stub!");
    }

    /* 172 */
    public android.content.SharedPreferences getPreferences(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 173 */
    public Object getSystemService(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 174 */
    public void setTitle(CharSequence title) {
        throw new RuntimeException("Stub!");
    }

    /* 175 */
    public void setTitle(int titleId) {
        throw new RuntimeException("Stub!");
    }

    /* 176 */
    public void setTitleColor(int textColor) {
        throw new RuntimeException("Stub!");
    }

    /* 177 */
    public final CharSequence getTitle() {
        throw new RuntimeException("Stub!");
    }

    /* 178 */
    public final int getTitleColor() {
        throw new RuntimeException("Stub!");
    }

    /* 179 */
    protected void onTitleChanged(CharSequence title, int color) {
        throw new RuntimeException("Stub!");
    }

    /* 180 */
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        throw new RuntimeException("Stub!");
    }

    /* 181 */
    public final void setProgressBarVisibility(boolean visible) {
        throw new RuntimeException("Stub!");
    }

    /* 182 */
    public final void setProgressBarIndeterminateVisibility(boolean visible) {
        throw new RuntimeException("Stub!");
    }

    /* 183 */
    public final void setProgressBarIndeterminate(boolean indeterminate) {
        throw new RuntimeException("Stub!");
    }

    /* 184 */
    public final void setProgress(int progress) {
        throw new RuntimeException("Stub!");
    }

    /* 185 */
    public final void setSecondaryProgress(int secondaryProgress) {
        throw new RuntimeException("Stub!");
    }

    /* 186 */
    public final void setVolumeControlStream(int streamType) {
        throw new RuntimeException("Stub!");
    }

    /* 187 */
    public final int getVolumeControlStream() {
        throw new RuntimeException("Stub!");
    }

    /* 188 */
    public final void runOnUiThread(Runnable action) {
        throw new RuntimeException("Stub!");
    }

    /* 189 */
    public android.view.View onCreateView(String name, android.content.Context context, android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 190 */
    public android.view.View onCreateView(android.view.View parent, String name, android.content.Context context, android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 191 */
    public void dump(String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /* 192 */
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 193 */
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 194 */
    public void onActionModeStarted(android.view.ActionMode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 195 */
    public void onActionModeFinished(android.view.ActionMode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 196 */
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 197 */
    public boolean navigateUpTo(Intent upIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 198 */
    public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 199 */
    public Intent getParentActivityIntent() {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */ 
/*     */   public static final int RESULT_FIRST_USER = 1;
    /* 203 */   protected static final int[] FOCUSED_STATE_SET = null;
    /*     */   public static final int DEFAULT_KEYS_DISABLE = 0;
    /*     */   public static final int DEFAULT_KEYS_DIALER = 1;
    /*     */   public static final int DEFAULT_KEYS_SHORTCUT = 2;
    /*     */   public static final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    /*     */   public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/Activity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */