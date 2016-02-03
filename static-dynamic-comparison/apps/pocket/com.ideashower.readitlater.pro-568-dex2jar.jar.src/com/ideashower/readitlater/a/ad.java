package com.ideashower.readitlater.a;

import android.os.AsyncTask;
import com.ideashower.readitlater.g.g;
import com.ideashower.readitlater.util.e;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class ad
  extends AsyncTask
{
  private ad(ac paramac) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      ac.a(this.a).await();
      paramVarArgs = g.g();
      paramVarArgs.a();
      paramVarArgs.b();
      ac.b(this.a).add(0, paramVarArgs);
      return Boolean.valueOf(true);
    }
    catch (Throwable paramVarArgs)
    {
      e.a(paramVarArgs, true);
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    ac.c(this.a).a(paramBoolean.booleanValue(), ac.b(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */