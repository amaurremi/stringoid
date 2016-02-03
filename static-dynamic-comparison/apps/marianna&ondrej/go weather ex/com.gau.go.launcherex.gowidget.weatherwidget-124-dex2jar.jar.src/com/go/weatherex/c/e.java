package com.go.weatherex.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

class e
  extends BaseAdapter
{
  private g[] b;
  private RadioButton c = null;
  
  public e(a parama, g[] paramArrayOfg)
  {
    this.b = paramArrayOfg;
  }
  
  public void a()
  {
    int j = getCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (this.b[i].f) {
          this.b[i].f = false;
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void a(g paramg)
  {
    a();
    paramg.f = true;
    a.j(this.a).setText(paramg.a());
    a.a(this.a, paramg.a);
    a.a(this.a, paramg.e);
  }
  
  public g b()
  {
    Object localObject2 = null;
    int j = getCount();
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        if (this.b[i].f) {
          localObject1 = this.b[i];
        }
      }
      else {
        return (g)localObject1;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.length;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.b != null) && (this.b.length > paramInt)) {
      return this.b[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    g localg;
    if (paramView == null)
    {
      paramViewGroup = new k(this.a);
      paramView = paramViewGroup.c;
      paramView.setTag(paramViewGroup);
      localg = this.b[paramInt];
      paramViewGroup.b.setText(localg.a());
      paramViewGroup.a.setId(paramInt);
      if (!localg.f) {
        break label109;
      }
      this.c = paramViewGroup.a;
      paramViewGroup.a.setChecked(true);
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new f(this, localg, paramViewGroup));
      return paramView;
      paramViewGroup = (k)paramView.getTag();
      break;
      label109:
      paramViewGroup.a.setChecked(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */