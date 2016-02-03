package com.pocket.widget.navigation;

import android.support.v4.app.Fragment;
import com.ideashower.readitlater.a.ai;
import com.ideashower.readitlater.a.aj;
import com.ideashower.readitlater.a.ak;
import java.util.ArrayList;

public class h
  implements ak, com.ideashower.readitlater.activity.g
{
  private int a;
  private i b;
  
  public h(i parami)
  {
    a(parami);
    a(com.ideashower.readitlater.a.g.v().a(this));
  }
  
  private void a(int paramInt)
  {
    if (this.a == paramInt) {}
    do
    {
      return;
      this.a = paramInt;
    } while (this.b == null);
    this.b.a(paramInt);
  }
  
  public void a(Fragment paramFragment)
  {
    com.ideashower.readitlater.a.g.v().b(this);
  }
  
  public void a(aj paramaj)
  {
    int i = 0;
    if ((paramaj.b.isEmpty()) && ((paramaj.g == null) || (paramaj.g.isEmpty())))
    {
      a(0);
      return;
    }
    if (paramaj.g != null) {
      i = paramaj.g.size();
    }
    a(i + paramaj.b.size());
  }
  
  public void a(i parami)
  {
    this.b = parami;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */