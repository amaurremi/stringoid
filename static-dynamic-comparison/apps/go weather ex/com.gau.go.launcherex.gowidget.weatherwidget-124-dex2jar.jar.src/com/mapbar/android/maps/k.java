package com.mapbar.android.maps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import java.util.LinkedList;
import java.util.List;

public class k
  implements f
{
  private Bitmap a;
  private Drawable b;
  private boolean c = false;
  private List<l> d = new LinkedList();
  
  public k(String paramString1, String paramString2, List<l> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0)) {
      this.d.addAll(paramList);
    }
  }
  
  public final int a()
  {
    try
    {
      int i = this.d.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final l a(int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramInt >= 0) {
      localObject1 = localObject3;
    }
    try
    {
      if (paramInt < this.d.size()) {
        localObject1 = (l)this.d.get(paramInt);
      }
      return (l)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public final l a(Point paramPoint, int paramInt)
  {
    float f1 = 1600.0F;
    Object localObject = null;
    paramInt = a() - 1;
    if (paramInt >= 0)
    {
      l locall = a(paramInt);
      PointF localPointF = locall.a();
      float f2 = localPointF.x;
      float f3 = paramPoint.x;
      float f4 = localPointF.x;
      float f5 = paramPoint.x;
      float f6 = localPointF.y;
      float f7 = paramPoint.y;
      f2 = (localPointF.y - paramPoint.y) * (f6 - f7) + (f2 - f3) * (f4 - f5);
      if (f2 > f1) {
        break label128;
      }
      f1 = f2;
      localObject = locall;
    }
    label128:
    for (;;)
    {
      paramInt -= 1;
      break;
      return (l)localObject;
    }
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.b = paramDrawable;
  }
  
  public final Bitmap b()
  {
    if ((this.a == null) || (this.a.isRecycled()) || (!this.c))
    {
      if ((this.a != null) && (!this.a.isRecycled())) {
        this.a.recycle();
      }
      this.a = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_4444);
      if (!this.c)
      {
        this.c = true;
        m.a(this, new Canvas(this.a), this.b);
      }
    }
    return this.a;
  }
  
  public void destory()
  {
    if ((this.a == null) || (this.a.isRecycled()))
    {
      this.a = null;
      return;
    }
    this.a.recycle();
    this.a = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */