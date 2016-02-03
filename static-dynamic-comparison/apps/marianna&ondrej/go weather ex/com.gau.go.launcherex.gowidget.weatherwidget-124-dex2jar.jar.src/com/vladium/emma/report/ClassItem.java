package com.vladium.emma.report;

import com.vladium.emma.data.ClassDescriptor;
import com.vladium.emma.data.MethodDescriptor;
import com.vladium.util.IntObjectMap;
import java.util.Iterator;

public final class ClassItem
  extends Item
{
  private static final Item.ItemMetadata METADATA = new Item.ItemMetadata(3, "class", 31L);
  final ClassDescriptor m_cls;
  final boolean[][] m_coverage;
  private int m_firstLine;
  
  public ClassItem(IItem paramIItem, ClassDescriptor paramClassDescriptor, boolean[][] paramArrayOfBoolean)
  {
    super(paramIItem);
    this.m_cls = paramClassDescriptor;
    this.m_coverage = paramArrayOfBoolean;
  }
  
  public static IItemMetadata getTypeMetadata()
  {
    return METADATA;
  }
  
  public void accept(IItemVisitor paramIItemVisitor, Object paramObject)
  {
    paramIItemVisitor.visit(this, paramObject);
  }
  
  public int getAggregate(int paramInt)
  {
    int[] arrayOfInt2 = this.m_aggregates;
    int j = arrayOfInt2[paramInt];
    int i = j;
    if (j < 0) {}
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      i = super.getAggregate(paramInt);
      return i;
    case 5: 
    case 11: 
      arrayOfInt2[11] = 1;
      if (this.m_coverage != null) {}
      for (i = 1;; i = 0)
      {
        arrayOfInt2[5] = i;
        return arrayOfInt2[paramInt];
      }
    }
    boolean[][] arrayOfBoolean = this.m_coverage;
    IntObjectMap localIntObjectMap1 = new IntObjectMap();
    MethodDescriptor[] arrayOfMethodDescriptor = this.m_cls.getMethods();
    Iterator localIterator = getChildren();
    Object localObject2;
    int n;
    label290:
    int k;
    label389:
    while (localIterator.hasNext())
    {
      i = ((MethodItem)localIterator.next()).getID();
      int[] arrayOfInt3;
      IntObjectMap localIntObjectMap2;
      int[] arrayOfInt4;
      if (arrayOfBoolean == null)
      {
        localObject1 = null;
        localObject2 = arrayOfMethodDescriptor[i];
        arrayOfInt3 = ((MethodDescriptor)localObject2).getBlockSizes();
        localIntObjectMap2 = ((MethodDescriptor)localObject2).getLineMap();
        arrayOfInt4 = localIntObjectMap2.keys();
        i = 0;
        m = arrayOfInt4.length;
      }
      for (;;)
      {
        if (i >= m) {
          break label389;
        }
        j = arrayOfInt4[i];
        int[] arrayOfInt1 = (int[])localIntObjectMap1.get(j);
        localObject2 = arrayOfInt1;
        if (arrayOfInt1 == null)
        {
          localObject2 = new int[4];
          localIntObjectMap1.put(j, localObject2);
        }
        arrayOfInt1 = (int[])localIntObjectMap2.get(j);
        n = arrayOfInt1.length;
        localObject2[0] += n;
        j = 0;
        if (j < n)
        {
          i1 = arrayOfInt1[j];
          if ((localObject1 != null) && (localObject1[i1] != 0)) {}
          for (k = 1;; k = 0)
          {
            i1 = arrayOfInt3[i1];
            localObject2[1] += i1;
            if (k != 0)
            {
              localObject2[2] += 1;
              localObject2[3] += i1;
            }
            j += 1;
            break label290;
            localObject1 = arrayOfBoolean[i];
            break;
          }
        }
        i += 1;
      }
    }
    arrayOfInt2[7] = localIntObjectMap1.size();
    int m = 0;
    i = 0;
    Object localObject1 = localIntObjectMap1.keys();
    j = 0;
    int i1 = localObject1.length;
    while (j < i1)
    {
      localObject2 = (int[])localIntObjectMap1.get(localObject1[j]);
      int i4 = localObject2[0];
      int i2 = localObject2[1];
      int i5 = localObject2[2];
      int i3 = localObject2[3];
      n = m;
      k = i;
      if (i3 > 0)
      {
        n = m + i5 * 100 / i4;
        k = i + i3 * 100 / i2;
      }
      j += 1;
      m = n;
      i = k;
    }
    arrayOfInt2[1] = m;
    arrayOfInt2[3] = i;
    return arrayOfInt2[paramInt];
  }
  
  public ClassDescriptor getClassDescriptor()
  {
    return this.m_cls;
  }
  
  public boolean[][] getCoverage()
  {
    return this.m_coverage;
  }
  
  public int getFirstLine()
  {
    if (this.m_firstLine == 0)
    {
      MethodDescriptor[] arrayOfMethodDescriptor = this.m_cls.getMethods();
      int j = Integer.MAX_VALUE;
      int i = 0;
      int n = arrayOfMethodDescriptor.length;
      while (i < n)
      {
        int m = arrayOfMethodDescriptor[i].getFirstLine();
        int k = j;
        if (m > 0)
        {
          k = j;
          if (m < j) {
            k = m;
          }
        }
        i += 1;
        j = k;
      }
      this.m_firstLine = j;
      return j;
    }
    return this.m_firstLine;
  }
  
  public final IItemMetadata getMetadata()
  {
    return METADATA;
  }
  
  public String getName()
  {
    return this.m_cls.getName();
  }
  
  public String getSrcFileName()
  {
    return this.m_cls.getSrcFileName();
  }
  
  public boolean loaded()
  {
    return this.m_coverage != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/ClassItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */