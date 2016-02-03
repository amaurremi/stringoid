package com.everimaging.fotorsdk.http;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class o
        implements HttpEntity {
    private static final byte[] a = "\r\n".getBytes();
    private static final byte[] b = "Content-Transfer-Encoding: binary\r\n".getBytes();
    private static final char[] c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final String d;
    private final byte[] e;
    private final byte[] f;
    private boolean g;
    private final List<a> h = new ArrayList();
    private final ByteArrayOutputStream i = new ByteArrayOutputStream();
    private final m j;
    private int k;
    private int l;

    public o(m paramm) {
        StringBuilder localStringBuilder = new StringBuilder();
        Random localRandom = new Random();
        int m = 0;
        while (m < 30) {
            localStringBuilder.append(c[localRandom.nextInt(c.length)]);
            m += 1;
        }
        this.d = localStringBuilder.toString();
        this.e = ("--" + this.d + "\r\n").getBytes();
        this.f = ("--" + this.d + "--" + "\r\n").getBytes();
        this.j = paramm;
    }

    private String a(String paramString) {
        String str = paramString;
        if (paramString == null) {
            str = "application/octet-stream";
        }
        return str;
    }

    private void a(int paramInt) {
        this.k += paramInt;
        this.j.b(this.k, this.l);
    }

    private byte[] b(String paramString) {
        return ("Content-Type: " + a(paramString) + "\r\n").getBytes();
    }

    private byte[] b(String paramString1, String paramString2) {
        return ("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"" + "\r\n").getBytes();
    }

    private byte[] c(String paramString) {
        return ("Content-Disposition: form-data; name=\"" + paramString + "\"" + "\r\n").getBytes();
    }

    public void a(String paramString1, File paramFile, String paramString2) {
        this.h.add(new a(paramString1, paramFile, a(paramString2)));
    }

    public void a(String paramString1, String paramString2) {
        a(paramString1, paramString2, "text/plain; charset=UTF-8");
    }

    public void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3)
            throws IOException {
        this.i.write(this.e);
        this.i.write(b(paramString1, paramString2));
        this.i.write(b(paramString3));
        this.i.write(b);
        this.i.write(a);
        paramString1 = new byte['က'];
        for (; ; ) {
            int m = paramInputStream.read(paramString1);
            if (m == -1) {
                break;
            }
            this.i.write(paramString1, 0, m);
        }
        this.i.write(a);
        this.i.flush();
        a.a(this.i);
    }

    public void a(String paramString1, String paramString2, String paramString3) {
        try {
            this.i.write(this.e);
            this.i.write(c(paramString1));
            this.i.write(b(paramString3));
            this.i.write(a);
            this.i.write(paramString2.getBytes());
            this.i.write(a);
            return;
        } catch (IOException paramString1) {
            Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", paramString1);
        }
    }

    public void a(boolean paramBoolean) {
        this.g = paramBoolean;
    }

    public void consumeContent()
            throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent()
            throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        long l1 = this.i.size();
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext()) {
            long l2 = ((a) localIterator.next()).a();
            if (l2 < 0L) {
                return -1L;
            }
            l1 += l2;
        }
        return l1 + this.f.length;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.d);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return this.g;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream paramOutputStream)
            throws IOException {
        this.k = 0;
        this.l = ((int) getContentLength());
        this.i.writeTo(paramOutputStream);
        a(this.i.size());
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext()) {
            ((a) localIterator.next()).a(paramOutputStream);
        }
        paramOutputStream.write(this.f);
        a(this.f.length);
    }

    private class a {
        public File a;
        public byte[] b = a(paramString1, paramFile.getName(), paramString2);

        public a(String paramString1, File paramFile, String paramString2) {
            this.a = paramFile;
        }

        private byte[] a(String paramString1, String paramString2, String paramString3) {
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            try {
                localByteArrayOutputStream.write(o.a(o.this));
                localByteArrayOutputStream.write(o.a(o.this, paramString1, paramString2));
                localByteArrayOutputStream.write(o.a(o.this, paramString3));
                localByteArrayOutputStream.write(o.a());
                localByteArrayOutputStream.write(o.b());
                return localByteArrayOutputStream.toByteArray();
            } catch (IOException paramString1) {
                for (; ; ) {
                    Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", paramString1);
                }
            }
        }

        public long a() {
            return this.a.length() + o.b().length + this.b.length;
        }

        public void a(OutputStream paramOutputStream)
                throws IOException {
            paramOutputStream.write(this.b);
            o.a(o.this, this.b.length);
            FileInputStream localFileInputStream = new FileInputStream(this.a);
            byte[] arrayOfByte = new byte['က'];
            for (; ; ) {
                int i = localFileInputStream.read(arrayOfByte);
                if (i == -1) {
                    break;
                }
                paramOutputStream.write(arrayOfByte, 0, i);
                o.a(o.this, i);
            }
            paramOutputStream.write(o.b());
            o.a(o.this, o.b().length);
            paramOutputStream.flush();
            a.a(localFileInputStream);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */