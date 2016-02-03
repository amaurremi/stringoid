package mobi.ifunny.video;

public class WebmVideo
        extends b {
    private static boolean libraryLoaded;

    static {
        try {
            System.loadLibrary("webm");
            libraryLoaded = true;
            return;
        } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
            libraryLoaded = false;
        }
    }

    public WebmVideo(String paramString) {
        super(paramString);
        if (!libraryLoaded) {
            throw new UnsatisfiedLinkError();
        }
    }

    private native boolean decodeCurrentFrame(int paramInt, long paramLong);

    private native int destroyCodec(int paramInt);

    private native boolean getBuffer(int paramInt, int[] paramArrayOfInt);

    private native long getCurrentFrameTimeStamp(int paramInt);

    private native int openFile(String paramString, int[] paramArrayOfInt);

    private native boolean readFrame(int paramInt);

    private native boolean readFrameLooped(int paramInt);

    private native void resetCodec(int paramInt);

    public int[] allocBuffer() {
        return new int[getWidth() * getHeight()];
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

    public long getCurrentFrameTimeStamp() {
        return getCurrentFrameTimeStamp(this.codecPtr);
    }

    public boolean openFile() {
        this.codecPtr = openFile(this.filename, this.metaData);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/WebmVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */