/*    */
package android.speech.tts;
/*    */ 
/*    */

import android.content.Intent;

/*    */
/*  5 */ public abstract class TextToSpeechService extends android.app.Service {
    public TextToSpeechService() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    protected abstract int onIsLanguageAvailable(String paramString1, String paramString2, String paramString3);

    /*    */
    protected abstract String[] onGetLanguage();

    /*    */
    protected abstract int onLoadLanguage(String paramString1, String paramString2, String paramString3);

    /*    */
    protected abstract void onStop();

    /*    */
    protected abstract void onSynthesizeText(SynthesisRequest paramSynthesisRequest, SynthesisCallback paramSynthesisCallback);

    /* 13 */
    protected java.util.Set<String> onGetFeaturesForLanguage(String lang, String country, String variant) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public android.os.IBinder onBind(Intent intent) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/speech/tts/TextToSpeechService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */