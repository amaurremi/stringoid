package com.gau.go.launcherex.gowidget.weather.view;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

class o
  implements View.OnClickListener
{
  View a;
  ImageView b;
  TextView c;
  CheckBox d;
  private int f;
  
  o(n paramn)
  {
    this.a = n.a(paramn).inflate(2130903063, null);
    this.b = ((ImageView)this.a.findViewById(2131230937));
    this.c = ((TextView)this.a.findViewById(2131230938));
    this.d = ((CheckBox)this.a.findViewById(2131230939));
    this.a.setOnClickListener(this);
  }
  
  void a(int paramInt)
  {
    this.f = paramInt;
    Object localObject = ((ResolveInfo)n.b(this.e).get(paramInt)).activityInfo.loadIcon(this.e.a.getPackageManager()).mutate();
    if (localObject != null) {
      this.b.setImageDrawable((Drawable)localObject);
    }
    localObject = ((ResolveInfo)n.b(this.e).get(paramInt)).activityInfo.loadLabel(this.e.a.getPackageManager()).toString();
    if (!((String)localObject).equals("")) {
      this.c.setText((CharSequence)localObject);
    }
    if ((AppListActivity.g(this.e.a) != null) && (AppListActivity.g(this.e.a).equals(((ResolveInfo)n.b(this.e).get(paramInt)).activityInfo.packageName + "#" + ((ResolveInfo)n.b(this.e).get(paramInt)).activityInfo.name)))
    {
      this.d.setChecked(true);
      return;
    }
    this.d.setChecked(false);
  }
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(AppListActivity.g(this.e.a))) && ((((ResolveInfo)AppListActivity.b(this.e.a).get(this.f)).activityInfo.packageName + "#" + ((ResolveInfo)AppListActivity.b(this.e.a).get(this.f)).activityInfo.name).equals(AppListActivity.g(this.e.a))))
    {
      Toast.makeText(this.e.a, this.e.a.getString(2131166300), 0).show();
      return;
    }
    AppListActivity.a(this.e.a, this.f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */