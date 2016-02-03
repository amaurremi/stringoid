/*    */
package android.media;
/*    */ 
/*    */

import android.hardware.Camera;

/*    */
/*    */ public class MediaRecorder {
    /*  6 */   public final class AudioSource {
        AudioSource() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int DEFAULT = 0;
        /*    */     public static final int MIC = 1;
        /*    */     public static final int VOICE_UPLINK = 2;
        /*    */     public static final int VOICE_DOWNLINK = 3;
        /*    */     public static final int VOICE_CALL = 4;
        /*    */     public static final int CAMCORDER = 5;
        /*    */     public static final int VOICE_RECOGNITION = 6;
        /*    */     public static final int VOICE_COMMUNICATION = 7;
/*    */
    }

    /*    */
/* 18 */   public final class VideoSource {
        VideoSource() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int DEFAULT = 0;
        /*    */     public static final int CAMERA = 1;
/*    */
    }

    /*    */
/* 24 */   public final class OutputFormat {
        OutputFormat() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int DEFAULT = 0;
        /*    */     public static final int THREE_GPP = 1;
        /*    */     public static final int MPEG_4 = 2;
        /*    */
        @Deprecated
/*    */ public static final int RAW_AMR = 3;
        /*    */     public static final int AMR_NB = 3;
        /*    */     public static final int AMR_WB = 4;
        /*    */     public static final int AAC_ADTS = 6;
/*    */
    }

    /*    */
/* 36 */   public final class AudioEncoder {
        AudioEncoder() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public static final int DEFAULT = 0;
        /*    */     public static final int AMR_NB = 1;
        /*    */     public static final int AMR_WB = 2;
        /*    */     public static final int AAC = 3;
        /*    */     public static final int HE_AAC = 4;
        /*    */     public static final int AAC_ELD = 5;
/*    */
    }

    /*    */
/* 46 */   public final class VideoEncoder {
        VideoEncoder() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */     public static final int DEFAULT = 0;
        /*    */
/*    */     public static final int H263 = 1;
        /*    */     public static final int H264 = 2;
        /*    */     public static final int MPEG_4_SP = 3;
/*    */
    }

    /*    */
/*    */   public static final int MEDIA_RECORDER_ERROR_UNKNOWN = 1;
    /*    */   public static final int MEDIA_RECORDER_INFO_UNKNOWN = 1;
    /*    */   public static final int MEDIA_RECORDER_INFO_MAX_DURATION_REACHED = 800;
    /*    */   public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801;

    /* 60 */
    public MediaRecorder() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void setCamera(Camera paramCamera);

    /* 62 */
    public void setPreviewDisplay(android.view.Surface sv) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void setAudioSource(int paramInt) throws IllegalStateException;

    /* 64 */
    public static final int getAudioSourceMax() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void setVideoSource(int paramInt) throws IllegalStateException;

    /* 66 */
    public void setProfile(CamcorderProfile profile) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public void setCaptureRate(double fps) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public void setOrientationHint(int degrees) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public void setLocation(float latitude, float longitude) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void setOutputFormat(int paramInt) throws IllegalStateException;

    /*    */
    public native void setVideoSize(int paramInt1, int paramInt2) throws IllegalStateException;

    /*    */
    public native void setVideoFrameRate(int paramInt) throws IllegalStateException;

    /*    */
    public native void setMaxDuration(int paramInt) throws IllegalArgumentException;

    /*    */
    public native void setMaxFileSize(long paramLong) throws IllegalArgumentException;

    /*    */
    public native void setAudioEncoder(int paramInt) throws IllegalStateException;

    /*    */
    public native void setVideoEncoder(int paramInt) throws IllegalStateException;

    /* 77 */
    public void setAudioSamplingRate(int samplingRate) {
        throw new RuntimeException("Stub!");
    }

    /* 78 */
    public void setAudioChannels(int numChannels) {
        throw new RuntimeException("Stub!");
    }

    /* 79 */
    public void setAudioEncodingBitRate(int bitRate) {
        throw new RuntimeException("Stub!");
    }

    /* 80 */
    public void setVideoEncodingBitRate(int bitRate) {
        throw new RuntimeException("Stub!");
    }

    /* 81 */
    public void setOutputFile(java.io.FileDescriptor fd) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 82 */
    public void setOutputFile(String path) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 83 */
    public void prepare() throws IllegalStateException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void start() throws IllegalStateException;

    /*    */
    public native void stop() throws IllegalStateException;

    /* 86 */
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native int getMaxAmplitude() throws IllegalStateException;

    /* 88 */
    public void setOnErrorListener(OnErrorListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 89 */
    public void setOnInfoListener(OnInfoListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native void release();

    /* 91 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnErrorListener
/*    */ {
        /*    */
        public abstract void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnInfoListener
/*    */ {
        /*    */
        public abstract void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/MediaRecorder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */