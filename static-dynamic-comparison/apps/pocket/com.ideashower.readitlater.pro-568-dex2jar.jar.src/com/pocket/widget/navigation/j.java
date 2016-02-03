package com.pocket.widget.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import java.util.ArrayList;

public class j
  extends BaseAdapter
{
  public static final m a = new m(2131493460, 2130837723, n.a, l.a, "highlights", null);
  public static final m b = new m(2131493464, 2130837725, n.a, l.a, "my_list", null);
  public static final m c = new m(2131493451, 0, n.b, l.a, "articles", null);
  public static final m d = new m(2131493489, 0, n.b, l.a, "videos", null);
  public static final m e = new m(2131493461, 0, n.b, l.a, "images", null);
  public static final m f = new m(2131493477, 0, n.b, l.a, "shared_to_me", null);
  public static final m g = new m(2131493487, 2130837727, n.a, l.a, "tags", null);
  public static final m h = new m(2131493458, 2130837722, n.a, l.a, "favorites", null);
  public static final m i = new m(2131493450, 2130837721, n.a, l.a, "archive", null);
  public static final m j = new m(2131493462, 2130837724, n.a, l.b, "inbox", null);
  public static final m k = new m(2131493466, 2130837726, n.a, l.b, "premium", null);
  public static final m l = new m(2131493488, 0, n.b, l.a, "untagged", null);
  private final ArrayList m = new ArrayList();
  private final Context n;
  private final k o;
  
  public j(Context paramContext, k paramk)
  {
    this.n = paramContext;
    this.o = paramk;
    this.m.add(a);
    this.m.add(b);
    this.m.add(c);
    this.m.add(d);
    this.m.add(e);
    this.m.add(f);
    this.m.add(g);
    this.m.add(h);
    this.m.add(i);
    this.m.add(j);
    this.m.add(k);
    if ((i.a(a.G)) && (com.ideashower.readitlater.util.j.f())) {
      this.m.add(this.m.indexOf(g) + 1, l);
    }
  }
  
  public int a(m paramm)
  {
    return this.m.indexOf(paramm);
  }
  
  public m a(int paramInt)
  {
    return (m)this.m.get(paramInt);
  }
  
  public int getCount()
  {
    return this.m.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    m localm = a(paramInt);
    if (paramView != null)
    {
      paramView = (s)paramView;
      if (paramInt + 1 >= getCount()) {
        break label65;
      }
    }
    label65:
    for (paramViewGroup = a(paramInt + 1).c;; paramViewGroup = n.a)
    {
      paramView.a(localm, paramViewGroup);
      return paramView;
      paramView = new s(this.n, this.o);
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */