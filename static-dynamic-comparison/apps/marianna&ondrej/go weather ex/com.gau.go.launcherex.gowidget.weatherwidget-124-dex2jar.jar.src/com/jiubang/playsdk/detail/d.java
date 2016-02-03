package com.jiubang.playsdk.detail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.imageload.p;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.t;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ad;

public class d
{
  private t a;
  private boolean b = false;
  private c c;
  private u d;
  
  public d(u paramu, Object paramObject, c paramc)
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
    for (this.a = new a(this.d);; this.a = new f(this.d))
    {
      this.a.a(this.c);
      return;
    }
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof e)) {
      a(1);
    }
    do
    {
      while ((this.a instanceof a))
      {
        if ((paramObject instanceof e)) {
          ((a)this.a).a((e)paramObject);
        }
        return;
        if ((paramObject instanceof com.jiubang.playsdk.a.a)) {
          a(2);
        }
      }
    } while ((!(this.a instanceof f)) || (!(paramObject instanceof com.jiubang.playsdk.a.a)));
    ((f)this.a).a((com.jiubang.playsdk.a.a)paramObject);
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
    if ((this.a instanceof f)) {
      ((f)this.a).m();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */