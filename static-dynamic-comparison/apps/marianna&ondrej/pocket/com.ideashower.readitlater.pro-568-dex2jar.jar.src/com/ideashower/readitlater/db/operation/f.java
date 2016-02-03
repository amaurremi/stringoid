package com.ideashower.readitlater.db.operation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.net.Uri;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.e.m;
import com.ideashower.readitlater.util.a.b;
import com.ideashower.readitlater.util.e;
import com.pocket.m.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class f
{
  private static Paint a;
  private final m b;
  private String c;
  private String d;
  private String e;
  private a f;
  private long g;
  private ArrayList h;
  private Uri i;
  
  protected f(m paramm, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (!paramm.b()) {
      throw new RuntimeException("local id cannot be 0");
    }
    this.b = paramm;
    this.c = paramString1;
    this.d = paramString2;
    c(paramString3);
    this.g = paramLong;
  }
  
  public static Bitmap a(f paramf, int paramInt, boolean paramBoolean)
  {
    e.b();
    paramf = paramf.e();
    b localb;
    if (paramf != null)
    {
      localb = x.b(com.ideashower.readitlater.f.f.a(paramf, new com.pocket.k.d(paramInt, paramInt), com.pocket.m.a.d.b()).a(1).a(true, com.pocket.m.a.k.a).a());
      if ((localb != null) && (localb.c())) {
        paramf = localb.b().copy(localb.b().getConfig(), false);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (paramf == null) {
          break label194;
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        if (a == null)
        {
          a = new Paint();
          a.setAntiAlias(true);
        }
        a.setShader(new BitmapShader(paramf, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        float f1 = paramInt / 2.0F;
        localCanvas.drawCircle(f1, f1, f1, a);
        a.setShader(null);
        paramf = localBitmap;
      }
      for (;;)
      {
        if (localb != null) {
          localb.b(false);
        }
        return paramf;
        continue;
        label194:
        paramf = null;
      }
      paramf = null;
      continue;
      localb = null;
      paramf = null;
    }
  }
  
  private void c(String paramString)
  {
    if (org.apache.a.c.k.a(paramString, this.e)) {
      return;
    }
    this.e = paramString;
    if (!org.apache.a.c.k.c(this.e)) {}
    for (this.f = a.a(this.e);; this.f = null)
    {
      this.i = null;
      return;
    }
  }
  
  public static Bitmap f()
  {
    return BitmapFactory.decodeResource(g.c().getResources(), 2130837521, null);
  }
  
  public int a()
  {
    return this.b.a();
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt != 0) {
      this.b.a(paramInt);
    }
    this.c = paramString2;
    this.d = paramString1;
    c(paramString3);
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(String paramString)
  {
    if (this.h == null) {
      this.h = new ArrayList();
    }
    if (!this.h.contains(paramString)) {
      this.h.add(paramString);
    }
  }
  
  public int b()
  {
    return this.b.c();
  }
  
  protected boolean b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    return (this.b.c() == paramInt) && (org.apache.a.c.k.a(this.d, paramString1)) && (org.apache.a.c.k.a(this.c, paramString2)) && (org.apache.a.c.k.a(this.e, paramString3));
  }
  
  public boolean b(String paramString)
  {
    if (this.h == null) {
      return false;
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public a e()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.e;
  }
  
  public String h()
  {
    if (m())
    {
      if (!org.apache.a.c.k.c(this.d)) {
        return this.d;
      }
      if ((this.h != null) && (!this.h.isEmpty())) {
        return (String)this.h.get(0);
      }
      if ((!org.apache.a.c.k.c(this.c)) && (!org.apache.a.c.k.g(d(), "*"))) {
        return this.c;
      }
      return g.a(2131493366);
    }
    if ((this.h != null) && (!this.h.isEmpty())) {
      return (String)this.h.get(0);
    }
    if (!org.apache.a.c.k.c(this.d)) {
      return this.d;
    }
    return g.a(2131493366);
  }
  
  public ArrayList i()
  {
    return this.h;
  }
  
  public String j()
  {
    if ((this.h != null) && (this.h.size() > 0)) {
      return (String)this.h.get(0);
    }
    return null;
  }
  
  public Uri k()
  {
    if (this.i == null)
    {
      if (this.e == null) {
        return null;
      }
      this.i = Uri.parse(this.e);
    }
    return this.i;
  }
  
  public long l()
  {
    return this.g;
  }
  
  public boolean m()
  {
    return b() != 0;
  }
  
  public String toString()
  {
    return "Friend [id=" + this.b.toString() + ", username=" + this.c + ", name=" + this.d + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */