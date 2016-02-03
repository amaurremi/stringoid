package mobi.ifunny.video.encode;

public class GifEncoder {
    private int a;

    static {
        System.loadLibrary("gifflen");
    }

    public GifEncoder(String paramString, int paramInt1, int paramInt2, int paramInt3) {
        this(paramString, paramInt1, paramInt2, 256, paramInt3, 4, 1.0F);
    }

    public GifEncoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {
        this.a = init(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat);
        if (this.a <= 0) {
            throw new IllegalStateException();
        }
    }

    private native int addFrame(int paramInt, int[] paramArrayOfInt);

    private native int addFrameWithCaption(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3);

    private native boolean close(int paramInt, boolean paramBoolean);

    private native int init(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat);

    private native void setColorsCount(int paramInt1, int paramInt2);

    private native void setDelay(int paramInt, long paramLong);

    private native void setTimeScale(int paramInt, float paramFloat);

    public void a(float paramFloat) {
        setTimeScale(this.a, paramFloat);
    }

    public void a(int paramInt) {
        setColorsCount(this.a, paramInt);
    }

    public void a(long paramLong) {
        setDelay(this.a, paramLong);
    }

    public void a(boolean paramBoolean) {
        if (this.a <= 0) {
            return;
        }
        close(this.a, paramBoolean);
        this.a = 0;
    }

    public void a(int[] paramArrayOfInt) {
        addFrame(this.a, paramArrayOfInt);
    }

    public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        addFrameWithCaption(this.a, paramArrayOfInt1, paramArrayOfInt1.length, paramArrayOfInt2, paramArrayOfInt2.length);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/encode/GifEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */