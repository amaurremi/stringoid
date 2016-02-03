/*   */
package android.media;

/*   */
/*   */ public class MediaSyncEvent {
    /* 4 */   MediaSyncEvent() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public static MediaSyncEvent createEvent(int eventType) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public MediaSyncEvent setAudioSessionId(int audioSessionId) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public int getType() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public int getAudioSessionId() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int SYNC_EVENT_NONE = 0;
    /*   */   public static final int SYNC_EVENT_PRESENTATION_COMPLETE = 1;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/MediaSyncEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */