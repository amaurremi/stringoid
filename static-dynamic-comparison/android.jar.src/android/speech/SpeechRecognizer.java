/*    */
package android.speech;
/*    */

import android.content.Context;

/*    */
/*  4 */ public class SpeechRecognizer {
    SpeechRecognizer() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static boolean isRecognitionAvailable(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static SpeechRecognizer createSpeechRecognizer(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static SpeechRecognizer createSpeechRecognizer(Context context, android.content.ComponentName serviceComponent) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setRecognitionListener(RecognitionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void startListening(android.content.Intent recognizerIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void stopListening() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void destroy() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String RESULTS_RECOGNITION = "results_recognition";
    /*    */   public static final String CONFIDENCE_SCORES = "confidence_scores";
    /*    */   public static final int ERROR_NETWORK_TIMEOUT = 1;
    /*    */   public static final int ERROR_NETWORK = 2;
    /*    */   public static final int ERROR_AUDIO = 3;
    /*    */   public static final int ERROR_SERVER = 4;
    /*    */   public static final int ERROR_CLIENT = 5;
    /*    */   public static final int ERROR_SPEECH_TIMEOUT = 6;
    /*    */   public static final int ERROR_NO_MATCH = 7;
    /*    */   public static final int ERROR_RECOGNIZER_BUSY = 8;
    /*    */   public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/speech/SpeechRecognizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */