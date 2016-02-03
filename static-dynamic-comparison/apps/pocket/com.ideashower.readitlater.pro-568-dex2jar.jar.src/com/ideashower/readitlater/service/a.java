package com.ideashower.readitlater.service;

import android.content.Intent;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  extends com.a.a.c.a
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  
  public a(String paramString)
  {
    super(paramString);
  }
  
  public static boolean a()
  {
    return a.get();
  }
  
  protected void a(Intent paramIntent)
  {
    a.set(true);
    WakefulAppService.a();
    b(paramIntent);
    a.set(false);
  }
  
  protected abstract void b(Intent paramIntent);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */