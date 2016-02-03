package com.vungle.publisher.env;

import com.vungle.publisher.bi;
import com.vungle.publisher.bq;
import com.vungle.publisher.cl;
import com.vungle.publisher.event.ClientEventListenerAdapter.Factory;
import com.vungle.publisher.log.Logger;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SdkConfig
{
  public bi a;
  public boolean b;
  public Set<bq> c = EnumSet.noneOf(bq.class);
  public int d;
  @Inject
  public ClientEventListenerAdapter.Factory e;
  
  public final void a(bq... paramVarArgs)
  {
    Logger.d("VungleConfig", "setting ad streaming connectivity types " + cl.a(paramVarArgs));
    this.c.clear();
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        bq localbq = paramVarArgs[i];
        if (localbq != null) {
          this.c.add(localbq);
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/SdkConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */