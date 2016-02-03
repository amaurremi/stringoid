package com.mongodb;

import com.mongodb.util.MyAsserts;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bson.BSONObject;
import org.bson.types.ObjectId;

public class RawDBObject
  implements DBObject
{
  private static final byte[] _cStrBuf = new byte['Ѐ'];
  final ByteBuffer _buf;
  final int _end;
  final int _offset;
  
  RawDBObject(ByteBuffer paramByteBuffer)
  {
    this(paramByteBuffer, 0);
    MyAsserts.assertEquals(this._end, this._buf.limit());
  }
  
  RawDBObject(ByteBuffer paramByteBuffer, int paramInt)
  {
    this._buf = paramByteBuffer;
    this._offset = paramInt;
    this._end = this._buf.getInt(this._offset);
  }
  
  int _cStrLength(int paramInt)
  {
    int i = paramInt;
    while (this._buf.get(i) != 0) {
      i += 1;
    }
    return i - paramInt + 1;
  }
  
  String _readCStr(int paramInt)
  {
    return _readCStr(paramInt, null);
  }
  
  String _readCStr(int paramInt, int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = _cStrBuf;
    int i = 0;
    int j;
    do
    {
      try
      {
        if (this._buf.get(i + paramInt) == 0) {
          break;
        }
        _cStrBuf[i] = this._buf.get(i + paramInt);
        j = i + 1;
        if (j >= _cStrBuf.length) {
          throw new IllegalArgumentException("c string too big for RawDBObject.  so far[" + new String(_cStrBuf) + "]");
        }
      }
      finally {}
      i = j;
    } while (j + paramInt < this._buf.limit());
    paramArrayOfInt = new StringBuilder();
    i = 0;
    for (;;)
    {
      int k;
      if (i < 10)
      {
        k = paramInt + i;
        if (k < this._buf.limit()) {}
      }
      else
      {
        throw new IllegalArgumentException("can't find end of cstring.  start:" + paramInt + " pos: " + j + " [" + paramArrayOfInt + "]");
      }
      paramArrayOfInt.append((char)this._buf.get(k));
      i += 1;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramArrayOfInt[0] = (paramInt + i);
    }
    paramArrayOfInt = new String(_cStrBuf, 0, i);
    return paramArrayOfInt;
  }
  
  String _readJavaString(int paramInt)
  {
    byte[] arrayOfByte = new byte[this._buf.getInt(paramInt) - 1];
    int i = this._buf.position();
    this._buf.position(paramInt + 4);
    this._buf.get(arrayOfByte, 0, arrayOfByte.length);
    this._buf.position(i);
    try
    {
      String str = new String(arrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(arrayOfByte);
  }
  
  public boolean containsField(String paramString)
  {
    return findElement(paramString) != null;
  }
  
  @Deprecated
  public boolean containsKey(String paramString)
  {
    return containsField(paramString);
  }
  
  Element findElement(String paramString)
  {
    ElementIter localElementIter = new ElementIter();
    while (localElementIter.hasNext())
    {
      Element localElement = localElementIter.next();
      if (localElement.fieldName().equals(paramString)) {
        return localElement;
      }
    }
    return null;
  }
  
  public Object get(String paramString)
  {
    paramString = findElement(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getObject();
  }
  
  public boolean isPartialObject()
  {
    return false;
  }
  
  public Set<String> keySet()
  {
    HashSet localHashSet = new HashSet();
    ElementIter localElementIter = new ElementIter();
    for (;;)
    {
      Element localElement;
      if (localElementIter.hasNext())
      {
        localElement = localElementIter.next();
        if (!localElement.eoo()) {}
      }
      else
      {
        return localHashSet;
      }
      localHashSet.add(localElement.fieldName());
    }
  }
  
  public void markAsPartialObject()
  {
    throw new RuntimeException("RawDBObject can't be a partial object");
  }
  
  public Object put(String paramString, Object paramObject)
  {
    throw new RuntimeException("read only");
  }
  
  public void putAll(Map paramMap)
  {
    throw new RuntimeException("read only");
  }
  
  public void putAll(BSONObject paramBSONObject)
  {
    throw new RuntimeException("read only");
  }
  
  public Object removeField(String paramString)
  {
    throw new RuntimeException("read only");
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localHashMap.put(localObject, get(String.valueOf(localObject)));
    }
    return localHashMap;
  }
  
  public String toString()
  {
    return "Object";
  }
  
  class Element
  {
    Object _cached;
    final int _dataStart;
    final String _name;
    final int _size;
    final int _start;
    final byte _type;
    
    Element(int paramInt)
    {
      this._start = paramInt;
      this._type = RawDBObject.this._buf.get(this._start);
      int[] arrayOfInt = new int[1];
      if (eoo()) {}
      int i;
      for (String str = "";; str = RawDBObject.this._readCStr(this._start + 1, arrayOfInt))
      {
        this._name = str;
        i = arrayOfInt[0] - this._start + 1;
        this._dataStart = (this._start + i);
        paramInt = i;
        switch (this._type)
        {
        default: 
          throw new RuntimeException("RawDBObject can't size type " + this._type);
        }
      }
      paramInt = i + 1;
      for (;;)
      {
        this._size = paramInt;
        return;
        paramInt = i + 8;
        continue;
        paramInt = i + 4;
        continue;
        paramInt = i + 12;
        continue;
        paramInt = i + 12 + (RawDBObject.this._buf.getInt(this._dataStart) + 4);
        continue;
        paramInt = i + (RawDBObject.this._buf.getInt(this._dataStart) + 4);
        continue;
        paramInt = i + RawDBObject.this._buf.getInt(this._dataStart);
        continue;
        paramInt = i + (RawDBObject.this._buf.getInt(this._dataStart) + 4 + 1);
        continue;
        paramInt = RawDBObject.this._cStrLength(this._dataStart);
        paramInt = i + (paramInt + RawDBObject.this._cStrLength(this._dataStart + paramInt));
        continue;
        paramInt = i + 8;
      }
    }
    
    boolean eoo()
    {
      return (this._type == 0) || (this._type == Byte.MAX_VALUE);
    }
    
    String fieldName()
    {
      return this._name;
    }
    
    Object getObject()
    {
      if (this._cached != null) {
        return this._cached;
      }
      switch (this._type)
      {
      default: 
        throw new RuntimeException("can't decode type " + this._type);
      case 1: 
        return Double.valueOf(RawDBObject.this._buf.getDouble(this._dataStart));
      case 16: 
        return Integer.valueOf(RawDBObject.this._buf.getInt(this._dataStart));
      case 7: 
        return new ObjectId(RawDBObject.this._buf.getInt(this._dataStart), RawDBObject.this._buf.getInt(this._dataStart + 4), RawDBObject.this._buf.getInt(this._dataStart + 8));
      case 13: 
      case 15: 
        throw new RuntimeException("can't handle code");
      case 2: 
      case 14: 
        return RawDBObject.this._readJavaString(this._dataStart);
      case 9: 
        return new Date(RawDBObject.this._buf.getLong(this._dataStart));
      case 11: 
        throw new RuntimeException("can't handle regex");
      case 5: 
        throw new RuntimeException("can't inspect binary in db");
      case 8: 
        if (RawDBObject.this._buf.get(this._dataStart) > 0) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      case 3: 
      case 4: 
        throw new RuntimeException("can't handle emebdded objects");
      }
      return null;
    }
    
    int size()
    {
      return this._size;
    }
  }
  
  class ElementIter
  {
    boolean _done = false;
    int _pos = RawDBObject.this._offset + 4;
    
    ElementIter() {}
    
    boolean hasNext()
    {
      return (!this._done) && (this._pos < RawDBObject.this._buf.limit());
    }
    
    RawDBObject.Element next()
    {
      RawDBObject.Element localElement = new RawDBObject.Element(RawDBObject.this, this._pos);
      this._done = localElement.eoo();
      this._pos += localElement.size();
      return localElement;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/RawDBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */