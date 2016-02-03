package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import com.ideashower.readitlater.util.j;

public class UpdatedActivity
  extends a
{
  public static void c(Context paramContext)
  {
    paramContext.startActivity(d(paramContext));
  }
  
  public static Intent d(Context paramContext)
  {
    return new Intent(paramContext, UpdatedActivity.class);
  }
  
  protected void c(boolean paramBoolean) {}
  
  public String f()
  {
    return "whats_new";
  }
  
  protected b l()
  {
    return b.d;
  }
  
  protected Drawable m()
  {
    if (j.g()) {
      return getResources().getDrawable(2130837749);
    }
    return super.m();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getWindow().setFormat(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      a(bk.Z(), null, bk.Y());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/UpdatedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */