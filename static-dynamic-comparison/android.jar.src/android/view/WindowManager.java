/*     */
package android.view;
/*     */ 
/*     */

import android.os.Parcel;

/*     */
/*     */ public abstract interface WindowManager extends ViewManager {
    /*     */
    public abstract Display getDefaultDisplay();

    /*     */
/*   8 */   public static class BadTokenException extends RuntimeException {
        public BadTokenException() {
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public BadTokenException(String name) {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static class LayoutParams extends ViewGroup.LayoutParams implements android.os.Parcelable {
        @ViewDebug.ExportedProperty
/*     */ public int x;

        /*     */
/*  15 */
        public LayoutParams() {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  16 */
        public LayoutParams(int _type) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  17 */
        public LayoutParams(int _type, int _flags) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  18 */
        public LayoutParams(int _type, int _flags, int _format) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  19 */
        public LayoutParams(int w, int h, int _type, int _flags, int _format) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  20 */
        public LayoutParams(int w, int h, int xpos, int ypos, int _type, int _flags, int _format) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  21 */
        public LayoutParams(Parcel in) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  22 */
        public static boolean mayUseInputMethod(int flags) {
            throw new RuntimeException("Stub!");
        }

        /*  23 */
        public final void setTitle(CharSequence title) {
            throw new RuntimeException("Stub!");
        }

        /*  24 */
        public final CharSequence getTitle() {
            throw new RuntimeException("Stub!");
        }

        /*  25 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /*  26 */
        public void writeToParcel(Parcel out, int parcelableFlags) {
            throw new RuntimeException("Stub!");
        }

        /*  27 */
        public final int copyFrom(LayoutParams o) {
            throw new RuntimeException("Stub!");
        }

        /*  28 */
        public String debug(String output) {
            throw new RuntimeException("Stub!");
        }

        /*  29 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */
        @ViewDebug.ExportedProperty
/*     */ public int y;
        /*     */
/*     */
        @ViewDebug.ExportedProperty
/*     */ public float horizontalWeight;
        /*     */
/*     */
        @ViewDebug.ExportedProperty
/*     */ public float verticalWeight;
        /*     */
/*     */
        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 1, to = "TYPE_BASE_APPLICATION"), @ViewDebug.IntToString(from = 2, to = "TYPE_APPLICATION"), @ViewDebug.IntToString(from = 3, to = "TYPE_APPLICATION_STARTING"), @ViewDebug.IntToString(from = 1000, to = "TYPE_APPLICATION_PANEL"), @ViewDebug.IntToString(from = 1001, to = "TYPE_APPLICATION_MEDIA"), @ViewDebug.IntToString(from = 1002, to = "TYPE_APPLICATION_SUB_PANEL"), @ViewDebug.IntToString(from = 1003, to = "TYPE_APPLICATION_ATTACHED_DIALOG"), @ViewDebug.IntToString(from = 2000, to = "TYPE_STATUS_BAR"), @ViewDebug.IntToString(from = 2001, to = "TYPE_SEARCH_BAR"), @ViewDebug.IntToString(from = 2002, to = "TYPE_PHONE"), @ViewDebug.IntToString(from = 2003, to = "TYPE_SYSTEM_ALERT"), @ViewDebug.IntToString(from = 2004, to = "TYPE_KEYGUARD"), @ViewDebug.IntToString(from = 2005, to = "TYPE_TOAST"), @ViewDebug.IntToString(from = 2006, to = "TYPE_SYSTEM_OVERLAY"), @ViewDebug.IntToString(from = 2007, to = "TYPE_PRIORITY_PHONE"), @ViewDebug.IntToString(from = 2014, to = "TYPE_STATUS_BAR_PANEL"), @ViewDebug.IntToString(from = 2017, to = "TYPE_STATUS_BAR_SUB_PANEL"), @ViewDebug.IntToString(from = 2008, to = "TYPE_SYSTEM_DIALOG"), @ViewDebug.IntToString(from = 2009, to = "TYPE_KEYGUARD_DIALOG"), @ViewDebug.IntToString(from = 2010, to = "TYPE_SYSTEM_ERROR"), @ViewDebug.IntToString(from = 2011, to = "TYPE_INPUT_METHOD"), @ViewDebug.IntToString(from = 2012, to = "TYPE_INPUT_METHOD_DIALOG"), @ViewDebug.IntToString(from = 2013, to = "TYPE_WALLPAPER"), @ViewDebug.IntToString(from = 2014, to = "TYPE_STATUS_BAR_PANEL"), @ViewDebug.IntToString(from = 2015, to = "TYPE_SECURE_SYSTEM_OVERLAY"), @ViewDebug.IntToString(from = 2016, to = "TYPE_DRAG"), @ViewDebug.IntToString(from = 2017, to = "TYPE_STATUS_BAR_SUB_PANEL"), @ViewDebug.IntToString(from = 2018, to = "TYPE_POINTER"), @ViewDebug.IntToString(from = 2019, to = "TYPE_NAVIGATION_BAR"), @ViewDebug.IntToString(from = 2020, to = "TYPE_VOLUME_OVERLAY"), @ViewDebug.IntToString(from = 2021, to = "TYPE_BOOT_PROGRESS")})
/*     */ public int type;
        /*     */
/*     */     public static final int FIRST_APPLICATION_WINDOW = 1;
        /*     */
/*     */     public static final int TYPE_BASE_APPLICATION = 1;
        /*     */
/*     */     public static final int TYPE_APPLICATION = 2;
        /*     */
/*     */     public static final int TYPE_APPLICATION_STARTING = 3;
        /*     */
/*     */     public static final int LAST_APPLICATION_WINDOW = 99;
        /*     */
/*     */     public static final int FIRST_SUB_WINDOW = 1000;
        /*     */
/*     */     public static final int TYPE_APPLICATION_PANEL = 1000;
        /*     */
/*     */     public static final int TYPE_APPLICATION_MEDIA = 1001;
        /*     */
/*     */     public static final int TYPE_APPLICATION_SUB_PANEL = 1002;
        /*     */
/*     */     public static final int TYPE_APPLICATION_ATTACHED_DIALOG = 1003;
        /*     */
/*     */     public static final int LAST_SUB_WINDOW = 1999;
        /*     */     public static final int FIRST_SYSTEM_WINDOW = 2000;
        /*     */     public static final int TYPE_STATUS_BAR = 2000;
        /*     */     public static final int TYPE_SEARCH_BAR = 2001;
        /*     */     public static final int TYPE_PHONE = 2002;
        /*     */     public static final int TYPE_SYSTEM_ALERT = 2003;
        /*     */     public static final int TYPE_KEYGUARD = 2004;
        /*     */     public static final int TYPE_TOAST = 2005;
        /*     */     public static final int TYPE_SYSTEM_OVERLAY = 2006;
        /*     */     public static final int TYPE_PRIORITY_PHONE = 2007;
        /*     */     public static final int TYPE_SYSTEM_DIALOG = 2008;
        /*     */     public static final int TYPE_KEYGUARD_DIALOG = 2009;
        /*     */     public static final int TYPE_SYSTEM_ERROR = 2010;
        /*     */     public static final int TYPE_INPUT_METHOD = 2011;
        /*     */     public static final int TYPE_INPUT_METHOD_DIALOG = 2012;
        /*     */     public static final int TYPE_WALLPAPER = 2013;
        /*     */     public static final int TYPE_STATUS_BAR_PANEL = 2014;
        /*     */     public static final int LAST_SYSTEM_WINDOW = 2999;
        /*     */
        @Deprecated
/*     */ public static final int MEMORY_TYPE_NORMAL = 0;
        /*     */
        @Deprecated
/*     */ public static final int MEMORY_TYPE_HARDWARE = 1;
        /*     */
        @Deprecated
/*     */ public static final int MEMORY_TYPE_GPU = 2;
        /*     */
        @Deprecated
/*     */ public static final int MEMORY_TYPE_PUSH_BUFFERS = 3;
        /*     */
        @Deprecated
/*     */ public int memoryType;
        /*     */     public static final int FLAG_ALLOW_LOCK_WHILE_SCREEN_ON = 1;
        /*     */     public static final int FLAG_DIM_BEHIND = 2;
        /*     */
        @Deprecated
/*     */ public static final int FLAG_BLUR_BEHIND = 4;
        /*     */     public static final int FLAG_NOT_FOCUSABLE = 8;
        /*     */     public static final int FLAG_NOT_TOUCHABLE = 16;
        /*     */     public static final int FLAG_NOT_TOUCH_MODAL = 32;
        /*     */     public static final int FLAG_TOUCHABLE_WHEN_WAKING = 64;
        /*     */     public static final int FLAG_KEEP_SCREEN_ON = 128;
        /*     */     public static final int FLAG_LAYOUT_IN_SCREEN = 256;
        /*     */     public static final int FLAG_LAYOUT_NO_LIMITS = 512;
        /*     */     public static final int FLAG_FULLSCREEN = 1024;
        /*     */     public static final int FLAG_FORCE_NOT_FULLSCREEN = 2048;
        /*     */     public static final int FLAG_DITHER = 4096;
        /*     */     public static final int FLAG_SECURE = 8192;
        /*     */     public static final int FLAG_SCALED = 16384;
        /*     */     public static final int FLAG_IGNORE_CHEEK_PRESSES = 32768;
        /*     */     public static final int FLAG_LAYOUT_INSET_DECOR = 65536;
        /*     */     public static final int FLAG_ALT_FOCUSABLE_IM = 131072;
        /*     */     public static final int FLAG_WATCH_OUTSIDE_TOUCH = 262144;
        /*     */     public static final int FLAG_SHOW_WHEN_LOCKED = 524288;
        /*     */     public static final int FLAG_SHOW_WALLPAPER = 1048576;
        /*     */     public static final int FLAG_TURN_SCREEN_ON = 2097152;
        /*     */     public static final int FLAG_DISMISS_KEYGUARD = 4194304;
        /*     */     public static final int FLAG_SPLIT_TOUCH = 8388608;
        /*     */     public static final int FLAG_HARDWARE_ACCELERATED = 16777216;
        /*     */
        @ViewDebug.ExportedProperty(flagMapping = {@ViewDebug.FlagToString(mask = 1, equals = 1, name = "FLAG_ALLOW_LOCK_WHILE_SCREEN_ON"), @ViewDebug.FlagToString(mask = 2, equals = 2, name = "FLAG_DIM_BEHIND"), @ViewDebug.FlagToString(mask = 4, equals = 4, name = "FLAG_BLUR_BEHIND"), @ViewDebug.FlagToString(mask = 8, equals = 8, name = "FLAG_NOT_FOCUSABLE"), @ViewDebug.FlagToString(mask = 16, equals = 16, name = "FLAG_NOT_TOUCHABLE"), @ViewDebug.FlagToString(mask = 32, equals = 32, name = "FLAG_NOT_TOUCH_MODAL"), @ViewDebug.FlagToString(mask = 64, equals = 64, name = "FLAG_TOUCHABLE_WHEN_WAKING"), @ViewDebug.FlagToString(mask = 128, equals = 128, name = "FLAG_KEEP_SCREEN_ON"), @ViewDebug.FlagToString(mask = 256, equals = 256, name = "FLAG_LAYOUT_IN_SCREEN"), @ViewDebug.FlagToString(mask = 512, equals = 512, name = "FLAG_LAYOUT_NO_LIMITS"), @ViewDebug.FlagToString(mask = 1024, equals = 1024, name = "FLAG_FULLSCREEN"), @ViewDebug.FlagToString(mask = 2048, equals = 2048, name = "FLAG_FORCE_NOT_FULLSCREEN"), @ViewDebug.FlagToString(mask = 4096, equals = 4096, name = "FLAG_DITHER"), @ViewDebug.FlagToString(mask = 8192, equals = 8192, name = "FLAG_SECURE"), @ViewDebug.FlagToString(mask = 16384, equals = 16384, name = "FLAG_SCALED"), @ViewDebug.FlagToString(mask = 32768, equals = 32768, name = "FLAG_IGNORE_CHEEK_PRESSES"), @ViewDebug.FlagToString(mask = 65536, equals = 65536, name = "FLAG_LAYOUT_INSET_DECOR"), @ViewDebug.FlagToString(mask = 131072, equals = 131072, name = "FLAG_ALT_FOCUSABLE_IM"), @ViewDebug.FlagToString(mask = 262144, equals = 262144, name = "FLAG_WATCH_OUTSIDE_TOUCH"), @ViewDebug.FlagToString(mask = 524288, equals = 524288, name = "FLAG_SHOW_WHEN_LOCKED"), @ViewDebug.FlagToString(mask = 1048576, equals = 1048576, name = "FLAG_SHOW_WALLPAPER"), @ViewDebug.FlagToString(mask = 2097152, equals = 2097152, name = "FLAG_TURN_SCREEN_ON"), @ViewDebug.FlagToString(mask = 4194304, equals = 4194304, name = "FLAG_DISMISS_KEYGUARD"), @ViewDebug.FlagToString(mask = 8388608, equals = 8388608, name = "FLAG_SPLIT_TOUCH"), @ViewDebug.FlagToString(mask = 16777216, equals = 16777216, name = "FLAG_HARDWARE_ACCELERATED")})
/*     */ public int flags;
        /*     */     public static final int SOFT_INPUT_MASK_STATE = 15;
        /*     */     public static final int SOFT_INPUT_STATE_UNSPECIFIED = 0;
        /*     */     public static final int SOFT_INPUT_STATE_UNCHANGED = 1;
        /*     */     public static final int SOFT_INPUT_STATE_HIDDEN = 2;
        /*     */     public static final int SOFT_INPUT_STATE_ALWAYS_HIDDEN = 3;
        /*     */     public static final int SOFT_INPUT_STATE_VISIBLE = 4;
        /*     */     public static final int SOFT_INPUT_STATE_ALWAYS_VISIBLE = 5;
        /*     */     public static final int SOFT_INPUT_MASK_ADJUST = 240;
        /*     */     public static final int SOFT_INPUT_ADJUST_UNSPECIFIED = 0;
        /*     */     public static final int SOFT_INPUT_ADJUST_RESIZE = 16;
        /*     */     public static final int SOFT_INPUT_ADJUST_PAN = 32;
        /*     */     public static final int SOFT_INPUT_ADJUST_NOTHING = 48;
        /*     */     public static final int SOFT_INPUT_IS_FORWARD_NAVIGATION = 256;
        /*     */     public int softInputMode;
        /*     */     public int gravity;
        /*     */     public float horizontalMargin;
        /*     */     public float verticalMargin;
        /*     */     public int format;
        /*     */     public int windowAnimations;
        /*     */     public float alpha;
        /*     */     public float dimAmount;
        /*     */     public static final float BRIGHTNESS_OVERRIDE_NONE = -1.0F;
        /*     */     public static final float BRIGHTNESS_OVERRIDE_OFF = 0.0F;
        /*     */     public static final float BRIGHTNESS_OVERRIDE_FULL = 1.0F;
        /*     */     public float screenBrightness;
        /*     */     public float buttonBrightness;
        /*     */     public android.os.IBinder token;
        /*     */     public String packageName;
        /*     */     public int screenOrientation;
        /*     */     public int systemUiVisibility;
        /* 150 */     public static final android.os.Parcelable.Creator<LayoutParams> CREATOR = null;
        /*     */     public static final int LAYOUT_CHANGED = 1;
        /*     */     public static final int TYPE_CHANGED = 2;
        /*     */     public static final int FLAGS_CHANGED = 4;
        /*     */     public static final int FORMAT_CHANGED = 8;
        /*     */     public static final int ANIMATION_CHANGED = 16;
        /*     */     public static final int DIM_AMOUNT_CHANGED = 32;
        /*     */     public static final int TITLE_CHANGED = 64;
        /*     */     public static final int ALPHA_CHANGED = 128;
        /*     */     public static final int MEMORY_TYPE_CHANGED = 256;
        /*     */     public static final int SOFT_INPUT_MODE_CHANGED = 512;
        /*     */     public static final int SCREEN_ORIENTATION_CHANGED = 1024;
        /*     */     public static final int SCREEN_BRIGHTNESS_CHANGED = 2048;
/*     */
    }

    /*     */
/*     */
    public abstract void removeViewImmediate(View paramView);
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/WindowManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */