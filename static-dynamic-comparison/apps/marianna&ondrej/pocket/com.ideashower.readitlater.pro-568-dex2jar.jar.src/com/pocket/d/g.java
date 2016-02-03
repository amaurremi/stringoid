package com.pocket.d;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ideashower.readitlater.activity.ag;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.d;
import com.ideashower.readitlater.h.l;
import java.io.File;

public class g
  extends c
{
  private final ResolveInfo i;
  private final String j;
  private final com.ideashower.readitlater.activity.f k;
  private final int l;
  
  public g(Context paramContext, b paramb, ResolveInfo paramResolveInfo, String paramString, com.ideashower.readitlater.activity.f paramf, int paramInt)
  {
    super(paramContext, paramb);
    this.i = paramResolveInfo;
    this.j = paramString;
    this.k = paramf;
    this.l = paramInt;
    this.b.setImageDrawable(this.i.loadIcon(k().getPackageManager()));
    g();
  }
  
  private int r()
  {
    return com.ideashower.readitlater.h.i.a(s());
  }
  
  private d s()
  {
    return (d)a.br.a(o());
  }
  
  private String t()
  {
    return com.pocket.m.a.c.c("tempAvatar" + o() + r());
  }
  
  private void u()
  {
    a(com.ideashower.readitlater.f.i.b(t(), m()));
  }
  
  protected void a()
  {
    this.a = ((ViewGroup)LayoutInflater.from(k()).inflate(2130903121, null));
    this.b = ((ImageView)this.a.findViewById(2131230986));
    this.c = ((TextView)this.a.findViewById(2131230902));
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }
  
  public void a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("isLoaded"))) {
      u();
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  protected int d()
  {
    return 0;
  }
  
  protected void e()
  {
    if (this.e != null) {
      this.e.b(this);
    }
    com.ideashower.readitlater.h.i.b().a(s(), r() + 1).a();
    ag.a((android.support.v4.app.f)k(), this.l, t());
  }
  
  public void f() {}
  
  protected void g()
  {
    this.c.setText(this.j);
  }
  
  public File n()
  {
    return new File(t());
  }
  
  public String o()
  {
    return "app_" + this.i.activityInfo.name;
  }
  
  public void onClick(View paramView)
  {
    e();
  }
  
  public Bundle p()
  {
    if (this.f != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isLoaded", true);
      return localBundle;
    }
    return null;
  }
  
  public void q()
  {
    super.q();
    Bitmap localBitmap = this.f;
    u();
    if (this.f == null) {
      this.f = localBitmap;
    }
    while ((this.f == localBitmap) || (this.e == null)) {
      return;
    }
    this.e.a(this, this.f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */