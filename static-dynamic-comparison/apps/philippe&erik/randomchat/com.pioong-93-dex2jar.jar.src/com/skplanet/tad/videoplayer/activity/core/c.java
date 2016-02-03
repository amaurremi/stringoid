package com.skplanet.tad.videoplayer.activity.core;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  static final int a = Color.parseColor("#99A2A2A2");
  static final int b = Color.parseColor("#ffffff");
  static final int c = Color.parseColor("#ffffff");
  Drawable A;
  Drawable B;
  Drawable C;
  public Button D;
  Drawable E;
  Drawable F;
  public boolean G = false;
  int H;
  int I;
  int J;
  List K = new ArrayList();
  View.OnTouchListener L = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((paramAnonymousView.getId() == 100) || (2 != paramAnonymousMotionEvent.getAction())) {
        c.this.a(paramAnonymousView, paramAnonymousMotionEvent);
      }
      if (paramAnonymousMotionEvent.getAction() == 0) {
        if (paramAnonymousView.getId() == 99) {
          paramAnonymousView.setBackgroundDrawable(c.this.w);
        }
      }
      for (;;)
      {
        return false;
        if (paramAnonymousView.getId() == 2)
        {
          paramAnonymousView.setBackgroundDrawable(c.this.y);
        }
        else if (paramAnonymousView.getId() == 4)
        {
          paramAnonymousView.setBackgroundDrawable(c.this.F);
          continue;
          if ((1 == paramAnonymousMotionEvent.getAction()) || (4 == paramAnonymousMotionEvent.getAction())) {
            if (paramAnonymousView.getId() == 99) {
              paramAnonymousView.setBackgroundDrawable(c.this.v);
            } else if (paramAnonymousView.getId() == 2) {
              paramAnonymousView.setBackgroundDrawable(c.this.x);
            } else if (paramAnonymousView.getId() == 4) {
              paramAnonymousView.setBackgroundDrawable(c.this.E);
            }
          }
        }
      }
    }
  };
  com.skplanet.tad.videoplayer.activity.c d;
  Activity e;
  public RelativeLayout f;
  public RelativeLayout g;
  public LinearLayout h;
  public Button i;
  public Button j;
  public RelativeLayout k;
  public LinearLayout l;
  public LinearLayout m;
  public TextView n;
  public TextView o;
  public TextView p;
  public SeekBar q;
  LinearLayout r;
  LinearLayout s;
  LinearLayout t;
  LinearLayout u;
  Drawable v;
  Drawable w;
  Drawable x;
  Drawable y;
  Drawable z;
  
  public c(com.skplanet.tad.videoplayer.activity.c paramc)
  {
    this.d = paramc;
    this.e = paramc.M;
    a.a(this.e);
    if (paramc.f.f.length > 0) {
      bool = true;
    }
    this.G = bool;
    this.H = (a.q / 2);
    this.I = (a.q / 4);
    this.J = (a.r / 2);
    f();
    this.f = new RelativeLayout(this.e);
    this.e.setContentView(this.f, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private Button a(LinearLayout.LayoutParams paramLayoutParams, com.skplanet.tad.videoplayer.data.a parama, int paramInt)
  {
    Button localButton = new Button(this.e);
    localButton.setLayoutParams(paramLayoutParams);
    if (1 == paramInt)
    {
      localButton.setText(parama.b);
      localButton.setTag(Integer.valueOf(parama.a));
    }
    for (;;)
    {
      localButton.setTextSize(2, a.n);
      localButton.setTextColor(c);
      localButton.setId(paramInt);
      localButton.setOnClickListener(this.d.E);
      localButton.setGravity(17);
      localButton.getBackground().setAlpha(com.skplanet.tad.videoplayer.util.c.a(b.b));
      this.K.add(localButton);
      return localButton;
      if (3 == paramInt) {
        localButton.setText("이전 동영상 보기");
      }
    }
  }
  
  private LinearLayout.LayoutParams a(boolean paramBoolean, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.J, a.f);
    if (paramBoolean) {
      localLayoutParams.width = (this.J - a.p / 2);
    }
    if (paramInt > 0) {
      localLayoutParams.leftMargin = a.p;
    }
    return localLayoutParams;
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    int i3 = this.d.f.f.length;
    int i1;
    Object localObject;
    int i2;
    if (i3 > 2)
    {
      i1 = this.I;
      localObject = new LinearLayout.LayoutParams(-1, -2);
      this.u = new LinearLayout(this.e);
      this.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.u.setGravity(1);
      i2 = 0;
    }
    for (;;)
    {
      if (i2 >= i3)
      {
        paramLinearLayout.addView(this.u);
        return;
        i1 = this.H;
        break;
      }
      localObject = this.d.f.f[i2];
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, a.f);
      if ((i3 == 2) || (i3 == 4)) {
        localLayoutParams.width = (i1 - a.o * 3 / 4);
      }
      if (i2 > 0) {
        localLayoutParams.leftMargin = a.o;
      }
      this.u.addView(a(localLayoutParams, (com.skplanet.tad.videoplayer.data.a)localObject, 1));
      i2 += 1;
    }
  }
  
  private LinearLayout b(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 2) {
      localLayoutParams.topMargin = a.p;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    localLinearLayout.setGravity(1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  private void b()
  {
    Iterator localIterator = this.K.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Button)localIterator.next()).clearFocus();
    }
  }
  
  private void b(SurfaceView paramSurfaceView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(15);
    paramSurfaceView.setLayoutParams(localLayoutParams);
    paramSurfaceView.setId(50);
    this.f.addView(paramSurfaceView);
    paramSurfaceView = new RelativeLayout.LayoutParams(-1, -2);
    paramSurfaceView.addRule(3, 50);
    paramSurfaceView.topMargin = (a.p * 2);
    this.m = new LinearLayout(this.e);
    this.m.setLayoutParams(paramSurfaceView);
    this.m.setOrientation(1);
    this.m.setGravity(17);
    this.r = b(1);
    this.r.addView(a(a(false, 0), null, 3));
    b(this.m);
    this.f.addView(this.m);
  }
  
  private void b(LinearLayout paramLinearLayout)
  {
    int i1 = this.d.f.f.length;
    com.skplanet.tad.videoplayer.data.a[] arrayOfa = this.d.f.f;
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    this.s = new LinearLayout(this.e);
    this.s.setOrientation(1);
    this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (i1 == 1)
    {
      localObject = b(1);
      ((LinearLayout)localObject).addView(a(a(false, 0), arrayOfa[0], 1));
      this.s.addView((View)localObject);
    }
    for (;;)
    {
      paramLinearLayout.addView(this.s);
      return;
      if (i1 == 2)
      {
        localObject = b(1);
        ((LinearLayout)localObject).addView(a(a(true, 0), arrayOfa[0], 1));
        ((LinearLayout)localObject).addView(a(a(true, 1), arrayOfa[1], 1));
        this.s.addView((View)localObject);
      }
      else if (i1 == 3)
      {
        localObject = b(1);
        ((LinearLayout)localObject).addView(a(a(false, 0), arrayOfa[0], 1));
        this.s.addView((View)localObject);
        localObject = b(2);
        ((LinearLayout)localObject).addView(a(a(true, 0), arrayOfa[1], 1));
        ((LinearLayout)localObject).addView(a(a(true, 1), arrayOfa[2], 1));
        this.s.addView((View)localObject);
      }
      else if (i1 == 4)
      {
        localObject = b(1);
        ((LinearLayout)localObject).addView(a(a(true, 0), arrayOfa[0], 1));
        ((LinearLayout)localObject).addView(a(a(true, 1), arrayOfa[1], 1));
        this.s.addView((View)localObject);
        localObject = b(2);
        ((LinearLayout)localObject).addView(a(a(true, 0), arrayOfa[2], 1));
        ((LinearLayout)localObject).addView(a(a(true, 1), arrayOfa[3], 1));
        this.s.addView((View)localObject);
      }
    }
  }
  
  private void c()
  {
    com.skplanet.tad.videoplayer.util.b.a("makeTopLayout: ");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.b);
    localLayoutParams.addRule(10);
    this.g = new RelativeLayout(this.e);
    this.g.setId(53);
    this.g.setLayoutParams(localLayoutParams);
    this.g.setBackgroundColor(a);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localLayoutParams.rightMargin = (a.j + a.g + a.g);
    localLayoutParams.leftMargin = (a.j + a.g + a.g);
    this.n = new TextView(this.e);
    this.n.setLayoutParams(localLayoutParams);
    this.n.setText(this.d.f.e);
    this.n.setTextColor(b);
    this.n.setGravity(17);
    this.n.setSingleLine(true);
    this.n.setTextSize(2, a.m);
    this.n.setTypeface(Typeface.DEFAULT, 1);
    this.n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.n.setFocusable(true);
    this.g.addView(this.n);
    localLayoutParams = new RelativeLayout.LayoutParams(a.j, a.j);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    localLayoutParams.rightMargin = a.g;
    localLayoutParams.leftMargin = a.g;
    Button localButton = new Button(this.e);
    localButton.setLayoutParams(localLayoutParams);
    localButton.setBackgroundDrawable(this.v);
    localButton.setOnTouchListener(this.L);
    localButton.setId(99);
    localButton.setOnClickListener(this.d.E);
    this.g.addView(localButton);
    localLayoutParams = new RelativeLayout.LayoutParams(a.j, a.j);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = a.g;
    localLayoutParams.rightMargin = a.g;
    this.j = new Button(this.e);
    this.j.setId(100000);
    this.j.setLayoutParams(localLayoutParams);
    this.j.setBackgroundDrawable(this.z);
    this.j.setOnTouchListener(this.L);
    this.j.setId(100);
    this.j.setOnClickListener(this.d.E);
    this.g.addView(this.j);
    this.f.addView(this.g);
  }
  
  private void d()
  {
    com.skplanet.tad.videoplayer.util.b.a("makeBottomLayout()");
    Object localObject = new RelativeLayout.LayoutParams(-1, a.c);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.h = new LinearLayout(this.e);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.h.setOrientation(1);
    this.h.setGravity(17);
    localObject = new LinearLayout.LayoutParams(this.H, a.f);
    this.t = b(1);
    this.t.addView(a((LinearLayout.LayoutParams)localObject, null, 3));
    localObject = new LinearLayout.LayoutParams(-1, a.e);
    this.l = new LinearLayout(this.e);
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.l.setGravity(1);
    a(this.l);
    this.h.addView(this.l);
    localObject = new LinearLayout.LayoutParams(-1, a.d);
    ((LinearLayout.LayoutParams)localObject).topMargin = a.o;
    this.k = e();
    this.k.setBackgroundColor(a);
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.h.addView(this.k);
    this.f.addView(this.h);
  }
  
  private RelativeLayout e()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = a.h;
    this.o = new TextView(this.e);
    this.o.setLayoutParams(localLayoutParams);
    this.o.setTextSize(2, a.n);
    this.o.setTextColor(b);
    this.o.setId(51);
    localRelativeLayout.addView(this.o);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    localLayoutParams.rightMargin = a.h;
    this.p = new TextView(this.e);
    this.p.setLayoutParams(localLayoutParams);
    this.p.setTextSize(2, a.n);
    this.p.setTextColor(b);
    this.p.setId(52);
    localRelativeLayout.addView(this.p);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 51);
    localLayoutParams.addRule(0, 52);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(a.g, 0, a.g, 0);
    this.q = new SeekBar(this.e);
    this.q.setLayoutParams(localLayoutParams);
    this.q.setPadding(a.i, 0, a.i, 0);
    localRelativeLayout.addView(this.q);
    return localRelativeLayout;
  }
  
  private void f()
  {
    this.A = this.e.getResources().getDrawable(17301553);
    this.z = this.e.getResources().getDrawable(17301553);
    this.C = this.e.getResources().getDrawable(17301554);
    this.B = this.e.getResources().getDrawable(17301554);
    this.x = this.e.getResources().getDrawable(17301581);
    this.y = this.e.getResources().getDrawable(17301581);
    this.v = this.e.getResources().getDrawable(17301527);
    this.w = this.e.getResources().getDrawable(17301527);
    this.E = this.e.getResources().getDrawable(17301540);
    this.F = this.e.getResources().getDrawable(17301540);
  }
  
  public void a()
  {
    if (!a.a())
    {
      this.j.setBackgroundDrawable(this.B);
      return;
    }
    this.j.setBackgroundDrawable(this.z);
  }
  
  public void a(int paramInt)
  {
    com.skplanet.tad.videoplayer.util.b.a("changeOrientation: " + paramInt);
    com.skplanet.tad.videoplayer.util.b.a("seekTimeRL.setVisibility(VodVideoPlayer.getIsSeekingBarShow(): " + com.skplanet.tad.videoplayer.activity.c.n());
    Object localObject = this.k;
    int i1;
    if (com.skplanet.tad.videoplayer.activity.c.n())
    {
      i1 = 0;
      ((RelativeLayout)localObject).setVisibility(i1);
      if (this.k.getVisibility() == 8)
      {
        localObject = this.k;
        if (!this.d.V) {
          break label214;
        }
        i1 = 0;
        label89:
        ((RelativeLayout)localObject).setVisibility(i1);
      }
      localObject = this.l;
      if (!this.G) {
        break label226;
      }
      if (2 != paramInt) {
        break label220;
      }
      i1 = 0;
      label113:
      ((LinearLayout)localObject).setVisibility(i1);
      if (1 == paramInt)
      {
        com.skplanet.tad.videoplayer.util.b.a("landTopRL VISIBLE 상단 타이틀 노출");
        this.g.setVisibility(0);
      }
      this.h.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
      if ((this.k.getVisibility() != 0) || (this.l.getVisibility() != 0)) {
        break label232;
      }
      com.skplanet.tad.videoplayer.util.b.a("landBottomRL 가로 기준 하단 영역 높이 설정");
      ((RelativeLayout.LayoutParams)localObject).height = a.c;
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      com.skplanet.tad.videoplayer.util.b.a("changeOrientation End");
      b();
      return;
      i1 = 8;
      break;
      label214:
      i1 = 8;
      break label89;
      label220:
      i1 = 8;
      break label113;
      label226:
      i1 = 8;
      break label113;
      label232:
      if (this.k.getVisibility() == 0)
      {
        com.skplanet.tad.videoplayer.util.b.a("landBottomRL 가로 기준 하단 영역 높이 설정 2");
        ((RelativeLayout.LayoutParams)localObject).height = a.d;
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else if (this.l.getVisibility() == 0)
      {
        com.skplanet.tad.videoplayer.util.b.a("landBottomRL 가로 기준 하단 영역 높이 설정 3");
        ((RelativeLayout.LayoutParams)localObject).height = (a.e + a.d);
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else
      {
        this.h.setVisibility(8);
        com.skplanet.tad.videoplayer.util.b.a("landBottomRL 가로 기준 하단 영역 높이 설정 4");
      }
    }
  }
  
  public void a(SurfaceView paramSurfaceView)
  {
    this.K.clear();
    b(paramSurfaceView);
    c();
    d();
    paramSurfaceView = new RelativeLayout.LayoutParams(a.k, a.k);
    paramSurfaceView.addRule(13);
    this.i = new Button(this.e);
    this.i.setLayoutParams(paramSurfaceView);
    this.i.setVisibility(8);
    this.i.setId(2);
    this.i.setOnClickListener(this.d.E);
    this.i.setBackgroundDrawable(this.x);
    this.i.setOnTouchListener(this.L);
    this.f.addView(this.i);
    paramSurfaceView = new RelativeLayout.LayoutParams(a.l, a.l);
    paramSurfaceView.addRule(13);
    this.D = new Button(this.e);
    this.D.setLayoutParams(paramSurfaceView);
    this.D.setVisibility(8);
    this.D.setId(4);
    this.D.setOnClickListener(this.d.E);
    this.D.setBackgroundDrawable(this.E);
    this.D.setOnTouchListener(this.L);
    this.f.addView(this.D);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (paramMotionEvent.getAction() == 0)
      {
        if (a.a())
        {
          paramView.setBackgroundDrawable(this.A);
          return;
        }
        paramView.setBackgroundDrawable(this.C);
        return;
      }
    } while (paramMotionEvent.getAction() != 1);
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    com.skplanet.tad.videoplayer.util.b.a("changeBack-" + paramBoolean);
    this.m.removeAllViews();
    this.l.removeAllViews();
    if (paramBoolean)
    {
      this.m.addView(this.r);
      this.l.addView(this.t);
      return;
    }
    this.m.addView(this.s);
    this.l.addView(this.u);
  }
  
  public void b(boolean paramBoolean)
  {
    Button localButton = this.i;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localButton.setVisibility(i1);
      this.i.invalidate();
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i1 = 8;
    if (!this.d.V)
    {
      Button localButton = this.D;
      if (paramBoolean) {
        i1 = 0;
      }
      localButton.setVisibility(i1);
      this.D.invalidate();
      return;
    }
    if (!paramBoolean)
    {
      this.D.setVisibility(8);
      this.D.invalidate();
      return;
    }
    this.D.setVisibility(8);
    this.D.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/activity/core/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */