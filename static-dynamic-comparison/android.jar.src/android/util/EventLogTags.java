/*    */
package android.util;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*    */
@Deprecated
/*    */ public class EventLogTags {
    public static class Description {
        public final int mTag;

        /*  7 */     Description() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public final String mName;
    }

    /*    */
/* 11 */
    public EventLogTags() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public EventLogTags(java.io.BufferedReader input) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public Description get(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public Description get(int tag) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/EventLogTags.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */