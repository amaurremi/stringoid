package com.pocket.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.q;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.pocket.i.a.h;
import com.pocket.p.w;
import java.util.ArrayList;

public class b
  extends ResizeDetectRelativeLayout
  implements AdapterView.OnItemClickListener, l
{
  private static final c a = null;
  private static final boolean b = com.ideashower.readitlater.util.a.i();
  private g c;
  private final ListView d;
  private final ImageView e;
  private ArrayList f = new ArrayList(0);
  private final w g = new w();
  private final f h;
  private ViewGroup i;
  private c j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public b(Context paramContext)
  {
    super(paramContext);
    setBackgroundResource(2130837588);
    LayoutInflater.from(paramContext).inflate(2130903145, this, true);
    this.e = ((ImageView)findViewById(2131231060));
    ListView localListView = (ListView)findViewById(2131230754);
    localListView.setCacheColorHint(0);
    localListView.setVerticalFadingEdgeEnabled(false);
    localListView.setSelector(new ColorDrawable(0));
    localListView.setDivider(null);
    localListView.setDividerHeight(0);
    localListView.setChoiceMode(1);
    this.d = localListView;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    com.a.a.a.a locala = new com.a.a.a.a();
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(2130903147, null, false);
    if (j.c()) {}
    for (int n = getResources().getDimensionPixelSize(2131296308);; n = getResources().getDimensionPixelSize(2131296307))
    {
      paramContext.setTextSize(0, n);
      locala.a(paramContext);
      paramContext.setClickable(false);
      this.h = new f(this, null);
      locala.a(this.h);
      localListView.setAdapter(locala);
      localListView.setOnItemClickListener(this);
      setDisplay(c.a);
      b();
      return;
    }
  }
  
  private void d()
  {
    int i1 = this.f.size();
    int[] arrayOfInt = new int[i1];
    int n = 0;
    while (n < i1)
    {
      arrayOfInt[n] = e.a((e)this.f.get(n));
      n += 1;
    }
    if (i1 == 0) {
      return;
    }
    new q(UiContext.b(), arrayOfInt).j();
  }
  
  private void e()
  {
    d locald = new d(this, null);
    locald.a(this, true);
    locald.f();
  }
  
  private void f()
  {
    int i1 = 0;
    ImageView localImageView;
    if (((getWidth() != 0) && (getWidth() >= getHeight())) || ((this.j != c.b) || (this.l)))
    {
      n = 1;
      localImageView = this.e;
      if (n == 0) {
        break label61;
      }
    }
    label61:
    for (int n = i1;; n = 8)
    {
      localImageView.setVisibility(n);
      return;
      n = 0;
      break;
    }
  }
  
  private void setDisplay(c paramc)
  {
    if (paramc == this.j) {
      return;
    }
    this.j = paramc;
    if (paramc == c.a) {}
    for (;;)
    {
      f();
      return;
      if (paramc == c.b)
      {
        if (this.i != null) {
          this.i.setVisibility(8);
        }
        this.d.setVisibility(0);
        if (b)
        {
          this.l = true;
          com.b.c.c.a(this.e).k(0.0F).a(333L).a(new DecelerateInterpolator()).a(new com.pocket.b.b()
          {
            public void a(com.b.a.a paramAnonymousa)
            {
              b.a(b.this, false);
              com.b.c.a.a(b.a(b.this), 1.0F);
              b.a(b.this).clearAnimation();
              b.b(b.this);
            }
          });
        }
      }
      else
      {
        if (this.i == null)
        {
          this.i = ((ViewGroup)((ViewStub)findViewById(2131231061)).inflate());
          localObject = new h(getContext());
          ((Drawable)localObject).setState(this.d.getDrawableState());
          findViewById(2131230769).setBackgroundDrawable((Drawable)localObject);
        }
        this.i.setVisibility(0);
        this.d.setVisibility(8);
        Object localObject = (TextView)findViewById(2131230963);
        View localView1 = findViewById(2131231031);
        View localView2 = findViewById(2131230769);
        localView1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            com.ideashower.readitlater.a.g.a((Activity)b.this.getContext(), "http://help.getpocket.com/customer/portal/articles/1361990", true);
            if (b.c(b.this) != null) {
              b.c(b.this).b(b.this);
            }
          }
        });
        localView1.setVisibility(0);
        localView2.setVisibility(0);
        if (paramc == c.d) {
          ((TextView)localObject).setText(2131493249);
        } else {
          ((TextView)localObject).setText(2131493248);
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(k paramk, boolean paramBoolean)
  {
    if (((Activity)getContext()).isFinishing()) {
      return;
    }
    d locald = (d)paramk;
    if (paramBoolean)
    {
      paramk = d.a(locald);
      label28:
      this.f = paramk;
      this.h.notifyDataSetChanged();
      if (!paramk.isEmpty()) {
        break label137;
      }
      if ((!d.b(locald)) || (i.a(com.ideashower.readitlater.h.a.cd))) {
        break label127;
      }
      setDisplay(c.d);
    }
    for (;;)
    {
      if ((this.c != null) && (!this.k))
      {
        this.k = true;
        this.c.a(this);
      }
      if (!this.m) {
        break;
      }
      this.m = false;
      d();
      return;
      paramk = new ArrayList();
      break label28;
      label127:
      setDisplay(c.c);
      continue;
      label137:
      i.b(com.ideashower.readitlater.h.a.cd);
      setDisplay(c.b);
    }
  }
  
  public void b()
  {
    this.m = true;
    e();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      paramInt -= 1;
      paramAdapterView = (e)this.f.get(paramInt);
      this.d.setItemChecked(paramInt, true);
    } while (this.c == null);
    this.c.a(this, paramAdapterView.a(), paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    f();
  }
  
  public void setHighlightSelectedListener(g paramg)
  {
    this.c = paramg;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */