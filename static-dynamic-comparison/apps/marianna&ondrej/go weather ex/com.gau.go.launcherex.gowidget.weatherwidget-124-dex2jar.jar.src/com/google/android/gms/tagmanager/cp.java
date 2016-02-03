package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.it.a;
import com.google.android.gms.internal.ks;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cp
  implements o.f
{
  private final String WJ;
  private bg<it.a> Zf;
  private final ExecutorService Zm;
  private final Context mContext;
  
  cp(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.WJ = paramString;
    this.Zm = Executors.newSingleThreadExecutor();
  }
  
  private cq.c a(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    try
    {
      paramByteArrayOutputStream = ba.bG(paramByteArrayOutputStream.toString("UTF-8"));
      return paramByteArrayOutputStream;
    }
    catch (UnsupportedEncodingException paramByteArrayOutputStream)
    {
      bh.v("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
      return null;
    }
    catch (JSONException paramByteArrayOutputStream)
    {
      bh.z("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
    }
    return null;
  }
  
  private cq.c k(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = cq.b(c.f.a(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (ks paramArrayOfByte)
    {
      bh.z("Resource doesn't contain a binary container");
      return null;
    }
    catch (cq.g paramArrayOfByte)
    {
      bh.z("Resource doesn't contain a binary container");
    }
    return null;
  }
  
  public void a(bg<it.a> parambg)
  {
    this.Zf = parambg;
  }
  
  public void b(final it.a parama)
  {
    this.Zm.execute(new Runnable()
    {
      public void run()
      {
        cp.this.c(parama);
      }
    });
  }
  
  /* Error */
  boolean c(it.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 114	com/google/android/gms/tagmanager/cp:lc	()Ljava/io/File;
    //   4: astore_3
    //   5: new 116	java/io/FileOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: invokestatic 125	com/google/android/gms/internal/kt:d	(Lcom/google/android/gms/internal/kt;)[B
    //   19: invokevirtual 129	java/io/FileOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   26: iconst_1
    //   27: ireturn
    //   28: astore_1
    //   29: ldc -122
    //   31: invokestatic 137	com/google/android/gms/tagmanager/bh:w	(Ljava/lang/String;)V
    //   34: iconst_0
    //   35: ireturn
    //   36: astore_1
    //   37: ldc -117
    //   39: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   42: iconst_1
    //   43: ireturn
    //   44: astore_1
    //   45: ldc -115
    //   47: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   50: aload_3
    //   51: invokevirtual 147	java/io/File:delete	()Z
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_1
    //   62: ldc -117
    //   64: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   67: iconst_0
    //   68: ireturn
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_2
    //   77: ldc -117
    //   79: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   82: goto -8 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	cp
    //   0	85	1	parama	it.a
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
  
  public cq.c ca(int paramInt)
  {
    bh.y("Atttempting to load container from resource ID " + paramInt);
    try
    {
      Object localObject2 = this.mContext.getResources().openRawResource(paramInt);
      Object localObject1 = new ByteArrayOutputStream();
      cq.b((InputStream)localObject2, (OutputStream)localObject1);
      localObject2 = a((ByteArrayOutputStream)localObject1);
      if (localObject2 != null) {
        return (cq.c)localObject2;
      }
      localObject1 = k(((ByteArrayOutputStream)localObject1).toByteArray());
      return (cq.c)localObject1;
    }
    catch (IOException localIOException)
    {
      bh.z("Error reading default container resource with ID " + paramInt);
      return null;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      bh.z("No default container resource found.");
    }
    return null;
  }
  
  public void km()
  {
    this.Zm.execute(new Runnable()
    {
      public void run()
      {
        cp.this.lb();
      }
    });
  }
  
  /* Error */
  void lb()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/google/android/gms/tagmanager/cp:Zf	Lcom/google/android/gms/tagmanager/bg;
    //   4: ifnonnull +13 -> 17
    //   7: new 204	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc -50
    //   13: invokespecial 208	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 92	com/google/android/gms/tagmanager/cp:Zf	Lcom/google/android/gms/tagmanager/bg;
    //   21: invokeinterface 213 1 0
    //   26: ldc -41
    //   28: invokestatic 169	com/google/android/gms/tagmanager/bh:y	(Ljava/lang/String;)V
    //   31: invokestatic 221	com/google/android/gms/tagmanager/cd:kT	()Lcom/google/android/gms/tagmanager/cd;
    //   34: invokevirtual 225	com/google/android/gms/tagmanager/cd:kU	()Lcom/google/android/gms/tagmanager/cd$a;
    //   37: getstatic 231	com/google/android/gms/tagmanager/cd$a:YU	Lcom/google/android/gms/tagmanager/cd$a;
    //   40: if_acmpeq +15 -> 55
    //   43: invokestatic 221	com/google/android/gms/tagmanager/cd:kT	()Lcom/google/android/gms/tagmanager/cd;
    //   46: invokevirtual 225	com/google/android/gms/tagmanager/cd:kU	()Lcom/google/android/gms/tagmanager/cd$a;
    //   49: getstatic 234	com/google/android/gms/tagmanager/cd$a:YV	Lcom/google/android/gms/tagmanager/cd$a;
    //   52: if_acmpne +32 -> 84
    //   55: aload_0
    //   56: getfield 28	com/google/android/gms/tagmanager/cp:WJ	Ljava/lang/String;
    //   59: invokestatic 221	com/google/android/gms/tagmanager/cd:kT	()Lcom/google/android/gms/tagmanager/cd;
    //   62: invokevirtual 237	com/google/android/gms/tagmanager/cd:getContainerId	()Ljava/lang/String;
    //   65: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +16 -> 84
    //   71: aload_0
    //   72: getfield 92	com/google/android/gms/tagmanager/cp:Zf	Lcom/google/android/gms/tagmanager/bg;
    //   75: getstatic 249	com/google/android/gms/tagmanager/bg$a:Yy	Lcom/google/android/gms/tagmanager/bg$a;
    //   78: invokeinterface 252 2 0
    //   83: return
    //   84: new 254	java/io/FileInputStream
    //   87: dup
    //   88: aload_0
    //   89: invokevirtual 114	com/google/android/gms/tagmanager/cp:lc	()Ljava/io/File;
    //   92: invokespecial 255	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: new 47	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 182	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: aload_1
    //   105: aload_2
    //   106: invokestatic 185	com/google/android/gms/tagmanager/cq:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   109: aload_0
    //   110: getfield 92	com/google/android/gms/tagmanager/cp:Zf	Lcom/google/android/gms/tagmanager/bg;
    //   113: aload_2
    //   114: invokevirtual 191	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: invokestatic 261	com/google/android/gms/internal/it$a:l	([B)Lcom/google/android/gms/internal/it$a;
    //   120: invokeinterface 265 2 0
    //   125: aload_1
    //   126: invokevirtual 266	java/io/FileInputStream:close	()V
    //   129: ldc_w 268
    //   132: invokestatic 169	com/google/android/gms/tagmanager/bh:y	(Ljava/lang/String;)V
    //   135: return
    //   136: astore_1
    //   137: ldc_w 270
    //   140: invokestatic 65	com/google/android/gms/tagmanager/bh:v	(Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 92	com/google/android/gms/tagmanager/cp:Zf	Lcom/google/android/gms/tagmanager/bg;
    //   147: getstatic 249	com/google/android/gms/tagmanager/bg$a:Yy	Lcom/google/android/gms/tagmanager/bg$a;
    //   150: invokeinterface 252 2 0
    //   155: return
    //   156: astore_1
    //   157: ldc_w 272
    //   160: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   163: goto -34 -> 129
    //   166: astore_2
    //   167: ldc_w 274
    //   170: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: getfield 92	com/google/android/gms/tagmanager/cp:Zf	Lcom/google/android/gms/tagmanager/bg;
    //   177: getstatic 277	com/google/android/gms/tagmanager/bg$a:Yz	Lcom/google/android/gms/tagmanager/bg$a;
    //   180: invokeinterface 252 2 0
    //   185: aload_1
    //   186: invokevirtual 266	java/io/FileInputStream:close	()V
    //   189: goto -60 -> 129
    //   192: astore_1
    //   193: ldc_w 272
    //   196: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   199: goto -70 -> 129
    //   202: astore_2
    //   203: aload_1
    //   204: invokevirtual 266	java/io/FileInputStream:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_1
    //   210: ldc_w 272
    //   213: invokestatic 70	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   216: goto -9 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	cp
    //   95	31	1	localFileInputStream	java.io.FileInputStream
    //   136	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   156	30	1	localIOException1	IOException
    //   192	12	1	localIOException2	IOException
    //   209	1	1	localIOException3	IOException
    //   103	11	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   166	1	2	localIOException4	IOException
    //   202	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   84	96	136	java/io/FileNotFoundException
    //   125	129	156	java/io/IOException
    //   96	125	166	java/io/IOException
    //   185	189	192	java/io/IOException
    //   96	125	202	finally
    //   167	185	202	finally
    //   203	207	209	java/io/IOException
  }
  
  File lc()
  {
    String str = "resource_" + this.WJ;
    return new File(this.mContext.getDir("google_tagmanager", 0), str);
  }
  
  public void release()
  {
    try
    {
      this.Zm.shutdown();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */