/*    */
package android.content.pm;
/*    */ 
/*    */

import android.content.ComponentName;

/*    */
/*    */ public abstract class PackageManager {
    public static final int GET_ACTIVITIES = 1;

    /*    */
/*  7 */   public static class NameNotFoundException extends android.util.AndroidException {
        public NameNotFoundException() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public NameNotFoundException(String name) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 10 */
    public PackageManager() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract PackageInfo getPackageInfo(String paramString, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract String[] currentToCanonicalPackageNames(String[] paramArrayOfString);

    /*    */
    public abstract String[] canonicalToCurrentPackageNames(String[] paramArrayOfString);

    /*    */
    public abstract android.content.Intent getLaunchIntentForPackage(String paramString);

    /*    */
    public abstract int[] getPackageGids(String paramString) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract PermissionInfo getPermissionInfo(String paramString, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract java.util.List<PermissionInfo> queryPermissionsByGroup(String paramString, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract PermissionGroupInfo getPermissionGroupInfo(String paramString, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract java.util.List<PermissionGroupInfo> getAllPermissionGroups(int paramInt);

    /*    */
    public abstract ApplicationInfo getApplicationInfo(String paramString, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract ActivityInfo getActivityInfo(ComponentName paramComponentName, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract ActivityInfo getReceiverInfo(ComponentName paramComponentName, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract ServiceInfo getServiceInfo(ComponentName paramComponentName, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract ProviderInfo getProviderInfo(ComponentName paramComponentName, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract java.util.List<PackageInfo> getInstalledPackages(int paramInt);

    /*    */
    public abstract int checkPermission(String paramString1, String paramString2);

    /*    */
    public abstract boolean addPermission(PermissionInfo paramPermissionInfo);

    /*    */
    public abstract boolean addPermissionAsync(PermissionInfo paramPermissionInfo);

    /*    */
    public abstract void removePermission(String paramString);

    /*    */
    public abstract int checkSignatures(String paramString1, String paramString2);

    /*    */
    public abstract int checkSignatures(int paramInt1, int paramInt2);

    /*    */
    public abstract String[] getPackagesForUid(int paramInt);

    /*    */
    public abstract String getNameForUid(int paramInt);

    /*    */
    public abstract java.util.List<ApplicationInfo> getInstalledApplications(int paramInt);

    /*    */
    public abstract String[] getSystemSharedLibraryNames();

    /*    */
    public abstract FeatureInfo[] getSystemAvailableFeatures();

    /*    */
    public abstract boolean hasSystemFeature(String paramString);

    /*    */
    public abstract ResolveInfo resolveActivity(android.content.Intent paramIntent, int paramInt);

    /*    */
    public abstract java.util.List<ResolveInfo> queryIntentActivities(android.content.Intent paramIntent, int paramInt);

    /*    */
    public abstract java.util.List<ResolveInfo> queryIntentActivityOptions(ComponentName paramComponentName, android.content.Intent[] paramArrayOfIntent, android.content.Intent paramIntent, int paramInt);

    /*    */
    public abstract java.util.List<ResolveInfo> queryBroadcastReceivers(android.content.Intent paramIntent, int paramInt);

    /*    */
    public abstract ResolveInfo resolveService(android.content.Intent paramIntent, int paramInt);

    /*    */
    public abstract java.util.List<ResolveInfo> queryIntentServices(android.content.Intent paramIntent, int paramInt);

    /*    */
    public abstract ProviderInfo resolveContentProvider(String paramString, int paramInt);

    /*    */
    public abstract java.util.List<ProviderInfo> queryContentProviders(String paramString, int paramInt1, int paramInt2);

    /*    */
    public abstract InstrumentationInfo getInstrumentationInfo(ComponentName paramComponentName, int paramInt) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract java.util.List<InstrumentationInfo> queryInstrumentation(String paramString, int paramInt);

    /*    */
    public abstract android.graphics.drawable.Drawable getDrawable(String paramString, int paramInt, ApplicationInfo paramApplicationInfo);

    /*    */
    public abstract android.graphics.drawable.Drawable getActivityIcon(ComponentName paramComponentName) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract android.graphics.drawable.Drawable getActivityIcon(android.content.Intent paramIntent) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract android.graphics.drawable.Drawable getDefaultActivityIcon();

    /*    */
    public abstract android.graphics.drawable.Drawable getApplicationIcon(ApplicationInfo paramApplicationInfo);

    /*    */
    public abstract android.graphics.drawable.Drawable getApplicationIcon(String paramString) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract android.graphics.drawable.Drawable getActivityLogo(ComponentName paramComponentName) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract android.graphics.drawable.Drawable getActivityLogo(android.content.Intent paramIntent) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract android.graphics.drawable.Drawable getApplicationLogo(ApplicationInfo paramApplicationInfo);

    /*    */
    public abstract android.graphics.drawable.Drawable getApplicationLogo(String paramString) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract CharSequence getText(String paramString, int paramInt, ApplicationInfo paramApplicationInfo);

    /*    */
    public abstract android.content.res.XmlResourceParser getXml(String paramString, int paramInt, ApplicationInfo paramApplicationInfo);

    /*    */
    public abstract CharSequence getApplicationLabel(ApplicationInfo paramApplicationInfo);

    /*    */
    public abstract android.content.res.Resources getResourcesForActivity(ComponentName paramComponentName) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract android.content.res.Resources getResourcesForApplication(ApplicationInfo paramApplicationInfo) throws PackageManager.NameNotFoundException;

    /*    */
    public abstract android.content.res.Resources getResourcesForApplication(String paramString) throws PackageManager.NameNotFoundException;

    /* 64 */
    public PackageInfo getPackageArchiveInfo(String archiveFilePath, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int GET_RECEIVERS = 2;
    /*    */   public static final int GET_SERVICES = 4;
    /*    */   public static final int GET_PROVIDERS = 8;
    /*    */   public static final int GET_INSTRUMENTATION = 16;
    /*    */   public static final int GET_INTENT_FILTERS = 32;
    /*    */   public static final int GET_SIGNATURES = 64;
    /*    */   public static final int GET_RESOLVED_FILTER = 64;
    /*    */   public static final int GET_META_DATA = 128;
    /*    */   public static final int GET_GIDS = 256;
    /*    */   public static final int GET_DISABLED_COMPONENTS = 512;
    /*    */   public static final int GET_SHARED_LIBRARY_FILES = 1024;
    /*    */   public static final int GET_URI_PERMISSION_PATTERNS = 2048;
    /*    */   public static final int GET_PERMISSIONS = 4096;
    /*    */   public static final int GET_UNINSTALLED_PACKAGES = 8192;
    /*    */   public static final int GET_CONFIGURATIONS = 16384;
    /*    */   public static final int MATCH_DEFAULT_ONLY = 65536;
    /*    */   public static final int PERMISSION_GRANTED = 0;
    /*    */   public static final int PERMISSION_DENIED = -1;
    /*    */   public static final int SIGNATURE_MATCH = 0;
    /*    */   public static final int SIGNATURE_NEITHER_SIGNED = 1;
    /*    */   public static final int SIGNATURE_FIRST_NOT_SIGNED = -1;
    /*    */   public static final int SIGNATURE_SECOND_NOT_SIGNED = -2;
    /*    */   public static final int SIGNATURE_NO_MATCH = -3;
    /*    */   public static final int SIGNATURE_UNKNOWN_PACKAGE = -4;
    /*    */   public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0;
    /*    */   public static final int COMPONENT_ENABLED_STATE_ENABLED = 1;
    /*    */   public static final int COMPONENT_ENABLED_STATE_DISABLED = 2;
    /*    */   public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3;
    /*    */   public static final int DONT_KILL_APP = 1;
    /*    */   public static final int VERIFICATION_ALLOW = 1;
    /*    */   public static final int VERIFICATION_REJECT = -1;
    /*    */   public static final String FEATURE_AUDIO_LOW_LATENCY = "android.hardware.audio.low_latency";
    /*    */   public static final String FEATURE_BLUETOOTH = "android.hardware.bluetooth";
    /*    */   public static final String FEATURE_CAMERA = "android.hardware.camera";
    /*    */   public static final String FEATURE_CAMERA_AUTOFOCUS = "android.hardware.camera.autofocus";
    /*    */   public static final String FEATURE_CAMERA_FLASH = "android.hardware.camera.flash";
    /*    */   public static final String FEATURE_CAMERA_FRONT = "android.hardware.camera.front";
    /*    */   public static final String FEATURE_LOCATION = "android.hardware.location";
    /*    */   public static final String FEATURE_LOCATION_GPS = "android.hardware.location.gps";
    /*    */   public static final String FEATURE_LOCATION_NETWORK = "android.hardware.location.network";
    /*    */   public static final String FEATURE_MICROPHONE = "android.hardware.microphone";
    /*    */   public static final String FEATURE_NFC = "android.hardware.nfc";
    /*    */   public static final String FEATURE_SENSOR_ACCELEROMETER = "android.hardware.sensor.accelerometer";
    /*    */   public static final String FEATURE_SENSOR_BAROMETER = "android.hardware.sensor.barometer";
    /*    */   public static final String FEATURE_SENSOR_COMPASS = "android.hardware.sensor.compass";
    /*    */   public static final String FEATURE_SENSOR_GYROSCOPE = "android.hardware.sensor.gyroscope";
    /*    */   public static final String FEATURE_SENSOR_LIGHT = "android.hardware.sensor.light";
    /*    */   public static final String FEATURE_SENSOR_PROXIMITY = "android.hardware.sensor.proximity";
    /*    */   public static final String FEATURE_TELEPHONY = "android.hardware.telephony";
    /*    */   public static final String FEATURE_TELEPHONY_CDMA = "android.hardware.telephony.cdma";
    /*    */   public static final String FEATURE_TELEPHONY_GSM = "android.hardware.telephony.gsm";
    /*    */   public static final String FEATURE_USB_HOST = "android.hardware.usb.host";
    /*    */   public static final String FEATURE_USB_ACCESSORY = "android.hardware.usb.accessory";
    /*    */   public static final String FEATURE_SIP = "android.software.sip";
    /*    */   public static final String FEATURE_SIP_VOIP = "android.software.sip.voip";
    /*    */   public static final String FEATURE_TOUCHSCREEN = "android.hardware.touchscreen";
    /*    */   public static final String FEATURE_TOUCHSCREEN_MULTITOUCH = "android.hardware.touchscreen.multitouch";
    /*    */   public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT = "android.hardware.touchscreen.multitouch.distinct";
    /*    */   public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND = "android.hardware.touchscreen.multitouch.jazzhand";
    /*    */   public static final String FEATURE_FAKETOUCH = "android.hardware.faketouch";
    /*    */   public static final String FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT = "android.hardware.faketouch.multitouch.distinct";
    /*    */   public static final String FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND = "android.hardware.faketouch.multitouch.jazzhand";
    /*    */   public static final String FEATURE_SCREEN_PORTRAIT = "android.hardware.screen.portrait";
    /*    */   public static final String FEATURE_SCREEN_LANDSCAPE = "android.hardware.screen.landscape";
    /*    */   public static final String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";
    /*    */   public static final String FEATURE_WIFI = "android.hardware.wifi";
    /*    */   public static final String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";
    /*    */   public static final String FEATURE_TELEVISION = "android.hardware.type.television";
    /*    */   public static final String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";

    /*    */
    public abstract void verifyPendingInstall(int paramInt1, int paramInt2);

    /*    */
/*    */
    public abstract void setInstallerPackageName(String paramString1, String paramString2);

    /*    */
/*    */
    public abstract String getInstallerPackageName(String paramString);

    /*    */
/*    */
    @Deprecated
/*    */ public abstract void addPackageToPreferred(String paramString);

    /*    */
/*    */
    @Deprecated
/*    */ public abstract void removePackageFromPreferred(String paramString);

    /*    */
/*    */
    public abstract java.util.List<PackageInfo> getPreferredPackages(int paramInt);

    /*    */
/*    */
    @Deprecated
/*    */ public abstract void addPreferredActivity(android.content.IntentFilter paramIntentFilter, int paramInt, ComponentName[] paramArrayOfComponentName, ComponentName paramComponentName);

    /*    */
/*    */
    public abstract void clearPackagePreferredActivities(String paramString);

    /*    */
/*    */
    public abstract int getPreferredActivities(java.util.List<android.content.IntentFilter> paramList, java.util.List<ComponentName> paramList1, String paramString);

    /*    */
/*    */
    public abstract void setComponentEnabledSetting(ComponentName paramComponentName, int paramInt1, int paramInt2);

    /*    */
/*    */
    public abstract int getComponentEnabledSetting(ComponentName paramComponentName);

    /*    */
/*    */
    public abstract void setApplicationEnabledSetting(String paramString, int paramInt1, int paramInt2);

    /*    */
/*    */
    public abstract int getApplicationEnabledSetting(String paramString);

    /*    */
/*    */
    public abstract boolean isSafeMode();
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/PackageManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */