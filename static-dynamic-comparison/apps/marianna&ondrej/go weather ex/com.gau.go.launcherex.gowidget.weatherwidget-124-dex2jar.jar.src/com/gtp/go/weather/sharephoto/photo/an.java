package com.gtp.go.weather.sharephoto.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.gau.go.launcherex.gowidget.weather.view.pullrefresh.a;
import com.jiubang.pla.listview.MultiColumnListView;

public class an
{
  private PhotoTouchRefresh a;
  private MultiColumnListView b = null;
  private float c;
  private boolean d = true;
  private boolean e = false;
  private PointF f;
  private boolean g = false;
  private float h;
  private float i = 0.0F;
  private a j;
  private boolean k = false;
  
  public an(PhotoTouchRefresh paramPhotoTouchRefresh)
  {
    this.a = paramPhotoTouchRefresh;
    this.a.a(this);
    float f1 = this.a.getContext().getResources().getDisplayMetrics().density;
    this.c = (6.0F * f1);
    this.h = (f1 * 80.0F);
    this.f = new PointF();
    this.b = ((MultiColumnListView)this.a.findViewById(2131231800));
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMotionEvent.getY() - this.f.y > this.c)
    {
      double d1 = (Math.toDegrees(Math.atan((paramMotionEvent.getY() - this.f.y) / (paramMotionEvent.getX() - this.f.x))) + 180.0D) % 180.0D;
      bool1 = bool2;
      if (d1 > 50.0D)
      {
        bool1 = bool2;
        if (d1 < 130.0D) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    if (this.j != null) {
      this.j.a();
    }
  }
  
  private void e()
  {
    this.f.x = 0.0F;
    this.f.y = 0.0F;
    if (this.j != null) {
      this.j.a(this.i);
    }
  }
  
  private void f()
  {
    if (this.i == 1.0F)
    {
      this.g = true;
      if (this.j != null) {
        this.j.b();
      }
    }
    while (this.j == null) {
      return;
    }
    this.j.b(this.i);
  }
  
  public void a(a parama)
  {
    this.j = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    if ((!a()) || (this.g) || (!this.b.j())) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return this.e;
      this.f.y = paramMotionEvent.getY();
      this.f.x = paramMotionEvent.getX();
      this.k = false;
      continue;
      if ((!this.k) && (!this.e) && (c(paramMotionEvent)))
      {
        this.e = true;
        this.f.y = paramMotionEvent.getY();
        this.f.x = paramMotionEvent.getX();
        d();
        continue;
        if (!this.k)
        {
          if (this.e)
          {
            this.e = false;
            e();
          }
          this.k = false;
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    if ((!a()) || (this.g)) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.f.y = paramMotionEvent.getY();
      this.f.x = paramMotionEvent.getX();
      this.k = false;
      if (!this.k) {
        if (!this.e)
        {
          if (c(paramMotionEvent))
          {
            this.e = true;
            this.f.y = paramMotionEvent.getY();
            this.f.x = paramMotionEvent.getX();
            d();
          }
        }
        else
        {
          float f2 = paramMotionEvent.getY() - this.f.y;
          if (f2 < 0.0F)
          {
            this.k = true;
            this.e = false;
            e();
          }
          else
          {
            this.i = (0.3F * f2 * (this.i + 1.0F) / this.h);
            if (this.i > 1.0F) {}
            for (;;)
            {
              this.i = f1;
              f();
              break;
              f1 = this.i;
            }
            if (!this.k)
            {
              if (this.e)
              {
                this.e = false;
                e();
              }
              this.k = false;
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    if (this.g)
    {
      this.f.x = 0.0F;
      this.f.y = 0.0F;
      this.i = 0.0F;
      this.g = false;
      this.e = false;
      this.k = true;
      if (this.j != null) {
        this.j.g_();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */