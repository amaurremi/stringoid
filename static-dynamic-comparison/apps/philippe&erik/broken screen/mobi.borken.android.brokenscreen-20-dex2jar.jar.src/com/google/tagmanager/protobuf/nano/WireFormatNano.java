package com.google.tagmanager.protobuf.nano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class WireFormatNano
{
  public static final boolean[] EMPTY_BOOLEAN_ARRAY;
  public static final Boolean[] EMPTY_BOOLEAN_REF_ARRAY = new Boolean[0];
  public static final byte[] EMPTY_BYTES;
  public static final byte[][] EMPTY_BYTES_ARRAY;
  public static final double[] EMPTY_DOUBLE_ARRAY;
  public static final Double[] EMPTY_DOUBLE_REF_ARRAY;
  public static final float[] EMPTY_FLOAT_ARRAY;
  public static final Float[] EMPTY_FLOAT_REF_ARRAY;
  public static final int[] EMPTY_INT_ARRAY;
  public static final Integer[] EMPTY_INT_REF_ARRAY;
  public static final long[] EMPTY_LONG_ARRAY;
  public static final Long[] EMPTY_LONG_REF_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  static final int MESSAGE_SET_ITEM = 1;
  static final int MESSAGE_SET_ITEM_END_TAG;
  static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
  static final int MESSAGE_SET_MESSAGE = 3;
  static final int MESSAGE_SET_MESSAGE_TAG;
  static final int MESSAGE_SET_TYPE_ID = 2;
  static final int MESSAGE_SET_TYPE_ID_TAG;
  static final int TAG_TYPE_BITS = 3;
  static final int TAG_TYPE_MASK = 7;
  static final int WIRETYPE_END_GROUP = 4;
  static final int WIRETYPE_FIXED32 = 5;
  static final int WIRETYPE_FIXED64 = 1;
  static final int WIRETYPE_LENGTH_DELIMITED = 2;
  static final int WIRETYPE_START_GROUP = 3;
  static final int WIRETYPE_VARINT = 0;
  
  static
  {
    MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    EMPTY_INT_ARRAY = new int[0];
    EMPTY_LONG_ARRAY = new long[0];
    EMPTY_FLOAT_ARRAY = new float[0];
    EMPTY_DOUBLE_ARRAY = new double[0];
    EMPTY_BOOLEAN_ARRAY = new boolean[0];
    EMPTY_STRING_ARRAY = new String[0];
    EMPTY_BYTES_ARRAY = new byte[0][];
    EMPTY_BYTES = new byte[0];
    EMPTY_INT_REF_ARRAY = new Integer[0];
    EMPTY_LONG_REF_ARRAY = new Long[0];
    EMPTY_FLOAT_REF_ARRAY = new Float[0];
    EMPTY_DOUBLE_REF_ARRAY = new Double[0];
  }
  
  public static int computeWireSize(List<UnknownFieldData> paramList)
  {
    int j;
    if (paramList == null)
    {
      j = 0;
      return j;
    }
    int i = 0;
    paramList = paramList.iterator();
    for (;;)
    {
      j = i;
      if (!paramList.hasNext()) {
        break;
      }
      UnknownFieldData localUnknownFieldData = (UnknownFieldData)paramList.next();
      i = i + CodedOutputByteBufferNano.computeRawVarint32Size(localUnknownFieldData.tag) + localUnknownFieldData.bytes.length;
    }
  }
  
  public static <T> T getExtension(Extension<T> paramExtension, List<UnknownFieldData> paramList)
  {
    if (paramList == null) {}
    Object localObject;
    UnknownFieldData localUnknownFieldData;
    do
    {
      return null;
      localObject = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localUnknownFieldData = (UnknownFieldData)paramList.next();
        if (getTagFieldNumber(localUnknownFieldData.tag) == paramExtension.fieldNumber) {
          ((List)localObject).add(localUnknownFieldData);
        }
      }
    } while (((List)localObject).isEmpty());
    if (paramExtension.isRepeatedField)
    {
      paramList = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localUnknownFieldData = (UnknownFieldData)((Iterator)localObject).next();
        paramList.add(readData(paramExtension.fieldType, localUnknownFieldData.bytes));
      }
      return (T)paramExtension.listType.cast(paramList);
    }
    paramList = (UnknownFieldData)((List)localObject).get(((List)localObject).size() - 1);
    return (T)readData(paramExtension.fieldType, paramList.bytes);
  }
  
  public static final int getRepeatedFieldArrayLength(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = paramCodedInputByteBufferNano.getPosition();
    paramCodedInputByteBufferNano.skipField(paramInt);
    for (;;)
    {
      if ((paramCodedInputByteBufferNano.getBytesUntilLimit() <= 0) || (paramCodedInputByteBufferNano.readTag() != paramInt))
      {
        paramCodedInputByteBufferNano.rewindToPosition(j);
        return i;
      }
      paramCodedInputByteBufferNano.skipField(paramInt);
      i += 1;
    }
  }
  
  public static int getTagFieldNumber(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  static int getTagWireType(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  static int makeTag(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static boolean parseUnknownField(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt)
    throws IOException
  {
    return paramCodedInputByteBufferNano.skipField(paramInt);
  }
  
  /* Error */
  private static <T> T readData(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: ifne +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_1
    //   8: invokestatic 231	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:newInstance	([B)Lcom/google/tagmanager/protobuf/nano/CodedInputByteBufferNano;
    //   11: astore_1
    //   12: aload_0
    //   13: ldc 79
    //   15: if_acmpne +12 -> 27
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 235	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readString	()Ljava/lang/String;
    //   23: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: areturn
    //   27: aload_0
    //   28: ldc 88
    //   30: if_acmpne +15 -> 45
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 238	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readInt32	()I
    //   38: invokestatic 242	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: areturn
    //   45: aload_0
    //   46: ldc 92
    //   48: if_acmpne +15 -> 63
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 246	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readInt64	()J
    //   56: invokestatic 249	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: areturn
    //   63: aload_0
    //   64: ldc 104
    //   66: if_acmpne +15 -> 81
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 252	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readBool	()Z
    //   74: invokestatic 255	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: areturn
    //   81: aload_0
    //   82: ldc 96
    //   84: if_acmpne +15 -> 99
    //   87: aload_0
    //   88: aload_1
    //   89: invokevirtual 259	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readFloat	()F
    //   92: invokestatic 262	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   95: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: areturn
    //   99: aload_0
    //   100: ldc 100
    //   102: if_acmpne +15 -> 117
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 266	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readDouble	()D
    //   110: invokestatic 269	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   113: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: areturn
    //   117: aload_0
    //   118: ldc 82
    //   120: if_acmpne +12 -> 132
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 273	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readBytes	()[B
    //   128: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: areturn
    //   132: ldc_w 275
    //   135: aload_0
    //   136: invokevirtual 279	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   139: istore_2
    //   140: iload_2
    //   141: ifeq +97 -> 238
    //   144: aload_0
    //   145: invokevirtual 281	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   148: checkcast 275	com/google/tagmanager/protobuf/nano/MessageNano
    //   151: astore_3
    //   152: aload_1
    //   153: aload_3
    //   154: invokevirtual 285	com/google/tagmanager/protobuf/nano/CodedInputByteBufferNano:readMessage	(Lcom/google/tagmanager/protobuf/nano/MessageNano;)V
    //   157: aload_0
    //   158: aload_3
    //   159: invokevirtual 192	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: astore_1
    //   163: aload_1
    //   164: areturn
    //   165: astore_1
    //   166: new 287	java/lang/IllegalArgumentException
    //   169: dup
    //   170: new 289	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 292
    //   180: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aload_1
    //   191: invokespecial 305	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: athrow
    //   195: astore_0
    //   196: new 287	java/lang/IllegalArgumentException
    //   199: dup
    //   200: ldc_w 307
    //   203: aload_0
    //   204: invokespecial 305	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: athrow
    //   208: astore_1
    //   209: new 287	java/lang/IllegalArgumentException
    //   212: dup
    //   213: new 289	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 292
    //   223: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_0
    //   227: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: aload_1
    //   234: invokespecial 305	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: athrow
    //   238: new 287	java/lang/IllegalArgumentException
    //   241: dup
    //   242: new 289	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 309
    //   252: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokespecial 312	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramClass	Class<T>
    //   0	266	1	paramArrayOfByte	byte[]
    //   139	2	2	bool	boolean
    //   151	8	3	localMessageNano	MessageNano
    // Exception table:
    //   from	to	target	type
    //   144	163	165	java/lang/IllegalAccessException
    //   18	27	195	java/io/IOException
    //   33	45	195	java/io/IOException
    //   51	63	195	java/io/IOException
    //   69	81	195	java/io/IOException
    //   87	99	195	java/io/IOException
    //   105	117	195	java/io/IOException
    //   123	132	195	java/io/IOException
    //   132	140	195	java/io/IOException
    //   144	163	195	java/io/IOException
    //   166	195	195	java/io/IOException
    //   209	238	195	java/io/IOException
    //   238	266	195	java/io/IOException
    //   144	163	208	java/lang/InstantiationException
  }
  
  public static <T> void setExtension(Extension<T> paramExtension, T paramT, List<UnknownFieldData> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UnknownFieldData localUnknownFieldData = (UnknownFieldData)((Iterator)localObject).next();
      if (paramExtension.fieldNumber == getTagFieldNumber(localUnknownFieldData.tag)) {
        ((Iterator)localObject).remove();
      }
    }
    if (paramT == null) {}
    for (;;)
    {
      return;
      if (!(paramT instanceof List)) {
        break;
      }
      paramT = ((List)paramT).iterator();
      while (paramT.hasNext())
      {
        localObject = paramT.next();
        paramList.add(write(paramExtension.fieldNumber, localObject));
      }
    }
    paramList.add(write(paramExtension.fieldNumber, paramT));
  }
  
  public static boolean storeUnknownField(List<UnknownFieldData> paramList, CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt)
    throws IOException
  {
    int i = paramCodedInputByteBufferNano.getPosition();
    boolean bool = paramCodedInputByteBufferNano.skipField(paramInt);
    paramList.add(new UnknownFieldData(paramInt, paramCodedInputByteBufferNano.getData(i, paramCodedInputByteBufferNano.getPosition() - i)));
    return bool;
  }
  
  private static UnknownFieldData write(int paramInt, Object paramObject)
  {
    Object localObject = paramObject.getClass();
    if (localObject == String.class) {}
    for (;;)
    {
      try
      {
        localObject = (String)paramObject;
        paramObject = new byte[CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject)];
        CodedOutputByteBufferNano.newInstance((byte[])paramObject).writeStringNoTag((String)localObject);
        paramInt = makeTag(paramInt, 2);
        return new UnknownFieldData(paramInt, (byte[])paramObject);
      }
      catch (IOException paramObject)
      {
        int i;
        CodedOutputByteBufferNano localCodedOutputByteBufferNano;
        throw new IllegalArgumentException((Throwable)paramObject);
      }
      if (localObject == Integer.class)
      {
        localObject = (Integer)paramObject;
        paramObject = new byte[CodedOutputByteBufferNano.computeInt32SizeNoTag(((Integer)localObject).intValue())];
        CodedOutputByteBufferNano.newInstance((byte[])paramObject).writeInt32NoTag(((Integer)localObject).intValue());
        paramInt = makeTag(paramInt, 0);
      }
      else if (localObject == Long.class)
      {
        localObject = (Long)paramObject;
        paramObject = new byte[CodedOutputByteBufferNano.computeInt64SizeNoTag(((Long)localObject).longValue())];
        CodedOutputByteBufferNano.newInstance((byte[])paramObject).writeInt64NoTag(((Long)localObject).longValue());
        paramInt = makeTag(paramInt, 0);
      }
      else if (localObject == Boolean.class)
      {
        localObject = (Boolean)paramObject;
        paramObject = new byte[CodedOutputByteBufferNano.computeBoolSizeNoTag(((Boolean)localObject).booleanValue())];
        CodedOutputByteBufferNano.newInstance((byte[])paramObject).writeBoolNoTag(((Boolean)localObject).booleanValue());
        paramInt = makeTag(paramInt, 0);
      }
      else if (localObject == Float.class)
      {
        localObject = (Float)paramObject;
        paramObject = new byte[CodedOutputByteBufferNano.computeFloatSizeNoTag(((Float)localObject).floatValue())];
        CodedOutputByteBufferNano.newInstance((byte[])paramObject).writeFloatNoTag(((Float)localObject).floatValue());
        paramInt = makeTag(paramInt, 5);
      }
      else if (localObject == Double.class)
      {
        localObject = (Double)paramObject;
        paramObject = new byte[CodedOutputByteBufferNano.computeDoubleSizeNoTag(((Double)localObject).doubleValue())];
        CodedOutputByteBufferNano.newInstance((byte[])paramObject).writeDoubleNoTag(((Double)localObject).doubleValue());
        paramInt = makeTag(paramInt, 1);
      }
      else if (localObject == byte[].class)
      {
        localObject = (byte[])paramObject;
        paramObject = new byte[CodedOutputByteBufferNano.computeByteArraySizeNoTag((byte[])localObject)];
        CodedOutputByteBufferNano.newInstance((byte[])paramObject).writeByteArrayNoTag((byte[])localObject);
        paramInt = makeTag(paramInt, 2);
      }
      else
      {
        if (!MessageNano.class.isAssignableFrom((Class)localObject)) {
          continue;
        }
        localObject = (MessageNano)paramObject;
        i = ((MessageNano)localObject).getSerializedSize();
        paramObject = new byte[i + CodedOutputByteBufferNano.computeRawVarint32Size(i)];
        localCodedOutputByteBufferNano = CodedOutputByteBufferNano.newInstance((byte[])paramObject);
        localCodedOutputByteBufferNano.writeRawVarint32(i);
        localCodedOutputByteBufferNano.writeRawBytes(MessageNano.toByteArray((MessageNano)localObject));
        paramInt = makeTag(paramInt, 2);
      }
    }
    throw new IllegalArgumentException("Unhandled extension field type: " + localObject);
  }
  
  public static void writeUnknownFields(List<UnknownFieldData> paramList, CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        UnknownFieldData localUnknownFieldData = (UnknownFieldData)paramList.next();
        paramCodedOutputByteBufferNano.writeTag(getTagFieldNumber(localUnknownFieldData.tag), getTagWireType(localUnknownFieldData.tag));
        paramCodedOutputByteBufferNano.writeRawBytes(localUnknownFieldData.bytes);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/protobuf/nano/WireFormatNano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */