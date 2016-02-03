package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

public class Location$Builder
  extends SpecificRecordBuilderBase<Location>
  implements RecordBuilder<Location>
{
  private float eY;
  private float eZ;
  
  private Location$Builder(byte paramByte)
  {
    super(Location.SCHEMA$);
  }
  
  /* Error */
  public Location build()
  {
    // Byte code:
    //   0: new 18	com/flurry/android/Location
    //   3: dup
    //   4: invokespecial 31	com/flurry/android/Location:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 35	com/flurry/android/Location$Builder:fieldSetFlags	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +34 -> 48
    //   17: aload_0
    //   18: getfield 37	com/flurry/android/Location$Builder:eY	F
    //   21: fstore_1
    //   22: aload_2
    //   23: fload_1
    //   24: putfield 38	com/flurry/android/Location:eY	F
    //   27: aload_0
    //   28: invokevirtual 35	com/flurry/android/Location$Builder:fieldSetFlags	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +35 -> 68
    //   36: aload_0
    //   37: getfield 40	com/flurry/android/Location$Builder:eZ	F
    //   40: fstore_1
    //   41: aload_2
    //   42: fload_1
    //   43: putfield 41	com/flurry/android/Location:eZ	F
    //   46: aload_2
    //   47: areturn
    //   48: aload_0
    //   49: aload_0
    //   50: invokevirtual 45	com/flurry/android/Location$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   53: iconst_0
    //   54: aaload
    //   55: invokevirtual 49	com/flurry/android/Location$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   58: checkcast 51	java/lang/Float
    //   61: invokevirtual 55	java/lang/Float:floatValue	()F
    //   64: fstore_1
    //   65: goto -43 -> 22
    //   68: aload_0
    //   69: aload_0
    //   70: invokevirtual 45	com/flurry/android/Location$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   73: iconst_1
    //   74: aaload
    //   75: invokevirtual 49	com/flurry/android/Location$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   78: checkcast 51	java/lang/Float
    //   81: invokevirtual 55	java/lang/Float:floatValue	()F
    //   84: fstore_1
    //   85: goto -44 -> 41
    //   88: astore_2
    //   89: new 57	com/flurry/org/apache/avro/AvroRuntimeException
    //   92: dup
    //   93: aload_2
    //   94: invokespecial 60	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	Builder
    //   21	64	1	f	float
    //   7	40	2	localLocation	Location
    //   88	6	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	88	java/lang/Exception
    //   22	41	88	java/lang/Exception
    //   41	46	88	java/lang/Exception
    //   48	65	88	java/lang/Exception
    //   68	85	88	java/lang/Exception
  }
  
  public Builder clearLat()
  {
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearLon()
  {
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Float getLat()
  {
    return Float.valueOf(this.eY);
  }
  
  public Float getLon()
  {
    return Float.valueOf(this.eZ);
  }
  
  public boolean hasLat()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasLon()
  {
    return fieldSetFlags()[1];
  }
  
  public Builder setLat(float paramFloat)
  {
    validate(fields()[0], Float.valueOf(paramFloat));
    this.eY = paramFloat;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setLon(float paramFloat)
  {
    validate(fields()[1], Float.valueOf(paramFloat));
    this.eZ = paramFloat;
    fieldSetFlags()[1] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/Location$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */