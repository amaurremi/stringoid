package com.jiubang.core.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;

public class u
  extends l
{
  static final Paint A = new Paint();
  protected int B = 32768;
  private boolean C;
  private b D;
  protected ArrayList w = new ArrayList();
  protected ArrayList x = new ArrayList();
  protected l y;
  protected boolean z;
  
  public u(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap)
  {
    super(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBitmap);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.D != null) {
      this.D.a(this);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    if (this.C)
    {
      paramCanvas.save();
      paramCanvas.clipRect(new Rect(0, 0, this.e, this.f));
    }
    if (this.j != null)
    {
      if ((this.q != null) && (paramInt2 != 255)) {
        paramCanvas.drawBitmap(this.q, null, this.k, this.i);
      }
      int i = this.i.getAlpha();
      this.i.setAlpha(paramInt2);
      if (paramInt2 != 0) {
        paramCanvas.drawBitmap(this.j, null, this.k, this.i);
      }
      this.i.setAlpha(i);
    }
    b(paramCanvas, paramFloat3, paramInt1, paramInt2);
    if (this.C) {
      paramCanvas.restore();
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.C)
    {
      paramCanvas.save();
      paramCanvas.clipRect(new Rect(0, 0, this.e, this.f));
    }
    if (this.j != null)
    {
      if ((this.q != null) && (paramInt2 != 255)) {
        paramCanvas.drawBitmap(this.q, null, this.k, this.i);
      }
      int i = this.i.getAlpha();
      this.i.setAlpha(paramInt2);
      if (paramInt2 != 0) {
        paramCanvas.drawBitmap(this.j, null, this.k, this.i);
      }
      this.i.setAlpha(i);
    }
    b(paramCanvas, paramFloat3, paramInt1, paramInt2);
    if (this.C) {
      paramCanvas.restore();
    }
  }
  
  protected void a(Canvas paramCanvas, float paramFloat, int paramInt1, int paramInt2)
  {
    c(paramCanvas, paramFloat, paramInt1, paramInt2);
  }
  
  public void a(l paraml)
  {
    if (paraml == null) {
      try
      {
        throw new IllegalArgumentException("component cannot be null");
      }
      finally {}
    }
    int i = b(paraml);
    if (i >= 0) {}
    for (;;)
    {
      return;
      this.w.add(paraml);
      paraml.a(this);
      this.x.add(paraml);
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = super.a(paramLong);
    Iterator localIterator = this.w.iterator();
    if (localIterator.hasNext())
    {
      if (!((l)localIterator.next()).a(paramLong)) {
        break label49;
      }
      bool = true;
    }
    label49:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public int b(l paraml)
  {
    if (paraml == null) {
      throw new IllegalArgumentException("component cannot be null");
    }
    return this.w.indexOf(paraml);
  }
  
  protected final void c(Canvas paramCanvas, float paramFloat, int paramInt1, int paramInt2)
  {
    int j = this.x.size();
    boolean bool = t();
    int i = 0;
    if (i < j)
    {
      l locall = (l)this.x.get(i);
      Bitmap localBitmap;
      label79:
      int k;
      if ((locall != null) && (locall.c()))
      {
        locall.d();
        if ((!bool) || (!locall.l())) {
          break label161;
        }
        localBitmap = locall.a(paramFloat, paramInt1);
        if ((localBitmap == null) || (localBitmap.isRecycled())) {
          break label222;
        }
        if (locall.k() != 255) {
          break label167;
        }
        k = this.i.getAlpha();
        this.i.setAlpha(paramInt2);
        paramCanvas.drawBitmap(localBitmap, locall.a, locall.b, this.i);
        this.i.setAlpha(k);
      }
      for (;;)
      {
        i += 1;
        break;
        label161:
        localBitmap = null;
        break label79;
        label167:
        k = A.getAlpha();
        k = (int)(paramInt2 / (k + 0.0F) * 255.0F);
        A.setAlpha(k);
        paramCanvas.drawBitmap(localBitmap, locall.a, locall.b, A);
        continue;
        label222:
        locall.a(paramCanvas, locall.a, locall.b, paramFloat, paramInt1, paramInt2, this.p);
      }
    }
  }
  
  protected void e()
  {
    super.e();
    this.y = null;
    this.z = false;
  }
  
  public void h()
  {
    try
    {
      if ((this.j != null) && (!this.j.isRecycled()))
      {
        this.j.recycle();
        this.j = null;
      }
      if ((this.q != null) && (!this.q.isRecycled()))
      {
        this.q.recycle();
        this.q = null;
      }
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).h();
      }
    }
    finally {}
  }
  
  public void m()
  {
    try
    {
      super.m();
      int j = this.x.size();
      int i = 0;
      while (i < j)
      {
        l locall = (l)this.x.get(i);
        if (locall != null) {
          locall.m();
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void p()
  {
    try
    {
      int j = this.w.size();
      int i = 0;
      while (i < j)
      {
        ((l)this.w.get(i)).p();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void q()
  {
    try
    {
      int j = this.w.size();
      int i = 0;
      while (i < j)
      {
        ((l)this.w.get(i)).q();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public boolean s()
  {
    int i = 0;
    boolean bool1;
    boolean bool2;
    int j;
    if (r() != null)
    {
      bool1 = true;
      bool2 = bool1;
      if (!bool1) {
        j = this.w.size();
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (i < j)
      {
        bool1 = ((l)this.w.get(i)).s();
        if (bool1) {
          bool2 = bool1;
        }
      }
      else
      {
        return bool2;
        bool1 = false;
        break;
      }
      i += 1;
    }
  }
  
  protected boolean t()
  {
    return (this.B & 0x8000) == 32768;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */