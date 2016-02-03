package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
  extends AbstractList<String>
  implements LazyStringList, RandomAccess
{
  public static final LazyStringList EMPTY = new UnmodifiableLazyStringList(new LazyStringArrayList());
  private final List<Object> list;
  
  public LazyStringArrayList()
  {
    this.list = new ArrayList();
  }
  
  public LazyStringArrayList(LazyStringList paramLazyStringList)
  {
    this.list = new ArrayList(paramLazyStringList.size());
    addAll(paramLazyStringList);
  }
  
  public LazyStringArrayList(List<String> paramList)
  {
    this.list = new ArrayList(paramList);
  }
  
  private static byte[] asByteArray(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return (byte[])paramObject;
    }
    if ((paramObject instanceof String)) {
      return Internal.toByteArray((String)paramObject);
    }
    return ((ByteString)paramObject).toByteArray();
  }
  
  private static ByteString asByteString(Object paramObject)
  {
    if ((paramObject instanceof ByteString)) {
      return (ByteString)paramObject;
    }
    if ((paramObject instanceof String)) {
      return ByteString.copyFromUtf8((String)paramObject);
    }
    return ByteString.copyFrom((byte[])paramObject);
  }
  
  private static String asString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof ByteString)) {
      return ((ByteString)paramObject).toStringUtf8();
    }
    return Internal.toStringUtf8((byte[])paramObject);
  }
  
  public void add(int paramInt, String paramString)
  {
    this.list.add(paramInt, paramString);
    this.modCount += 1;
  }
  
  public void add(ByteString paramByteString)
  {
    this.list.add(paramByteString);
    this.modCount += 1;
  }
  
  public void add(byte[] paramArrayOfByte)
  {
    this.list.add(paramArrayOfByte);
    this.modCount += 1;
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    if ((paramCollection instanceof LazyStringList)) {
      paramCollection = ((LazyStringList)paramCollection).getUnderlyingElements();
    }
    for (;;)
    {
      boolean bool = this.list.addAll(paramInt, paramCollection);
      this.modCount += 1;
      return bool;
    }
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public boolean addAllByteArray(Collection<byte[]> paramCollection)
  {
    boolean bool = this.list.addAll(paramCollection);
    this.modCount += 1;
    return bool;
  }
  
  public boolean addAllByteString(Collection<? extends ByteString> paramCollection)
  {
    boolean bool = this.list.addAll(paramCollection);
    this.modCount += 1;
    return bool;
  }
  
  public List<byte[]> asByteArrayList()
  {
    return new ByteArrayListView(this.list);
  }
  
  public void clear()
  {
    this.list.clear();
    this.modCount += 1;
  }
  
  public String get(int paramInt)
  {
    Object localObject1 = this.list.get(paramInt);
    if ((localObject1 instanceof String)) {
      localObject1 = (String)localObject1;
    }
    Object localObject2;
    String str;
    do
    {
      do
      {
        return (String)localObject1;
        if (!(localObject1 instanceof ByteString)) {
          break;
        }
        localObject2 = (ByteString)localObject1;
        str = ((ByteString)localObject2).toStringUtf8();
        localObject1 = str;
      } while (!((ByteString)localObject2).isValidUtf8());
      this.list.set(paramInt, str);
      return str;
      localObject2 = (byte[])localObject1;
      str = Internal.toStringUtf8((byte[])localObject2);
      localObject1 = str;
    } while (!Internal.isValidUtf8((byte[])localObject2));
    this.list.set(paramInt, str);
    return str;
  }
  
  public byte[] getByteArray(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    byte[] arrayOfByte = asByteArray(localObject);
    if (arrayOfByte != localObject) {
      this.list.set(paramInt, arrayOfByte);
    }
    return arrayOfByte;
  }
  
  public ByteString getByteString(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    ByteString localByteString = asByteString(localObject);
    if (localByteString != localObject) {
      this.list.set(paramInt, localByteString);
    }
    return localByteString;
  }
  
  public List<?> getUnderlyingElements()
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public void mergeFrom(LazyStringList paramLazyStringList)
  {
    paramLazyStringList = paramLazyStringList.getUnderlyingElements().iterator();
    while (paramLazyStringList.hasNext())
    {
      Object localObject = paramLazyStringList.next();
      if ((localObject instanceof byte[]))
      {
        localObject = (byte[])localObject;
        this.list.add(Arrays.copyOf((byte[])localObject, localObject.length));
      }
      else
      {
        this.list.add(localObject);
      }
    }
  }
  
  public String remove(int paramInt)
  {
    Object localObject = this.list.remove(paramInt);
    this.modCount += 1;
    return asString(localObject);
  }
  
  public String set(int paramInt, String paramString)
  {
    return asString(this.list.set(paramInt, paramString));
  }
  
  public void set(int paramInt, ByteString paramByteString)
  {
    this.list.set(paramInt, paramByteString);
  }
  
  public void set(int paramInt, byte[] paramArrayOfByte)
  {
    this.list.set(paramInt, paramArrayOfByte);
  }
  
  public int size()
  {
    return this.list.size();
  }
  
  private static class ByteArrayListView
    extends AbstractList<byte[]>
  {
    private final List<Object> list;
    
    ByteArrayListView(List<Object> paramList)
    {
      this.list = paramList;
    }
    
    public void add(int paramInt, byte[] paramArrayOfByte)
    {
      this.list.add(paramInt, paramArrayOfByte);
      this.modCount += 1;
    }
    
    public byte[] get(int paramInt)
    {
      Object localObject = this.list.get(paramInt);
      byte[] arrayOfByte = LazyStringArrayList.asByteArray(localObject);
      if (arrayOfByte != localObject) {
        this.list.set(paramInt, arrayOfByte);
      }
      return arrayOfByte;
    }
    
    public byte[] remove(int paramInt)
    {
      Object localObject = this.list.remove(paramInt);
      this.modCount += 1;
      return LazyStringArrayList.asByteArray(localObject);
    }
    
    public byte[] set(int paramInt, byte[] paramArrayOfByte)
    {
      return LazyStringArrayList.asByteArray(this.list.set(paramInt, paramArrayOfByte));
    }
    
    public int size()
    {
      return this.list.size();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/LazyStringArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */