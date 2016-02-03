/*    */
package android.view;
/*    */ 
/*    */

import android.os.Parcelable;

/*    */
/*  5 */ public abstract class AbsSavedState implements Parcelable {
    protected AbsSavedState(Parcelable superState) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected AbsSavedState(android.os.Parcel source) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public final Parcelable getSuperState() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/* 12 */   public static final android.os.Parcelable.Creator<AbsSavedState> CREATOR = null;
    public static final AbsSavedState EMPTY_STATE = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/AbsSavedState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */