package com.vladium.emma.report;

import java.util.Comparator;

public abstract interface ItemComparator
  extends Comparator
{
  public static final ItemComparator NULL_COMPARATOR = new ItemComparator.Factory.NullComparator(null);
  
  public static abstract class Factory
  {
    public static ItemComparator create(int[] paramArrayOfInt, int paramInt)
    {
      if (paramArrayOfInt == null) {
        throw new IllegalArgumentException("null input: attributeIDsWithDir");
      }
      if (paramArrayOfInt.length == 0) {
        return ItemComparator.NULL_COMPARATOR;
      }
      Comparator[] arrayOfComparator = new Comparator[paramArrayOfInt.length >> 1];
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        Comparator localComparator = IItemAttribute.Factory.getAttribute(paramArrayOfInt[i], paramInt).comparator();
        Object localObject = localComparator;
        if (paramArrayOfInt[(i + 1)] < 0) {
          localObject = new ReverseComparator(localComparator);
        }
        arrayOfComparator[(i >> 1)] = localObject;
        i += 2;
      }
      return new CompositeComparator(arrayOfComparator);
    }
    
    private static final class CompositeComparator
      implements ItemComparator
    {
      private final Comparator[] m_comparators;
      
      CompositeComparator(Comparator[] paramArrayOfComparator)
      {
        this.m_comparators = paramArrayOfComparator;
      }
      
      public int compare(Object paramObject1, Object paramObject2)
      {
        int i = 0;
        while (i < this.m_comparators.length)
        {
          int j = this.m_comparators[i].compare(paramObject1, paramObject2);
          if (j != 0) {
            return j;
          }
          i += 1;
        }
        return 0;
      }
    }
    
    private static final class NullComparator
      implements ItemComparator
    {
      public int compare(Object paramObject1, Object paramObject2)
      {
        return 0;
      }
    }
    
    private static final class ReverseComparator
      implements ItemComparator
    {
      private final Comparator m_comparator;
      
      ReverseComparator(Comparator paramComparator)
      {
        this.m_comparator = paramComparator;
      }
      
      public int compare(Object paramObject1, Object paramObject2)
      {
        return this.m_comparator.compare(paramObject2, paramObject1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/ItemComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */