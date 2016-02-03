package com.pocket.q.a;

import android.content.Context;
import android.view.View.OnClickListener;
import com.ideashower.readitlater.activity.h;

public abstract class n
  implements View.OnClickListener
{
  protected final h h;
  
  public n(h paramh)
  {
    if (paramh == null) {
      throw new NullPointerException("settings cannot be null");
    }
    this.h = paramh;
  }
  
  public abstract o a(Context paramContext);
  
  public abstract void a(o paramo);
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract int d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */