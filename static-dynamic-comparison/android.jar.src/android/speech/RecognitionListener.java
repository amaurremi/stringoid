package android.speech;

import android.os.Bundle;

public abstract interface RecognitionListener {
    public abstract void onReadyForSpeech(Bundle paramBundle);

    public abstract void onBeginningOfSpeech();

    public abstract void onRmsChanged(float paramFloat);

    public abstract void onBufferReceived(byte[] paramArrayOfByte);

    public abstract void onEndOfSpeech();

    public abstract void onError(int paramInt);

    public abstract void onResults(Bundle paramBundle);

    public abstract void onPartialResults(Bundle paramBundle);

    public abstract void onEvent(int paramInt, Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/speech/RecognitionListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */