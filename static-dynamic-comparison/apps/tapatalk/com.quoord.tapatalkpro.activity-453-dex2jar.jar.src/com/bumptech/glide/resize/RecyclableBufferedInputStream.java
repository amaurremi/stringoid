package com.bumptech.glide.resize;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream
        extends FilterInputStream {
    protected volatile byte[] buf;
    protected int count;
    protected int marklimit;
    protected int markpos = -1;
    protected int pos;

    public RecyclableBufferedInputStream(InputStream paramInputStream, byte[] paramArrayOfByte) {
        super(paramInputStream);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.buf = paramArrayOfByte;
    }

    private int fillbuf(InputStream paramInputStream, byte[] paramArrayOfByte)
            throws IOException {
        int i = 0;
        int j;
        if ((this.markpos == -1) || (this.pos - this.markpos >= this.marklimit)) {
            j = paramInputStream.read(paramArrayOfByte);
            if (j > 0) {
                this.markpos = -1;
                this.pos = 0;
                if (j != -1) {
                    break label62;
                }
            }
            for (; ; ) {
                this.count = i;
                return j;
                label62:
                i = j;
            }
        }
        byte[] arrayOfByte;
        if ((this.markpos == 0) && (this.marklimit > paramArrayOfByte.length) && (this.count != 0)) {
            j = paramArrayOfByte.length * 2;
            i = j;
            if (j > this.marklimit) {
                i = this.marklimit;
            }
            arrayOfByte = new byte[i];
            System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
            this.buf = arrayOfByte;
            this.pos -= this.markpos;
            this.markpos = 0;
            this.count = 0;
            j = paramInputStream.read(arrayOfByte, this.pos, arrayOfByte.length - this.pos);
            if (j > 0) {
                break label229;
            }
        }
        label229:
        for (i = this.pos; ; i = this.pos + j) {
            this.count = i;
            return j;
            arrayOfByte = paramArrayOfByte;
            if (this.markpos <= 0) {
                break;
            }
            System.arraycopy(paramArrayOfByte, this.markpos, paramArrayOfByte, 0, paramArrayOfByte.length - this.markpos);
            arrayOfByte = paramArrayOfByte;
            break;
        }
    }

    private IOException streamClosed()
            throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public int available()
            throws IOException {
        try {
            InputStream localInputStream = this.in;
            if ((this.buf == null) || (localInputStream == null)) {
                throw streamClosed();
            }
        } finally {
        }
        int i = this.count;
        int j = this.pos;
        int k = ((InputStream) localObject).available();
        return i - j + k;
    }

    public void clearMark() {
        try {
            this.markpos = -1;
            this.marklimit = 0;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void close()
            throws IOException {
        this.buf = null;
        InputStream localInputStream = this.in;
        this.in = null;
        if (localInputStream != null) {
            localInputStream.close();
        }
    }

    public void mark(int paramInt) {
        try {
            this.marklimit = Math.max(this.marklimit, paramInt);
            this.markpos = this.pos;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read()
            throws IOException {
        int i = -1;
        byte[] arrayOfByte2;
        try {
            arrayOfByte2 = this.buf;
            InputStream localInputStream1 = this.in;
            if ((arrayOfByte2 == null) || (localInputStream1 == null)) {
                throw streamClosed();
            }
        } finally {
        }
        if (this.pos >= this.count) {
            int j = fillbuf(localInputStream2, arrayOfByte2);
            if (j != -1) {
            }
        }
        for (; ; ) {
            return i;
            byte[] arrayOfByte1 = arrayOfByte2;
            if (arrayOfByte2 != this.buf) {
                arrayOfByte2 = this.buf;
                arrayOfByte1 = arrayOfByte2;
                if (arrayOfByte2 == null) {
                    throw streamClosed();
                }
            }
            if (this.count - this.pos > 0) {
                i = this.pos;
                this.pos = (i + 1);
                i = arrayOfByte1[i];
                i &= 0xFF;
            }
        }
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        int k = -1;
        Object localObject2;
        try {
            localObject2 = this.buf;
            if (localObject2 == null) {
                throw streamClosed();
            }
        } finally {
        }
        if (paramInt2 == 0) {
            paramInt1 = 0;
        }
        for (; ; ) {
            return paramInt1;
            InputStream localInputStream = this.in;
            if (localInputStream == null) {
                throw streamClosed();
            }
            int i;
            label134:
            int m;
            Object localObject1;
            int j;
            if (this.pos < this.count) {
                if (this.count - this.pos >= paramInt2) {
                }
                for (i = paramInt2; ; i = this.count - this.pos) {
                    System.arraycopy(localObject2, this.pos, paramArrayOfByte, paramInt1, i);
                    this.pos += i;
                    if (i == paramInt2) {
                        break;
                    }
                    if (localInputStream.available() != 0) {
                        break label351;
                    }
                    break;
                }
                if ((this.markpos == -1) && (i >= localObject2.length)) {
                    m = localInputStream.read(paramArrayOfByte, paramInt1, i);
                    localObject1 = localObject2;
                    j = m;
                    if (m != -1) {
                        break label371;
                    }
                    paramInt1 = k;
                    if (i == paramInt2) {
                        continue;
                    }
                    paramInt1 = paramInt2 - i;
                    continue;
                }
                if (fillbuf(localInputStream, (byte[]) localObject2) == -1) {
                    paramInt1 = k;
                    if (i == paramInt2) {
                        continue;
                    }
                    paramInt1 = paramInt2 - i;
                    continue;
                }
                localObject1 = localObject2;
                if (localObject2 != this.buf) {
                    localObject2 = this.buf;
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                        throw streamClosed();
                    }
                }
                if (this.count - this.pos >= i) {
                }
                for (j = i; ; j = this.count - this.pos) {
                    System.arraycopy(localObject1, this.pos, paramArrayOfByte, paramInt1, j);
                    this.pos += j;
                    break;
                }
            }
            label351:
            label371:
            do {
                m = localInputStream.available();
                if (m == 0) {
                    paramInt1 = paramInt2 - i;
                    break;
                }
                paramInt1 += j;
                localObject2 = localObject1;
                break label134;
                paramInt1 = i;
                break;
                paramInt1 += i;
                i = paramInt2 - i;
                break label134;
                i = paramInt2;
                break label134;
                i -= j;
            } while (i != 0);
            paramInt1 = paramInt2;
        }
    }

    public void reset()
            throws IOException {
        try {
            if (this.buf == null) {
                throw new IOException("Stream is closed");
            }
        } finally {
        }
        if (-1 == this.markpos) {
            throw new InvalidMarkException("Mark has been invalidated");
        }
        this.pos = this.markpos;
    }

    public long skip(long paramLong)
            throws IOException {
        InputStream localInputStream;
        try {
            byte[] arrayOfByte1 = this.buf;
            localInputStream = this.in;
            if (arrayOfByte1 == null) {
                throw streamClosed();
            }
        } finally {
        }
        if (paramLong < 1L) {
            paramLong = 0L;
        }
        for (; ; ) {
            return paramLong;
            if (localInputStream == null) {
                throw streamClosed();
            }
            if (this.count - this.pos >= paramLong) {
                this.pos = ((int) (this.pos + paramLong));
            } else {
                long l = this.count - this.pos;
                this.pos = this.count;
                if ((this.markpos != -1) && (paramLong <= this.marklimit)) {
                    if (fillbuf(localInputStream, arrayOfByte2) == -1) {
                        paramLong = l;
                    } else if (this.count - this.pos >= paramLong - l) {
                        this.pos = ((int) (this.pos + (paramLong - l)));
                    } else {
                        paramLong = this.count - this.pos;
                        this.pos = this.count;
                        paramLong = l + paramLong;
                    }
                } else {
                    paramLong = localInputStream.skip(paramLong - l);
                    paramLong = l + paramLong;
                }
            }
        }
    }

    public static class InvalidMarkException
            extends RuntimeException {
        public InvalidMarkException(String paramString) {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/RecyclableBufferedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */