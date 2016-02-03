package com.vladium.jcd.cls;

import com.vladium.jcd.cls.constant.CONSTANT_Utf8_info;
import com.vladium.jcd.cls.constant.CONSTANT_info;
import com.vladium.jcd.lib.UDataOutputStream;
import com.vladium.util.ObjectIntMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class ConstantCollection
  implements IConstantCollection
{
  private transient ObjectIntMap m_CONSTANT_Utf8_index;
  private List m_constants;
  private int m_size;
  
  ConstantCollection(int paramInt)
  {
    if (paramInt < 0) {}
    for (ArrayList localArrayList = new ArrayList();; localArrayList = new ArrayList(paramInt))
    {
      this.m_constants = localArrayList;
      return;
    }
  }
  
  private ObjectIntMap getCONSTANT_Utf8_index()
  {
    if (this.m_CONSTANT_Utf8_index == null)
    {
      ObjectIntMap localObjectIntMap = new ObjectIntMap(this.m_size);
      int i = 0;
      while (i < this.m_constants.size())
      {
        CONSTANT_info localCONSTANT_info = (CONSTANT_info)this.m_constants.get(i);
        if ((localCONSTANT_info != null) && (localCONSTANT_info.tag() == 1)) {
          localObjectIntMap.put(((CONSTANT_Utf8_info)localCONSTANT_info).m_value, i);
        }
        i += 1;
      }
      this.m_CONSTANT_Utf8_index = localObjectIntMap;
    }
    return this.m_CONSTANT_Utf8_index;
  }
  
  public void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject)
  {
    paramIClassDefVisitor.visit(this, paramObject);
  }
  
  public int add(CONSTANT_info paramCONSTANT_info)
  {
    this.m_constants.add(paramCONSTANT_info);
    this.m_size += 1;
    int j = this.m_constants.size();
    int i = 1;
    while (i < paramCONSTANT_info.width())
    {
      this.m_size += 1;
      this.m_constants.add(null);
      i += 1;
    }
    if ((this.m_CONSTANT_Utf8_index != null) && ((paramCONSTANT_info instanceof CONSTANT_Utf8_info))) {
      this.m_CONSTANT_Utf8_index.put(((CONSTANT_Utf8_info)paramCONSTANT_info).m_value, j - 1);
    }
    return j;
  }
  
  public Object clone()
  {
    try
    {
      ConstantCollection localConstantCollection = (ConstantCollection)super.clone();
      int j = this.m_constants.size();
      localConstantCollection.m_constants = new ArrayList(j);
      int i = 0;
      if (i < j)
      {
        Object localObject = (CONSTANT_info)this.m_constants.get(i);
        List localList = localConstantCollection.m_constants;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((CONSTANT_info)localObject).clone())
        {
          localList.add(localObject);
          i += 1;
          break;
        }
      }
      return localConstantCollection;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public int find(int paramInt, IConstantCollection.IConstantComparator paramIConstantComparator)
  {
    if (paramIConstantComparator == null) {
      throw new IllegalArgumentException("null input: comparator");
    }
    int i = 0;
    while (i < this.m_constants.size())
    {
      CONSTANT_info localCONSTANT_info = (CONSTANT_info)this.m_constants.get(i);
      if ((localCONSTANT_info != null) && (localCONSTANT_info.tag() == paramInt) && (paramIConstantComparator.equals(localCONSTANT_info))) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public int findCONSTANT_Utf8(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null input: value");
    }
    ObjectIntMap localObjectIntMap = getCONSTANT_Utf8_index();
    int[] arrayOfInt = new int[1];
    if (localObjectIntMap.get(paramString, arrayOfInt)) {
      return arrayOfInt[0] + 1;
    }
    return -1;
  }
  
  public CONSTANT_info get(int paramInt)
  {
    Object localObject = this.m_constants.get(paramInt - 1);
    if (localObject == null) {
      throw new IllegalStateException("assertion failure: dereferencing an invalid constant pool slot " + paramInt);
    }
    return (CONSTANT_info)localObject;
  }
  
  public IConstantCollection.IConstantIterator iterator()
  {
    return new ConstantIterator(this.m_constants);
  }
  
  public CONSTANT_info set(int paramInt, CONSTANT_info paramCONSTANT_info)
  {
    int i = paramInt - 1;
    CONSTANT_info localCONSTANT_info = (CONSTANT_info)this.m_constants.get(i);
    if (localCONSTANT_info == null) {
      throw new IllegalStateException("assertion failure: dereferencing an invalid constant pool slot " + paramInt);
    }
    if (localCONSTANT_info.width() != paramCONSTANT_info.width()) {
      throw new IllegalArgumentException("assertion failure: can't set entry of type [" + localCONSTANT_info.getClass().getName() + "] to an entry of type [" + localCONSTANT_info.getClass().getName() + "] at pool slot " + paramInt);
    }
    this.m_constants.set(i, paramCONSTANT_info);
    if (this.m_CONSTANT_Utf8_index != null)
    {
      if ((localCONSTANT_info instanceof CONSTANT_Utf8_info))
      {
        String str = ((CONSTANT_Utf8_info)localCONSTANT_info).m_value;
        int[] arrayOfInt = new int[1];
        if ((this.m_CONSTANT_Utf8_index.get(str, arrayOfInt)) && (arrayOfInt[0] == i)) {
          this.m_CONSTANT_Utf8_index.remove(str);
        }
      }
      if ((paramCONSTANT_info instanceof CONSTANT_Utf8_info)) {
        this.m_CONSTANT_Utf8_index.put(((CONSTANT_Utf8_info)paramCONSTANT_info).m_value, i);
      }
    }
    return localCONSTANT_info;
  }
  
  public int size()
  {
    return this.m_size;
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    paramUDataOutputStream.writeU2(this.m_constants.size() + 1);
    ConstantIterator localConstantIterator = new ConstantIterator(this.m_constants);
    for (;;)
    {
      CONSTANT_info localCONSTANT_info = localConstantIterator.nextConstant();
      if (localCONSTANT_info == null) {
        break;
      }
      localCONSTANT_info.writeInClassFormat(paramUDataOutputStream);
    }
  }
  
  private static final class ConstantIterator
    implements IConstantCollection.IConstantIterator
  {
    private List m_constants;
    private int m_index;
    private int m_next_index;
    private int m_prev_index;
    
    ConstantIterator(List paramList)
    {
      this.m_constants = paramList;
      this.m_next_index = 1;
      shift();
    }
    
    private void shift()
    {
      this.m_prev_index = this.m_index;
      this.m_index = this.m_next_index;
      if (this.m_index > 0) {}
      try
      {
        CONSTANT_info localCONSTANT_info = (CONSTANT_info)this.m_constants.get(this.m_index - 1);
        this.m_next_index += localCONSTANT_info.width();
        if (this.m_next_index > this.m_constants.size()) {
          this.m_next_index = -1;
        }
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        this.m_next_index = -1;
        this.m_index = -1;
      }
    }
    
    public CONSTANT_info nextConstant()
    {
      int i = nextIndex();
      if (i < 0) {
        return null;
      }
      return (CONSTANT_info)this.m_constants.get(i - 1);
    }
    
    public int nextIndex()
    {
      int i = this.m_index;
      shift();
      return i;
    }
    
    public CONSTANT_info set(CONSTANT_info paramCONSTANT_info)
    {
      int i = this.m_prev_index - 1;
      CONSTANT_info localCONSTANT_info = (CONSTANT_info)this.m_constants.get(i);
      if (localCONSTANT_info == null) {
        throw new IllegalStateException("assertion failure: dereferencing an invalid constant pool slot " + this.m_prev_index);
      }
      if (localCONSTANT_info.width() != paramCONSTANT_info.width()) {
        throw new IllegalArgumentException("assertion failure: can't set entry of type [" + localCONSTANT_info.getClass().getName() + "] to an entry of type [" + localCONSTANT_info.getClass().getName() + "] at pool slot " + this.m_prev_index);
      }
      this.m_constants.set(i, paramCONSTANT_info);
      return localCONSTANT_info;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/ConstantCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */