package com.flurry.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class aw {
    private static final String a = aw.class.getSimpleName();
    private final String b;
    private final long c;
    private final boolean d;
    private fh e;

    public aw(String paramString, long paramLong, boolean paramBoolean) {
        if ((paramString == null) || (paramString.length() == 0)) {
            throw new IllegalArgumentException("The cache must have a name");
        }
        this.b = paramString;
        this.c = paramLong;
        this.d = paramBoolean;
    }

    public b a(String paramString) {
        if (this.e == null) {
        }
        while (paramString == null) {
            return null;
        }
        try {
            Object localObject = this.e.a(ce.c(paramString));
            if (localObject == null) {
                break label97;
            }
            localObject = new b((fh.c) localObject, this.d, null);
            paramString = (String) localObject;
        } catch (IOException localIOException) {
            for (; ; ) {
                eo.a(3, a, "Exception during get for cache: " + this.b + " key: " + paramString, localIOException);
                fe.a(null);
                paramString = null;
                continue;
                paramString = null;
            }
        }
        return paramString;
    }

    public void a() {
        try {
            this.e = fh.a(ce.a(this.b), 1, 1, this.c);
            return;
        } catch (IOException localIOException) {
            eo.a(3, a, "Could not open cache: " + this.b);
        }
    }

    public c b(String paramString) {
        if (this.e == null) {
        }
        while (paramString == null) {
            return null;
        }
        try {
            Object localObject = this.e.b(ce.c(paramString));
            if (localObject == null) {
                break label97;
            }
            localObject = new c((fh.a) localObject, this.d, null);
            paramString = (String) localObject;
        } catch (IOException localIOException) {
            for (; ; ) {
                eo.a(3, a, "Exception during get for cache: " + this.b + " key: " + paramString, localIOException);
                fe.a(null);
                paramString = null;
                continue;
                paramString = null;
            }
        }
        return paramString;
    }

    public void b() {
        fe.a(this.e);
    }

    public void c() {
        d();
        a();
    }

    public boolean c(String paramString) {
        if (this.e == null) {
        }
        while (paramString == null) {
            return false;
        }
        try {
            boolean bool = this.e.c(ce.c(paramString));
            return bool;
        } catch (IOException localIOException) {
            eo.a(3, a, "Exception during remove for cache: " + this.b + " key: " + paramString, localIOException);
        }
        return false;
    }

    public void d() {
        if (this.e == null) {
            return;
        }
        try {
            this.e.a();
            return;
        } catch (IOException localIOException) {
            eo.a(3, a, "Exception during delete for cache: " + this.b, localIOException);
        }
    }

    public boolean d(String paramString) {
        boolean bool = false;
        if (this.e == null) {
        }
        while (paramString == null) {
            return false;
        }
        try {
            paramString = this.e.a(ce.c(paramString));
            if (paramString != null) {
                bool = true;
            }
            fe.a(paramString);
            return bool;
        } catch (IOException paramString) {
            eo.a(3, a, "Exception during exists for cache: " + this.b, paramString);
            return false;
        } finally {
            fe.a(null);
        }
    }

    protected void finalize()
            throws Throwable {
        super.finalize();
        b();
    }

    static class a
            extends BufferedOutputStream {
        private boolean a = false;

        private a(OutputStream paramOutputStream) {
            super();
        }

        private boolean a() {
            return this.a;
        }

        public void close()
                throws IOException {
            try {
                super.close();
                return;
            } catch (IOException localIOException) {
                this.a = true;
                throw localIOException;
            }
        }

        public void flush()
                throws IOException {
            try {
                super.flush();
                return;
            } catch (IOException localIOException) {
                this.a = true;
                throw localIOException;
            }
        }

        public void write(int paramInt)
                throws IOException {
            try {
                super.write(paramInt);
                return;
            } catch (IOException localIOException) {
                this.a = true;
                throw localIOException;
            }
        }

        public void write(byte[] paramArrayOfByte)
                throws IOException {
            try {
                super.write(paramArrayOfByte);
                return;
            } catch (IOException paramArrayOfByte) {
                this.a = true;
                throw paramArrayOfByte;
            }
        }

        public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            try {
                super.write(paramArrayOfByte, paramInt1, paramInt2);
                return;
            } catch (IOException paramArrayOfByte) {
                this.a = true;
                throw paramArrayOfByte;
            }
        }
    }

    public class b
            implements Closeable {
        private final fh.c b;
        private final InputStream c;
        private final GZIPInputStream d;
        private final BufferedInputStream e;
        private boolean f;

        private b(fh.c paramc, boolean paramBoolean)
                throws IOException {
            if (paramc == null) {
                throw new IllegalArgumentException("Snapshot cannot be null");
            }
            this.b = paramc;
            this.c = this.b.a(0);
            if (this.c == null) {
                throw new IOException("Snapshot inputstream is null");
            }
            if (paramBoolean) {
                this.d = new GZIPInputStream(this.c);
                if (this.d == null) {
                    throw new IOException("Gzip inputstream is null");
                }
                this.e = new BufferedInputStream(this.d);
                return;
            }
            this.d = null;
            this.e = new BufferedInputStream(this.c);
        }

        public InputStream a() {
            return this.e;
        }

        public void close() {
            if (this.f) {
                return;
            }
            this.f = true;
            fe.a(this.e);
            fe.a(this.d);
            fe.a(this.c);
            fe.a(this.b);
        }

        protected void finalize()
                throws Throwable {
            super.finalize();
            close();
        }
    }

    public class c
            implements Closeable {
        private final fh.a b;
        private final OutputStream c;
        private final GZIPOutputStream d;
        private final aw.a e;
        private boolean f;

        private c(fh.a parama, boolean paramBoolean)
                throws IOException {
            if (parama == null) {
                throw new IllegalArgumentException("Editor cannot be null");
            }
            this.b = parama;
            this.c = this.b.a(0);
            if (this.b == null) {
                throw new IOException("Editor outputstream is null");
            }
            if (paramBoolean) {
                this.d = new GZIPOutputStream(this.c);
                if (this.d == null) {
                    throw new IOException("Gzip outputstream is null");
                }
                this.e = new aw.a(this.d, null);
                return;
            }
            this.d = null;
            this.e = new aw.a(this.c, null);
        }

        public OutputStream a() {
            return this.e;
        }

        public void close() {
            boolean bool = true;
            if (this.f) {
            }
            do {
                return;
                this.f = true;
                fe.a(this.e);
                fe.a(this.d);
                fe.a(this.c);
            } while (this.b == null);
            if (this.e == null) {
            }
            while (bool) {
                try {
                    this.b.b();
                    return;
                } catch (IOException localIOException) {
                    eo.a(3, aw.e(), "Exception closing editor for cache: " + aw.a(aw.this), localIOException);
                    return;
                }
                bool = aw.a.a(this.e);
            }
            this.b.a();
        }

        protected void finalize()
                throws Throwable {
            super.finalize();
            close();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */