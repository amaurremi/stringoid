package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.jiubang.playsdk.a.x;
import com.jiubang.playsdk.e.c;
import java.util.Iterator;
import java.util.List;

public class VerticalView
  extends LinearLayout
  implements q
{
  private LayoutInflater a;
  private x b;
  private BannerView c;
  
  public VerticalView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VerticalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(BannerView paramBannerView)
  {
    if (paramBannerView == null) {
      return;
    }
    Object localObject = paramBannerView.b();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!com.jiubang.playsdk.g.a.d(getContext(), (String)localObject))) {
      if (getResources().getConfiguration().orientation == 2) {
        localObject = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(com.jiubang.playsdk.d.g));
      }
    }
    for (;;)
    {
      paramBannerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localObject = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(com.jiubang.playsdk.d.f));
      continue;
      localObject = new LinearLayout.LayoutParams(-1, 0);
    }
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(x paramx)
  {
    this.b = paramx;
  }
  
  public void a(com.jiubang.playsdk.e.d paramd)
  {
    paramd = paramd.e();
    if ((paramd != null) && (paramd.size() > 0))
    {
      paramd = paramd.iterator();
      while (paramd.hasNext())
      {
        Object localObject = (c)paramd.next();
        localObject = this.b.a(((c)localObject).a());
        if (localObject != null)
        {
          localObject = a.a(this.a, (com.jiubang.playsdk.e.d)localObject, this.b);
          if (localObject != null)
          {
            localObject = ((q)localObject).a();
            if ((localObject instanceof BannerView))
            {
              this.c = ((BannerView)localObject);
              a(this.c);
            }
            addView((View)localObject);
          }
        }
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a(this.c);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = LayoutInflater.from(getContext());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/VerticalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */