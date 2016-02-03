package org.osmdroid.tileprovider.modules;

import java.util.concurrent.ThreadFactory;

public class ConfigurablePriorityThreadFactory
  implements ThreadFactory
{
  private final String mName;
  private final int mPriority;
  
  public ConfigurablePriorityThreadFactory(int paramInt, String paramString)
  {
    this.mPriority = paramInt;
    this.mName = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setPriority(this.mPriority);
    if (this.mName != null) {
      paramRunnable.setName(this.mName);
    }
    return paramRunnable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/ConfigurablePriorityThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */