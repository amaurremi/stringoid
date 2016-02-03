package com.vladium.util;

public abstract class IntegerFactory
{
  private static final IntObjectMap s_values = new IntObjectMap(16661);
  
  public static Integer getInteger(int paramInt)
  {
    synchronized (s_values)
    {
      Object localObject1 = s_values.get(paramInt);
      if (localObject1 == null)
      {
        localObject1 = new Integer(paramInt);
        s_values.put(paramInt, localObject1);
        return (Integer)localObject1;
      }
      localObject1 = (Integer)localObject1;
      return (Integer)localObject1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/IntegerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */