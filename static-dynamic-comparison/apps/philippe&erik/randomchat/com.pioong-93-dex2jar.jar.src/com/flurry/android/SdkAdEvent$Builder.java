package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.Map;

public class SdkAdEvent$Builder
  extends SpecificRecordBuilderBase<SdkAdEvent>
  implements RecordBuilder<SdkAdEvent>
{
  private CharSequence af;
  private Map<CharSequence, CharSequence> ag;
  private long ah;
  
  private SdkAdEvent$Builder()
  {
    super(SdkAdEvent.SCHEMA$);
  }
  
  /* Error */
  public SdkAdEvent build()
  {
    // Byte code:
    //   0: new 18	com/flurry/android/SdkAdEvent
    //   3: dup
    //   4: invokespecial 32	com/flurry/android/SdkAdEvent:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 36	com/flurry/android/SdkAdEvent$Builder:fieldSetFlags	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +57 -> 72
    //   18: aload_0
    //   19: getfield 38	com/flurry/android/SdkAdEvent$Builder:af	Ljava/lang/CharSequence;
    //   22: astore_3
    //   23: aload 4
    //   25: aload_3
    //   26: putfield 39	com/flurry/android/SdkAdEvent:af	Ljava/lang/CharSequence;
    //   29: aload_0
    //   30: invokevirtual 36	com/flurry/android/SdkAdEvent$Builder:fieldSetFlags	()[Z
    //   33: iconst_1
    //   34: baload
    //   35: ifeq +54 -> 89
    //   38: aload_0
    //   39: getfield 41	com/flurry/android/SdkAdEvent$Builder:ag	Ljava/util/Map;
    //   42: astore_3
    //   43: aload 4
    //   45: aload_3
    //   46: putfield 42	com/flurry/android/SdkAdEvent:ag	Ljava/util/Map;
    //   49: aload_0
    //   50: invokevirtual 36	com/flurry/android/SdkAdEvent$Builder:fieldSetFlags	()[Z
    //   53: iconst_2
    //   54: baload
    //   55: ifeq +51 -> 106
    //   58: aload_0
    //   59: getfield 44	com/flurry/android/SdkAdEvent$Builder:ah	J
    //   62: lstore_1
    //   63: aload 4
    //   65: lload_1
    //   66: putfield 45	com/flurry/android/SdkAdEvent:ah	J
    //   69: aload 4
    //   71: areturn
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 49	com/flurry/android/SdkAdEvent$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   77: iconst_0
    //   78: aaload
    //   79: invokevirtual 53	com/flurry/android/SdkAdEvent$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   82: checkcast 55	java/lang/CharSequence
    //   85: astore_3
    //   86: goto -63 -> 23
    //   89: aload_0
    //   90: aload_0
    //   91: invokevirtual 49	com/flurry/android/SdkAdEvent$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   94: iconst_1
    //   95: aaload
    //   96: invokevirtual 53	com/flurry/android/SdkAdEvent$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   99: checkcast 57	java/util/Map
    //   102: astore_3
    //   103: goto -60 -> 43
    //   106: aload_0
    //   107: aload_0
    //   108: invokevirtual 49	com/flurry/android/SdkAdEvent$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   111: iconst_2
    //   112: aaload
    //   113: invokevirtual 53	com/flurry/android/SdkAdEvent$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   116: checkcast 59	java/lang/Long
    //   119: invokevirtual 63	java/lang/Long:longValue	()J
    //   122: lstore_1
    //   123: goto -60 -> 63
    //   126: astore_3
    //   127: new 65	com/flurry/org/apache/avro/AvroRuntimeException
    //   130: dup
    //   131: aload_3
    //   132: invokespecial 68	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	Builder
    //   62	61	1	l	long
    //   22	81	3	localObject	Object
    //   126	6	3	localException	Exception
    //   7	63	4	localSdkAdEvent	SdkAdEvent
    // Exception table:
    //   from	to	target	type
    //   0	23	126	java/lang/Exception
    //   23	43	126	java/lang/Exception
    //   43	63	126	java/lang/Exception
    //   63	69	126	java/lang/Exception
    //   72	86	126	java/lang/Exception
    //   89	103	126	java/lang/Exception
    //   106	123	126	java/lang/Exception
  }
  
  public Builder clearParams()
  {
    this.ag = null;
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearTimeOffset()
  {
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearType()
  {
    this.af = null;
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Map<CharSequence, CharSequence> getParams()
  {
    return this.ag;
  }
  
  public Long getTimeOffset()
  {
    return Long.valueOf(this.ah);
  }
  
  public CharSequence getType()
  {
    return this.af;
  }
  
  public boolean hasParams()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasTimeOffset()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasType()
  {
    return fieldSetFlags()[0];
  }
  
  public Builder setParams(Map<CharSequence, CharSequence> paramMap)
  {
    validate(fields()[1], paramMap);
    this.ag = paramMap;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setTimeOffset(long paramLong)
  {
    validate(fields()[2], Long.valueOf(paramLong));
    this.ah = paramLong;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setType(CharSequence paramCharSequence)
  {
    validate(fields()[0], paramCharSequence);
    this.af = paramCharSequence;
    fieldSetFlags()[0] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/SdkAdEvent$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */