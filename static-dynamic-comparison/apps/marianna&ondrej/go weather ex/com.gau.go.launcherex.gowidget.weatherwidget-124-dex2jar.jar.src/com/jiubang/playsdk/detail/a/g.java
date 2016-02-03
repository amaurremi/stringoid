package com.jiubang.playsdk.detail.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
  extends BaseAdapter
{
  private Context a;
  private List b;
  private int c;
  private j d;
  
  public g(Context paramContext, List paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
    a();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 23: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 34: 
    case 35: 
    default: 
      return com.jiubang.playsdk.e.p;
    case 21: 
    case 24: 
      return com.jiubang.playsdk.e.p;
    case 22: 
      return com.jiubang.playsdk.e.q;
    case 25: 
    case 26: 
      return com.jiubang.playsdk.e.u;
    case 31: 
    case 32: 
    case 33: 
    case 36: 
      return com.jiubang.playsdk.e.y;
    }
    return com.jiubang.playsdk.e.o;
  }
  
  private void a(k paramk, com.jiubang.playsdk.e.a parama)
  {
    paramk.e.setText(com.jiubang.playsdk.i.b);
    paramk.e.setOnClickListener(new h(this, parama));
  }
  
  private void b(k paramk, com.jiubang.playsdk.e.a parama)
  {
    paramk.e.setText(com.jiubang.playsdk.i.e);
    paramk.e.setOnClickListener(new i(this, parama));
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
  
  public void a(j paramj)
  {
    this.d = paramj;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
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
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.a, com.jiubang.playsdk.g.y, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView = new k(this, null);
      paramView.a = ((ImageView)paramViewGroup.findViewById(f.X));
      paramView.b = ((TextView)paramViewGroup.findViewById(f.aA));
      paramView.c = ((KPNetworkImageView)paramViewGroup.findViewById(f.ai));
      paramView.e = ((Button)paramViewGroup.findViewById(f.D));
      paramView.d = ((KPNetworkImageView)paramViewGroup.findViewById(f.l));
      paramViewGroup.findViewById(f.Q).getLayoutParams().width = this.c;
      paramViewGroup.setTag(paramView);
    }
    paramView = (k)paramViewGroup.getTag();
    Object localObject = (com.jiubang.playsdk.e.e)getItem(paramInt);
    if (localObject != null)
    {
      paramView.b.setText(((com.jiubang.playsdk.e.e)localObject).b());
      paramView.c.a(com.jiubang.playsdk.e.g);
      paramView.c.a(((com.jiubang.playsdk.e.e)localObject).a());
      localObject = ((com.jiubang.playsdk.e.e)localObject).f();
      if (localObject != null) {}
    }
    else
    {
      return paramViewGroup;
    }
    paramInt = a(((com.jiubang.playsdk.e.a)localObject).f());
    paramView.a.setBackgroundResource(paramInt);
    String str = ((com.jiubang.playsdk.e.a)localObject).c();
    if (com.jiubang.playsdk.g.a.a(this.a, str, null)) {
      a(paramView, (com.jiubang.playsdk.e.a)localObject);
    }
    while ((localObject != null) && (!TextUtils.isEmpty(((com.jiubang.playsdk.e.a)localObject).l())))
    {
      paramView.d.setVisibility(0);
      paramView.d.a(((com.jiubang.playsdk.e.a)localObject).l());
      return paramViewGroup;
      b(paramView, (com.jiubang.playsdk.e.a)localObject);
    }
    paramView.d.setVisibility(4);
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */