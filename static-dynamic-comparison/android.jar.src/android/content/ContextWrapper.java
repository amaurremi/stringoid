/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*  5 */ public class ContextWrapper extends Context {
    public ContextWrapper(Context base) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected void attachBaseContext(Context base) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public Context getBaseContext() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public android.content.res.AssetManager getAssets() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public android.content.res.Resources getResources() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public android.content.pm.PackageManager getPackageManager() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public ContentResolver getContentResolver() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public android.os.Looper getMainLooper() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Context getApplicationContext() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setTheme(int resid) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public android.content.res.Resources.Theme getTheme() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public ClassLoader getClassLoader() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public String getPackageName() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public android.content.pm.ApplicationInfo getApplicationInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public String getPackageResourcePath() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public String getPackageCodePath() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public SharedPreferences getSharedPreferences(String name, int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public java.io.FileInputStream openFileInput(String name) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public java.io.FileOutputStream openFileOutput(String name, int mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean deleteFile(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public java.io.File getFileStreamPath(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public String[] fileList() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public java.io.File getFilesDir() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public java.io.File getExternalFilesDir(String type) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public java.io.File getObbDir() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public java.io.File getCacheDir() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public java.io.File getExternalCacheDir() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public java.io.File getDir(String name, int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(String name, int mode, android.database.sqlite.SQLiteDatabase.CursorFactory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(String name, int mode, android.database.sqlite.SQLiteDatabase.CursorFactory factory, android.database.DatabaseErrorHandler errorHandler) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean deleteDatabase(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public java.io.File getDatabasePath(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public String[] databaseList() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public android.graphics.drawable.Drawable getWallpaper() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public android.graphics.drawable.Drawable peekWallpaper() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public int getWallpaperDesiredMinimumWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public int getWallpaperDesiredMinimumHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setWallpaper(android.graphics.Bitmap bitmap) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void setWallpaper(java.io.InputStream data) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void clearWallpaper() throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void startActivity(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void startActivity(Intent intent, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void startActivities(Intent[] intents) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void startActivities(Intent[] intents, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void sendBroadcast(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void sendBroadcast(Intent intent, String receiverPermission) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, android.os.Handler scheduler, int initialCode, String initialData, android.os.Bundle initialExtras) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void sendStickyBroadcast(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, android.os.Handler scheduler, int initialCode, String initialData, android.os.Bundle initialExtras) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void removeStickyBroadcast(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, android.os.Handler scheduler) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public void unregisterReceiver(BroadcastReceiver receiver) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public ComponentName startService(Intent service) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public boolean stopService(Intent name) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void unbindService(ServiceConnection conn) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public boolean startInstrumentation(ComponentName className, String profileFile, android.os.Bundle arguments) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public Object getSystemService(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public int checkPermission(String permission, int pid, int uid) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public int checkCallingPermission(String permission) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public int checkCallingOrSelfPermission(String permission) {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public void enforcePermission(String permission, int pid, int uid, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public void enforceCallingPermission(String permission, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    public void enforceCallingOrSelfPermission(String permission, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    public void revokeUriPermission(Uri uri, int modeFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 75 */
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 76 */
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 77 */
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 78 */
    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 79 */
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 80 */
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 81 */
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 82 */
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 83 */
    public Context createPackageContext(String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 84 */
    public boolean isRestricted() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ContextWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */