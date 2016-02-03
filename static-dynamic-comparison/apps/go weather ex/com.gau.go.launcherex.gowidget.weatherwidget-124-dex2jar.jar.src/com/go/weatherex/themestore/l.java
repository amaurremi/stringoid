package com.go.weatherex.themestore;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.gau.go.launcherex.goweather.goplay.q;
import com.jiubang.playsdk.a.a.b;
import com.jiubang.playsdk.e.a;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.views.ProportionFrameLayout;
import java.util.List;

public class l
  extends d
{
  private float e = 1.16F;
  private boolean f = false;
  private int g = this.b.getResources().getDimensionPixelSize(2131427899);
  private b h = u.f().n();
  
  public l(Context paramContext, List paramList, ListView paramListView)
  {
    super(paramContext, paramList, paramListView);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new m();
      localView = this.c.inflate(2130903174, paramViewGroup, false);
      localView.setBackgroundColor(0);
      if ((localView instanceof ProportionFrameLayout)) {
        ((ProportionFrameLayout)localView).a(this.e);
      }
      paramView.a = ((KPNetworkImageView)localView.findViewById(2131231584));
      paramView.b = ((KPNetworkImageView)localView.findViewById(2131231585));
      paramView.b.a(false);
      localView.setTag(paramView);
    }
    paramView = (m)localView.getTag();
    if (paramInt == b() - 1)
    {
      paramView.b.setVisibility(4);
      paramView.a.setTag("more_theme");
      paramView.a.a(0);
      paramView.a.a("");
      if (this.h != null) {
        paramView.a.setImageResource(this.h.g());
      }
    }
    do
    {
      return localView;
      paramViewGroup = (e)this.d.get(paramInt);
      if (paramViewGroup == null) {
        break;
      }
      paramView.a.a(2130837980);
      paramView.a.a(paramViewGroup.a());
      paramViewGroup = paramViewGroup.f();
    } while (!(paramViewGroup instanceof a));
    paramViewGroup = (a)paramViewGroup;
    if (paramViewGroup.q())
    {
      if (this.f)
      {
        paramView.b.setVisibility(0);
        paramView.b.a("");
        paramView.b.setImageResource(2130837979);
        return localView;
      }
      if (!TextUtils.isEmpty(paramViewGroup.l()))
      {
        paramView.b.setVisibility(0);
        paramView.b.a(paramViewGroup.l());
        return localView;
      }
      paramView.b.setVisibility(4);
      paramView.b.setImageResource(0);
      return localView;
    }
    if (!TextUtils.isEmpty(paramViewGroup.l()))
    {
      paramView.b.setVisibility(0);
      paramView.b.a(paramViewGroup.l());
      return localView;
    }
    paramView.b.setVisibility(4);
    paramView.b.setImageResource(0);
    return localView;
    paramView.b.setVisibility(4);
    paramView.a.setTag("");
    paramView.a.a(0);
    paramView.a.a("");
    paramView.a.setImageResource(2130837980);
    return localView;
  }
  
  protected void a(FrameLayout paramFrameLayout, LinearLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    super.a(paramFrameLayout, paramLayoutParams, paramInt1, paramInt2);
    if (paramInt1 == 0) {
      paramFrameLayout.setPadding(paramFrameLayout.getPaddingLeft(), this.g, paramFrameLayout.getPaddingRight(), paramFrameLayout.getPaddingBottom());
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
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int b()
  {
    if (super.b() == 0) {
      return 0;
    }
    return super.b() + 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */