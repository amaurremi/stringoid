package com.go.weatherex.e;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.messagecenter.util.ae;
import com.gau.go.launcherex.gowidget.messagecenter.util.ag;
import com.gau.go.launcherex.gowidget.messagecenter.util.i;
import com.gau.go.launcherex.gowidget.messagecenter.util.m;
import com.gau.go.launcherex.gowidget.messagecenter.view.GCMMsgDetailActivity;
import com.gau.go.launcherex.gowidget.messagecenter.view.HtmlMsgDetailActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class a
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, AdapterView.OnItemClickListener, ag, com.gau.go.launcherex.gowidget.messagecenter.util.b
{
  private View a;
  private ListView b = null;
  private LinearLayout c = null;
  private c d = null;
  private m e;
  private com.gau.go.launcherex.gowidget.messagecenter.a.c f;
  private Vector g;
  private TextView h;
  private com.jiubang.core.b.a i;
  private Button j;
  
  private void a(int paramInt)
  {
    this.j.setVisibility(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.h.setText(2131165999);
      return;
    }
    this.h.setText(getString(2131165999) + "(" + paramInt1 + "/" + paramInt2 + ")");
  }
  
  private void a(String paramString)
  {
    ae.a(getActivity()).a(paramString);
  }
  
  private void b()
  {
    if (this.g.isEmpty())
    {
      this.c.setVisibility(0);
      this.b.setVisibility(8);
      return;
    }
    this.c.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  private void b(d paramd)
  {
    Intent localIntent = new Intent(getActivity(), HtmlMsgDetailActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extras_bundle_msg_id", paramd.a);
    localBundle.putString("extras_bundle_msg_url", paramd.e);
    localBundle.putString("extras_bundle_msg_title", paramd.b);
    localBundle.putString("extras_bundle_msg_pubished_time", paramd.d);
    localIntent.putExtra("weather_alerts_lists_entrance", "application");
    localIntent.putExtras(localBundle);
    startActivity(localIntent);
    m.a(getActivity()).b(paramd.a, 1);
  }
  
  private void c(d paramd)
  {
    if (paramd != null) {
      switch (paramd.c)
      {
      default: 
        this.e.a(paramd, 1, getActivity(), true);
      }
    }
    for (;;)
    {
      this.e.b(paramd);
      i.b(this.g);
      this.d.notifyDataSetChanged();
      a(i.a(this.g), this.g.size());
      a(paramd.a);
      return;
      b(paramd);
      continue;
      if (!TextUtils.isEmpty(paramd.e))
      {
        b(paramd);
      }
      else
      {
        this.e.a(paramd, 1, getActivity(), true);
        continue;
        Intent localIntent = new Intent(getActivity(), GCMMsgDetailActivity.class);
        localIntent.putExtra("extras_bundle_msg_id", paramd.a);
        localIntent.putExtra("extras_bundle_msg_title", paramd.b);
        localIntent.putExtra("extras_bundle_msg_summary", paramd.i);
        localIntent.putExtra("extras_bundle_msg_time", paramd.d);
        localIntent.putExtra("weather_alerts_lists_entrance", "application");
        startActivity(localIntent);
      }
    }
  }
  
  private boolean c()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      if (((d)localIterator.next()).y) {
        return true;
      }
    }
    return false;
  }
  
  private d d()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!locald.y) {
        return locald;
      }
    }
    return null;
  }
  
  private void j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = this.g.size();
    int k = 0;
    while (k < m)
    {
      localObject = (d)this.g.get(k);
      if (!((d)localObject).y)
      {
        localStringBuilder.append(((d)localObject).a);
        if (k != m - 1) {
          localStringBuilder.append("#");
        }
      }
      k += 1;
    }
    Object localObject = this.i.a().edit();
    ((SharedPreferences.Editor)localObject).putString("key_message_center_reminded", localStringBuilder.toString());
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject, List paramList)
  {
    this.f = ((com.gau.go.launcherex.gowidget.messagecenter.a.c)paramObject);
    if (this.f != null)
    {
      this.g = this.f.a();
      this.d.notifyDataSetChanged();
      a(i.a(this.g), this.g.size());
    }
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity = new com.gau.go.launcherex.gowidget.weather.globalview.b(paramActivity);
    paramActivity.b(2131166004);
    paramActivity.c(2131166005);
    paramActivity.a(new b(this));
    paramActivity.b();
  }
  
  public void a(com.gau.go.launcherex.gowidget.messagecenter.a.c paramc)
  {
    if (paramc == null) {}
    for (this.f = new com.gau.go.launcherex.gowidget.messagecenter.a.c();; this.f = paramc)
    {
      this.g = this.f.a();
      this.d.notifyDataSetChanged();
      a(i.a(this.g), this.g.size());
      b();
      j();
      if (!this.g.isEmpty())
      {
        paramc = d();
        if (paramc != null) {
          c(paramc);
        }
      }
      return;
    }
  }
  
  public void a(d paramd) {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a = c(2131231370);
    this.a.setOnClickListener(this);
    this.b = ((ListView)c(2131231373));
    this.d = new c(this);
    this.b.setAdapter(this.d);
    this.b.setOnItemClickListener(this);
    this.c = ((LinearLayout)c(2131231374));
    this.h = ((TextView)c(2131231371));
    this.i = GoWidgetApplication.c(getActivity().getApplicationContext());
    this.j = ((Button)c(2131231372));
    this.j.setOnClickListener(this);
    this.e = m.a(getActivity().getApplicationContext());
    this.e.a(this);
    this.e.b(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a)) {
      h();
    }
    while (!paramView.equals(this.j)) {
      return;
    }
    a(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903146, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    if (this.e != null) {
      this.e.b(this);
    }
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    c((d)paramAdapterView.getItemAtPosition(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */