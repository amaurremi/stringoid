package com.everimaging.fotorsdk.http;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class h
        implements HttpEntity {
    private static final UnsupportedOperationException a = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final StringBuilder c = new StringBuilder(128);
    private static final byte[] d = "true".getBytes();
    private static final byte[] e = "false".getBytes();
    private static final byte[] f = "null".getBytes();
    private static final byte[] g = a("name");
    private static final byte[] h = a("type");
    private static final byte[] i = a("contents");
    private static final byte[] j = a("_elapsed");
    private static final Header k = new BasicHeader("Content-Type", "application/json");
    private static final Header l = new BasicHeader("Content-Encoding", "gzip");
    private final byte[] b = new byte['က'];
    private final Map<String, Object> m = new HashMap();
    private final Header n;
    private final m o;

    public h(m paramm, boolean paramBoolean) {
        this.o = paramm;
        if (paramBoolean) {
        }
        for (paramm = l; ; paramm = null) {
            this.n = paramm;
            return;
        }
    }

    private void a(OutputStream paramOutputStream)
            throws IOException {
        paramOutputStream.write(34);
    }

    private void a(OutputStream paramOutputStream, l.a parama)
            throws IOException {
        a(paramOutputStream, parama.a.getName(), parama.b);
        int i2 = (int) parama.a.length();
        parama = new FileInputStream(parama.a);
        e locale = new e(paramOutputStream, 18);
        int i1 = 0;
        for (; ; ) {
            int i3 = parama.read(this.b);
            if (i3 == -1) {
                break;
            }
            locale.write(this.b, 0, i3);
            i1 += i3;
            this.o.b(i1, i2);
        }
        a.a(locale);
        a(paramOutputStream);
        a.a(parama);
    }

    private void a(OutputStream paramOutputStream, l.b paramb)
            throws IOException {
        a(paramOutputStream, paramb.b, paramb.c);
        e locale = new e(paramOutputStream, 18);
        for (; ; ) {
            int i1 = paramb.a.read(this.b);
            if (i1 == -1) {
                break;
            }
            locale.write(this.b, 0, i1);
        }
        a.a(locale);
        a(paramOutputStream);
        if (paramb.d) {
            a.a(paramb.a);
        }
    }

    private void a(OutputStream paramOutputStream, String paramString1, String paramString2)
            throws IOException {
        paramOutputStream.write(g);
        paramOutputStream.write(58);
        paramOutputStream.write(a(paramString1));
        paramOutputStream.write(44);
        paramOutputStream.write(h);
        paramOutputStream.write(58);
        paramOutputStream.write(a(paramString2));
        paramOutputStream.write(44);
        paramOutputStream.write(i);
        paramOutputStream.write(58);
        paramOutputStream.write(34);
    }

    static byte[] a(String paramString) {
        if (paramString == null) {
            return f;
        }
        c.append('"');
        int i3 = paramString.length();
        int i1 = -1;
        int i2 = i1 + 1;
        if (i2 < i3) {
            char c1 = paramString.charAt(i2);
            String str;
            int i4;
            switch (c1) {
                default:
                    if (((c1 >= 0) && (c1 <= '\037')) || ((c1 >= '') && (c1 <= '')) || ((c1 >= ' ') && (c1 <= '⃿'))) {
                        str = Integer.toHexString(c1);
                        c.append("\\u");
                        i4 = str.length();
                        i1 = 0;
                    }
                    break;
                case '"':
                    while (i1 < 4 - i4) {
                        c.append('0');
                        i1 += 1;
                        continue;
                        c.append("\\\"");
                    }
            }
            for (; ; ) {
                i1 = i2;
                break;
                c.append("\\\\");
                continue;
                c.append("\\b");
                continue;
                c.append("\\f");
                continue;
                c.append("\\n");
                continue;
                c.append("\\r");
                continue;
                c.append("\\t");
                continue;
                c.append(str.toUpperCase(Locale.US));
                continue;
                c.append(c1);
            }
        }
        c.append('"');
        try {
            paramString = c.toString().getBytes();
            return paramString;
        } finally {
            c.setLength(0);
        }
    }

    public void a(String paramString, Object paramObject) {
        this.m.put(paramString, paramObject);
    }

    public void consumeContent()
            throws IOException, UnsupportedOperationException {
    }

    public InputStream getContent()
            throws IOException, UnsupportedOperationException {
        throw a;
    }

    public Header getContentEncoding() {
        return this.n;
    }

    public long getContentLength() {
        return -1L;
    }

    public Header getContentType() {
        return k;
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

    public void writeTo(OutputStream paramOutputStream)
            throws IOException {
        if (paramOutputStream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long l1 = System.currentTimeMillis();
        Object localObject1 = paramOutputStream;
        if (this.n != null) {
            localObject1 = new GZIPOutputStream(paramOutputStream, 4096);
        }
        ((OutputStream) localObject1).write(123);
        Iterator localIterator = this.m.keySet().iterator();
        while (localIterator.hasNext()) {
            paramOutputStream = (String) localIterator.next();
            Object localObject2 = this.m.get(paramOutputStream);
            if (localObject2 != null) {
                ((OutputStream) localObject1).write(a(paramOutputStream));
                ((OutputStream) localObject1).write(58);
                boolean bool = localObject2 instanceof l.a;
                if ((bool) || ((localObject2 instanceof l.b))) {
                    ((OutputStream) localObject1).write(123);
                    if (bool) {
                        a((OutputStream) localObject1, (l.a) localObject2);
                        label162:
                        ((OutputStream) localObject1).write(125);
                    }
                }
                for (; ; ) {
                    ((OutputStream) localObject1).write(44);
                    break;
                    a((OutputStream) localObject1, (l.b) localObject2);
                    break label162;
                    if ((localObject2 instanceof Boolean)) {
                        if (((Boolean) localObject2).booleanValue()) {
                        }
                        for (paramOutputStream = d; ; paramOutputStream = e) {
                            ((OutputStream) localObject1).write(paramOutputStream);
                            break;
                        }
                    }
                    if ((localObject2 instanceof Long)) {
                        ((OutputStream) localObject1).write((((Number) localObject2).longValue() + "").getBytes());
                    } else if ((localObject2 instanceof Double)) {
                        ((OutputStream) localObject1).write((((Number) localObject2).doubleValue() + "").getBytes());
                    } else if ((localObject2 instanceof Float)) {
                        ((OutputStream) localObject1).write((((Number) localObject2).floatValue() + "").getBytes());
                    } else if ((localObject2 instanceof Integer)) {
                        ((OutputStream) localObject1).write((((Number) localObject2).intValue() + "").getBytes());
                    } else {
                        ((OutputStream) localObject1).write(localObject2.toString().getBytes());
                    }
                }
            }
        }
        ((OutputStream) localObject1).write(j);
        ((OutputStream) localObject1).write(58);
        l1 = System.currentTimeMillis() - l1;
        ((OutputStream) localObject1).write((l1 + "}").getBytes());
        Log.i("JsonStreamerEntity", "Uploaded JSON in " + Math.floor(l1 / 1000L) + " seconds");
        ((OutputStream) localObject1).flush();
        a.a((OutputStream) localObject1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */