package com.google.tagmanager.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class CodedInputStream
{
  private static final int BUFFER_SIZE = 4096;
  private static final int DEFAULT_RECURSION_LIMIT = 64;
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  private final byte[] buffer;
  private final boolean bufferIsImmutable;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int currentLimit = Integer.MAX_VALUE;
  private boolean enableAliasing = false;
  private final InputStream input;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 64;
  private RefillCallback refillCallback = null;
  private int sizeLimit = 67108864;
  private int totalBytesRetired;
  
  private CodedInputStream(LiteralByteString paramLiteralByteString)
  {
    this.buffer = paramLiteralByteString.bytes;
    this.bufferPos = paramLiteralByteString.getOffsetIntoBytes();
    this.bufferSize = (paramLiteralByteString.getOffsetIntoBytes() + paramLiteralByteString.size());
    this.totalBytesRetired = (-this.bufferPos);
    this.input = null;
    this.bufferIsImmutable = true;
  }
  
  private CodedInputStream(InputStream paramInputStream)
  {
    this.buffer = new byte['က'];
    this.bufferSize = 0;
    this.bufferPos = 0;
    this.totalBytesRetired = 0;
    this.input = paramInputStream;
    this.bufferIsImmutable = false;
  }
  
  private CodedInputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt1 + paramInt2);
    this.bufferPos = paramInt1;
    this.totalBytesRetired = (-paramInt1);
    this.input = null;
    this.bufferIsImmutable = false;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  static CodedInputStream newInstance(LiteralByteString paramLiteralByteString)
  {
    CodedInputStream localCodedInputStream = new CodedInputStream(paramLiteralByteString);
    try
    {
      localCodedInputStream.pushLimit(paramLiteralByteString.size());
      return localCodedInputStream;
    }
    catch (InvalidProtocolBufferException paramLiteralByteString)
    {
      throw new IllegalArgumentException(paramLiteralByteString);
    }
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream)
  {
    return new CodedInputStream(paramInputStream);
  }
  
  public static CodedInputStream newInstance(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray()) {
      return newInstance(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
    }
    paramByteBuffer = paramByteBuffer.duplicate();
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    return newInstance(arrayOfByte);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new CodedInputStream(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      paramArrayOfByte.pushLimit(paramInt2);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static int readRawVarint32(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    int j;
    if ((paramInt & 0x80) == 0)
    {
      j = paramInt;
      return j;
    }
    int i = paramInt & 0x7F;
    paramInt = 7;
    for (;;)
    {
      j = paramInt;
      if (paramInt >= 32) {
        break label78;
      }
      int k = paramInputStream.read();
      if (k == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      i |= (k & 0x7F) << paramInt;
      j = i;
      if ((k & 0x80) == 0) {
        break;
      }
      paramInt += 7;
    }
    label78:
    do
    {
      j += 7;
      if (j >= 64) {
        break;
      }
      paramInt = paramInputStream.read();
      if (paramInt == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
    } while ((paramInt & 0x80) != 0);
    return i;
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  static int readRawVarint32(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    return readRawVarint32(i, paramInputStream);
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    this.bufferSize += this.bufferSizeAfterLimit;
    int i = this.totalBytesRetired + this.bufferSize;
    if (i > this.currentLimit)
    {
      this.bufferSizeAfterLimit = (i - this.currentLimit);
      this.bufferSize -= this.bufferSizeAfterLimit;
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  private boolean refillBuffer(boolean paramBoolean)
    throws IOException
  {
    if (this.bufferPos < this.bufferSize) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.totalBytesRetired + this.bufferSize == this.currentLimit)
    {
      if (paramBoolean) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      return false;
    }
    if (this.refillCallback != null) {
      this.refillCallback.onRefill();
    }
    this.totalBytesRetired += this.bufferSize;
    this.bufferPos = 0;
    if (this.input == null) {}
    for (int i = -1;; i = this.input.read(this.buffer))
    {
      this.bufferSize = i;
      if ((this.bufferSize != 0) && (this.bufferSize >= -1)) {
        break;
      }
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
    }
    if (this.bufferSize == -1)
    {
      this.bufferSize = 0;
      if (paramBoolean) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      return false;
    }
    recomputeBufferSizeAfterLimit();
    i = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
    if ((i > this.sizeLimit) || (i < 0)) {
      throw InvalidProtocolBufferException.sizeLimitExceeded();
    }
    return true;
  }
  
  private void skipRawVarint()
    throws IOException
  {
    int i = 0;
    while (i < 10)
    {
      if (readRawByte() >= 0) {
        return;
      }
      i += 1;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public void checkLastTagWas(int paramInt)
    throws InvalidProtocolBufferException
  {
    if (this.lastTag != paramInt) {
      throw InvalidProtocolBufferException.invalidEndTag();
    }
  }
  
  public void enableAliasing(boolean paramBoolean)
  {
    this.enableAliasing = paramBoolean;
  }
  
  public int getBytesUntilLimit()
  {
    if (this.currentLimit == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.totalBytesRetired;
    int j = this.bufferPos;
    return this.currentLimit - (i + j);
  }
  
  public int getLastTag()
  {
    return this.lastTag;
  }
  
  public int getTotalBytesRead()
  {
    return this.totalBytesRetired + this.bufferPos;
  }
  
  public boolean isAtEnd()
    throws IOException
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bufferPos == this.bufferSize)
    {
      bool1 = bool2;
      if (!refillBuffer(false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void mergeToMessage(MutableMessageLite paramMutableMessageLite)
    throws IOException
  {
    Object localObject = new SkippedDataSink(null);
    this.refillCallback = ((RefillCallback)localObject);
    skipMessage();
    this.refillCallback = null;
    localObject = ((SkippedDataSink)localObject).getSkippedData();
    if (!paramMutableMessageLite.mergeFrom(((ByteBuffer)localObject).array(), ((ByteBuffer)localObject).position(), ((ByteBuffer)localObject).remaining())) {
      throw InvalidProtocolBufferException.parseFailure();
    }
  }
  
  public void popLimit(int paramInt)
  {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public int pushLimit(int paramInt)
    throws InvalidProtocolBufferException
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    paramInt += this.totalBytesRetired + this.bufferPos;
    int i = this.currentLimit;
    if (paramInt > i) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
    return i;
  }
  
  public boolean readBool()
    throws IOException
  {
    return readRawVarint32() != 0;
  }
  
  public byte[] readByteArray()
    throws IOException
  {
    int i = readRawVarint32();
    if (i == 0) {
      return Internal.EMPTY_BYTE_ARRAY;
    }
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + i);
      this.bufferPos += i;
      return arrayOfByte;
    }
    return readRawBytes(i);
  }
  
  public ByteBuffer readByteBuffer()
    throws IOException
  {
    int i = readRawVarint32();
    if (i == 0) {
      return Internal.EMPTY_BYTE_BUFFER;
    }
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      if ((this.input == null) && (!this.bufferIsImmutable) && (this.enableAliasing)) {}
      for (ByteBuffer localByteBuffer = ByteBuffer.wrap(this.buffer, this.bufferPos, i).slice();; localByteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + i)))
      {
        this.bufferPos += i;
        return localByteBuffer;
      }
    }
    return ByteBuffer.wrap(readRawBytes(i));
  }
  
  public ByteString readBytes()
    throws IOException
  {
    int i = readRawVarint32();
    if (i == 0) {
      return ByteString.EMPTY;
    }
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      if ((this.bufferIsImmutable) && (this.enableAliasing)) {}
      for (Object localObject = new BoundedByteString(this.buffer, this.bufferPos, i);; localObject = ByteString.copyFrom(this.buffer, this.bufferPos, i))
      {
        this.bufferPos += i;
        return (ByteString)localObject;
      }
    }
    return new LiteralByteString(readRawBytes(i));
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public int readEnum()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public int readFixed32()
    throws IOException
  {
    return readRawLittleEndian32();
  }
  
  public long readFixed64()
    throws IOException
  {
    return readRawLittleEndian64();
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public <T extends MessageLite> T readGroup(int paramInt, Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    this.recursionDepth += 1;
    paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(WireFormat.makeTag(paramInt, 4));
    this.recursionDepth -= 1;
    return paramParser;
  }
  
  public void readGroup(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    this.recursionDepth += 1;
    paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(WireFormat.makeTag(paramInt, 4));
    this.recursionDepth -= 1;
  }
  
  public void readGroup(int paramInt, MutableMessageLite paramMutableMessageLite, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    this.recursionDepth += 1;
    paramMutableMessageLite.mergeFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(WireFormat.makeTag(paramInt, 4));
    this.recursionDepth -= 1;
  }
  
  public int readInt32()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public long readInt64()
    throws IOException
  {
    return readRawVarint64();
  }
  
  public <T extends MessageLite> T readMessage(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    int i = readRawVarint32();
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
    return paramParser;
  }
  
  public void readMessage(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    int i = readRawVarint32();
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
  }
  
  public void readMessage(MutableMessageLite paramMutableMessageLite, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    int i = readRawVarint32();
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramMutableMessageLite.mergeFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
  }
  
  public byte readRawByte()
    throws IOException
  {
    if (this.bufferPos == this.bufferSize) {
      refillBuffer(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] readRawBytes(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.bufferPos, localObject, 0, paramInt);
      this.bufferPos += paramInt;
      return (byte[])localObject;
    }
    if (paramInt < 4096)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.bufferPos;
      System.arraycopy(this.buffer, this.bufferPos, localObject, 0, i);
      this.bufferPos = this.bufferSize;
      refillBuffer(true);
      while (paramInt - i > this.bufferSize)
      {
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.bufferPos = this.bufferSize;
        refillBuffer(true);
      }
      System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
      this.bufferPos = (paramInt - i);
      return (byte[])localObject;
    }
    int m = this.bufferPos;
    int n = this.bufferSize;
    this.totalBytesRetired += this.bufferSize;
    this.bufferPos = 0;
    this.bufferSize = 0;
    int i = paramInt - (n - m);
    Object localObject = new ArrayList();
    while (i > 0)
    {
      arrayOfByte = new byte[Math.min(i, 4096)];
      int j = 0;
      while (j < arrayOfByte.length)
      {
        if (this.input == null) {}
        for (int k = -1; k == -1; k = this.input.read(arrayOfByte, j, arrayOfByte.length - j)) {
          throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.totalBytesRetired += k;
        j += k;
      }
      i -= arrayOfByte.length;
      ((List)localObject).add(arrayOfByte);
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = n - m;
    System.arraycopy(this.buffer, m, arrayOfByte, 0, paramInt);
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      localObject = arrayOfByte;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (byte[])localIterator.next();
      System.arraycopy(localObject, 0, arrayOfByte, paramInt, localObject.length);
      paramInt += localObject.length;
    }
  }
  
  public int readRawLittleEndian32()
    throws IOException
  {
    return readRawByte() & 0xFF | (readRawByte() & 0xFF) << 8 | (readRawByte() & 0xFF) << 16 | (readRawByte() & 0xFF) << 24;
  }
  
  public long readRawLittleEndian64()
    throws IOException
  {
    int i = readRawByte();
    int j = readRawByte();
    int k = readRawByte();
    int m = readRawByte();
    int n = readRawByte();
    int i1 = readRawByte();
    int i2 = readRawByte();
    int i3 = readRawByte();
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int readRawVarint32()
    throws IOException
  {
    int i = readRawByte();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = readRawByte();
      if (k >= 0) {
        return i | k << 21;
      }
      j = readRawByte();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (readRawByte() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public long readRawVarint64()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public int readSFixed32()
    throws IOException
  {
    return readRawLittleEndian32();
  }
  
  public long readSFixed64()
    throws IOException
  {
    return readRawLittleEndian64();
  }
  
  public int readSInt32()
    throws IOException
  {
    return decodeZigZag32(readRawVarint32());
  }
  
  public long readSInt64()
    throws IOException
  {
    return decodeZigZag64(readRawVarint64());
  }
  
  public String readString()
    throws IOException
  {
    int i = readRawVarint32();
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      String str = new String(this.buffer, this.bufferPos, i, "UTF-8");
      this.bufferPos += i;
      return str;
    }
    return new String(readRawBytes(i), "UTF-8");
  }
  
  public String readStringRequireUtf8()
    throws IOException
  {
    int i = readRawVarint32();
    Object localObject;
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      localObject = ByteString.copyFrom(this.buffer, this.bufferPos, i);
      this.bufferPos += i;
    }
    while (!((ByteString)localObject).isValidUtf8())
    {
      throw InvalidProtocolBufferException.invalidUtf8();
      localObject = new LiteralByteString(readRawBytes(i));
    }
    return ((ByteString)localObject).toStringUtf8();
  }
  
  public int readTag()
    throws IOException
  {
    if (isAtEnd())
    {
      this.lastTag = 0;
      return 0;
    }
    this.lastTag = readRawVarint32();
    if (WireFormat.getTagFieldNumber(this.lastTag) == 0) {
      throw InvalidProtocolBufferException.invalidTag();
    }
    return this.lastTag;
  }
  
  public int readUInt32()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public long readUInt64()
    throws IOException
  {
    return readRawVarint64();
  }
  
  @Deprecated
  public void readUnknownGroup(int paramInt, MessageLite.Builder paramBuilder)
    throws IOException
  {
    readGroup(paramInt, paramBuilder, null);
  }
  
  public void resetSizeCounter()
  {
    this.totalBytesRetired = (-this.bufferPos);
  }
  
  public int setRecursionLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Recursion limit cannot be negative: " + paramInt);
    }
    int i = this.recursionLimit;
    this.recursionLimit = paramInt;
    return i;
  }
  
  public int setSizeLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Size limit cannot be negative: " + paramInt);
    }
    int i = this.sizeLimit;
    this.sizeLimit = paramInt;
    return i;
  }
  
  public boolean skipField(int paramInt)
    throws IOException
  {
    switch (WireFormat.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferException.invalidWireType();
    case 0: 
      skipRawVarint();
      return true;
    case 1: 
      skipRawBytes(8);
      return true;
    case 2: 
      skipRawBytes(readRawVarint32());
      return true;
    case 3: 
      skipMessage();
      checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    skipRawBytes(4);
    return true;
  }
  
  public boolean skipField(int paramInt, CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    long l;
    switch (WireFormat.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferException.invalidWireType();
    case 0: 
      l = readInt64();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeUInt64NoTag(l);
      return true;
    case 1: 
      l = readRawLittleEndian64();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeFixed64NoTag(l);
      return true;
    case 2: 
      ByteString localByteString = readBytes();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeBytesNoTag(localByteString);
      return true;
    case 3: 
      paramCodedOutputStream.writeRawVarint32(paramInt);
      skipMessage(paramCodedOutputStream);
      paramInt = WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4);
      checkLastTagWas(paramInt);
      paramCodedOutputStream.writeRawVarint32(paramInt);
      return true;
    case 4: 
      return false;
    }
    int i = readRawLittleEndian32();
    paramCodedOutputStream.writeRawVarint32(paramInt);
    paramCodedOutputStream.writeFixed32NoTag(i);
    return true;
  }
  
  public void skipMessage()
    throws IOException
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i)));
  }
  
  public void skipMessage(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i, paramCodedOutputStream)));
  }
  
  public void skipRawBytes(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos)
    {
      this.bufferPos += paramInt;
      return;
    }
    int i = this.bufferSize - this.bufferPos;
    this.bufferPos = this.bufferSize;
    refillBuffer(true);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.bufferPos = this.bufferSize;
      refillBuffer(true);
    }
    this.bufferPos = (paramInt - i);
  }
  
  private static abstract interface RefillCallback
  {
    public abstract void onRefill();
  }
  
  private class SkippedDataSink
    implements CodedInputStream.RefillCallback
  {
    private ByteArrayOutputStream byteArrayStream;
    private int lastPos = CodedInputStream.this.bufferPos;
    
    private SkippedDataSink() {}
    
    ByteBuffer getSkippedData()
    {
      if (this.byteArrayStream == null) {
        return ByteBuffer.wrap(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
      }
      this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos);
      return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }
    
    public void onRefill()
    {
      if (this.byteArrayStream == null) {
        this.byteArrayStream = new ByteArrayOutputStream();
      }
      this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
      this.lastPos = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/CodedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */