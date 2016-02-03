package org.bson;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.bson.io.Bits;
import org.bson.types.ObjectId;

public class NewBSONDecoder
  implements BSONDecoder
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  private static final int MAX_STRING = 33554432;
  private BSONCallback _callback;
  private byte[] _data;
  private int _length;
  private int _pos = 0;
  
  private final void _binary(String paramString)
  {
    int i = Bits.readInt(this._data, this._pos);
    this._pos += 4;
    byte b = this._data[this._pos];
    this._pos += 1;
    byte[] arrayOfByte;
    switch (b)
    {
    case 1: 
    default: 
      arrayOfByte = new byte[i];
      System.arraycopy(this._data, this._pos, arrayOfByte, 0, i);
      this._pos += i;
      this._callback.gotBinary(paramString, b, arrayOfByte);
      return;
    case 0: 
      arrayOfByte = new byte[i];
      System.arraycopy(this._data, this._pos, arrayOfByte, 0, i);
      this._pos += i;
      this._callback.gotBinary(paramString, b, arrayOfByte);
      return;
    case 2: 
      int j = Bits.readInt(this._data, this._pos);
      this._pos += 4;
      if (j + 4 != i) {
        throw new IllegalArgumentException("bad data size subtype 2 len: " + j + " totalLen: " + i);
      }
      arrayOfByte = new byte[j];
      System.arraycopy(this._data, this._pos, arrayOfByte, 0, j);
      this._pos += j;
      this._callback.gotBinary(paramString, b, arrayOfByte);
      return;
    }
    if (i != 16) {
      throw new IllegalArgumentException("bad data size subtype 3 len: " + i + " != 16");
    }
    long l1 = Bits.readLong(this._data, this._pos);
    this._pos += 8;
    long l2 = Bits.readLong(this._data, this._pos);
    this._pos += 8;
    this._callback.gotUUID(paramString, l1, l2);
  }
  
  private final void _decode()
  {
    this._callback.objectStart();
    while (decodeElement()) {}
    this._callback.objectDone();
  }
  
  private final Object _readBasicObject()
  {
    this._pos += 4;
    BSONCallback localBSONCallback1 = this._callback;
    BSONCallback localBSONCallback2 = this._callback.createBSONCallback();
    this._callback = localBSONCallback2;
    localBSONCallback2.reset();
    localBSONCallback2.objectStart(false);
    while (decodeElement()) {}
    this._callback = localBSONCallback1;
    return localBSONCallback2.get();
  }
  
  private final boolean decodeElement()
  {
    boolean bool = false;
    int i = this._data[this._pos];
    this._pos += 1;
    if (i == 0) {
      return false;
    }
    String str = readCstr();
    Object localObject;
    int j;
    int k;
    switch (i)
    {
    default: 
      throw new UnsupportedOperationException("BSONDecoder doesn't understand type : " + i + " name: " + str);
    case 10: 
      this._callback.gotNull(str);
      return true;
    case 6: 
      this._callback.gotUndefined(str);
      return true;
    case 8: 
      localObject = this._callback;
      if (this._data[this._pos] > 0) {
        bool = true;
      }
      ((BSONCallback)localObject).gotBoolean(str, bool);
      this._pos += 1;
      return true;
    case 1: 
      this._callback.gotDouble(str, Double.longBitsToDouble(Bits.readLong(this._data, this._pos)));
      this._pos += 8;
      return true;
    case 16: 
      this._callback.gotInt(str, Bits.readInt(this._data, this._pos));
      this._pos += 4;
      return true;
    case 18: 
      this._callback.gotLong(str, Bits.readLong(this._data, this._pos));
      this._pos += 8;
      return true;
    case 14: 
      this._callback.gotSymbol(str, readUtf8Str());
      return true;
    case 2: 
      this._callback.gotString(str, readUtf8Str());
      return true;
    case 7: 
      i = Bits.readIntBE(this._data, this._pos);
      this._pos += 4;
      j = Bits.readIntBE(this._data, this._pos);
      this._pos += 4;
      k = Bits.readIntBE(this._data, this._pos);
      this._pos += 4;
      this._callback.gotObjectId(str, new ObjectId(i, j, k));
      return true;
    case 12: 
      this._pos += 4;
      localObject = readCstr();
      i = Bits.readInt(this._data, this._pos);
      this._pos += 4;
      j = Bits.readInt(this._data, this._pos);
      this._pos += 4;
      k = Bits.readInt(this._data, this._pos);
      this._pos += 4;
      this._callback.gotDBRef(str, (String)localObject, new ObjectId(i, j, k));
      return true;
    case 9: 
      this._callback.gotDate(str, Bits.readLong(this._data, this._pos));
      this._pos += 8;
      return true;
    case 11: 
      this._callback.gotRegex(str, readCstr(), readCstr());
      return true;
    case 5: 
      _binary(str);
      return true;
    case 13: 
      this._callback.gotCode(str, readUtf8Str());
      return true;
    case 15: 
      this._pos += 4;
      this._callback.gotCodeWScope(str, readUtf8Str(), _readBasicObject());
      return true;
    case 4: 
      this._pos += 4;
      this._callback.arrayStart(str);
      while (decodeElement()) {}
      this._callback.arrayDone();
      return true;
    case 3: 
      this._pos += 4;
      this._callback.objectStart(str);
      while (decodeElement()) {}
      this._callback.objectDone();
      return true;
    case 17: 
      i = Bits.readInt(this._data, this._pos);
      this._pos += 4;
      j = Bits.readInt(this._data, this._pos);
      this._pos += 4;
      this._callback.gotTimestamp(str, j, i);
      return true;
    case -1: 
      this._callback.gotMinKey(str);
      return true;
    }
    this._callback.gotMaxKey(str);
    return true;
  }
  
  private final String readCstr()
  {
    int i = 0;
    int j = this._pos;
    Object localObject;
    for (;;)
    {
      localObject = this._data;
      int k = this._pos;
      this._pos = (k + 1);
      if (localObject[k] == 0) {
        break;
      }
      i += 1;
    }
    try
    {
      localObject = new String(this._data, j, i, "UTF-8");
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(this._data, j, i);
  }
  
  private final String readUtf8Str()
  {
    int i = Bits.readInt(this._data, this._pos);
    this._pos += 4;
    if ((i <= 0) || (i > 33554432)) {
      throw new BSONException("String invalid - corruption");
    }
    try
    {
      String str = new String(this._data, this._pos, i - 1, "UTF-8");
      this._pos += i;
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new BSONException("What is in the db", localUnsupportedEncodingException);
    }
  }
  
  public int decode(InputStream paramInputStream, BSONCallback paramBSONCallback)
    throws IOException
  {
    this._length = Bits.readInt(paramInputStream);
    if ((this._data == null) || (this._data.length < this._length)) {
      this._data = new byte[this._length];
    }
    new DataInputStream(paramInputStream).readFully(this._data, 4, this._length - 4);
    return decode(this._data, paramBSONCallback);
  }
  
  public int decode(byte[] paramArrayOfByte, BSONCallback paramBSONCallback)
  {
    this._data = paramArrayOfByte;
    this._pos = 4;
    this._callback = paramBSONCallback;
    _decode();
    return this._length;
  }
  
  public BSONObject readObject(InputStream paramInputStream)
    throws IOException
  {
    this._length = Bits.readInt(paramInputStream);
    if ((this._data == null) || (this._data.length < this._length)) {
      this._data = new byte[this._length];
    }
    new DataInputStream(paramInputStream).readFully(this._data, 4, this._length - 4);
    return readObject(this._data);
  }
  
  public BSONObject readObject(byte[] paramArrayOfByte)
  {
    this._length = paramArrayOfByte.length;
    BasicBSONCallback localBasicBSONCallback = new BasicBSONCallback();
    decode(paramArrayOfByte, localBasicBSONCallback);
    return (BSONObject)localBasicBSONCallback.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/NewBSONDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */