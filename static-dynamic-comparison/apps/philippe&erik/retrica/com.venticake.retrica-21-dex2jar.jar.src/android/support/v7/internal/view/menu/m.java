package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.b.h;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public class m
  implements ab, AdapterView.OnItemClickListener
{
  Context a;
  LayoutInflater b;
  o c;
  ExpandedMenuView d;
  int e;
  int f;
  n g;
  private int h;
  private ac i;
  
  public m(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.e = paramInt2;
  }
  
  public ad a(ViewGroup paramViewGroup)
  {
    if (this.g == null) {
      this.g = new n(this);
    }
    if (!this.g.isEmpty())
    {
      if (this.d == null)
      {
        this.d = ((ExpandedMenuView)this.b.inflate(h.abc_expanded_menu_layout, paramViewGroup, false));
        this.d.setAdapter(this.g);
        this.d.setOnItemClickListener(this);
      }
      return this.d;
    }
    return null;
  }
  
  public ListAdapter a()
  {
    if (this.g == null) {
      this.g = new n(this);
    }
    return this.g;
  }
  
  public void a(Context paramContext, o paramo)
  {
    if (this.e != 0)
    {
      this.a = new ContextThemeWrapper(paramContext, this.e);
      this.b = LayoutInflater.from(this.a);
    }
    for (;;)
    {
      this.c = paramo;
      if (this.g != null) {
        this.g.notifyDataSetChanged();
      }
      return;
      if (this.a != null)
      {
        this.a = paramContext;
        if (this.b == null) {
          this.b = LayoutInflater.from(this.a);
        }
      }
    }
  }
  
  public void a(ac paramac)
  {
    this.i = paramac;
  }
  
  public void a(o paramo, boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.a(paramo, paramBoolean);
    }
  }
  
  public boolean a(ah paramah)
  {
    if (!paramah.hasVisibleItems()) {
      return false;
    }
    new r(paramah).a(null);
    if (this.i != null) {
      this.i.b(paramah);
    }
    return true;
  }
  
  public boolean a(o paramo, s params)
  {
    return false;
  }
  
  public boolean b(o paramo, s params)
  {
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.notifyDataSetChanged();
    }
  }
  
  public boolean g()
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c.a(this.g.a(paramInt), 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */