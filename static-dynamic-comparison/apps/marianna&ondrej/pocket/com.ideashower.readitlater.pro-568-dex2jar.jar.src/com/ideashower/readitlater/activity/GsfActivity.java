package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.j;
import android.view.Menu;
import com.ideashower.readitlater.service.PocketDemoService;
import com.ideashower.readitlater.views.z;

public class GsfActivity
  extends a
{
  private static u A;
  public static boolean z = true;
  private v B;
  private boolean C;
  
  private void C()
  {
    if (!this.C) {}
    do
    {
      do
      {
        return;
        e(false);
        switch (PocketDemoService.c())
        {
        case 0: 
        default: 
          return;
        case -1: 
          new AlertDialog.Builder(this).setTitle(2131493090).setMessage(2131493195).setPositiveButton(2131492924, null).show();
        }
      } while (this.B == null);
      this.B.aa();
      return;
    } while (getIntent().getIntExtra("extraStartSource", 1) != 1);
    finish();
    Intent localIntent = new Intent(this, PocketActivity.class);
    localIntent.addFlags(268435456);
    startActivity(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext.startActivity(b(paramContext, paramInt));
  }
  
  public static void a(u paramu)
  {
    if (z)
    {
      paramu.a();
      return;
    }
    A = paramu;
  }
  
  public static Intent b(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, GsfActivity.class);
    paramContext.putExtra("extraStartSource", paramInt);
    return paramContext;
  }
  
  protected void c(boolean paramBoolean)
  {
    if (com.ideashower.readitlater.a.v.j()) {
      return;
    }
    super.c(paramBoolean);
  }
  
  public void e(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public String f()
  {
    if (getIntent().getIntExtra("extraStartSource", 1) == 1) {
      return "get_started_flow";
    }
    return "how_to_save_from_apps";
  }
  
  protected int g()
  {
    return 3;
  }
  
  protected b l()
  {
    return b.a;
  }
  
  protected Drawable m()
  {
    return getResources().getDrawable(2130837830);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      this.B = v.Z();
      a(this.B, "main", v.Y());
    }
    for (;;)
    {
      this.u.a(false);
      return;
      this.B = ((v)e().a("main"));
      this.C = paramBundle.getBoolean("isAwaitingDemo", false);
      C();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent.hasExtra("extraSuccess"))
    {
      this.C = true;
      C();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.setGroupVisible(-1, false);
    paramMenu.setGroupVisible(-2, false);
    return true;
  }
  
  public void onRestart()
  {
    super.onRestart();
    C();
  }
  
  public void onResume()
  {
    super.onResume();
    z = false;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("isAwaitingDemo", this.C);
  }
  
  public boolean onSearchRequested()
  {
    return false;
  }
  
  protected void onStop()
  {
    super.onStop();
    z = true;
    if (A != null)
    {
      A.a();
      A = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/GsfActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */