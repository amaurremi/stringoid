package com.gtp.go.weather.sharephoto.takephoto;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

class af
  implements View.OnClickListener
{
  View a;
  ImageView b;
  TextView c;
  ImageView d;
  ah e;
  
  af(ad paramad, int paramInt)
  {
    this.a = ad.a(paramad).getLayoutInflater().inflate(2130903286, null);
    this.b = ((ImageView)this.a.findViewById(2131231915));
    this.d = ((ImageView)this.a.findViewById(2131231916));
    this.c = ((TextView)this.a.findViewById(2131231917));
    this.d.setVisibility(4);
    this.a.setOnClickListener(this);
    paramad = new ViewGroup.LayoutParams(paramInt, -2);
    this.a.setLayoutParams(paramad);
  }
  
  void a(ah paramah)
  {
    this.e = paramah;
    this.c.setText(this.e.b);
    this.b.setImageResource(this.e.c);
    paramah = this.d;
    if (this.e.d) {}
    for (int i = 0;; i = 4)
    {
      paramah.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    ad.a(this.f, this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */