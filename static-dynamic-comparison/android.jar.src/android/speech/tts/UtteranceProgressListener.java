/*   */
package android.speech.tts;

/*   */
/*   */ public abstract class UtteranceProgressListener {
    /* 4 */
    public UtteranceProgressListener() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public abstract void onStart(String paramString);

    /*   */
/*   */
    public abstract void onDone(String paramString);

    /*   */
/*   */
    public abstract void onError(String paramString);
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/speech/tts/UtteranceProgressListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */