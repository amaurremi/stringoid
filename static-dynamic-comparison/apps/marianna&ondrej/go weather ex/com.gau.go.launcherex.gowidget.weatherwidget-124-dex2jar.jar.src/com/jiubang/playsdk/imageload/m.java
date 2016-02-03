package com.jiubang.playsdk.imageload;

import com.android.a.aa;

class m
  implements k
{
  m(KPNetworkImageView paramKPNetworkImageView, boolean paramBoolean) {}
  
  public void a(aa paramaa)
  {
    if (KPNetworkImageView.a(this.b) != 0) {
      this.b.setImageResource(KPNetworkImageView.a(this.b));
    }
  }
  
  public void a(j paramj, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a))
    {
      this.b.post(new n(this, paramj));
      return;
    }
    paramj = paramj.b();
    KPNetworkImageView.a(this.b, paramj);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */