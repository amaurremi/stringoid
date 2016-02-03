package com.appbrain.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.appbrain.AdOptions;
import com.appbrain.AppBrainActivity.a;

public class ac
  extends AppBrainActivity.a
{
  static final String a = ac.class.getName() + ".ao";
  static final String b = ac.class.getName() + ".wm";
  private final Activity c;
  private ae d;
  
  public ac(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  public final void a(Bundle paramBundle)
  {
    AdOptions localAdOptions = (AdOptions)this.c.getIntent().getSerializableExtra(a);
    boolean bool = this.c.getIntent().getBooleanExtra(b, false);
    this.d = new ae(this.c, paramBundle, localAdOptions, ae.d.a, bool, new ad(this));
    this.c.requestWindowFeature(1);
    this.c.setContentView(this.d.a());
  }
  
  public final void b(Bundle paramBundle)
  {
    this.d.a(paramBundle);
  }
  
  public final void c()
  {
    this.c.setContentView(this.d.a());
  }
  
  public final boolean d()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */