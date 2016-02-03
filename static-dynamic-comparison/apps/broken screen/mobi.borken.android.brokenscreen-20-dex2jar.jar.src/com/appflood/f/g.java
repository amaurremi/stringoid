package com.appflood.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appflood.b.b.a;
import com.appflood.c.d;
import com.appflood.e.j;
import com.appflood.e.k;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends RelativeLayout
{
  private float a = 1.0F;
  private int b;
  private com.appflood.e.b c = new com.appflood.e.b((this.b << 1) + 212, (this.b << 1) + 162);
  private com.appflood.e.b d = new com.appflood.e.b((this.b << 1) + 448, (this.b << 1) + 295);
  private boolean e;
  private Context f;
  private e g = null;
  private f h = null;
  private i[] i = null;
  private Paint j = new Paint();
  private com.appflood.e.b k = new com.appflood.e.b();
  private RectF l = new RectF();
  
  public g(Context paramContext, final boolean paramBoolean, float paramFloat, int paramInt)
  {
    super(paramContext);
    this.f = paramContext;
    this.e = paramBoolean;
    this.a = paramFloat;
    this.b = paramInt;
    try
    {
      this.i = new i[4];
      if (this.e)
      {
        this.c = new com.appflood.e.b((paramInt << 1) + 212, (paramInt << 1) + 162);
        this.d = new com.appflood.e.b((paramInt << 1) + 448, (paramInt << 1) + 295);
        this.c.a(paramFloat);
        this.d.a(paramFloat);
        setWillNotDraw(false);
        if (!this.e) {
          break label378;
        }
        a();
      }
      for (;;)
      {
        if (j.a(d.m)) {
          break label385;
        }
        paramBoolean = bool;
        if (com.appflood.c.g.a().a != null) {
          paramBoolean = true;
        }
        if (paramBoolean) {
          a(com.appflood.c.g.a().a);
        }
        new com.appflood.b.b(d.m, null).a(new b.a()
        {
          public final void a(com.appflood.b.b paramAnonymousb)
          {
            paramAnonymousb = j.e(paramAnonymousb.c());
            int i = j.a(paramAnonymousb, "ret", -1);
            paramAnonymousb = j.e(j.a(paramAnonymousb, "data", null));
            d.x = j.a(paramAnonymousb, "show_cb_url", "");
            paramAnonymousb = j.a(paramAnonymousb, "data", "");
            JSONObject[] arrayOfJSONObject;
            if (i == 0)
            {
              paramAnonymousb = j.f(paramAnonymousb);
              arrayOfJSONObject = new JSONObject[paramAnonymousb.length()];
              i = 0;
              for (;;)
              {
                if (i < paramAnonymousb.length()) {
                  try
                  {
                    arrayOfJSONObject[i] = paramAnonymousb.getJSONObject(i);
                    i += 1;
                  }
                  catch (Throwable localThrowable)
                  {
                    for (;;)
                    {
                      j.a(localThrowable, "Failed to get a jsonobject from JsonArray");
                    }
                  }
                }
              }
              if (paramBoolean) {
                com.appflood.c.g.a().a = arrayOfJSONObject;
              }
            }
            else
            {
              return;
            }
            g.a(g.this, arrayOfJSONObject);
          }
          
          public final void a(com.appflood.b.b paramAnonymousb, int paramAnonymousInt)
          {
            com.appflood.c.e.a().a(false, 2);
          }
        }).f();
        return;
        this.c = new com.appflood.e.b((paramInt << 1) + 169, (paramInt << 1) + 130);
        this.d = new com.appflood.e.b((paramInt << 1) + 486, (paramInt << 1) + 251);
        break;
        label378:
        b();
      }
      label385:
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private void a()
  {
    int n = 0;
    int i1 = (int)((16 - this.b * 1) * this.a);
    this.g = new e(this.f, this.a, this.b);
    this.g.setId(5);
    Object localObject = new RelativeLayout.LayoutParams((int)this.d.a, (int)this.d.b);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    addView(this.g, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams[4];
    int m = 0;
    while (m < this.i.length)
    {
      this.i[m] = new i(this.f, this.a, this.e);
      localObject[m] = new RelativeLayout.LayoutParams((int)this.c.a, (int)this.c.b);
      m += 1;
    }
    this.i[0].setId(6);
    localObject[0].addRule(9);
    localObject[0].addRule(3, 5);
    localObject[0].topMargin = i1;
    this.i[1].setId(7);
    localObject[1].addRule(11);
    localObject[1].addRule(6, 6);
    localObject[2].addRule(9);
    localObject[2].addRule(12);
    localObject[3].addRule(11);
    localObject[3].addRule(12);
    m = n;
    while (m < this.i.length)
    {
      addView(this.i[m], localObject[m]);
      m += 1;
    }
  }
  
  private void a(JSONObject[] paramArrayOfJSONObject)
  {
    com.appflood.c.e.a().a(true, 2);
    final int m = 0;
    if (m < 5)
    {
      final Object localObject3 = paramArrayOfJSONObject[m];
      String str1 = j.a((JSONObject)localObject3, "name", null);
      String str2 = j.a((JSONObject)localObject3, "desc", null);
      Object localObject1 = j.a((JSONObject)localObject3, "click_url", "");
      final Object localObject2 = localObject1;
      if (!((String)localObject1).contains("://")) {
        localObject2 = k.b((String)localObject1, null).toString();
      }
      localObject3 = j.a((JSONObject)localObject3, "back_url", "");
      if (m == 0) {
        if (this.e) {
          localObject1 = this.g;
        }
      }
      for (;;)
      {
        ((a)localObject1).a(str1, str2);
        ((a)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            try
            {
              if (!j.a(localObject3)) {
                new com.appflood.b.b(localObject3, null).b(true);
              }
              try
              {
                com.appflood.c.e.a().a(true, j.a("type", Integer.valueOf(2)));
                paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse(localObject2));
                g.a(g.this).startActivity(paramAnonymousView);
                return;
              }
              catch (Throwable paramAnonymousView)
              {
                for (;;)
                {
                  j.b(paramAnonymousView, "error in fireEventDelegate");
                }
              }
              return;
            }
            catch (Throwable paramAnonymousView) {}
          }
        });
        m += 1;
        break;
        localObject1 = this.h;
        continue;
        localObject1 = this.i[(m - 1)];
      }
    }
    m = 0;
    while (m < paramArrayOfJSONObject.length)
    {
      new com.appflood.b.b(paramArrayOfJSONObject[m]).a(new b.a()
      {
        public final void a(com.appflood.b.b paramAnonymousb)
        {
          try
          {
            g.a(g.this, m, paramAnonymousb.d());
            return;
          }
          catch (Throwable paramAnonymousb)
          {
            j.a(paramAnonymousb, "Panel Image failed");
          }
        }
        
        public final void a(com.appflood.b.b paramAnonymousb, int paramAnonymousInt)
        {
          j.c("Panel image url connection failed statuscode = " + paramAnonymousInt);
        }
      }).f();
      m += 1;
    }
  }
  
  private void b()
  {
    int n = 0;
    int i1 = (int)((21 - this.b * 2) * this.a);
    int i2 = (int)((25 - this.b) * this.a);
    int i3 = (int)((10 - this.b) * this.a);
    this.h = new f(this.f, this.a, this.b);
    this.h.setId(5);
    Object localObject = new RelativeLayout.LayoutParams((int)this.d.a, (int)this.d.b);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    addView(this.h, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams[4];
    int m = 0;
    while (m < this.i.length)
    {
      this.i[m] = new i(this.f, this.a, this.e);
      localObject[m] = new RelativeLayout.LayoutParams((int)this.c.a, (int)this.c.b);
      m += 1;
    }
    this.i[0].setId(6);
    localObject[0].addRule(9);
    localObject[0].addRule(3, 5);
    localObject[0].leftMargin = i2;
    localObject[0].topMargin = (-i3);
    this.i[1].setId(7);
    localObject[1].addRule(1, 6);
    localObject[1].addRule(6, 6);
    localObject[1].leftMargin = (-i1);
    this.i[2].setId(8);
    localObject[2].addRule(1, 7);
    localObject[2].addRule(6, 7);
    localObject[2].leftMargin = (-i1);
    localObject[3].addRule(1, 8);
    localObject[3].addRule(6, 7);
    localObject[3].leftMargin = (-i1);
    m = n;
    while (m < this.i.length)
    {
      addView(this.i[m], localObject[m]);
      m += 1;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    try
    {
      if (!this.e)
      {
        com.appflood.e.b localb = this.k;
        localb.a = 722.0F;
        localb.b = 131.0F;
        this.k.a(this.a);
        this.l.set(0.0F, getHeight() - (int)this.k.b - 1, (int)this.k.a - 1, getHeight() - 1);
        this.j.setColor(-526083);
        this.j.setStyle(Paint.Style.FILL);
        paramCanvas.drawRoundRect(this.l, 3.0F, 3.0F, this.j);
        this.j.setColor(-4010527);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.clearShadowLayer();
        paramCanvas.drawRoundRect(this.l, 3.0F, 3.0F, this.j);
      }
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */