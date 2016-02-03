package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.nio.ByteBuffer;

public class AdReportedId$Builder
  extends SpecificRecordBuilderBase<AdReportedId>
  implements RecordBuilder<AdReportedId>
{
  private ByteBuffer ev;
  private int type;
  
  private AdReportedId$Builder(byte paramByte)
  {
    super(AdReportedId.SCHEMA$);
  }
  
  /* Error */
  public AdReportedId build()
  {
    // Byte code:
    //   0: new 19	com/flurry/android/AdReportedId
    //   3: dup
    //   4: invokespecial 32	com/flurry/android/AdReportedId:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 36	com/flurry/android/AdReportedId$Builder:fieldSetFlags	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +34 -> 48
    //   17: aload_0
    //   18: getfield 38	com/flurry/android/AdReportedId$Builder:type	I
    //   21: istore_1
    //   22: aload_3
    //   23: iload_1
    //   24: putfield 39	com/flurry/android/AdReportedId:type	I
    //   27: aload_0
    //   28: invokevirtual 36	com/flurry/android/AdReportedId$Builder:fieldSetFlags	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +35 -> 68
    //   36: aload_0
    //   37: getfield 41	com/flurry/android/AdReportedId$Builder:ev	Ljava/nio/ByteBuffer;
    //   40: astore_2
    //   41: aload_3
    //   42: aload_2
    //   43: putfield 42	com/flurry/android/AdReportedId:ev	Ljava/nio/ByteBuffer;
    //   46: aload_3
    //   47: areturn
    //   48: aload_0
    //   49: aload_0
    //   50: invokevirtual 46	com/flurry/android/AdReportedId$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   53: iconst_0
    //   54: aaload
    //   55: invokevirtual 50	com/flurry/android/AdReportedId$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   58: checkcast 52	java/lang/Integer
    //   61: invokevirtual 56	java/lang/Integer:intValue	()I
    //   64: istore_1
    //   65: goto -43 -> 22
    //   68: aload_0
    //   69: aload_0
    //   70: invokevirtual 46	com/flurry/android/AdReportedId$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   73: iconst_1
    //   74: aaload
    //   75: invokevirtual 50	com/flurry/android/AdReportedId$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   78: checkcast 58	java/nio/ByteBuffer
    //   81: astore_2
    //   82: goto -41 -> 41
    //   85: astore_2
    //   86: new 60	com/flurry/org/apache/avro/AvroRuntimeException
    //   89: dup
    //   90: aload_2
    //   91: invokespecial 63	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
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
  
  public Builder clearId()
  {
    this.ev = null;
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearType()
  {
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public ByteBuffer getId()
  {
    return this.ev;
  }
  
  public Integer getType()
  {
    return Integer.valueOf(this.type);
  }
  
  public boolean hasId()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasType()
  {
    return fieldSetFlags()[0];
  }
  
  public Builder setId(ByteBuffer paramByteBuffer)
  {
    validate(fields()[1], paramByteBuffer);
    this.ev = paramByteBuffer;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setType(int paramInt)
  {
    validate(fields()[0], Integer.valueOf(paramInt));
    this.type = paramInt;
    fieldSetFlags()[0] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdReportedId$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */