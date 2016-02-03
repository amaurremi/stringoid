/*    */
package android.media;
/*    */ 
/*    */

import android.os.Handler;

/*    */
/*    */ public class AudioTrack {
    public static final int PLAYSTATE_STOPPED = 1;
    /*    */   public static final int PLAYSTATE_PAUSED = 2;
    /*    */   public static final int PLAYSTATE_PLAYING = 3;

    /*    */
/*  9 */
    public AudioTrack(int streamType, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes, int mode) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public AudioTrack(int streamType, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes, int mode, int sessionId) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void release() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static float getMinVolume() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static float getMaxVolume() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getSampleRate() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getPlaybackRate() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getAudioFormat() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getStreamType() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getChannelConfiguration() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getChannelCount() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getState() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getPlayState() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected int getNativeFrameCount() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getNotificationMarkerPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getPositionNotificationPeriod() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getPlaybackHeadPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public static int getNativeOutputSampleRate(int streamType) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public static int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getAudioSessionId() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener listener, Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int setStereoVolume(float leftVolume, float rightVolume) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int setPlaybackRate(int sampleRateInHz) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int setNotificationMarkerPosition(int markerInFrames) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int setPositionNotificationPeriod(int periodInFrames) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public int setPlaybackHeadPosition(int positionInFrames) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public int setLoopPoints(int startInFrames, int endInFrames, int loopCount) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected void setState(int state) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void play() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void stop() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void pause() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public int write(byte[] audioData, int offsetInBytes, int sizeInBytes) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public int write(short[] audioData, int offsetInShorts, int sizeInShorts) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public int reloadStaticData() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public int attachAuxEffect(int effectId) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public int setAuxEffectSendLevel(float level) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int MODE_STATIC = 0;
    /*    */   public static final int MODE_STREAM = 1;
    /*    */   public static final int STATE_UNINITIALIZED = 0;
    /*    */   public static final int STATE_INITIALIZED = 1;
    /*    */   public static final int STATE_NO_STATIC_DATA = 2;
    /*    */   public static final int SUCCESS = 0;
    /*    */   public static final int ERROR = -1;
    /*    */   public static final int ERROR_BAD_VALUE = -2;
    /*    */   public static final int ERROR_INVALID_OPERATION = -3;

    /*    */   public static abstract interface OnPlaybackPositionUpdateListener
/*    */ {
        /*    */
        public abstract void onMarkerReached(AudioTrack paramAudioTrack);

        /*    */
/*    */
        public abstract void onPeriodicNotification(AudioTrack paramAudioTrack);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/AudioTrack.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */