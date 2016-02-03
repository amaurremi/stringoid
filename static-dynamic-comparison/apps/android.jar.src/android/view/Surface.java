/*    */
package android.view;
/*    */ 
/*    */

import android.graphics.Canvas;

/*    */
/*    */ public class Surface implements android.os.Parcelable {
    public static final int ROTATION_0 = 0;
    /*    */   public static final int ROTATION_90 = 1;

    /*    */
/*  8 */   public static class OutOfResourcesException extends Exception {
        public OutOfResourcesException() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public OutOfResourcesException(String name) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 11 */
    public Surface(android.graphics.SurfaceTexture surfaceTexture) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native boolean isValid();

    /*    */
    public native void release();

    /* 14 */
    public Canvas lockCanvas(android.graphics.Rect dirty) throws Surface.OutOfResourcesException, IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void unlockCanvasAndPost(Canvas paramCanvas);

    /*    */
    public native void unlockCanvas(Canvas paramCanvas);

    /* 17 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void readFromParcel(android.os.Parcel paramParcel);

    /*    */
    public native void writeToParcel(android.os.Parcel paramParcel, int paramInt);

    /* 21 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public static final int ROTATION_180 = 2;
    /*    */
/*    */   public static final int ROTATION_270 = 3;
    /* 27 */   public static final android.os.Parcelable.Creator<Surface> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/Surface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */