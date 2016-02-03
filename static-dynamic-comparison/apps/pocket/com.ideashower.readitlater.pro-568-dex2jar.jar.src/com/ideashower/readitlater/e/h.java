package com.ideashower.readitlater.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.ideashower.readitlater.f.e;
import com.ideashower.readitlater.f.f;
import com.ideashower.readitlater.util.a.b;
import com.pocket.m.a.a;
import com.pocket.m.a.d;
import com.pocket.m.a.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

class h
{
  private final ObjectNode b;
  private BitmapDrawable c;
  private int d;
  
  private h(g paramg, ObjectNode paramObjectNode)
  {
    this.b = paramObjectNode;
  }
  
  private BitmapDrawable a(final Context paramContext, final j paramj)
  {
    Object localObject = paramContext.getResources().getDisplayMetrics();
    final int i = ((DisplayMetrics)localObject).densityDpi;
    if ((this.c != null) && (this.d == i)) {
      return this.c;
    }
    this.c = null;
    this.d = i;
    localObject = g.a(((DisplayMetrics)localObject).density, this.b);
    String str = this.b.get((String)localObject).asText();
    final int j = g.a((String)localObject);
    f.a(str, null, d.b()).a(true, k.a).a(new com.ideashower.readitlater.f.g()
    {
      public void a(e paramAnonymouse, b paramAnonymousb)
      {
        h.a(h.this, paramContext, paramAnonymouse.f().c(), j, i, paramj);
        paramAnonymouse.m();
      }
      
      public boolean a(e paramAnonymouse)
      {
        return true;
      }
    }, false, false).b();
    return null;
  }
  
  private void a(Context paramContext, Bitmap paramBitmap, float paramFloat, j paramj)
  {
    if (paramFloat != this.d) {}
    do
    {
      return;
      this.c = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
    } while (paramj == null);
    paramj.a(this.a, this.c);
  }
  
  private void a(final Context paramContext, final String paramString, int paramInt1, final int paramInt2, final j paramj)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScreenDensity = paramInt2;
    localOptions.inTargetDensity = paramInt2;
    localOptions.inDensity = paramInt1;
    localOptions.inScaled = true;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if (com.ideashower.readitlater.a.g.q())
    {
      a(paramContext, paramString, paramInt2, paramj);
      return;
    }
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run()
      {
        h.a(h.this, paramContext, paramString, paramInt2, paramj);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */