package com.vladium.emma.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

abstract class Item
  implements IItem
{
  protected final int[] m_aggregates;
  private final List m_children;
  protected final IItem m_parent;
  
  Item(IItem paramIItem)
  {
    this.m_parent = paramIItem;
    this.m_children = new ArrayList();
    this.m_aggregates = new int[13];
    int i = 0;
    while (i < this.m_aggregates.length)
    {
      this.m_aggregates[i] = -1;
      i += 1;
    }
  }
  
  protected void addChild(IItem paramIItem)
  {
    if (paramIItem == null) {
      throw new IllegalArgumentException("null input: item");
    }
    this.m_children.add(paramIItem);
  }
  
  public int getAggregate(int paramInt)
  {
    int[] arrayOfInt = this.m_aggregates;
    int i = arrayOfInt[paramInt];
    if (i < 0)
    {
      i = 0;
      Iterator localIterator = this.m_children.iterator();
      while (localIterator.hasNext()) {
        i += ((IItem)localIterator.next()).getAggregate(paramInt);
      }
      arrayOfInt[paramInt] = i;
      return i;
    }
    return i;
  }
  
  public final IItemAttribute getAttribute(int paramInt1, int paramInt2)
  {
    if ((getMetadata().getAttributeIDs() & 1 << paramInt1) == 0L) {
      return null;
    }
    return IItemAttribute.Factory.getAttribute(paramInt1, paramInt2);
  }
  
  public final int getChildCount()
  {
    return this.m_children.size();
  }
  
  public final Iterator getChildren()
  {
    return this.m_children.iterator();
  }
  
  public final Iterator getChildren(ItemComparator paramItemComparator)
  {
    if (paramItemComparator == null) {
      return getChildren();
    }
    IItem[] arrayOfIItem = new IItem[this.m_children.size()];
    this.m_children.toArray(arrayOfIItem);
    Arrays.sort(arrayOfIItem, paramItemComparator);
    return Arrays.asList(arrayOfIItem).iterator();
  }
  
  public final IItem getParent()
  {
    return this.m_parent;
  }
  
  protected static final class ItemMetadata
    implements IItemMetadata
  {
    private final long m_attributeIDs;
    private final int m_typeID;
    private final String m_typeName;
    
    ItemMetadata(int paramInt, String paramString, long paramLong)
    {
      this.m_typeID = paramInt;
      this.m_typeName = paramString;
      this.m_attributeIDs = paramLong;
    }
    
    public long getAttributeIDs()
    {
      return this.m_attributeIDs;
    }
    
    public int getTypeID()
    {
      return this.m_typeID;
    }
    
    public String getTypeName()
    {
      return this.m_typeName;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */