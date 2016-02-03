package com.appflood.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.appflood.AFListActivity.1;
import com.appflood.AppFlood.AFRequestDelegate;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.e.j;
import com.appflood.e.k;
import java.net.URL;
import java.util.Random;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  JSONObject[] a;
  JSONObject b;
  public View c;
  boolean d = false;
  boolean e = true;
  boolean f = true;
  public boolean g = true;
  int h = 17;
  a i = null;
  private int j = -1;
  private float k = 5.0F;
  
  public c(View paramView, a parama)
  {
    this.c = paramView;
    this.f = false;
    this.d = true;
    this.h = 13;
    this.k = 0.0F;
    this.i = parama;
    if (!d.H) {
      return;
    }
    d.a(new d.a()
    {
      public final void a()
      {
        c localc = c.this;
        g.a().a(localc.h, new c.2(localc), false);
      }
    });
  }
  
  private int a(int paramInt)
  {
    if (this.h == 13) {
      return new Random().nextInt(this.a.length);
    }
    return (paramInt + 1) % this.a.length;
  }
  
  final void a()
  {
    if (this.c == null) {
      return;
    }
    int m = 0;
    for (;;)
    {
      try
      {
        if (m >= this.a.length) {
          break;
        }
        int n = a(this.j + m);
        this.b = this.a[n];
        new StringBuilder("current json ").append(this.b).append("  iiii ").append(n).toString();
        j.a();
        Object localObject = new b(this.a[n]);
        if (((b)localObject).e())
        {
          localObject = ((b)localObject).d();
          if (localObject != null)
          {
            this.j = n;
            a((Bitmap)localObject);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        j.b(localThrowable, "error in refreshView");
        return;
      }
      m += 1;
    }
    this.j = a(this.j);
    this.b = this.a[this.j];
    new b(this.a[this.j]).a(new b.a()
    {
      public final void a(b paramAnonymousb)
      {
        c.this.a(paramAnonymousb.d());
      }
      
      public final void a(b paramAnonymousb, int paramAnonymousInt)
      {
        c.this.a(null);
      }
    }).f();
  }
  
  final void a(final Bitmap paramBitmap)
  {
    if (this.c == null) {
      return;
    }
    final Object localObject = paramBitmap;
    if (paramBitmap != null) {
      localObject = paramBitmap;
    }
    for (;;)
    {
      try
      {
        if (this.k > 0.0F) {
          localObject = AFListActivity.1.a(paramBitmap, this.k);
        }
        if (localObject == null)
        {
          try
          {
            if (this.a.length > 1) {
              continue;
            }
            f.a(new Runnable()
            {
              public final void run()
              {
                try
                {
                  if ((c.this.i != null) && (c.this.e))
                  {
                    c.this.i.a(false);
                    c.this.e = false;
                  }
                  return;
                }
                catch (Throwable localThrowable) {}
              }
            });
            return;
          }
          catch (Throwable paramBitmap) {}
          f.a(new Runnable()
          {
            public final void run()
            {
              try
              {
                if (c.this.c != null)
                {
                  localObject.getWidth();
                  localObject.getHeight();
                  Object localObject = j.a(c.this.b, "app_type", "");
                  new StringBuilder("apptype ").append((String)localObject).toString();
                  j.a();
                  if ((c.this.c instanceof ImageView)) {
                    ((ImageView)c.this.c).setImageBitmap(localObject);
                  }
                  for (;;)
                  {
                    if (c.this.i != null)
                    {
                      if ((c.this.d) && ((c.this.h == 10) || (c.this.h == 13)))
                      {
                        int i = localObject.getWidth();
                        int j = localObject.getHeight();
                        c.this.b.put("width_bitmap", i);
                        c.this.b.put("height_bitmap", j);
                        localObject = c.this.i;
                        JSONObject localJSONObject = c.this.b;
                        ((c.a)localObject).a();
                      }
                      if (c.this.e)
                      {
                        c.this.i.a(true);
                        c.this.e = false;
                      }
                    }
                    if ((c.this.c == null) || (!c.this.c.isShown())) {
                      break;
                    }
                    new b(j.a(c.this.b, "show_cb_url", "")).f();
                    return;
                    c.this.c.setBackgroundDrawable(new BitmapDrawable(localObject));
                  }
                }
                return;
              }
              catch (Throwable localThrowable)
              {
                j.b(localThrowable, "error in adView.setImageBitmap");
              }
            }
          });
          try
          {
            JSONObject localJSONObject = this.a[this.j];
            if (this.c == null) {
              break;
            }
            localObject = j.a(localJSONObject, "click_url", "");
            paramBitmap = (Bitmap)localObject;
            if (!((String)localObject).contains("://")) {
              paramBitmap = k.b((String)localObject, null).toString();
            }
            localObject = j.a(localJSONObject, "back_url", "");
            this.c.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                for (;;)
                {
                  try
                  {
                    if (!j.a(localObject)) {
                      new b(localObject, null).b(true);
                    }
                    try
                    {
                      paramAnonymousView = e.a();
                      if (c.this.h != 13) {
                        continue;
                      }
                      i = 128;
                      paramAnonymousView.a(true, j.a("type", Integer.valueOf(i)));
                    }
                    catch (Throwable paramAnonymousView)
                    {
                      int i;
                      j.b(paramAnonymousView, "error in fireEventDelegate");
                      continue;
                    }
                    if ((!c.this.f) && (c.this.g) && (c.this.a.length > 1)) {
                      c.this.a();
                    }
                    paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse(paramBitmap));
                    c.this.c.getContext().startActivity(paramAnonymousView);
                    return;
                  }
                  catch (Throwable paramAnonymousView) {}
                  i = c.this.h;
                  if (i == 10) {
                    i = 4;
                  } else {
                    i = 1;
                  }
                }
              }
            });
            return;
          }
          catch (Throwable paramBitmap)
          {
            j.b(paramBitmap, "error in generateView");
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        j.b(localThrowable, "error in getRoundedCornerBitmap");
        Bitmap localBitmap = paramBitmap;
        continue;
        a();
        return;
      }
      if (this.a.length > 1)
      {
        new b(this.a[a(this.j)]).f();
        if (this.f) {
          f.a(new TimerTask()
          {
            public final void run()
            {
              c.this.a();
            }
          }, d.B);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */