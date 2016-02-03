package com.vladium.emma.data;

public abstract interface ICoverageData
  extends IMergeable
{
  public abstract void addClass(boolean[][] paramArrayOfBoolean, String paramString, long paramLong);
  
  public abstract DataHolder getCoverage(ClassDescriptor paramClassDescriptor);
  
  public abstract Object lock();
  
  public abstract ICoverageData shallowCopy();
  
  public abstract int size();
  
  public static final class DataHolder
  {
    public final boolean[][] m_coverage;
    public final long m_stamp;
    
    public DataHolder(boolean[][] paramArrayOfBoolean, long paramLong)
    {
      this.m_coverage = paramArrayOfBoolean;
      this.m_stamp = paramLong;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/ICoverageData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */