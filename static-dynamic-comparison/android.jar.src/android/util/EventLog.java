/*    */
package android.util;
/*    */ 
/*    */

import java.util.Collection;

/*    */
/*    */ public class EventLog {
    /*  6 */   public static final class Event {
        Event() {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public int getProcessId() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public int getThreadId() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public long getTimeNanos() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public int getTag() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public synchronized Object getData() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 13 */   EventLog() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public static native int writeEvent(int paramInt1, int paramInt2);

    /*    */
    public static native int writeEvent(int paramInt, long paramLong);

    /*    */
    public static native int writeEvent(int paramInt, String paramString);

    /*    */
    public static native int writeEvent(int paramInt, Object... paramVarArgs);

    /*    */
    public static native void readEvents(int[] paramArrayOfInt, Collection<Event> paramCollection) throws java.io.IOException;

    /* 19 */
    public static String getTagName(int tag) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static int getTagCode(String name) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/EventLog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */