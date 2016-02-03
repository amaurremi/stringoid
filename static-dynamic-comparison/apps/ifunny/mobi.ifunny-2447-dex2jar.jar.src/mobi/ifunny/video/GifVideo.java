package mobi.ifunny.video;

import android.graphics.Rect;

public class GifVideo
        extends b {
    private static boolean libraryLoaded;
    private Rect cropRect;

    static {
        try {
            System.loadLibrary("gifJNI");
            libraryLoaded = true;
            return;
        } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
            libraryLoaded = false;
        }
    }

    public GifVideo(String paramString, Rect paramRect) {
        super(paramString);
        if (!libraryLoaded) {
            throw new UnsatisfiedLinkError();
        }
        if (paramRect == null) {
            this.cropRect = new Rect();
            this.cropRect.setEmpty();
            return;
        }
        this.cropRect = new Rect(paramRect);
    }

    private native boolean decodeCurrentFrame(int paramInt, long paramLong);

    private native void destroyCodec(int paramInt);

    private native boolean getBuffer(int paramInt, int[] paramArrayOfInt);

    private native int getCurrentDispose(int paramInt);

    private native int getCurrentFrameColorsCount(int paramInt);

    private native long getCurrentFrameDuration(int paramInt);

    private native long getCurrentFrameTimeStamp(int paramInt);

    private native int openFile(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);

    private native boolean readFrame(int paramInt);

    private native boolean readFrameLooped(int paramInt);

    private native void resetCodec(int paramInt);

    public int[] allocBuffer() {
        return new int[getWidth() * getHeight()];
    }

    public int[] createMetadata() {
        return new int[3];
    }

    public boolean decodeCurrentFrame(long paramLong) {
        return decodeCurrentFrame(this.codecPtr, paramLong);
    }

    public void destroyCodec() {
        destroyCodec(this.codecPtr);
    }

    public boolean getBuffer(int[] paramArrayOfInt) {
        return getBuffer(this.codecPtr, paramArrayOfInt);
    }

    public int getCurrentDispose() {
        return getCurrentDispose(this.codecPtr);
    }

    public int getCurrentFrameColorsCount() {
        return getCurrentFrameColorsCount(this.codecPtr);
    }

    public long getCurrentFrameDuration() {
        return getCurrentFrameDuration(this.codecPtr);
    }

    public long getCurrentFrameTimeStamp() {
        return getCurrentFrameTimeStamp(this.codecPtr);
    }

    public int getFrameCount() {
        return this.metaData[2];
    }

    public boolean openFile() {
        this.codecPtr = openFile(this.filename, this.cropRect.left, this.cropRect.right, this.cropRect.top, this.cropRect.bottom, this.metaData);
        return this.codecPtr != 0;
    }

    public boolean readFrame() {
        return readFrame(this.codecPtr);
    }

    public boolean readFrameLooped() {
        return readFrameLooped(this.codecPtr);
    }

    public void resetCodec() {
        resetCodec(this.codecPtr);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/GifVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */