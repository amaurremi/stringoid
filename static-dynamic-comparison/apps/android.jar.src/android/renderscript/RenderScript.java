/*    */
package android.renderscript;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class RenderScript {
    /*    */   public static class RSMessageHandler implements Runnable {
        /*  7 */
        public RSMessageHandler() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public void run() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */     protected int[] mData = null;
        /*    */     protected int mID;
        /*    */     protected int mLength;
    }

    /*    */
/*    */   public static class RSErrorHandler implements Runnable {
        protected String mErrorMessage;
        /*    */     protected int mErrorNum;

        /*    */
/* 16 */
        public RSErrorHandler() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public void run() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */ 
/*    */   public static enum Priority
/*    */ {
        /* 23 */     LOW,
        /* 24 */     NORMAL;

        /*    */
        private Priority() {
        }
    }

    /* 26 */   RenderScript() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setMessageHandler(RSMessageHandler msg) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public RSMessageHandler getMessageHandler() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setErrorHandler(RSErrorHandler msg) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public RSErrorHandler getErrorHandler() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setPriority(Priority p) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public final Context getApplicationContext() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public static RenderScript create(Context ctx) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void contextDump() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void finish() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void destroy() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/RenderScript.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */