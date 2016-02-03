/*    */
package android.provider;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ public class CallLog {
    public static final String AUTHORITY = "call_log";

    /*    */
/*  7 */   public static class Calls implements BaseColumns {
        public Calls() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public static String getLastOutgoingCall(android.content.Context context) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */ 
/*    */     public static final String IS_READ = "is_read";
        /*    */     public static final String CACHED_NUMBER_LABEL = "numberlabel";
        /*    */     public static final String CACHED_NUMBER_TYPE = "numbertype";
        /*    */     public static final String CACHED_NAME = "name";
        /*    */     public static final String NEW = "new";
        /*    */     public static final String DURATION = "duration";
        /*    */     public static final String DATE = "date";
        /*    */     public static final String NUMBER = "number";
        /*    */     public static final int MISSED_TYPE = 3;
        /*    */     public static final int OUTGOING_TYPE = 2;
        /*    */     public static final int INCOMING_TYPE = 1;
        /*    */     public static final String TYPE = "type";
        /*    */     public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/calls";
        /*    */     public static final String CONTENT_TYPE = "vnd.android.cursor.dir/calls";
        /*    */     public static final String DEFAULT_SORT_ORDER = "date DESC";
        /* 26 */     public static final Uri CONTENT_FILTER_URI = null;
        public static final Uri CONTENT_URI = null;
    }

    /*    */
/* 28 */
    public CallLog() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/* 31 */   public static final Uri CONTENT_URI = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/CallLog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */