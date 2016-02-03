package com.gtp.go.weather.sharephoto.takephoto;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameter;
import java.lang.ref.SoftReference;

class f
  implements View.OnClickListener
{
  View a;
  ImageView b;
  TextView c;
  ImageView d;
  h e;
  
  f(d paramd, int paramInt)
  {
    this.a = d.a(paramd).getLayoutInflater().inflate(2130903284, null);
    this.b = ((ImageView)this.a.findViewById(2131231910));
    this.d = ((ImageView)this.a.findViewById(2131231911));
    this.c = ((TextView)this.a.findViewById(2131231912));
    this.d.setVisibility(4);
    this.a.setOnClickListener(this);
    paramd = new ViewGroup.LayoutParams(paramInt, -2);
    this.a.setLayoutParams(paramd);
  }
  
  void a(h paramh)
  {
    this.e = paramh;
    FilterParameter localFilterParameter = paramh.a;
    this.c.setText(localFilterParameter.getFilterNameResId());
    if (d.b(this.f) != null)
    {
      paramh = (SoftReference)d.c(this.f).get(localFilterParameter.getTypeId());
      if (paramh == null) {
        break label132;
      }
    }
    label127:
    label132:
    for (paramh = (Bitmap)paramh.get();; paramh = null)
    {
      if (paramh != null)
      {
        this.b.setImageBitmap(paramh);
        paramh = this.d;
        if (!this.e.b) {
          break label127;
        }
      }
      for (int i = 0;; i = 4)
      {
        paramh.setVisibility(i);
        return;
        localFilterParameter.mSrcBitmap = d.b(this.f);
        new g(this, localFilterParameter).execute(new Void[0]);
        break;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    d.a(this.f, this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */