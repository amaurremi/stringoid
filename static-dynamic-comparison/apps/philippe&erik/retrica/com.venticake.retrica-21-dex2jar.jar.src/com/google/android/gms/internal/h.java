package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.SecureRandom;

public abstract class h
  implements g
{
  protected MotionEvent jO;
  protected DisplayMetrics jP;
  protected m jQ;
  private qg jR;
  
  protected h(Context paramContext, m paramm, qg paramqg)
  {
    this.jQ = paramm;
    this.jR = paramqg;
    try
    {
      this.jP = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      this.jP = new DisplayMetrics();
      this.jP.density = 1.0F;
    }
  }
  
  /* Error */
  private String a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 58	com/google/android/gms/internal/h:t	()V
    //   6: iload_3
    //   7: ifeq +27 -> 34
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 62	com/google/android/gms/internal/h:e	(Landroid/content/Context;)V
    //   15: aload_0
    //   16: invokespecial 66	com/google/android/gms/internal/h:u	()[B
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: arraylength
    //   24: ifne +43 -> 67
    //   27: iconst_5
    //   28: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   31: astore_1
    //   32: aload_1
    //   33: areturn
    //   34: iload 4
    //   36: ifeq +23 -> 59
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 75	com/google/android/gms/internal/h:d	(Landroid/content/Context;)V
    //   44: goto -29 -> 15
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: bipush 7
    //   55: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   58: areturn
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 78	com/google/android/gms/internal/h:c	(Landroid/content/Context;)V
    //   64: goto -49 -> 15
    //   67: aload_0
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 81	com/google/android/gms/internal/h:a	([BLjava/lang/String;)Ljava/lang/String;
    //   73: astore_1
    //   74: aload_1
    //   75: areturn
    //   76: astore_1
    //   77: bipush 7
    //   79: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   82: areturn
    //   83: astore_1
    //   84: iconst_3
    //   85: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	h
    //   0	89	1	paramContext	Context
    //   0	89	2	paramString	String
    //   0	89	3	paramBoolean1	boolean
    //   0	89	4	paramBoolean2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	6	47	finally
    //   10	15	47	finally
    //   15	22	47	finally
    //   39	44	47	finally
    //   48	50	47	finally
    //   59	64	47	finally
    //   0	2	52	java/security/NoSuchAlgorithmException
    //   22	32	52	java/security/NoSuchAlgorithmException
    //   50	52	52	java/security/NoSuchAlgorithmException
    //   67	74	52	java/security/NoSuchAlgorithmException
    //   0	2	76	java/io/UnsupportedEncodingException
    //   22	32	76	java/io/UnsupportedEncodingException
    //   50	52	76	java/io/UnsupportedEncodingException
    //   67	74	76	java/io/UnsupportedEncodingException
    //   0	2	83	java/io/IOException
    //   22	32	83	java/io/IOException
    //   50	52	83	java/io/IOException
    //   67	74	83	java/io/IOException
  }
  
  private void t()
  {
    this.jR.a();
  }
  
  private byte[] u()
  {
    return this.jR.b();
  }
  
  public String a(Context paramContext)
  {
    return a(paramContext, null, false, false);
  }
  
  public String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true, false);
  }
  
  String a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte.length > 239)
    {
      t();
      a(20, 1L);
      localObject = u();
    }
    if (localObject.length < 239)
    {
      paramArrayOfByte = new byte[239 - localObject.length];
      new SecureRandom().nextBytes(paramArrayOfByte);
    }
    for (paramArrayOfByte = ByteBuffer.allocate(240).put((byte)localObject.length).put((byte[])localObject).put(paramArrayOfByte).array();; paramArrayOfByte = ByteBuffer.allocate(240).put((byte)localObject.length).put((byte[])localObject).array())
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      paramArrayOfByte = ByteBuffer.allocate(256).put((byte[])localObject).put(paramArrayOfByte).array();
      localObject = new byte['Ā'];
      new f().a(paramArrayOfByte, (byte[])localObject);
      if ((paramString != null) && (paramString.length() > 0)) {
        a(paramString, (byte[])localObject);
      }
      return this.jQ.a((byte[])localObject, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jO != null) {
      this.jO.recycle();
    }
    this.jO = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.jP.density, paramInt2 * this.jP.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }
  
  protected void a(int paramInt, long paramLong)
  {
    this.jR.a(paramInt, paramLong);
  }
  
  protected void a(int paramInt, String paramString)
  {
    this.jR.a(paramInt, paramString);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (this.jO != null) {
        this.jO.recycle();
      }
      this.jO = MotionEvent.obtain(paramMotionEvent);
    }
  }
  
  void a(String paramString, byte[] paramArrayOfByte)
  {
    String str = paramString;
    if (paramString.length() > 32) {
      str = paramString.substring(0, 32);
    }
    new lx(str.getBytes("UTF-8")).o(paramArrayOfByte);
  }
  
  public String b(Context paramContext)
  {
    return a(paramContext, null, false, true);
  }
  
  protected abstract void c(Context paramContext);
  
  protected abstract void d(Context paramContext);
  
  protected abstract void e(Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */