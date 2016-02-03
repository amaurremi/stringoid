package com.pocket.q.a;

import android.support.v4.app.f;
import android.view.View;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.h;
import com.pocket.tts.o;
import com.pocket.tts.p;
import com.pocket.tts.q;
import org.apache.a.c.k;

public class w
  extends a
{
  private p g = p.a();
  private String i;
  
  public w(h paramh)
  {
    super(paramh, paramh.m().getString(2131493710), null, null, null);
    o localo = this.g.c();
    paramh = (h)localObject;
    if (localo != null) {
      paramh = localo.b;
    }
    this.i = paramh;
  }
  
  public boolean a()
  {
    this.g = p.a();
    Object localObject = this.g.c();
    if (localObject != null) {}
    for (localObject = ((o)localObject).b; !k.a((CharSequence)localObject, this.i); localObject = null)
    {
      this.i = ((String)localObject);
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public int d()
  {
    return 1;
  }
  
  public String f()
  {
    if (this.i != null) {
      return this.i;
    }
    return g.a(2131493711);
  }
  
  public void onClick(View paramView)
  {
    this.g.a(this.h.m(), new q()
    {
      public void a() {}
      
      public void a(o paramAnonymouso)
      {
        w.this.a();
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */