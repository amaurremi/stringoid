package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.View;
import android.view.View.MeasureSpec;
import com.gtp.a.a.b.c;

public class a
  extends ao
{
  private Context l;
  
  public a(an paraman)
  {
    this.l = paraman.h();
    this.a = paraman.e();
    this.b.x = paraman.f();
    this.b.y = paraman.g();
    this.c = paraman.b;
    this.d = paraman.c;
    this.g = paraman.f;
    this.i = paraman.h;
    this.h = paraman.g;
    this.f = paraman.e;
    this.e = paraman.d;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        float f;
        localObject3 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          localObject3 = localObject1;
          if (localObject2 != null)
          {
            f = this.g * paramInt1 / this.c;
            localObject1 = an.a(this.l, this.a);
            ((an)localObject1).a(this.j, this.k);
            localObject1 = ((an)localObject1).d();
            ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(this.h, 0), View.MeasureSpec.makeMeasureSpec(this.i, 0));
            ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
            paramInt2 = (int)(paramInt2 * this.b.y);
            paramInt1 = (int)(paramInt1 * this.b.x);
            ((Canvas)localObject2).save();
            ((Canvas)localObject2).translate(paramInt1, paramInt2);
            ((Canvas)localObject2).scale(f, f);
            ((View)localObject1).draw((Canvas)localObject2);
            ((Canvas)localObject2).restore();
          }
          return (Bitmap)localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          for (;;) {}
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject1 = null;
      }
      localObject2 = localObject4;
      if (c.a())
      {
        localOutOfMemoryError1.printStackTrace();
        localObject3 = localObject1;
        localObject2 = localObject4;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */