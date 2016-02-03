/*    */
package android.content.pm;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class Signature implements android.os.Parcelable {
    public Signature(byte[] signature) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Signature(String text) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public char[] toChars() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public char[] toChars(char[] existingArray, int[] outLen) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String toCharsString() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public byte[] toByteArray() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 16 */   public static final android.os.Parcelable.Creator<Signature> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/pm/Signature.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */