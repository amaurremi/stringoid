package com.go.weatherex.themestore.detail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.a.a;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.imageload.p;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ad;

public class e
{
  private n a;
  private boolean b = false;
  private c c;
  private u d;
  
  public e(u paramu, Object paramObject, c paramc)
  {
    this.d = paramu;
    this.c = paramc;
    a(paramObject);
  }
  
  private void a(int paramInt)
  {
    if (this.a != null) {
      return;
    }
    if (paramInt == 1) {}
    for (this.a = new b(this.d);; this.a = new g(this.d))
    {
      this.a.a(this.c);
      return;
    }
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof com.jiubang.playsdk.e.e)) {
      a(1);
    }
    do
    {
      while ((this.a instanceof b))
      {
        if ((paramObject instanceof com.jiubang.playsdk.e.e)) {
          ((b)this.a).a((com.jiubang.playsdk.e.e)paramObject);
        }
        return;
        if ((paramObject instanceof a)) {
          a(2);
        }
      }
    } while ((!(this.a instanceof g)) || (!(paramObject instanceof a)));
    ((g)this.a).a((a)paramObject);
  }
  
  public View a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (this.a != null) {
      return this.a.a(paramArrayOfInt1, paramArrayOfInt2);
    }
    return null;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.i();
    }
    if (this.b)
    {
      aa.a().c();
      p.a().b();
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener, View.OnClickListener paramOnClickListener, ad paramad)
  {
    if (this.a != null) {
      this.a.a(paramOnItemClickListener, paramOnClickListener, paramad);
    }
  }
  
  public void b()
  {
    if ((this.a instanceof g)) {
      ((g)this.a).m();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */