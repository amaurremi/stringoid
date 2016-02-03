package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.jiubang.playsdk.a.a.b;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import java.util.ArrayList;
import java.util.List;

public class SelectorView
  extends LinearLayout
  implements View.OnClickListener
{
  private v a;
  private int[] b;
  private int[] c;
  private int[] d;
  private int e = 0;
  private List f = new ArrayList();
  private LinearLayout g;
  private int h = 0;
  private int i = 0;
  private b j;
  
  public SelectorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    this.g.removeAllViews();
    this.f.clear();
    this.b = this.j.c();
    this.c = this.j.d();
    this.d = this.j.e();
    Object localObject1 = getContext().getResources();
    int m = ((Resources)localObject1).getColor(com.jiubang.playsdk.c.g);
    int n = ((Resources)localObject1).getDimensionPixelSize(d.F);
    int i1 = ((Resources)localObject1).getDimensionPixelSize(d.E);
    int k = 0;
    if (k < this.d.length)
    {
      localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(g.u, null);
      ((LinearLayout)localObject1).setBackgroundResource(aa.a().b().l());
      Object localObject2 = (ImageView)((LinearLayout)localObject1).findViewById(f.G);
      TextView localTextView = (TextView)((LinearLayout)localObject1).findViewById(f.H);
      localTextView.setText(this.d[k]);
      if (k == this.e)
      {
        ((ImageView)localObject2).setImageResource(this.c[k]);
        localTextView.setTextColor(this.i);
      }
      for (;;)
      {
        w localw = new w(this);
        localw.a = ((ImageView)localObject2);
        localw.b = localTextView;
        this.f.add(localw);
        new FrameLayout.LayoutParams(-2, -2).gravity = 17;
        ((LinearLayout)localObject1).setId(k);
        ((LinearLayout)localObject1).setOnClickListener(this);
        this.g.addView((View)localObject1, new LinearLayout.LayoutParams(0, -1, 1.0F));
        if (k != this.d.length - 1)
        {
          localObject1 = new View(getContext());
          ((View)localObject1).setBackgroundColor(m);
          localObject2 = new LinearLayout.LayoutParams(n, i1);
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          this.g.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        k += 1;
        break;
        ((ImageView)localObject2).setImageResource(this.b[k]);
        localTextView.setTextColor(this.h);
      }
    }
  }
  
  public int a()
  {
    return this.f.size();
  }
  
  public void a(int paramInt)
  {
    if ((this.f.size() < paramInt) || (this.e == paramInt)) {
      return;
    }
    ((w)this.f.get(this.e)).a.setImageResource(this.b[this.e]);
    ((w)this.f.get(this.e)).b.setTextColor(this.h);
    ((w)this.f.get(paramInt)).a.setImageResource(this.c[paramInt]);
    ((w)this.f.get(paramInt)).b.setTextColor(this.i);
    this.e = paramInt;
  }
  
  public void a(v paramv)
  {
    this.a = paramv;
  }
  
  public int[] b()
  {
    if (this.j != null) {
      return this.j.a();
    }
    return new int[0];
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    a(k);
    if (this.a != null) {
      this.a.c(k);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.j = aa.a().b().n();
    if (this.j == null) {
      throw new RuntimeException("BaseController's getMineViewBean() can't null");
    }
    this.g = ((LinearLayout)findViewById(f.ak));
    this.h = getContext().getResources().getColor(com.jiubang.playsdk.c.h);
    this.i = getContext().getResources().getColor(this.j.f());
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/SelectorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */