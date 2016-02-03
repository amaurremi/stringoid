package retrofit;

import java.io.IOException;
import java.io.InputStream;

class ExceptionCatchingTypedInput$ExceptionCatchingInputStream
        extends InputStream {
    private final InputStream delegate;
    private IOException thrownException;

    ExceptionCatchingTypedInput$ExceptionCatchingInputStream(InputStream paramInputStream) {
        this.delegate = paramInputStream;
    }

    public int available() {
        try {
            int i = this.delegate.available();
            return i;
        } catch (IOException localIOException) {
            this.thrownException = localIOException;
            throw localIOException;
        }
    }

    public void close() {
        try {
            this.delegate.close();
            return;
        } catch (IOException localIOException) {
            this.thrownException = localIOException;
            throw localIOException;
        }
    }

    public void mark(int paramInt) {
        try {
            this.delegate.mark(paramInt);
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean markSupported() {
        return this.delegate.markSupported();
    }

    public int read() {
        try {
            int i = this.delegate.read();
            return i;
        } catch (IOException localIOException) {
            this.thrownException = localIOException;
            throw localIOException;
        }
    }

    public int read(byte[] paramArrayOfByte) {
        try {
            int i = this.delegate.read(paramArrayOfByte);
            return i;
        } catch (IOException paramArrayOfByte) {
            this.thrownException = paramArrayOfByte;
            throw paramArrayOfByte;
        }
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        try {
            paramInt1 = this.delegate.read(paramArrayOfByte, paramInt1, paramInt2);
            return paramInt1;
        } catch (IOException paramArrayOfByte) {
            this.thrownException = paramArrayOfByte;
            throw paramArrayOfByte;
        }
    }

    public void reset() {
        try {
            this.delegate.reset();
            return;
        } catch (IOException localIOException) {
            this.thrownException = localIOException;
            throw localIOException;
        } finally {
        }
    }

    public long skip(long paramLong) {
        try {
            paramLong = this.delegate.skip(paramLong);
            return paramLong;
        } catch (IOException localIOException) {
            this.thrownException = localIOException;
            throw localIOException;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/ExceptionCatchingTypedInput$ExceptionCatchingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */