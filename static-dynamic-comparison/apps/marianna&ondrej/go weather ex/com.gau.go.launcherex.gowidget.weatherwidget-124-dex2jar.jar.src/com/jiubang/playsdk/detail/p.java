package com.jiubang.playsdk.detail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.e.a;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import java.util.List;

class p
  extends BaseAdapter
{
  private Context b;
  private List c;
  private int d;
  
  public p(ThemePreviewLastItemView paramThemePreviewLastItemView, Context paramContext, List paramList)
  {
    this.b = paramContext;
    this.c = paramList;
    this.d = this.b.getResources().getDimensionPixelOffset(d.e);
  }
  
  public int getCount()
  {
    if (this.c != null) {}
    for (int i = this.c.size(); i > 4; i = 0) {
      return 4;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.c != null) {
      return (com.jiubang.playsdk.e.e)this.c.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new KPNetworkImageView(this.b);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(this.d, this.d));
      paramView = new q(this, null);
      paramView.a = ((KPNetworkImageView)paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    paramView = (q)paramViewGroup.getTag();
    Object localObject = (com.jiubang.playsdk.e.e)getItem(paramInt);
    if ((localObject != null) && (((com.jiubang.playsdk.e.e)localObject).f() != null))
    {
      localObject = ((com.jiubang.playsdk.e.e)localObject).f().e();
      paramView.a.a(com.jiubang.playsdk.e.g);
      paramView.a.a((String)localObject);
    }
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */