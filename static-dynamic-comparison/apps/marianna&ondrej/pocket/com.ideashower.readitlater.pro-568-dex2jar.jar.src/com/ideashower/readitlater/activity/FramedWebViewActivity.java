package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.os.Bundle;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class FramedWebViewActivity
  extends BasicWebViewActivity
{
  private RilButton z;
  
  protected int C()
  {
    return 2130903068;
  }
  
  protected int D()
  {
    return 2131230730;
  }
  
  protected b l()
  {
    return b.d;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("com.ideashower.readitlater.extra.title");
    StyledToolbar localStyledToolbar = (StyledToolbar)findViewById(2131230742);
    localStyledToolbar.a(paramBundle, false);
    localStyledToolbar.a(true, null);
    this.z = ((RilButton)findViewById(2131230863));
    this.z.setText(2131492891);
    this.z.setVisibility(8);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/FramedWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */