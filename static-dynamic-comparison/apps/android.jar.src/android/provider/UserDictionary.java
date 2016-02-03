/*    */
package android.provider;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class UserDictionary {
    public static final String AUTHORITY = "user_dictionary";

    /*    */
/*  7 */   public static class Words implements BaseColumns {
        public Words() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/*  9 */ public static void addWord(Context context, String word, int frequency, int localeType) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public static void addWord(Context context, String word, int frequency, String shortcut, java.util.Locale locale) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 25 */     public static final android.net.Uri CONTENT_URI = null;
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.userword";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.userword";
        public static final String _ID = "_id";
        public static final String WORD = "word";
        public static final String FREQUENCY = "frequency";
        public static final String LOCALE = "locale";
        public static final String APP_ID = "appid";
        public static final String SHORTCUT = "shortcut";
        @Deprecated
/*    */ public static final int LOCALE_TYPE_ALL = 0;
        @Deprecated
/* 27 */ public static final int LOCALE_TYPE_CURRENT = 1;
        public static final String DEFAULT_SORT_ORDER = "frequency DESC";
    }

    public UserDictionary() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/* 30 */   public static final android.net.Uri CONTENT_URI = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/UserDictionary.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */