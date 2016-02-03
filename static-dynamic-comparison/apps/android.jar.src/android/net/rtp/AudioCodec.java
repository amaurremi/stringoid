/*    */
package android.net.rtp;

/*    */
/*    */ public class AudioCodec {
    /*  4 */   AudioCodec() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static AudioCodec[] getCodecs() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static AudioCodec getCodec(int type, String rtpmap, String fmtp) {
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
/* 15 */   public static final AudioCodec AMR = null;
    public static final AudioCodec GSM_EFR = null;
    public static final AudioCodec GSM = null;
    public static final AudioCodec PCMA = null;
    public static final AudioCodec PCMU = null;
    /*    */   public final String fmtp;
    /*    */   public final String rtpmap;
    /*    */   public final int type;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/rtp/AudioCodec.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */