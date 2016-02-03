package com.vladium.emma.report;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Comparator;

public abstract interface IItemAttribute
{
  public static final int ATTRIBUTE_BLOCK_COVERAGE_ID = 3;
  public static final int ATTRIBUTE_CLASS_COVERAGE_ID = 1;
  public static final int ATTRIBUTE_LINE_COVERAGE_ID = 4;
  public static final int ATTRIBUTE_METHOD_COVERAGE_ID = 2;
  public static final int ATTRIBUTE_NAME_ID = 0;
  public static final int UNITS_COUNT = 0;
  public static final int UNITS_INSTR = 1;
  
  public abstract Comparator comparator();
  
  public abstract void format(IItem paramIItem, StringBuffer paramStringBuffer);
  
  public abstract String getName();
  
  public abstract boolean passes(IItem paramIItem, int paramInt);
  
  public static abstract class Factory
  {
    private static final IItemAttribute[][] ATTRIBUTES;
    
    static
    {
      NameAttribute localNameAttribute = new NameAttribute("name");
      FractionAttribute localFractionAttribute1 = new FractionAttribute("class, %", 5, 11, 1, 0);
      FractionAttribute localFractionAttribute2 = new FractionAttribute("method, %", 4, 10, 1, 0);
      FractionAttribute localFractionAttribute3 = new FractionAttribute("block, %", 0, 6, 1, 0);
      FractionAttribute localFractionAttribute4 = new FractionAttribute("line, %", 1, 7, 100, 1);
      FractionAttribute localFractionAttribute5 = new FractionAttribute("block, %", 2, 8, 1, 0);
      FractionAttribute localFractionAttribute6 = new FractionAttribute("line, %", 3, 7, 100, 1);
      ATTRIBUTES = new IItemAttribute[][] { { localNameAttribute, localFractionAttribute1, localFractionAttribute2, localFractionAttribute3, localFractionAttribute4 }, { localNameAttribute, localFractionAttribute1, localFractionAttribute2, localFractionAttribute5, localFractionAttribute6 } };
    }
    
    public static IItemAttribute getAttribute(int paramInt1, int paramInt2)
    {
      return ATTRIBUTES[paramInt2][paramInt1];
    }
    
    public static IItemAttribute[] getAttributes(int paramInt)
    {
      return (IItemAttribute[])ATTRIBUTES[paramInt].clone();
    }
    
    private static abstract class Attribute
      implements IItemAttribute
    {
      private final String m_name;
      
      protected Attribute(String paramString)
      {
        if (paramString == null) {
          throw new IllegalArgumentException("null input: name");
        }
        this.m_name = paramString;
      }
      
      public String getName()
      {
        return this.m_name;
      }
    }
    
    private static final class FractionAttribute
      extends IItemAttribute.Factory.Attribute
      implements IItemAttribute
    {
      private final Comparator m_comparator;
      final int m_denominatorAggregateID;
      private final FieldPosition m_fieldPosition;
      private final DecimalFormat m_format;
      private final DecimalFormat m_nFormat;
      final int m_numeratorAggregateID;
      private final int m_scale;
      
      FractionAttribute(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
      {
        super();
        this.m_numeratorAggregateID = paramInt1;
        this.m_denominatorAggregateID = paramInt2;
        this.m_scale = paramInt3;
        this.m_format = ((DecimalFormat)NumberFormat.getPercentInstance());
        this.m_fieldPosition = new FieldPosition(0);
        this.m_format.setMaximumFractionDigits(0);
        this.m_nFormat = ((DecimalFormat)NumberFormat.getInstance());
        this.m_nFormat.setGroupingUsed(false);
        this.m_nFormat.setMaximumFractionDigits(paramInt4);
        this.m_comparator = new FractionComparator(null);
      }
      
      public Comparator comparator()
      {
        return this.m_comparator;
      }
      
      public void format(IItem paramIItem, StringBuffer paramStringBuffer)
      {
        double d = paramIItem.getAggregate(this.m_numeratorAggregateID) / this.m_scale;
        int j = paramIItem.getAggregate(this.m_denominatorAggregateID);
        int i = paramStringBuffer.length();
        if (j == 0) {
          this.m_format.format(1.0D, paramStringBuffer, this.m_fieldPosition);
        }
        for (;;)
        {
          int k = Math.max(1, 5 - paramStringBuffer.length() + i);
          i = 0;
          while (i < k)
          {
            paramStringBuffer.append(' ');
            i += 1;
          }
          this.m_format.format(d / j, paramStringBuffer, this.m_fieldPosition);
        }
        paramStringBuffer.append('(');
        this.m_nFormat.format(d, paramStringBuffer, this.m_fieldPosition);
        paramStringBuffer.append('/');
        paramStringBuffer.append(j);
        paramStringBuffer.append(')');
      }
      
      public boolean passes(IItem paramIItem, int paramInt)
      {
        int i = paramIItem.getAggregate(this.m_numeratorAggregateID);
        int j = paramIItem.getAggregate(this.m_denominatorAggregateID);
        return i * 100.0D >= j * this.m_scale * paramInt;
      }
      
      private final class FractionComparator
        implements Comparator
      {
        private FractionComparator() {}
        
        public int compare(Object paramObject1, Object paramObject2)
        {
          paramObject1 = (IItem)paramObject1;
          paramObject2 = (IItem)paramObject2;
          double d1 = ((IItem)paramObject1).getAggregate(IItemAttribute.Factory.FractionAttribute.this.m_numeratorAggregateID);
          double d2 = ((IItem)paramObject1).getAggregate(IItemAttribute.Factory.FractionAttribute.this.m_denominatorAggregateID);
          double d3 = ((IItem)paramObject2).getAggregate(IItemAttribute.Factory.FractionAttribute.this.m_numeratorAggregateID);
          d1 = d1 * ((IItem)paramObject2).getAggregate(IItemAttribute.Factory.FractionAttribute.this.m_denominatorAggregateID) - d3 * d2;
          if (d1 > 0.0D) {
            return 1;
          }
          if (d1 < 0.0D) {
            return -1;
          }
          return 0;
        }
      }
    }
    
    private static final class NameAttribute
      extends IItemAttribute.Factory.Attribute
      implements IItemAttribute
    {
      private final Comparator m_comparator = new NameComparator(null);
      
      NameAttribute(String paramString)
      {
        super();
      }
      
      public Comparator comparator()
      {
        return this.m_comparator;
      }
      
      public void format(IItem paramIItem, StringBuffer paramStringBuffer)
      {
        paramStringBuffer.append(paramIItem.getName());
      }
      
      public boolean passes(IItem paramIItem, int paramInt)
      {
        return true;
      }
      
      private static final class NameComparator
        implements Comparator
      {
        public int compare(Object paramObject1, Object paramObject2)
        {
          paramObject1 = (IItem)paramObject1;
          paramObject2 = (IItem)paramObject2;
          return ((IItem)paramObject1).getName().compareTo(((IItem)paramObject2).getName());
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/IItemAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */