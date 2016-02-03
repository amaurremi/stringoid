package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public abstract class dc
  implements db
{
  protected MotionEvent a;
  protected DisplayMetrics b;
  protected dn c;
  private do d;
  
  protected dc(Context paramContext, dn paramdn, do paramdo)
  {
    this.c = paramdn;
    this.d = paramdo;
    try
    {
      this.b = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      this.b = new DisplayMetrics();
      this.b.density = 1.0F;
    }
  }
  
  /* Error */
  private String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 56	com/google/android/gms/internal/dc:a	()V
    //   6: iload_3
    //   7: ifeq +29 -> 36
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 59	com/google/android/gms/internal/dc:c	(Landroid/content/Context;)V
    //   15: aload_0
    //   16: invokespecial 62	com/google/android/gms/internal/dc:b	()[B
    //   19: astore 4
    //   21: aload_0
    //   22: monitorexit
    //   23: aload 4
    //   25: arraylength
    //   26: ifne +30 -> 56
    //   29: iconst_5
    //   30: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 70	com/google/android/gms/internal/dc:b	(Landroid/content/Context;)V
    //   41: goto -26 -> 15
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: bipush 7
    //   52: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   55: areturn
    //   56: aload 4
    //   58: astore_1
    //   59: aload 4
    //   61: arraylength
    //   62: sipush 239
    //   65: if_icmple +19 -> 84
    //   68: aload_0
    //   69: invokespecial 56	com/google/android/gms/internal/dc:a	()V
    //   72: aload_0
    //   73: bipush 20
    //   75: lconst_1
    //   76: invokevirtual 73	com/google/android/gms/internal/dc:a	(IJ)V
    //   79: aload_0
    //   80: invokespecial 62	com/google/android/gms/internal/dc:b	()[B
    //   83: astore_1
    //   84: aload_1
    //   85: arraylength
    //   86: sipush 239
    //   89: if_icmpge +168 -> 257
    //   92: sipush 239
    //   95: aload_1
    //   96: arraylength
    //   97: isub
    //   98: newarray <illegal type>
    //   100: astore 4
    //   102: new 75	java/security/SecureRandom
    //   105: dup
    //   106: invokespecial 76	java/security/SecureRandom:<init>	()V
    //   109: aload 4
    //   111: invokevirtual 80	java/security/SecureRandom:nextBytes	([B)V
    //   114: sipush 240
    //   117: invokestatic 86	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   120: aload_1
    //   121: arraylength
    //   122: i2b
    //   123: invokevirtual 90	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   126: aload_1
    //   127: invokevirtual 93	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   130: aload 4
    //   132: invokevirtual 93	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   135: invokevirtual 96	java/nio/ByteBuffer:array	()[B
    //   138: astore_1
    //   139: ldc 98
    //   141: invokestatic 104	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   144: astore 4
    //   146: aload 4
    //   148: aload_1
    //   149: invokevirtual 107	java/security/MessageDigest:update	([B)V
    //   152: aload 4
    //   154: invokevirtual 110	java/security/MessageDigest:digest	()[B
    //   157: astore 4
    //   159: sipush 256
    //   162: invokestatic 86	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   165: aload 4
    //   167: invokevirtual 93	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   170: aload_1
    //   171: invokevirtual 93	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   174: invokevirtual 96	java/nio/ByteBuffer:array	()[B
    //   177: astore_1
    //   178: sipush 256
    //   181: newarray <illegal type>
    //   183: astore 4
    //   185: new 112	com/google/android/gms/internal/co
    //   188: dup
    //   189: invokespecial 113	com/google/android/gms/internal/co:<init>	()V
    //   192: aload_1
    //   193: aload 4
    //   195: invokevirtual 116	com/google/android/gms/internal/co:a	([B[B)V
    //   198: aload_2
    //   199: ifnull +47 -> 246
    //   202: aload_2
    //   203: invokevirtual 122	java/lang/String:length	()I
    //   206: ifle +40 -> 246
    //   209: aload_2
    //   210: astore_1
    //   211: aload_2
    //   212: invokevirtual 122	java/lang/String:length	()I
    //   215: bipush 32
    //   217: if_icmple +11 -> 228
    //   220: aload_2
    //   221: iconst_0
    //   222: bipush 32
    //   224: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore_1
    //   228: new 128	com/google/android/gms/internal/dh
    //   231: dup
    //   232: aload_1
    //   233: ldc -126
    //   235: invokevirtual 134	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   238: invokespecial 136	com/google/android/gms/internal/dh:<init>	([B)V
    //   241: aload 4
    //   243: invokevirtual 138	com/google/android/gms/internal/dh:a	([B)V
    //   246: aload_0
    //   247: getfield 23	com/google/android/gms/internal/dc:c	Lcom/google/android/gms/internal/dn;
    //   250: aload 4
    //   252: iconst_1
    //   253: invokevirtual 143	com/google/android/gms/internal/dn:a	([BZ)Ljava/lang/String;
    //   256: areturn
    //   257: sipush 240
    //   260: invokestatic 86	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   263: aload_1
    //   264: arraylength
    //   265: i2b
    //   266: invokevirtual 90	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   269: aload_1
    //   270: invokevirtual 93	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   273: invokevirtual 96	java/nio/ByteBuffer:array	()[B
    //   276: astore_1
    //   277: goto -138 -> 139
    //   280: astore_1
    //   281: bipush 7
    //   283: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   286: areturn
    //   287: astore_1
    //   288: iconst_3
    //   289: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   292: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	dc
    //   0	293	1	paramContext	Context
    //   0	293	2	paramString	String
    //   0	293	3	paramBoolean	boolean
    //   19	232	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	44	finally
    //   10	15	44	finally
    //   15	23	44	finally
    //   36	41	44	finally
    //   0	2	49	java/security/NoSuchAlgorithmException
    //   23	34	49	java/security/NoSuchAlgorithmException
    //   45	49	49	java/security/NoSuchAlgorithmException
    //   59	84	49	java/security/NoSuchAlgorithmException
    //   84	139	49	java/security/NoSuchAlgorithmException
    //   139	198	49	java/security/NoSuchAlgorithmException
    //   202	209	49	java/security/NoSuchAlgorithmException
    //   211	228	49	java/security/NoSuchAlgorithmException
    //   228	246	49	java/security/NoSuchAlgorithmException
    //   246	257	49	java/security/NoSuchAlgorithmException
    //   257	277	49	java/security/NoSuchAlgorithmException
    //   0	2	280	java/io/UnsupportedEncodingException
    //   23	34	280	java/io/UnsupportedEncodingException
    //   45	49	280	java/io/UnsupportedEncodingException
    //   59	84	280	java/io/UnsupportedEncodingException
    //   84	139	280	java/io/UnsupportedEncodingException
    //   139	198	280	java/io/UnsupportedEncodingException
    //   202	209	280	java/io/UnsupportedEncodingException
    //   211	228	280	java/io/UnsupportedEncodingException
    //   228	246	280	java/io/UnsupportedEncodingException
    //   246	257	280	java/io/UnsupportedEncodingException
    //   257	277	280	java/io/UnsupportedEncodingException
    //   0	2	287	java/io/IOException
    //   23	34	287	java/io/IOException
    //   45	49	287	java/io/IOException
    //   59	84	287	java/io/IOException
    //   84	139	287	java/io/IOException
    //   139	198	287	java/io/IOException
    //   202	209	287	java/io/IOException
    //   211	228	287	java/io/IOException
    //   228	246	287	java/io/IOException
    //   246	257	287	java/io/IOException
    //   257	277	287	java/io/IOException
  }
  
  private void a()
  {
    this.d.a();
  }
  
  private byte[] b()
  {
    return this.d.b();
  }
  
  public final String a(Context paramContext)
  {
    return a(paramContext, null, false);
  }
  
  public final String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null) {
      this.a.recycle();
    }
    this.a = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.b.density, paramInt2 * this.b.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }
  
  protected final void a(int paramInt, long paramLong)
  {
    this.d.a(paramInt, paramLong);
  }
  
  protected final void a(int paramInt, String paramString)
  {
    this.d.a(paramInt, paramString);
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (this.a != null) {
        this.a.recycle();
      }
      this.a = MotionEvent.obtain(paramMotionEvent);
    }
  }
  
  protected abstract void b(Context paramContext);
  
  protected abstract void c(Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */