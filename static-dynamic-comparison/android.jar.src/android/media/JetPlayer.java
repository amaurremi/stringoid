/*    */
package android.media;
/*    */ 
/*    */

import android.content.res.AssetFileDescriptor;
/*    */ import android.os.Handler;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JetPlayer
/*    */ {
    /* 11 */   JetPlayer() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static JetPlayer getJetPlayer() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void release() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static int getMaxTracks() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean loadJetFile(String path) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean loadJetFile(AssetFileDescriptor afd) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean closeJetFile() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean play() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean pause() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean queueJetSegment(int segmentNum, int libNum, int repeatCount, int transpose, int muteFlags, byte userID) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean queueJetSegmentMuteArray(int segmentNum, int libNum, int repeatCount, int transpose, boolean[] muteArray, byte userID) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean setMuteFlags(int muteFlags, boolean sync) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean setMuteArray(boolean[] muteArray, boolean sync) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean setMuteFlag(int trackId, boolean muteFlag, boolean sync) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean triggerClip(int clipId) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean clearQueue() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setEventListener(OnJetEventListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setEventListener(OnJetEventListener listener, Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnJetEventListener
/*    */ {
        /*    */
        public abstract void onJetEvent(JetPlayer paramJetPlayer, short paramShort, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);

        /*    */
/*    */
        public abstract void onJetUserIdUpdate(JetPlayer paramJetPlayer, int paramInt1, int paramInt2);

        /*    */
/*    */
        public abstract void onJetNumQueuedSegmentUpdate(JetPlayer paramJetPlayer, int paramInt);

        /*    */
/*    */
        public abstract void onJetPauseUpdate(JetPlayer paramJetPlayer, int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/JetPlayer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */