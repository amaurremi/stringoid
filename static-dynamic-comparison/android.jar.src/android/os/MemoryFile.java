/*    */
package android.os;
/*    */

import java.io.IOException;

/*    */
/*  4 */ public class MemoryFile {
    public MemoryFile(String name, int length) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int length() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean isPurgingAllowed() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public synchronized boolean allowPurging(boolean allowPurging) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public java.io.InputStream getInputStream() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public java.io.OutputStream getOutputStream() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int readBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void writeBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/MemoryFile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */