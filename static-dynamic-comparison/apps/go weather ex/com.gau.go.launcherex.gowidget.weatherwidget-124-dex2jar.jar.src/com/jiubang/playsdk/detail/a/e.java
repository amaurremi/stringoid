package com.jiubang.playsdk.detail.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.main.BitmapBean;
import com.jiubang.playsdk.views.ProportionFrameLayout;
import java.util.ArrayList;
import java.util.List;

public class e
  extends c
  implements View.OnClickListener
{
  private Context d;
  private LayoutInflater e;
  private List f;
  private List g = new ArrayList();
  
  public e(Context paramContext, List paramList)
  {
    this.d = paramContext;
    this.e = LayoutInflater.from(this.d);
    if (paramList == null) {}
    for (this.f = new ArrayList();; this.f = paramList)
    {
      int i = 0;
      while (i < this.f.size())
      {
        this.g.add(null);
        i += 1;
      }
    }
  }
  
  public List a()
  {
    return this.f;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)this.g.get(paramInt);
    if (paramObject != null)
    {
      ((View)paramObject).setOnClickListener(null);
      paramViewGroup.removeView((View)paramObject);
      this.g.set(paramInt, null);
    }
  }
  
  public int getCount()
  {
    return this.f.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (View)this.g.get(paramInt);
    Object localObject1 = localObject2;
    KPNetworkImageView localKPNetworkImageView;
    TextView localTextView;
    BitmapBean localBitmapBean;
    if (localObject2 == null)
    {
      localObject2 = (FrameLayout)this.e.inflate(g.z, null);
      localObject1 = (ProportionFrameLayout)((FrameLayout)localObject2).findViewById(com.jiubang.playsdk.f.y);
      if (!this.c) {
        ((ProportionFrameLayout)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      }
      ((ProportionFrameLayout)localObject1).setTag(Integer.valueOf(paramInt));
      ((ProportionFrameLayout)localObject1).setOnClickListener(this);
      ((ProportionFrameLayout)localObject1).a(false);
      ((ProportionFrameLayout)localObject1).b(this.c);
      ((ProportionFrameLayout)localObject1).a(1.77F);
      localKPNetworkImageView = (KPNetworkImageView)((ProportionFrameLayout)localObject1).findViewById(com.jiubang.playsdk.f.x);
      localTextView = (TextView)((ProportionFrameLayout)localObject1).findViewById(com.jiubang.playsdk.f.z);
      localBitmapBean = (BitmapBean)this.f.get(paramInt);
      localObject1 = localObject2;
      if (localBitmapBean != null)
      {
        localObject1 = localBitmapBean.a();
        if (localObject1 == null) {
          break label196;
        }
        localKPNetworkImageView.setImageBitmap((Bitmap)localObject1);
        localKPNetworkImageView.a("");
        localKPNetworkImageView.a(0);
        localTextView.setVisibility(8);
      }
    }
    for (localObject1 = localObject2;; localObject1 = localObject2)
    {
      paramViewGroup.addView((View)localObject1);
      return localObject1;
      label196:
      localKPNetworkImageView.a(localBitmapBean.b());
      localKPNetworkImageView.a(com.jiubang.playsdk.e.g);
      localKPNetworkImageView.a(new f(this, localTextView));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      this.a.a(i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */