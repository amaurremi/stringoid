package com.pocket.q.a;

import android.widget.TextView;
import com.e.b.a;
import com.ideashower.readitlater.a.g;
import com.pocket.m.a.f;

class e
  implements f
{
  private final Runnable b = new Runnable()
  {
    public void run()
    {
      e.a(e.this);
    }
  };
  private long c;
  
  private e(d paramd) {}
  
  private void a()
  {
    if ((com.pocket.m.a.e.j()) || ((com.pocket.m.a.e.i()) && (com.pocket.m.a.a.c.b())))
    {
      d.b(this.a).setVisibility(0);
      d.b(this.a).setText(2131493632);
      return;
    }
    if (com.pocket.m.a.a.c.b())
    {
      d.b(this.a).setVisibility(4);
      return;
    }
    if (com.pocket.m.a.e.i())
    {
      d.b(this.a).setVisibility(4);
      return;
    }
    d.b(this.a).setVisibility(0);
    a(this.c + com.pocket.p.c.b(15.0F), 2131493633);
  }
  
  private void a(long paramLong, int paramInt)
  {
    float f;
    Object localObject;
    if (paramLong >= com.pocket.p.c.c(1.0F))
    {
      f = (float)Math.round(com.pocket.p.c.b(paramLong) * 100.0D) / 100.0F;
      localObject = d.c(this.a);
      if (!localObject.equals(d.d(this.a))) {
        break label143;
      }
    }
    label143:
    for (String str = String.valueOf((int)f);; str = String.format("%.2f", new Object[] { Float.valueOf(f) }))
    {
      localObject = str + " " + localObject;
      localObject = a.a(this.a.getContext(), paramInt).a("disk_space_size", (CharSequence)localObject).a();
      d.b(this.a).setText((CharSequence)localObject);
      return;
      f = (float)Math.round(com.pocket.p.c.a(paramLong));
      localObject = d.d(this.a);
      break;
    }
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
    if (!g.q())
    {
      g.a(this.b);
      return;
    }
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */