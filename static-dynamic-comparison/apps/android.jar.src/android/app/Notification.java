/*     */
package android.app;
/*     */ 
/*     */

import android.widget.RemoteViews;

/*     */
/*     */ public class Notification implements android.os.Parcelable {
    public static final int DEFAULT_ALL = -1;

    /*     */
/*   7 */   public static class Builder {
        public Builder(android.content.Context context) {
            throw new RuntimeException("Stub!");
        }

        /*   8 */
        public Builder setWhen(long when) {
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public Builder setUsesChronometer(boolean b) {
            throw new RuntimeException("Stub!");
        }

        /*  10 */
        public Builder setSmallIcon(int icon) {
            throw new RuntimeException("Stub!");
        }

        /*  11 */
        public Builder setSmallIcon(int icon, int level) {
            throw new RuntimeException("Stub!");
        }

        /*  12 */
        public Builder setContentTitle(CharSequence title) {
            throw new RuntimeException("Stub!");
        }

        /*  13 */
        public Builder setContentText(CharSequence text) {
            throw new RuntimeException("Stub!");
        }

        /*  14 */
        public Builder setSubText(CharSequence text) {
            throw new RuntimeException("Stub!");
        }

        /*  15 */
        public Builder setNumber(int number) {
            throw new RuntimeException("Stub!");
        }

        /*  16 */
        public Builder setContentInfo(CharSequence info) {
            throw new RuntimeException("Stub!");
        }

        /*  17 */
        public Builder setProgress(int max, int progress, boolean indeterminate) {
            throw new RuntimeException("Stub!");
        }

        /*  18 */
        public Builder setContent(RemoteViews views) {
            throw new RuntimeException("Stub!");
        }

        /*  19 */
        public Builder setContentIntent(PendingIntent intent) {
            throw new RuntimeException("Stub!");
        }

        /*  20 */
        public Builder setDeleteIntent(PendingIntent intent) {
            throw new RuntimeException("Stub!");
        }

        /*  21 */
        public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            throw new RuntimeException("Stub!");
        }

        /*  22 */
        public Builder setTicker(CharSequence tickerText) {
            throw new RuntimeException("Stub!");
        }

        /*  23 */
        public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            throw new RuntimeException("Stub!");
        }

        /*  24 */
        public Builder setLargeIcon(android.graphics.Bitmap icon) {
            throw new RuntimeException("Stub!");
        }

        /*  25 */
        public Builder setSound(android.net.Uri sound) {
            throw new RuntimeException("Stub!");
        }

        /*  26 */
        public Builder setSound(android.net.Uri sound, int streamType) {
            throw new RuntimeException("Stub!");
        }

        /*  27 */
        public Builder setVibrate(long[] pattern) {
            throw new RuntimeException("Stub!");
        }

        /*  28 */
        public Builder setLights(int argb, int onMs, int offMs) {
            throw new RuntimeException("Stub!");
        }

        /*  29 */
        public Builder setOngoing(boolean ongoing) {
            throw new RuntimeException("Stub!");
        }

        /*  30 */
        public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            throw new RuntimeException("Stub!");
        }

        /*  31 */
        public Builder setAutoCancel(boolean autoCancel) {
            throw new RuntimeException("Stub!");
        }

        /*  32 */
        public Builder setDefaults(int defaults) {
            throw new RuntimeException("Stub!");
        }

        /*  33 */
        public Builder setPriority(int pri) {
            throw new RuntimeException("Stub!");
        }

        /*  34 */
        public Builder addAction(int icon, CharSequence title, PendingIntent intent) {
            throw new RuntimeException("Stub!");
        }

        /*  35 */
        public Builder setStyle(Notification.Style style) {
            throw new RuntimeException("Stub!");
        }

        /*     */
        @Deprecated
/*  37 */ public Notification getNotification() {
            throw new RuntimeException("Stub!");
        }

        /*  38 */
        public Notification build() {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*     */   public static abstract class Style {
        protected Notification.Builder mBuilder;

        /*     */
/*  42 */
        public Style() {
            throw new RuntimeException("Stub!");
        }

        /*  43 */
        protected void internalSetBigContentTitle(CharSequence title) {
            throw new RuntimeException("Stub!");
        }

        /*  44 */
        protected void internalSetSummaryText(CharSequence cs) {
            throw new RuntimeException("Stub!");
        }

        /*  45 */
        public void setBuilder(Notification.Builder builder) {
            throw new RuntimeException("Stub!");
        }

        /*  46 */
        protected void checkBuilder() {
            throw new RuntimeException("Stub!");
        }

        /*  47 */
        protected RemoteViews getStandardView(int layoutId) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */
        public abstract Notification build();
/*     */
    }

    /*     */
/*     */   public static class BigPictureStyle
/*     */ extends Notification.Style {
        /*  54 */
        public BigPictureStyle() {
            throw new RuntimeException("Stub!");
        }

        /*  55 */
        public BigPictureStyle(Notification.Builder builder) {
            throw new RuntimeException("Stub!");
        }

        /*  56 */
        public BigPictureStyle setBigContentTitle(CharSequence title) {
            throw new RuntimeException("Stub!");
        }

        /*  57 */
        public BigPictureStyle setSummaryText(CharSequence cs) {
            throw new RuntimeException("Stub!");
        }

        /*  58 */
        public BigPictureStyle bigPicture(android.graphics.Bitmap b) {
            throw new RuntimeException("Stub!");
        }

        /*  59 */
        public BigPictureStyle bigLargeIcon(android.graphics.Bitmap b) {
            throw new RuntimeException("Stub!");
        }

        /*  60 */
        public Notification build() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static class BigTextStyle
/*     */ extends Notification.Style {
        /*  65 */
        public BigTextStyle() {
            throw new RuntimeException("Stub!");
        }

        /*  66 */
        public BigTextStyle(Notification.Builder builder) {
            throw new RuntimeException("Stub!");
        }

        /*  67 */
        public BigTextStyle setBigContentTitle(CharSequence title) {
            throw new RuntimeException("Stub!");
        }

        /*  68 */
        public BigTextStyle setSummaryText(CharSequence cs) {
            throw new RuntimeException("Stub!");
        }

        /*  69 */
        public BigTextStyle bigText(CharSequence cs) {
            throw new RuntimeException("Stub!");
        }

        /*  70 */
        public Notification build() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static class InboxStyle
/*     */ extends Notification.Style {
        /*  75 */
        public InboxStyle() {
            throw new RuntimeException("Stub!");
        }

        /*  76 */
        public InboxStyle(Notification.Builder builder) {
            throw new RuntimeException("Stub!");
        }

        /*  77 */
        public InboxStyle setBigContentTitle(CharSequence title) {
            throw new RuntimeException("Stub!");
        }

        /*  78 */
        public InboxStyle setSummaryText(CharSequence cs) {
            throw new RuntimeException("Stub!");
        }

        /*  79 */
        public InboxStyle addLine(CharSequence cs) {
            throw new RuntimeException("Stub!");
        }

        /*  80 */
        public Notification build() {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*  82 */
    public Notification() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  84 */ public Notification(int icon, CharSequence tickerText, long when) {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public Notification(android.os.Parcel parcel) {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public Notification clone() {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public void writeToParcel(android.os.Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  90 */ public void setLatestEventInfo(android.content.Context context, CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent) {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */   public static final int DEFAULT_SOUND = 1;
    /*     */   public static final int DEFAULT_VIBRATE = 2;
    /*     */   public static final int DEFAULT_LIGHTS = 4;
    /*     */   public long when;
    /*     */   public int icon;
    /*     */   public int iconLevel;
    /*     */   public int number;
    /*     */   public PendingIntent contentIntent;
    /*     */   public PendingIntent deleteIntent;
    /*     */   public PendingIntent fullScreenIntent;
    /*     */   public CharSequence tickerText;
    /*     */   public RemoteViews tickerView;
    /*     */   public RemoteViews contentView;
    /*     */   public RemoteViews bigContentView;
    /*     */   public android.graphics.Bitmap largeIcon;
    /*     */   public android.net.Uri sound;
    /*     */   public static final int STREAM_DEFAULT = -1;
    /*     */   public int audioStreamType;
    /* 111 */   public long[] vibrate = null;
    /*     */
/*     */   public int ledARGB;
    /*     */   public int ledOnMS;
    /*     */   public int ledOffMS;
    /*     */   public int defaults;
    /*     */   public static final int FLAG_SHOW_LIGHTS = 1;
    /*     */   public static final int FLAG_ONGOING_EVENT = 2;
    /*     */   public static final int FLAG_INSISTENT = 4;
    /*     */   public static final int FLAG_ONLY_ALERT_ONCE = 8;
    /*     */   public static final int FLAG_AUTO_CANCEL = 16;
    /*     */   public static final int FLAG_NO_CLEAR = 32;
    /*     */   public static final int FLAG_FOREGROUND_SERVICE = 64;
    /*     */
    @Deprecated
/*     */ public static final int FLAG_HIGH_PRIORITY = 128;
    /*     */   public int flags;
    /*     */   public static final int PRIORITY_DEFAULT = 0;
    /*     */   public static final int PRIORITY_LOW = -1;
    /*     */   public static final int PRIORITY_MIN = -2;
    /*     */   public static final int PRIORITY_HIGH = 1;
    /*     */   public static final int PRIORITY_MAX = 2;
    /*     */   public int priority;
    /* 133 */   public static final android.os.Parcelable.Creator<Notification> CREATOR = null;
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/Notification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */