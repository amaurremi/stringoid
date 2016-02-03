/*    */
package android.inputmethodservice;
/*    */ 
/*    */

import android.view.inputmethod.InputMethodSession;

/*    */
/*    */ public abstract class AbstractInputMethodService extends android.app.Service
/*    */ implements android.view.KeyEvent.Callback
/*    */ {
    /*    */   public abstract class AbstractInputMethodImpl implements android.view.inputmethod.InputMethod {
        /*  9 */
        public AbstractInputMethodImpl() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public void createSession(android.view.inputmethod.InputMethod.SessionCallback callback) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public void setSessionEnabled(InputMethodSession session, boolean enabled) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public void revokeSession(InputMethodSession session) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public abstract class AbstractInputMethodSessionImpl
/*    */ implements InputMethodSession {
        /* 17 */
        public AbstractInputMethodSessionImpl() {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public boolean isEnabled() {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public boolean isRevoked() {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public void setEnabled(boolean enabled) {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public void revokeSelf() {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public void dispatchKeyEvent(int seq, android.view.KeyEvent event, android.view.inputmethod.InputMethodSession.EventCallback callback) {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public void dispatchTrackballEvent(int seq, android.view.MotionEvent event, android.view.inputmethod.InputMethodSession.EventCallback callback) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 25 */
    public AbstractInputMethodService() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public android.view.KeyEvent.DispatcherState getKeyDispatcherState() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract AbstractInputMethodImpl onCreateInputMethodInterface();

    /*    */
    public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

    /* 29 */
    protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter fout, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public final android.os.IBinder onBind(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean onTrackballEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/inputmethodservice/AbstractInputMethodService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */