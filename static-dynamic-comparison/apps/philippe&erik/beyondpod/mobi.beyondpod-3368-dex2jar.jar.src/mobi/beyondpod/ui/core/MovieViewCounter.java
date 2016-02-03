package mobi.beyondpod.ui.core;

public class MovieViewCounter
{
  static volatile int _InstanceCount = 0;
  
  public static void AddInstance()
  {
    _InstanceCount += 1;
  }
  
  public static boolean HasInstances()
  {
    return _InstanceCount > 0;
  }
  
  public static int InstanceCount()
  {
    return _InstanceCount;
  }
  
  public static void RemoveInstance()
  {
    _InstanceCount -= 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/MovieViewCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */