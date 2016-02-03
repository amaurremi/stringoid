package com.pocket.list.widget.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.pocket.i.a.k;
import com.pocket.list.widget.b.b;
import java.util.ArrayList;

public class c
  extends ResizeDetectRelativeLayout
  implements View.OnClickListener
{
  public static final int a = j.a(320.0F);
  private static final ArrayList b = new ArrayList();
  private com.pocket.list.widget.b.a c;
  private d d;
  private ViewGroup e;
  private StyledIconButton f;
  private StyledIconButton g;
  private StyledIconButton h;
  private StyledIconButton i;
  private StyledIconButton j;
  private StyledIconButton k;
  private final int l;
  private boolean m = false;
  private a n;
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.l = paramInt;
  }
  
  public static void b()
  {
    if (b.isEmpty()) {}
    for (;;)
    {
      return;
      while (!b.isEmpty()) {
        ((c)b.remove(0)).a();
      }
    }
  }
  
  public void a()
  {
    if (this.m) {
      return;
    }
    this.m = true;
    this.n.b();
  }
  
  public void a(com.pocket.list.widget.b.a parama)
  {
    setEnabled(true);
    b();
    b.add(this);
    this.c = parama;
    int i3 = parama.getWidth();
    int i4 = parama.getHeight();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
    int i2;
    int i1;
    switch (this.l)
    {
    default: 
      throw new RuntimeException("invalid layout type");
    case 2: 
      localLayoutParams.width = j.a(80.0F);
      localLayoutParams.height = i4;
      i2 = localLayoutParams.width;
      i1 = 2130903092;
      this.e = ((ViewGroup)LayoutInflater.from(getContext()).inflate(i1, null, false));
      if (this.l == 1)
      {
        setBackgroundResource(2130837781);
        this.e.setBackgroundDrawable(null);
        localLayoutParams.addRule(13);
        label165:
        this.e.setLayoutParams(localLayoutParams);
        addView(this.e);
        this.f = ((StyledIconButton)this.e.findViewById(2131230933));
        this.g = ((StyledIconButton)this.e.findViewById(2131230934));
        this.h = ((StyledIconButton)this.e.findViewById(2131230935));
        this.i = ((StyledIconButton)this.e.findViewById(2131230936));
        this.j = ((StyledIconButton)this.e.findViewById(2131230937));
        this.k = ((StyledIconButton)this.e.findViewById(2131230938));
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.g.setCheckedUseSourceImage(true);
        this.g.setCheckable(true);
        this.i.setCheckedUseSourceImage(true);
        this.i.setCheckable(true);
        if (parama.getItem().ae()) {
          this.i.setChecked(true);
        }
        if (parama.getItem().al() != 0) {
          break label652;
        }
        this.e.findViewById(2131230934).setVisibility(0);
        this.e.findViewById(2131230935).setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      parama.setIsOpen(this);
      z.a(parama, this);
      parama.setLayoutParams(new RelativeLayout.LayoutParams(i3, i4));
      this.d = new d(this, getContext());
      this.d.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      this.d.addView(parama);
      addView(this.d);
      this.n = a.a(this);
      this.n.a(i2);
      return;
      localLayoutParams.height = ((int)getResources().getDimension(2131296395));
      localLayoutParams.width = -1;
      i1 = 2130903091;
      i2 = i3;
      break;
      localLayoutParams.width = parama.getWidth();
      localLayoutParams.height = parama.getHeight();
      i1 = 2130903093;
      i2 = i3;
      break;
      if (this.l == 4)
      {
        setBackgroundDrawable(new k(getResources(), 0, 2131165781, Math.max(1, j.a(1.0F))));
        localLayoutParams.addRule(13);
        break label165;
      }
      this.e.setBackgroundDrawable(new k(getResources(), 0, 2131165781, Math.max(1, j.a(1.0F))));
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      break label165;
      label652:
      this.e.findViewById(2131230934).setVisibility(8);
      this.e.findViewById(2131230935).setVisibility(0);
    }
  }
  
  public com.pocket.list.widget.b.a c()
  {
    this.m = true;
    this.d.clearAnimation();
    this.n.c();
    this.c.setIsOpen(null);
    this.d.removeView(this.c);
    z.a(this, this.c);
    com.pocket.list.widget.b.a locala = this.c;
    this.c = null;
    return locala;
  }
  
  public void d()
  {
    if (this.c != null) {
      c();
    }
  }
  
  public void e() {}
  
  public d getCellHolder()
  {
    return this.d;
  }
  
  public void onClick(View paramView)
  {
    if (!isEnabled()) {}
    o localo;
    b localb;
    do
    {
      return;
      setEnabled(false);
      localo = this.c.getItem();
      localb = this.c.getListener();
      if (paramView == this.f)
      {
        localb.a(localo, this, this.c);
        return;
      }
      if (paramView == this.g)
      {
        localb.b(localo, this, this.c);
        return;
      }
      if (paramView == this.h)
      {
        localb.c(localo, this, this.c);
        return;
      }
      if (paramView == this.i)
      {
        localb.d(localo, this, this.c);
        return;
      }
      if (paramView == this.j)
      {
        localb.e(localo, this, this.c);
        return;
      }
    } while (paramView != this.k);
    localb.f(localo, this, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */