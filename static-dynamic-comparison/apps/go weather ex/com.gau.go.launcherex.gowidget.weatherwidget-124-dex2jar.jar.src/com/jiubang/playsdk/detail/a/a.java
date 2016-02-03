package com.jiubang.playsdk.detail.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.detail.ThemePreviewLastItemView;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.views.ProportionFrameLayout;
import java.util.ArrayList;
import java.util.List;

public class a
  extends c
  implements View.OnClickListener
{
  private Context d;
  private LayoutInflater e;
  private ArrayList f;
  private int g;
  private com.jiubang.playsdk.e.a h;
  private List i = new ArrayList();
  private com.jiubang.playsdk.main.c j;
  
  public a(Context paramContext, com.jiubang.playsdk.e.e parame)
  {
    this.d = paramContext;
    this.e = LayoutInflater.from(this.d);
    this.g = aa.a().e();
    this.h = parame.f();
    this.f = a(parame);
    int k = 0;
    while (k < this.f.size() + 1)
    {
      this.i.add(null);
      k += 1;
    }
    this.j = aa.a().b();
  }
  
  private String a(String paramString)
  {
    paramString = paramString.split("##");
    if ((paramString != null) && (paramString.length == 2)) {
      return paramString[1];
    }
    return "";
  }
  
  private ArrayList a(com.jiubang.playsdk.e.e parame)
  {
    ArrayList localArrayList = new ArrayList();
    parame = parame.f().g();
    if (!TextUtils.isEmpty(parame))
    {
      parame = parame.split("@@");
      if (parame != null)
      {
        int m = parame.length;
        int k = 0;
        while (k < m)
        {
          Object localObject = parame[k];
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = a((String)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localArrayList.add(localObject);
            }
          }
          k += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    int k = 0;
    if (k < getCount() - 1)
    {
      Object localObject = (View)this.i.get(k);
      if (localObject != null)
      {
        localObject = (KPNetworkImageView)((View)localObject).findViewById(f.w);
        if ((this.h instanceof com.jiubang.playsdk.e.a))
        {
          if (!this.h.q()) {
            break label145;
          }
          if (!this.j.b(this.d)) {
            break label100;
          }
          ((KPNetworkImageView)localObject).setVisibility(0);
          ((KPNetworkImageView)localObject).a("");
          ((KPNetworkImageView)localObject).setImageResource(com.jiubang.playsdk.e.f);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        label100:
        if (!TextUtils.isEmpty(this.h.l()))
        {
          ((KPNetworkImageView)localObject).setVisibility(0);
          ((KPNetworkImageView)localObject).a(this.h.l());
        }
        else
        {
          ((KPNetworkImageView)localObject).setVisibility(4);
          ((KPNetworkImageView)localObject).setImageResource(0);
          continue;
          label145:
          if (!TextUtils.isEmpty(this.h.l()))
          {
            ((KPNetworkImageView)localObject).setVisibility(0);
            ((KPNetworkImageView)localObject).a(this.h.l());
          }
          else
          {
            ((KPNetworkImageView)localObject).setVisibility(4);
            ((KPNetworkImageView)localObject).setImageResource(0);
          }
        }
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)this.i.get(paramInt);
    if (paramObject != null)
    {
      ((View)paramObject).setOnClickListener(null);
      paramViewGroup.removeView((View)paramObject);
      this.i.set(paramInt, null);
    }
  }
  
  public int getCount()
  {
    if (this.b) {
      return this.f.size() + 1;
    }
    return this.f.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (View)this.i.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramInt != getCount() - 1) || (!this.b)) {
        break label120;
      }
      localObject2 = (ThemePreviewLastItemView)this.e.inflate(g.i, null);
      localObject1 = localObject2;
      if (this.h != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.h.c()))
        {
          ((ThemePreviewLastItemView)localObject2).a(this.h.c(), this.g);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      this.i.set(paramInt, localObject1);
      paramViewGroup.addView((View)localObject1);
      return localObject1;
      label120:
      localObject2 = (FrameLayout)this.e.inflate(g.z, null);
      localObject1 = (ProportionFrameLayout)((FrameLayout)localObject2).findViewById(f.y);
      if (!this.c) {
        ((ProportionFrameLayout)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      }
      ((ProportionFrameLayout)localObject1).setTag(Integer.valueOf(paramInt));
      ((ProportionFrameLayout)localObject1).setOnClickListener(this);
      ((ProportionFrameLayout)localObject1).a(false);
      ((ProportionFrameLayout)localObject1).b(this.c);
      ((ProportionFrameLayout)localObject1).a(1.77F);
      KPNetworkImageView localKPNetworkImageView2 = (KPNetworkImageView)((ProportionFrameLayout)localObject1).findViewById(f.x);
      KPNetworkImageView localKPNetworkImageView1 = (KPNetworkImageView)((ProportionFrameLayout)localObject1).findViewById(f.w);
      localKPNetworkImageView2.a(new b(this, (TextView)((ProportionFrameLayout)localObject1).findViewById(f.z)));
      localKPNetworkImageView2.a((String)this.f.get(paramInt));
      localKPNetworkImageView2.a(com.jiubang.playsdk.e.g);
      localObject1 = localObject2;
      if ((this.h instanceof com.jiubang.playsdk.e.a)) {
        if (this.h.q())
        {
          if (this.j.b(this.d))
          {
            localKPNetworkImageView1.setVisibility(0);
            localKPNetworkImageView1.a("");
            localKPNetworkImageView1.setImageResource(com.jiubang.playsdk.e.f);
            localObject1 = localObject2;
          }
          else if (!TextUtils.isEmpty(this.h.l()))
          {
            localKPNetworkImageView1.setVisibility(0);
            localKPNetworkImageView1.a(this.h.l());
            localObject1 = localObject2;
          }
          else
          {
            localKPNetworkImageView1.setVisibility(4);
            localKPNetworkImageView1.setImageResource(0);
            localObject1 = localObject2;
          }
        }
        else if (!TextUtils.isEmpty(this.h.l()))
        {
          localKPNetworkImageView1.setVisibility(0);
          localKPNetworkImageView1.a(this.h.l());
          localObject1 = localObject2;
        }
        else
        {
          localKPNetworkImageView1.setVisibility(4);
          localKPNetworkImageView1.setImageResource(0);
          localObject1 = localObject2;
        }
      }
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
      int k = ((Integer)paramView.getTag()).intValue();
      this.a.a(k);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */