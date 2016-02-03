package com.getjar.sdk.comm;

import java.util.Comparator;

public class OperationPriorityComparator
  implements Comparator<Operation>
{
  private static volatile OperationPriorityComparator _Instance = null;
  
  public static OperationPriorityComparator getInstance()
  {
    if (_Instance == null) {
      makeTheInstance();
    }
    return _Instance;
  }
  
  private static void makeTheInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new OperationPriorityComparator();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int compare(Operation paramOperation1, Operation paramOperation2)
  {
    if (paramOperation1 == null) {
      throw new IllegalArgumentException("'lhs' can not be NULL");
    }
    if (paramOperation2 == null) {
      throw new IllegalArgumentException("'rhs' can not be NULL");
    }
    int i = 0;
    int j;
    if (paramOperation1.getPriority() < paramOperation2.getPriority())
    {
      i = -1;
      j = i;
      if (i == 0)
      {
        if (paramOperation1.getCreatedTimestamp() <= paramOperation2.getCreatedTimestamp()) {
          break label84;
        }
        j = -1;
      }
    }
    label84:
    do
    {
      return j;
      if (paramOperation1.getPriority() <= paramOperation2.getPriority()) {
        break;
      }
      i = 1;
      break;
      j = i;
    } while (paramOperation1.getCreatedTimestamp() >= paramOperation2.getCreatedTimestamp());
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/OperationPriorityComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */