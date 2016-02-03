/*    */
package android.media;
/*    */

import java.io.FileDescriptor;

/*    */
/*  4 */ public final class MediaExtractor {
    public MediaExtractor() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public final void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<String, String> headers) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public final void setDataSource(String path, java.util.Map<String, String> headers) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public final void setDataSource(String path) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public final void setDataSource(FileDescriptor fd) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public final native void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);

    /* 10 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public final native void release();

    /*    */
    public final native int getTrackCount();

    /* 13 */
    public MediaFormat getTrackFormat(int index) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int SEEK_TO_PREVIOUS_SYNC = 0;
    /*    */   public static final int SEEK_TO_NEXT_SYNC = 1;
    /*    */   public static final int SEEK_TO_CLOSEST_SYNC = 2;
    /*    */   public static final int SAMPLE_FLAG_SYNC = 1;
    /*    */   public static final int SAMPLE_FLAG_ENCRYPTED = 2;

    /*    */
    public native void selectTrack(int paramInt);

    /*    */
/*    */
    public native void unselectTrack(int paramInt);

    /*    */
/*    */
    public native void seekTo(long paramLong, int paramInt);

    /*    */
/*    */
    public native boolean advance();

    /*    */
/*    */
    public native int readSampleData(java.nio.ByteBuffer paramByteBuffer, int paramInt);

    /*    */
/*    */
    public native int getSampleTrackIndex();

    /*    */
/*    */
    public native long getSampleTime();

    /*    */
/*    */
    public native int getSampleFlags();

    /*    */
/*    */
    public native boolean getSampleCryptoInfo(MediaCodec.CryptoInfo paramCryptoInfo);

    /*    */
/*    */
    public native long getCachedDuration();

    /*    */
/*    */
    public native boolean hasCacheReachedEndOfStream();
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/MediaExtractor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */