/*    */
package android.content.pm;
/*    */ 
/*    */

import android.util.Printer;

/*    */
/*    */ public class ActivityInfo extends ComponentInfo implements android.os.Parcelable {
    /*  6 */
    public ActivityInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public ActivityInfo(ActivityInfo orig) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public final int getThemeResource() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void dump(Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToParcel(android.os.Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public int theme;
    /*    */   public static final int LAUNCH_MULTIPLE = 0;
    /*    */   public static final int LAUNCH_SINGLE_TOP = 1;
    /*    */   public static final int LAUNCH_SINGLE_TASK = 2;
    /*    */   public static final int LAUNCH_SINGLE_INSTANCE = 3;
    /*    */   public int launchMode;
    /*    */   public String permission;
    /*    */   public String taskAffinity;
    /*    */   public String targetActivity;
    /*    */   public static final int FLAG_MULTIPROCESS = 1;
    /*    */   public static final int FLAG_FINISH_ON_TASK_LAUNCH = 2;
    /*    */   public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 4;
    /*    */   public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 8;
    /*    */   public static final int FLAG_STATE_NOT_NEEDED = 16;
    /*    */   public static final int FLAG_EXCLUDE_FROM_RECENTS = 32;
    /*    */   public static final int FLAG_ALLOW_TASK_REPARENTING = 64;
    /*    */   public static final int FLAG_NO_HISTORY = 128;
    /*    */   public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 256;
    /*    */   public static final int FLAG_HARDWARE_ACCELERATED = 512;
    /*    */   public int flags;
    /*    */   public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1;
    /*    */   public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    /*    */   public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    /*    */   public static final int SCREEN_ORIENTATION_USER = 2;
    /*    */   public static final int SCREEN_ORIENTATION_BEHIND = 3;
    /*    */   public static final int SCREEN_ORIENTATION_SENSOR = 4;
    /*    */   public static final int SCREEN_ORIENTATION_NOSENSOR = 5;
    /*    */   public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
    /*    */   public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
    /*    */   public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
    /*    */   public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;
    /*    */   public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10;
    /*    */   public int screenOrientation;
    /*    */   public static final int CONFIG_MCC = 1;
    /*    */   public static final int CONFIG_MNC = 2;
    /*    */   public static final int CONFIG_LOCALE = 4;
    /*    */   public static final int CONFIG_TOUCHSCREEN = 8;
    /*    */   public static final int CONFIG_KEYBOARD = 16;
    /*    */   public static final int CONFIG_KEYBOARD_HIDDEN = 32;
    /*    */   public static final int CONFIG_NAVIGATION = 64;
    /*    */   public static final int CONFIG_ORIENTATION = 128;
    /*    */   public static final int CONFIG_SCREEN_LAYOUT = 256;
    /*    */   public static final int CONFIG_UI_MODE = 512;
    /*    */   public static final int CONFIG_SCREEN_SIZE = 1024;
    /*    */   public static final int CONFIG_SMALLEST_SCREEN_SIZE = 2048;
    /*    */   public static final int CONFIG_FONT_SCALE = 1073741824;
    /*    */   public int configChanges;
    /*    */   public int softInputMode;
    /*    */   public int uiOptions;
    /*    */   public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    /*    */   public String parentActivityName;
    /* 65 */   public static final android.os.Parcelable.Creator<ActivityInfo> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/ActivityInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */