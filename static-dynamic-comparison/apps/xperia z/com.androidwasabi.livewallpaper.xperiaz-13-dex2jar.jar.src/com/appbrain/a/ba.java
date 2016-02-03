package com.appbrain.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.appbrain.a;
import com.appbrain.f;

public class ba
  implements f
{
  static final String a = ba.class.getName() + ".ao";
  static final String b = ba.class.getName() + ".wm";
  private Activity c;
  private bc d;
  
  public ba(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  public final void a()
  {
    this.c.setContentView(this.d.a());
  }
  
  public final void a(Bundle paramBundle)
  {
    a locala = (a)this.c.getIntent().getSerializableExtra(a);
    boolean bool = this.c.getIntent().getBooleanExtra(b, false);
    this.d = new bc(this.c, paramBundle, locala, bg.a, bool, new bb(this));
    this.c.requestWindowFeature(1);
    this.c.setContentView(this.d.a());
  }
  
  public final boolean a(int paramInt)
  {
    return false;
  }
  
  public final void b() {}
  
  public final void b(Bundle paramBundle)
  {
    this.d.a(paramBundle);
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final void d() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */