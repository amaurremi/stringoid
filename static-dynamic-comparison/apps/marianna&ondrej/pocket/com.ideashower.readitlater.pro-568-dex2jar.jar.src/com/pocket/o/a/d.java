package com.pocket.o.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.activity.al;

public class d
  extends i
  implements View.OnClickListener
{
  private final View a = LayoutInflater.from(g()).inflate(2130903186, null);
  private CharSequence b;
  private boolean c;
  
  public d(l paraml, k paramk, Context paramContext)
  {
    super(paraml, paramk, paramContext);
    ((TextView)this.a.findViewById(2131231142)).setText(2131493339);
    this.a.setEnabled(true);
    this.a.setClickable(true);
    this.a.setOnClickListener(this);
  }
  
  public ListAdapter a()
  {
    return null;
  }
  
  public void a(j paramj)
  {
    c();
    paramj.b();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    c();
  }
  
  public void a(String paramString) {}
  
  public View b()
  {
    return this.a;
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    if ((TextUtils.isEmpty(this.b)) && (!as.m()) && (com.ideashower.readitlater.a.f.a()))
    {
      a(true);
      if (!this.c)
      {
        this.c = true;
        com.pocket.stats.d.c.a(null, "tags");
      }
      return;
    }
    a(false);
  }
  
  public void i(boolean paramBoolean)
  {
    c();
  }
  
  public void onClick(View paramView)
  {
    al.a((android.support.v4.app.f)g(), 2, "tags");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */