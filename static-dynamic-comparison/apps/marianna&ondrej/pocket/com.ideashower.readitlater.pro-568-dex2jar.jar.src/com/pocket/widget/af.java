package com.pocket.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.ideashower.readitlater.activity.f;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.b;
import com.ideashower.readitlater.db.operation.action.r;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.objects.h;
import java.util.ArrayList;

public abstract class af
  extends g
{
  private final View.OnClickListener a;
  protected h g = new h();
  protected ArrayList h = new ArrayList();
  protected final String i;
  protected final UiTrigger j;
  private final View.OnClickListener k;
  
  public af(f paramf, com.pocket.list.g paramg, ListView paramListView, Context paramContext, UiTrigger paramUiTrigger, String paramString)
  {
    super(paramf, paramg, paramListView, paramContext);
    this.j = paramUiTrigger;
    this.i = paramString;
    this.k = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ag localag = (ag)paramAnonymousView.getTag();
        af.this.b(localag, paramAnonymousView);
      }
    };
    this.a = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ag localag = (ag)paramAnonymousView.getTag();
        af.this.a(localag, paramAnonymousView);
      }
    };
  }
  
  public int a(com.ideashower.readitlater.e.c paramc)
  {
    return this.h.indexOf(paramc);
  }
  
  protected void a(ag paramag, View paramView)
  {
    g();
    new r((x)paramag.b(), paramag.a(), d(paramag.y)).j();
    a(this.h.indexOf(paramag.v), paramag, null);
    x.k();
  }
  
  protected void b(int paramInt)
  {
    this.h.remove(paramInt);
  }
  
  protected void b(ag paramag, View paramView)
  {
    g();
    new b((x)paramag.b(), paramag.a(), d(paramag.y)).j();
  }
  
  public com.ideashower.readitlater.e.c c(int paramInt)
  {
    return (com.ideashower.readitlater.e.c)this.h.get(paramInt);
  }
  
  protected UiContext d(int paramInt)
  {
    return UiContext.a(this.i, this.j, paramInt);
  }
  
  protected void g()
  {
    h();
  }
  
  public int getCount()
  {
    return this.h.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void h()
  {
    int n = this.e.getChildCount();
    int m = 0;
    while (m < n)
    {
      View localView = this.e.getChildAt(m);
      Object localObject = localView.getTag();
      if ((localObject instanceof ag))
      {
        localObject = ((ag)localObject).v;
        if (((x)localObject).g() == 2) {
          this.f.a(localView, this.h.indexOf(localObject), null);
        }
      }
      m += 1;
    }
    x.k();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */