package org.bson;

import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.bson.io.BSONByteBuffer;
import org.bson.types.BSONTimestamp;
import org.bson.types.Code;
import org.bson.types.CodeWScope;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.ObjectId;
import org.bson.types.Symbol;

public class LazyBSONObject
  implements BSONObject
{
  static final int FIRST_ELMT_OFFSET = 4;
  private static final Logger log = Logger.getLogger("org.bson.LazyBSONObject");
  protected final LazyBSONCallback _callback;
  protected final int _doc_start_offset;
  protected final BSONByteBuffer _input;
  
  public LazyBSONObject(BSONByteBuffer paramBSONByteBuffer, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    this._callback = paramLazyBSONCallback;
    this._input = paramBSONByteBuffer;
    this._doc_start_offset = paramInt;
  }
  
  public LazyBSONObject(BSONByteBuffer paramBSONByteBuffer, LazyBSONCallback paramLazyBSONCallback)
  {
    this(paramBSONByteBuffer, 0, paramLazyBSONCallback);
  }
  
  public LazyBSONObject(byte[] paramArrayOfByte, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    this(BSONByteBuffer.wrap(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt), paramInt, paramLazyBSONCallback);
  }
  
  public LazyBSONObject(byte[] paramArrayOfByte, LazyBSONCallback paramLazyBSONCallback)
  {
    this(BSONByteBuffer.wrap(paramArrayOfByte), paramLazyBSONCallback);
  }
  
  private int getBSONSize(int paramInt)
  {
    return this._input.getInt(paramInt);
  }
  
  private String getElementFieldName(int paramInt)
  {
    return this._input.getCString(paramInt);
  }
  
  private Object readBinary(int paramInt)
  {
    int j = this._input.getInt(paramInt);
    int i = paramInt + 4;
    paramInt = this._input.get(i);
    i += 1;
    byte[] arrayOfByte;
    switch (paramInt)
    {
    case 1: 
    default: 
      arrayOfByte = new byte[j];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfByte;
        if (paramInt >= j) {
          break;
        }
        arrayOfByte[paramInt] = this._input.get(i + paramInt);
        paramInt += 1;
      }
    case 0: 
      arrayOfByte = new byte[j];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfByte;
        if (paramInt >= j) {
          break;
        }
        arrayOfByte[paramInt] = this._input.get(i + paramInt);
        paramInt += 1;
      }
    case 2: 
      int k = this._input.getInt(i);
      if (k + 4 != j) {
        throw new IllegalArgumentException("Bad Data Size; Binary Subtype 2.  { actual len: " + k + " expected totalLen: " + j + "}");
      }
      arrayOfByte = new byte[k];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfByte;
        if (paramInt >= k) {
          break;
        }
        arrayOfByte[paramInt] = this._input.get(i + 4 + paramInt);
        paramInt += 1;
      }
    }
    if (j != 16) {
      throw new IllegalArgumentException("Bad Data Size; Binary Subtype 3 (UUID). { total length: " + j + " != 16");
    }
    Object localObject = new UUID(this._input.getLong(i), this._input.getLong(i + 8));
    return localObject;
  }
  
  public boolean containsField(String paramString)
  {
    return keySet().contains(paramString);
  }
  
  @Deprecated
  public boolean containsKey(String paramString)
  {
    return containsField(paramString);
  }
  
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return new LazyBSONEntrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (LazyBSONObject)paramObject;
    return Arrays.equals(this._input.array(), ((LazyBSONObject)paramObject)._input.array());
  }
  
  public Object get(String paramString)
  {
    paramString = getElement(paramString);
    if (paramString == null) {
      return null;
    }
    return getElementValue(paramString);
  }
  
  public int getBSONSize()
  {
    return getBSONSize(this._doc_start_offset);
  }
  
  ElementRecord getElement(String paramString)
  {
    int i = this._doc_start_offset + 4;
    while (!isElementEmpty(i))
    {
      int j = sizeCString(i + 1);
      int k = getElementBSONSize(i);
      Object localObject = this._input;
      i += 1;
      localObject = ((BSONByteBuffer)localObject).getCString(i);
      if (((String)localObject).equals(paramString)) {
        return new ElementRecord((String)localObject, i);
      }
      i += j + k;
    }
    return null;
  }
  
  protected int getElementBSONSize(int paramInt)
  {
    int i = 0;
    int j = paramInt + 1;
    int m = getElementType(paramInt);
    int k = j + sizeCString(j);
    paramInt = i;
    switch (m)
    {
    default: 
      throw new BSONException("Invalid type " + m + " for field " + getElementFieldName(j));
    case 8: 
      paramInt = 1;
    case -1: 
    case 0: 
    case 6: 
    case 10: 
    case 127: 
      return paramInt;
    case 16: 
      return 4;
    case 1: 
    case 9: 
    case 17: 
    case 18: 
      return 8;
    case 7: 
      return 12;
    case 2: 
    case 13: 
    case 14: 
      return this._input.getInt(k) + 4;
    case 15: 
      return this._input.getInt(k);
    case 12: 
      return this._input.getInt(k) + 4 + 12;
    case 3: 
    case 4: 
      return this._input.getInt(k);
    case 5: 
      return this._input.getInt(k) + 4 + 1;
    }
    paramInt = sizeCString(k);
    return paramInt + sizeCString(k + paramInt);
  }
  
  protected byte getElementType(int paramInt)
  {
    return this._input.get(paramInt);
  }
  
  protected Object getElementValue(ElementRecord paramElementRecord)
  {
    switch (paramElementRecord.type)
    {
    default: 
      throw new BSONException("Invalid type " + paramElementRecord.type + " for field " + getElementFieldName(paramElementRecord.offset));
    case 0: 
    case 6: 
    case 10: 
      return null;
    case 127: 
      return new MaxKey();
    case -1: 
      return new MinKey();
    case 8: 
      if (this._input.get(paramElementRecord.valueOffset) != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 16: 
      return Integer.valueOf(this._input.getInt(paramElementRecord.valueOffset));
    case 17: 
      i = this._input.getInt(paramElementRecord.valueOffset);
      return new BSONTimestamp(this._input.getInt(paramElementRecord.valueOffset + 4), i);
    case 9: 
      return new Date(this._input.getLong(paramElementRecord.valueOffset));
    case 18: 
      return Long.valueOf(this._input.getLong(paramElementRecord.valueOffset));
    case 1: 
      return Double.valueOf(Double.longBitsToDouble(this._input.getLong(paramElementRecord.valueOffset)));
    case 7: 
      return new ObjectId(this._input.getIntBE(paramElementRecord.valueOffset), this._input.getIntBE(paramElementRecord.valueOffset + 4), this._input.getIntBE(paramElementRecord.valueOffset + 8));
    case 14: 
      return new Symbol(this._input.getUTF8String(paramElementRecord.valueOffset));
    case 13: 
      return new Code(this._input.getUTF8String(paramElementRecord.valueOffset));
    case 2: 
      return this._input.getUTF8String(paramElementRecord.valueOffset);
    case 15: 
      i = this._input.getInt(paramElementRecord.valueOffset + 4);
      return new CodeWScope(this._input.getUTF8String(paramElementRecord.valueOffset + 4), (BSONObject)this._callback.createObject(this._input.array(), paramElementRecord.valueOffset + 4 + 4 + i));
    case 12: 
      i = this._input.getInt(paramElementRecord.valueOffset);
      String str = this._input.getCString(paramElementRecord.valueOffset + 4);
      i = paramElementRecord.valueOffset + i + 4;
      paramElementRecord = new ObjectId(this._input.getIntBE(i), this._input.getIntBE(i + 4), this._input.getIntBE(i + 8));
      return this._callback.createDBRef(str, paramElementRecord);
    case 3: 
      return this._callback.createObject(this._input.array(), paramElementRecord.valueOffset);
    case 4: 
      return this._callback.createArray(this._input.array(), paramElementRecord.valueOffset);
    case 5: 
      return readBinary(paramElementRecord.valueOffset);
    }
    int i = sizeCString(paramElementRecord.valueOffset);
    return Pattern.compile(this._input.getCString(paramElementRecord.valueOffset), BSON.regexFlags(this._input.getCString(paramElementRecord.valueOffset + i + 1)));
  }
  
  List<ElementRecord> getElements()
  {
    int i = this._doc_start_offset + 4;
    ArrayList localArrayList = new ArrayList();
    while (!isElementEmpty(i))
    {
      int j = sizeCString(i + 1);
      int k = getElementBSONSize(i);
      BSONByteBuffer localBSONByteBuffer = this._input;
      i += 1;
      localArrayList.add(new ElementRecord(localBSONByteBuffer.getCString(i), i));
      i += j + k;
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this._input.array());
  }
  
  protected boolean isElementEmpty(int paramInt)
  {
    return getElementType(paramInt) == 0;
  }
  
  public boolean isEmpty()
  {
    return isElementEmpty(this._doc_start_offset + 4);
  }
  
  public Set<String> keySet()
  {
    return new LazyBSONKeySet();
  }
  
  public int pipe(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this._input.array(), this._doc_start_offset, getBSONSize());
    return getBSONSize();
  }
  
  public Object put(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("Object is read only");
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException("Object is read only");
  }
  
  public void putAll(BSONObject paramBSONObject)
  {
    throw new UnsupportedOperationException("Object is read only");
  }
  
  public Object removeField(String paramString)
  {
    throw new UnsupportedOperationException("Object is read only");
  }
  
  protected int sizeCString(int paramInt)
  {
    int i = paramInt;
    for (;;)
    {
      if (this._input.get(i) == 0) {
        return i - paramInt + 1;
      }
      i += 1;
    }
  }
  
  public Map toMap()
  {
    throw new UnsupportedOperationException("Not Supported");
  }
  
  public String toString()
  {
    return JSON.serialize(this);
  }
  
  class ElementRecord
  {
    final int fieldNameSize;
    final String name;
    final int offset;
    final byte type;
    final int valueOffset;
    
    ElementRecord(String paramString, int paramInt)
    {
      this.name = paramString;
      this.offset = paramInt;
      this.type = LazyBSONObject.this.getElementType(paramInt - 1);
      this.fieldNameSize = LazyBSONObject.this.sizeCString(paramInt);
      this.valueOffset = (this.fieldNameSize + paramInt);
    }
  }
  
  class LazyBSONEntryIterator
    implements Iterator<Map.Entry<String, Object>>
  {
    int offset = LazyBSONObject.this._doc_start_offset + 4;
    
    LazyBSONEntryIterator() {}
    
    public boolean hasNext()
    {
      return !LazyBSONObject.this.isElementEmpty(this.offset);
    }
    
    public Map.Entry<String, Object> next()
    {
      int i = LazyBSONObject.this.sizeCString(this.offset + 1);
      int j = LazyBSONObject.this.getElementBSONSize(this.offset);
      final Object localObject = LazyBSONObject.this._input.getCString(this.offset + 1);
      LazyBSONObject localLazyBSONObject = LazyBSONObject.this;
      int k = this.offset + 1;
      this.offset = k;
      localObject = new LazyBSONObject.ElementRecord(localLazyBSONObject, (String)localObject, k);
      this.offset += i + j;
      new Map.Entry()
      {
        public boolean equals(Object paramAnonymousObject)
        {
          if (!(paramAnonymousObject instanceof Map.Entry)) {}
          do
          {
            return false;
            paramAnonymousObject = (Map.Entry)paramAnonymousObject;
          } while ((!getKey().equals(((Map.Entry)paramAnonymousObject).getKey())) || (!getValue().equals(((Map.Entry)paramAnonymousObject).getValue())));
          return true;
        }
        
        public String getKey()
        {
          return localObject.name;
        }
        
        public Object getValue()
        {
          return LazyBSONObject.this.getElementValue(localObject);
        }
        
        public int hashCode()
        {
          return getKey().hashCode() ^ getValue().hashCode();
        }
        
        public Object setValue(Object paramAnonymousObject)
        {
          throw new UnsupportedOperationException("Read only");
        }
        
        public String toString()
        {
          return getKey() + "=" + getValue();
        }
      };
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read only");
    }
  }
  
  class LazyBSONEntrySet
    extends LazyBSONObject.ReadOnlySet<Map.Entry<String, Object>>
  {
    LazyBSONEntrySet()
    {
      super();
    }
    
    public boolean contains(Object paramObject)
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        if (((Map.Entry)localIterator.next()).equals(paramObject)) {
          return true;
        }
      }
      return false;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean isEmpty()
    {
      return LazyBSONObject.this.isEmpty();
    }
    
    public Iterator<Map.Entry<String, Object>> iterator()
    {
      return new LazyBSONObject.LazyBSONEntryIterator(LazyBSONObject.this);
    }
    
    public int size()
    {
      return LazyBSONObject.this.keySet().size();
    }
    
    public Object[] toArray()
    {
      return toArray(new Map.Entry[size()]);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      int i = size();
      if (paramArrayOfT.length >= i) {}
      for (;;)
      {
        Iterator localIterator = iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          paramArrayOfT[i] = localIterator.next();
          i += 1;
        }
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
      }
      if (paramArrayOfT.length > i) {
        paramArrayOfT[i] = null;
      }
      return paramArrayOfT;
    }
  }
  
  class LazyBSONKeyIterator
    implements Iterator<String>
  {
    int offset = LazyBSONObject.this._doc_start_offset + 4;
    
    LazyBSONKeyIterator() {}
    
    public boolean hasNext()
    {
      return !LazyBSONObject.this.isElementEmpty(this.offset);
    }
    
    public String next()
    {
      int i = LazyBSONObject.this.sizeCString(this.offset + 1);
      int j = LazyBSONObject.this.getElementBSONSize(this.offset);
      String str = LazyBSONObject.this._input.getCString(this.offset + 1);
      this.offset += i + j + 1;
      return str;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read only");
    }
  }
  
  public class LazyBSONKeySet
    extends LazyBSONObject.ReadOnlySet<String>
  {
    public LazyBSONKeySet()
    {
      super();
    }
    
    public boolean add(String paramString)
    {
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean contains(Object paramObject)
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(paramObject)) {
          return true;
        }
      }
      return false;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean isEmpty()
    {
      return LazyBSONObject.this.isEmpty();
    }
    
    public Iterator<String> iterator()
    {
      return new LazyBSONObject.LazyBSONKeyIterator(LazyBSONObject.this);
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int size()
    {
      int i = 0;
      Iterator localIterator = iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        i += 1;
      }
      return i;
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      int i = size();
      if (paramArrayOfT.length >= i) {}
      for (;;)
      {
        i = 0;
        Iterator localIterator = iterator();
        while (localIterator.hasNext())
        {
          paramArrayOfT[i] = ((String)localIterator.next());
          i += 1;
        }
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
      }
      if (paramArrayOfT.length > i) {
        paramArrayOfT[i] = null;
      }
      return paramArrayOfT;
    }
    
    public String[] toArray()
    {
      return (String[])toArray(new String[size()]);
    }
  }
  
  abstract class ReadOnlySet<E>
    implements Set<E>
  {
    ReadOnlySet() {}
    
    public boolean add(E paramE)
    {
      throw new UnsupportedOperationException("Read-only Set");
    }
    
    public boolean addAll(Collection<? extends E> paramCollection)
    {
      throw new UnsupportedOperationException("Read-only Set");
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException("Read-only Set");
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException("Read-only Set");
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException("Read-only Set");
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException("Read-only Set");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/LazyBSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */