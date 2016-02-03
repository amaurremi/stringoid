/*    */
package android.app;
/*    */ 
/*    */

import android.content.Intent;

/*    */
/*    */ public final class PendingIntent implements android.os.Parcelable {
    public static abstract interface OnFinished {
        public abstract void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, android.os.Bundle paramBundle);
/*    */
    }

    /*    */
/*  8 */   public static class CanceledException extends android.util.AndroidException {
        public CanceledException() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public CanceledException(String name) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public CanceledException(Exception cause) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static final int FLAG_ONE_SHOT = 1073741824;
    /*    */   public static final int FLAG_NO_CREATE = 536870912;

    /*    */   PendingIntent() {
/* 16 */
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static PendingIntent getActivity(android.content.Context context, int requestCode, Intent intent, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static PendingIntent getActivity(android.content.Context context, int requestCode, Intent intent, int flags, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static PendingIntent getActivities(android.content.Context context, int requestCode, Intent[] intents, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static PendingIntent getActivities(android.content.Context context, int requestCode, Intent[] intents, int flags, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static PendingIntent getBroadcast(android.content.Context context, int requestCode, Intent intent, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static PendingIntent getService(android.content.Context context, int requestCode, Intent intent, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public android.content.IntentSender getIntentSender() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void send() throws PendingIntent.CanceledException {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void send(int code) throws PendingIntent.CanceledException {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void send(android.content.Context context, int code, Intent intent) throws PendingIntent.CanceledException {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void send(int code, OnFinished onFinished, android.os.Handler handler) throws PendingIntent.CanceledException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void send(android.content.Context context, int code, Intent intent, OnFinished onFinished, android.os.Handler handler) throws PendingIntent.CanceledException {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void send(android.content.Context context, int code, Intent intent, OnFinished onFinished, android.os.Handler handler, String requiredPermission) throws PendingIntent.CanceledException {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public String getTargetPackage() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean equals(Object otherObj) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void writeToParcel(android.os.Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public static void writePendingIntentOrNullToParcel(PendingIntent sender, android.os.Parcel out) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public static PendingIntent readPendingIntentOrNullFromParcel(android.os.Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public static final int FLAG_CANCEL_CURRENT = 268435456;
    /*    */
/*    */   public static final int FLAG_UPDATE_CURRENT = 134217728;
    /* 44 */   public static final android.os.Parcelable.Creator<PendingIntent> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/PendingIntent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */