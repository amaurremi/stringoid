package com.b.a.a.a;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
  implements Closeable
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final File gg;
  private final File gh;
  private final File gi;
  private final int gj;
  private final long gk;
  private final int gl;
  private long gm = 0L;
  private Writer gn;
  private final LinkedHashMap<String, b> go = new LinkedHashMap(0, 0.75F, true);
  private int gp;
  private long gq = 0L;
  private final ExecutorService gr = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final Callable<Void> gs = new Callable()
  {
    public Void fq()
    {
      synchronized (a.this)
      {
        if (a.a(a.this) == null) {
          return null;
        }
        a.b(a.this);
        if (a.c(a.this))
        {
          a.d(a.this);
          a.a(a.this, 0);
        }
        return null;
      }
    }
  };
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.gg = paramFile;
    this.gj = paramInt1;
    this.gh = new File(paramFile, "journal");
    this.gi = new File(paramFile, "journal.tmp");
    this.gl = paramInt2;
    this.gk = paramLong;
  }
  
  private a a(String paramString, long paramLong)
  {
    for (;;)
    {
      a locala;
      try
      {
        fp();
        l(paramString);
        b localb = (b)this.go.get(paramString);
        if (paramLong != -1L) {
          if (localb != null)
          {
            long l = b.e(localb);
            if (l == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localb == null)
        {
          localb = new b(paramString, null);
          this.go.put(paramString, localb);
          locala = new a(localb, null);
          b.a(localb, locala);
          this.gn.write("DIRTY " + paramString + '\n');
          this.gn.flush();
          paramString = locala;
          continue;
        }
        locala = b.a(localb);
      }
      finally {}
      if (locala != null) {
        paramString = null;
      }
    }
  }
  
  public static a a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    a locala = new a(paramFile, paramInt1, paramInt2, paramLong);
    if (locala.gh.exists()) {
      try
      {
        locala.fl();
        locala.fm();
        locala.gn = new BufferedWriter(new FileWriter(locala.gh, true), 8192);
        return locala;
      }
      catch (IOException localIOException)
      {
        locala.delete();
      }
    }
    paramFile.mkdirs();
    paramFile = new a(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.fn();
    return paramFile;
  }
  
  public static String a(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        throw new EOFException();
      }
      if (i == 10)
      {
        i = localStringBuilder.length();
        if ((i > 0) && (localStringBuilder.charAt(i - 1) == '\r')) {
          localStringBuilder.setLength(i - 1);
        }
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i);
    }
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int k = 0;
    b localb;
    try
    {
      localb = a.a(parama);
      if (b.a(localb) != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int j = k;
    int i;
    if (paramBoolean)
    {
      j = k;
      if (!b.d(localb))
      {
        i = 0;
        j = k;
        if (i < this.gl)
        {
          if (localb.ay(i).exists()) {
            break label398;
          }
          parama.abort();
          throw new IllegalStateException("edit didn't create file " + i);
        }
      }
    }
    for (;;)
    {
      long l1;
      if (j < this.gl)
      {
        parama = localb.ay(j);
        if (paramBoolean)
        {
          if (parama.exists())
          {
            File localFile = localb.ax(j);
            parama.renameTo(localFile);
            l1 = b.b(localb)[j];
            long l2 = localFile.length();
            b.b(localb)[j] = l2;
            this.gm = (this.gm - l1 + l2);
          }
        }
        else {
          c(parama);
        }
      }
      else
      {
        this.gp += 1;
        b.a(localb, null);
        if ((b.d(localb) | paramBoolean))
        {
          b.a(localb, true);
          this.gn.write("CLEAN " + b.c(localb) + localb.fr() + '\n');
          if (paramBoolean)
          {
            l1 = this.gq;
            this.gq = (1L + l1);
            b.a(localb, l1);
          }
        }
        for (;;)
        {
          if ((this.gm > this.gk) || (fo())) {
            this.gr.submit(this.gs);
          }
          return;
          this.go.remove(b.c(localb));
          this.gn.write("REMOVE " + b.c(localb) + '\n');
        }
        label398:
        i += 1;
        break;
      }
      j += 1;
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void b(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IllegalArgumentException("not a directory: " + paramFile);
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      paramFile = arrayOfFile[i];
      if (paramFile.isDirectory()) {
        b(paramFile);
      }
      if (!paramFile.delete()) {
        throw new IOException("failed to delete file: " + paramFile);
      }
      i += 1;
    }
  }
  
  private static void c(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static <T> T[] copyOfRange(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfT.length;
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt2);
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  private void fl()
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.gh), 8192);
    try
    {
      String str1 = a(localBufferedInputStream);
      String str2 = a(localBufferedInputStream);
      String str3 = a(localBufferedInputStream);
      String str4 = a(localBufferedInputStream);
      String str5 = a(localBufferedInputStream);
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.gj).equals(str3)) || (!Integer.toString(this.gl).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      a(localBufferedInputStream);
    }
  }
  
  private void fm()
  {
    c(this.gi);
    Iterator localIterator = this.go.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int i;
      if (b.a(localb) == null)
      {
        i = 0;
        while (i < this.gl)
        {
          this.gm += b.b(localb)[i];
          i += 1;
        }
      }
      else
      {
        b.a(localb, null);
        i = 0;
        while (i < this.gl)
        {
          c(localb.ax(i));
          c(localb.ay(i));
          i += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void fn()
  {
    for (;;)
    {
      try
      {
        if (this.gn != null) {
          this.gn.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(this.gi), 8192);
        localBufferedWriter.write("libcore.io.DiskLruCache");
        localBufferedWriter.write("\n");
        localBufferedWriter.write("1");
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.gj));
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.gl));
        localBufferedWriter.write("\n");
        localBufferedWriter.write("\n");
        Iterator localIterator = this.go.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        b localb = (b)localIterator.next();
        if (b.a(localb) != null) {
          localBufferedWriter.write("DIRTY " + b.c(localb) + '\n');
        } else {
          ((Writer)localObject).write("CLEAN " + b.c(localb) + localb.fr() + '\n');
        }
      }
      finally {}
    }
    ((Writer)localObject).close();
    this.gi.renameTo(this.gh);
    this.gn = new BufferedWriter(new FileWriter(this.gh, true), 8192);
  }
  
  private boolean fo()
  {
    return (this.gp >= 2000) && (this.gp >= this.go.size());
  }
  
  private void fp()
  {
    if (this.gn == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void g(String paramString)
  {
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length < 2) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    String str = arrayOfString[1];
    if ((arrayOfString[0].equals("REMOVE")) && (arrayOfString.length == 2))
    {
      this.go.remove(str);
      return;
    }
    b localb = (b)this.go.get(str);
    if (localb == null)
    {
      localb = new b(str, null);
      this.go.put(str, localb);
    }
    for (;;)
    {
      if ((arrayOfString[0].equals("CLEAN")) && (arrayOfString.length == this.gl + 2))
      {
        b.a(localb, true);
        b.a(localb, null);
        b.a(localb, (String[])copyOfRange(arrayOfString, 2, arrayOfString.length));
        return;
      }
      if ((arrayOfString[0].equals("DIRTY")) && (arrayOfString.length == 2))
      {
        b.a(localb, new a(localb, null));
        return;
      }
      if ((arrayOfString[0].equals("READ")) && (arrayOfString.length == 2)) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void l(String paramString)
  {
    if ((paramString.contains(" ")) || (paramString.contains("\n")) || (paramString.contains("\r"))) {
      throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + paramString + "\"");
    }
  }
  
  private void trimToSize()
  {
    while (this.gm > this.gk) {
      k((String)((Map.Entry)this.go.entrySet().iterator().next()).getKey());
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.gn;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.go.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          b localb = (b)((Iterator)localObject1).next();
          if (b.a(localb) == null) {
            continue;
          }
          b.a(localb).abort();
          continue;
        }
        trimToSize();
      }
      finally {}
      this.gn.close();
      this.gn = null;
    }
  }
  
  public void delete()
  {
    close();
    b(this.gg);
  }
  
  public void flush()
  {
    try
    {
      fp();
      trimToSize();
      this.gn.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public c h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 123	com/b/a/a/a/a:fp	()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 127	com/b/a/a/a/a:l	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 70	com/b/a/a/a/a:go	Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual 131	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 15	com/b/a/a/a/a$b
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +9 -> 33
    //   27: aconst_null
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: aload_3
    //   34: invokestatic 256	com/b/a/a/a/a$b:d	(Lcom/b/a/a/a/a$b;)Z
    //   37: ifne +8 -> 45
    //   40: aconst_null
    //   41: astore_1
    //   42: goto -13 -> 29
    //   45: aload_0
    //   46: getfield 114	com/b/a/a/a/a:gl	I
    //   49: anewarray 228	java/io/InputStream
    //   52: astore 4
    //   54: iconst_0
    //   55: istore_2
    //   56: iload_2
    //   57: aload_0
    //   58: getfield 114	com/b/a/a/a/a:gl	I
    //   61: if_icmpge +32 -> 93
    //   64: aload 4
    //   66: iload_2
    //   67: new 392	java/io/FileInputStream
    //   70: dup
    //   71: aload_3
    //   72: iload_2
    //   73: invokevirtual 272	com/b/a/a/a/a$b:ax	(I)Ljava/io/File;
    //   76: invokespecial 394	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   79: aastore
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: istore_2
    //   84: goto -28 -> 56
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -61 -> 29
    //   93: aload_0
    //   94: aload_0
    //   95: getfield 119	com/b/a/a/a/a:gp	I
    //   98: iconst_1
    //   99: iadd
    //   100: putfield 119	com/b/a/a/a/a:gp	I
    //   103: aload_0
    //   104: getfield 152	com/b/a/a/a/a:gn	Ljava/io/Writer;
    //   107: new 154	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 519
    //   117: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: bipush 10
    //   126: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   129: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 522	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   135: pop
    //   136: aload_0
    //   137: invokespecial 302	com/b/a/a/a/a:fo	()Z
    //   140: ifeq +17 -> 157
    //   143: aload_0
    //   144: getfield 90	com/b/a/a/a/a:gr	Ljava/util/concurrent/ExecutorService;
    //   147: aload_0
    //   148: getfield 95	com/b/a/a/a/a:gs	Ljava/util/concurrent/Callable;
    //   151: invokeinterface 308 2 0
    //   156: pop
    //   157: new 18	com/b/a/a/a/a$c
    //   160: dup
    //   161: aload_0
    //   162: aload_1
    //   163: aload_3
    //   164: invokestatic 137	com/b/a/a/a/a$b:e	(Lcom/b/a/a/a/a$b;)J
    //   167: aload 4
    //   169: aconst_null
    //   170: invokespecial 525	com/b/a/a/a/a$c:<init>	(Lcom/b/a/a/a/a;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/b/a/a/a/a$1;)V
    //   173: astore_1
    //   174: goto -145 -> 29
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	a
    //   0	182	1	paramString	String
    //   55	29	2	i	int
    //   22	142	3	localb	b
    //   52	116	4	arrayOfInputStream	InputStream[]
    // Exception table:
    //   from	to	target	type
    //   56	80	87	java/io/FileNotFoundException
    //   2	23	177	finally
    //   33	40	177	finally
    //   45	54	177	finally
    //   56	80	177	finally
    //   93	157	177	finally
    //   157	174	177	finally
  }
  
  public boolean isClosed()
  {
    return this.gn == null;
  }
  
  public a j(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public boolean k(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        fp();
        l(paramString);
        b localb = (b)this.go.get(paramString);
        Object localObject;
        if (localb != null)
        {
          localObject = b.a(localb);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.gm -= b.b(localb)[i];
          b.b(localb)[i] = 0L;
          i += 1;
        }
        if (i < this.gl)
        {
          localObject = localb.ax(i);
          if (((File)localObject).delete()) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.gp += 1;
      this.gn.append("REMOVE " + paramString + '\n');
      this.go.remove(paramString);
      if (fo()) {
        this.gr.submit(this.gs);
      }
      boolean bool = true;
    }
  }
  
  public final class a
  {
    private final a.b gu;
    private boolean gv;
    
    private a(a.b paramb)
    {
      this.gu = paramb;
    }
    
    public void abort()
    {
      a.a(a.this, this, false);
    }
    
    public OutputStream aw(int paramInt)
    {
      synchronized (a.this)
      {
        if (a.b.a(this.gu) != this) {
          throw new IllegalStateException();
        }
      }
      a locala1 = new a(new FileOutputStream(this.gu.ay(paramInt)), null);
      return locala1;
    }
    
    public void commit()
    {
      if (this.gv)
      {
        a.a(a.this, this, false);
        a.this.k(a.b.c(this.gu));
        return;
      }
      a.a(a.this, this, true);
    }
    
    private class a
      extends FilterOutputStream
    {
      private a(OutputStream paramOutputStream)
      {
        super();
      }
      
      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          a.a.b(a.a.this, true);
        }
      }
      
      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          a.a.b(a.a.this, true);
        }
      }
      
      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          a.a.b(a.a.this, true);
        }
      }
      
      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException paramArrayOfByte)
        {
          a.a.b(a.a.this, true);
        }
      }
    }
  }
  
  private final class b
  {
    private long gA;
    private final long[] gx;
    private boolean gy;
    private a.a gz;
    private final String key;
    
    private b(String paramString)
    {
      this.key = paramString;
      this.gx = new long[a.e(a.this)];
    }
    
    private void b(String[] paramArrayOfString)
    {
      if (paramArrayOfString.length != a.e(a.this)) {
        throw c(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.gx[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw c(paramArrayOfString);
      }
    }
    
    private IOException c(String[] paramArrayOfString)
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    public File ax(int paramInt)
    {
      return new File(a.f(a.this), this.key + "." + paramInt);
    }
    
    public File ay(int paramInt)
    {
      return new File(a.f(a.this), this.key + "." + paramInt + ".tmp");
    }
    
    public String fr()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.gx;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        localStringBuilder.append(' ').append(l);
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
  
  public final class c
    implements Closeable
  {
    private final long gA;
    private final InputStream[] gB;
    private final String key;
    
    private c(String paramString, long paramLong, InputStream[] paramArrayOfInputStream)
    {
      this.key = paramString;
      this.gA = paramLong;
      this.gB = paramArrayOfInputStream;
    }
    
    public InputStream az(int paramInt)
    {
      return this.gB[paramInt];
    }
    
    public void close()
    {
      InputStream[] arrayOfInputStream = this.gB;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        a.a(arrayOfInputStream[i]);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/b/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */