package com.ideashower.readitlater.a;

import android.os.AsyncTask;
import com.ideashower.readitlater.util.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

class af
  extends AsyncTask
{
  private final ag b;
  
  private af(ac paramac, ag paramag)
  {
    this.b = paramag;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      ac.c().set(true);
      this.b.a();
      return Boolean.valueOf(true);
    }
    catch (Throwable paramVarArgs)
    {
      ac.c().set(false);
      e.a(paramVarArgs, true);
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.b.b();
    ac.a(this.a).countDown();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */