package twitter4j.management;

import java.util.Map;

public abstract interface APIStatisticsMBean
  extends InvocationStatistics
{
  public abstract Iterable getInvocationStatistics();
  
  public abstract Map getMethodLevelSummariesAsString();
  
  public abstract String getMethodLevelSummary(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/management/APIStatisticsMBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */