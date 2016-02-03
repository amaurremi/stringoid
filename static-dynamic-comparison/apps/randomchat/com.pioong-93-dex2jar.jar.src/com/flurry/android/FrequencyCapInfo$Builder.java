package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

public class FrequencyCapInfo$Builder
  extends SpecificRecordBuilderBase<FrequencyCapInfo>
  implements RecordBuilder<FrequencyCapInfo>
{
  private CharSequence W;
  private long X;
  private int Y;
  private int Z;
  private int aa;
  private long ab;
  private int df;
  
  private FrequencyCapInfo$Builder(byte paramByte)
  {
    super(FrequencyCapInfo.SCHEMA$);
  }
  
  /* Error */
  public FrequencyCapInfo build()
  {
    // Byte code:
    //   0: new 25	com/flurry/android/FrequencyCapInfo
    //   3: dup
    //   4: invokespecial 38	com/flurry/android/FrequencyCapInfo:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 42	com/flurry/android/FrequencyCapInfo$Builder:fieldSetFlags	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +140 -> 155
    //   18: aload_0
    //   19: getfield 44	com/flurry/android/FrequencyCapInfo$Builder:W	Ljava/lang/CharSequence;
    //   22: astore 4
    //   24: aload 5
    //   26: aload 4
    //   28: putfield 45	com/flurry/android/FrequencyCapInfo:W	Ljava/lang/CharSequence;
    //   31: aload_0
    //   32: invokevirtual 42	com/flurry/android/FrequencyCapInfo$Builder:fieldSetFlags	()[Z
    //   35: iconst_1
    //   36: baload
    //   37: ifeq +136 -> 173
    //   40: aload_0
    //   41: getfield 47	com/flurry/android/FrequencyCapInfo$Builder:X	J
    //   44: lstore_2
    //   45: aload 5
    //   47: lload_2
    //   48: putfield 48	com/flurry/android/FrequencyCapInfo:X	J
    //   51: aload_0
    //   52: invokevirtual 42	com/flurry/android/FrequencyCapInfo$Builder:fieldSetFlags	()[Z
    //   55: iconst_2
    //   56: baload
    //   57: ifeq +136 -> 193
    //   60: aload_0
    //   61: getfield 50	com/flurry/android/FrequencyCapInfo$Builder:ab	J
    //   64: lstore_2
    //   65: aload 5
    //   67: lload_2
    //   68: putfield 51	com/flurry/android/FrequencyCapInfo:ab	J
    //   71: aload_0
    //   72: invokevirtual 42	com/flurry/android/FrequencyCapInfo$Builder:fieldSetFlags	()[Z
    //   75: iconst_3
    //   76: baload
    //   77: ifeq +136 -> 213
    //   80: aload_0
    //   81: getfield 53	com/flurry/android/FrequencyCapInfo$Builder:df	I
    //   84: istore_1
    //   85: aload 5
    //   87: iload_1
    //   88: putfield 54	com/flurry/android/FrequencyCapInfo:df	I
    //   91: aload_0
    //   92: invokevirtual 42	com/flurry/android/FrequencyCapInfo$Builder:fieldSetFlags	()[Z
    //   95: iconst_4
    //   96: baload
    //   97: ifeq +136 -> 233
    //   100: aload_0
    //   101: getfield 56	com/flurry/android/FrequencyCapInfo$Builder:Y	I
    //   104: istore_1
    //   105: aload 5
    //   107: iload_1
    //   108: putfield 57	com/flurry/android/FrequencyCapInfo:Y	I
    //   111: aload_0
    //   112: invokevirtual 42	com/flurry/android/FrequencyCapInfo$Builder:fieldSetFlags	()[Z
    //   115: iconst_5
    //   116: baload
    //   117: ifeq +136 -> 253
    //   120: aload_0
    //   121: getfield 59	com/flurry/android/FrequencyCapInfo$Builder:Z	I
    //   124: istore_1
    //   125: aload 5
    //   127: iload_1
    //   128: putfield 60	com/flurry/android/FrequencyCapInfo:Z	I
    //   131: aload_0
    //   132: invokevirtual 42	com/flurry/android/FrequencyCapInfo$Builder:fieldSetFlags	()[Z
    //   135: bipush 6
    //   137: baload
    //   138: ifeq +135 -> 273
    //   141: aload_0
    //   142: getfield 62	com/flurry/android/FrequencyCapInfo$Builder:aa	I
    //   145: istore_1
    //   146: aload 5
    //   148: iload_1
    //   149: putfield 63	com/flurry/android/FrequencyCapInfo:aa	I
    //   152: aload 5
    //   154: areturn
    //   155: aload_0
    //   156: aload_0
    //   157: invokevirtual 67	com/flurry/android/FrequencyCapInfo$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   160: iconst_0
    //   161: aaload
    //   162: invokevirtual 71	com/flurry/android/FrequencyCapInfo$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   165: checkcast 73	java/lang/CharSequence
    //   168: astore 4
    //   170: goto -146 -> 24
    //   173: aload_0
    //   174: aload_0
    //   175: invokevirtual 67	com/flurry/android/FrequencyCapInfo$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   178: iconst_1
    //   179: aaload
    //   180: invokevirtual 71	com/flurry/android/FrequencyCapInfo$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   183: checkcast 75	java/lang/Long
    //   186: invokevirtual 79	java/lang/Long:longValue	()J
    //   189: lstore_2
    //   190: goto -145 -> 45
    //   193: aload_0
    //   194: aload_0
    //   195: invokevirtual 67	com/flurry/android/FrequencyCapInfo$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   198: iconst_2
    //   199: aaload
    //   200: invokevirtual 71	com/flurry/android/FrequencyCapInfo$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   203: checkcast 75	java/lang/Long
    //   206: invokevirtual 79	java/lang/Long:longValue	()J
    //   209: lstore_2
    //   210: goto -145 -> 65
    //   213: aload_0
    //   214: aload_0
    //   215: invokevirtual 67	com/flurry/android/FrequencyCapInfo$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   218: iconst_3
    //   219: aaload
    //   220: invokevirtual 71	com/flurry/android/FrequencyCapInfo$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   223: checkcast 81	java/lang/Integer
    //   226: invokevirtual 85	java/lang/Integer:intValue	()I
    //   229: istore_1
    //   230: goto -145 -> 85
    //   233: aload_0
    //   234: aload_0
    //   235: invokevirtual 67	com/flurry/android/FrequencyCapInfo$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   238: iconst_4
    //   239: aaload
    //   240: invokevirtual 71	com/flurry/android/FrequencyCapInfo$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   243: checkcast 81	java/lang/Integer
    //   246: invokevirtual 85	java/lang/Integer:intValue	()I
    //   249: istore_1
    //   250: goto -145 -> 105
    //   253: aload_0
    //   254: aload_0
    //   255: invokevirtual 67	com/flurry/android/FrequencyCapInfo$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   258: iconst_5
    //   259: aaload
    //   260: invokevirtual 71	com/flurry/android/FrequencyCapInfo$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   263: checkcast 81	java/lang/Integer
    //   266: invokevirtual 85	java/lang/Integer:intValue	()I
    //   269: istore_1
    //   270: goto -145 -> 125
    //   273: aload_0
    //   274: aload_0
    //   275: invokevirtual 67	com/flurry/android/FrequencyCapInfo$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   278: bipush 6
    //   280: aaload
    //   281: invokevirtual 71	com/flurry/android/FrequencyCapInfo$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   284: checkcast 81	java/lang/Integer
    //   287: invokevirtual 85	java/lang/Integer:intValue	()I
    //   290: istore_1
    //   291: goto -145 -> 146
    //   294: astore 4
    //   296: new 87	com/flurry/org/apache/avro/AvroRuntimeException
    //   299: dup
    //   300: aload 4
    //   302: invokespecial 90	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   305: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	Builder
    //   84	207	1	i	int
    //   44	166	2	l	long
    //   22	147	4	localCharSequence	CharSequence
    //   294	7	4	localException	Exception
    //   7	146	5	localFrequencyCapInfo	FrequencyCapInfo
    // Exception table:
    //   from	to	target	type
    //   0	24	294	java/lang/Exception
    //   24	45	294	java/lang/Exception
    //   45	65	294	java/lang/Exception
    //   65	85	294	java/lang/Exception
    //   85	105	294	java/lang/Exception
    //   105	125	294	java/lang/Exception
    //   125	146	294	java/lang/Exception
    //   146	152	294	java/lang/Exception
    //   155	170	294	java/lang/Exception
    //   173	190	294	java/lang/Exception
    //   193	210	294	java/lang/Exception
    //   213	230	294	java/lang/Exception
    //   233	250	294	java/lang/Exception
    //   253	270	294	java/lang/Exception
    //   273	291	294	java/lang/Exception
  }
  
  public Builder clearExpirationTime()
  {
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearIdHash()
  {
    this.W = null;
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearNewCap()
  {
    fieldSetFlags()[4] = 0;
    return this;
  }
  
  public Builder clearPreviousCap()
  {
    fieldSetFlags()[5] = 0;
    return this;
  }
  
  public Builder clearPreviousCapType()
  {
    fieldSetFlags()[6] = 0;
    return this;
  }
  
  public Builder clearServeTime()
  {
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearViews()
  {
    fieldSetFlags()[3] = 0;
    return this;
  }
  
  public Long getExpirationTime()
  {
    return Long.valueOf(this.ab);
  }
  
  public CharSequence getIdHash()
  {
    return this.W;
  }
  
  public Integer getNewCap()
  {
    return Integer.valueOf(this.Y);
  }
  
  public Integer getPreviousCap()
  {
    return Integer.valueOf(this.Z);
  }
  
  public Integer getPreviousCapType()
  {
    return Integer.valueOf(this.aa);
  }
  
  public Long getServeTime()
  {
    return Long.valueOf(this.X);
  }
  
  public Integer getViews()
  {
    return Integer.valueOf(this.df);
  }
  
  public boolean hasExpirationTime()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasIdHash()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasNewCap()
  {
    return fieldSetFlags()[4];
  }
  
  public boolean hasPreviousCap()
  {
    return fieldSetFlags()[5];
  }
  
  public boolean hasPreviousCapType()
  {
    return fieldSetFlags()[6];
  }
  
  public boolean hasServeTime()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasViews()
  {
    return fieldSetFlags()[3];
  }
  
  public Builder setExpirationTime(long paramLong)
  {
    validate(fields()[2], Long.valueOf(paramLong));
    this.ab = paramLong;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setIdHash(CharSequence paramCharSequence)
  {
    validate(fields()[0], paramCharSequence);
    this.W = paramCharSequence;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setNewCap(int paramInt)
  {
    validate(fields()[4], Integer.valueOf(paramInt));
    this.Y = paramInt;
    fieldSetFlags()[4] = 1;
    return this;
  }
  
  public Builder setPreviousCap(int paramInt)
  {
    validate(fields()[5], Integer.valueOf(paramInt));
    this.Z = paramInt;
    fieldSetFlags()[5] = 1;
    return this;
  }
  
  public Builder setPreviousCapType(int paramInt)
  {
    validate(fields()[6], Integer.valueOf(paramInt));
    this.aa = paramInt;
    fieldSetFlags()[6] = 1;
    return this;
  }
  
  public Builder setServeTime(long paramLong)
  {
    validate(fields()[1], Long.valueOf(paramLong));
    this.X = paramLong;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setViews(int paramInt)
  {
    validate(fields()[3], Integer.valueOf(paramInt));
    this.df = paramInt;
    fieldSetFlags()[3] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FrequencyCapInfo$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */