package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

public class TestAds$Builder
  extends SpecificRecordBuilderBase<TestAds>
  implements RecordBuilder<TestAds>
{
  private int ew;
  
  private TestAds$Builder(byte paramByte)
  {
    super(TestAds.SCHEMA$);
  }
  
  /* Error */
  public TestAds build()
  {
    // Byte code:
    //   0: new 17	com/flurry/android/TestAds
    //   3: dup
    //   4: invokespecial 30	com/flurry/android/TestAds:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 34	com/flurry/android/TestAds$Builder:fieldSetFlags	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 36	com/flurry/android/TestAds$Builder:ew	I
    //   21: istore_1
    //   22: aload_2
    //   23: iload_1
    //   24: putfield 37	com/flurry/android/TestAds:ew	I
    //   27: aload_2
    //   28: areturn
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual 41	com/flurry/android/TestAds$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   34: iconst_0
    //   35: aaload
    //   36: invokevirtual 45	com/flurry/android/TestAds$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   39: checkcast 47	java/lang/Integer
    //   42: invokevirtual 51	java/lang/Integer:intValue	()I
    //   45: istore_1
    //   46: goto -24 -> 22
    //   49: astore_2
    //   50: new 53	com/flurry/org/apache/avro/AvroRuntimeException
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 56	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
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
  
  public Builder clearAdspacePlacement()
  {
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Integer getAdspacePlacement()
  {
    return Integer.valueOf(this.ew);
  }
  
  public boolean hasAdspacePlacement()
  {
    return fieldSetFlags()[0];
  }
  
  public Builder setAdspacePlacement(int paramInt)
  {
    validate(fields()[0], Integer.valueOf(paramInt));
    this.ew = paramInt;
    fieldSetFlags()[0] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/TestAds$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */