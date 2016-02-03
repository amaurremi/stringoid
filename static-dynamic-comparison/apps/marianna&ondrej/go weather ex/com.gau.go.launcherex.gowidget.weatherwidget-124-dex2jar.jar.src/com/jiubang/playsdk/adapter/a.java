package com.jiubang.playsdk.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.views.ProportionFrameLayout;
import java.util.List;

public class a
  extends d
{
  private float g = 1.57F;
  private c h = aa.a().b();
  
  public a(Context paramContext, List paramList, ListView paramListView)
  {
    super(paramContext, paramList, paramListView);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject = (com.jiubang.playsdk.e.e)this.d.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      paramView = this.c.inflate(g.a, null, false);
      if ((paramView instanceof ProportionFrameLayout)) {
        ((ProportionFrameLayout)paramView).a(this.g);
      }
      localb.a = ((KPNetworkImageView)paramView.findViewById(f.k));
      localb.b = ((KPNetworkImageView)paramView.findViewById(f.l));
      localb.b.a(false);
      paramView.setTag(localb);
    }
    for (;;)
    {
      localb = (b)paramView.getTag();
      if ((localObject != null) && (localb != null))
      {
        localb.a.a(((com.jiubang.playsdk.e.e)localObject).a());
        localb.a.a(com.jiubang.playsdk.e.g);
        localObject = ((com.jiubang.playsdk.e.e)localObject).f();
        if ((localObject instanceof com.jiubang.playsdk.e.a))
        {
          localObject = (com.jiubang.playsdk.e.a)localObject;
          if (!((com.jiubang.playsdk.e.a)localObject).q()) {
            break label267;
          }
          if (!this.h.b(this.b)) {
            break label214;
          }
          localb.b.setVisibility(0);
          localb.b.a("");
          localb.b.setImageResource(com.jiubang.playsdk.e.f);
        }
      }
      return paramView;
      label214:
      if (!TextUtils.isEmpty(((com.jiubang.playsdk.e.a)localObject).l()))
      {
        localb.b.setVisibility(0);
        localb.b.a(((com.jiubang.playsdk.e.a)localObject).l());
        return paramView;
      }
      localb.b.setVisibility(4);
      localb.b.setImageResource(0);
      return paramView;
      label267:
      if (!TextUtils.isEmpty(((com.jiubang.playsdk.e.a)localObject).l()))
      {
        localb.b.setVisibility(0);
        localb.b.a(((com.jiubang.playsdk.e.a)localObject).l());
        return paramView;
      }
      localb.b.setVisibility(4);
      localb.b.setImageResource(0);
      return paramView;
    }
  }
  
  public void a(float paramFloat)
  {
    this.g = paramFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */