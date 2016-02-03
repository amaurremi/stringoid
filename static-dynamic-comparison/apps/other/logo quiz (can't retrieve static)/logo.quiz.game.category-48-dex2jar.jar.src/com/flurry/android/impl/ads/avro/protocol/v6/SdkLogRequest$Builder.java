package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.nv;
import java.util.List;

public class SdkLogRequest$Builder
  extends nv<SdkLogRequest>
{
  private CharSequence a;
  private List<AdReportedId> b;
  private List<SdkAdLog> c;
  private long d;
  private boolean e;
  
  private SdkLogRequest$Builder()
  {
    super(SdkLogRequest.SCHEMA$);
  }
  
  public Builder a(long paramLong)
  {
    a(b()[3], Long.valueOf(paramLong));
    this.d = paramLong;
    c()[3] = 1;
    return this;
  }
  
  public Builder a(CharSequence paramCharSequence)
  {
    a(b()[0], paramCharSequence);
    this.a = paramCharSequence;
    c()[0] = 1;
    return this;
  }
  
  public Builder a(List<AdReportedId> paramList)
  {
    a(b()[1], paramList);
    this.b = paramList;
    c()[1] = 1;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    a(b()[4], Boolean.valueOf(paramBoolean));
    this.e = paramBoolean;
    c()[4] = 1;
    return this;
  }
  
  /* Error */
  public SdkLogRequest a()
  {
    // Byte code:
    //   0: new 20	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest
    //   3: dup
    //   4: invokespecial 69	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:c	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +103 -> 118
    //   18: aload_0
    //   19: getfield 52	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:a	Ljava/lang/CharSequence;
    //   22: astore 4
    //   24: aload 5
    //   26: aload 4
    //   28: putfield 70	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest:a	Ljava/lang/CharSequence;
    //   31: aload_0
    //   32: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:c	()[Z
    //   35: iconst_1
    //   36: baload
    //   37: ifeq +99 -> 136
    //   40: aload_0
    //   41: getfield 55	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:b	Ljava/util/List;
    //   44: astore 4
    //   46: aload 5
    //   48: aload 4
    //   50: putfield 71	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest:b	Ljava/util/List;
    //   53: aload_0
    //   54: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:c	()[Z
    //   57: iconst_2
    //   58: baload
    //   59: ifeq +95 -> 154
    //   62: aload_0
    //   63: getfield 73	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:c	Ljava/util/List;
    //   66: astore 4
    //   68: aload 5
    //   70: aload 4
    //   72: putfield 74	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest:c	Ljava/util/List;
    //   75: aload_0
    //   76: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:c	()[Z
    //   79: iconst_3
    //   80: baload
    //   81: ifeq +91 -> 172
    //   84: aload_0
    //   85: getfield 46	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:d	J
    //   88: lstore_1
    //   89: aload 5
    //   91: lload_1
    //   92: putfield 75	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest:d	J
    //   95: aload_0
    //   96: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:c	()[Z
    //   99: iconst_4
    //   100: baload
    //   101: ifeq +91 -> 192
    //   104: aload_0
    //   105: getfield 65	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:e	Z
    //   108: istore_3
    //   109: aload 5
    //   111: iload_3
    //   112: putfield 76	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest:e	Z
    //   115: aload 5
    //   117: areturn
    //   118: aload_0
    //   119: aload_0
    //   120: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   123: iconst_0
    //   124: aaload
    //   125: invokevirtual 79	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   128: checkcast 81	java/lang/CharSequence
    //   131: astore 4
    //   133: goto -109 -> 24
    //   136: aload_0
    //   137: aload_0
    //   138: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   141: iconst_1
    //   142: aaload
    //   143: invokevirtual 79	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   146: checkcast 83	java/util/List
    //   149: astore 4
    //   151: goto -105 -> 46
    //   154: aload_0
    //   155: aload_0
    //   156: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   159: iconst_2
    //   160: aaload
    //   161: invokevirtual 79	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   164: checkcast 83	java/util/List
    //   167: astore 4
    //   169: goto -101 -> 68
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   177: iconst_3
    //   178: aaload
    //   179: invokevirtual 79	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   182: checkcast 37	java/lang/Long
    //   185: invokevirtual 87	java/lang/Long:longValue	()J
    //   188: lstore_1
    //   189: goto -100 -> 89
    //   192: aload_0
    //   193: aload_0
    //   194: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   197: iconst_4
    //   198: aaload
    //   199: invokevirtual 79	com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   202: checkcast 60	java/lang/Boolean
    //   205: invokevirtual 91	java/lang/Boolean:booleanValue	()Z
    //   208: istore_3
    //   209: goto -100 -> 109
    //   212: astore 4
    //   214: new 93	com/flurry/android/monolithic/sdk/impl/jg
    //   217: dup
    //   218: aload 4
    //   220: invokespecial 96	com/flurry/android/monolithic/sdk/impl/jg:<init>	(Ljava/lang/Throwable;)V
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	Builder
    //   88	101	1	l	long
    //   108	101	3	bool	boolean
    //   22	146	4	localObject	Object
    //   212	7	4	localException	Exception
    //   7	109	5	localSdkLogRequest	SdkLogRequest
    // Exception table:
    //   from	to	target	type
    //   0	24	212	java/lang/Exception
    //   24	46	212	java/lang/Exception
    //   46	68	212	java/lang/Exception
    //   68	89	212	java/lang/Exception
    //   89	109	212	java/lang/Exception
    //   109	115	212	java/lang/Exception
    //   118	133	212	java/lang/Exception
    //   136	151	212	java/lang/Exception
    //   154	169	212	java/lang/Exception
    //   172	189	212	java/lang/Exception
    //   192	209	212	java/lang/Exception
  }
  
  public Builder b(List<SdkAdLog> paramList)
  {
    a(b()[2], paramList);
    this.c = paramList;
    c()[2] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/SdkLogRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */