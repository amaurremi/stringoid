/*    */
package android.net;
/*    */

import java.io.IOException;

/*    */
/*  4 */ public class LocalSocket {
    public LocalSocket() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void connect(LocalSocketAddress endpoint) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void bind(LocalSocketAddress bindpoint) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public LocalSocketAddress getLocalSocketAddress() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public java.io.InputStream getInputStream() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public java.io.OutputStream getOutputStream() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void shutdownInput() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void shutdownOutput() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setReceiveBufferSize(int size) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getReceiveBufferSize() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setSoTimeout(int n) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getSoTimeout() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setSendBufferSize(int n) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getSendBufferSize() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public LocalSocketAddress getRemoteSocketAddress() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public synchronized boolean isConnected() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean isClosed() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public synchronized boolean isBound() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean isOutputShutdown() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isInputShutdown() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void connect(LocalSocketAddress endpoint, int timeout) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setFileDescriptorsForSend(java.io.FileDescriptor[] fds) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public java.io.FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public Credentials getPeerCredentials() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public java.io.FileDescriptor getFileDescriptor() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/LocalSocket.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */