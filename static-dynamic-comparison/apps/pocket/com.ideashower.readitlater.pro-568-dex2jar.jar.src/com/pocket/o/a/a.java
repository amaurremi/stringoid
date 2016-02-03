package com.pocket.o.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class a
  extends i
  implements View.OnClickListener
{
  private final View a = LayoutInflater.from(g()).inflate(2130903117, paramListView, false);
  private final TextView b = (TextView)this.a.findViewById(2131230984);
  private CharSequence c;
  
  public a(l paraml, k paramk, ListView paramListView)
  {
    super(paraml, paramk, paramListView.getContext());
    this.b.setTextColor(g().getResources().getColorStateList(2131165729));
    this.a.setOnClickListener(this);
  }
  
  public ListAdapter a()
  {
    return null;
  }
  
  public void a(j paramj)
  {
    a(this.c);
    paramj.b();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    if ((TextUtils.isEmpty(paramCharSequence)) || (f().a(paramCharSequence)))
    {
      this.b.setText("");
      a(false);
      return;
    }
    paramCharSequence = com.ideashower.readitlater.util.i.a(com.e.b.a.a(g().getResources(), 2131492867).a("name_of_tag", paramCharSequence).a());
    this.b.setText(paramCharSequence);
    a(true);
  }
  
  public void a(String paramString) {}
  
  public View b()
  {
    return this.a;
  }
  
  public void b(String paramString) {}
  
  public void i(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    paramView = this.c.toString();
    f().a(this, paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */