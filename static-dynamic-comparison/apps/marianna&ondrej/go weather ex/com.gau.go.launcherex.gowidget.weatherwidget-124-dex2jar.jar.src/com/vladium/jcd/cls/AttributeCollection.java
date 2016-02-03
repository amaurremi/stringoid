package com.vladium.jcd.cls;

import com.vladium.jcd.cls.attribute.Attribute_info;
import com.vladium.jcd.cls.attribute.BridgeAttribute_info;
import com.vladium.jcd.cls.attribute.InnerClassesAttribute_info;
import com.vladium.jcd.cls.attribute.SyntheticAttribute_info;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class AttributeCollection
  implements IAttributeCollection
{
  private static final boolean DISALLOW_MULTIPLE_SYNTHETIC_ATTRIBUTES = false;
  private List m_attributes;
  private transient int m_bridgeRefCount;
  private transient int m_innerClassesAttributeOffset;
  private transient int m_syntheticRefCount;
  
  AttributeCollection(int paramInt)
  {
    if (paramInt < 0) {}
    for (ArrayList localArrayList = new ArrayList();; localArrayList = new ArrayList(paramInt))
    {
      this.m_attributes = localArrayList;
      this.m_innerClassesAttributeOffset = -1;
      return;
    }
  }
  
  public void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject)
  {
    paramIClassDefVisitor.visit(this, paramObject);
  }
  
  public int add(Attribute_info paramAttribute_info)
  {
    List localList = this.m_attributes;
    int i = localList.size();
    localList.add(paramAttribute_info);
    if ((paramAttribute_info instanceof SyntheticAttribute_info)) {
      this.m_syntheticRefCount += 1;
    }
    do
    {
      return i;
      if ((paramAttribute_info instanceof InnerClassesAttribute_info))
      {
        if (this.m_innerClassesAttributeOffset >= 0) {
          throw new IllegalArgumentException("this attribute collection already has an InnerClasses attribute");
        }
        this.m_innerClassesAttributeOffset = i;
        return i;
      }
    } while (!(paramAttribute_info instanceof BridgeAttribute_info));
    this.m_bridgeRefCount += 1;
    return i;
  }
  
  public Object clone()
  {
    try
    {
      AttributeCollection localAttributeCollection = (AttributeCollection)super.clone();
      int j = this.m_attributes.size();
      localAttributeCollection.m_attributes = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localAttributeCollection.m_attributes.add(((Attribute_info)this.m_attributes.get(i)).clone());
        i += 1;
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public final Attribute_info get(int paramInt)
  {
    return (Attribute_info)this.m_attributes.get(paramInt);
  }
  
  public final InnerClassesAttribute_info getInnerClassesAttribute()
  {
    int i = this.m_innerClassesAttributeOffset;
    if (i < 0) {
      return null;
    }
    return (InnerClassesAttribute_info)get(i);
  }
  
  public final boolean hasBridge()
  {
    return this.m_bridgeRefCount > 0;
  }
  
  public final boolean hasSynthetic()
  {
    return this.m_syntheticRefCount > 0;
  }
  
  public final long length()
  {
    long l = 2L;
    int j = this.m_attributes.size();
    int i = 0;
    while (i < j)
    {
      l += get(i).length();
      i += 1;
    }
    return l;
  }
  
  public Attribute_info remove(int paramInt)
  {
    Attribute_info localAttribute_info = (Attribute_info)this.m_attributes.remove(paramInt);
    if ((localAttribute_info instanceof SyntheticAttribute_info)) {
      this.m_syntheticRefCount -= 1;
    }
    do
    {
      return localAttribute_info;
      if ((localAttribute_info instanceof InnerClassesAttribute_info))
      {
        this.m_innerClassesAttributeOffset = -1;
        return localAttribute_info;
      }
    } while (!(localAttribute_info instanceof BridgeAttribute_info));
    this.m_bridgeRefCount -= 1;
    return localAttribute_info;
  }
  
  public Attribute_info set(int paramInt, Attribute_info paramAttribute_info)
  {
    Attribute_info localAttribute_info = (Attribute_info)this.m_attributes.set(paramInt, paramAttribute_info);
    if ((localAttribute_info instanceof SyntheticAttribute_info))
    {
      this.m_syntheticRefCount -= 1;
      if (!(paramAttribute_info instanceof SyntheticAttribute_info)) {
        break label86;
      }
      this.m_syntheticRefCount += 1;
    }
    label86:
    do
    {
      return localAttribute_info;
      if ((localAttribute_info instanceof InnerClassesAttribute_info))
      {
        this.m_innerClassesAttributeOffset = -1;
        break;
      }
      if (!(localAttribute_info instanceof BridgeAttribute_info)) {
        break;
      }
      this.m_bridgeRefCount -= 1;
      break;
      if ((paramAttribute_info instanceof InnerClassesAttribute_info))
      {
        this.m_innerClassesAttributeOffset = paramInt;
        return localAttribute_info;
      }
    } while (!(paramAttribute_info instanceof BridgeAttribute_info));
    this.m_bridgeRefCount += 1;
    return localAttribute_info;
  }
  
  public final int size()
  {
    return this.m_attributes.size();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    int j = size();
    paramUDataOutputStream.writeU2(j);
    int i = 0;
    while (i < j)
    {
      get(i).writeInClassFormat(paramUDataOutputStream);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/AttributeCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */