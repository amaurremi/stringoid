/*    */
package android.content.pm;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*    */ public class ApplicationInfo extends PackageItemInfo implements android.os.Parcelable {
    /*    */   public String taskAffinity;
    /*    */   public String permission;

    /*    */
/*  9 */   public static class DisplayNameComparator implements java.util.Comparator<ApplicationInfo> {
        public DisplayNameComparator(PackageManager pm) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public final int compare(ApplicationInfo aa, ApplicationInfo ab) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 12 */
    public ApplicationInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public ApplicationInfo(ApplicationInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void dump(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public CharSequence loadDescription(PackageManager pm) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public String processName;
    /*    */   public String className;
    /*    */   public int descriptionRes;
    /*    */   public int theme;
    /*    */   public String manageSpaceActivityName;
    /*    */   public String backupAgentName;
    /*    */   public int uiOptions;
    /*    */   public static final int FLAG_SYSTEM = 1;
    /*    */   public static final int FLAG_DEBUGGABLE = 2;
    /*    */   public static final int FLAG_HAS_CODE = 4;
    /*    */   public static final int FLAG_PERSISTENT = 8;
    /*    */   public static final int FLAG_FACTORY_TEST = 16;
    /*    */   public static final int FLAG_ALLOW_TASK_REPARENTING = 32;
    /*    */   public static final int FLAG_ALLOW_CLEAR_USER_DATA = 64;
    /*    */   public static final int FLAG_UPDATED_SYSTEM_APP = 128;
    /*    */   public static final int FLAG_TEST_ONLY = 256;
    /*    */   public static final int FLAG_SUPPORTS_SMALL_SCREENS = 512;
    /*    */   public static final int FLAG_SUPPORTS_NORMAL_SCREENS = 1024;
    /*    */   public static final int FLAG_SUPPORTS_LARGE_SCREENS = 2048;
    /*    */   public static final int FLAG_RESIZEABLE_FOR_SCREENS = 4096;
    /*    */   public static final int FLAG_SUPPORTS_SCREEN_DENSITIES = 8192;
    /*    */   public static final int FLAG_VM_SAFE_MODE = 16384;
    /*    */   public static final int FLAG_ALLOW_BACKUP = 32768;
    /*    */   public static final int FLAG_KILL_AFTER_RESTORE = 65536;
    /*    */   public static final int FLAG_RESTORE_ANY_VERSION = 131072;
    /*    */   public static final int FLAG_EXTERNAL_STORAGE = 262144;
    /*    */   public static final int FLAG_SUPPORTS_XLARGE_SCREENS = 524288;
    /*    */   public static final int FLAG_LARGE_HEAP = 1048576;
    /*    */   public static final int FLAG_STOPPED = 2097152;
    /*    */   public int flags;
    /*    */   public int requiresSmallestWidthDp;
    /*    */   public int compatibleWidthLimitDp;
    /*    */   public int largestWidthLimitDp;
    /*    */   public String sourceDir;
    /*    */   public String publicSourceDir;
    /* 56 */   public String[] sharedLibraryFiles = null;
    /*    */
/*    */   public String dataDir;
    /*    */   public String nativeLibraryDir;
    /*    */   public int uid;
    /*    */   public int targetSdkVersion;
    /*    */   public boolean enabled;
    /* 63 */   public static final android.os.Parcelable.Creator<ApplicationInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/ApplicationInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */