/*    */
package android.os;
/*    */ 
/*    */

import java.util.UUID;

/*    */
/*  5 */ public final class ParcelUuid implements Parcelable {
    public ParcelUuid(UUID uuid) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static ParcelUuid fromString(String uuid) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public UUID getUuid() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean equals(Object object) {
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

    /*    */
/* 14 */   public static final Parcelable.Creator<ParcelUuid> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/ParcelUuid.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */