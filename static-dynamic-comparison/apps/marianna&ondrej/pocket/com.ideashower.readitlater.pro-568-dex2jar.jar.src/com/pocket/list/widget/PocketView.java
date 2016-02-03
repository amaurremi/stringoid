package com.pocket.list.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.f;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ideashower.readitlater.activity.HTSActivity;
import com.ideashower.readitlater.activity.w;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectFrameLayout;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.c;
import com.pocket.list.g;
import com.pocket.p.k;
import com.pocket.widget.az;

public class PocketView
  extends ResizeDetectFrameLayout
{
  private b a;
  private a b;
  private LinearLayout c;
  private az d;
  private TextView e;
  private e f;
  private g g;
  
  public PocketView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PocketView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PocketView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    b();
    c();
    g();
    if (this.g != null) {
      getAdapter().c(this.g);
    }
  }
  
  private void b()
  {
    this.a = new b(getContext());
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void c()
  {
    this.b = new a(getContext());
    addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    this.b.setVisibility(4);
    this.b.setItemAdapter(getAdapter());
    this.b.setOnButtonClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (w.Y() == com.pocket.p.l.a)
        {
          k.a(w.Z(), (f)PocketView.this.getContext());
          return;
        }
        HTSActivity.d(PocketView.this.getContext());
      }
    });
    d();
    this.g = new g()
    {
      private void a()
      {
        z.c(PocketView.a(PocketView.this), false);
        PocketView.b(PocketView.this).setVisibility(0);
        PocketView.c(PocketView.this).c();
        if (PocketView.this.getAdapter().b().f())
        {
          PocketView.d(PocketView.this);
          return;
        }
        PocketView.e(PocketView.this);
      }
      
      private void b()
      {
        z.c(PocketView.a(PocketView.this), true);
        PocketView.b(PocketView.this).setVisibility(4);
        PocketView.c(PocketView.this).d();
        PocketView.e(PocketView.this);
      }
      
      public void C()
      {
        PocketView.a(PocketView.this).C();
        b();
      }
      
      public void D()
      {
        PocketView.a(PocketView.this).D();
        a();
      }
      
      public void E()
      {
        PocketView.a(PocketView.this).E();
        b();
      }
      
      public void F()
      {
        PocketView.a(PocketView.this).F();
        b();
      }
      
      public void a(boolean paramAnonymousBoolean, ErrorReport paramAnonymousErrorReport)
      {
        PocketView.a(PocketView.this).a(paramAnonymousBoolean, paramAnonymousErrorReport);
        b();
      }
    };
    getAdapter().a(this.g);
    setEmptyStateHandler(new c(getContext(), getAdapter()));
  }
  
  private void d()
  {
    this.e = new TextView(getContext());
    this.e.setGravity(19);
    z.a(this.e, 15.5F, 16.0F);
    com.ideashower.readitlater.util.i.a(com.ideashower.readitlater.util.i.a, this.e);
    this.e.setTextSize(1, 14.0F);
    this.e.setBackgroundColor(com.pocket.i.a.i.b);
    this.e.setTextColor(-1);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PocketView.e(PocketView.this);
        PocketView.this.getAdapter().b().a();
      }
    });
    a(this.e, d.a);
  }
  
  private void e()
  {
    this.e.setVisibility(8);
    this.e.setText(null);
  }
  
  private void f()
  {
    Object localObject = getAdapter().b().g();
    if (localObject != null) {}
    for (localObject = getResources().getString(2131493043) + "\n\n" + ((ErrorReport)localObject).b();; localObject = getResources().getString(2131493414))
    {
      this.e.setVisibility(0);
      this.e.setText((CharSequence)localObject);
      return;
    }
  }
  
  private void g()
  {
    this.c = new LinearLayout(getContext());
    this.c.setOrientation(1);
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.d = new az(this.c);
    this.a.addHeaderView(this.d.a());
    this.b.a(this.d.b());
  }
  
  public void a(View paramView)
  {
    this.a.addFooterView(paramView);
  }
  
  public void a(View paramView, d paramd)
  {
    if (paramd == d.a)
    {
      this.a.addHeaderView(paramView);
      return;
    }
    this.c.addView(paramView);
  }
  
  public com.pocket.list.adapter.a getAdapter()
  {
    return this.a.getPocketAdapter();
  }
  
  public a getEmptyView()
  {
    return this.b;
  }
  
  public b getListView()
  {
    return this.a;
  }
  
  public ItemQuery getQuery()
  {
    return getAdapter().b().j();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.f != null) && (paramMotionEvent.getAction() == 0)) {
      this.f.a();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setEmptyStateHandler(com.ideashower.readitlater.views.l paraml)
  {
    getEmptyView().setEmptyStateHandler(paraml);
  }
  
  public void setOnViewGroupTouchedListener(e parame)
  {
    this.f = parame;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/PocketView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */