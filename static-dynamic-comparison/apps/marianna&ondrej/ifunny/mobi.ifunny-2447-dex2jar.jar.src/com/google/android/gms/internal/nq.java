package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.SecureRandom;

public abstract class nq
        implements le {
    protected MotionEvent a;
    protected DisplayMetrics b;
    protected qy c;
    private rk d;

    protected nq(Context paramContext, qy paramqy, rk paramrk) {
        this.c = paramqy;
        this.d = paramrk;
        try {
            this.b = paramContext.getResources().getDisplayMetrics();
            return;
        } catch (UnsupportedOperationException paramContext) {
            this.b = new DisplayMetrics();
            this.b.density = 1.0F;
        }
    }

    /* Error */
    private String a(Context paramContext, String paramString, boolean paramBoolean) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokespecial 56	com/google/android/gms/internal/nq:a	()V
        //   6: iload_3
        //   7: ifeq +27 -> 34
        //   10: aload_0
        //   11: aload_1
        //   12: invokevirtual 59	com/google/android/gms/internal/nq:c	(Landroid/content/Context;)V
        //   15: aload_0
        //   16: invokespecial 62	com/google/android/gms/internal/nq:b	()[B
        //   19: astore_1
        //   20: aload_0
        //   21: monitorexit
        //   22: aload_1
        //   23: arraylength
        //   24: ifne +30 -> 54
        //   27: iconst_5
        //   28: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   31: astore_1
        //   32: aload_1
        //   33: areturn
        //   34: aload_0
        //   35: aload_1
        //   36: invokevirtual 70	com/google/android/gms/internal/nq:b	(Landroid/content/Context;)V
        //   39: goto -24 -> 15
        //   42: astore_1
        //   43: aload_0
        //   44: monitorexit
        //   45: aload_1
        //   46: athrow
        //   47: astore_1
        //   48: bipush 7
        //   50: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   53: areturn
        //   54: aload_0
        //   55: aload_1
        //   56: aload_2
        //   57: invokevirtual 73	com/google/android/gms/internal/nq:a	([BLjava/lang/String;)Ljava/lang/String;
        //   60: astore_1
        //   61: aload_1
        //   62: areturn
        //   63: astore_1
        //   64: bipush 7
        //   66: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   69: areturn
        //   70: astore_1
        //   71: iconst_3
        //   72: invokestatic 68	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   75: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	nq
        //   0	76	1	paramContext	Context
        //   0	76	2	paramString	String
        //   0	76	3	paramBoolean	boolean
        // Exception table:
        //   from	to	target	type
        //   2	6	42	finally
        //   10	15	42	finally
        //   15	22	42	finally
        //   34	39	42	finally
        //   43	45	42	finally
        //   0	2	47	java/security/NoSuchAlgorithmException
        //   22	32	47	java/security/NoSuchAlgorithmException
        //   45	47	47	java/security/NoSuchAlgorithmException
        //   54	61	47	java/security/NoSuchAlgorithmException
        //   0	2	63	java/io/UnsupportedEncodingException
        //   22	32	63	java/io/UnsupportedEncodingException
        //   45	47	63	java/io/UnsupportedEncodingException
        //   54	61	63	java/io/UnsupportedEncodingException
        //   0	2	70	java/io/IOException
        //   22	32	70	java/io/IOException
        //   45	47	70	java/io/IOException
        //   54	61	70	java/io/IOException
    }

    private void a() {
        this.d.a();
    }

    private byte[] b() {
        return this.d.b();
    }

    public String a(Context paramContext) {
        return a(paramContext, null, false);
    }

    public String a(Context paramContext, String paramString) {
        return a(paramContext, paramString, true);
    }

    String a(byte[] paramArrayOfByte, String paramString) {
        Object localObject = paramArrayOfByte;
        if (paramArrayOfByte.length > 239) {
            a();
            a(20, 1L);
            localObject = b();
        }
        if (localObject.length < 239) {
            paramArrayOfByte = new byte[239 - localObject.length];
            new SecureRandom().nextBytes(paramArrayOfByte);
        }
        for (paramArrayOfByte = ByteBuffer.allocate(240).put((byte) localObject.length).put((byte[]) localObject).put(paramArrayOfByte).array(); ; paramArrayOfByte = ByteBuffer.allocate(240).put((byte) localObject.length).put((byte[]) localObject).array()) {
            localObject = MessageDigest.getInstance("MD5");
            ((MessageDigest) localObject).update(paramArrayOfByte);
            localObject = ((MessageDigest) localObject).digest();
            paramArrayOfByte = ByteBuffer.allocate(256).put((byte[]) localObject).put(paramArrayOfByte).array();
            localObject = new byte['Ā'];
            new ij().a(paramArrayOfByte, (byte[]) localObject);
            if ((paramString != null) && (paramString.length() > 0)) {
                a(paramString, (byte[]) localObject);
            }
            return this.c.a((byte[]) localObject, true);
        }
    }

    public void a(int paramInt1, int paramInt2, int paramInt3) {
        if (this.a != null) {
            this.a.recycle();
        }
        this.a = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.b.density, paramInt2 * this.b.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
    }

    protected void a(int paramInt, long paramLong) {
        this.d.a(paramInt, paramLong);
    }

    protected void a(int paramInt, String paramString) {
        this.d.a(paramInt, paramString);
    }

    public void a(MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getAction() == 1) {
            if (this.a != null) {
                this.a.recycle();
            }
            this.a = MotionEvent.obtain(paramMotionEvent);
        }
    }

    void a(String paramString, byte[] paramArrayOfByte) {
        String str = paramString;
        if (paramString.length() > 32) {
            str = paramString.substring(0, 32);
        }
        new sl(str.getBytes("UTF-8")).a(paramArrayOfByte);
    }

    protected abstract void b(Context paramContext);

    protected abstract void c(Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */