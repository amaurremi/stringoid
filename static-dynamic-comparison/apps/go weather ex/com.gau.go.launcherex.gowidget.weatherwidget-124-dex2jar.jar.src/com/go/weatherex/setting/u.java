package com.go.weatherex.setting;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.statistics.z;
import com.gau.go.launcherex.gowidget.weather.b.ax;

class u
  extends AsyncTask
{
  String a = "";
  String b;
  int c = 1;
  
  private u(q paramq) {}
  
  protected String a(String... paramVarArgs)
  {
    this.a = this.d.c();
    this.c = this.d.d();
    return ax.a(this.d.getActivity().getApplicationContext()).a(2, this.a, this.c, 2);
  }
  
  protected void a(String paramString)
  {
    super.onPostExecute(paramString);
    if ((!q.a(this.d)) && (q.b(this.d) != null)) {
      q.b(this.d).dismiss();
    }
    if ((q.c(this.d)) && (!q.a(this.d)))
    {
      if (paramString == null) {
        break label244;
      }
      paramString = z.a(paramString);
      if (paramString.a == -1) {
        Toast.makeText(this.d.getActivity(), 2131165365, 0).show();
      }
    }
    else
    {
      return;
    }
    if ((paramString.a == 2) || ((paramString.a == 3) && (paramString.g > 0) && (paramString.g != y.e(this.d.getActivity()))))
    {
      this.b = paramString.c;
      q.a(this.d, paramString.b, this.b);
      q.d(this.d).edit().putBoolean("key_has_new_version", true).commit();
      q.e(this.d).setVisibility(0);
      return;
    }
    q.d(this.d).edit().putBoolean("key_has_new_version", false).commit();
    q.e(this.d).setVisibility(4);
    Toast.makeText(this.d.getActivity(), 2131165366, 0).show();
    return;
    label244:
    Toast.makeText(this.d.getActivity(), 2131165365, 0).show();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    q.a(this.d, true);
    if ((!q.a(this.d)) && (q.b(this.d) != null)) {
      q.b(this.d).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */