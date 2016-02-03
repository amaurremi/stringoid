package com.vladium.emma.report;

import java.util.Iterator;

public abstract interface IItem
{
  public static final int COVERAGE_BLOCK_COUNT = 0;
  public static final int COVERAGE_BLOCK_INSTR = 2;
  public static final int COVERAGE_CLASS_COUNT = 5;
  public static final int COVERAGE_LINE_COUNT = 1;
  public static final int COVERAGE_LINE_INSTR = 3;
  public static final int COVERAGE_METHOD_COUNT = 4;
  public static final int NUM_OF_AGGREGATES = 13;
  public static final int PRECISION = 100;
  public static final int TOTAL_BLOCK_COUNT = 6;
  public static final int TOTAL_BLOCK_INSTR = 8;
  public static final int TOTAL_CLASS_COUNT = 11;
  public static final int TOTAL_LINE_COUNT = 7;
  public static final int TOTAL_METHOD_COUNT = 10;
  public static final int TOTAL_SRCFILE_COUNT = 12;
  
  public abstract void accept(IItemVisitor paramIItemVisitor, Object paramObject);
  
  public abstract int getAggregate(int paramInt);
  
  public abstract IItemAttribute getAttribute(int paramInt1, int paramInt2);
  
  public abstract int getChildCount();
  
  public abstract Iterator getChildren();
  
  public abstract Iterator getChildren(ItemComparator paramItemComparator);
  
  public abstract IItemMetadata getMetadata();
  
  public abstract String getName();
  
  public abstract IItem getParent();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/IItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */