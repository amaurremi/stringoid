/*    */
package android.os;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*    */ public class ParcelFileDescriptor implements Parcelable, java.io.Closeable {
    public static final int MODE_WORLD_READABLE = 1;
    /*    */   public static final int MODE_WORLD_WRITEABLE = 2;

    /*    */
/*  8 */   public static class AutoCloseInputStream extends java.io.FileInputStream {
        public AutoCloseInputStream(ParcelFileDescriptor fd) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public void close() throws IOException {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static class AutoCloseOutputStream extends java.io.FileOutputStream {
        /*    */
        public AutoCloseOutputStream(ParcelFileDescriptor fd) {
/* 14 */
            super();
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public void close() throws IOException {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 17 */
    public ParcelFileDescriptor(ParcelFileDescriptor descriptor) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static ParcelFileDescriptor open(java.io.File file, int mode) throws java.io.FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static ParcelFileDescriptor dup(java.io.FileDescriptor orig) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public ParcelFileDescriptor dup() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static ParcelFileDescriptor fromFd(int fd) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static ParcelFileDescriptor adoptFd(int fd) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static ParcelFileDescriptor fromSocket(java.net.Socket socket) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public static ParcelFileDescriptor fromDatagramSocket(java.net.DatagramSocket datagramSocket) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static ParcelFileDescriptor[] createPipe() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public java.io.FileDescriptor getFileDescriptor() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public native long getStatSize();

    /* 28 */
    public int getFd() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int detachFd() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void writeToParcel(Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public static final int MODE_READ_ONLY = 268435456;
    /*    */
/*    */   public static final int MODE_WRITE_ONLY = 536870912;
    /*    */   public static final int MODE_READ_WRITE = 805306368;
    /*    */   public static final int MODE_CREATE = 134217728;
    /*    */   public static final int MODE_TRUNCATE = 67108864;
    /*    */   public static final int MODE_APPEND = 33554432;
    /* 44 */   public static final Parcelable.Creator<ParcelFileDescriptor> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/ParcelFileDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */