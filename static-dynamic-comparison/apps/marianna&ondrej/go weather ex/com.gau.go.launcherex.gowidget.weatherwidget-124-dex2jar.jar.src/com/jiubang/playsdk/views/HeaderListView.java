package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jiubang.playsdk.a.k;
import com.jiubang.playsdk.a.x;
import com.jiubang.playsdk.adapter.o;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.main.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeaderListView
  extends FrameLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, k, o, i, q, r
{
  private ListViewPage a;
  private x b;
  private Resources c;
  private List d = new ArrayList();
  private LayoutInflater e;
  private FrameLayout f;
  private LinearLayout g;
  private LinearLayout h;
  private int i;
  private int j;
  private long k;
  private ViewStub l;
  private com.jiubang.playsdk.e.d m;
  private com.jiubang.playsdk.e.d n;
  private com.jiubang.playsdk.e.d o;
  private com.jiubang.playsdk.adapter.d p;
  private boolean q = true;
  private FrameLayout r;
  private FrameLayout s;
  private LinearLayout t;
  private Handler u = new g(this);
  
  public HeaderListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ArrayList a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      e locale = (e)paramList.get(i1);
      if ((locale != null) && (locale.f() != null) && (!com.jiubang.playsdk.g.a.d(getContext(), locale.f().c()))) {
        localArrayList.add(locale);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      this.r.removeAllViews();
      com.jiubang.playsdk.g.a.a(paramView);
      this.r.addView(paramView);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Configuration localConfiguration = getResources().getConfiguration();
    Object localObject;
    if (paramBoolean)
    {
      localObject = (DependentAppView)this.e.inflate(com.jiubang.playsdk.g.g, null);
      ((DependentAppView)localObject).a(paramString);
      if (this.n.h() > 0)
      {
        paramString = this.n.a(0);
        if ((paramString != null) && (paramString.f() != null)) {
          ((DependentAppView)localObject).a(paramString.f().i());
        }
      }
      if (localConfiguration.orientation == 2)
      {
        ((DependentAppView)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, this.c.getDimensionPixelSize(com.jiubang.playsdk.d.i) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j)));
        ((DependentAppView)localObject).setPadding(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.r), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.s), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j));
      }
      for (;;)
      {
        if (localObject != null)
        {
          this.f.removeAllViews();
          this.f.addView((View)localObject);
        }
        return;
        ((DependentAppView)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, this.c.getDimensionPixelSize(com.jiubang.playsdk.d.h) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j)));
        ((DependentAppView)localObject).setPadding(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.t), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.u), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j));
      }
    }
    if ((this.o != null) && (this.b != null))
    {
      paramString = a.a(this.e, this.o, this.b).a();
      if ((paramString instanceof BannerView))
      {
        localObject = ((BannerView)paramString).b();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!com.jiubang.playsdk.g.a.d(getContext(), (String)localObject))) {
          if (localConfiguration.orientation == 2)
          {
            paramString.setLayoutParams(new AbsListView.LayoutParams(-1, this.c.getDimensionPixelSize(com.jiubang.playsdk.d.i) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j)));
            paramString.setPadding(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.r), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.s), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j));
          }
        }
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString != null) {
        break;
      }
      localObject = new View(getContext());
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k)));
      break;
      paramString.setLayoutParams(new AbsListView.LayoutParams(-1, this.c.getDimensionPixelSize(com.jiubang.playsdk.d.h) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k) + this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j)));
      paramString.setPadding(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.t), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.k), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.u), this.c.getDimensionPixelSize(com.jiubang.playsdk.d.j));
      continue;
      paramString = null;
    }
  }
  
  private void b(com.jiubang.playsdk.e.d paramd)
  {
    if (this.a != null)
    {
      this.a.a(null);
      removeView(this.a);
    }
    this.a = ((ListViewPage)this.e.inflate(com.jiubang.playsdk.g.m, null));
    this.a.a(this.q);
    this.a.setOnItemClickListener(this);
    addView(this.a, 0);
    this.d = a(paramd.f());
    this.f = new FrameLayout(getContext());
    this.f.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.a.addHeaderView(this.f, null, false);
    this.g = ((LinearLayout)this.e.inflate(com.jiubang.playsdk.g.r, null));
    LinearLayout localLinearLayout = (LinearLayout)this.g.findViewById(com.jiubang.playsdk.f.E);
    localLinearLayout.setBackgroundResource(com.jiubang.playsdk.a.aa.a().b().l());
    ((TextView)localLinearLayout.findViewById(com.jiubang.playsdk.f.F)).setTextColor(this.c.getColor(com.jiubang.playsdk.a.aa.a().b().k()));
    localLinearLayout.setOnClickListener(this);
    this.n = paramd;
    paramd = this.n.l();
    if ((!TextUtils.isEmpty(paramd)) && ("com.jb.gosms".equals(paramd)) && (!com.jiubang.playsdk.g.a.d(getContext(), paramd))) {
      a(true, paramd);
    }
    for (;;)
    {
      e();
      this.k = this.n.a();
      this.j = this.n.b();
      this.i = this.n.c();
      f();
      if ((this.d != null) && (this.d.size() > 0)) {
        break;
      }
      this.s.setVisibility(8);
      this.t.setVisibility(0);
      return;
      a(false, paramd);
    }
    this.s.setVisibility(0);
    this.t.setVisibility(8);
  }
  
  private void c(com.jiubang.playsdk.e.d paramd)
  {
    this.j = paramd.b();
    this.i = paramd.c();
    this.d.addAll(a(paramd.f()));
    this.p.a(this.d);
    f();
    this.a.b();
    c(false);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.l == null)
    {
      this.l = ((ViewStub)findViewById(com.jiubang.playsdk.f.T));
      this.l.inflate();
    }
    if (paramBoolean)
    {
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(4);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.r.getVisibility() == 8) {
        this.r.setVisibility(0);
      }
    }
    while (this.r.getVisibility() != 0) {
      return;
    }
    this.r.setVisibility(8);
  }
  
  private void e()
  {
    Configuration localConfiguration = getResources().getConfiguration();
    com.jiubang.playsdk.adapter.a locala = new com.jiubang.playsdk.adapter.a(getContext(), this.d, this.a);
    if (this.n.j() == 28)
    {
      locala.a(2);
      locala.a(0.8F);
      if (localConfiguration.orientation != 2) {
        break label190;
      }
      locala.a(3);
      locala.d(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.r));
      locala.e(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.s));
      locala.b(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.x));
      locala.c(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.y));
    }
    for (;;)
    {
      this.a.setAdapter(locala);
      this.p = locala;
      return;
      if (this.n.j() == 18)
      {
        locala.a(2);
        break;
      }
      if (this.n.j() == 31)
      {
        locala.a(2);
        locala.a(1.16F);
        break;
      }
      locala.a(3);
      break;
      label190:
      locala.d(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.t));
      locala.e(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.u));
      locala.b(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.w));
      locala.c(this.c.getDimensionPixelSize(com.jiubang.playsdk.d.y));
    }
  }
  
  private void f()
  {
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= paramInt3 / 2) && (this.a.c()) && (this.j < this.i))
    {
      this.a.a();
      com.jiubang.playsdk.a.aa.a().a(this.k, this.i, 0, 0, this);
    }
    if (paramInt1 + paramInt2 < paramInt3) {
      d(true);
    }
    while (this.h.getParent() != null) {
      return;
    }
    d(false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.f != null) && (this.f.getChildCount() > 0))
    {
      View localView = this.f.getChildAt(0);
      if ((!(localView instanceof BannerView)) && (!(localView instanceof DependentAppView))) {}
    }
    else
    {
      return;
    }
    this.f.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(com.android.a.aa paramaa) {}
  
  public void a(x paramx)
  {
    this.b = paramx;
  }
  
  public void a(com.jiubang.playsdk.e.d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.m = paramd;
    Object localObject2 = paramd.e();
    Object localObject1 = paramd;
    if (this.b != null)
    {
      localObject1 = paramd;
      if (localObject2 != null)
      {
        localObject1 = paramd;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            localObject1 = paramd;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (com.jiubang.playsdk.e.c)((Iterator)localObject2).next();
            localObject1 = this.b.a(((com.jiubang.playsdk.e.c)localObject1).a());
            if (localObject1 != null) {
              if (((com.jiubang.playsdk.e.d)localObject1).j() == 27) {
                this.o = ((com.jiubang.playsdk.e.d)localObject1);
              } else {
                paramd = (com.jiubang.playsdk.e.d)localObject1;
              }
            }
          }
        }
      }
    }
    b((com.jiubang.playsdk.e.d)localObject1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(this.m);
    }
    while (this.p == null) {
      return;
    }
    this.p.notifyDataSetChanged();
  }
  
  public void b()
  {
    a(com.jiubang.playsdk.a.aa.a().b().d(getContext(), this));
  }
  
  public void b(x paramx)
  {
    if (paramx != null)
    {
      paramx = paramx.a(this.n.a());
      if (paramx != null) {
        c(paramx);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void c()
  {
    if (this.r != null) {
      this.r.removeAllViews();
    }
  }
  
  public void d() {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.a(this);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.n.l();
    if (!TextUtils.isEmpty(paramView))
    {
      int i1 = com.jiubang.playsdk.g.a.a(paramView);
      com.jiubang.playsdk.a.aa.a().a(getContext(), i1, this.n.a());
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a(this.m);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.a(null);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.e = LayoutInflater.from(getContext());
    this.c = getContext().getResources();
    this.t = ((LinearLayout)findViewById(com.jiubang.playsdk.f.M));
    ((FrameLayout.LayoutParams)this.t.getLayoutParams()).setMargins(0, 0, 0, getResources().getDimensionPixelSize(com.jiubang.playsdk.d.D));
    Object localObject = (ImageView)this.t.findViewById(com.jiubang.playsdk.f.N);
    TextView localTextView = (TextView)this.t.findViewById(com.jiubang.playsdk.f.O);
    if (com.jiubang.playsdk.a.aa.a().b().s() != 0) {
      ((ImageView)localObject).setImageResource(com.jiubang.playsdk.a.aa.a().b().s());
    }
    int i1 = com.jiubang.playsdk.a.aa.a().b().t();
    if (i1 != 0) {
      localTextView.setText(i1);
    }
    this.s = ((FrameLayout)findViewById(com.jiubang.playsdk.f.L));
    this.r = ((FrameLayout)findViewById(com.jiubang.playsdk.f.S));
    this.h = ((LinearLayout)this.e.inflate(com.jiubang.playsdk.g.r, null));
    localObject = (LinearLayout)this.h.findViewById(com.jiubang.playsdk.f.E);
    ((View)localObject).setBackgroundResource(com.jiubang.playsdk.a.aa.a().b().l());
    ((TextView)((View)localObject).findViewById(com.jiubang.playsdk.f.F)).setTextColor(this.c.getColor(com.jiubang.playsdk.a.aa.a().b().k()));
    ((View)localObject).setOnClickListener(this);
    a(com.jiubang.playsdk.a.aa.a().b().d(getContext(), this));
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.d == null) || (this.d.size() < paramInt)) {}
    do
    {
      return;
      paramAdapterView = (e)this.d.get(paramInt);
    } while (paramAdapterView == null);
    com.jiubang.playsdk.a.aa.a().a(getContext(), paramAdapterView, this.n.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/HeaderListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */