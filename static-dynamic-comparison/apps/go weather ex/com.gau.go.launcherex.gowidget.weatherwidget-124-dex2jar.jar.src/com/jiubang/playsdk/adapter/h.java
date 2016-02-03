package com.jiubang.playsdk.adapter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.jiubang.playsdk.a.a;
import com.jiubang.playsdk.a.a.b;
import com.jiubang.playsdk.e;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.main.BitmapBean;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.views.ProportionFrameLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h
  extends d
  implements g
{
  public c g = null;
  private float h = 1.57F;
  private Map i = new HashMap();
  private b j;
  private Handler k = new i(this);
  
  public h(Context paramContext, List paramList, c paramc, ListView paramListView)
  {
    super(paramContext, paramList, paramListView);
    this.g = paramc;
    this.j = this.g.n();
    a(true);
  }
  
  private void a(BitmapBean paramBitmapBean, KPNetworkImageView paramKPNetworkImageView)
  {
    if ((paramBitmapBean == null) || (paramKPNetworkImageView == null)) {
      return;
    }
    if (paramBitmapBean.a() != null)
    {
      paramKPNetworkImageView.a("");
      paramKPNetworkImageView.a(0);
      paramKPNetworkImageView.setImageBitmap(paramBitmapBean.a());
      return;
    }
    paramKPNetworkImageView.a(e.g);
    paramKPNetworkImageView.a(paramBitmapBean.b());
  }
  
  public View a(int paramInt, View paramView)
  {
    a locala = (a)this.d.get(paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new j();
      localView = this.c.inflate(com.jiubang.playsdk.g.p, null, false);
      if ((localView instanceof ProportionFrameLayout)) {
        ((ProportionFrameLayout)localView).a(this.h);
      }
      paramView.a = ((KPNetworkImageView)localView.findViewById(com.jiubang.playsdk.f.aa));
      paramView.b = ((FrameLayout)localView.findViewById(com.jiubang.playsdk.f.ab));
      localView.setTag(paramView);
    }
    paramView = (j)localView.getTag();
    if ((this.g != null) && (paramView != null))
    {
      if ((paramInt != this.d.size() - 1) && (locala != null)) {
        break label189;
      }
      paramView.b.setVisibility(4);
      paramView.a.setTag("");
      paramView.a.a(0);
      paramView.a.a("");
      if (this.j != null) {
        paramView.a.setImageResource(this.j.g());
      }
    }
    return localView;
    label189:
    String str = locala.a() + locala.hashCode();
    paramView.a.setTag(str);
    paramView.a.a(e.g);
    paramView.a.a("");
    com.jiubang.playsdk.c.d.a(new f(this.b, this.g, locala, this, str));
    if (this.g.d(this.b, locala))
    {
      paramView.b.setVisibility(0);
      return localView;
    }
    paramView.b.setVisibility(4);
    return localView;
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void a(BitmapBean paramBitmapBean, String paramString)
  {
    if ((paramBitmapBean == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.i.put(paramString, paramBitmapBean);
    this.k.sendMessage(this.k.obtainMessage(1, paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */