/*    */
package android.net;
/*    */ 
/*    */

import java.net.Socket;

/*    */
/*    */ public class SSLCertificateSocketFactory extends javax.net.ssl.SSLSocketFactory {
    @Deprecated
/*  6 */ public SSLCertificateSocketFactory(int handshakeTimeoutMillis) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static javax.net.SocketFactory getDefault(int handshakeTimeoutMillis) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static javax.net.ssl.SSLSocketFactory getDefault(int handshakeTimeoutMillis, SSLSessionCache cache) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static javax.net.ssl.SSLSocketFactory getInsecure(int handshakeTimeoutMillis, SSLSessionCache cache) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static org.apache.http.conn.ssl.SSLSocketFactory getHttpSocketFactory(int handshakeTimeoutMillis, SSLSessionCache cache) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setTrustManagers(javax.net.ssl.TrustManager[] trustManager) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setNpnProtocols(byte[][] npnProtocols) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public byte[] getNpnSelectedProtocol(Socket socket) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setKeyManagers(javax.net.ssl.KeyManager[] keyManagers) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public Socket createSocket(Socket k, String host, int port, boolean close) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public Socket createSocket() throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public Socket createSocket(java.net.InetAddress addr, int port, java.net.InetAddress localAddr, int localPort) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public Socket createSocket(java.net.InetAddress addr, int port) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public Socket createSocket(String host, int port, java.net.InetAddress localAddr, int localPort) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public Socket createSocket(String host, int port) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public String[] getDefaultCipherSuites() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public String[] getSupportedCipherSuites() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/SSLCertificateSocketFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */