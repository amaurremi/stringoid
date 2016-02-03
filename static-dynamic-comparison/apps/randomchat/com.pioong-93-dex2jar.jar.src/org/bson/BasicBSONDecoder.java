package org.bson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.bson.io.Bits;
import org.bson.io.PoolOutputBuffer;
import org.bson.types.ObjectId;

public class BasicBSONDecoder
  implements BSONDecoder
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  private static final int MAX_STRING = 33554432;
  static final String[] ONE_BYTE_STRINGS = new String[''];
  protected BSONCallback _callback;
  protected BSONInput _in;
  private byte[] _inputBuffer = new byte['Ѐ'];
  protected int _len;
  protected int _pos;
  private byte[] _random = new byte['Ѐ'];
  private PoolOutputBuffer _stringBuffer = new PoolOutputBuffer();
  
  static
  {
    _fillRange((byte)48, (byte)57);
    _fillRange((byte)97, (byte)122);
    _fillRange((byte)65, (byte)90);
  }
  
  private int _decode(BSONInput paramBSONInput, BSONCallback paramBSONCallback)
    throws IOException
  {
    if ((this._in != null) || (this._callback != null)) {
      throw new IllegalStateException("not ready");
    }
    this._in = paramBSONInput;
    this._callback = paramBSONCallback;
    if (paramBSONInput.numRead() != 0) {
      throw new IllegalArgumentException("i'm confused");
    }
    int i;
    try
    {
      i = this._in.readInt();
      this._in.setMax(i);
      this._callback.objectStart();
      while (decodeElement()) {}
      this._callback.objectDone();
      if (this._in.numRead() != i) {
        throw new IllegalArgumentException("bad data.  lengths don't match read:" + this._in.numRead() + " != len:" + i);
      }
    }
    finally
    {
      this._in = null;
      this._callback = null;
    }
    this._in = null;
    this._callback = null;
    return i;
  }
  
  static void _fillRange(byte paramByte1, byte paramByte2)
  {
    while (paramByte1 < paramByte2)
    {
      String str = "" + (char)paramByte1;
      ONE_BYTE_STRINGS[paramByte1] = str;
      paramByte1 = (byte)(paramByte1 + 1);
    }
  }
  
  private static final boolean _isAscii(byte paramByte)
  {
    return (paramByte >= 0) && (paramByte <= Byte.MAX_VALUE);
  }
  
  protected void _binary(String paramString)
    throws IOException
  {
    int i = this._in.readInt();
    byte b = this._in.read();
    byte[] arrayOfByte;
    switch (b)
    {
    case 1: 
    default: 
      arrayOfByte = new byte[i];
      this._in.fill(arrayOfByte);
      this._callback.gotBinary(paramString, b, arrayOfByte);
      return;
    case 0: 
      arrayOfByte = new byte[i];
      this._in.fill(arrayOfByte);
      this._callback.gotBinary(paramString, b, arrayOfByte);
      return;
    case 2: 
      int j = this._in.readInt();
      if (j + 4 != i) {
        throw new IllegalArgumentException("bad data size subtype 2 len: " + j + " totalLen: " + i);
      }
      arrayOfByte = new byte[j];
      this._in.fill(arrayOfByte);
      this._callback.gotBinary(paramString, b, arrayOfByte);
      return;
    }
    if (i != 16) {
      throw new IllegalArgumentException("bad data size subtype 3 len: " + i + " != 16");
    }
    long l1 = this._in.readLong();
    long l2 = this._in.readLong();
    this._callback.gotUUID(paramString, l1, l2);
  }
  
  Object _readBasicObject()
    throws IOException
  {
    this._in.readInt();
    BSONCallback localBSONCallback1 = this._callback;
    BSONCallback localBSONCallback2 = this._callback.createBSONCallback();
    this._callback = localBSONCallback2;
    localBSONCallback2.reset();
    localBSONCallback2.objectStart(false);
    while (decodeElement()) {}
    this._callback = localBSONCallback1;
    return localBSONCallback2.get();
  }
  
  public int decode(InputStream paramInputStream, BSONCallback paramBSONCallback)
    throws IOException
  {
    return _decode(new BSONInput(paramInputStream), paramBSONCallback);
  }
  
  int decode(boolean paramBoolean)
    throws IOException
  {
    int i = this._in.numRead();
    int j = this._in.readInt();
    if (paramBoolean) {
      this._in.setMax(j);
    }
    this._callback.objectStart();
    while (decodeElement()) {}
    this._callback.objectDone();
    if (this._in.numRead() - i != j) {}
    return j;
  }
  
  public int decode(byte[] paramArrayOfByte, BSONCallback paramBSONCallback)
  {
    try
    {
      int i = _decode(new BSONInput(new ByteArrayInputStream(paramArrayOfByte)), paramBSONCallback);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new BSONException("should be impossible", paramArrayOfByte);
    }
  }
  
  boolean decodeElement()
    throws IOException
  {
    boolean bool = false;
    int i = this._in.read();
    if (i == 0) {
      return false;
    }
    String str = this._in.readCStr();
    switch (i)
    {
    default: 
      throw new UnsupportedOperationException("BSONDecoder doesn't understand type : " + i + " name: " + str);
    case 10: 
      this._callback.gotNull(str);
    }
    for (;;)
    {
      return true;
      this._callback.gotUndefined(str);
      continue;
      Object localObject = this._callback;
      if (this._in.read() > 0) {
        bool = true;
      }
      ((BSONCallback)localObject).gotBoolean(str, bool);
      continue;
      this._callback.gotDouble(str, this._in.readDouble());
      continue;
      this._callback.gotInt(str, this._in.readInt());
      continue;
      this._callback.gotLong(str, this._in.readLong());
      continue;
      this._callback.gotSymbol(str, this._in.readUTF8String());
      continue;
      this._callback.gotString(str, this._in.readUTF8String());
      continue;
      this._callback.gotObjectId(str, new ObjectId(this._in.readIntBE(), this._in.readIntBE(), this._in.readIntBE()));
      continue;
      this._in.readInt();
      localObject = this._in.readCStr();
      ObjectId localObjectId = new ObjectId(this._in.readInt(), this._in.readInt(), this._in.readInt());
      this._callback.gotDBRef(str, (String)localObject, localObjectId);
      continue;
      this._callback.gotDate(str, this._in.readLong());
      continue;
      this._callback.gotRegex(str, this._in.readCStr(), this._in.readCStr());
      continue;
      _binary(str);
      continue;
      this._callback.gotCode(str, this._in.readUTF8String());
      continue;
      this._in.readInt();
      this._callback.gotCodeWScope(str, this._in.readUTF8String(), _readBasicObject());
      continue;
      this._in.readInt();
      this._callback.arrayStart(str);
      while (decodeElement()) {}
      this._callback.arrayDone();
      continue;
      this._in.readInt();
      this._callback.objectStart(str);
      while (decodeElement()) {}
      this._callback.objectDone();
      continue;
      i = this._in.readInt();
      int j = this._in.readInt();
      this._callback.gotTimestamp(str, j, i);
      continue;
      this._callback.gotMinKey(str);
      continue;
      this._callback.gotMaxKey(str);
    }
  }
  
  public BSONObject readObject(InputStream paramInputStream)
    throws IOException
  {
    BasicBSONCallback localBasicBSONCallback = new BasicBSONCallback();
    decode(paramInputStream, localBasicBSONCallback);
    return (BSONObject)localBasicBSONCallback.get();
  }
  
  public BSONObject readObject(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = readObject(new ByteArrayInputStream(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new BSONException("should be impossible", paramArrayOfByte);
    }
  }
  
  protected class BSONInput
  {
    int _max = 4;
    final InputStream _raw;
    int _read;
    
    public BSONInput(InputStream paramInputStream)
    {
      this._raw = paramInputStream;
      this._read = 0;
      BasicBSONDecoder.this._pos = 0;
      BasicBSONDecoder.this._len = 0;
    }
    
    protected boolean _isAscii(byte paramByte)
    {
      return (paramByte >= 0) && (paramByte <= Byte.MAX_VALUE);
    }
    
    protected int _need(int paramInt)
      throws IOException
    {
      if (BasicBSONDecoder.this._len - BasicBSONDecoder.this._pos >= paramInt)
      {
        i = BasicBSONDecoder.this._pos;
        localBasicBSONDecoder = BasicBSONDecoder.this;
        localBasicBSONDecoder._pos += paramInt;
        this._read += paramInt;
        return i;
      }
      if (paramInt >= BasicBSONDecoder.this._inputBuffer.length) {
        throw new IllegalArgumentException("you can't need that much");
      }
      int i = BasicBSONDecoder.this._len - BasicBSONDecoder.this._pos;
      if (BasicBSONDecoder.this._pos > 0)
      {
        System.arraycopy(BasicBSONDecoder.this._inputBuffer, BasicBSONDecoder.this._pos, BasicBSONDecoder.this._inputBuffer, 0, i);
        BasicBSONDecoder.this._pos = 0;
        BasicBSONDecoder.this._len = i;
      }
      i = Math.min(this._max - this._read - i, BasicBSONDecoder.this._inputBuffer.length - BasicBSONDecoder.this._len);
      while (i > 0)
      {
        int j = this._raw.read(BasicBSONDecoder.this._inputBuffer, BasicBSONDecoder.this._len, i);
        if (j <= 0) {
          throw new IOException("unexpected EOF");
        }
        i -= j;
        localBasicBSONDecoder = BasicBSONDecoder.this;
        localBasicBSONDecoder._len += j;
      }
      i = BasicBSONDecoder.this._pos;
      BasicBSONDecoder localBasicBSONDecoder = BasicBSONDecoder.this;
      localBasicBSONDecoder._pos += paramInt;
      this._read += paramInt;
      return i;
    }
    
    public void fill(byte[] paramArrayOfByte)
      throws IOException
    {
      fill(paramArrayOfByte, paramArrayOfByte.length);
    }
    
    public void fill(byte[] paramArrayOfByte, int paramInt)
      throws IOException
    {
      int i = Math.min(paramInt, BasicBSONDecoder.this._len - BasicBSONDecoder.this._pos);
      System.arraycopy(BasicBSONDecoder.this._inputBuffer, BasicBSONDecoder.this._pos, paramArrayOfByte, 0, i);
      BasicBSONDecoder localBasicBSONDecoder = BasicBSONDecoder.this;
      localBasicBSONDecoder._pos += i;
      this._read += i;
      paramInt -= i;
      while (paramInt > 0)
      {
        int j = this._raw.read(paramArrayOfByte, i, paramInt);
        if (j <= 0) {
          throw new IOException("unexpected EOF");
        }
        this._read += j;
        i += j;
        paramInt -= j;
      }
    }
    
    public int getMax()
    {
      return this._max;
    }
    
    public int getPos()
    {
      return BasicBSONDecoder.this._pos;
    }
    
    public int numRead()
    {
      return this._read;
    }
    
    public byte read()
      throws IOException
    {
      if (BasicBSONDecoder.this._pos < BasicBSONDecoder.this._len)
      {
        this._read += 1;
        byte[] arrayOfByte = BasicBSONDecoder.this._inputBuffer;
        BasicBSONDecoder localBasicBSONDecoder = BasicBSONDecoder.this;
        int i = localBasicBSONDecoder._pos;
        localBasicBSONDecoder._pos = (i + 1);
        return arrayOfByte[i];
      }
      return BasicBSONDecoder.this._inputBuffer[_need(1)];
    }
    
    public String readCStr()
      throws IOException
    {
      BasicBSONDecoder.this._random[0] = read();
      Object localObject;
      if (BasicBSONDecoder.this._random[0] == 0) {
        localObject = "";
      }
      String str;
      do
      {
        return (String)localObject;
        BasicBSONDecoder.this._random[1] = read();
        if (BasicBSONDecoder.this._random[1] != 0) {
          break;
        }
        str = BasicBSONDecoder.ONE_BYTE_STRINGS[BasicBSONDecoder.this._random[0]];
        localObject = str;
      } while (str != null);
      return new String(BasicBSONDecoder.this._random, 0, 1, "UTF-8");
      BasicBSONDecoder.this._stringBuffer.reset();
      BasicBSONDecoder.this._stringBuffer.write(BasicBSONDecoder.this._random, 0, 2);
      if ((_isAscii(BasicBSONDecoder.this._random[0])) && (_isAscii(BasicBSONDecoder.this._random[1])))
      {
        i = 1;
        byte b = read();
        if (b == 0) {
          break label207;
        }
        BasicBSONDecoder.this._stringBuffer.write(b);
        if ((i == 0) || (!_isAscii(b))) {
          break label202;
        }
      }
      label202:
      for (int i = 1;; i = 0)
      {
        break;
        i = 0;
        break;
      }
      label207:
      if (i != 0) {
        localObject = BasicBSONDecoder.this._stringBuffer.asAscii();
      }
      for (;;)
      {
        BasicBSONDecoder.this._stringBuffer.reset();
        return (String)localObject;
        try
        {
          localObject = BasicBSONDecoder.this._stringBuffer.asString("UTF-8");
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          throw new BSONException("impossible", localUnsupportedOperationException);
        }
      }
    }
    
    public double readDouble()
      throws IOException
    {
      return Double.longBitsToDouble(readLong());
    }
    
    public int readInt()
      throws IOException
    {
      return Bits.readInt(BasicBSONDecoder.this._inputBuffer, _need(4));
    }
    
    public int readIntBE()
      throws IOException
    {
      return Bits.readIntBE(BasicBSONDecoder.this._inputBuffer, _need(4));
    }
    
    public long readLong()
      throws IOException
    {
      return Bits.readLong(BasicBSONDecoder.this._inputBuffer, _need(8));
    }
    
    public String readUTF8String()
      throws IOException
    {
      int i = readInt();
      if ((i <= 0) || (i > 33554432)) {
        throw new BSONException("bad string size: " + i);
      }
      if (i < BasicBSONDecoder.this._inputBuffer.length / 2)
      {
        if (i == 1)
        {
          read();
          return "";
        }
        return new String(BasicBSONDecoder.this._inputBuffer, _need(i), i - 1, "UTF-8");
      }
      if (i < BasicBSONDecoder.this._random.length) {}
      byte[] arrayOfByte;
      for (Object localObject = BasicBSONDecoder.this._random;; arrayOfByte = new byte[i])
      {
        fill((byte[])localObject, i);
        try
        {
          localObject = new String((byte[])localObject, 0, i - 1, "UTF-8");
          return (String)localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          throw new BSONException("impossible", localUnsupportedEncodingException);
        }
      }
    }
    
    public void setMax(int paramInt)
    {
      this._max = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BasicBSONDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */