package com.gtp.go.weather.sharephoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gtp.go.weather.sharephoto.b.j;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoReportActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private ListView d;
  private final ArrayList e = new ArrayList();
  private w f;
  private ArrayList g = new ArrayList();
  private long h = -1L;
  
  private void a()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {
      return;
    }
    this.h = localIntent.getLongExtra("photo_id", -1L);
  }
  
  private void a(ArrayList paramArrayList)
  {
    this.e.clear();
    if (paramArrayList != null)
    {
      if (b(paramArrayList)) {
        throw new IllegalArgumentException("choiceItemDatas have more than one be set to check!");
      }
      this.e.addAll(paramArrayList);
    }
    this.f.notifyDataSetChanged();
  }
  
  private void b()
  {
    this.d = ((ListView)findViewById(2131231824));
    this.f = new w(this, null);
    this.d.setAdapter(this.f);
    this.d.setOnItemClickListener(this);
    a locala1 = new a();
    locala1.b = true;
    locala1.a = getString(2131166369);
    a locala2 = new a();
    locala2.b = false;
    locala2.a = getString(2131166370);
    a locala3 = new a();
    locala3.b = false;
    locala3.a = getString(2131166371);
    a locala4 = new a();
    locala4.b = false;
    locala4.a = getString(2131166372);
    this.g.add(locala1);
    this.g.add(locala2);
    this.g.add(locala3);
    this.g.add(locala4);
    a(this.g);
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    boolean bool2 = false;
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramArrayList.hasNext())
      {
        if (((a)paramArrayList.next()).b)
        {
          int j = i + 1;
          i = j;
          if (j > 1) {
            bool1 = true;
          }
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  private void f()
  {
    if (this.h == -1L) {
      return;
    }
    j localj = new j();
    localj.a(this.h);
    localj.b(h() + 1);
    com.gtp.go.weather.sharephoto.c.d.a(this).a(localj);
  }
  
  private void g()
  {
    if (com.gtp.a.a.c.d.b(this))
    {
      Toast.makeText(this, getString(2131166374), 0).show();
      return;
    }
    Toast.makeText(this, getText(2131165656), 0).show();
  }
  
  private int h()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b) {
        return this.e.indexOf(locala);
      }
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a)) {
      finish();
    }
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        f();
        g();
        finish();
        return;
      }
    } while (!paramView.equals(this.c));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903258);
    a();
    this.a = ((ImageView)findViewById(2131231822));
    this.b = ((TextView)findViewById(2131231826));
    this.c = ((TextView)findViewById(2131231825));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    b();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((v)paramView.getTag()).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/PhotoReportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */