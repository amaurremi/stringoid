/*    */
package android.media;
/*    */ 
/*    */

import java.nio.ByteBuffer;

/*    */
/*    */ public class AudioRecord {
    /*    */   public static final int STATE_UNINITIALIZED = 0;
    /*    */   public static final int STATE_INITIALIZED = 1;

    /*    */
/*  9 */
    public AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void release() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getSampleRate() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getAudioSource() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getAudioFormat() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getChannelConfiguration() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getChannelCount() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getState() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getRecordingState() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getNotificationMarkerPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getPositionNotificationPeriod() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getAudioSessionId() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void startRecording() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void startRecording(MediaSyncEvent syncEvent) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void stop() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int read(byte[] audioData, int offsetInBytes, int sizeInBytes) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int read(short[] audioData, int offsetInShorts, int sizeInShorts) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public int read(ByteBuffer audioBuffer, int sizeInBytes) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener listener, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public int setNotificationMarkerPosition(int markerInFrames) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int setPositionNotificationPeriod(int periodInFrames) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int RECORDSTATE_STOPPED = 1;
    /*    */   public static final int RECORDSTATE_RECORDING = 3;
    /*    */   public static final int SUCCESS = 0;
    /*    */   public static final int ERROR = -1;
    /*    */   public static final int ERROR_BAD_VALUE = -2;
    /*    */   public static final int ERROR_INVALID_OPERATION = -3;

    /*    */   public static abstract interface OnRecordPositionUpdateListener
/*    */ {
        /*    */
        public abstract void onMarkerReached(AudioRecord paramAudioRecord);

        /*    */
/*    */
        public abstract void onPeriodicNotification(AudioRecord paramAudioRecord);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/AudioRecord.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */