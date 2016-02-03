package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.nv;
import java.nio.ByteBuffer;

public class AdReportedId$Builder
  extends nv<AdReportedId>
{
  private int a;
  private ByteBuffer b;
  
  private AdReportedId$Builder()
  {
    super(AdReportedId.SCHEMA$);
  }
  
  public Builder a(int paramInt)
  {
    a(b()[0], Integer.valueOf(paramInt));
    this.a = paramInt;
    c()[0] = 1;
    return this;
  }
  
  public Builder a(ByteBuffer paramByteBuffer)
  {
    a(b()[1], paramByteBuffer);
    this.b = paramByteBuffer;
    c()[1] = 1;
    return this;
  }
  
  /* Error */
  public AdReportedId a()
  {
    // Byte code:
    //   0: new 13	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId
    //   3: dup
    //   4: invokespecial 50	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 43	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:c	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +34 -> 48
    //   17: aload_0
    //   18: getfield 39	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:a	I
    //   21: istore_1
    //   22: aload_3
    //   23: iload_1
    //   24: putfield 51	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId:a	I
    //   27: aload_0
    //   28: invokevirtual 43	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:c	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +35 -> 68
    //   36: aload_0
    //   37: getfield 46	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:b	Ljava/nio/ByteBuffer;
    //   40: astore_2
    //   41: aload_3
    //   42: aload_2
    //   43: putfield 52	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId:b	Ljava/nio/ByteBuffer;
    //   46: aload_3
    //   47: areturn
    //   48: aload_0
    //   49: aload_0
    //   50: invokevirtual 28	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   53: iconst_0
    //   54: aaload
    //   55: invokevirtual 55	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   58: checkcast 30	java/lang/Integer
    //   61: invokevirtual 59	java/lang/Integer:intValue	()I
    //   64: istore_1
    //   65: goto -43 -> 22
    //   68: aload_0
    //   69: aload_0
    //   70: invokevirtual 28	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   73: iconst_1
    //   74: aaload
    //   75: invokevirtual 55	com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   78: checkcast 61	java/nio/ByteBuffer
    //   81: astore_2
    //   82: goto -41 -> 41
    //   85: astore_2
    //   86: new 63	com/flurry/android/monolithic/sdk/impl/jg
    //   89: dup
    //   90: aload_2
    //   91: invokespecial 66	com/flurry/android/monolithic/sdk/impl/jg:<init>	(Ljava/lang/Throwable;)V
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	Builder
    //   21	44	1	i	int
    //   40	42	2	localByteBuffer	ByteBuffer
    //   85	6	2	localException	Exception
    //   7	40	3	localAdReportedId	AdReportedId
    // Exception table:
    //   from	to	target	type
    //   0	22	85	java/lang/Exception
    //   22	41	85	java/lang/Exception
    //   41	46	85	java/lang/Exception
    //   48	65	85	java/lang/Exception
    //   68	82	85	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/AdReportedId$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */