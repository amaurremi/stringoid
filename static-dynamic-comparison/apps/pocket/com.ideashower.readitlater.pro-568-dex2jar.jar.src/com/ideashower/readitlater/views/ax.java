package com.ideashower.readitlater.views;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.ThemedIconButton;

public class ax
{
  private final View b;
  private final ThemedIconButton c;
  private final TextView d;
  private aw e;
  
  protected ax(ThemedSpinner paramThemedSpinner, View paramView)
  {
    this.b = paramView;
    this.d = ((TextView)this.b.findViewById(2131230902));
    this.c = ((ThemedIconButton)this.b.findViewById(2131230792));
    if (this.c != null)
    {
      this.c.b();
      if (a.d()) {
        this.c.a(0);
      }
    }
  }
  
  private void a()
  {
    this.d.setVisibility(0);
    a(aw.b(this.e));
    c((int)this.a.getResources().getDimension(2131296393));
    b(j.a(48.0F));
    this.b.setPadding(0, 0, 0, 0);
  }
  
  private void a(int paramInt)
  {
    if (this.c != null)
    {
      if (paramInt != 0)
      {
        this.c.setImageResource(paramInt);
        this.c.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void b()
  {
    int i;
    int j;
    if (this.a.a == 2)
    {
      a(aw.b(this.e));
      this.d.setVisibility(8);
      c((int)this.a.getResources().getDimension(2131296393));
      i = 0;
      j = 0;
    }
    for (;;)
    {
      b(-2);
      this.b.setPadding(j, 0, i, 0);
      return;
      if (aw.c(this.e) != 0)
      {
        a(aw.c(this.e));
        this.d.setVisibility(8);
        c(-2);
        i = j.a(4.0F);
        j = 0;
      }
      else
      {
        j = j.a(10.5F);
        i = j.a(14.5F);
        this.d.setVisibility(0);
        c();
      }
    }
  }
  
  private void b(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    localLayoutParams.height = paramInt;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void c()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
  }
  
  private void c(int paramInt)
  {
    if (this.c == null) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = this.c.getLayoutParams();
    } while (localLayoutParams == null);
    localLayoutParams.width = paramInt;
    this.c.setLayoutParams(localLayoutParams);
  }
  
  protected void a(aw paramaw, boolean paramBoolean)
  {
    this.e = paramaw;
    this.d.setText(aw.a(paramaw));
    if (paramBoolean) {
      a();
    }
    for (;;)
    {
      if (a.e()) {
        this.d.setTextSize(1, 18.0F);
      }
      return;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */