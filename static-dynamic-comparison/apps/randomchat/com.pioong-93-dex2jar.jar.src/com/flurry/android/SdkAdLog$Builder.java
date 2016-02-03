package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

public class SdkAdLog$Builder
  extends SpecificRecordBuilderBase<SdkAdLog>
  implements RecordBuilder<SdkAdLog>
{
  private long bU;
  private CharSequence bV;
  private List<SdkAdEvent> bW;
  
  private SdkAdLog$Builder()
  {
    super(SdkAdLog.SCHEMA$);
  }
  
  /* Error */
  public SdkAdLog build()
  {
    // Byte code:
    //   0: new 18	com/flurry/android/SdkAdLog
    //   3: dup
    //   4: invokespecial 32	com/flurry/android/SdkAdLog:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 36	com/flurry/android/SdkAdLog$Builder:fieldSetFlags	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +57 -> 72
    //   18: aload_0
    //   19: getfield 38	com/flurry/android/SdkAdLog$Builder:bU	J
    //   22: lstore_1
    //   23: aload 4
    //   25: lload_1
    //   26: putfield 39	com/flurry/android/SdkAdLog:bU	J
    //   29: aload_0
    //   30: invokevirtual 36	com/flurry/android/SdkAdLog$Builder:fieldSetFlags	()[Z
    //   33: iconst_1
    //   34: baload
    //   35: ifeq +57 -> 92
    //   38: aload_0
    //   39: getfield 41	com/flurry/android/SdkAdLog$Builder:bV	Ljava/lang/CharSequence;
    //   42: astore_3
    //   43: aload 4
    //   45: aload_3
    //   46: putfield 42	com/flurry/android/SdkAdLog:bV	Ljava/lang/CharSequence;
    //   49: aload_0
    //   50: invokevirtual 36	com/flurry/android/SdkAdLog$Builder:fieldSetFlags	()[Z
    //   53: iconst_2
    //   54: baload
    //   55: ifeq +54 -> 109
    //   58: aload_0
    //   59: getfield 44	com/flurry/android/SdkAdLog$Builder:bW	Ljava/util/List;
    //   62: astore_3
    //   63: aload 4
    //   65: aload_3
    //   66: putfield 45	com/flurry/android/SdkAdLog:bW	Ljava/util/List;
    //   69: aload 4
    //   71: areturn
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 49	com/flurry/android/SdkAdLog$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   77: iconst_0
    //   78: aaload
    //   79: invokevirtual 53	com/flurry/android/SdkAdLog$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   82: checkcast 55	java/lang/Long
    //   85: invokevirtual 59	java/lang/Long:longValue	()J
    //   88: lstore_1
    //   89: goto -66 -> 23
    //   92: aload_0
    //   93: aload_0
    //   94: invokevirtual 49	com/flurry/android/SdkAdLog$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   97: iconst_1
    //   98: aaload
    //   99: invokevirtual 53	com/flurry/android/SdkAdLog$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   102: checkcast 61	java/lang/CharSequence
    //   105: astore_3
    //   106: goto -63 -> 43
    //   109: aload_0
    //   110: aload_0
    //   111: invokevirtual 49	com/flurry/android/SdkAdLog$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   114: iconst_2
    //   115: aaload
    //   116: invokevirtual 53	com/flurry/android/SdkAdLog$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   119: checkcast 63	java/util/List
    //   122: astore_3
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
    //   22	67	1	l	long
    //   42	81	3	localObject	Object
    //   126	6	3	localException	Exception
    //   7	63	4	localSdkAdLog	SdkAdLog
    // Exception table:
    //   from	to	target	type
    //   0	23	126	java/lang/Exception
    //   23	43	126	java/lang/Exception
    //   43	63	126	java/lang/Exception
    //   63	69	126	java/lang/Exception
    //   72	89	126	java/lang/Exception
    //   92	106	126	java/lang/Exception
    //   109	123	126	java/lang/Exception
  }
  
  public Builder clearAdLogGUID()
  {
    this.bV = null;
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearSdkAdEvents()
  {
    this.bW = null;
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearSessionId()
  {
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public CharSequence getAdLogGUID()
  {
    return this.bV;
  }
  
  public List<SdkAdEvent> getSdkAdEvents()
  {
    return this.bW;
  }
  
  public Long getSessionId()
  {
    return Long.valueOf(this.bU);
  }
  
  public boolean hasAdLogGUID()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasSdkAdEvents()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasSessionId()
  {
    return fieldSetFlags()[0];
  }
  
  public Builder setAdLogGUID(CharSequence paramCharSequence)
  {
    validate(fields()[1], paramCharSequence);
    this.bV = paramCharSequence;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setSdkAdEvents(List<SdkAdEvent> paramList)
  {
    validate(fields()[2], paramList);
    this.bW = paramList;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setSessionId(long paramLong)
  {
    validate(fields()[0], Long.valueOf(paramLong));
    this.bU = paramLong;
    fieldSetFlags()[0] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/SdkAdLog$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */