package com.go.weatherex.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.a.a.a;
import com.a.a.d;
import com.a.a.s;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.go.weatherex.framework.fragment.f;
import java.util.List;

class aa
  extends BaseAdapter
{
  float a;
  float b;
  float c;
  float d;
  boolean e = false;
  
  private aa(t paramt) {}
  
  private void a(View paramView, int paramInt)
  {
    if (!this.e) {
      return;
    }
    int i = paramInt / 4;
    s[] arrayOfs = new s[2];
    float f1 = this.a;
    float f2 = this.d;
    arrayOfs[0] = s.a(paramView, "translationX", new float[] { f1 - paramInt % 4 * f2, 0.0F });
    arrayOfs[0].a(500L);
    f1 = this.b;
    f2 = this.c;
    arrayOfs[1] = s.a(paramView, "translationY", new float[] { f1 - i * f2, 0.0F });
    arrayOfs[1].a(500L);
    paramView = new d();
    paramView.a(arrayOfs);
    paramView.a();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.c = paramFloat2;
  }
  
  public int getCount()
  {
    if (t.a(this.f) != null) {
      return t.a(this.f).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.f.i().a(2130903269, paramViewGroup, false);
      paramView = (TextView)localView.findViewById(2131231119);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.setText(((b)t.a(this.f).get(paramInt)).b());
      localView.clearAnimation();
      if (t.a(this.f).equals(t.b(this.f))) {
        a(localView, paramInt);
      }
      return localView;
      paramViewGroup = (TextView)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */