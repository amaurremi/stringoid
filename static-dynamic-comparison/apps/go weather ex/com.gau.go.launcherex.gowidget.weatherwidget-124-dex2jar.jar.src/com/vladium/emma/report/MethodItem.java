package com.vladium.emma.report;

import com.vladium.emma.data.MethodDescriptor;
import com.vladium.util.Descriptors;
import com.vladium.util.IntObjectMap;

public final class MethodItem
  extends Item
{
  private static final Item.ItemMetadata METADATA = new Item.ItemMetadata(4, "method", 29L);
  private final int m_ID;
  private final String m_descriptor;
  private final int m_firstLine;
  private final String m_name;
  private transient String m_userName;
  
  public MethodItem(IItem paramIItem, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    super(paramIItem);
    this.m_ID = paramInt1;
    this.m_name = paramString1;
    this.m_descriptor = paramString2;
    this.m_firstLine = paramInt2;
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
    int[] arrayOfInt1 = this.m_aggregates;
    int j = arrayOfInt1[paramInt];
    int i = j;
    Object localObject2;
    int m;
    int i5;
    int k;
    int[] arrayOfInt2;
    if (j < 0)
    {
      Object localObject1 = (ClassItem)this.m_parent;
      localObject2 = localObject1.m_cls.getMethods()[this.m_ID];
      i = ((MethodDescriptor)localObject2).getStatus();
      if ((i & 0xE) != 0)
      {
        i = 0;
        while (i < arrayOfInt1.length)
        {
          arrayOfInt1[i] = 0;
          i += 1;
        }
      }
      if ((i & 0x1) == 0)
      {
        m = 1;
        if (((ClassItem)localObject1).m_coverage == null) {
          break label225;
        }
      }
      int i2;
      int i3;
      int n;
      int i6;
      int i4;
      int i1;
      label225:
      for (localObject1 = localObject1.m_coverage[this.m_ID];; localObject1 = null)
      {
        i5 = ((MethodDescriptor)localObject2).getBlockCount();
        arrayOfInt1[10] = 1;
        arrayOfInt1[6] = i5;
        j = 0;
        k = 0;
        arrayOfInt2 = ((MethodDescriptor)localObject2).getBlockSizes();
        if (localObject1 == null) {
          break label485;
        }
        j = 0;
        i2 = 0;
        i = 0;
        i3 = 0;
        n = 0;
        while (n < i5)
        {
          i6 = arrayOfInt2[n];
          i4 = k + i6;
          i1 = j;
          k = i;
          if (localObject1[n] != 0)
          {
            i1 = j + 1;
            k = i + i6;
          }
          n += 1;
          j = i1;
          i = k;
          k = i4;
        }
        m = 0;
        break;
      }
      if (m != 0)
      {
        localObject2 = ((MethodDescriptor)localObject2).getLineMap();
        int i8 = ((IntObjectMap)localObject2).size();
        arrayOfInt1[7] = i8;
        int[] arrayOfInt3 = ((IntObjectMap)localObject2).keys();
        m = 0;
        n = i3;
        i1 = i2;
        while (m < i8)
        {
          int[] arrayOfInt4 = (int[])((IntObjectMap)localObject2).get(arrayOfInt3[m]);
          i4 = 0;
          int i9 = arrayOfInt4.length;
          i2 = 0;
          i5 = 0;
          i3 = 0;
          while (i3 < i9)
          {
            int i11 = arrayOfInt4[i3];
            int i10 = arrayOfInt2[i11];
            int i7 = i5 + i10;
            i6 = i4;
            i5 = i2;
            if (localObject1[i11] != 0)
            {
              i6 = i4 + 1;
              i5 = i2 + i10;
            }
            i3 += 1;
            i4 = i6;
            i2 = i5;
            i5 = i7;
          }
          i1 += i4 * 100 / i9;
          n += i2 * 100 / i5;
          m += 1;
        }
        arrayOfInt1[1] = i1;
        arrayOfInt1[3] = n;
      }
      arrayOfInt1[8] = k;
      if (j <= 0) {
        break label479;
      }
      k = 1;
      arrayOfInt1[4] = k;
      arrayOfInt1[0] = j;
      arrayOfInt1[2] = i;
    }
    for (;;)
    {
      i = arrayOfInt1[paramInt];
      return i;
      label479:
      k = 0;
      break;
      label485:
      i = 0;
      while (i < i5)
      {
        j += arrayOfInt2[i];
        i += 1;
      }
      arrayOfInt1[8] = j;
      arrayOfInt1[4] = 0;
      arrayOfInt1[0] = 0;
      arrayOfInt1[2] = 0;
      if (m != 0)
      {
        arrayOfInt1[7] = ((MethodDescriptor)localObject2).getLineMap().size();
        arrayOfInt1[1] = 0;
        arrayOfInt1[3] = 0;
      }
    }
  }
  
  public int getFirstLine()
  {
    return this.m_firstLine;
  }
  
  public int getID()
  {
    return this.m_ID;
  }
  
  public final IItemMetadata getMetadata()
  {
    return METADATA;
  }
  
  public String getName()
  {
    if (this.m_userName == null) {
      this.m_userName = Descriptors.methodVMNameToJavaName(this.m_parent.getName(), this.m_name, this.m_descriptor, true, true, true);
    }
    return this.m_userName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/MethodItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */