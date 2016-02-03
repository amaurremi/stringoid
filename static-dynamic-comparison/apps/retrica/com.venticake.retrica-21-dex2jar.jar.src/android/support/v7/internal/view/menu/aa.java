package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class aa
  extends BaseAdapter
{
  private o b;
  private int c = -1;
  
  public aa(z paramz, o paramo)
  {
    this.b = paramo;
    a();
  }
  
  public s a(int paramInt)
  {
    if (z.a(this.a)) {}
    for (ArrayList localArrayList = this.b.k();; localArrayList = this.b.h())
    {
      int i = paramInt;
      if (this.c >= 0)
      {
        i = paramInt;
        if (paramInt >= this.c) {
          i = paramInt + 1;
        }
      }
      return (s)localArrayList.get(i);
    }
  }
  
  void a()
  {
    s locals = z.c(this.a).q();
    if (locals != null)
    {
      ArrayList localArrayList = z.c(this.a).k();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((s)localArrayList.get(i) == locals)
        {
          this.c = i;
          return;
        }
        i += 1;
      }
    }
    this.c = -1;
  }
  
  public int getCount()
  {
    if (z.a(this.a)) {}
    for (ArrayList localArrayList = this.b.k(); this.c < 0; localArrayList = this.b.h()) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = z.b(this.a).inflate(z.b, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = (ae)paramView;
      if (this.a.c) {
        ((ListMenuItemView)paramView).setForceShowIcon(true);
      }
      paramViewGroup.a(a(paramInt), 0);
      return paramView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */