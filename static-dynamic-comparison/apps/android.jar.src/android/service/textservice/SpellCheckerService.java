/*    */
package android.service.textservice;
/*    */ 
/*    */

import android.view.textservice.TextInfo;

/*    */
/*    */ public abstract class SpellCheckerService extends android.app.Service {
    public static final String SERVICE_INTERFACE = "android.service.textservice.SpellCheckerService";

    /*    */
/*  7 */   public static abstract class Session {
        public Session() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        public abstract void onCreate();

        /*    */
        public abstract android.view.textservice.SuggestionsInfo onGetSuggestions(TextInfo paramTextInfo, int paramInt);

        /* 10 */
        public android.view.textservice.SuggestionsInfo[] onGetSuggestionsMultiple(TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public android.view.textservice.SentenceSuggestionsInfo[] onGetSentenceSuggestionsMultiple(TextInfo[] textInfos, int suggestionsLimit) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public void onCancel() {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public void onClose() {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public String getLocale() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public android.os.Bundle getBundle() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 17 */
    public SpellCheckerService() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public final android.os.IBinder onBind(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    public abstract Session createSession();
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/service/textservice/SpellCheckerService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */