package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.j;
import android.view.Menu;
import android.view.Window;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.b.c;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.views.z;
import java.util.Iterator;
import java.util.Set;

public class SplashActivity
  extends a
{
  private com.pocket.a.a A;
  private boolean z = false;
  
  private void C()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && ((localIntent.getFlags() & 0x400000) == 4194304) && (i.a(com.ideashower.readitlater.h.a.aj)))
    {
      this.z = true;
      finish();
      overridePendingTransition(0, 0);
    }
  }
  
  private void D()
  {
    label149:
    label159:
    for (;;)
    {
      try
      {
        if ((this.z) && (!g.j()))
        {
          Object localObject1 = getIntent();
          if (localObject1 == null) {
            break label149;
          }
          int i = ((Intent)localObject1).getFlags();
          Object localObject2 = ((Intent)localObject1).getCategories();
          localObject1 = "";
          if (localObject2 != null)
          {
            localObject2 = ((Set)localObject2).iterator();
            localObject1 = "";
            if (!((Iterator)localObject2).hasNext()) {
              break label159;
            }
            String str = (String)((Iterator)localObject2).next();
            localObject1 = (String)localObject1 + str;
            continue;
          }
          throw new c("Failed launch fix with flags: " + i + " and categories: " + (String)localObject1);
        }
      }
      catch (c localc)
      {
        i.b().a(com.ideashower.readitlater.h.a.aj, false).a();
        e.a(localc, true);
      }
      return;
      throw new c("Failed launch fix with empty intent");
    }
  }
  
  protected void c(boolean paramBoolean) {}
  
  public String f()
  {
    return "login";
  }
  
  protected int g()
  {
    return 3;
  }
  
  protected b l()
  {
    return b.c;
  }
  
  protected Drawable m()
  {
    return new ColorDrawable(-1);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.A.c(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getWindow().setFormat(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    C();
    super.onCreate(paramBundle);
    this.r = true;
    if (paramBundle == null)
    {
      this.A = com.pocket.a.a.Z();
      a(this.A, "main", com.pocket.a.a.Y());
    }
    for (;;)
    {
      this.u.a(false);
      g.a(this);
      if (i.a(com.ideashower.readitlater.h.a.q))
      {
        i.a(com.ideashower.readitlater.h.a.q, false);
        new AlertDialog.Builder(this).setTitle(2131493101).setMessage(2131493100).setNeutralButton(2131492924, null).setPositiveButton(2131492898, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            g.a(SplashActivity.this, "http://help.getpocket.com/customer/portal/articles/1449009");
          }
        }).show();
      }
      return;
      if (this.A == null) {
        this.A = ((com.pocket.a.a)e().a("main"));
      }
    }
  }
  
  protected void onDestroy()
  {
    D();
    super.onDestroy();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.setGroupVisible(-1, false);
    paramMenu.setGroupVisible(-2, false);
    return true;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (as.l()) {
      finish();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (this.A == null) {
      this.A = ((com.pocket.a.a)e().a("main"));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    g.b(this);
  }
  
  public boolean onSearchRequested()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */