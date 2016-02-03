package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

public class AdUnit$Builder
  extends SpecificRecordBuilderBase<AdUnit>
  implements RecordBuilder<AdUnit>
{
  private CharSequence R;
  private long S;
  private List<AdFrame> T;
  private int U;
  private CharSequence V;
  private CharSequence W;
  private long X;
  private int Y;
  private int Z;
  private int aa;
  private long ab;
  
  private AdUnit$Builder()
  {
    super(AdUnit.SCHEMA$);
  }
  
  /* Error */
  public AdUnit build()
  {
    // Byte code:
    //   0: new 27	com/flurry/android/AdUnit
    //   3: dup
    //   4: invokespecial 41	com/flurry/android/AdUnit:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   13: iconst_0
    //   14: baload
    //   15: ifeq +230 -> 245
    //   18: aload_0
    //   19: getfield 47	com/flurry/android/AdUnit$Builder:R	Ljava/lang/CharSequence;
    //   22: astore 4
    //   24: aload 5
    //   26: aload 4
    //   28: putfield 48	com/flurry/android/AdUnit:R	Ljava/lang/CharSequence;
    //   31: aload_0
    //   32: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   35: iconst_1
    //   36: baload
    //   37: ifeq +226 -> 263
    //   40: aload_0
    //   41: getfield 50	com/flurry/android/AdUnit$Builder:S	J
    //   44: lstore_2
    //   45: aload 5
    //   47: lload_2
    //   48: putfield 51	com/flurry/android/AdUnit:S	J
    //   51: aload_0
    //   52: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   55: iconst_2
    //   56: baload
    //   57: ifeq +226 -> 283
    //   60: aload_0
    //   61: getfield 53	com/flurry/android/AdUnit$Builder:T	Ljava/util/List;
    //   64: astore 4
    //   66: aload 5
    //   68: aload 4
    //   70: putfield 54	com/flurry/android/AdUnit:T	Ljava/util/List;
    //   73: aload_0
    //   74: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   77: iconst_3
    //   78: baload
    //   79: ifeq +222 -> 301
    //   82: aload_0
    //   83: getfield 56	com/flurry/android/AdUnit$Builder:U	I
    //   86: istore_1
    //   87: aload 5
    //   89: iload_1
    //   90: putfield 57	com/flurry/android/AdUnit:U	I
    //   93: aload_0
    //   94: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   97: iconst_4
    //   98: baload
    //   99: ifeq +222 -> 321
    //   102: aload_0
    //   103: getfield 59	com/flurry/android/AdUnit$Builder:V	Ljava/lang/CharSequence;
    //   106: astore 4
    //   108: aload 5
    //   110: aload 4
    //   112: putfield 60	com/flurry/android/AdUnit:V	Ljava/lang/CharSequence;
    //   115: aload_0
    //   116: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   119: iconst_5
    //   120: baload
    //   121: ifeq +218 -> 339
    //   124: aload_0
    //   125: getfield 62	com/flurry/android/AdUnit$Builder:W	Ljava/lang/CharSequence;
    //   128: astore 4
    //   130: aload 5
    //   132: aload 4
    //   134: putfield 63	com/flurry/android/AdUnit:W	Ljava/lang/CharSequence;
    //   137: aload_0
    //   138: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   141: bipush 6
    //   143: baload
    //   144: ifeq +213 -> 357
    //   147: aload_0
    //   148: getfield 65	com/flurry/android/AdUnit$Builder:X	J
    //   151: lstore_2
    //   152: aload 5
    //   154: lload_2
    //   155: putfield 66	com/flurry/android/AdUnit:X	J
    //   158: aload_0
    //   159: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   162: bipush 7
    //   164: baload
    //   165: ifeq +213 -> 378
    //   168: aload_0
    //   169: getfield 68	com/flurry/android/AdUnit$Builder:Y	I
    //   172: istore_1
    //   173: aload 5
    //   175: iload_1
    //   176: putfield 69	com/flurry/android/AdUnit:Y	I
    //   179: aload_0
    //   180: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   183: bipush 8
    //   185: baload
    //   186: ifeq +213 -> 399
    //   189: aload_0
    //   190: getfield 71	com/flurry/android/AdUnit$Builder:Z	I
    //   193: istore_1
    //   194: aload 5
    //   196: iload_1
    //   197: putfield 72	com/flurry/android/AdUnit:Z	I
    //   200: aload_0
    //   201: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   204: bipush 9
    //   206: baload
    //   207: ifeq +213 -> 420
    //   210: aload_0
    //   211: getfield 74	com/flurry/android/AdUnit$Builder:aa	I
    //   214: istore_1
    //   215: aload 5
    //   217: iload_1
    //   218: putfield 75	com/flurry/android/AdUnit:aa	I
    //   221: aload_0
    //   222: invokevirtual 45	com/flurry/android/AdUnit$Builder:fieldSetFlags	()[Z
    //   225: bipush 10
    //   227: baload
    //   228: ifeq +213 -> 441
    //   231: aload_0
    //   232: getfield 77	com/flurry/android/AdUnit$Builder:ab	J
    //   235: lstore_2
    //   236: aload 5
    //   238: lload_2
    //   239: putfield 78	com/flurry/android/AdUnit:ab	J
    //   242: aload 5
    //   244: areturn
    //   245: aload_0
    //   246: aload_0
    //   247: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   250: iconst_0
    //   251: aaload
    //   252: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   255: checkcast 88	java/lang/CharSequence
    //   258: astore 4
    //   260: goto -236 -> 24
    //   263: aload_0
    //   264: aload_0
    //   265: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   268: iconst_1
    //   269: aaload
    //   270: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   273: checkcast 90	java/lang/Long
    //   276: invokevirtual 94	java/lang/Long:longValue	()J
    //   279: lstore_2
    //   280: goto -235 -> 45
    //   283: aload_0
    //   284: aload_0
    //   285: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   288: iconst_2
    //   289: aaload
    //   290: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   293: checkcast 96	java/util/List
    //   296: astore 4
    //   298: goto -232 -> 66
    //   301: aload_0
    //   302: aload_0
    //   303: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   306: iconst_3
    //   307: aaload
    //   308: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   311: checkcast 98	java/lang/Integer
    //   314: invokevirtual 102	java/lang/Integer:intValue	()I
    //   317: istore_1
    //   318: goto -231 -> 87
    //   321: aload_0
    //   322: aload_0
    //   323: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   326: iconst_4
    //   327: aaload
    //   328: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   331: checkcast 88	java/lang/CharSequence
    //   334: astore 4
    //   336: goto -228 -> 108
    //   339: aload_0
    //   340: aload_0
    //   341: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   344: iconst_5
    //   345: aaload
    //   346: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   349: checkcast 88	java/lang/CharSequence
    //   352: astore 4
    //   354: goto -224 -> 130
    //   357: aload_0
    //   358: aload_0
    //   359: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   362: bipush 6
    //   364: aaload
    //   365: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   368: checkcast 90	java/lang/Long
    //   371: invokevirtual 94	java/lang/Long:longValue	()J
    //   374: lstore_2
    //   375: goto -223 -> 152
    //   378: aload_0
    //   379: aload_0
    //   380: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   383: bipush 7
    //   385: aaload
    //   386: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   389: checkcast 98	java/lang/Integer
    //   392: invokevirtual 102	java/lang/Integer:intValue	()I
    //   395: istore_1
    //   396: goto -223 -> 173
    //   399: aload_0
    //   400: aload_0
    //   401: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   404: bipush 8
    //   406: aaload
    //   407: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   410: checkcast 98	java/lang/Integer
    //   413: invokevirtual 102	java/lang/Integer:intValue	()I
    //   416: istore_1
    //   417: goto -223 -> 194
    //   420: aload_0
    //   421: aload_0
    //   422: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   425: bipush 9
    //   427: aaload
    //   428: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   431: checkcast 98	java/lang/Integer
    //   434: invokevirtual 102	java/lang/Integer:intValue	()I
    //   437: istore_1
    //   438: goto -223 -> 215
    //   441: aload_0
    //   442: aload_0
    //   443: invokevirtual 82	com/flurry/android/AdUnit$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   446: bipush 10
    //   448: aaload
    //   449: invokevirtual 86	com/flurry/android/AdUnit$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   452: checkcast 90	java/lang/Long
    //   455: invokevirtual 94	java/lang/Long:longValue	()J
    //   458: lstore_2
    //   459: goto -223 -> 236
    //   462: astore 4
    //   464: new 104	com/flurry/org/apache/avro/AvroRuntimeException
    //   467: dup
    //   468: aload 4
    //   470: invokespecial 107	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   473: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	this	Builder
    //   86	352	1	i	int
    //   44	415	2	l	long
    //   22	331	4	localObject	Object
    //   462	7	4	localException	Exception
    //   7	236	5	localAdUnit	AdUnit
    // Exception table:
    //   from	to	target	type
    //   0	24	462	java/lang/Exception
    //   24	45	462	java/lang/Exception
    //   45	66	462	java/lang/Exception
    //   66	87	462	java/lang/Exception
    //   87	108	462	java/lang/Exception
    //   108	130	462	java/lang/Exception
    //   130	152	462	java/lang/Exception
    //   152	173	462	java/lang/Exception
    //   173	194	462	java/lang/Exception
    //   194	215	462	java/lang/Exception
    //   215	236	462	java/lang/Exception
    //   236	242	462	java/lang/Exception
    //   245	260	462	java/lang/Exception
    //   263	280	462	java/lang/Exception
    //   283	298	462	java/lang/Exception
    //   301	318	462	java/lang/Exception
    //   321	336	462	java/lang/Exception
    //   339	354	462	java/lang/Exception
    //   357	375	462	java/lang/Exception
    //   378	396	462	java/lang/Exception
    //   399	417	462	java/lang/Exception
    //   420	438	462	java/lang/Exception
    //   441	459	462	java/lang/Exception
  }
  
  public Builder clearAdFrames()
  {
    this.T = null;
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearAdSpace()
  {
    this.R = null;
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearCombinable()
  {
    fieldSetFlags()[3] = 0;
    return this;
  }
  
  public Builder clearExpiration()
  {
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearExpirationTime()
  {
    fieldSetFlags()[10] = 0;
    return this;
  }
  
  public Builder clearGroupId()
  {
    this.V = null;
    fieldSetFlags()[4] = 0;
    return this;
  }
  
  public Builder clearIdHash()
  {
    this.W = null;
    fieldSetFlags()[5] = 0;
    return this;
  }
  
  public Builder clearNewCap()
  {
    fieldSetFlags()[7] = 0;
    return this;
  }
  
  public Builder clearPreviousCap()
  {
    fieldSetFlags()[8] = 0;
    return this;
  }
  
  public Builder clearPreviousCapType()
  {
    fieldSetFlags()[9] = 0;
    return this;
  }
  
  public Builder clearServeTime()
  {
    fieldSetFlags()[6] = 0;
    return this;
  }
  
  public List<AdFrame> getAdFrames()
  {
    return this.T;
  }
  
  public CharSequence getAdSpace()
  {
    return this.R;
  }
  
  public Integer getCombinable()
  {
    return Integer.valueOf(this.U);
  }
  
  public Long getExpiration()
  {
    return Long.valueOf(this.S);
  }
  
  public Long getExpirationTime()
  {
    return Long.valueOf(this.ab);
  }
  
  public CharSequence getGroupId()
  {
    return this.V;
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
  
  public boolean hasAdFrames()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasAdSpace()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasCombinable()
  {
    return fieldSetFlags()[3];
  }
  
  public boolean hasExpiration()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasExpirationTime()
  {
    return fieldSetFlags()[10];
  }
  
  public boolean hasGroupId()
  {
    return fieldSetFlags()[4];
  }
  
  public boolean hasIdHash()
  {
    return fieldSetFlags()[5];
  }
  
  public boolean hasNewCap()
  {
    return fieldSetFlags()[7];
  }
  
  public boolean hasPreviousCap()
  {
    return fieldSetFlags()[8];
  }
  
  public boolean hasPreviousCapType()
  {
    return fieldSetFlags()[9];
  }
  
  public boolean hasServeTime()
  {
    return fieldSetFlags()[6];
  }
  
  public Builder setAdFrames(List<AdFrame> paramList)
  {
    validate(fields()[2], paramList);
    this.T = paramList;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setAdSpace(CharSequence paramCharSequence)
  {
    validate(fields()[0], paramCharSequence);
    this.R = paramCharSequence;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setCombinable(int paramInt)
  {
    validate(fields()[3], Integer.valueOf(paramInt));
    this.U = paramInt;
    fieldSetFlags()[3] = 1;
    return this;
  }
  
  public Builder setExpiration(long paramLong)
  {
    validate(fields()[1], Long.valueOf(paramLong));
    this.S = paramLong;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setExpirationTime(long paramLong)
  {
    validate(fields()[10], Long.valueOf(paramLong));
    this.ab = paramLong;
    fieldSetFlags()[10] = 1;
    return this;
  }
  
  public Builder setGroupId(CharSequence paramCharSequence)
  {
    validate(fields()[4], paramCharSequence);
    this.V = paramCharSequence;
    fieldSetFlags()[4] = 1;
    return this;
  }
  
  public Builder setIdHash(CharSequence paramCharSequence)
  {
    validate(fields()[5], paramCharSequence);
    this.W = paramCharSequence;
    fieldSetFlags()[5] = 1;
    return this;
  }
  
  public Builder setNewCap(int paramInt)
  {
    validate(fields()[7], Integer.valueOf(paramInt));
    this.Y = paramInt;
    fieldSetFlags()[7] = 1;
    return this;
  }
  
  public Builder setPreviousCap(int paramInt)
  {
    validate(fields()[8], Integer.valueOf(paramInt));
    this.Z = paramInt;
    fieldSetFlags()[8] = 1;
    return this;
  }
  
  public Builder setPreviousCapType(int paramInt)
  {
    validate(fields()[9], Integer.valueOf(paramInt));
    this.aa = paramInt;
    fieldSetFlags()[9] = 1;
    return this;
  }
  
  public Builder setServeTime(long paramLong)
  {
    validate(fields()[6], Long.valueOf(paramLong));
    this.X = paramLong;
    fieldSetFlags()[6] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdUnit$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */