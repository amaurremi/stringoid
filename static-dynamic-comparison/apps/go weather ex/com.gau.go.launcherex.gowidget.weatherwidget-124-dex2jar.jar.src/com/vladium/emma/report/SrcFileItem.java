package com.vladium.emma.report;

import com.vladium.emma.data.ClassDescriptor;
import com.vladium.emma.data.MethodDescriptor;
import com.vladium.util.IntObjectMap;
import java.util.Iterator;

public final class SrcFileItem
  extends Item
{
  private static final Item.ItemMetadata METADATA = new Item.ItemMetadata(2, "srcfile", 31L);
  private int m_firstLine;
  private final String m_fullVMName;
  private IntObjectMap m_lineCoverage;
  private final String m_name;
  
  public SrcFileItem(IItem paramIItem, String paramString1, String paramString2)
  {
    super(paramIItem);
    this.m_name = paramString1;
    this.m_fullVMName = paramString2;
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
    int i = arrayOfInt2[paramInt];
    if (i < 0)
    {
      Object localObject1;
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        return super.getAggregate(paramInt);
      case 5: 
      case 11: 
        arrayOfInt2[11] = getChildCount();
        i = 0;
        localObject1 = getChildren();
        while (((Iterator)localObject1).hasNext()) {
          i += ((IItem)((Iterator)localObject1).next()).getAggregate(5);
        }
        arrayOfInt2[5] = i;
        return arrayOfInt2[paramInt];
      case 12: 
        arrayOfInt2[12] = 1;
        return 1;
      }
      IntObjectMap localIntObjectMap1 = new IntObjectMap();
      Iterator localIterator1 = getChildren();
      int m;
      int n;
      if (localIterator1.hasNext())
      {
        localObject1 = (ClassItem)localIterator1.next();
        boolean[][] arrayOfBoolean = ((ClassItem)localObject1).getCoverage();
        MethodDescriptor[] arrayOfMethodDescriptor = ((ClassItem)localObject1).getClassDescriptor().getMethods();
        Iterator localIterator2 = ((ClassItem)localObject1).getChildren();
        label360:
        label459:
        while (localIterator2.hasNext())
        {
          i = ((MethodItem)localIterator2.next()).getID();
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
              break label459;
            }
            j = arrayOfInt4[i];
            arrayOfInt1 = (int[])localIntObjectMap1.get(j);
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
                break label360;
                localObject1 = arrayOfBoolean[i];
                break;
              }
            }
            i += 1;
          }
        }
      }
      int i4 = localIntObjectMap1.size();
      arrayOfInt2[7] = i4;
      int i1 = 0;
      i = 0;
      Object localObject2 = new IntObjectMap(i4);
      int j = Integer.MAX_VALUE;
      int[] arrayOfInt1 = localIntObjectMap1.keys();
      int k = 0;
      if (k < i4)
      {
        int i3 = arrayOfInt1[k];
        localObject1 = (int[])localIntObjectMap1.get(i3);
        int i2 = localObject1[0];
        int i5 = localObject1[1];
        int i6 = localObject1[2];
        int i7 = localObject1[3];
        n = i1;
        m = i;
        if (i7 > 0)
        {
          n = i1 + i6 * 100 / i2;
          m = i + i7 * 100 / i5;
        }
        localObject1 = (int[][])null;
        if (i7 == 0) {
          i = 0;
        }
        for (;;)
        {
          ((IntObjectMap)localObject2).put(i3, new LineCoverageData(i, (int[][])localObject1));
          i2 = j;
          if (i3 < j) {
            i2 = i3;
          }
          k += 1;
          i1 = n;
          i = m;
          j = i2;
          break;
          if (i7 == i5)
          {
            i = 2;
          }
          else
          {
            i = 1;
            localObject1 = new int[2][];
            localObject1[0] = { i2, i6 };
            localObject1[1] = { i5, i7 };
          }
        }
      }
      this.m_lineCoverage = ((IntObjectMap)localObject2);
      this.m_firstLine = j;
      arrayOfInt2[1] = i1;
      arrayOfInt2[3] = i;
      return arrayOfInt2[paramInt];
    }
    return i;
  }
  
  public int getFirstLine()
  {
    if (this.m_firstLine == 0) {
      getAggregate(7);
    }
    return this.m_firstLine;
  }
  
  public String getFullVMName()
  {
    return this.m_fullVMName;
  }
  
  public IntObjectMap getLineCoverage()
  {
    if (this.m_lineCoverage == null) {
      getAggregate(7);
    }
    return this.m_lineCoverage;
  }
  
  public final IItemMetadata getMetadata()
  {
    return METADATA;
  }
  
  public String getName()
  {
    return this.m_name;
  }
  
  public final class LineCoverageData
  {
    public static final int LINE_COVERAGE_COMPLETE = 2;
    public static final int LINE_COVERAGE_PARTIAL = 1;
    public static final int LINE_COVERAGE_ZERO = 0;
    public final int[][] m_coverageRatio;
    public final int m_coverageStatus;
    
    LineCoverageData(int paramInt, int[][] paramArrayOfInt)
    {
      this.m_coverageStatus = paramInt;
      this.m_coverageRatio = paramArrayOfInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/SrcFileItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */