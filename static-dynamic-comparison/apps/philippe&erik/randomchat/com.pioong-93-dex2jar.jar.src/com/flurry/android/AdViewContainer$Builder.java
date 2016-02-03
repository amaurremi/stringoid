package com.flurry.android;

import com.flurry.org.apache.avro.data.RecordBuilder;
import com.flurry.org.apache.avro.specific.SpecificRecordBuilderBase;

public class AdViewContainer$Builder
  extends SpecificRecordBuilderBase<AdViewContainer>
  implements RecordBuilder<AdViewContainer>
{
  private int ai;
  private int aj;
  private int ak;
  private int al;
  
  private AdViewContainer$Builder(byte paramByte)
  {
    super(AdViewContainer.SCHEMA$);
  }
  
  /* Error */
  public AdViewContainer build()
  {
    // Byte code:
    //   0: new 20	com/flurry/android/AdViewContainer
    //   3: dup
    //   4: invokespecial 33	com/flurry/android/AdViewContainer:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 37	com/flurry/android/AdViewContainer$Builder:fieldSetFlags	()[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +72 -> 86
    //   17: aload_0
    //   18: getfield 39	com/flurry/android/AdViewContainer$Builder:ai	I
    //   21: istore_1
    //   22: aload_2
    //   23: iload_1
    //   24: putfield 40	com/flurry/android/AdViewContainer:ai	I
    //   27: aload_0
    //   28: invokevirtual 37	com/flurry/android/AdViewContainer$Builder:fieldSetFlags	()[Z
    //   31: iconst_1
    //   32: baload
    //   33: ifeq +73 -> 106
    //   36: aload_0
    //   37: getfield 42	com/flurry/android/AdViewContainer$Builder:aj	I
    //   40: istore_1
    //   41: aload_2
    //   42: iload_1
    //   43: putfield 43	com/flurry/android/AdViewContainer:aj	I
    //   46: aload_0
    //   47: invokevirtual 37	com/flurry/android/AdViewContainer$Builder:fieldSetFlags	()[Z
    //   50: iconst_2
    //   51: baload
    //   52: ifeq +74 -> 126
    //   55: aload_0
    //   56: getfield 45	com/flurry/android/AdViewContainer$Builder:ak	I
    //   59: istore_1
    //   60: aload_2
    //   61: iload_1
    //   62: putfield 46	com/flurry/android/AdViewContainer:ak	I
    //   65: aload_0
    //   66: invokevirtual 37	com/flurry/android/AdViewContainer$Builder:fieldSetFlags	()[Z
    //   69: iconst_3
    //   70: baload
    //   71: ifeq +75 -> 146
    //   74: aload_0
    //   75: getfield 48	com/flurry/android/AdViewContainer$Builder:al	I
    //   78: istore_1
    //   79: aload_2
    //   80: iload_1
    //   81: putfield 49	com/flurry/android/AdViewContainer:al	I
    //   84: aload_2
    //   85: areturn
    //   86: aload_0
    //   87: aload_0
    //   88: invokevirtual 53	com/flurry/android/AdViewContainer$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual 57	com/flurry/android/AdViewContainer$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   96: checkcast 59	java/lang/Integer
    //   99: invokevirtual 63	java/lang/Integer:intValue	()I
    //   102: istore_1
    //   103: goto -81 -> 22
    //   106: aload_0
    //   107: aload_0
    //   108: invokevirtual 53	com/flurry/android/AdViewContainer$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   111: iconst_1
    //   112: aaload
    //   113: invokevirtual 57	com/flurry/android/AdViewContainer$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   116: checkcast 59	java/lang/Integer
    //   119: invokevirtual 63	java/lang/Integer:intValue	()I
    //   122: istore_1
    //   123: goto -82 -> 41
    //   126: aload_0
    //   127: aload_0
    //   128: invokevirtual 53	com/flurry/android/AdViewContainer$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   131: iconst_2
    //   132: aaload
    //   133: invokevirtual 57	com/flurry/android/AdViewContainer$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   136: checkcast 59	java/lang/Integer
    //   139: invokevirtual 63	java/lang/Integer:intValue	()I
    //   142: istore_1
    //   143: goto -83 -> 60
    //   146: aload_0
    //   147: aload_0
    //   148: invokevirtual 53	com/flurry/android/AdViewContainer$Builder:fields	()[Lcom/flurry/org/apache/avro/Schema$Field;
    //   151: iconst_3
    //   152: aaload
    //   153: invokevirtual 57	com/flurry/android/AdViewContainer$Builder:defaultValue	(Lcom/flurry/org/apache/avro/Schema$Field;)Ljava/lang/Object;
    //   156: checkcast 59	java/lang/Integer
    //   159: invokevirtual 63	java/lang/Integer:intValue	()I
    //   162: istore_1
    //   163: goto -84 -> 79
    //   166: astore_2
    //   167: new 65	com/flurry/org/apache/avro/AvroRuntimeException
    //   170: dup
    //   171: aload_2
    //   172: invokespecial 68	com/flurry/org/apache/avro/AvroRuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	Builder
    //   21	142	1	i	int
    //   7	78	2	localAdViewContainer	AdViewContainer
    //   166	6	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	166	java/lang/Exception
    //   22	41	166	java/lang/Exception
    //   41	60	166	java/lang/Exception
    //   60	79	166	java/lang/Exception
    //   79	84	166	java/lang/Exception
    //   86	103	166	java/lang/Exception
    //   106	123	166	java/lang/Exception
    //   126	143	166	java/lang/Exception
    //   146	163	166	java/lang/Exception
  }
  
  public Builder clearScreenHeight()
  {
    fieldSetFlags()[3] = 0;
    return this;
  }
  
  public Builder clearScreenWidth()
  {
    fieldSetFlags()[2] = 0;
    return this;
  }
  
  public Builder clearViewHeight()
  {
    fieldSetFlags()[1] = 0;
    return this;
  }
  
  public Builder clearViewWidth()
  {
    fieldSetFlags()[0] = 0;
    return this;
  }
  
  public Integer getScreenHeight()
  {
    return Integer.valueOf(this.al);
  }
  
  public Integer getScreenWidth()
  {
    return Integer.valueOf(this.ak);
  }
  
  public Integer getViewHeight()
  {
    return Integer.valueOf(this.aj);
  }
  
  public Integer getViewWidth()
  {
    return Integer.valueOf(this.ai);
  }
  
  public boolean hasScreenHeight()
  {
    return fieldSetFlags()[3];
  }
  
  public boolean hasScreenWidth()
  {
    return fieldSetFlags()[2];
  }
  
  public boolean hasViewHeight()
  {
    return fieldSetFlags()[1];
  }
  
  public boolean hasViewWidth()
  {
    return fieldSetFlags()[0];
  }
  
  public Builder setScreenHeight(int paramInt)
  {
    validate(fields()[3], Integer.valueOf(paramInt));
    this.al = paramInt;
    fieldSetFlags()[3] = 1;
    return this;
  }
  
  public Builder setScreenWidth(int paramInt)
  {
    validate(fields()[2], Integer.valueOf(paramInt));
    this.ak = paramInt;
    fieldSetFlags()[2] = 1;
    return this;
  }
  
  public Builder setViewHeight(int paramInt)
  {
    validate(fields()[1], Integer.valueOf(paramInt));
    this.aj = paramInt;
    fieldSetFlags()[1] = 1;
    return this;
  }
  
  public Builder setViewWidth(int paramInt)
  {
    validate(fields()[0], Integer.valueOf(paramInt));
    this.ai = paramInt;
    fieldSetFlags()[0] = 1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdViewContainer$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */