package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class n
  extends BaseAdapter
{
  private int b = -1;
  
  public n(m paramm)
  {
    a();
  }
  
  public s a(int paramInt)
  {
    ArrayList localArrayList = this.a.c.k();
    int i = m.a(this.a) + paramInt;
    paramInt = i;
    if (this.b >= 0)
    {
      paramInt = i;
      if (i >= this.b) {
        paramInt = i + 1;
      }
    }
    return (s)localArrayList.get(paramInt);
  }
  
  void a()
  {
    s locals = this.a.c.q();
    if (locals != null)
    {
      ArrayList localArrayList = this.a.c.k();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((s)localArrayList.get(i) == locals)
        {
          this.b = i;
          return;
        }
        i += 1;
      }
    }
    this.b = -1;
  }
  
  public int getCount()
  {
    int i = this.a.c.k().size() - m.a(this.a);
    if (this.b < 0) {
      return i;
    }
    return i - 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.a.b.inflate(this.a.f, paramViewGroup, false);
    }
    for (;;)
    {
      ((ae)paramView).a(a(paramInt), 0);
      return paramView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */