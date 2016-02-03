package com.ideashower.readitlater.activity;

import android.os.Bundle;
import android.view.Menu;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.views.z;

public class LoginPromptPasswordActivity
  extends a
{
  protected void c(boolean paramBoolean) {}
  
  public String f()
  {
    return getClass().getName();
  }
  
  protected int g()
  {
    return 3;
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      a(af.Z(), null, af.Y());
    }
    this.u.a(false);
    if ((!i.a(com.ideashower.readitlater.h.a.n)) || (as.v() == null))
    {
      e.a("unexpected use of prompt", true);
      i.b().a(com.ideashower.readitlater.h.a.n, false).a();
      q();
      finish();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.setGroupVisible(-1, false);
    paramMenu.setGroupVisible(-2, false);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/LoginPromptPasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */