package com.go.weatherex.themestore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.gau.go.launcherex.gowidget.weather.service.a.b;
import com.jiubang.playsdk.a.a;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.main.BitmapBean;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.views.ProportionFrameLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class g
  extends d
{
  private float e = 1.16F;
  private c f = null;
  private final Map g = new HashMap();
  private final Executor h = Executors.newSingleThreadExecutor();
  private int i = this.b.getResources().getDimensionPixelSize(2131427899);
  private com.gau.go.launcherex.gowidget.weather.service.a.g j = new h(this);
  
  public g(Context paramContext, List paramList, ListView paramListView)
  {
    super(paramContext, paramList, paramListView);
    b.a(this.j);
  }
  
  private void a(BitmapBean paramBitmapBean, KPNetworkImageView paramKPNetworkImageView)
  {
    if ((paramBitmapBean == null) || (paramKPNetworkImageView == null)) {
      return;
    }
    if ((paramBitmapBean.a() != null) && (!paramBitmapBean.a().isRecycled()))
    {
      paramKPNetworkImageView.a("");
      paramKPNetworkImageView.a(0);
      paramKPNetworkImageView.setImageBitmap(paramBitmapBean.a());
      return;
    }
    paramKPNetworkImageView.a("");
    paramKPNetworkImageView.a(0);
    paramKPNetworkImageView.setImageResource(2130837980);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new i(null);
      localView = this.c.inflate(2130903191, paramViewGroup, false);
      localView.setBackgroundColor(0);
      if ((localView instanceof ProportionFrameLayout)) {
        ((ProportionFrameLayout)localView).a(this.e);
      }
      paramView.a = ((KPNetworkImageView)localView.findViewById(2131231618));
      paramView.b = ((FrameLayout)localView.findViewById(2131231619));
      localView.setTag(paramView);
    }
    paramView = (i)localView.getTag();
    String str;
    BitmapBean localBitmapBean;
    if ((this.f != null) && (paramView != null))
    {
      paramViewGroup = (a)this.d.get(paramInt);
      str = paramViewGroup.a();
      paramView.a.setTag(str);
      localBitmapBean = (BitmapBean)this.g.get(str);
      if ((localBitmapBean == null) || (localBitmapBean.a() == null) || (localBitmapBean.a().isRecycled())) {
        break label214;
      }
      a(localBitmapBean, paramView.a);
    }
    while (this.f.d(this.b, paramViewGroup))
    {
      paramView.b.setVisibility(0);
      return localView;
      label214:
      if (localBitmapBean != null) {
        this.g.remove(localBitmapBean);
      }
      b.a(new e(this.b, this.f, paramViewGroup, str), this.h);
    }
    paramView.b.setVisibility(4);
    return localView;
  }
  
  protected void a(FrameLayout paramFrameLayout, LinearLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    super.a(paramFrameLayout, paramLayoutParams, paramInt1, paramInt2);
    if (paramInt1 == 0) {
      paramFrameLayout.setPadding(paramFrameLayout.getPaddingLeft(), this.i, paramFrameLayout.getPaddingRight(), paramFrameLayout.getPaddingBottom());
    }
    if (paramInt1 == getCount() - 1) {
      paramFrameLayout.setPadding(paramFrameLayout.getPaddingLeft(), paramFrameLayout.getPaddingTop(), paramFrameLayout.getPaddingRight(), c());
    }
    if (paramInt2 == 0) {
      paramFrameLayout.setPadding(d(), paramFrameLayout.getPaddingTop(), paramFrameLayout.getPaddingRight(), paramFrameLayout.getPaddingBottom());
    }
    if (paramInt2 == a() - 1) {
      paramFrameLayout.setPadding(paramFrameLayout.getPaddingLeft(), paramFrameLayout.getPaddingTop(), d(), paramFrameLayout.getPaddingBottom());
    }
  }
  
  public void e()
  {
    b.b(this.j);
    this.g.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */