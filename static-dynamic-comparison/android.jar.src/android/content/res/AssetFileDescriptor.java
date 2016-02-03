/*    */
package android.content.res;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*    */ public class AssetFileDescriptor implements android.os.Parcelable {
    /*    */   public static final long UNKNOWN_LENGTH = -1L;

    /*    */
/*  8 */   public static class AutoCloseInputStream extends android.os.ParcelFileDescriptor.AutoCloseInputStream {
        public AutoCloseInputStream(AssetFileDescriptor fd) throws IOException {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public int available() throws IOException {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public int read() throws IOException {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public int read(byte[] buffer, int offset, int count) throws IOException {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public int read(byte[] buffer) throws IOException {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public long skip(long count) throws IOException {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public void mark(int readlimit) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public boolean markSupported() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public synchronized void reset() throws IOException {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static class AutoCloseOutputStream extends android.os.ParcelFileDescriptor.AutoCloseOutputStream {
        /*    */
        public AutoCloseOutputStream(AssetFileDescriptor fd) throws IOException {
/* 21 */
            super();
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public void write(byte[] buffer, int offset, int count) throws IOException {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public void write(byte[] buffer) throws IOException {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public void write(int oneByte) throws IOException {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 26 */
    public AssetFileDescriptor(android.os.ParcelFileDescriptor fd, long startOffset, long length) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public android.os.ParcelFileDescriptor getParcelFileDescriptor() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public java.io.FileDescriptor getFileDescriptor() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public long getStartOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public long getLength() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public long getDeclaredLength() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public java.io.FileInputStream createInputStream() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public java.io.FileOutputStream createOutputStream() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void writeToParcel(android.os.Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/* 40 */   public static final android.os.Parcelable.Creator<AssetFileDescriptor> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/res/AssetFileDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */