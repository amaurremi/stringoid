package com.mopub.common;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
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

public final class DiskLruCache
        implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream p = new e();
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
    private final LinkedHashMap<String, g> l = new LinkedHashMap(0, 0.75F, true);
    private int m;
    private long n = 0L;
    private final Callable<Void> o = new d(this);

    private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong) {
        this.c = paramFile;
        this.g = paramInt1;
        this.d = new File(paramFile, "journal");
        this.e = new File(paramFile, "journal.tmp");
        this.f = new File(paramFile, "journal.bkp");
        this.i = paramInt2;
        this.h = paramLong;
    }

    private DiskLruCache.Editor a(String paramString, long paramLong) {
        for (; ; ) {
            DiskLruCache.Editor localEditor;
            try {
                f();
                b(paramString);
                g localg = (g) this.l.get(paramString);
                if (paramLong != -1L) {
                    if (localg != null) {
                        long l1 = g.e(localg);
                        if (l1 == paramLong) {
                        }
                    } else {
                        paramString = null;
                        return paramString;
                    }
                }
                if (localg == null) {
                    localg = new g(this, paramString, null);
                    this.l.put(paramString, localg);
                    localEditor = new DiskLruCache.Editor(this, localg, null);
                    g.a(localg, localEditor);
                    this.k.write("DIRTY " + paramString + '\n');
                    this.k.flush();
                    paramString = localEditor;
                    continue;
                }
                localEditor = g.a(localg);
            } finally {
            }
            if (localEditor != null) {
                paramString = null;
            }
        }
    }

    private void a(DiskLruCache.Editor paramEditor, boolean paramBoolean) {
        int i3 = 0;
        g localg;
        try {
            localg = DiskLruCache.Editor.a(paramEditor);
            if (g.a(localg) != paramEditor) {
                throw new IllegalStateException();
            }
        } finally {
        }
        int i2 = i3;
        if (paramBoolean) {
            i2 = i3;
            if (!g.d(localg)) {
                int i1 = 0;
                for (; ; ) {
                    i2 = i3;
                    if (i1 >= this.i) {
                        break;
                    }
                    if (DiskLruCache.Editor.b(paramEditor)[i1] == 0) {
                        paramEditor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
                    }
                    if (!localg.getDirtyFile(i1).exists()) {
                        paramEditor.abort();
                        return;
                    }
                    i1 += 1;
                }
            }
        }
        for (; ; ) {
            long l1;
            if (i2 < this.i) {
                paramEditor = localg.getDirtyFile(i2);
                if (paramBoolean) {
                    if (paramEditor.exists()) {
                        File localFile = localg.getCleanFile(i2);
                        paramEditor.renameTo(localFile);
                        l1 = g.b(localg)[i2];
                        long l2 = localFile.length();
                        g.b(localg)[i2] = l2;
                        this.j = (this.j - l1 + l2);
                    }
                } else {
                    a(paramEditor);
                }
            } else {
                this.m += 1;
                g.a(localg, null);
                if ((g.d(localg) | paramBoolean)) {
                    g.a(localg, true);
                    this.k.write("CLEAN " + g.c(localg) + localg.getLengths() + '\n');
                    if (paramBoolean) {
                        l1 = this.n;
                        this.n = (1L + l1);
                        g.a(localg, l1);
                    }
                }
                for (; ; ) {
                    this.k.flush();
                    if ((this.j <= this.h) && (!e())) {
                        break;
                    }
                    this.b.submit(this.o);
                    break;
                    this.l.remove(g.c(localg));
                    this.k.write("REMOVE " + g.c(localg) + '\n');
                }
            }
            i2 += 1;
        }
    }

    private static void a(File paramFile) {
        if ((paramFile.exists()) && (!paramFile.delete())) {
            throw new IOException();
        }
    }

    private static void a(File paramFile1, File paramFile2, boolean paramBoolean) {
        if (paramBoolean) {
            a(paramFile2);
        }
        if (!paramFile1.renameTo(paramFile2)) {
            throw new IOException();
        }
    }

    private void a(String paramString) {
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
            g localg2 = (g) this.l.get(str);
            g localg1 = localg2;
            if (localg2 == null) {
                localg1 = new g(this, str, null);
                this.l.put(str, localg1);
            }
            if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN"))) {
                paramString = paramString.substring(i3 + 1).split(" ");
                g.a(localg1, true);
                g.a(localg1, null);
                g.a(localg1, paramString);
                return;
            }
            if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY"))) {
                g.a(localg1, new DiskLruCache.Editor(this, localg1, null));
                return;
            }
            if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
                break;
            }
            throw new IOException("unexpected journal line: " + paramString);
        }
    }

    private static String b(InputStream paramInputStream) {
        return DiskLruCacheUtil.a(new InputStreamReader(paramInputStream, DiskLruCacheUtil.b));
    }

    private void b() {
        h localh = new h(new FileInputStream(this.d), DiskLruCacheUtil.a);
        int i1;
        try {
            String str1 = localh.readLine();
            String str2 = localh.readLine();
            String str3 = localh.readLine();
            String str4 = localh.readLine();
            String str5 = localh.readLine();
            if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.g).equals(str3)) || (!Integer.toString(this.i).equals(str4)) || (!"".equals(str5))) {
                throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
            }
        } finally {
            DiskLruCacheUtil.a(localh);
            throw ((Throwable) localObject);
        }
    }

    private void b(String paramString) {
        if (!a.matcher(paramString).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
        }
    }

    private void c() {
        a(this.e);
        Iterator localIterator = this.l.values().iterator();
        while (localIterator.hasNext()) {
            g localg = (g) localIterator.next();
            int i1;
            if (g.a(localg) == null) {
                i1 = 0;
                while (i1 < this.i) {
                    this.j += g.b(localg)[i1];
                    i1 += 1;
                }
            } else {
                g.a(localg, null);
                i1 = 0;
                while (i1 < this.i) {
                    a(localg.getCleanFile(i1));
                    a(localg.getDirtyFile(i1));
                    i1 += 1;
                }
                localIterator.remove();
            }
        }
    }

    private void d() {
        for (; ; ) {
            try {
                if (this.k != null) {
                    this.k.close();
                }
                BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), DiskLruCacheUtil.a));
                g localg;
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
                    localg = (g) localIterator.next();
                    if (g.a(localg) != null) {
                        localBufferedWriter.write("DIRTY " + g.c(localg) + '\n');
                        continue;
                        localObject1 =finally;
                    }
                } finally {
                    localBufferedWriter.close();
                }
                ((Writer) localObject1).write("CLEAN " + g.c(localg) + localg.getLengths() + '\n');
            } finally {
            }
        }
        ((Writer) localObject1).close();
        if (this.d.exists()) {
            a(this.d, this.f, true);
        }
        a(this.e, this.d, false);
        this.f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), DiskLruCacheUtil.a));
    }

    private boolean e() {
        return (this.m >= 2000) && (this.m >= this.l.size());
    }

    private void f() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void g() {
        while (this.j > this.h) {
            remove((String) ((Map.Entry) this.l.entrySet().iterator().next()).getKey());
        }
    }

    public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong) {
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
                break label150;
            }
            ((File) localObject).delete();
        }
        for (; ; ) {
            localObject = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
            if (!((DiskLruCache) localObject).d.exists()) {
                break label214;
            }
            try {
                ((DiskLruCache) localObject).b();
                ((DiskLruCache) localObject).c();
                ((DiskLruCache) localObject).k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((DiskLruCache) localObject).d, true), DiskLruCacheUtil.a));
                return (DiskLruCache) localObject;
            } catch (IOException localIOException) {
                label150:
                System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
                ((DiskLruCache) localObject).delete();
            }
            a((File) localObject, localFile, false);
        }
        label214:
        paramFile.mkdirs();
        paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        paramFile.d();
        return paramFile;
    }

    public void close() {
        for (; ; ) {
            try {
                Object localObject1 = this.k;
                if (localObject1 == null) {
                    return;
                }
                localObject1 = new ArrayList(this.l.values()).iterator();
                if (((Iterator) localObject1).hasNext()) {
                    g localg = (g) ((Iterator) localObject1).next();
                    if (g.a(localg) == null) {
                        continue;
                    }
                    g.a(localg).abort();
                    continue;
                }
                g();
            } finally {
            }
            this.k.close();
            this.k = null;
        }
    }

    public void delete() {
        close();
        DiskLruCacheUtil.a(this.c);
    }

    public DiskLruCache.Editor edit(String paramString) {
        return a(paramString, -1L);
    }

    public void flush() {
        try {
            f();
            g();
            this.k.flush();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    /* Error */
    public DiskLruCache.Snapshot get(String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aload_0
        //   4: monitorenter
        //   5: aload_0
        //   6: invokespecial 126	com/mopub/common/DiskLruCache:f	()V
        //   9: aload_0
        //   10: aload_1
        //   11: invokespecial 129	com/mopub/common/DiskLruCache:b	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 65	com/mopub/common/DiskLruCache:l	Ljava/util/LinkedHashMap;
        //   18: aload_1
        //   19: invokevirtual 133	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   22: checkcast 135	com/mopub/common/g
        //   25: astore 6
        //   27: aload 6
        //   29: ifnonnull +10 -> 39
        //   32: aload 4
        //   34: astore_3
        //   35: aload_0
        //   36: monitorexit
        //   37: aload_3
        //   38: areturn
        //   39: aload 4
        //   41: astore_3
        //   42: aload 6
        //   44: invokestatic 199	com/mopub/common/g:d	(Lcom/mopub/common/g;)Z
        //   47: ifeq -12 -> 35
        //   50: aload_0
        //   51: getfield 115	com/mopub/common/DiskLruCache:i	I
        //   54: anewarray 508	java/io/InputStream
        //   57: astore 5
        //   59: iconst_0
        //   60: istore_2
        //   61: iload_2
        //   62: aload_0
        //   63: getfield 115	com/mopub/common/DiskLruCache:i	I
        //   66: if_icmpge +65 -> 131
        //   69: aload 5
        //   71: iload_2
        //   72: new 334	java/io/FileInputStream
        //   75: dup
        //   76: aload 6
        //   78: iload_2
        //   79: invokevirtual 223	com/mopub/common/g:getCleanFile	(I)Ljava/io/File;
        //   82: invokespecial 336	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   85: aastore
        //   86: iload_2
        //   87: iconst_1
        //   88: iadd
        //   89: istore_2
        //   90: goto -29 -> 61
        //   93: astore_1
        //   94: iconst_0
        //   95: istore_2
        //   96: aload 4
        //   98: astore_3
        //   99: iload_2
        //   100: aload_0
        //   101: getfield 115	com/mopub/common/DiskLruCache:i	I
        //   104: if_icmpge -69 -> 35
        //   107: aload 4
        //   109: astore_3
        //   110: aload 5
        //   112: iload_2
        //   113: aaload
        //   114: ifnull -79 -> 35
        //   117: aload 5
        //   119: iload_2
        //   120: aaload
        //   121: invokestatic 365	com/mopub/common/DiskLruCacheUtil:a	(Ljava/io/Closeable;)V
        //   124: iload_2
        //   125: iconst_1
        //   126: iadd
        //   127: istore_2
        //   128: goto -32 -> 96
        //   131: aload_0
        //   132: aload_0
        //   133: getfield 120	com/mopub/common/DiskLruCache:m	I
        //   136: iconst_1
        //   137: iadd
        //   138: putfield 120	com/mopub/common/DiskLruCache:m	I
        //   141: aload_0
        //   142: getfield 157	com/mopub/common/DiskLruCache:k	Ljava/io/Writer;
        //   145: new 159	java/lang/StringBuilder
        //   148: dup
        //   149: invokespecial 160	java/lang/StringBuilder:<init>	()V
        //   152: ldc_w 510
        //   155: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: aload_1
        //   159: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   162: bipush 10
        //   164: invokevirtual 169	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   167: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   170: invokevirtual 513	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
        //   173: pop
        //   174: aload_0
        //   175: invokespecial 253	com/mopub/common/DiskLruCache:e	()Z
        //   178: ifeq +15 -> 193
        //   181: aload_0
        //   182: getfield 85	com/mopub/common/DiskLruCache:b	Ljava/util/concurrent/ThreadPoolExecutor;
        //   185: aload_0
        //   186: getfield 92	com/mopub/common/DiskLruCache:o	Ljava/util/concurrent/Callable;
        //   189: invokevirtual 257	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
        //   192: pop
        //   193: new 515	com/mopub/common/DiskLruCache$Snapshot
        //   196: dup
        //   197: aload_0
        //   198: aload_1
        //   199: aload 6
        //   201: invokestatic 140	com/mopub/common/g:e	(Lcom/mopub/common/g;)J
        //   204: aload 5
        //   206: aload 6
        //   208: invokestatic 230	com/mopub/common/g:b	(Lcom/mopub/common/g;)[J
        //   211: aconst_null
        //   212: invokespecial 518	com/mopub/common/DiskLruCache$Snapshot:<init>	(Lcom/mopub/common/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/mopub/common/d;)V
        //   215: astore_3
        //   216: goto -181 -> 35
        //   219: astore_1
        //   220: aload_0
        //   221: monitorexit
        //   222: aload_1
        //   223: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	224	0	this	DiskLruCache
        //   0	224	1	paramString	String
        //   60	68	2	i1	int
        //   34	182	3	localObject1	Object
        //   1	107	4	localObject2	Object
        //   57	148	5	arrayOfInputStream	InputStream[]
        //   25	182	6	localg	g
        // Exception table:
        //   from	to	target	type
        //   61	86	93	java/io/FileNotFoundException
        //   5	27	219	finally
        //   42	59	219	finally
        //   61	86	219	finally
        //   99	107	219	finally
        //   117	124	219	finally
        //   131	193	219	finally
        //   193	216	219	finally
    }

    public File getDirectory() {
        return this.c;
    }

    public long getMaxSize() {
        try {
            long l1 = this.h;
            return l1;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    /* Error */
    public boolean isClosed() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 157	com/mopub/common/DiskLruCache:k	Ljava/io/Writer;
        //   6: astore_2
        //   7: aload_2
        //   8: ifnonnull +9 -> 17
        //   11: iconst_1
        //   12: istore_1
        //   13: aload_0
        //   14: monitorexit
        //   15: iload_1
        //   16: ireturn
        //   17: iconst_0
        //   18: istore_1
        //   19: goto -6 -> 13
        //   22: astore_2
        //   23: aload_0
        //   24: monitorexit
        //   25: aload_2
        //   26: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	27	0	this	DiskLruCache
        //   12	7	1	bool	boolean
        //   6	2	2	localWriter	Writer
        //   22	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	22	finally
    }

    public boolean remove(String paramString) {
        int i1 = 0;
        for (; ; ) {
            try {
                f();
                b(paramString);
                g localg = (g) this.l.get(paramString);
                Object localObject;
                if (localg != null) {
                    localObject = g.a(localg);
                    if (localObject == null) {
                    }
                } else {
                    bool = false;
                    return bool;
                    this.j -= g.b(localg)[i1];
                    g.b(localg)[i1] = 0L;
                    i1 += 1;
                }
                if (i1 < this.i) {
                    localObject = localg.getCleanFile(i1);
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
            if (e()) {
                this.b.submit(this.o);
            }
            boolean bool = true;
        }
    }

    public void setMaxSize(long paramLong) {
        try {
            this.h = paramLong;
            this.b.submit(this.o);
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public long size() {
        try {
            long l1 = this.j;
            return l1;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */