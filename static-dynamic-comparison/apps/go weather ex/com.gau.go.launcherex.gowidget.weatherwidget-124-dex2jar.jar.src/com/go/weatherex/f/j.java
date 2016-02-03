package com.go.weatherex.f;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.go.weatherex.framework.fragment.a;
import com.go.weatherex.framework.fragment.f;
import java.util.ArrayList;

public class j
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private Activity a;
  private View b;
  private ListView c;
  private l d;
  private ArrayList e;
  private final Handler f;
  private a g;
  
  public j(Activity paramActivity, a parama, Handler paramHandler)
  {
    this.a = paramActivity;
    this.g = parama;
    this.f = paramHandler;
    this.b = this.g.i().a(2130903272, null);
    this.c = ((ListView)this.b.findViewById(2131231892));
    this.d = new l(this, null);
    this.c.setAdapter(this.d);
    this.c.setOnItemClickListener(this);
    this.c.setOnScrollListener(this);
    this.e = new ArrayList();
    b();
  }
  
  private b a(String paramString)
  {
    paramString = paramString.split("#");
    if (paramString.length != 6) {
      return null;
    }
    String str1 = paramString[0];
    String str2 = paramString[1];
    String str3 = paramString[2];
    Object localObject = paramString[3];
    return new b(paramString[4], str1, str2, str3, paramString[5], str1 + ", " + str2 + ", (" + str3 + ")");
  }
  
  private void a(b paramb)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramb;
    this.f.sendMessage(localMessage);
  }
  
  private void b()
  {
    if (this.e.size() == 0)
    {
      String[] arrayOfString = this.a.getResources().getStringArray(2131558426);
      int i = 0;
      while (i < arrayOfString.length)
      {
        b localb = a(arrayOfString[i]);
        if (localb != null) {
          this.e.add(localb);
        }
        i += 1;
      }
    }
  }
  
  private void c()
  {
    this.f.sendEmptyMessage(3);
  }
  
  public View a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.e != null) && (paramInt >= 0) && (paramInt < this.e.size())) {
      a((b)this.e.get(paramInt));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */