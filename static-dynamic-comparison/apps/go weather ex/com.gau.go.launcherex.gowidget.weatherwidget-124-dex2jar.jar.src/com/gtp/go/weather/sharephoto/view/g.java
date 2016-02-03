package com.gtp.go.weather.sharephoto.view;

import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gtp.go.weather.sharephoto.b.p;
import com.gtp.go.weather.sharephoto.c.a;
import com.gtp.go.weather.sharephoto.d.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

public class g
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private List c = new ArrayList();
  private f d;
  private a e;
  private m f;
  private c g;
  private n h;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
    this.f = new m(this);
    paramContext = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_FAVOUR_OR_BACKCOUNT");
    this.a.registerReceiver(this.f, paramContext);
    this.e = new h(this);
    com.gtp.go.weather.sharephoto.c.l.a(this.e);
  }
  
  private com.gtp.go.weather.sharephoto.b.h a(long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      com.gtp.go.weather.sharephoto.b.h localh = (com.gtp.go.weather.sharephoto.b.h)localIterator.next();
      if (localh.b(paramLong) != null) {
        return localh;
      }
    }
    return null;
  }
  
  private com.gtp.go.weather.sharephoto.b.h a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      com.gtp.go.weather.sharephoto.b.h localh = (com.gtp.go.weather.sharephoto.b.h)localIterator.next();
      if (localh.a().equals(paramString)) {
        return localh;
      }
    }
    return null;
  }
  
  private UserPhotoItem a(l paraml, p paramp)
  {
    return ((UserPhotoItem)this.b.inflate(2130903262, null)).a(paraml.a).a(this.g).a(paramp).a();
  }
  
  private void a(com.gtp.go.weather.sharephoto.b.h paramh, l paraml)
  {
    label65:
    UserPhotoItem localUserPhotoItem;
    if (paramh.d())
    {
      paraml.c.setText(this.a.getString(2131166386));
      paraml.b.setImageResource(2130838427);
      paraml.c.setTextColor(-16736279);
      paramh = paramh.b();
      paraml.d.removeAllViews();
      paramh = paramh.values().iterator();
      int i = 1;
      if (!paramh.hasNext()) {
        break label155;
      }
      localUserPhotoItem = a(paraml, (p)paramh.next());
      if (i == 0) {
        break label156;
      }
      localUserPhotoItem.a(false);
      i = 0;
    }
    label155:
    label156:
    for (;;)
    {
      localUserPhotoItem.a(this.d);
      paraml.d.addView(localUserPhotoItem);
      break label65;
      paraml.c.setText(paramh.a());
      paraml.b.setImageResource(2130838426);
      paraml.c.setTextColor(-6974059);
      break;
      return;
    }
  }
  
  private void b(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        paramList = a(localp.c());
        if (paramList == null)
        {
          String str = localp.i();
          localObject = a(str);
          paramList = (List)localObject;
          if (localObject == null)
          {
            paramList = new com.gtp.go.weather.sharephoto.b.h(str, localp.b());
            this.c.add(paramList);
          }
          paramList.a(localp);
        }
        else
        {
          paramList.a(localp);
        }
      }
      Collections.sort(this.c, new i(this));
      Object localObject = this.c.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramList = (com.gtp.go.weather.sharephoto.b.h)((Iterator)localObject).next();
      } while (paramList.e());
    }
    for (;;)
    {
      if (paramList != null)
      {
        paramList = (com.gtp.go.weather.sharephoto.b.h)this.c.get(0);
        paramList.a(new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(Long.valueOf(System.currentTimeMillis())).equals(paramList.a()));
      }
      return;
      paramList = null;
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.c.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((com.gtp.go.weather.sharephoto.b.h)localIterator.next()).b().size() + i) {}
    return i;
  }
  
  public com.gtp.go.weather.sharephoto.b.h a(int paramInt)
  {
    return (com.gtp.go.weather.sharephoto.b.h)this.c.get(paramInt);
  }
  
  public void a(long paramLong, View paramView, UserPhotoItem paramUserPhotoItem)
  {
    com.gtp.go.weather.sharephoto.b.h localh = a(paramUserPhotoItem.c());
    if (localh != null)
    {
      localh.a(paramLong);
      if (localh.c()) {
        b.a(new j(this, localh), paramView);
      }
    }
    else
    {
      return;
    }
    b.a(new k(this), paramUserPhotoItem);
  }
  
  public void a(c paramc)
  {
    this.g = paramc;
  }
  
  public void a(f paramf)
  {
    this.d = paramf;
  }
  
  public void a(n paramn)
  {
    this.h = paramn;
  }
  
  public void a(List paramList)
  {
    b(paramList);
  }
  
  public void b()
  {
    com.gtp.go.weather.sharephoto.c.l.b(this.e);
    this.a.unregisterReceiver(this.f);
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.gtp.go.weather.sharephoto.b.h localh = a(paramInt);
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903260, null);
      paramViewGroup = new l(this, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      a(localh, paramViewGroup);
      return paramView;
      paramViewGroup = (l)paramView.getTag();
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (this.h != null) {
      this.h.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */