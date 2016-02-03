/*    */
package android.media;
/*    */

import android.net.Uri;

/*    */
/*  4 */ public class RingtoneManager {
    public RingtoneManager(android.app.Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public RingtoneManager(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setType(int type) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int inferStreamType() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setStopPreviousRingtone(boolean stopPreviousRingtone) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public boolean getStopPreviousRingtone() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void stopPreviousRingtone() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean getIncludeDrm() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setIncludeDrm(boolean includeDrm) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public android.database.Cursor getCursor() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public Ringtone getRingtone(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public Uri getRingtoneUri(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getRingtonePosition(Uri ringtoneUri) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static Uri getValidRingtoneUri(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static Ringtone getRingtone(android.content.Context context, Uri ringtoneUri) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static Uri getActualDefaultRingtoneUri(android.content.Context context, int type) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static void setActualDefaultRingtoneUri(android.content.Context context, int type, Uri ringtoneUri) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static boolean isDefault(Uri ringtoneUri) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static int getDefaultType(Uri defaultRingtoneUri) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static Uri getDefaultUri(int type) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int TYPE_RINGTONE = 1;
    /*    */   public static final int TYPE_NOTIFICATION = 2;
    /*    */   public static final int TYPE_ALARM = 4;
    /*    */   public static final int TYPE_ALL = 7;
    /*    */   public static final String ACTION_RINGTONE_PICKER = "android.intent.action.RINGTONE_PICKER";
    /*    */   public static final String EXTRA_RINGTONE_SHOW_DEFAULT = "android.intent.extra.ringtone.SHOW_DEFAULT";
    /*    */   public static final String EXTRA_RINGTONE_SHOW_SILENT = "android.intent.extra.ringtone.SHOW_SILENT";
    /*    */   public static final String EXTRA_RINGTONE_INCLUDE_DRM = "android.intent.extra.ringtone.INCLUDE_DRM";
    /*    */   public static final String EXTRA_RINGTONE_EXISTING_URI = "android.intent.extra.ringtone.EXISTING_URI";
    /*    */   public static final String EXTRA_RINGTONE_DEFAULT_URI = "android.intent.extra.ringtone.DEFAULT_URI";
    /*    */   public static final String EXTRA_RINGTONE_TYPE = "android.intent.extra.ringtone.TYPE";
    /*    */   public static final String EXTRA_RINGTONE_TITLE = "android.intent.extra.ringtone.TITLE";
    /*    */   public static final String EXTRA_RINGTONE_PICKED_URI = "android.intent.extra.ringtone.PICKED_URI";
    /*    */   public static final int ID_COLUMN_INDEX = 0;
    /*    */   public static final int TITLE_COLUMN_INDEX = 1;
    /*    */   public static final int URI_COLUMN_INDEX = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/RingtoneManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */