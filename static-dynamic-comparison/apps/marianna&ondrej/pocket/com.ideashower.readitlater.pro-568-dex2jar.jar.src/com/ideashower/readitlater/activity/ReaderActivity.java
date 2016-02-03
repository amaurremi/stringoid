package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v4.app.j;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import com.ideashower.readitlater.a.ah;
import com.ideashower.readitlater.a.ai;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.reader.n;

public class ReaderActivity
  extends a
{
  private ReaderFragment z;
  
  public static Intent a(Activity paramActivity, o paramo, UiContext paramUiContext)
  {
    return a(paramActivity, 1, paramo, paramUiContext);
  }
  
  private static Intent a(Context paramContext, int paramInt, o paramo, UiContext paramUiContext)
  {
    String str = null;
    int i = 0;
    if (paramo != null)
    {
      ah.a(paramo);
      i = paramo.e();
      str = paramo.i();
    }
    return a(paramContext, paramInt, str, i, paramUiContext);
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a(paramContext, 2, paramString, paramInt1, null);
    paramContext.putExtra("com.pocket.reader.extra.internal.notification.shareId", paramInt2);
    return paramContext;
  }
  
  private static Intent a(Context paramContext, int paramInt1, String paramString, int paramInt2, UiContext paramUiContext)
  {
    paramContext = new Intent(paramContext, ReaderActivity.class);
    paramContext.putExtra("com.pocket.reader.extra.internal.startSource", paramInt1);
    paramContext.putExtra("com.pocket.reader.extra.internal.uiContext", paramUiContext);
    paramContext.putExtra("com.pocket.reader.extra.internal.uniqueId", paramInt2);
    paramContext.putExtra("com.pocket.reader.extra.internal.itemUrl", paramString);
    return paramContext;
  }
  
  public static Intent a(aa paramaa, o paramo, UiContext paramUiContext)
  {
    return a(paramaa.m(), 3, paramo, paramUiContext);
  }
  
  public static void b(Activity paramActivity, o paramo, UiContext paramUiContext)
  {
    paramActivity.startActivity(a(paramActivity, paramo, paramUiContext));
  }
  
  public static void b(aa paramaa, o paramo, UiContext paramUiContext)
  {
    paramaa.m().startActivity(a(paramaa, paramo, paramUiContext));
  }
  
  public static Intent c(Context paramContext)
  {
    return a(paramContext, 4, null, null);
  }
  
  public int C()
  {
    return getIntent().getIntExtra("com.pocket.reader.extra.internal.startSource", 0);
  }
  
  public boolean D()
  {
    if (this.z != null) {
      return this.z.aA();
    }
    return false;
  }
  
  protected void a(Menu paramMenu)
  {
    super.a(paramMenu);
    this.z.aq().a(paramMenu);
  }
  
  public void a(o paramo)
  {
    ad.a(this, ad.a(paramo, this.z.b(UiTrigger.j)));
  }
  
  protected boolean a(MenuItem paramMenuItem)
  {
    if (this.z.aq().a(paramMenuItem)) {
      return true;
    }
    return super.a(paramMenuItem);
  }
  
  public String f()
  {
    return "reader";
  }
  
  public void finish()
  {
    if (C() == 4) {
      startActivity(new Intent(this, PocketActivity.class).addFlags(603979776));
    }
    super.finish();
  }
  
  protected int g()
  {
    return 0;
  }
  
  protected b l()
  {
    return b.a;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((!isFinishing()) && (paramInt1 == 555)) {
      this.z.a(paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = getIntent();
      int i = getIntent().getIntExtra("com.pocket.reader.extra.internal.uniqueId", 0);
      this.z = ReaderFragment.e(i);
      a(this.z, "main");
      if (C() == 2)
      {
        int j = paramBundle.getIntExtra("com.pocket.reader.extra.internal.notification.shareId", 0);
        if (j != 0) {
          ai.a(new int[] { j }, new int[] { i });
        }
      }
      return;
    }
    this.z = ((ReaderFragment)e().a("main"));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.z.a(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.z.b(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    if (bool) {
      this.z.aq().b(paramMenu);
    }
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.z != null)) {
      this.z.Y();
    }
  }
  
  public boolean t()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ReaderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */