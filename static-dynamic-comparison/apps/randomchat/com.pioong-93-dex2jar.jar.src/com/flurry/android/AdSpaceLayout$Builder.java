package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

public class AdSpaceLayout$Builder
  extends SpecificRecordBuilderBase<AdSpaceLayout>
  implements RecordBuilder<AdSpaceLayout>
{
  private int jdField_do;
  private int dp;
  private CharSequence dq;
  private CharSequence dr;
  private CharSequence ds;
  
  private AdSpaceLayout$Builder()
  {
    super(AdSpaceLayout.SCHEMA$);
  }
  
  /* Error */
  public AdSpaceLayout build()
  {
    // Byte code:
    //   0: new 18	com/flurry/android/AdSpaceLayout
    //   3: dup
    //   4: invokespecial 32	com/flurry/android/AdSpaceLayout:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 36	com/flurry/android/AdSpaceLayout$Builder:fieldSetFlags	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +91 -> 105
    //   17: aload_0
    //   18: getfield 38	com/flurry/android/AdSpaceLayout$Builder:do	I
    //   21: istore_1
    //   22: aload_3
    //   23: iload_1
    //   24: putfield 39	com/flurry/android/AdSpaceLayout:do	I
    //   27: aload_0
    //   28: invokevirtual 36	com/flurry/android/AdSpaceLayout$Builder:fieldSetFlags	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +92 -> 125
    //   36: aload_0
    //   37: getfield 41	com/flurry/android/AdSpaceLayout$Builder:dp	I
    //   40: istore_1
    //   41: aload_3
    //   42: iload_1
    //   43: putfield 42	com/flurry/android/AdSpaceLayout:dp	I
    //   46: aload_0
    //   47: invokevirtual 36	com/flurry/android/AdSpaceLayout$Builder:fieldSetFlags	()[Z
    //   50: iconst_2
    //   51: baload
    //   52: ifeq +93 -> 145
    //   55: aload_0
    //   56: getfield 44	com/flurry/android/AdSpaceLayout$Builder:dq	Ljava/lang/CharSequence;
    //   59: astore_2
    //   60: aload_3
    //   61: aload_2
    //   62: putfield 45	com/flurry/android/AdSpaceLayout:dq	Ljava/lang/CharSequence;
    //   65: aload_0
    //   66: invokevirtual 36	com/flurry/android/AdSpaceLayout$Builder:fieldSetFlags	()[Z
    //   69: iconst_3
    //   70: baload
    //   71: ifeq +91 -> 162
    //   74: aload_0
    //   75: getfield 47	com/flurry/android/AdSpaceLayout$Builder:dr	Ljava/lang/CharSequence;
    //   78: astore_2
    //   79: aload_3
    //   80: aload_2
    //   81: putfield 48	com/flurry/android/AdSpaceLayout:dr	Ljava/lang/CharSequence;
    //   84: aload_0
    //   85: invokevirtual 36	com/flurry/android/AdSpaceLayout$Builder:fieldSetFlags	()[Z
    //   88: iconst_4
    //   89: baload
    //   90: ifeq +89 -> 179
    //   93: aload_0
    //   94: getfield 50	com/flurry/android/AdSpaceLayout$Builder:ds	Ljava/lang/CharSequence;
    //   97: astore_2
    //   98: aload_3
    //   99: aload_2
    //   100: putfield 51	com/flurry/android/AdSpaceLayout:ds	Ljava/lang/CharSequence;
    //   103: aload_3
    //   104: areturn
    //   105: aload_0
    //   106: aload_0
    //   107: invokevirtual 55	com/flurry/android/AdSpaceLayout$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   110: iconst_0
    //   111: aaload
    //   112: invokevirtual 59	com/flurry/android/AdSpaceLayout$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   115: checkcast 61	java/lang/Integer
    //   118: invokevirtual 65	java/lang/Integer:intValue	()I
    //   121: istore_1
    //   122: goto -100 -> 22
    //   125: aload_0
    //   126: aload_0
    //   127: invokevirtual 55	com/flurry/android/AdSpaceLayout$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   130: iconst_1
    //   131: aaload
    //   132: invokevirtual 59	com/flurry/android/AdSpaceLayout$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   135: checkcast 61	java/lang/Integer
    //   138: invokevirtual 65	java/lang/Integer:intValue	()I
    //   141: istore_1
    //   142: goto -101 -> 41
    //   145: aload_0
    //   146: aload_0
    //   147: invokevirtual 55	com/flurry/android/AdSpaceLayout$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   150: iconst_2
    //   151: aaload
    //   152: invokevirtual 59	com/flurry/android/AdSpaceLayout$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   155: checkcast 67	java/lang/CharSequence
    //   158: astore_2
    //   159: goto -99 -> 60
    //   162: aload_0
    //   163: aload_0
    //   164: invokevirtual 55	com/flurry/android/AdSpaceLayout$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   167: iconst_3
    //   168: aaload
    //   169: invokevirtual 59	com/flurry/android/AdSpaceLayout$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   172: checkcast 67	java/lang/CharSequence
    //   175: astore_2
    //   176: goto -97 -> 79
    //   179: aload_0
    //   180: aload_0
    //   181: invokevirtual 55	com/flurry/android/AdSpaceLayout$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   184: iconst_4
    //   185: aaload
    //   186: invokevirtual 59	com/flurry/android/AdSpaceLayout$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   189: checkcast 67	java/lang/CharSequence
    //   192: astore_2
    //   193: goto -95 -> 98
    //   196: astore_2
    //   197: new 69	com/flurry/org/apache/avro/AvroRuntimeException
    //   200: dup
    //   201: aload_2
    //   202: invokespecial 72	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	Builder
    //   21	121	1	i	int
    //   59	134	2	localCharSequence	CharSequence
    //   196	6	2	localException	Exception
    //   7	97	3	localAdSpaceLayout	AdSpaceLayout
    // Exception table:
    //   from	to	target	type
    //   0	22	196	java/lang/Exception
    //   22	41	196	java/lang/Exception
    //   41	60	196	java/lang/Exception
    //   60	79	196	java/lang/Exception
    //   79	98	196	java/lang/Exception
    //   98	103	196	java/lang/Exception
    //   105	122	196	java/lang/Exception
    //   125	142	196	java/lang/Exception
    //   145	159	196	java/lang/Exception
    //   162	176	196	java/lang/Exception
    //   179	193	196	java/lang/Exception
  }
  
  public Builder clearAdHeight()
  {
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearAdWidth()
  {
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearAlignment()
  {
    this.ds = null;
    fieldSetFlags()[4] = 0;
    return this;
  }
  
  public Builder clearFix()
  {
    this.dq = null;
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearFormat()
  {
    this.dr = null;
    fieldSetFlags()[3] = 0;
    return this;
  }
  
  public Integer getAdHeight()
  {
    return Integer.valueOf(this.dp);
  }
  
  public Integer getAdWidth()
  {
    return Integer.valueOf(this.jdField_do);
  }
  
  public CharSequence getAlignment()
  {
    return this.ds;
  }
  
  public CharSequence getFix()
  {
    return this.dq;
  }
  
  public CharSequence getFormat()
  {
    return this.dr;
  }
  
  public boolean hasAdHeight()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasAdWidth()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasAlignment()
  {
    return fieldSetFlags()[4];
  }
  
  public boolean hasFix()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasFormat()
  {
    return fieldSetFlags()[3];
  }
  
  public Builder setAdHeight(int paramInt)
  {
    validate(fields()[1], Integer.valueOf(paramInt));
    this.dp = paramInt;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setAdWidth(int paramInt)
  {
    validate(fields()[0], Integer.valueOf(paramInt));
    this.jdField_do = paramInt;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setAlignment(CharSequence paramCharSequence)
  {
    validate(fields()[4], paramCharSequence);
    this.ds = paramCharSequence;
    fieldSetFlags()[4] = 1;
    return this;
  }
  
  public Builder setFix(CharSequence paramCharSequence)
  {
    validate(fields()[2], paramCharSequence);
    this.dq = paramCharSequence;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setFormat(CharSequence paramCharSequence)
  {
    validate(fields()[3], paramCharSequence);
    this.dr = paramCharSequence;
    fieldSetFlags()[3] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdSpaceLayout$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */