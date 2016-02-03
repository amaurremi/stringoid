package com.gtp.go.weather.sharephoto.award;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gtp.go.weather.sharephoto.b.d;
import java.util.ArrayList;
import java.util.Iterator;

class y
  extends BaseAdapter
{
  private ArrayList b = new ArrayList();
  private ArrayList c = new ArrayList();
  private ArrayList d = new ArrayList();
  private boolean e;
  private int f;
  private int g;
  
  private y(MyAwardsActivity paramMyAwardsActivity) {}
  
  private void a()
  {
    this.d.clear();
    this.c.clear();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.j() != 0) {
        this.d.add(locald);
      } else {
        this.c.add(locald);
      }
    }
    this.f = this.c.size();
    this.g = this.d.size();
    if ((this.f != 0) && (this.g != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      return;
    }
  }
  
  public d a(int paramInt)
  {
    if (paramInt < this.f) {
      return (d)this.c.get(paramInt);
    }
    if ((paramInt == this.f) && (this.e)) {
      return null;
    }
    if (this.e) {
      return (d)this.d.get(paramInt - this.f - 1);
    }
    return (d)this.d.get(paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      this.b = paramArrayList;
    }
  }
  
  public int getCount()
  {
    if (this.e) {
      return this.f + this.g + 1;
    }
    return this.f + this.g;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = MyAwardsActivity.d(this.a).inflate(2130903223, null);
      paramViewGroup = new z(this.a, paramView);
      paramView.setTag(paramViewGroup);
      localObject = a(paramInt);
      if (localObject == null) {
        break label206;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.a.setVisibility(8);
      if (((d)localObject).j() == 0) {
        break label160;
      }
      paramInt = 1;
      label75:
      if (paramInt != 0) {
        break label165;
      }
      paramViewGroup.f.setVisibility(4);
      paramViewGroup.e.setImageResource(2130838410);
    }
    for (;;)
    {
      paramViewGroup.c.setText(((d)localObject).c());
      localObject = MyAwardsActivity.b(this.a, ((d)localObject).g());
      if (localObject == null) {
        break label196;
      }
      if (paramInt == 0) {
        break label185;
      }
      paramViewGroup.d.setImageBitmap(MyAwardsActivity.a(this.a, (Bitmap)localObject));
      return paramView;
      paramViewGroup = (z)paramView.getTag();
      break;
      label160:
      paramInt = 0;
      break label75;
      label165:
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.e.setImageResource(2130838411);
    }
    label185:
    paramViewGroup.d.setImageBitmap((Bitmap)localObject);
    return paramView;
    label196:
    paramViewGroup.d.setImageBitmap(null);
    return paramView;
    label206:
    paramViewGroup.b.setVisibility(8);
    paramViewGroup.a.setVisibility(0);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return a(paramInt) != null;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */