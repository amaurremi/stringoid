package com.pocket.o.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class b
  extends i
{
  private final View a = LayoutInflater.from(g()).inflate(2130903118, paramListView, false);
  private boolean b;
  private boolean c;
  
  public b(l paraml, k paramk, ListView paramListView)
  {
    super(paraml, paramk, paramListView.getContext());
  }
  
  private void c()
  {
    if ((this.b) && (!this.c)) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public ListAdapter a()
  {
    return null;
  }
  
  public void a(j paramj)
  {
    paramj.b();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      c();
      return;
    }
  }
  
  public void a(String paramString) {}
  
  protected void a(ArrayList paramArrayList)
  {
    this.b = paramArrayList.isEmpty();
    c();
  }
  
  public View b()
  {
    return this.a;
  }
  
  public void b(String paramString) {}
  
  public void i(boolean paramBoolean) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */