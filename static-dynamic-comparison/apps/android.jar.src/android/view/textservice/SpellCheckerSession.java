/*    */
package android.view.textservice;

/*    */
/*    */ 
/*    */ public class SpellCheckerSession
/*    */ {
    /*    */   public static final String SERVICE_META_DATA = "android.view.textservice.scs";

    /*    */
/*    */ 
/*  9 */   SpellCheckerSession() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isSessionDisconnected() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public SpellCheckerInfo getSpellChecker() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void getSentenceSuggestions(TextInfo[] textInfos, int suggestionsLimit) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 16 */ public void getSuggestions(TextInfo textInfo, int suggestionsLimit) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 18 */ public void getSuggestions(TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface SpellCheckerSessionListener
/*    */ {
        /*    */
        public abstract void onGetSuggestions(SuggestionsInfo[] paramArrayOfSuggestionsInfo);

        /*    */
/*    */
        public abstract void onGetSentenceSuggestions(SentenceSuggestionsInfo[] paramArrayOfSentenceSuggestionsInfo);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/textservice/SpellCheckerSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */