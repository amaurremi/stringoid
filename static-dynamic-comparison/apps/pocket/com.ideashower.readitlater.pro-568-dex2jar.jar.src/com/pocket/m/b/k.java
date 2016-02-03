package com.pocket.m.b;

import android.content.Context;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.y;
import com.pocket.oauth.q;
import java.util.ArrayList;
import java.util.Iterator;
import twitter4j.Twitter;

public class k
  extends e
{
  private ArrayList f = new ArrayList();
  private y g;
  private final int h;
  private final Context p;
  
  public k(ArrayList paramArrayList, int paramInt1, int paramInt2, com.pocket.m.a.k paramk, Context paramContext)
  {
    super(paramInt2, paramk);
    this.f = paramArrayList;
    this.h = paramInt1;
    this.p = paramContext;
  }
  
  protected void a()
  {
    Twitter localTwitter = q.a(this.p);
    if (localTwitter != null)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        y localy = (y)localIterator.next();
        if (!localy.n())
        {
          this.g = y.a(localTwitter.showStatus(localy.b()), true);
          this.g.a(this.h);
          new j()
          {
            protected void c_()
            {
              a(k.a(k.this));
            }
          }.f();
        }
      }
    }
  }
  
  public y l()
  {
    return this.g;
  }
  
  public int m()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */