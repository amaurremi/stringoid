package com.jiubang.playsdk.detail.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.views.TouchMaskFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
  extends BaseAdapter
{
  private Context a;
  private List b;
  private int c;
  private int d;
  private int e = 1;
  private AdapterView.OnItemClickListener f;
  
  public l(Context paramContext, List paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
    this.d = ((int)(paramInt * 1.65D));
    this.e = paramContext.getResources().getDimensionPixelSize(d.G);
    a();
  }
  
  public void a()
  {
    if (this.b == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      com.jiubang.playsdk.e.e locale = (com.jiubang.playsdk.e.e)localIterator.next();
      if ((locale != null) && (locale.f() != null))
      {
        String str = locale.f().c();
        if (com.jiubang.playsdk.g.a.a(this.a, str, null))
        {
          localArrayList.add(locale);
          localIterator.remove();
        }
      }
    }
    this.b.addAll(localArrayList);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.f = paramOnItemClickListener;
  }
  
  public int getCount()
  {
    if (this.b != null) {}
    for (int i = this.b.size(); i > 3; i = 0) {
      return 3;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.b != null) {
      return (com.jiubang.playsdk.e.e)this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = new TouchMaskFrameLayout(this.a);
    paramView.setPadding(this.e, this.e, this.e, this.e);
    paramView.setLayoutParams(new LinearLayout.LayoutParams(this.c, -1));
    KPNetworkImageView localKPNetworkImageView = new KPNetworkImageView(this.a);
    localKPNetworkImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localKPNetworkImageView.setAdjustViewBounds(true);
    localKPNetworkImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localKPNetworkImageView.a(com.jiubang.playsdk.e.g);
    com.jiubang.playsdk.e.e locale = (com.jiubang.playsdk.e.e)getItem(paramInt);
    if (locale != null) {
      localKPNetworkImageView.a(locale.a());
    }
    paramView.addView(localKPNetworkImageView);
    paramView.setOnClickListener(new m(this, paramViewGroup, paramView, paramInt));
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */