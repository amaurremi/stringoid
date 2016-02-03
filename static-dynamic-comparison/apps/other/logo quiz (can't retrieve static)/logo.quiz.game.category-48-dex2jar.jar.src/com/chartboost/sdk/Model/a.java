package com.chartboost.sdk.Model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.c;
import com.chartboost.sdk.c.a;
import com.chartboost.sdk.c.b;
import com.chartboost.sdk.c.c;
import com.chartboost.sdk.c.d;
import com.chartboost.sdk.impl.g;
import com.chartboost.sdk.impl.j;
import com.chartboost.sdk.impl.t;
import com.chartboost.sdk.impl.t.a;
import com.chartboost.sdk.impl.w;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public final class a
{
  public JSONObject a;
  public Date b;
  public b c = b.a;
  public c d;
  public String e;
  public boolean f;
  public boolean g = false;
  public t h;
  public boolean i;
  public boolean j = false;
  public boolean k = false;
  public j l;
  private c m;
  private a n;
  private Runnable o;
  private Runnable p;
  
  public a(c paramc, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this.f = paramBoolean1;
    this.e = paramString;
    this.d = paramc;
    this.i = paramBoolean2;
  }
  
  public void a(CBError.CBImpressionError paramCBImpressionError)
  {
    if (this.m.d != null) {
      this.m.d.a(paramCBImpressionError);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.o = paramRunnable;
  }
  
  public void a(JSONObject paramJSONObject, a parama)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    this.a = localJSONObject;
    this.b = new Date();
    this.c = b.a;
    this.n = parama;
    boolean bool = localJSONObject.optString("type", "").equals("native");
    if ((bool) && (this.d == c.a)) {
      this.m = new com.chartboost.sdk.impl.a(this);
    }
    for (;;)
    {
      this.m.c = new c.a()
      {
        public void a()
        {
          if (a.a(jdField_this) != null) {
            a.a(jdField_this).a(jdField_this);
          }
        }
      };
      this.m.a = new c.a()
      {
        public void a()
        {
          if (a.a(jdField_this) != null) {
            a.a(jdField_this).b(jdField_this);
          }
        }
      };
      this.m.b = new c.c()
      {
        public void a(a paramAnonymousa, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          if ((paramAnonymousa.c != a.b.c) || (paramAnonymousa.k)) {
            return;
          }
          if (paramAnonymousString != null) {}
          for (;;)
          {
            String str = jdField_this.a.optString("deep-link");
            paramAnonymousa = paramAnonymousString;
            if (str != null)
            {
              paramAnonymousa = paramAnonymousString;
              if (str.equals("")) {}
            }
            try
            {
              paramAnonymousa = new Intent("android.intent.action.VIEW", Uri.parse(str));
              int i = Chartboost.sharedChartboost().getContext().getPackageManager().queryIntentActivities(paramAnonymousa, 65536).size();
              paramAnonymousa = paramAnonymousString;
              if (i > 0) {
                paramAnonymousa = str;
              }
            }
            catch (Exception paramAnonymousa)
            {
              for (;;)
              {
                paramAnonymousa = paramAnonymousString;
              }
            }
            a.a(jdField_this).a(jdField_this, paramAnonymousa, paramAnonymousJSONObject);
            return;
            paramAnonymousString = jdField_this.a.optString("link");
          }
        }
      };
      this.m.d = new c.d()
      {
        public void a(CBError.CBImpressionError paramAnonymousCBImpressionError)
        {
          if (a.a(jdField_this) != null) {
            a.a(jdField_this).a(jdField_this, paramAnonymousCBImpressionError);
          }
        }
      };
      this.m.a(localJSONObject);
      return;
      if ((bool) && (this.d == c.b)) {
        this.m = new g(this);
      } else {
        this.m = new w(this);
      }
    }
  }
  
  public boolean a()
  {
    this.m.b();
    return this.m.e() != null;
  }
  
  public void b()
  {
    c();
    if (this.m != null) {
      this.m.d();
    }
    this.m = null;
  }
  
  public void b(Runnable paramRunnable)
  {
    this.p = paramRunnable;
  }
  
  public void c()
  {
    if (this.h != null) {
      this.h.d();
    }
    try
    {
      if (this.m.e().getParent() != null) {
        this.h.removeView(this.m.e());
      }
      this.h = null;
      if (this.m != null) {
        this.m.f();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CBLogging.b("CBImpression", "Exception raised while cleaning up views", localException);
      }
    }
  }
  
  public CBError.CBImpressionError d()
  {
    return this.m.c();
  }
  
  public t.a e()
  {
    return this.m.e();
  }
  
  public void f()
  {
    if ((this.m != null) && (this.m.e() != null)) {
      this.m.e().setVisibility(8);
    }
    if (this.o != null)
    {
      this.o.run();
      this.o = null;
    }
  }
  
  public void g()
  {
    this.k = true;
  }
  
  public void h()
  {
    if (this.p != null)
    {
      this.p.run();
      this.p = null;
    }
    this.k = false;
    this.j = false;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(a parama, CBError.CBImpressionError paramCBImpressionError);
    
    public abstract void a(a parama, String paramString, JSONObject paramJSONObject);
    
    public abstract void b(a parama);
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */