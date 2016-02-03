package com.gau.go.launcherex.gowidget.weather.dynamicbackground;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.jiubang.core.a.f;
import com.jiubang.core.a.l;
import java.util.ArrayList;

public class DynamicBackgroundView
  extends View
  implements com.jiubang.core.a.c
{
  private l a = null;
  private l b = null;
  private volatile int c = 0;
  private volatile boolean d;
  private int e;
  private int f;
  private int g = 255;
  private ArrayList h = new ArrayList();
  private boolean i;
  private Handler j = new a(this);
  
  public DynamicBackgroundView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DynamicBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void f()
  {
    int m = this.h.size();
    int k = 0;
    while (k < m)
    {
      l locall = (l)this.h.get(k);
      if (locall != null) {
        locall.h();
      }
      k += 1;
    }
    this.h.clear();
  }
  
  private void g()
  {
    this.c = 0;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  /* Error */
  public void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/gau/go/launcherex/gowidget/weather/dynamicbackground/DynamicBackgroundView:d	Z
    //   6: ifeq +26 -> 32
    //   9: aload_0
    //   10: getfield 56	com/gau/go/launcherex/gowidget/weather/dynamicbackground/DynamicBackgroundView:i	Z
    //   13: ifne +10 -> 23
    //   16: aload_0
    //   17: getfield 79	com/gau/go/launcherex/gowidget/weather/dynamicbackground/DynamicBackgroundView:e	I
    //   20: ifeq +12 -> 32
    //   23: aload_0
    //   24: getfield 77	com/gau/go/launcherex/gowidget/weather/dynamicbackground/DynamicBackgroundView:d	Z
    //   27: istore_3
    //   28: iload_3
    //   29: ifne +6 -> 35
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: invokevirtual 82	com/gau/go/launcherex/gowidget/weather/dynamicbackground/DynamicBackgroundView:getVisibility	()I
    //   39: ifne -7 -> 32
    //   42: aload_0
    //   43: invokevirtual 85	com/gau/go/launcherex/gowidget/weather/dynamicbackground/DynamicBackgroundView:postInvalidate	()V
    //   46: goto -14 -> 32
    //   49: astore 4
    //   51: getstatic 91	java/lang/System:out	Ljava/io/PrintStream;
    //   54: ldc 93
    //   56: invokevirtual 99	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   59: goto -27 -> 32
    //   62: astore 4
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 4
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	DynamicBackgroundView
    //   0	69	1	paramLong	long
    //   27	2	3	bool	boolean
    //   49	1	4	localException	Exception
    //   62	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	46	49	java/lang/Exception
    //   2	23	62	finally
    //   23	28	62	finally
    //   35	46	62	finally
    //   51	59	62	finally
  }
  
  public void a(l paraml, boolean paramBoolean)
  {
    if (f.e())
    {
      f.d();
      this.j.removeMessages(2);
    }
    this.i = paramBoolean;
    this.e = 30;
    if ((this.b == null) && (this.a == null))
    {
      this.a = paraml;
      this.a.a(getLeft(), getTop(), getRight(), getBottom());
      return;
    }
    if (this.c == 0)
    {
      this.b = paraml;
      this.b.a(getLeft(), getTop(), getRight(), getBottom());
    }
    for (;;)
    {
      g();
      return;
      l locall = this.b;
      this.b = paraml;
      this.h.add(locall);
      this.b.a(getLeft(), getTop(), getRight(), getBottom());
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.c())
      {
        bool1 = bool2;
        if (this.a.a(l)) {
          bool1 = true;
        }
      }
    }
    bool2 = bool1;
    if (this.b != null)
    {
      bool2 = bool1;
      if (this.b.c())
      {
        bool2 = bool1;
        if (this.b.a(l)) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public void b()
  {
    try
    {
      if (this.a != null)
      {
        this.a.h();
        this.a = null;
      }
      if (this.b != null)
      {
        this.b.h();
        this.b = null;
      }
      f();
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      com.gtp.a.a.b.c.a("DynamicBackgroundView", "screenOff");
      if (this.a != null) {
        this.a.p();
      }
      if (this.b != null) {
        this.b.p();
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      com.gtp.a.a.b.c.a("DynamicBackgroundView", "screenOn");
      if (this.a != null) {
        this.a.q();
      }
      if (this.b != null) {
        this.b.q();
      }
      return;
    }
    finally {}
  }
  
  public void e()
  {
    this.e = 30;
    if (f.e())
    {
      f.d();
      this.j.removeMessages(2);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    f.a(25);
    f.a(this);
    f.b();
    f.d();
    this.e = 30;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    f.b(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        a();
        if ((this.a != null) && (this.a.c()))
        {
          this.a.d();
          if ((Build.VERSION.SDK_INT >= 11) && (this.a.s())) {
            this.a.a(paramCanvas, this.a.f(), this.a.g(), 0.0F, this.f, this.g, this.i);
          }
        }
        else
        {
          if ((paramCanvas == null) || (this.b == null) || (!this.a.c())) {
            break label439;
          }
          this.a.d();
          this.c = ((int)(this.c + 35L));
          if (this.c > 255) {
            this.c = 255;
          }
          float f1 = paramCanvas.getWidth();
          float f2 = paramCanvas.getHeight();
          k = (int)(this.c * (this.g / 255.0F));
          if ((Build.VERSION.SDK_INT < 11) || (!this.a.s())) {
            break label451;
          }
          k = paramCanvas.saveLayerAlpha(0.0F, 0.0F, f1, f2, k, 4);
          this.b.a(paramCanvas, this.b.f(), this.b.g(), 0.0F, this.f, 255, this.i);
          if (k != -1) {
            paramCanvas.restoreToCount(k);
          }
          if (this.c >= 255)
          {
            this.c = 0;
            if (this.a != null) {
              this.a.h();
            }
            this.a = this.b;
            this.b = null;
            this.j.sendEmptyMessage(2);
          }
          if ((Build.VERSION.SDK_INT < 11) || ((this.a != null) && (!this.a.s())))
          {
            k = (int)((255 - this.g) * 0.35D);
            if (k != 0) {
              paramCanvas.drawColor(Color.argb(k, 0, 0, 0));
            }
          }
          this.j.sendEmptyMessage(1);
          if (this.e > 0)
          {
            this.e -= 1;
            invalidate();
          }
          return;
        }
        this.a.a(paramCanvas, this.a.f(), this.a.g(), 0.0F, this.f, 255, this.i);
        continue;
        this.j.sendEmptyMessage(2);
      }
      finally {}
      label439:
      continue;
      label451:
      int k = -1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramBoolean)
      {
        this.f = getWidth();
        this.d = true;
        if (this.a != null) {
          this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
        }
        if (this.b != null) {
          this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
        }
      }
      return;
    }
    finally {}
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    com.gtp.a.a.b.c.a("DynamicBackgroundView", "onVisibilityChanged: " + paramInt);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    com.gtp.a.a.b.c.a("DynamicBackgroundView", "onWindowVisibilityChanged: " + paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/DynamicBackgroundView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */