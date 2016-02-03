package com.flurry.android.impl.ads.avro.protocol.v6;

import com.flurry.android.monolithic.sdk.impl.nv;

public class TestAds$Builder
  extends nv<TestAds>
{
  private int a;
  
  private TestAds$Builder()
  {
    super(TestAds.SCHEMA$);
  }
  
  public Builder a(int paramInt)
  {
    a(b()[0], Integer.valueOf(paramInt));
    this.a = paramInt;
    c()[0] = 1;
    return this;
  }
  
  /* Error */
  public TestAds a()
  {
    // Byte code:
    //   0: new 11	com/flurry/android/impl/ads/avro/protocol/v6/TestAds
    //   3: dup
    //   4: invokespecial 46	com/flurry/android/impl/ads/avro/protocol/v6/TestAds:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 42	com/flurry/android/impl/ads/avro/protocol/v6/TestAds$Builder:c	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 38	com/flurry/android/impl/ads/avro/protocol/v6/TestAds$Builder:a	I
    //   21: istore_1
    //   22: aload_2
    //   23: iload_1
    //   24: putfield 47	com/flurry/android/impl/ads/avro/protocol/v6/TestAds:a	I
    //   27: aload_2
    //   28: areturn
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual 27	com/flurry/android/impl/ads/avro/protocol/v6/TestAds$Builder:b	()[Lcom/flurry/android/monolithic/sdk/impl/js;
    //   34: iconst_0
    //   35: aaload
    //   36: invokevirtual 50	com/flurry/android/impl/ads/avro/protocol/v6/TestAds$Builder:a	(Lcom/flurry/android/monolithic/sdk/impl/js;)Ljava/lang/Object;
    //   39: checkcast 29	java/lang/Integer
    //   42: invokevirtual 54	java/lang/Integer:intValue	()I
    //   45: istore_1
    //   46: goto -24 -> 22
    //   49: astore_2
    //   50: new 56	com/flurry/android/monolithic/sdk/impl/jg
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 59	com/flurry/android/monolithic/sdk/impl/jg:<init>	(Ljava/lang/Throwable;)V
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	Builder
    //   21	25	1	i	int
    //   7	21	2	localTestAds	TestAds
    //   49	6	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	49	java/lang/Exception
    //   22	27	49	java/lang/Exception
    //   29	46	49	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v6/TestAds$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */