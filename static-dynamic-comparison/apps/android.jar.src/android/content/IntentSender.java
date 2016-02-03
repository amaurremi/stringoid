/*    */
package android.content;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*    */ public class IntentSender implements android.os.Parcelable {
    public static abstract interface OnFinished {
        public abstract void onSendFinished(IntentSender paramIntentSender, Intent paramIntent, int paramInt, String paramString, android.os.Bundle paramBundle);
/*    */
    }

    /*    */
/*  8 */   public static class SendIntentException extends android.util.AndroidException {
        public SendIntentException() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public SendIntentException(String name) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public SendIntentException(Exception cause) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */ 
/*    */ 
/*    */ 
/* 16 */   IntentSender() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void sendIntent(Context context, int code, Intent intent, OnFinished onFinished, android.os.Handler handler) throws IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void sendIntent(Context context, int code, Intent intent, OnFinished onFinished, android.os.Handler handler, String requiredPermission) throws IntentSender.SendIntentException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public String getTargetPackage() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean equals(Object otherObj) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static void writeIntentSenderOrNullToParcel(IntentSender sender, Parcel out) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public static IntentSender readIntentSenderOrNullFromParcel(Parcel in) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 28 */   public static final android.os.Parcelable.Creator<IntentSender> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/IntentSender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */