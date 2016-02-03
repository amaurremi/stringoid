package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.nv;

public class AdViewContainer$Builder
  extends nv<AdViewContainer>
{
  private int a;
  private int b;
  private int c;
  private int d;
  private float e;
  
  private AdViewContainer$Builder()
  {
    super(AdViewContainer.SCHEMA$);
  }
  
  public Builder a(float paramFloat)
  {
    a(b()[4], Float.valueOf(paramFloat));
    this.e = paramFloat;
    c()[4] = 1;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    a(b()[0], Integer.valueOf(paramInt));
    this.a = paramInt;
    c()[0] = 1;
    return this;
  }
  
  /* Error */
  public AdViewContainer a()
  {
    // Byte code:
    //   0: new 16	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer
    //   3: dup
    //   4: invokespecial 57	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 45	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:c	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +91 -> 105
    //   17: aload_0
    //   18: getfield 53	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:a	I
    //   21: istore_2
    //   22: aload_3
    //   23: iload_2
    //   24: putfield 58	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer:a	I
    //   27: aload_0
    //   28: invokevirtual 45	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:c	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +92 -> 125
    //   36: aload_0
    //   37: getfield 60	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:b	I
    //   40: istore_2
    //   41: aload_3
    //   42: iload_2
    //   43: putfield 61	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer:b	I
    //   46: aload_0
    //   47: invokevirtual 45	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:c	()[Z
    //   50: iconst_2
    //   51: baload
    //   52: ifeq +93 -> 145
    //   55: aload_0
    //   56: getfield 63	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:c	I
    //   59: istore_2
    //   60: aload_3
    //   61: iload_2
    //   62: putfield 64	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer:c	I
    //   65: aload_0
    //   66: invokevirtual 45	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:c	()[Z
    //   69: iconst_3
    //   70: baload
    //   71: ifeq +94 -> 165
    //   74: aload_0
    //   75: getfield 66	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:d	I
    //   78: istore_2
    //   79: aload_3
    //   80: iload_2
    //   81: putfield 67	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer:d	I
    //   84: aload_0
    //   85: invokevirtual 45	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:c	()[Z
    //   88: iconst_4
    //   89: baload
    //   90: ifeq +95 -> 185
    //   93: aload_0
    //   94: getfield 42	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:e	F
    //   97: fstore_1
    //   98: aload_3
    //   99: fload_1
    //   100: putfield 68	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer:e	F
    //   103: aload_3
    //   104: areturn
    //   105: aload_0
    //   106: aload_0
    //   107: invokevirtual 31	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   110: iconst_0
    //   111: aaload
    //   112: invokevirtual 71	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   115: checkcast 48	java/lang/Integer
    //   118: invokevirtual 75	java/lang/Integer:intValue	()I
    //   121: istore_2
    //   122: goto -100 -> 22
    //   125: aload_0
    //   126: aload_0
    //   127: invokevirtual 31	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   130: iconst_1
    //   131: aaload
    //   132: invokevirtual 71	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   135: checkcast 48	java/lang/Integer
    //   138: invokevirtual 75	java/lang/Integer:intValue	()I
    //   141: istore_2
    //   142: goto -101 -> 41
    //   145: aload_0
    //   146: aload_0
    //   147: invokevirtual 31	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   150: iconst_2
    //   151: aaload
    //   152: invokevirtual 71	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   155: checkcast 48	java/lang/Integer
    //   158: invokevirtual 75	java/lang/Integer:intValue	()I
    //   161: istore_2
    //   162: goto -102 -> 60
    //   165: aload_0
    //   166: aload_0
    //   167: invokevirtual 31	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   170: iconst_3
    //   171: aaload
    //   172: invokevirtual 71	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   175: checkcast 48	java/lang/Integer
    //   178: invokevirtual 75	java/lang/Integer:intValue	()I
    //   181: istore_2
    //   182: goto -103 -> 79
    //   185: aload_0
    //   186: aload_0
    //   187: invokevirtual 31	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   190: iconst_4
    //   191: aaload
    //   192: invokevirtual 71	com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   195: checkcast 33	java/lang/Float
    //   198: invokevirtual 79	java/lang/Float:floatValue	()F
    //   201: fstore_1
    //   202: goto -104 -> 98
    //   205: astore_3
    //   206: new 81	com/flurry/android/monolithic/sdk/impl/jg
    //   209: dup
    //   210: aload_3
    //   211: invokespecial 84	com/flurry/android/monolithic/sdk/impl/jg:<init>	(Ljava/lang/Throwable;)V
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	Builder
    //   97	105	1	f	float
    //   21	161	2	i	int
    //   7	97	3	localAdViewContainer	AdViewContainer
    //   205	6	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	205	java/lang/Exception
    //   22	41	205	java/lang/Exception
    //   41	60	205	java/lang/Exception
    //   60	79	205	java/lang/Exception
    //   79	98	205	java/lang/Exception
    //   98	103	205	java/lang/Exception
    //   105	122	205	java/lang/Exception
    //   125	142	205	java/lang/Exception
    //   145	162	205	java/lang/Exception
    //   165	182	205	java/lang/Exception
    //   185	202	205	java/lang/Exception
  }
  
  public Builder b(int paramInt)
  {
    a(b()[1], Integer.valueOf(paramInt));
    this.b = paramInt;
    c()[1] = 1;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    a(b()[2], Integer.valueOf(paramInt));
    this.c = paramInt;
    c()[2] = 1;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    a(b()[3], Integer.valueOf(paramInt));
    this.d = paramInt;
    c()[3] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/AdViewContainer$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */