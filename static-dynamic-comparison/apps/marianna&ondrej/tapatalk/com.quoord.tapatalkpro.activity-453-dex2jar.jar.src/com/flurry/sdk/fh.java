package com.flurry.sdk;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class fh
        implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream p = new OutputStream() {
        public void write(int paramAnonymousInt)
                throws IOException {
        }
    };
    final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private final int i;
    private long j = 0L;
    private Writer k;
    private final LinkedHashMap<String, b> l = new LinkedHashMap(0, 0.75F, true);
    private int m;
    private long n = 0L;
    private final Callable<Void> o = new Callable() {
        public Void a()
                throws Exception {
            synchronized (fh.this) {
                if (fh.a(fh.this) == null) {
                    return null;
                }
                fh.b(fh.this);
                if (fh.c(fh.this)) {
                    fh.d(fh.this);
                    fh.a(fh.this, 0);
                }
                return null;
            }
        }
    };

    private fh(File paramFile, int paramInt1, int paramInt2, long paramLong) {
        this.c = paramFile;
        this.g = paramInt1;
        this.d = new File(paramFile, "journal");
        this.e = new File(paramFile, "journal.tmp");
        this.f = new File(paramFile, "journal.bkp");
        this.i = paramInt2;
        this.h = paramLong;
    }

    private a a(String paramString, long paramLong)
            throws IOException {
        for (; ; ) {
            a locala;
            try {
                g();
                e(paramString);
                b localb = (b) this.l.get(paramString);
                if (paramLong != -1L) {
                    if (localb != null) {
                        long l1 = b.e(localb);
                        if (l1 == paramLong) {
                        }
                    } else {
                        paramString = null;
                        return paramString;
                    }
                }
                if (localb == null) {
                    localb = new b(paramString, null);
                    this.l.put(paramString, localb);
                    locala = new a(localb, null);
                    b.a(localb, locala);
                    this.k.write("DIRTY " + paramString + '\n');
                    this.k.flush();
                    paramString = locala;
                    continue;
                }
                locala = b.a(localb);
            } finally {
            }
            if (locala != null) {
                paramString = null;
            }
        }
    }

    public static fh a(File paramFile, int paramInt1, int paramInt2, long paramLong)
            throws IOException {
        if (paramLong <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (paramInt2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        Object localObject = new File(paramFile, "journal.bkp");
        File localFile;
        if (((File) localObject).exists()) {
            localFile = new File(paramFile, "journal");
            if (!localFile.exists()) {
                break label148;
            }
            ((File) localObject).delete();
        }
        for (; ; ) {
            localObject = new fh(paramFile, paramInt1, paramInt2, paramLong);
            if (!((fh) localObject).d.exists()) {
                break label209;
            }
            try {
                ((fh) localObject).c();
                ((fh) localObject).d();
                ((fh) localObject).k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((fh) localObject).d, true), fj.a));
                return (fh) localObject;
            } catch (IOException localIOException) {
                label148:
                System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
                ((fh) localObject).a();
            }
            a((File) localObject, localFile, false);
        }
        label209:
        paramFile.mkdirs();
        paramFile = new fh(paramFile, paramInt1, paramInt2, paramLong);
        paramFile.e();
        return paramFile;
    }

    private void a(a parama, boolean paramBoolean)
            throws IOException {
        int i3 = 0;
        b localb;
        try {
            localb = a.a(parama);
            if (b.a(localb) != parama) {
                throw new IllegalStateException();
            }
        } finally {
        }
        int i2 = i3;
        if (paramBoolean) {
            i2 = i3;
            if (!b.d(localb)) {
                int i1 = 0;
                for (; ; ) {
                    i2 = i3;
                    if (i1 >= this.i) {
                        break;
                    }
                    if (a.b(parama)[i1] == 0) {
                        parama.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
                    }
                    if (!localb.b(i1).exists()) {
                        parama.b();
                        return;
                    }
                    i1 += 1;
                }
            }
        }
        for (; ; ) {
            long l1;
            if (i2 < this.i) {
                parama = localb.b(i2);
                if (paramBoolean) {
                    if (parama.exists()) {
                        File localFile = localb.a(i2);
                        parama.renameTo(localFile);
                        l1 = b.b(localb)[i2];
                        long l2 = localFile.length();
                        b.b(localb)[i2] = l2;
                        this.j = (this.j - l1 + l2);
                    }
                } else {
                    a(parama);
                }
            } else {
                this.m += 1;
                b.a(localb, null);
                if ((b.d(localb) | paramBoolean)) {
                    b.a(localb, true);
                    this.k.write("CLEAN " + b.c(localb) + localb.a() + '\n');
                    if (paramBoolean) {
                        l1 = this.n;
                        this.n = (1L + l1);
                        b.a(localb, l1);
                    }
                }
                for (; ; ) {
                    this.k.flush();
                    if ((this.j <= this.h) && (!f())) {
                        break;
                    }
                    this.b.submit(this.o);
                    break;
                    this.l.remove(b.c(localb));
                    this.k.write("REMOVE " + b.c(localb) + '\n');
                }
            }
            i2 += 1;
        }
    }

    private static void a(File paramFile)
            throws IOException {
        if ((paramFile.exists()) && (!paramFile.delete())) {
            throw new IOException();
        }
    }

    private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
            throws IOException {
        if (paramBoolean) {
            a(paramFile2);
        }
        if (!paramFile1.renameTo(paramFile2)) {
            throw new IOException();
        }
    }

    private void c()
            throws IOException {
        fi localfi = new fi(new FileInputStream(this.d), fj.a);
        int i1;
        try {
            String str1 = localfi.a();
            String str2 = localfi.a();
            String str3 = localfi.a();
            String str4 = localfi.a();
            String str5 = localfi.a();
            if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.g).equals(str3)) || (!Integer.toString(this.i).equals(str4)) || (!"".equals(str5))) {
                throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
            }
        } finally {
            fj.a(localfi);
            throw ((Throwable) localObject);
        }
    }

    private void d()
            throws IOException {
        a(this.e);
        Iterator localIterator = this.l.values().iterator();
        while (localIterator.hasNext()) {
            b localb = (b) localIterator.next();
            int i1;
            if (b.a(localb) == null) {
                i1 = 0;
                while (i1 < this.i) {
                    this.j += b.b(localb)[i1];
                    i1 += 1;
                }
            } else {
                b.a(localb, null);
                i1 = 0;
                while (i1 < this.i) {
                    a(localb.a(i1));
                    a(localb.b(i1));
                    i1 += 1;
                }
                localIterator.remove();
            }
        }
    }

    private void d(String paramString)
            throws IOException {
        int i1 = paramString.indexOf(' ');
        if (i1 == -1) {
            throw new IOException("unexpected journal line: " + paramString);
        }
        int i2 = i1 + 1;
        int i3 = paramString.indexOf(' ', i2);
        String str;
        if (i3 == -1) {
            str = paramString.substring(i2);
            if ((i1 == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
                this.l.remove(str);
            }
        } else {
            str = paramString.substring(i2, i3);
        }
        for (; ; ) {
            b localb2 = (b) this.l.get(str);
            b localb1 = localb2;
            if (localb2 == null) {
                localb1 = new b(str, null);
                this.l.put(str, localb1);
            }
            if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN"))) {
                paramString = paramString.substring(i3 + 1).split(" ");
                b.a(localb1, true);
                b.a(localb1, null);
                b.a(localb1, paramString);
                return;
            }
            if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY"))) {
                b.a(localb1, new a(localb1, null));
                return;
            }
            if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
                break;
            }
            throw new IOException("unexpected journal line: " + paramString);
        }
    }

    private void e()
            throws IOException {
        for (; ; ) {
            try {
                if (this.k != null) {
                    this.k.close();
                }
                BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), fj.a));
                b localb;
                try {
                    localBufferedWriter.write("libcore.io.DiskLruCache");
                    localBufferedWriter.write("\n");
                    localBufferedWriter.write("1");
                    localBufferedWriter.write("\n");
                    localBufferedWriter.write(Integer.toString(this.g));
                    localBufferedWriter.write("\n");
                    localBufferedWriter.write(Integer.toString(this.i));
                    localBufferedWriter.write("\n");
                    localBufferedWriter.write("\n");
                    Iterator localIterator = this.l.values().iterator();
                    if (!localIterator.hasNext()) {
                        break;
                    }
                    localb = (b) localIterator.next();
                    if (b.a(localb) != null) {
                        localBufferedWriter.write("DIRTY " + b.c(localb) + '\n');
                        continue;
                        localObject1 =finally;
                    }
                } finally {
                    localBufferedWriter.close();
                }
                ((Writer) localObject1).write("CLEAN " + b.c(localb) + localb.a() + '\n');
            } finally {
            }
        }
        ((Writer) localObject1).close();
        if (this.d.exists()) {
            a(this.d, this.f, true);
        }
        a(this.e, this.d, false);
        this.f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), fj.a));
    }

    private void e(String paramString) {
        if (!a.matcher(paramString).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
        }
    }

    private boolean f() {
        return (this.m >= 2000) && (this.m >= this.l.size());
    }

    private void g() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void h()
            throws IOException {
        while (this.j > this.h) {
            c((String) ((Map.Entry) this.l.entrySet().iterator().next()).getKey());
        }
    }

    public c a(String paramString)
            throws IOException {
        label211:
        for (; ; ) {
            try {
                g();
                e(paramString);
                b localb = (b) this.l.get(paramString);
                if (localb == null) {
                    paramString = null;
                    return paramString;
                }
                if (!b.d(localb)) {
                    paramString = null;
                } else {
                    InputStream[] arrayOfInputStream = new InputStream[this.i];
                    int i1 = 0;
                    try {
                        if (i1 >= this.i) {
                            continue;
                        }
                        arrayOfInputStream[i1] = new FileInputStream(localb.a(i1));
                        i1 += 1;
                        continue;
                        if (arrayOfInputStream[i1] == null) {
                            break label211;
                        }
                    } catch (FileNotFoundException paramString) {
                        i1 = 0;
                        if (i1 >= this.i) {
                            break label211;
                        }
                    }
                    fj.a(arrayOfInputStream[i1]);
                    i1 += 1;
                    continue;
                    this.m += 1;
                    this.k.append("READ " + paramString + '\n');
                    if (f()) {
                        this.b.submit(this.o);
                    }
                    paramString = new c(paramString, b.e(localb), arrayOfInputStream, b.b(localb), null);
                    continue;
                    paramString = null;
                }
            } finally {
            }
        }
    }

    public void a()
            throws IOException {
        close();
        fj.a(this.c);
    }

    public a b(String paramString)
            throws IOException {
        return a(paramString, -1L);
    }

    public boolean c(String paramString)
            throws IOException {
        int i1 = 0;
        for (; ; ) {
            try {
                g();
                e(paramString);
                b localb = (b) this.l.get(paramString);
                Object localObject;
                if (localb != null) {
                    localObject = b.a(localb);
                    if (localObject == null) {
                    }
                } else {
                    bool = false;
                    return bool;
                    this.j -= b.b(localb)[i1];
                    b.b(localb)[i1] = 0L;
                    i1 += 1;
                }
                if (i1 < this.i) {
                    localObject = localb.a(i1);
                    if ((!((File) localObject).exists()) || (((File) localObject).delete())) {
                        continue;
                    }
                    throw new IOException("failed to delete " + localObject);
                }
            } finally {
            }
            this.m += 1;
            this.k.append("REMOVE " + paramString + '\n');
            this.l.remove(paramString);
            if (f()) {
                this.b.submit(this.o);
            }
            boolean bool = true;
        }
    }

    public void close()
            throws IOException {
        for (; ; ) {
            try {
                Object localObject1 = this.k;
                if (localObject1 == null) {
                    return;
                }
                localObject1 = new ArrayList(this.l.values()).iterator();
                if (((Iterator) localObject1).hasNext()) {
                    b localb = (b) ((Iterator) localObject1).next();
                    if (b.a(localb) == null) {
                        continue;
                    }
                    b.a(localb).b();
                    continue;
                }
                h();
            } finally {
            }
            this.k.close();
            this.k = null;
        }
    }

    public final class a {
        private final fh.b b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        private a(fh.b paramb) {
            this.b = paramb;
            if (fh.b.d(paramb)) {
            }
            for (this$1 = null; ; this$1 = new boolean[fh.e(fh.this)]) {
                this.c = fh.this;
                return;
            }
        }

        public OutputStream a(int paramInt)
                throws IOException {
            synchronized (fh.this) {
                if (fh.b.a(this.b) != this) {
                    throw new IllegalStateException();
                }
            }
            if (!fh.b.d(this.b)) {
                this.c[paramInt] = true;
            }
            File localFile = this.b.b(paramInt);
            try {
                Object localObject2 = new FileOutputStream(localFile);
                localObject2 = new a((OutputStream) localObject2, null);
                return (OutputStream) localObject2;
            } catch (FileNotFoundException localFileNotFoundException1) {
                for (; ; ) {
                    fh.f(fh.this).mkdirs();
                    try {
                        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
                    } catch (FileNotFoundException localFileNotFoundException2) {
                        OutputStream localOutputStream = fh.b();
                        return localOutputStream;
                    }
                }
            }
        }

        public void a()
                throws IOException {
            if (this.d) {
                fh.a(fh.this, this, false);
                fh.this.c(fh.b.c(this.b));
            }
            for (; ; ) {
                this.e = true;
                return;
                fh.a(fh.this, this, true);
            }
        }

        public void b()
                throws IOException {
            fh.a(fh.this, this, false);
        }

        class a
                extends FilterOutputStream {
            private a(OutputStream paramOutputStream) {
                super();
            }

            public void close() {
                try {
                    this.out.close();
                    return;
                } catch (IOException localIOException) {
                    fh.a.a(fh.a.this, true);
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                    return;
                } catch (IOException localIOException) {
                    fh.a.a(fh.a.this, true);
                }
            }

            public void write(int paramInt) {
                try {
                    this.out.write(paramInt);
                    return;
                } catch (IOException localIOException) {
                    fh.a.a(fh.a.this, true);
                }
            }

            public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
                try {
                    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
                    return;
                } catch (IOException paramArrayOfByte) {
                    fh.a.a(fh.a.this, true);
                }
            }
        }
    }

    final class b {
        private final String b;
        private final long[] c;
        private boolean d;
        private fh.a e;
        private long f;

        private b(String paramString) {
            this.b = paramString;
            this.c = new long[fh.e(fh.this)];
        }

        private void a(String[] paramArrayOfString)
                throws IOException {
            if (paramArrayOfString.length != fh.e(fh.this)) {
                throw b(paramArrayOfString);
            }
            int i = 0;
            try {
                while (i < paramArrayOfString.length) {
                    this.c[i] = Long.parseLong(paramArrayOfString[i]);
                    i += 1;
                }
                return;
            } catch (NumberFormatException localNumberFormatException) {
                throw b(paramArrayOfString);
            }
        }

        private IOException b(String[] paramArrayOfString)
                throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
        }

        public File a(int paramInt) {
            return new File(fh.f(fh.this), this.b + "." + paramInt);
        }

        public String a()
                throws IOException {
            StringBuilder localStringBuilder = new StringBuilder();
            long[] arrayOfLong = this.c;
            int j = arrayOfLong.length;
            int i = 0;
            while (i < j) {
                long l = arrayOfLong[i];
                localStringBuilder.append(' ').append(l);
                i += 1;
            }
            return localStringBuilder.toString();
        }

        public File b(int paramInt) {
            return new File(fh.f(fh.this), this.b + "." + paramInt + ".tmp");
        }
    }

    public final class c
            implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private c(String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong) {
            this.b = paramString;
            this.c = paramLong;
            this.d = paramArrayOfInputStream;
            this.e = paramArrayOfLong;
        }

        public InputStream a(int paramInt) {
            return this.d[paramInt];
        }

        public void close() {
            InputStream[] arrayOfInputStream = this.d;
            int j = arrayOfInputStream.length;
            int i = 0;
            while (i < j) {
                fj.a(arrayOfInputStream[i]);
                i += 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */