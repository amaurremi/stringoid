package com.vungle.publisher.net.http;

import android.os.Parcel;
import com.vungle.publisher.bv;
import com.vungle.publisher.bw;
import java.io.IOException;
import org.json.JSONException;

public abstract class MaxRetryAgeHttpResponseHandler
  extends bw
{
  private int a = 2000;
  private int b = 300000;
  public int f = 100;
  public int g;
  int h;
  
  public void a() {}
  
  public abstract void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException, JSONException;
  
  public <T extends bw> T b(Parcel paramParcel)
  {
    super.b(paramParcel);
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    return this;
  }
  
  public void b()
  {
    a();
  }
  
  /* Error */
  public final void b(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_2
    //   7: getfield 51	com/vungle/publisher/bv:a	I
    //   10: istore 5
    //   12: iload 5
    //   14: sipush 200
    //   17: if_icmpne +19 -> 36
    //   20: iconst_1
    //   21: istore 4
    //   23: iload 4
    //   25: ifeq +382 -> 407
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aload_3
    //   32: invokevirtual 53	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:a	(Lcom/vungle/publisher/net/http/HttpTransaction;Lcom/vungle/publisher/bv;Lcom/vungle/publisher/net/http/HttpTransaction$a;)V
    //   35: return
    //   36: iconst_0
    //   37: istore 4
    //   39: goto -16 -> 23
    //   42: astore 11
    //   44: ldc 55
    //   46: aload 11
    //   48: invokestatic 61	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   51: sipush 603
    //   54: istore 4
    //   56: aload_1
    //   57: getfield 67	com/vungle/publisher/net/http/HttpTransaction:c	Lcom/vungle/publisher/bx;
    //   60: astore 11
    //   62: aload 11
    //   64: getfield 70	com/vungle/publisher/bx:b	I
    //   67: istore 5
    //   69: aload_0
    //   70: getfield 16	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:f	I
    //   73: ifle +363 -> 436
    //   76: iload 5
    //   78: aload_0
    //   79: getfield 16	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:f	I
    //   82: if_icmplt +354 -> 436
    //   85: iconst_1
    //   86: istore 5
    //   88: iload 5
    //   90: ifne +312 -> 402
    //   93: aload 11
    //   95: getfield 73	com/vungle/publisher/bx:a	J
    //   98: lstore 8
    //   100: aload_0
    //   101: getfield 40	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:h	I
    //   104: ifle +338 -> 442
    //   107: invokestatic 79	android/os/SystemClock:elapsedRealtime	()J
    //   110: lload 8
    //   112: lsub
    //   113: aload_0
    //   114: getfield 40	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:h	I
    //   117: i2l
    //   118: lcmp
    //   119: iflt +323 -> 442
    //   122: iconst_1
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +275 -> 402
    //   130: iload 4
    //   132: invokestatic 82	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:a	(I)Z
    //   135: ifeq +267 -> 402
    //   138: aload 11
    //   140: getfield 84	com/vungle/publisher/bx:c	I
    //   143: istore 5
    //   145: iload 4
    //   147: invokestatic 86	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:b	(I)Z
    //   150: istore 10
    //   152: iload 5
    //   154: istore 4
    //   156: iload 10
    //   158: ifne +44 -> 202
    //   161: aload 11
    //   163: getfield 84	com/vungle/publisher/bx:c	I
    //   166: iconst_1
    //   167: isub
    //   168: istore 4
    //   170: aload 11
    //   172: iload 4
    //   174: putfield 84	com/vungle/publisher/bx:c	I
    //   177: iload 4
    //   179: ifge +16 -> 195
    //   182: ldc 55
    //   184: ldc 88
    //   186: invokestatic 91	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload 11
    //   191: iconst_0
    //   192: putfield 84	com/vungle/publisher/bx:c	I
    //   195: aload 11
    //   197: getfield 84	com/vungle/publisher/bx:c	I
    //   200: istore 4
    //   202: aload_0
    //   203: getfield 38	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:g	I
    //   206: ifle +242 -> 448
    //   209: iload 4
    //   211: aload_0
    //   212: getfield 38	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:g	I
    //   215: if_icmplt +233 -> 448
    //   218: iload 7
    //   220: istore 5
    //   222: goto +192 -> 414
    //   225: ldc 55
    //   227: new 93	java/lang/StringBuilder
    //   230: dup
    //   231: ldc 95
    //   233: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload_1
    //   237: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: ldc 104
    //   242: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload 4
    //   247: sipush 1000
    //   250: idiv
    //   251: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: ldc 112
    //   256: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 91	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_3
    //   266: aload_1
    //   267: iload 4
    //   269: invokeinterface 121 3 0
    //   274: return
    //   275: astore_1
    //   276: ldc 55
    //   278: new 93	java/lang/StringBuilder
    //   281: dup
    //   282: ldc 123
    //   284: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: aload_2
    //   288: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: aload_1
    //   295: invokestatic 127	com/vungle/publisher/log/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   298: aload_0
    //   299: invokevirtual 129	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:b	()V
    //   302: return
    //   303: astore 11
    //   305: ldc 55
    //   307: aload 11
    //   309: invokestatic 132	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   312: sipush 600
    //   315: istore 4
    //   317: goto -261 -> 56
    //   320: astore 11
    //   322: ldc 55
    //   324: aload 11
    //   326: invokestatic 132	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: sipush 604
    //   332: istore 4
    //   334: goto -278 -> 56
    //   337: aload_0
    //   338: getfield 18	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:a	I
    //   341: i2d
    //   342: ldc2_w 133
    //   345: iload 4
    //   347: iconst_1
    //   348: isub
    //   349: i2d
    //   350: invokestatic 140	java/lang/Math:pow	(DD)D
    //   353: dmul
    //   354: aload_0
    //   355: getfield 21	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:b	I
    //   358: i2d
    //   359: invokestatic 143	java/lang/Math:min	(DD)D
    //   362: d2i
    //   363: istore 4
    //   365: goto -140 -> 225
    //   368: ldc 55
    //   370: new 93	java/lang/StringBuilder
    //   373: dup
    //   374: ldc 95
    //   376: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: aload_1
    //   380: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   383: ldc -111
    //   385: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 91	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_3
    //   395: aload_1
    //   396: invokeinterface 148 2 0
    //   401: return
    //   402: aload_0
    //   403: invokevirtual 44	com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler:a	()V
    //   406: return
    //   407: iload 5
    //   409: istore 4
    //   411: goto -355 -> 56
    //   414: iload 5
    //   416: ifne -14 -> 402
    //   419: iload 10
    //   421: ifeq -53 -> 368
    //   424: iload 4
    //   426: ifgt -89 -> 337
    //   429: iload 6
    //   431: istore 4
    //   433: goto -208 -> 225
    //   436: iconst_0
    //   437: istore 5
    //   439: goto -351 -> 88
    //   442: iconst_0
    //   443: istore 5
    //   445: goto -320 -> 125
    //   448: iconst_0
    //   449: istore 5
    //   451: goto -37 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	MaxRetryAgeHttpResponseHandler
    //   0	454	1	paramHttpTransaction	HttpTransaction
    //   0	454	2	parambv	bv
    //   0	454	3	parama	HttpTransaction.a
    //   21	411	4	i	int
    //   10	440	5	j	int
    //   4	426	6	k	int
    //   1	218	7	m	int
    //   98	13	8	l	long
    //   150	270	10	bool	boolean
    //   42	5	11	localSocketTimeoutException	java.net.SocketTimeoutException
    //   60	136	11	localbx	com.vungle.publisher.bx
    //   303	5	11	localIOException	IOException
    //   320	5	11	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   28	35	42	java/net/SocketTimeoutException
    //   6	12	275	java/lang/Exception
    //   28	35	275	java/lang/Exception
    //   44	51	275	java/lang/Exception
    //   56	85	275	java/lang/Exception
    //   93	122	275	java/lang/Exception
    //   130	152	275	java/lang/Exception
    //   161	177	275	java/lang/Exception
    //   182	195	275	java/lang/Exception
    //   195	202	275	java/lang/Exception
    //   202	218	275	java/lang/Exception
    //   225	274	275	java/lang/Exception
    //   305	312	275	java/lang/Exception
    //   322	329	275	java/lang/Exception
    //   337	365	275	java/lang/Exception
    //   368	401	275	java/lang/Exception
    //   402	406	275	java/lang/Exception
    //   28	35	303	java/io/IOException
    //   28	35	320	org/json/JSONException
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/MaxRetryAgeHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */