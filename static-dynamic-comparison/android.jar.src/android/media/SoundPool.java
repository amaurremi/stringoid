/*    */
package android.media;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ 
/*    */ public class SoundPool
/*    */ {
    /*  8 */
    public SoundPool(int maxStreams, int streamType, int srcQuality) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int load(String path, int priority) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int load(Context context, int resId, int priority) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int load(android.content.res.AssetFileDescriptor afd, int priority) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int load(java.io.FileDescriptor fd, long offset, long length, int priority) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public final native boolean unload(int paramInt);

    /*    */
    public final native int play(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3);

    /*    */
    public final native void pause(int paramInt);

    /*    */
    public final native void resume(int paramInt);

    /*    */
    public final native void autoPause();

    /*    */
    public final native void autoResume();

    /*    */
    public final native void stop(int paramInt);

    /*    */
    public final native void setVolume(int paramInt, float paramFloat1, float paramFloat2);

    /*    */
    public final native void setPriority(int paramInt1, int paramInt2);

    /*    */
    public final native void setLoop(int paramInt1, int paramInt2);

    /*    */
    public final native void setRate(int paramInt, float paramFloat);

    /* 24 */
    public void setOnLoadCompleteListener(OnLoadCompleteListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public final native void release();

    /* 26 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnLoadCompleteListener
/*    */ {
        /*    */
        public abstract void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/SoundPool.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */