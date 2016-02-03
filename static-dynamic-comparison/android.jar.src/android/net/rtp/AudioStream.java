/*    */
package android.net.rtp;
/*    */ 
/*    */

import java.net.InetAddress;

/*    */
/*  5 */ public class AudioStream extends RtpStream {
    public AudioStream(InetAddress address) throws java.net.SocketException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public final boolean isBusy() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public AudioGroup getGroup() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void join(AudioGroup group) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public AudioCodec getCodec() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setCodec(AudioCodec codec) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getDtmfType() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setDtmfType(int type) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/rtp/AudioStream.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */