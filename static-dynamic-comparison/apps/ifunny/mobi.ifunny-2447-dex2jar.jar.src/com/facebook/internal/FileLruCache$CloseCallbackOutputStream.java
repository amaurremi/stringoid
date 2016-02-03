package com.facebook.internal;

import java.io.OutputStream;

class FileLruCache$CloseCallbackOutputStream
        extends OutputStream {
    final FileLruCache.StreamCloseCallback callback;
    final OutputStream innerStream;

    FileLruCache$CloseCallbackOutputStream(OutputStream paramOutputStream, FileLruCache.StreamCloseCallback paramStreamCloseCallback) {
        this.innerStream = paramOutputStream;
        this.callback = paramStreamCloseCallback;
    }

    public void close() {
        try {
            this.innerStream.close();
            return;
        } finally {
            this.callback.onClose();
        }
    }

    public void flush() {
        this.innerStream.flush();
    }

    public void write(int paramInt) {
        this.innerStream.write(paramInt);
    }

    public void write(byte[] paramArrayOfByte) {
        this.innerStream.write(paramArrayOfByte);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.innerStream.write(paramArrayOfByte, paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache$CloseCallbackOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */