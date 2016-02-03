package com.vungle.sdk;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class aj
{
  private static volatile aj b = null;
  public c a;
  private ArrayList<c> c = new ArrayList();
  private long d = Long.MIN_VALUE;
  private Boolean e = Boolean.valueOf(false);
  private String f = null;
  private long g = Long.MIN_VALUE;
  
  private aj()
    throws aj.e
  {
    String str1 = b();
    if (str1 == null) {
      throw new e((byte)0);
    }
    Object localObject = new File(str1);
    ((File)localObject).mkdirs();
    if (!((File)localObject).isDirectory())
    {
      Log.e("VungleCache", "Failed to create cache directory structure.");
      return;
    }
    String[] arrayOfString = ((File)localObject).list();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      localObject = arrayOfString[i];
      File localFile = new File(str1, (String)localObject);
      if (localFile.isDirectory())
      {
        localObject = d(localFile.getAbsolutePath());
        if (localObject != null) {
          this.c.add(localObject);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localFile.isFile()) && (((String)localObject).equals("last_request"))) {
          try
          {
            FileReader localFileReader = new FileReader(localFile);
            BufferedReader localBufferedReader = new BufferedReader(localFileReader);
            String str2 = localBufferedReader.readLine();
            String str3;
            for (localObject = "";; localObject = (String)localObject + str3)
            {
              str3 = localBufferedReader.readLine();
              if (str3 == null) {
                break;
              }
            }
            this.g = Long.parseLong(str2);
            this.f = ((String)localObject);
            localBufferedReader.close();
            localFileReader.close();
          }
          catch (Throwable localThrowable)
          {
            localFile.delete();
            this.f = null;
            this.g = Long.MIN_VALUE;
          }
        }
      }
    }
    f();
  }
  
  private static void a(c paramc)
  {
    a(new File(paramc.a()));
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (!a(new File(paramFile, arrayOfString[i]))) {
          return false;
        }
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static String b()
  {
    if (ak.e() == null) {
      Log.e("VungleCache", "Cache being initialized before context is set.");
    }
    Object localObject = ak.e().getExternalCacheDir();
    if (localObject == null) {
      return null;
    }
    localObject = ((File)localObject).getAbsolutePath();
    return (String)localObject + File.separator + ".VungleCacheDir";
  }
  
  private static boolean b(String paramString)
  {
    paramString = paramString.toLowerCase();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ".mp4";
    arrayOfString[1] = ".avi";
    arrayOfString[2] = ".3gp";
    arrayOfString[3] = ".webm";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.endsWith(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static String c(String paramString)
  {
    Object localObject = new File(paramString);
    paramString = new String[2];
    paramString[0] = ".htm";
    paramString[1] = ".html";
    if (!((File)localObject).isDirectory()) {}
    for (;;)
    {
      return null;
      localObject = ((File)localObject).list();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        String str = localObject[i].toLowerCase();
        int m = paramString.length;
        int j = 0;
        while (j < m)
        {
          if (str.endsWith(paramString[j])) {
            return str;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private c d(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    long l1 = Long.MIN_VALUE;
    File localFile = new File(paramString);
    if (!localFile.isDirectory())
    {
      a(localFile);
      return null;
    }
    Object localObject4 = paramString.split(File.separator);
    String str2 = localObject4[(localObject4.length - 1)];
    String[] arrayOfString = localFile.list();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str1 = arrayOfString[i];
      long l2;
      Object localObject6;
      if (str1.equalsIgnoreCase("pre"))
      {
        localObject4 = c(paramString + File.separator + "pre");
        l2 = l1;
        localObject6 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject4;
        localObject1 = localObject6;
        l1 = l2;
        break;
        if (str1.equalsIgnoreCase("post"))
        {
          localObject6 = c(paramString + File.separator + "post");
          localObject4 = localObject2;
          l2 = l1;
        }
        else
        {
          Object localObject5;
          if (str1.equalsIgnoreCase("expire"))
          {
            long l3 = l1;
            try
            {
              localObject4 = new Scanner(new File(paramString, str1));
              l2 = l1;
              l3 = l1;
              if (((Scanner)localObject4).hasNextLong())
              {
                l3 = l1;
                l2 = ((Scanner)localObject4).nextLong();
              }
              l3 = l2;
              ((Scanner)localObject4).close();
              localObject4 = localObject2;
              localObject6 = localObject1;
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              Log.e("VungleCache", "Failed to read expiration value, due to missing value. :/");
              localObject5 = localObject2;
              localObject6 = localObject1;
              l2 = l3;
            }
          }
          else
          {
            localObject5 = localObject2;
            localObject6 = localObject1;
            l2 = l1;
            if (b(str1))
            {
              localObject3 = str1;
              localObject5 = localObject2;
              localObject6 = localObject1;
              l2 = l1;
            }
          }
        }
      }
    }
    if ((str2 == null) || (l1 == Long.MIN_VALUE) || (((localObject2 == null) || (localObject1 == null) || (localObject3 == null)) && ((localObject2 != null) || (localObject1 == null) || (localObject3 == null)) && ((localObject2 == null) || (localObject1 != null) || (localObject3 != null)) && ((localObject2 != null) || (localObject1 == null) || (localObject3 != null))))
    {
      new StringBuilder("PRE ").append((String)localObject2).append("|POST ").append((String)localObject1).append("|VID ").append((String)localObject3);
      new StringBuilder("Malformed cache directory detected. Removing: ").append(localFile);
      a(localFile);
      return null;
    }
    return new c(str2, (String)localObject3, (String)localObject2, (String)localObject1, l1);
  }
  
  /* Error */
  public static aj e()
  {
    // Byte code:
    //   0: getstatic 32	com/vungle/sdk/aj:b	Lcom/vungle/sdk/aj;
    //   3: ifnonnull +27 -> 30
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 32	com/vungle/sdk/aj:b	Lcom/vungle/sdk/aj;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +13 -> 27
    //   17: new 2	com/vungle/sdk/aj
    //   20: dup
    //   21: invokespecial 263	com/vungle/sdk/aj:<init>	()V
    //   24: putstatic 32	com/vungle/sdk/aj:b	Lcom/vungle/sdk/aj;
    //   27: ldc 2
    //   29: monitorexit
    //   30: getstatic 32	com/vungle/sdk/aj:b	Lcom/vungle/sdk/aj;
    //   33: areturn
    //   34: astore_0
    //   35: aconst_null
    //   36: putstatic 32	com/vungle/sdk/aj:b	Lcom/vungle/sdk/aj;
    //   39: goto -12 -> 27
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	localaj	aj
    //   34	1	0	locale	e
    //   42	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	27	34	com/vungle/sdk/aj$e
    //   9	13	42	finally
    //   17	27	42	finally
    //   27	30	42	finally
    //   35	39	42	finally
  }
  
  private void f()
  {
    long l4 = System.currentTimeMillis() / 1000L;
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (((this.a == null) || (!this.a.a.equals(localc.a))) && (localc.b < l4))
      {
        new StringBuilder("Removing expired campaign: ").append(localc.a);
        a(localc);
        ((Iterator)localObject).remove();
      }
    }
    int m = this.c.size() - 10;
    if (m <= 0) {}
    label291:
    for (;;)
    {
      return;
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label291;
        }
        int k = -1;
        long l1 = Long.MAX_VALUE;
        int i = 0;
        while (i < this.c.size())
        {
          long l3 = l4 - ((c)this.c.get(i)).b;
          if (this.a != null) {
            this.a.a.equals(((c)this.c.get(i)).a);
          }
          long l2 = l1;
          if (l3 < l1)
          {
            l2 = l3;
            k = i;
          }
          i += 1;
          l1 = l2;
        }
        if (k < 0) {
          break;
        }
        localObject = (c)this.c.get(k);
        new StringBuilder("Removing extra campaign: ").append(((c)localObject).a);
        a((c)localObject);
        this.c.remove(k);
        j += 1;
      }
    }
  }
  
  public final void a(k arg1, a parama)
  {
    int m = 1;
    Object localObject2 = ???.e;
    ??? = ((a)localObject2).g;
    Object localObject3 = this.c.iterator();
    Object localObject1;
    Object localObject5;
    int j;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (c)((Iterator)localObject3).next();
      if (((c)localObject1).a.equalsIgnoreCase((String)???))
      {
        ??? = ((c)localObject1).b();
        localObject5 = ((a)localObject2).b;
        if ((localObject5 != null) && (((String)localObject5).length() != 0)) {
          break label357;
        }
        i = 1;
        if ((??? != null) && (((String)???).length() != 0)) {
          break label362;
        }
        j = 1;
        label105:
        if (i == j) {
          break label809;
        }
      }
    }
    label143:
    label159:
    label198:
    label219:
    label357:
    label362:
    label374:
    label380:
    label386:
    label392:
    label492:
    label809:
    for (int i = 0;; i = 1)
    {
      ??? = ((c)localObject1).c();
      localObject5 = ((a)localObject2).h;
      int k;
      if ((??? == null) || (((String)???).length() == 0))
      {
        j = 1;
        if ((localObject5 != null) && (((String)localObject5).length() != 0)) {
          break label374;
        }
        k = 1;
        if (j != k) {
          i = 0;
        }
        ??? = ((c)localObject1).d();
        localObject5 = ((a)localObject2).i;
        if ((??? != null) && (((String)???).length() != 0)) {
          break label380;
        }
        j = 1;
        k = m;
        if (localObject5 != null)
        {
          if (((String)localObject5).length() != 0) {
            break label386;
          }
          k = m;
        }
        if (j != k) {
          i = 0;
        }
        if (i != 0) {
          break label392;
        }
        a((c)localObject1);
        ((Iterator)localObject3).remove();
        localObject5 = ???.e;
        localObject3 = ((a)localObject5).h;
        ??? = ((a)localObject5).i;
        localObject6 = ((a)localObject5).g;
        localObject1 = ((a)localObject5).b;
        localObject2 = ((a)localObject5).f;
        this.d = SystemClock.elapsedRealtime();
        synchronized (this.e)
        {
          this.e = Boolean.valueOf(true);
          ??? = new File(b(), (String)localObject6);
          ((File)???).mkdirs();
          if (((File)???).isDirectory()) {
            break label492;
          }
        }
      }
      synchronized (this.e)
      {
        this.e = Boolean.valueOf(false);
        return;
        i = 0;
        break;
        j = 0;
        break label105;
        j = 0;
        break label143;
        k = 0;
        break label159;
        j = 0;
        break label198;
        k = 0;
        break label219;
        ??? = new File(((c)localObject1).a(), "expire");
        ???.delete();
        try
        {
          ??? = new FileWriter(???);
          localObject3 = new BufferedWriter(???);
          ((BufferedWriter)localObject3).write(String.valueOf(((a)localObject2).n));
          ((BufferedWriter)localObject3).close();
          ???.close();
          this.a = ((c)localObject1);
          parama.a((c)localObject1);
          return;
        }
        catch (IOException ???)
        {
          for (;;)
          {
            av.a("VungleCache", "Exception encountered while writing expiration file.", ???);
          }
        }
        ??? = finally;
        throw ???;
      }
      Object localObject6 = new File(((File)???).getAbsoluteFile(), "expire");
      if (((File)localObject6).exists()) {
        ((File)localObject6).delete();
      }
      try
      {
        localObject6 = new FileWriter((File)localObject6);
        BufferedWriter localBufferedWriter = new BufferedWriter((Writer)localObject6);
        localBufferedWriter.write(String.valueOf(((a)localObject5).n));
        localBufferedWriter.close();
        ((FileWriter)localObject6).close();
        localObject5 = new b((byte)0);
        parama = new d(((File)???).getAbsolutePath(), (b)localObject5, parama);
        ((b)localObject5).a = parama;
        if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
          continue;
        }
        localObject3 = new ap((String)localObject3, ((File)???).getAbsolutePath());
        ((ap)localObject3).a((ap.b)localObject5);
        ((ap)localObject3).a("pre_");
        parama.a = ((ap)localObject3);
        ((ap)localObject3).a();
      }
      catch (IOException ???)
      {
        for (;;)
        {
          av.a("insertAdvert", "Exception encountered while writing expiration file.", ???);
          synchronized (this.e)
          {
            this.e = Boolean.valueOf(false);
            return;
          }
          ((b)localObject5).a();
          continue;
          ((b)localObject5).a();
        }
        ((b)localObject5).a();
        return;
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localObject1 = new ap((String)localObject1, ((File)???).getAbsolutePath(), (String)localObject2);
        ((ap)localObject1).a((ap.b)localObject5);
        parama.b = ((ap)localObject1);
        ((ap)localObject1).a();
        if ((??? == null) || (???.length() <= 0)) {
          continue;
        }
        ??? = new ap(???, ((File)???).getAbsolutePath());
        ???.a((ap.b)localObject5);
        ???.a("post_");
        parama.c = ???;
        ???.a();
      }
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 67	java/io/File
    //   5: dup
    //   6: invokestatic 62	com/vungle/sdk/aj:b	()Ljava/lang/String;
    //   9: ldc 108
    //   11: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: astore_2
    //   15: new 346	java/io/FileWriter
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 347	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   23: astore_2
    //   24: new 349	java/io/BufferedWriter
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 352	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   32: astore_3
    //   33: aload_3
    //   34: new 130	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   41: invokestatic 268	java/lang/System:currentTimeMillis	()J
    //   44: invokestatic 413	java/lang/Long:toString	(J)Ljava/lang/String;
    //   47: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 415
    //   53: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   62: aload_3
    //   63: aload_1
    //   64: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   67: aload_3
    //   68: invokevirtual 362	java/io/BufferedWriter:close	()V
    //   71: aload_2
    //   72: invokevirtual 363	java/io/FileWriter:close	()V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: new 130	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 417
    //   86: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_1
    //   90: invokevirtual 418	java/io/IOException:toString	()Ljava/lang/String;
    //   93: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_0
    //   98: invokevirtual 420	com/vungle/sdk/aj:c	()V
    //   101: goto -26 -> 75
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	aj
    //   0	109	1	paramString	String
    //   14	58	2	localObject	Object
    //   32	36	3	localBufferedWriter	BufferedWriter
    // Exception table:
    //   from	to	target	type
    //   15	75	78	java/io/IOException
    //   2	15	104	finally
    //   15	75	104	finally
    //   79	101	104	finally
  }
  
  public final void c()
  {
    try
    {
      new File(b(), "last_request").delete();
      this.f = null;
      this.g = Long.MIN_VALUE;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final String d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 268	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 57	com/vungle/sdk/aj:f	Ljava/lang/String;
    //   10: ifnull +25 -> 35
    //   13: lload_1
    //   14: aload_0
    //   15: getfield 59	com/vungle/sdk/aj:g	J
    //   18: lsub
    //   19: ldc2_w 421
    //   22: lcmp
    //   23: ifge +12 -> 35
    //   26: aload_0
    //   27: getfield 57	com/vungle/sdk/aj:f	Ljava/lang/String;
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 420	com/vungle/sdk/aj:c	()V
    //   39: aconst_null
    //   40: astore_3
    //   41: goto -10 -> 31
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	aj
    //   5	9	1	l	long
    //   30	11	3	str	String
    //   44	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	44	finally
    //   35	39	44	finally
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(aj.c paramc);
  }
  
  private final class b
    implements ap.b
  {
    aj.d a = null;
    private Integer c = Integer.valueOf(0);
    private boolean d = true;
    
    private b() {}
    
    private void d()
    {
      synchronized (this.c)
      {
        Integer localInteger2 = this.c;
        this.c = Integer.valueOf(this.c.intValue() - 1);
        return;
      }
    }
    
    public final void a()
    {
      int m = 1;
      int k = 0;
      int i;
      int j;
      for (;;)
      {
        aj.d locald;
        synchronized (this.c)
        {
          ??? = Integer.valueOf(this.c.intValue() + 1);
          this.c = ((Integer)???);
          if (((Integer)???).intValue() == 3)
          {
            if (!this.d) {
              break label551;
            }
            locald = this.a;
            if ((locald.a == null) || (!locald.a.c())) {
              break label577;
            }
            ??? = new File(locald.a.d());
            if ((locald.b != null) && (locald.b.c())) {
              new File(locald.b.d());
            }
            if ((locald.c == null) || (!locald.c.c())) {
              break label571;
            }
            File localFile = new File(locald.c.d());
            if (??? == null) {
              break label564;
            }
            String str = ((File)???).getParent() + File.separator + "pre";
            if (as.a(((File)???).getAbsolutePath(), str)) {
              break label564;
            }
            Log.e("VungleCache", "Unzip of pre-roll failed.");
            aj.a(new File(str));
            if (!locald.a.b()) {
              break label595;
            }
            locald.d.d();
            i = 0;
            break;
            if (localFile == null) {
              break label561;
            }
            ??? = localFile.getParent() + File.separator + "post";
            if (as.a(localFile.getAbsolutePath(), (String)???)) {
              break label561;
            }
            Log.e("VungleCache", "Unzip of post-roll failed.");
            aj.a(new File((String)???));
            j = m;
            if (!locald.c.b()) {
              break label588;
            }
            locald.d.d();
            j = i;
            break label588;
          }
          label354:
          synchronized (aj.a(locald.g))
          {
            aj.a(locald.g, Boolean.valueOf(false));
            if (j == 0)
            {
              if (i != 0) {
                locald.a();
              }
              return;
            }
          }
        }
        long l1 = SystemClock.elapsedRealtime();
        long l2 = aj.b(locald.g);
        ay.c().c = (l1 - l2);
        aj.c localc = aj.a(locald.g, locald.f);
        if (localc != null)
        {
          new StringBuilder("New campaign (").append(localc.a).append(") successfully added.");
          locald.g.a = localc;
          aj.c(locald.g).add(localc);
          aj.d(locald.g);
          locald.e.a(locald.g.a);
        }
        else
        {
          locald.e.a();
          continue;
          label551:
          this.a.a();
          continue;
          label561:
          continue;
          label564:
          i = 0;
          j = 1;
          continue;
          label571:
          Object localObject4 = null;
          continue;
          label577:
          localc = null;
        }
      }
      for (;;)
      {
        j = 0;
        break;
        label588:
        i = j;
        j = k;
        break label354;
        label595:
        i = 1;
      }
    }
    
    public final void b()
    {
      a();
    }
    
    public final void c()
    {
      synchronized (this.c)
      {
        this.d = false;
        a();
        return;
      }
    }
  }
  
  public final class c
  {
    String a;
    long b;
    private String d;
    private String e;
    private String f;
    
    public c(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      this.a = paramString1;
      this.d = paramString2;
      this.e = paramString3;
      this.f = paramString4;
      this.b = paramLong;
    }
    
    public final String a()
    {
      String str = aj.b();
      return str + File.separator + this.a;
    }
    
    public final String b()
    {
      if (this.d == null) {
        return null;
      }
      return a() + File.separator + this.d;
    }
    
    public final String c()
    {
      if (this.e == null) {
        return null;
      }
      return a() + File.separator + "pre" + File.separator + this.e;
    }
    
    public final String d()
    {
      if (this.f == null) {
        return null;
      }
      return a() + File.separator + "post" + File.separator + this.f;
    }
  }
  
  private final class d
  {
    ap a = null;
    ap b = null;
    ap c = null;
    aj.b d;
    aj.a e;
    String f;
    
    public d(String paramString, aj.b paramb, aj.a parama)
    {
      this.d = paramb;
      this.e = parama;
      this.f = paramString;
    }
    
    public final void a()
    {
      ??? = this.f.split(File.separator);
      Log.e("VungleCache", "Failed to acquire campaign: " + ???[(???.length - 1)]);
      aj.a(new File(this.f));
      synchronized (aj.a(aj.this))
      {
        aj.a(aj.this, Boolean.valueOf(false));
        this.e.a();
        return;
      }
    }
  }
  
  private final class e
    extends Exception
  {
    private e() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */