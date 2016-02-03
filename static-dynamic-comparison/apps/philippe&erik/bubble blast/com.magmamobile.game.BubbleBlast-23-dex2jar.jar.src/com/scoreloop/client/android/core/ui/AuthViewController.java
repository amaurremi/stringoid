package com.scoreloop.client.android.core.ui;

import android.app.Activity;
import com.scoreloop.client.android.core.model.Session;

public abstract class AuthViewController
{
  private Observer a;
  private Session b;
  
  public AuthViewController(Session paramSession, Observer paramObserver)
  {
    this.b = paramSession;
    this.a = paramObserver;
  }
  
  @Deprecated
  public abstract void a(Activity paramActivity);
  
  Session d()
  {
    return this.b;
  }
  
  protected Observer e()
  {
    return this.a;
  }
  
  public static abstract interface Observer
  {
    public abstract void a();
    
    public abstract void a(Throwable paramThrowable);
    
    public abstract void c();
    
    public abstract void d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/AuthViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */