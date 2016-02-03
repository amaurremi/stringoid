package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.le.a;
import com.google.android.gms.internal.md;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class ch
  implements dw
{
  private final Context a;
  private final String b;
  private final ExecutorService c;
  private bg<le.a> d;
  
  ch(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = Executors.newSingleThreadExecutor();
  }
  
  private cq.c a(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    try
    {
      paramByteArrayOutputStream = am.a(paramByteArrayOutputStream.toString("UTF-8"));
      return paramByteArrayOutputStream;
    }
    catch (UnsupportedEncodingException paramByteArrayOutputStream)
    {
      as.d("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
      return null;
    }
    catch (JSONException paramByteArrayOutputStream)
    {
      as.b("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
    }
    return null;
  }
  
  private cq.c a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = cq.a(c.f.a(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (md paramArrayOfByte)
    {
      as.b("Resource doesn't contain a binary container");
      return null;
    }
    catch (cq.g paramArrayOfByte)
    {
      as.b("Resource doesn't contain a binary container");
    }
    return null;
  }
  
  public cq.c a(int paramInt)
  {
    as.e("Atttempting to load container from resource ID " + paramInt);
    try
    {
      Object localObject2 = this.a.getResources().openRawResource(paramInt);
      Object localObject1 = new ByteArrayOutputStream();
      cq.a((InputStream)localObject2, (OutputStream)localObject1);
      localObject2 = a((ByteArrayOutputStream)localObject1);
      if (localObject2 != null) {
        return (cq.c)localObject2;
      }
      localObject1 = a(((ByteArrayOutputStream)localObject1).toByteArray());
      return (cq.c)localObject1;
    }
    catch (IOException localIOException)
    {
      as.b("Error reading default container resource with ID " + paramInt);
      return null;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      as.b("No default container resource found.");
    }
    return null;
  }
  
  public void a()
  {
    this.c.execute(new Runnable()
    {
      public void run()
      {
        ch.this.b();
      }
    });
  }
  
  public void a(final le.a parama)
  {
    this.c.execute(new Runnable()
    {
      public void run()
      {
        ch.this.b(parama);
      }
    });
  }
  
  public void a(bg<le.a> parambg)
  {
    this.d = parambg;
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 150	com/google/android/gms/tagmanager/ch:d	Lcom/google/android/gms/tagmanager/bg;
    //   4: ifnonnull +13 -> 17
    //   7: new 156	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc -98
    //   13: invokespecial 160	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 150	com/google/android/gms/tagmanager/ch:d	Lcom/google/android/gms/tagmanager/bg;
    //   21: invokeinterface 164 1 0
    //   26: ldc -90
    //   28: invokestatic 106	com/google/android/gms/tagmanager/as:e	(Ljava/lang/String;)V
    //   31: invokestatic 171	com/google/android/gms/tagmanager/br:a	()Lcom/google/android/gms/tagmanager/br;
    //   34: invokevirtual 174	com/google/android/gms/tagmanager/br:b	()Lcom/google/android/gms/tagmanager/bs;
    //   37: getstatic 179	com/google/android/gms/tagmanager/bs:b	Lcom/google/android/gms/tagmanager/bs;
    //   40: if_acmpeq +15 -> 55
    //   43: invokestatic 171	com/google/android/gms/tagmanager/br:a	()Lcom/google/android/gms/tagmanager/br;
    //   46: invokevirtual 174	com/google/android/gms/tagmanager/br:b	()Lcom/google/android/gms/tagmanager/bs;
    //   49: getstatic 181	com/google/android/gms/tagmanager/bs:c	Lcom/google/android/gms/tagmanager/bs;
    //   52: if_acmpne +32 -> 84
    //   55: aload_0
    //   56: getfield 28	com/google/android/gms/tagmanager/ch:b	Ljava/lang/String;
    //   59: invokestatic 171	com/google/android/gms/tagmanager/br:a	()Lcom/google/android/gms/tagmanager/br;
    //   62: invokevirtual 183	com/google/android/gms/tagmanager/br:d	()Ljava/lang/String;
    //   65: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +16 -> 84
    //   71: aload_0
    //   72: getfield 150	com/google/android/gms/tagmanager/ch:d	Lcom/google/android/gms/tagmanager/bg;
    //   75: getstatic 195	com/google/android/gms/tagmanager/bg$a:agg	Lcom/google/android/gms/tagmanager/bg$a;
    //   78: invokeinterface 198 2 0
    //   83: return
    //   84: new 200	java/io/FileInputStream
    //   87: dup
    //   88: aload_0
    //   89: invokevirtual 203	com/google/android/gms/tagmanager/ch:c	()Ljava/io/File;
    //   92: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: new 46	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 119	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: aload_1
    //   105: aload_2
    //   106: invokestatic 122	com/google/android/gms/tagmanager/cq:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   109: aload_0
    //   110: getfield 150	com/google/android/gms/tagmanager/ch:d	Lcom/google/android/gms/tagmanager/bg;
    //   113: aload_2
    //   114: invokevirtual 128	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: invokestatic 212	com/google/android/gms/internal/le$a:l	([B)Lcom/google/android/gms/internal/le$a;
    //   120: invokeinterface 215 2 0
    //   125: aload_1
    //   126: invokevirtual 218	java/io/FileInputStream:close	()V
    //   129: ldc -36
    //   131: invokestatic 106	com/google/android/gms/tagmanager/as:e	(Ljava/lang/String;)V
    //   134: return
    //   135: astore_1
    //   136: ldc -34
    //   138: invokestatic 62	com/google/android/gms/tagmanager/as:d	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 150	com/google/android/gms/tagmanager/ch:d	Lcom/google/android/gms/tagmanager/bg;
    //   145: getstatic 195	com/google/android/gms/tagmanager/bg$a:agg	Lcom/google/android/gms/tagmanager/bg$a;
    //   148: invokeinterface 198 2 0
    //   153: return
    //   154: astore_1
    //   155: ldc -32
    //   157: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   160: goto -31 -> 129
    //   163: astore_2
    //   164: ldc -30
    //   166: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   169: aload_0
    //   170: getfield 150	com/google/android/gms/tagmanager/ch:d	Lcom/google/android/gms/tagmanager/bg;
    //   173: getstatic 229	com/google/android/gms/tagmanager/bg$a:agh	Lcom/google/android/gms/tagmanager/bg$a;
    //   176: invokeinterface 198 2 0
    //   181: aload_1
    //   182: invokevirtual 218	java/io/FileInputStream:close	()V
    //   185: goto -56 -> 129
    //   188: astore_1
    //   189: ldc -32
    //   191: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   194: goto -65 -> 129
    //   197: astore_2
    //   198: aload_1
    //   199: invokevirtual 218	java/io/FileInputStream:close	()V
    //   202: aload_2
    //   203: athrow
    //   204: astore_1
    //   205: ldc -32
    //   207: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   210: goto -8 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	ch
    //   95	31	1	localFileInputStream	java.io.FileInputStream
    //   135	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   154	28	1	localIOException1	IOException
    //   188	11	1	localIOException2	IOException
    //   204	1	1	localIOException3	IOException
    //   103	11	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   163	1	2	localIOException4	IOException
    //   197	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   84	96	135	java/io/FileNotFoundException
    //   125	129	154	java/io/IOException
    //   96	125	163	java/io/IOException
    //   181	185	188	java/io/IOException
    //   96	125	197	finally
    //   164	181	197	finally
    //   198	202	204	java/io/IOException
  }
  
  /* Error */
  boolean b(le.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 203	com/google/android/gms/tagmanager/ch:c	()Ljava/io/File;
    //   4: astore_3
    //   5: new 232	java/io/FileOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: invokestatic 238	com/google/android/gms/internal/me:d	(Lcom/google/android/gms/internal/me;)[B
    //   19: invokevirtual 242	java/io/FileOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   26: iconst_1
    //   27: ireturn
    //   28: astore_1
    //   29: ldc -11
    //   31: invokestatic 247	com/google/android/gms/tagmanager/as:a	(Ljava/lang/String;)V
    //   34: iconst_0
    //   35: ireturn
    //   36: astore_1
    //   37: ldc -7
    //   39: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   42: iconst_1
    //   43: ireturn
    //   44: astore_1
    //   45: ldc -5
    //   47: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   50: aload_3
    //   51: invokevirtual 257	java/io/File:delete	()Z
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_1
    //   62: ldc -7
    //   64: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   67: iconst_0
    //   68: ireturn
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_2
    //   77: ldc -7
    //   79: invokestatic 66	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   82: goto -8 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	ch
    //   0	85	1	parama	le.a
    //   13	58	2	localFileOutputStream	java.io.FileOutputStream
    //   76	1	2	localIOException	IOException
    //   4	47	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	14	28	java/io/FileNotFoundException
    //   22	26	36	java/io/IOException
    //   14	22	44	java/io/IOException
    //   55	59	61	java/io/IOException
    //   14	22	69	finally
    //   45	55	69	finally
    //   70	74	76	java/io/IOException
  }
  
  File c()
  {
    String str = "resource_" + this.b;
    return new File(this.a.getDir("google_tagmanager", 0), str);
  }
  
  public void release()
  {
    try
    {
      this.c.shutdown();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */