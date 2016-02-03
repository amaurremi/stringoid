/*    */
package android.speech;
/*    */ 
/*    */

import android.os.RemoteException;

/*    */
/*    */ public abstract class RecognitionService extends android.app.Service {
    public static final String SERVICE_INTERFACE = "android.speech.RecognitionService";

    /*    */
/*  7 */   public class Callback {
        Callback() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public void beginningOfSpeech() throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public void bufferReceived(byte[] buffer) throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public void endOfSpeech() throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public void error(int error) throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public void partialResults(android.os.Bundle partialResults) throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public void readyForSpeech(android.os.Bundle params) throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public void results(android.os.Bundle results) throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public void rmsChanged(float rmsdB) throws RemoteException {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 17 */
    public RecognitionService() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    protected abstract void onStartListening(android.content.Intent paramIntent, Callback paramCallback);

    /*    */
    protected abstract void onCancel(Callback paramCallback);

    /*    */
    protected abstract void onStopListening(Callback paramCallback);

    /* 21 */
    public final android.os.IBinder onBind(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String SERVICE_META_DATA = "android.speech";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/speech/RecognitionService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */