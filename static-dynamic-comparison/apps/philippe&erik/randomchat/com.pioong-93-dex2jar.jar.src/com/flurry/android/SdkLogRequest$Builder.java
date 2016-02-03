package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

public class SdkLogRequest$Builder
  extends SpecificRecordBuilderBase<SdkLogRequest>
  implements RecordBuilder<SdkLogRequest>
{
  private CharSequence bX;
  private List<AdReportedId> ca;
  private boolean cc;
  private List<SdkAdLog> dl;
  private long dm;
  
  private SdkLogRequest$Builder(byte paramByte)
  {
    super(SdkLogRequest.SCHEMA$);
  }
  
  /* Error */
  public SdkLogRequest build()
  {
    // Byte code:
    //   0: new 26	com/flurry/android/SdkLogRequest
    //   3: dup
    //   4: invokespecial 39	com/flurry/android/SdkLogRequest:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 43	com/flurry/android/SdkLogRequest$Builder:fieldSetFlags	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +103 -> 118
    //   18: aload_0
    //   19: getfield 45	com/flurry/android/SdkLogRequest$Builder:bX	Ljava/lang/CharSequence;
    //   22: astore 4
    //   24: aload 5
    //   26: aload 4
    //   28: putfield 46	com/flurry/android/SdkLogRequest:bX	Ljava/lang/CharSequence;
    //   31: aload_0
    //   32: invokevirtual 43	com/flurry/android/SdkLogRequest$Builder:fieldSetFlags	()[Z
    //   35: iconst_1
    //   36: baload
    //   37: ifeq +99 -> 136
    //   40: aload_0
    //   41: getfield 48	com/flurry/android/SdkLogRequest$Builder:ca	Ljava/util/List;
    //   44: astore 4
    //   46: aload 5
    //   48: aload 4
    //   50: putfield 49	com/flurry/android/SdkLogRequest:ca	Ljava/util/List;
    //   53: aload_0
    //   54: invokevirtual 43	com/flurry/android/SdkLogRequest$Builder:fieldSetFlags	()[Z
    //   57: iconst_2
    //   58: baload
    //   59: ifeq +95 -> 154
    //   62: aload_0
    //   63: getfield 51	com/flurry/android/SdkLogRequest$Builder:dl	Ljava/util/List;
    //   66: astore 4
    //   68: aload 5
    //   70: aload 4
    //   72: putfield 52	com/flurry/android/SdkLogRequest:dl	Ljava/util/List;
    //   75: aload_0
    //   76: invokevirtual 43	com/flurry/android/SdkLogRequest$Builder:fieldSetFlags	()[Z
    //   79: iconst_3
    //   80: baload
    //   81: ifeq +91 -> 172
    //   84: aload_0
    //   85: getfield 54	com/flurry/android/SdkLogRequest$Builder:dm	J
    //   88: lstore_1
    //   89: aload 5
    //   91: lload_1
    //   92: putfield 55	com/flurry/android/SdkLogRequest:dm	J
    //   95: aload_0
    //   96: invokevirtual 43	com/flurry/android/SdkLogRequest$Builder:fieldSetFlags	()[Z
    //   99: iconst_4
    //   100: baload
    //   101: ifeq +91 -> 192
    //   104: aload_0
    //   105: getfield 57	com/flurry/android/SdkLogRequest$Builder:cc	Z
    //   108: istore_3
    //   109: aload 5
    //   111: iload_3
    //   112: putfield 58	com/flurry/android/SdkLogRequest:cc	Z
    //   115: aload 5
    //   117: areturn
    //   118: aload_0
    //   119: aload_0
    //   120: invokevirtual 62	com/flurry/android/SdkLogRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   123: iconst_0
    //   124: aaload
    //   125: invokevirtual 66	com/flurry/android/SdkLogRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   128: checkcast 68	java/lang/CharSequence
    //   131: astore 4
    //   133: goto -109 -> 24
    //   136: aload_0
    //   137: aload_0
    //   138: invokevirtual 62	com/flurry/android/SdkLogRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   141: iconst_1
    //   142: aaload
    //   143: invokevirtual 66	com/flurry/android/SdkLogRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   146: checkcast 70	java/util/List
    //   149: astore 4
    //   151: goto -105 -> 46
    //   154: aload_0
    //   155: aload_0
    //   156: invokevirtual 62	com/flurry/android/SdkLogRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   159: iconst_2
    //   160: aaload
    //   161: invokevirtual 66	com/flurry/android/SdkLogRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   164: checkcast 70	java/util/List
    //   167: astore 4
    //   169: goto -101 -> 68
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 62	com/flurry/android/SdkLogRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   177: iconst_3
    //   178: aaload
    //   179: invokevirtual 66	com/flurry/android/SdkLogRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   182: checkcast 72	java/lang/Long
    //   185: invokevirtual 76	java/lang/Long:longValue	()J
    //   188: lstore_1
    //   189: goto -100 -> 89
    //   192: aload_0
    //   193: aload_0
    //   194: invokevirtual 62	com/flurry/android/SdkLogRequest$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   197: iconst_4
    //   198: aaload
    //   199: invokevirtual 66	com/flurry/android/SdkLogRequest$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   202: checkcast 78	java/lang/Boolean
    //   205: invokevirtual 82	java/lang/Boolean:booleanValue	()Z
    //   208: istore_3
    //   209: goto -100 -> 109
    //   212: astore 4
    //   214: new 84	com/flurry/org/apache/avro/AvroRuntimeException
    //   217: dup
    //   218: aload 4
    //   220: invokespecial 87	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
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
  
  public Builder clearAdReportedIds()
  {
    this.ca = null;
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearAgentTimestamp()
  {
    fieldSetFlags()[3] = 0;
    return this;
  }
  
  public Builder clearApiKey()
  {
    this.bX = null;
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearSdkAdLogs()
  {
    this.dl = null;
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearTestDevice()
  {
    fieldSetFlags()[4] = 0;
    return this;
  }
  
  public List<AdReportedId> getAdReportedIds()
  {
    return this.ca;
  }
  
  public Long getAgentTimestamp()
  {
    return Long.valueOf(this.dm);
  }
  
  public CharSequence getApiKey()
  {
    return this.bX;
  }
  
  public List<SdkAdLog> getSdkAdLogs()
  {
    return this.dl;
  }
  
  public Boolean getTestDevice()
  {
    return Boolean.valueOf(this.cc);
  }
  
  public boolean hasAdReportedIds()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasAgentTimestamp()
  {
    return fieldSetFlags()[3];
  }
  
  public boolean hasApiKey()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasSdkAdLogs()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasTestDevice()
  {
    return fieldSetFlags()[4];
  }
  
  public Builder setAdReportedIds(List<AdReportedId> paramList)
  {
    validate(fields()[1], paramList);
    this.ca = paramList;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setAgentTimestamp(long paramLong)
  {
    validate(fields()[3], Long.valueOf(paramLong));
    this.dm = paramLong;
    fieldSetFlags()[3] = 1;
    return this;
  }
  
  public Builder setApiKey(CharSequence paramCharSequence)
  {
    validate(fields()[0], paramCharSequence);
    this.bX = paramCharSequence;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setSdkAdLogs(List<SdkAdLog> paramList)
  {
    validate(fields()[2], paramList);
    this.dl = paramList;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setTestDevice(boolean paramBoolean)
  {
    validate(fields()[4], Boolean.valueOf(paramBoolean));
    this.cc = paramBoolean;
    fieldSetFlags()[4] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/SdkLogRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */