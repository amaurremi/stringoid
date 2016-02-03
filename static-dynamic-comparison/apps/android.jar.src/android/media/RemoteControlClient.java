/*    */
package android.media;
/*    */ 
/*    */

import android.app.PendingIntent;

/*    */
/*    */ public class RemoteControlClient {
    public class MetadataEditor {
        public static final int BITMAP_KEY_ARTWORK = 100;

        /*  6 */     MetadataEditor() {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public synchronized MetadataEditor putString(int key, String value) throws IllegalArgumentException {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public synchronized MetadataEditor putLong(int key, long value) throws IllegalArgumentException {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public synchronized MetadataEditor putBitmap(int key, android.graphics.Bitmap bitmap) throws IllegalArgumentException {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public synchronized void clear() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public synchronized void apply() {
            throw new RuntimeException("Stub!");
        }
/*    */     
/*    */
    }

    /* 14 */
    public RemoteControlClient(PendingIntent mediaButtonIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public RemoteControlClient(PendingIntent mediaButtonIntent, android.os.Looper looper) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public MetadataEditor editMetadata(boolean startEmpty) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setPlaybackState(int state) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setTransportControlFlags(int transportControlFlags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int PLAYSTATE_STOPPED = 1;
    /*    */   public static final int PLAYSTATE_PAUSED = 2;
    /*    */   public static final int PLAYSTATE_PLAYING = 3;
    /*    */   public static final int PLAYSTATE_FAST_FORWARDING = 4;
    /*    */   public static final int PLAYSTATE_REWINDING = 5;
    /*    */   public static final int PLAYSTATE_SKIPPING_FORWARDS = 6;
    /*    */   public static final int PLAYSTATE_SKIPPING_BACKWARDS = 7;
    /*    */   public static final int PLAYSTATE_BUFFERING = 8;
    /*    */   public static final int PLAYSTATE_ERROR = 9;
    /*    */   public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    /*    */   public static final int FLAG_KEY_MEDIA_REWIND = 2;
    /*    */   public static final int FLAG_KEY_MEDIA_PLAY = 4;
    /*    */   public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    /*    */   public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    /*    */   public static final int FLAG_KEY_MEDIA_STOP = 32;
    /*    */   public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    /*    */   public static final int FLAG_KEY_MEDIA_NEXT = 128;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/RemoteControlClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */