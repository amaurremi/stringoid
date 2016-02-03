package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class k
  extends AbstractList<String>
  implements l, RandomAccess
{
  public static final l akb = new t(new k());
  private final List<Object> akc;
  
  public k()
  {
    this.akc = new ArrayList();
  }
  
  public k(l paraml)
  {
    this.akc = new ArrayList(paraml.size());
    addAll(paraml);
  }
  
  private static String au(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof e)) {
      return ((e)paramObject).AK();
    }
    return i.r((byte[])paramObject);
  }
  
  private static e av(Object paramObject)
  {
    if ((paramObject instanceof e)) {
      return (e)paramObject;
    }
    if ((paramObject instanceof String)) {
      return e.cU((String)paramObject);
    }
    return e.k((byte[])paramObject);
  }
  
  public List<?> BZ()
  {
    return Collections.unmodifiableList(this.akc);
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof l)) {
      localObject = ((l)paramCollection).BZ();
    }
    boolean bool = this.akc.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public void clear()
  {
    this.akc.clear();
    this.modCount += 1;
  }
  
  public String d(int paramInt, String paramString)
  {
    return au(this.akc.set(paramInt, paramString));
  }
  
  public void e(int paramInt, String paramString)
  {
    this.akc.add(paramInt, paramString);
    this.modCount += 1;
  }
  
  public void f(e parame)
  {
    this.akc.add(parame);
    this.modCount += 1;
  }
  
  public String fr(int paramInt)
  {
    Object localObject = this.akc.get(paramInt);
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    if ((localObject instanceof e))
    {
      localObject = (e)localObject;
      str = ((e)localObject).AK();
      if (((e)localObject).AL()) {
        this.akc.set(paramInt, str);
      }
      return str;
    }
    localObject = (byte[])localObject;
    String str = i.r((byte[])localObject);
    if (i.q((byte[])localObject)) {
      this.akc.set(paramInt, str);
    }
    return str;
  }
  
  public String fs(int paramInt)
  {
    Object localObject = this.akc.remove(paramInt);
    this.modCount += 1;
    return au(localObject);
  }
  
  public e ft(int paramInt)
  {
    Object localObject = this.akc.get(paramInt);
    e locale = av(localObject);
    if (locale != localObject) {
      this.akc.set(paramInt, locale);
    }
    return locale;
  }
  
  public int size()
  {
    return this.akc.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */