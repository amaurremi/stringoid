/*    */
package android.speech.tts;
/*    */ 
/*    */

import java.util.HashMap;

/*    */
/*    */ public class TextToSpeech {
    public static final int SUCCESS = 0;
    /*    */   public static final int ERROR = -1;

    /*    */
/*    */   public static abstract interface OnInitListener {
        public abstract void onInit(int paramInt);
    }

    /*    */
/*    */   public static abstract interface OnUtteranceCompletedListener {
        public abstract void onUtteranceCompleted(String paramString);
    }

    /*    */
/*    */   public class Engine {
        public static final int DEFAULT_STREAM = 3;
        /*    */     public static final int CHECK_VOICE_DATA_PASS = 1;
        public static final int CHECK_VOICE_DATA_FAIL = 0;
        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        public static final String INTENT_ACTION_TTS_SERVICE = "android.intent.action.TTS_SERVICE";
        public static final String SERVICE_META_DATA = "android.speech.tts";
        public static final String ACTION_INSTALL_TTS_DATA = "android.speech.tts.engine.INSTALL_TTS_DATA";
        public static final String ACTION_TTS_DATA_INSTALLED = "android.speech.tts.engine.TTS_DATA_INSTALLED";
        public static final String ACTION_CHECK_TTS_DATA = "android.speech.tts.engine.CHECK_TTS_DATA";
        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";

        /* 14 */
        public Engine() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */ 
/*    */     public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        /*    */
/*    */ 
/*    */     public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        /*    */
/*    */     public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        /*    */
/*    */     public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        /*    */
/*    */     public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        /*    */     public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        /*    */     public static final String KEY_PARAM_STREAM = "streamType";
        /*    */     public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        /*    */     public static final String KEY_PARAM_VOLUME = "volume";
        /*    */     public static final String KEY_PARAM_PAN = "pan";
        /*    */     public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        /*    */     public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
/*    */
    }

    /*    */
/*    */   public static class EngineInfo
/*    */ {
        /*    */     public String name;
        /*    */     public String label;

        /*    */
/* 42 */
        public EngineInfo() {
            throw new RuntimeException("Stub!");
        }

        /* 43 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public int icon;
/*    */
    }

    /*    */
/* 48 */
    public TextToSpeech(android.content.Context context, OnInitListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public TextToSpeech(android.content.Context context, OnInitListener listener, String engine) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public int addSpeech(String text, String packagename, int resourceId) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public int addSpeech(String text, String filename) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public int addEarcon(String earcon, String packagename, int resourceId) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public int addEarcon(String earcon, String filename) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public int speak(String text, int queueMode, HashMap<String, String> params) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public int playEarcon(String earcon, int queueMode, HashMap<String, String> params) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public int playSilence(long durationInMs, int queueMode, HashMap<String, String> params) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public java.util.Set<String> getFeatures(java.util.Locale locale) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public boolean isSpeaking() {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public int stop() {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public int setSpeechRate(float speechRate) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public int setPitch(float pitch) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public int setLanguage(java.util.Locale loc) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public java.util.Locale getLanguage() {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public int isLanguageAvailable(java.util.Locale loc) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public int synthesizeToFile(String text, HashMap<String, String> params, String filename) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 68 */ public int setOnUtteranceCompletedListener(OnUtteranceCompletedListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 71 */ public int setEngineByPackageName(String enginePackageName) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    public String getDefaultEngine() {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    public boolean areDefaultsEnforced() {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    public java.util.List<EngineInfo> getEngines() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int QUEUE_FLUSH = 0;
    /*    */   public static final int QUEUE_ADD = 1;
    /*    */   public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    /*    */   public static final int LANG_COUNTRY_AVAILABLE = 1;
    /*    */   public static final int LANG_AVAILABLE = 0;
    /*    */   public static final int LANG_MISSING_DATA = -1;
    /*    */   public static final int LANG_NOT_SUPPORTED = -2;
    /*    */   public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED = "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/speech/tts/TextToSpeech.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */