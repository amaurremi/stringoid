package mobi.ifunny.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import mobi.ifunny.util.s;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class f
        implements HttpEntity {
    private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String b = null;
    private ByteArrayOutputStream c = new ByteArrayOutputStream();
    private boolean d = false;
    private boolean e = false;
    private h f;

    public f() {
        StringBuilder localStringBuilder = new StringBuilder();
        Random localRandom = new Random();
        while (i < 30) {
            localStringBuilder.append(a[localRandom.nextInt(a.length)]);
            i += 1;
        }
        this.b = localStringBuilder.toString();
    }

    public void a() {
        if (!this.e) {
        }
        try {
            this.c.write(("--" + this.b + "\r\n").getBytes());
            this.e = true;
            return;
        } catch (IOException localIOException) {
            for (; ; ) {
                localIOException.printStackTrace();
            }
        }
    }

    public void a(String paramString1, String paramString2) {
        a();
        try {
            this.c.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"\r\n\r\n").getBytes());
            this.c.write(paramString2.getBytes());
            this.c.write(("\r\n--" + this.b + "\r\n").getBytes());
            return;
        } catch (IOException paramString1) {
            paramString1.printStackTrace();
        }
    }

    public void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3, boolean paramBoolean) {
        a();
        try {
            paramString3 = "Content-Type: " + paramString3 + "\r\n";
            this.c.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"\r\n").getBytes());
            this.c.write(paramString3.getBytes());
            this.c.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
            paramString1 = new byte['က'];
            for (; ; ) {
                int i = paramInputStream.read(paramString1);
                if (i == -1) {
                    break;
                }
                this.c.write(paramString1, 0, i);
            }
            try {
                paramInputStream.close();
                throw paramString1;
            } catch (IOException paramString2) {
                for (; ; ) {
                    paramString2.printStackTrace();
                }
            }
        } catch (IOException paramString1) {
            paramString1 = paramString1;
            paramString1.printStackTrace();
            try {
                paramInputStream.close();
                return;
            } catch (IOException paramString1) {
                paramString1.printStackTrace();
                return;
            }
            if (!paramBoolean) {
                this.c.write(("\r\n--" + this.b + "\r\n").getBytes());
            }
            this.c.flush();
            try {
                paramInputStream.close();
                return;
            } catch (IOException paramString1) {
                paramString1.printStackTrace();
                return;
            }
        } finally {
        }
    }

    public void a(String paramString1, String paramString2, InputStream paramInputStream, boolean paramBoolean) {
        a(paramString1, paramString2, paramInputStream, "application/octet-stream", paramBoolean);
    }

    public void a(h paramh) {
        this.f = paramh;
    }

    public void b() {
        if (this.d) {
            return;
        }
        try {
            this.c.write(("\r\n--" + this.b + "--\r\n").getBytes());
            this.d = true;
            return;
        } catch (IOException localIOException) {
            for (; ; ) {
                localIOException.printStackTrace();
            }
        }
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.c.toByteArray());
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        b();
        return this.c.toByteArray().length;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.b);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream paramOutputStream) {
        byte[] arrayOfByte = this.c.toByteArray();
        int i = arrayOfByte.length;
        s.a(new ByteArrayInputStream(arrayOfByte), paramOutputStream, new g(this, i));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */