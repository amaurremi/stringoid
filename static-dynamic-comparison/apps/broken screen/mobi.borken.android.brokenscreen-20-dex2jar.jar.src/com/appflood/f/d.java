package com.appflood.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.e.j;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public final class d
  extends ImageView
{
  private Bitmap a;
  private c b;
  private Timer c;
  private TimerTask d;
  
  public d(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    setBackgroundColor(0);
    this.b = new c();
    paramContext = new b(com.appflood.c.d.z + "video_loading.gif", (byte)0);
    paramContext.a(new b.a()
    {
      public final void a(b paramAnonymousb)
      {
        new StringBuilder(" finished ").append(paramAnonymousb.a().toString()).append(paramAnonymousb.b()).toString();
        j.a();
        paramAnonymousb = new ByteArrayInputStream(paramAnonymousb.b());
        d.a(d.this).a(paramAnonymousb);
        d.a(d.this, d.a(d.this).a(0));
      }
      
      public final void a(b paramAnonymousb, int paramAnonymousInt) {}
    });
    paramContext.f();
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.c == null)
    {
      this.c = new Timer();
      this.d = new TimerTask()
      {
        public final void run()
        {
          d.this.postInvalidate();
        }
      };
    }
    this.c.schedule(this.d, 0L, 200L);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.c != null)
    {
      this.c.cancel();
      this.c = null;
      this.d = null;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      RectF localRectF = new RectF(new Rect(0, 0, getWidth(), getHeight()));
      paramCanvas.drawBitmap(this.a, null, localRectF, null);
      paramCanvas = this.b;
      paramCanvas.a += 1;
      if (paramCanvas.a > paramCanvas.b.size() - 1) {
        paramCanvas.a = 0;
      }
      this.a = ((c.a)paramCanvas.b.elementAt(paramCanvas.a)).a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */