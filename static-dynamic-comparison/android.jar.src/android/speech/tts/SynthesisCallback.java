package android.speech.tts;

public abstract interface SynthesisCallback {
    public abstract int getMaxBufferSize();

    public abstract int start(int paramInt1, int paramInt2, int paramInt3);

    public abstract int audioAvailable(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

    public abstract int done();

    public abstract void error();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/speech/tts/SynthesisCallback.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */