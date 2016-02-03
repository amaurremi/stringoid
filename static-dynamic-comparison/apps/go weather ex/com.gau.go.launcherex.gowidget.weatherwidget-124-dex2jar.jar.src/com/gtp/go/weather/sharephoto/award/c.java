package com.gtp.go.weather.sharephoto.award;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.model.ThemeDataBean;
import com.gau.go.launcherex.gowidget.weather.view.al;
import com.gtp.go.weather.sharephoto.b.b;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c
  extends com.gau.go.launcherex.gowidget.weather.globalview.f
  implements DialogInterface.OnDismissListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener
{
  private TextView b;
  private TextView c;
  private TextView d;
  private ListView e;
  private ProgressBar f;
  private al g;
  private final ArrayList h = new ArrayList();
  private i i;
  private h j;
  private com.gtp.go.weather.sharephoto.b.d k;
  private k l;
  private final HashMap m = new HashMap();
  private final List n = new ArrayList();
  private int o;
  private HashMap p = new HashMap();
  private final o q = new f(this);
  private final o r = new g(this);
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    setCanceledOnTouchOutside(false);
    setContentView(2130903280);
    this.b = ((TextView)findViewById(2131230797));
    this.d = ((TextView)findViewById(2131231898));
    this.f = ((ProgressBar)findViewById(2131231709));
    this.c = ((TextView)findViewById(2131231899));
    this.c.setText(b(2131166394));
    this.c.setOnClickListener(this);
    this.c.setEnabled(false);
    this.e = ((ListView)findViewById(2131231269));
    this.i = new i(this, null);
    this.e.setAdapter(this.i);
    paramActivity = this.a.getResources().getDisplayMetrics();
    this.o = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
    setOnDismissListener(this);
    a(2131166393);
  }
  
  private Bitmap a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject1 = (SoftReference)this.m.get(paramString);
      if (localObject1 != null) {}
      for (localObject1 = (Bitmap)((SoftReference)localObject1).get();; localObject1 = null)
      {
        if (localObject1 != null) {}
        for (;;)
        {
          return (Bitmap)localObject1;
          try
          {
            localObject2 = BitmapFactory.decodeFile(paramString);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = new SoftReference(localObject2);
              this.m.put(paramString, localObject1);
              return (Bitmap)localObject2;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Object localObject2 = localObject1;
              if (com.gtp.a.a.b.c.a())
              {
                localOutOfMemoryError.printStackTrace();
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  private void a()
  {
    if (!this.a.isFinishing())
    {
      if (this.g == null) {
        break label35;
      }
      if (!this.g.isShowing()) {
        this.g.show();
      }
    }
    return;
    label35:
    this.g = al.a(this.a);
    this.g.setCanceledOnTouchOutside(false);
    this.g.setOnKeyListener(new d(this));
    this.g.a(b(2131166397));
    this.g.show();
  }
  
  private void a(long paramLong)
  {
    if (this.j.b.a() != paramLong) {}
    while (this.j.b.c() != 1) {
      return;
    }
    com.gtp.go.weather.sharephoto.b.a locala = this.j.b.d();
    ThemeDataBean localThemeDataBean = new ThemeDataBean();
    localThemeDataBean.a(locala.d());
    localThemeDataBean.e(locala.c());
    localThemeDataBean.a((int)this.j.b.a());
    switch (locala.f())
    {
    }
    for (;;)
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, localThemeDataBean);
      return;
      localThemeDataBean.j(locala.e());
      continue;
      localThemeDataBean.k(locala.e());
      continue;
      localThemeDataBean.n(locala.e());
    }
  }
  
  private void a(b paramb)
  {
    com.gtp.go.weather.sharephoto.b.a locala;
    if (paramb.c() == 1)
    {
      locala = paramb.d();
      if (!TextUtils.isEmpty(locala.a())) {}
    }
    else
    {
      return;
    }
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(locala.a())) {
        return;
      }
    }
    this.n.add(locala.a());
    com.gtp.a.a.b.c.a("AwardListDialog", "re download ApkImage..." + paramb.a());
    new e(this, paramb).execute(new b[] { paramb });
  }
  
  private void a(List paramList)
  {
    this.c.setEnabled(false);
    this.c.setBackgroundResource(2130839071);
    this.h.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if ((localb.c() == 1) && (localb.d() != null) && (!TextUtils.isEmpty(localb.d().b())))
      {
        h localh = new h(this, null);
        localh.a = false;
        localh.b = localb;
        this.h.add(localh);
      }
    }
    this.i.notifyDataSetChanged();
    if (this.h.size() == 0) {
      dismiss();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
    this.f.setVisibility(8);
    this.e.setVisibility(0);
  }
  
  private String b(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  private void b()
  {
    if ((!this.a.isFinishing()) && (this.g != null) && (this.g.isShowing()))
    {
      this.g.dismiss();
      this.g = null;
    }
  }
  
  private void c()
  {
    if (isShowing()) {
      return;
    }
    this.e.getViewTreeObserver().addOnPreDrawListener(this);
    a(17, 0, 0, this.o, -2);
  }
  
  private void d()
  {
    this.e.getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.l != null)
    {
      this.l.b(this.q);
      this.l.b(this.r);
      this.l.a();
      this.l = null;
    }
  }
  
  private void e()
  {
    a();
    b localb = this.j.b;
    k.a(this.a, localb.b(), localb.a());
  }
  
  public void a(int paramInt)
  {
    a(b(paramInt));
  }
  
  public void a(com.gtp.go.weather.sharephoto.b.d paramd)
  {
    this.k = paramd;
    if (this.k == null) {
      return;
    }
    this.l = new k(getContext());
    this.l.a(this.q);
    this.l.a(this.r);
    paramd = (List)this.p.get(Long.valueOf(this.k.a()));
    if (paramd == null)
    {
      a(true);
      this.l.a(true, this.k);
    }
    for (;;)
    {
      this.d.setText(this.k.c());
      c();
      return;
      a(paramd);
    }
  }
  
  public void a(com.gtp.go.weather.sharephoto.b.d paramd, List paramList)
  {
    this.k = paramd;
    if ((this.k == null) || (paramList == null)) {
      return;
    }
    a(false);
    a(paramList);
    this.d.setText(this.k.c());
    this.l = new k(getContext());
    this.l.a(this.r);
    c();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      e();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    d();
  }
  
  public boolean onPreDraw()
  {
    int i1 = this.a.getResources().getDisplayMetrics().heightPixels / 2;
    if (this.e.getHeight() > i1)
    {
      this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, i1));
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */