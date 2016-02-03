package com.pocket.list;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.ideashower.readitlater.activity.PocketActivity;
import com.ideashower.readitlater.activity.ad;
import com.ideashower.readitlater.activity.ai;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.al;
import com.ideashower.readitlater.db.operation.action.am;
import com.ideashower.readitlater.db.operation.action.c;
import com.ideashower.readitlater.db.operation.action.d;
import com.ideashower.readitlater.db.operation.action.k;
import com.ideashower.readitlater.db.operation.action.m;
import com.ideashower.readitlater.db.operation.action.s;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.h;
import java.util.ArrayList;
import java.util.Iterator;

public class a
  implements View.OnClickListener, h
{
  private final ai a;
  private final PocketActivity b;
  private final ToolbarLayout c;
  private com.pocket.list.adapter.a d;
  private StyledToolbar e;
  private StyledToolbar f;
  private RilButton g;
  private StyledIconButton h;
  private StyledIconButton i;
  private StyledIconButton j;
  private StyledIconButton k;
  private StyledIconButton l;
  private View m;
  private boolean n = false;
  private SparseArray o;
  private Bundle p;
  private final ArrayList q = new ArrayList();
  private TextView r;
  
  public a(ai paramai, ToolbarLayout paramToolbarLayout)
  {
    this.a = paramai;
    this.b = ((PocketActivity)paramai.m());
    this.c = paramToolbarLayout;
  }
  
  private UiContext a(o paramo)
  {
    return this.d.a(UiTrigger.g, paramo);
  }
  
  private s a(int paramInt, o paramo)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new com.ideashower.readitlater.db.operation.action.i(paramo, a(paramo));
    case 2: 
      return new d(true, paramo, a(paramo));
    case 3: 
      return new m(true, paramo, a(paramo));
    case 4: 
      return new m(false, paramo, a(paramo));
    }
    return new k(paramo, a(paramo));
  }
  
  private ArrayList a(int paramInt, SparseArray paramSparseArray)
  {
    int i2 = paramSparseArray.size();
    ArrayList localArrayList = new ArrayList(i2);
    int i1 = 0;
    if (i1 < i2)
    {
      o localo = (o)paramSparseArray.valueAt(i1);
      if (paramInt == 1) {
        localArrayList.add(new al(localo, UiContext.a(UiTrigger.h)));
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (paramInt == 5) {
          localArrayList.add(new am(localo, UiContext.a(UiTrigger.h), localo.al()));
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.o.size();
    ArrayList localArrayList = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      o localo = (o)this.o.valueAt(i1);
      if (paramBoolean1) {
        this.d.b().c(localo);
      }
      localArrayList.add(a(paramInt1, localo));
      i1 += 1;
    }
    c.a(localArrayList, true);
    this.a.Z();
    if (paramBoolean2) {
      Toast.makeText(this.b, this.b.getString(paramInt2, new Object[] { Integer.valueOf(i2) }), 1).show();
    }
    if (i2 > 0) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a(paramBoolean1);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    if (!this.n) {
      return;
    }
    this.a.g(false);
    this.n = false;
    this.e.setVisibility(8);
    this.e.clearAnimation();
    if (this.f != null) {
      this.c.b(false, true);
    }
    this.o.clear();
    Object localObject = this.d;
    if (paramBoolean) {}
    for (;;)
    {
      ((com.pocket.list.adapter.a)localObject).b(i1);
      localObject = this.q.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).b();
      }
      break;
      i1 = -1;
    }
  }
  
  private void f()
  {
    boolean bool = j.c();
    Object localObject = LayoutInflater.from(this.b);
    int i1;
    if (bool)
    {
      i1 = 2130903074;
      this.e = ((StyledToolbar)((LayoutInflater)localObject).inflate(i1, null, false));
      this.e.setIsTopToolbar(true);
      localObject = new RelativeLayout.LayoutParams(-1, (int)this.e.getResources().getDimension(2131296395));
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.c.addView(this.e);
      this.r = ((TextView)this.e.findViewById(2131230768));
      this.g = ((RilButton)this.e.findViewById(2131230908));
      this.g.setOnClickListener(this);
      if (!bool)
      {
        this.f = ((StyledToolbar)LayoutInflater.from(this.b).inflate(2130903073, null, false));
        this.c.setBottomToolbar(this.f);
        this.m = this.f.findViewById(2131230904);
      }
      if (!bool) {
        break label348;
      }
    }
    label348:
    for (localObject = this.e;; localObject = this.f)
    {
      this.h = ((StyledIconButton)((View)localObject).findViewById(2131230856));
      this.h.setOnClickListener(this);
      this.h.setTooltip(2131493344);
      this.i = ((StyledIconButton)((View)localObject).findViewById(2131230905));
      this.i.setOnClickListener(this);
      this.i.setTooltip(2131493348);
      this.j = ((StyledIconButton)((View)localObject).findViewById(2131230906));
      this.j.setOnClickListener(this);
      this.k = ((StyledIconButton)((View)localObject).findViewById(2131230907));
      this.k.setOnClickListener(this);
      this.k.setTooltip(2131493345);
      this.l = ((StyledIconButton)((View)localObject).findViewById(2131230744));
      this.l.setOnClickListener(this);
      this.l.setTooltip(2131493343);
      return;
      i1 = 2130903075;
      break;
    }
  }
  
  private void g()
  {
    boolean bool2 = true;
    int i5 = this.o.size();
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    if (i3 < i5)
    {
      int i4;
      switch (((o)this.o.valueAt(i3)).al())
      {
      default: 
        i4 = i2;
        i2 = i1;
        i1 = i4;
      }
      for (;;)
      {
        i4 = i3 + 1;
        i3 = i2;
        i2 = i1;
        i1 = i3;
        i3 = i4;
        break;
        i4 = i2 + 1;
        i2 = i1;
        i1 = i4;
        continue;
        i4 = i1 + 1;
        i1 = i2;
        i2 = i4;
      }
    }
    TextView localTextView = this.r;
    Object localObject;
    if (i5 > 0)
    {
      localObject = i5 + " " + this.a.n().getQuantityString(2131427329, i5);
      localTextView.setText((CharSequence)localObject);
      localObject = this.h;
      if ((i5 <= 0) || (i1 != 0)) {
        break label300;
      }
      bool1 = true;
      label188:
      ((StyledIconButton)localObject).setEnabled(bool1);
      localObject = this.i;
      if ((i5 <= 0) || (i2 != 0)) {
        break label306;
      }
      bool1 = true;
      label213:
      ((StyledIconButton)localObject).setEnabled(bool1);
      localObject = this.j;
      if (i5 <= 0) {
        break label312;
      }
      bool1 = true;
      label234:
      ((StyledIconButton)localObject).setEnabled(bool1);
      localObject = this.k;
      if (i5 <= 0) {
        break label318;
      }
      bool1 = true;
      label255:
      ((StyledIconButton)localObject).setEnabled(bool1);
      localObject = this.l;
      if (i5 <= 0) {
        break label324;
      }
    }
    label300:
    label306:
    label312:
    label318:
    label324:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((StyledIconButton)localObject).setEnabled(bool1);
      return;
      localObject = this.a.a(2131493325);
      break;
      bool1 = false;
      break label188;
      bool1 = false;
      break label213;
      bool1 = false;
      break label234;
      bool1 = false;
      break label255;
    }
  }
  
  public void a()
  {
    if (this.p != null)
    {
      int[] arrayOfInt = this.p.getIntArray("stateSelections");
      int i2 = arrayOfInt.length;
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = arrayOfInt[i1];
        o localo = this.d.b().d(i3);
        if (localo != null) {
          a(i3, localo, true);
        }
        i1 += 1;
      }
      this.p = null;
      this.d.b(-1);
    }
  }
  
  public void a(int paramInt, o paramo, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.o.put(paramInt, paramo);
    }
    for (;;)
    {
      g();
      return;
      this.o.delete(paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.n)
    {
      paramBundle.putBoolean("stateIsBulkEditing", true);
      int i2 = this.o.size();
      int[] arrayOfInt = new int[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfInt[i1] = this.o.keyAt(i1);
        i1 += 1;
      }
      paramBundle.putIntArray("stateSelections", arrayOfInt);
    }
  }
  
  public void a(b paramb)
  {
    this.q.add(paramb);
  }
  
  public boolean a(int paramInt)
  {
    if (!this.n) {}
    while (this.o.get(paramInt) == null) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    boolean bool2 = false;
    if (this.n) {
      return;
    }
    if (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aD))
    {
      this.a.g(true);
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aD, true).a();
    }
    this.n = true;
    if (this.e == null) {
      f();
    }
    this.e.setVisibility(0);
    this.d = this.a.ae();
    this.d.a(this);
    Object localObject1 = this.d.c();
    Object localObject2 = this.h;
    boolean bool1;
    if ((!((ItemQuery)localObject1).f()) || (((ItemQuery)localObject1).e().intValue() != 1))
    {
      bool1 = true;
      label121:
      z.c((View)localObject2, bool1);
      localObject2 = this.i;
      if ((((ItemQuery)localObject1).f()) && (((ItemQuery)localObject1).e().intValue() == 0)) {
        break label326;
      }
      bool1 = true;
      label154:
      z.c((View)localObject2, bool1);
      localObject2 = this.m;
      bool1 = bool2;
      if (this.h.getVisibility() == 0)
      {
        bool1 = bool2;
        if (this.i.getVisibility() == 0) {
          bool1 = true;
        }
      }
      z.c((View)localObject2, bool1);
      localObject2 = this.j;
      if (!((ItemQuery)localObject1).w()) {
        break label331;
      }
    }
    label326:
    label331:
    for (int i1 = 2131493352;; i1 = 2131493346)
    {
      ((StyledIconButton)localObject2).setTooltip(i1);
      if (this.f != null)
      {
        this.c.b(true, true);
        this.f.post(new Runnable()
        {
          public void run()
          {
            a.a(a.this).requestLayout();
            a.a(a.this).invalidate();
          }
        });
      }
      if (this.o == null) {
        this.o = new SparseArray();
      }
      g();
      this.d.b(-1);
      localObject1 = this.q.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b)((Iterator)localObject1).next()).a();
      }
      break;
      bool1 = false;
      break label121;
      bool1 = false;
      break label154;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("stateIsBulkEditing"))
    {
      if (this.p == null) {
        this.p = new Bundle();
      }
      this.p.putIntArray("stateSelections", paramBundle.getIntArray("stateSelections"));
      b();
      this.d.a(this);
    }
  }
  
  public void c()
  {
    a(false);
  }
  
  public boolean d()
  {
    return this.n;
  }
  
  public void e()
  {
    if (!this.n) {
      return;
    }
    int i1 = this.o.size();
    int i2 = 0;
    if (i2 < i1)
    {
      if (this.d.b().d(this.o.keyAt(i2)) != null) {
        break label88;
      }
      a(this.o.keyAt(i2), (o)this.o.valueAt(i2), false);
      i2 -= 1;
      i1 -= 1;
    }
    label88:
    for (;;)
    {
      i2 += 1;
      break;
      g();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramView == this.g)
    {
      c();
      return;
    }
    Object localObject = this.d.c();
    if (paramView == this.h)
    {
      if ((((ItemQuery)localObject).f()) && (((ItemQuery)localObject).e().intValue() == 0)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramView = this.o;
        com.pocket.widget.undobar.a.a(this.b, a(1, paramView));
        a(1, 2131493736, bool1, false);
        return;
      }
    }
    int i2;
    int i1;
    if (paramView == this.i)
    {
      i2 = 2;
      bool1 = bool2;
      if (((ItemQuery)localObject).f())
      {
        bool1 = bool2;
        if (((ItemQuery)localObject).e().intValue() == 1) {
          bool1 = true;
        }
      }
      i1 = 2131493739;
    }
    for (;;)
    {
      a(i2, i1, bool1, true);
      return;
      if (paramView != this.j) {
        break;
      }
      if (((ItemQuery)localObject).w())
      {
        i1 = 2131493741;
        i2 = 4;
        bool1 = true;
      }
      else
      {
        i2 = 3;
        i1 = 2131493738;
      }
    }
    if (paramView == this.k)
    {
      paramView = this.o;
      com.pocket.widget.undobar.a.a(this.b, a(5, paramView));
      a(5, 2131493737, true, false);
      return;
    }
    if (paramView == this.l)
    {
      i2 = this.o.size();
      paramView = new ArrayList(i2);
      localObject = new ArrayList(i2);
      i1 = 0;
      while (i1 < i2)
      {
        o localo = (o)this.o.valueAt(i1);
        paramView.add(localo.i());
        ((ArrayList)localObject).add(a(localo));
        i1 += 1;
      }
      paramView = ad.a(paramView, (ArrayList)localObject);
      ad.a(this.b, paramView);
      a(false);
      return;
    }
    throw new RuntimeException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */