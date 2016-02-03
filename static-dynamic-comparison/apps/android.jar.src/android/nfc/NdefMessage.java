/*    */
package android.nfc;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public final class NdefMessage implements android.os.Parcelable {
    public NdefMessage(byte[] data) throws FormatException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public NdefMessage(NdefRecord record, NdefRecord... records) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public NdefMessage(NdefRecord[] records) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public NdefRecord[] getRecords() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getByteArrayLength() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public byte[] toByteArray() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 17 */   public static final android.os.Parcelable.Creator<NdefMessage> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/NdefMessage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */