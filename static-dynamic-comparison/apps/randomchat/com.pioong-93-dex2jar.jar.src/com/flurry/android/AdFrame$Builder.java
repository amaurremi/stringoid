package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;
import java.util.List;

public class AdFrame$Builder
  extends SpecificRecordBuilderBase<AdFrame>
  implements RecordBuilder<AdFrame>
{
  private int p;
  private CharSequence q;
  private CharSequence r;
  private AdSpaceLayout s;
  private List<Callback> t;
  private CharSequence u;
  
  private AdFrame$Builder()
  {
    super(AdFrame.SCHEMA$);
  }
  
  /* Error */
  public AdFrame build()
  {
    // Byte code:
    //   0: new 22	com/flurry/android/AdFrame
    //   3: dup
    //   4: invokespecial 36	com/flurry/android/AdFrame:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 40	com/flurry/android/AdFrame$Builder:fieldSetFlags	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +110 -> 124
    //   17: aload_0
    //   18: getfield 42	com/flurry/android/AdFrame$Builder:p	I
    //   21: istore_1
    //   22: aload_3
    //   23: iload_1
    //   24: putfield 43	com/flurry/android/AdFrame:p	I
    //   27: aload_0
    //   28: invokevirtual 40	com/flurry/android/AdFrame$Builder:fieldSetFlags	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +111 -> 144
    //   36: aload_0
    //   37: getfield 45	com/flurry/android/AdFrame$Builder:q	Ljava/lang/CharSequence;
    //   40: astore_2
    //   41: aload_3
    //   42: aload_2
    //   43: putfield 46	com/flurry/android/AdFrame:q	Ljava/lang/CharSequence;
    //   46: aload_0
    //   47: invokevirtual 40	com/flurry/android/AdFrame$Builder:fieldSetFlags	()[Z
    //   50: iconst_2
    //   51: baload
    //   52: ifeq +109 -> 161
    //   55: aload_0
    //   56: getfield 48	com/flurry/android/AdFrame$Builder:r	Ljava/lang/CharSequence;
    //   59: astore_2
    //   60: aload_3
    //   61: aload_2
    //   62: putfield 49	com/flurry/android/AdFrame:r	Ljava/lang/CharSequence;
    //   65: aload_0
    //   66: invokevirtual 40	com/flurry/android/AdFrame$Builder:fieldSetFlags	()[Z
    //   69: iconst_3
    //   70: baload
    //   71: ifeq +107 -> 178
    //   74: aload_0
    //   75: getfield 51	com/flurry/android/AdFrame$Builder:s	Lcom/flurry/android/AdSpaceLayout;
    //   78: astore_2
    //   79: aload_3
    //   80: aload_2
    //   81: putfield 52	com/flurry/android/AdFrame:s	Lcom/flurry/android/AdSpaceLayout;
    //   84: aload_0
    //   85: invokevirtual 40	com/flurry/android/AdFrame$Builder:fieldSetFlags	()[Z
    //   88: iconst_4
    //   89: baload
    //   90: ifeq +105 -> 195
    //   93: aload_0
    //   94: getfield 54	com/flurry/android/AdFrame$Builder:t	Ljava/util/List;
    //   97: astore_2
    //   98: aload_3
    //   99: aload_2
    //   100: putfield 55	com/flurry/android/AdFrame:t	Ljava/util/List;
    //   103: aload_0
    //   104: invokevirtual 40	com/flurry/android/AdFrame$Builder:fieldSetFlags	()[Z
    //   107: iconst_5
    //   108: baload
    //   109: ifeq +103 -> 212
    //   112: aload_0
    //   113: getfield 57	com/flurry/android/AdFrame$Builder:u	Ljava/lang/CharSequence;
    //   116: astore_2
    //   117: aload_3
    //   118: aload_2
    //   119: putfield 58	com/flurry/android/AdFrame:u	Ljava/lang/CharSequence;
    //   122: aload_3
    //   123: areturn
    //   124: aload_0
    //   125: aload_0
    //   126: invokevirtual 62	com/flurry/android/AdFrame$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   129: iconst_0
    //   130: aaload
    //   131: invokevirtual 66	com/flurry/android/AdFrame$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   134: checkcast 68	java/lang/Integer
    //   137: invokevirtual 72	java/lang/Integer:intValue	()I
    //   140: istore_1
    //   141: goto -119 -> 22
    //   144: aload_0
    //   145: aload_0
    //   146: invokevirtual 62	com/flurry/android/AdFrame$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   149: iconst_1
    //   150: aaload
    //   151: invokevirtual 66	com/flurry/android/AdFrame$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   154: checkcast 74	java/lang/CharSequence
    //   157: astore_2
    //   158: goto -117 -> 41
    //   161: aload_0
    //   162: aload_0
    //   163: invokevirtual 62	com/flurry/android/AdFrame$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   166: iconst_2
    //   167: aaload
    //   168: invokevirtual 66	com/flurry/android/AdFrame$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   171: checkcast 74	java/lang/CharSequence
    //   174: astore_2
    //   175: goto -115 -> 60
    //   178: aload_0
    //   179: aload_0
    //   180: invokevirtual 62	com/flurry/android/AdFrame$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   183: iconst_3
    //   184: aaload
    //   185: invokevirtual 66	com/flurry/android/AdFrame$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   188: checkcast 76	com/flurry/android/AdSpaceLayout
    //   191: astore_2
    //   192: goto -113 -> 79
    //   195: aload_0
    //   196: aload_0
    //   197: invokevirtual 62	com/flurry/android/AdFrame$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   200: iconst_4
    //   201: aaload
    //   202: invokevirtual 66	com/flurry/android/AdFrame$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   205: checkcast 78	java/util/List
    //   208: astore_2
    //   209: goto -111 -> 98
    //   212: aload_0
    //   213: aload_0
    //   214: invokevirtual 62	com/flurry/android/AdFrame$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   217: iconst_5
    //   218: aaload
    //   219: invokevirtual 66	com/flurry/android/AdFrame$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   222: checkcast 74	java/lang/CharSequence
    //   225: astore_2
    //   226: goto -109 -> 117
    //   229: astore_2
    //   230: new 80	com/flurry/org/apache/avro/AvroRuntimeException
    //   233: dup
    //   234: aload_2
    //   235: invokespecial 83	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	Builder
    //   21	120	1	i	int
    //   40	186	2	localObject	Object
    //   229	6	2	localException	Exception
    //   7	116	3	localAdFrame	AdFrame
    // Exception table:
    //   from	to	target	type
    //   0	22	229	java/lang/Exception
    //   22	41	229	java/lang/Exception
    //   41	60	229	java/lang/Exception
    //   60	79	229	java/lang/Exception
    //   79	98	229	java/lang/Exception
    //   98	117	229	java/lang/Exception
    //   117	122	229	java/lang/Exception
    //   124	141	229	java/lang/Exception
    //   144	158	229	java/lang/Exception
    //   161	175	229	java/lang/Exception
    //   178	192	229	java/lang/Exception
    //   195	209	229	java/lang/Exception
    //   212	226	229	java/lang/Exception
  }
  
  public Builder clearAdGuid()
  {
    this.u = null;
    fieldSetFlags()[5] = 0;
    return this;
  }
  
  public Builder clearAdSpaceLayout()
  {
    this.s = null;
    fieldSetFlags()[3] = 0;
    return this;
  }
  
  public Builder clearBinding()
  {
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Builder clearCallbacks()
  {
    this.t = null;
    fieldSetFlags()[4] = 0;
    return this;
  }
  
  public Builder clearContent()
  {
    this.r = null;
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearDisplay()
  {
    this.q = null;
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public CharSequence getAdGuid()
  {
    return this.u;
  }
  
  public AdSpaceLayout getAdSpaceLayout()
  {
    return this.s;
  }
  
  public Integer getBinding()
  {
    return Integer.valueOf(this.p);
  }
  
  public List<Callback> getCallbacks()
  {
    return this.t;
  }
  
  public CharSequence getContent()
  {
    return this.r;
  }
  
  public CharSequence getDisplay()
  {
    return this.q;
  }
  
  public boolean hasAdGuid()
  {
    return fieldSetFlags()[5];
  }
  
  public boolean hasAdSpaceLayout()
  {
    return fieldSetFlags()[3];
  }
  
  public boolean hasBinding()
  {
    return fieldSetFlags()[0];
  }
  
  public boolean hasCallbacks()
  {
    return fieldSetFlags()[4];
  }
  
  public boolean hasContent()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasDisplay()
  {
    return fieldSetFlags()[1];
  }
  
  public Builder setAdGuid(CharSequence paramCharSequence)
  {
    validate(fields()[5], paramCharSequence);
    this.u = paramCharSequence;
    fieldSetFlags()[5] = 1;
    return this;
  }
  
  public Builder setAdSpaceLayout(AdSpaceLayout paramAdSpaceLayout)
  {
    validate(fields()[3], paramAdSpaceLayout);
    this.s = paramAdSpaceLayout;
    fieldSetFlags()[3] = 1;
    return this;
  }
  
  public Builder setBinding(int paramInt)
  {
    validate(fields()[0], Integer.valueOf(paramInt));
    this.p = paramInt;
    fieldSetFlags()[0] = 1;
    return this;
  }
  
  public Builder setCallbacks(List<Callback> paramList)
  {
    validate(fields()[4], paramList);
    this.t = paramList;
    fieldSetFlags()[4] = 1;
    return this;
  }
  
  public Builder setContent(CharSequence paramCharSequence)
  {
    validate(fields()[2], paramCharSequence);
    this.r = paramCharSequence;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setDisplay(CharSequence paramCharSequence)
  {
    validate(fields()[1], paramCharSequence);
    this.q = paramCharSequence;
    fieldSetFlags()[1] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdFrame$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */