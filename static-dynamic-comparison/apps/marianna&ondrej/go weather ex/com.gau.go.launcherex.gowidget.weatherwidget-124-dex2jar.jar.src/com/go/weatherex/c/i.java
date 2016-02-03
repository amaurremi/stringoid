package com.go.weatherex.c;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globalview.y;
import java.util.List;

class i
  extends BaseAdapter
{
  private RadioButton b = null;
  
  public i(a parama) {}
  
  private void a()
  {
    Object localObject2 = this.a.getActivity().getSharedPreferences("myLocation", 0);
    String str1 = ((SharedPreferences)localObject2).getString("lat", "");
    Object localObject1 = ((SharedPreferences)localObject2).getString("lng", "");
    String str3 = ((SharedPreferences)localObject2).getString("cityName", "");
    String str2 = ((SharedPreferences)localObject2).getString("stateName", "");
    localObject2 = ((SharedPreferences)localObject2).getString("countryName", "");
    if ((str3.length() == 0) || (str2.length() == 0) || (((String)localObject2).length() == 0) || (str1.length() == 0) || ((((String)localObject1).length() == 0) && (!a.m(this.a))))
    {
      localObject1 = new y(this.a.getActivity());
      ((y)localObject1).a(2131165672);
      ((y)localObject1).c(2131165699);
      ((y)localObject1).b(2131165674);
      ((y)localObject1).a();
      return;
    }
    str3 = this.a.getString(2131165677) + str3 + ";<br/>";
    str2 = str3 + this.a.getString(2131165679) + str2 + ";<br/>";
    str2 = str2 + this.a.getString(2131165678) + (String)localObject2 + ";<br/>";
    str1 = str2 + this.a.getString(2131165676) + str1 + ";<br/>";
    localObject1 = Html.fromHtml(str1 + this.a.getString(2131165675) + (String)localObject1 + ".<br/>");
    a.a(this.a).setText((CharSequence)localObject1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      a.l(this.a).setClickable(paramBoolean);
      return;
      a.j(this.a).setText("");
    }
  }
  
  public int getCount()
  {
    return a.e(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return a.e(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    h localh;
    if (paramView == null)
    {
      paramViewGroup = new k(this.a);
      paramView = paramViewGroup.c;
      paramView.setTag(paramViewGroup);
      localh = (h)a.e(this.a).get(paramInt);
      paramViewGroup.b.setText(localh.b());
      paramViewGroup.a.setId(paramInt);
      if (!localh.b().equals(a.f(this.a).getText().toString())) {
        break label127;
      }
      paramViewGroup.a.setChecked(true);
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new j(this, paramViewGroup, localh));
      return paramView;
      paramViewGroup = (k)paramView.getTag();
      break;
      label127:
      paramViewGroup.a.setChecked(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */