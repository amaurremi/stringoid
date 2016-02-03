package mobi.ifunny.video;

public abstract class b {
    protected int codecPtr;
    protected String filename;
    protected final int[] metaData;

    protected b(String paramString) {
        this.filename = paramString;
        this.metaData = createMetadata();
    }

    public abstract int[] allocBuffer();

    public int[] createMetadata() {
        return new int[2];
    }

    public abstract boolean decodeCurrentFrame(long paramLong);

    public abstract void destroyCodec();

    public abstract boolean getBuffer(int[] paramArrayOfInt);

    public abstract long getCurrentFrameTimeStamp();

    public int getHeight() {
        return this.metaData[1];
    }

    public int getWidth() {
        return this.metaData[0];
    }

    public abstract boolean openFile();

    public abstract boolean readFrame();

    public abstract boolean readFrameLooped();

    public abstract void resetCodec();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */