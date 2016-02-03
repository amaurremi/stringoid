package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBOrientation;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.c;
import com.chartboost.sdk.c.a;
import com.chartboost.sdk.c.b;
import com.chartboost.sdk.c.c;
import java.util.Locale;
import org.json.JSONObject;

public class a
  extends c
{
  private static Point n = null;
  public g h = new g(this);
  public g i = new g(this);
  public g j = new g(this);
  public g k = new g(this);
  public g l = new g(this);
  public g m = new g(this);
  
  public a(com.chartboost.sdk.Model.a parama)
  {
    super(parama);
    this.e = 6;
  }
  
  private Point a(String paramString)
  {
    paramString = this.f.optJSONObject(paramString);
    if (paramString != null)
    {
      paramString = paramString.optJSONObject("offset");
      if (paramString != null) {
        return new Point(paramString.optInt("x", 0), paramString.optInt("y", 0));
      }
    }
    return new Point(0, 0);
  }
  
  private static Point c(Context paramContext)
  {
    if (n == null) {
      n = new Point(-(int)(CBUtility.b(10, paramContext) + 0.5F), -(int)(CBUtility.b(10, paramContext) + 0.5F));
    }
    return n;
  }
  
  protected c.b a(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (CBPreferences.getInstance().getOrientation().isPortrait()) {}
    for (paramJSONObject = "portrait";; paramJSONObject = "landscape")
    {
      if (this.f.optJSONObject(String.format(Locale.US, "ad-%s", new Object[] { paramJSONObject })) != null) {
        if (this.f.optJSONObject(String.format(Locale.US, "frame-%s", new Object[] { paramJSONObject })) != null) {
          break;
        }
      }
      this.g.a(CBError.CBImpressionError.WRONG_ORIENTATION);
      return;
    }
    this.i.a("ad-landscape");
    this.h.a("ad-portrait");
    this.k.a("frame-landscape");
    this.j.a("frame-portrait");
    this.m.a("close-landscape");
    this.l.a("close-portrait");
  }
  
  public void d()
  {
    super.d();
    this.i.c();
    this.h.c();
    this.k.c();
    this.j.c();
    this.m.c();
    this.l.c();
    this.i = null;
    this.h = null;
    this.k = null;
    this.j = null;
    this.m = null;
    this.l = null;
  }
  
  public class a
    extends c.b
  {
    public ImageView c;
    public ImageView d;
    public Button e;
    public u f;
    
    private a(Context paramContext)
    {
      super(paramContext);
      setBackgroundColor(0);
      setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      this.f = new u(paramContext);
      this.c = new ImageView(paramContext);
      this.e = new Button(paramContext);
      this.d = new ImageView(paramContext);
      this.e.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (a.this.a != null) {
            a.this.a.a();
          }
        }
      });
      this.c.setClickable(true);
      this.c.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (a.this.b != null) {
            a.this.b.a(a.a(a.this), null, null);
          }
        }
      });
      this.f.a(this.d);
      this.f.a(this.c);
      this.f.a(this.e);
      addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      boolean bool = CBPreferences.getInstance().getOrientation().isPortrait();
      Object localObject1;
      g localg1;
      label39:
      g localg2;
      label53:
      RelativeLayout.LayoutParams localLayoutParams1;
      RelativeLayout.LayoutParams localLayoutParams2;
      RelativeLayout.LayoutParams localLayoutParams3;
      Object localObject3;
      if (bool)
      {
        localObject1 = a.this.j;
        if (!bool) {
          break label670;
        }
        localg1 = a.this.h;
        if (!bool) {
          break label682;
        }
        localg2 = a.this.l;
        localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        CBLogging.a("CBNativeInterstitialViewProtocol", "Layout orientation changed");
        localLayoutParams1.width = ((int)(((g)localObject1).a() / ((g)localObject1).f()));
        localLayoutParams1.height = ((int)(((g)localObject1).b() / ((g)localObject1).f()));
        localObject3 = a.this;
        if (!bool) {
          break label694;
        }
        localObject2 = "frame-portrait";
        label150:
        localObject2 = a.a((a)localObject3, (String)localObject2);
        localLayoutParams1.leftMargin = Math.round((paramInt1 - localLayoutParams1.width) / 2.0F + ((Point)localObject2).x / ((g)localObject1).f());
        float f1 = (paramInt2 - localLayoutParams1.height) / 2.0F;
        localLayoutParams1.topMargin = Math.round(((Point)localObject2).y / ((g)localObject1).f() + f1);
        this.c.setId(100);
        localLayoutParams2.width = ((int)(localg1.a() / localg1.f()));
        localLayoutParams2.height = ((int)(localg1.b() / localg1.f()));
        localObject3 = a.this;
        if (!bool) {
          break label701;
        }
        localObject2 = "ad-portrait";
        label283:
        localObject2 = a.a((a)localObject3, (String)localObject2);
        localLayoutParams2.leftMargin = Math.round((paramInt1 - localLayoutParams2.width) / 2.0F + ((Point)localObject2).x / localg1.f());
        f1 = (paramInt2 - localLayoutParams2.height) / 2.0F;
        localLayoutParams2.topMargin = Math.round(((Point)localObject2).y / localg1.f() + f1);
        localLayoutParams3.width = ((int)(localg2.a() / localg2.f()));
        localLayoutParams3.height = ((int)(localg2.b() / localg2.f()));
        localObject3 = a.this;
        if (!bool) {
          break label708;
        }
      }
      label670:
      label682:
      label694:
      label701:
      label708:
      for (Object localObject2 = "close-portrait";; localObject2 = "close-landscape")
      {
        localObject2 = a.a((a)localObject3, (String)localObject2);
        localObject3 = a.b(getContext());
        int i = localLayoutParams2.leftMargin;
        int j = localLayoutParams2.width;
        int k = Math.round(((Point)localObject2).x + ((Point)localObject3).x);
        int m = localLayoutParams2.topMargin;
        int n = localLayoutParams3.height;
        int i1 = Math.round(((Point)localObject2).y + ((Point)localObject3).y);
        localLayoutParams3.leftMargin = Math.min(Math.max(0, i + j + k), paramInt1 - localLayoutParams3.width);
        localLayoutParams3.topMargin = Math.min(Math.max(0, i1 + (m - n)), paramInt2 - localLayoutParams3.height);
        this.d.setLayoutParams(localLayoutParams1);
        this.c.setLayoutParams(localLayoutParams2);
        this.e.setLayoutParams(localLayoutParams3);
        localObject1 = new BitmapDrawable(((g)localObject1).e());
        this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.d.setImageDrawable((Drawable)localObject1);
        localObject1 = new BitmapDrawable(localg1.e());
        this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.c.setImageDrawable((Drawable)localObject1);
        localObject1 = new BitmapDrawable(localg2.e());
        this.e.setBackgroundDrawable((Drawable)localObject1);
        return;
        localObject1 = a.this.k;
        break;
        localg1 = a.this.i;
        break label39;
        localg2 = a.this.m;
        break label53;
        localObject2 = "frame-landscape";
        break label150;
        localObject2 = "ad-landscape";
        break label283;
      }
    }
    
    public void c()
    {
      super.c();
      this.d = null;
      this.c = null;
      this.e = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */