package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

public class AdResponse$Builder
  extends SpecificRecordBuilderBase<AdResponse>
  implements RecordBuilder<AdResponse>
{
  private List<AdUnit> bx;
  private List<CharSequence> x;
  
  private AdResponse$Builder()
  {
    super(AdResponse.SCHEMA$);
  }
  
  /* Error */
  public AdResponse build()
  {
    // Byte code:
    //   0: new 16	com/flurry/android/AdResponse
    //   3: dup
    //   4: invokespecial 30	com/flurry/android/AdResponse:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 34	com/flurry/android/AdResponse$Builder:fieldSetFlags	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +34 -> 48
    //   17: aload_0
    //   18: getfield 36	com/flurry/android/AdResponse$Builder:bx	Ljava/util/List;
    //   21: astore_1
    //   22: aload_2
    //   23: aload_1
    //   24: putfield 37	com/flurry/android/AdResponse:bx	Ljava/util/List;
    //   27: aload_0
    //   28: invokevirtual 34	com/flurry/android/AdResponse$Builder:fieldSetFlags	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +32 -> 65
    //   36: aload_0
    //   37: getfield 39	com/flurry/android/AdResponse$Builder:x	Ljava/util/List;
    //   40: astore_1
    //   41: aload_2
    //   42: aload_1
    //   43: putfield 40	com/flurry/android/AdResponse:x	Ljava/util/List;
    //   46: aload_2
    //   47: areturn
    //   48: aload_0
    //   49: aload_0
    //   50: invokevirtual 44	com/flurry/android/AdResponse$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   53: iconst_0
    //   54: aaload
    //   55: invokevirtual 48	com/flurry/android/AdResponse$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   58: checkcast 50	java/util/List
    //   61: astore_1
    //   62: goto -40 -> 22
    //   65: aload_0
    //   66: aload_0
    //   67: invokevirtual 44	com/flurry/android/AdResponse$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   70: iconst_1
    //   71: aaload
    //   72: invokevirtual 48	com/flurry/android/AdResponse$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   75: checkcast 50	java/util/List
    //   78: astore_1
    //   79: goto -38 -> 41
    //   82: astore_1
    //   83: new 52	com/flurry/org/apache/avro/AvroRuntimeException
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 55	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	Builder
    //   21	58	1	localList	List
    //   82	6	1	localException	Exception
    //   7	40	2	localAdResponse	AdResponse
    // Exception table:
    //   from	to	target	type
    //   0	22	82	java/lang/Exception
    //   22	41	82	java/lang/Exception
    //   41	46	82	java/lang/Exception
    //   48	62	82	java/lang/Exception
    //   65	79	82	java/lang/Exception
  }
  
  public Builder clearAdUnits()
  {
    this.bx = null;
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearErrors()
  {
    this.x = null;
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public List<AdUnit> getAdUnits()
  {
    return this.bx;
  }
  
  public List<CharSequence> getErrors()
  {
    return this.x;
  }
  
  public boolean hasAdUnits()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasErrors()
  {
    return fieldSetFlags()[1];
  }
  
  public Builder setAdUnits(List<AdUnit> paramList)
  {
    validate(fields()[0], paramList);
    this.bx = paramList;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setErrors(List<CharSequence> paramList)
  {
    validate(fields()[1], paramList);
    this.x = paramList;
    fieldSetFlags()[1] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdResponse$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */