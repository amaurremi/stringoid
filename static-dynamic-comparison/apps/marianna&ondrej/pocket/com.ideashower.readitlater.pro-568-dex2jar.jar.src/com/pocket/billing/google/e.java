package com.pocket.billing.google;

import android.os.Bundle;
import com.ideashower.readitlater.g.m;
import java.util.ArrayList;
import java.util.Iterator;

public class e
  extends m
{
  private final com.android.c.a.a a;
  private final f b;
  private g c;
  private int d;
  
  protected e(com.android.c.a.a parama, f paramf)
  {
    this.a = parama;
    this.b = paramf;
  }
  
  private int k()
  {
    Object localObject1 = this.a.a(3, "com.ideashower.readitlater.pro", a.a.a, a.a());
    if (((Bundle)localObject1).containsKey("DETAILS_LIST"))
    {
      Object localObject2 = ((Bundle)localObject1).getStringArrayList("DETAILS_LIST");
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(GooglePremiumProduct.a((String)((Iterator)localObject2).next()));
      }
      this.c = g.a((ArrayList)localObject1);
      if (this.c == null) {
        return -1;
      }
      return 0;
    }
    return a.a((Bundle)localObject1);
  }
  
  private int l()
  {
    Object localObject = this.a.a(3, "com.ideashower.readitlater.pro", "subs", null);
    int j = a.a((Bundle)localObject);
    int i = j;
    if (j == 0)
    {
      localObject = ((Bundle)localObject).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      i = j;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.c.a(str);
        }
        i = 0;
      }
    }
    return i;
  }
  
  protected void a()
  {
    int j = k();
    int i = j;
    if (j == 0) {
      i = l();
    }
    this.d = i;
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if ((paramBoolean) && (this.c != null))
    {
      this.b.a(this.c);
      return;
    }
    if (this.d == 0) {
      this.d = -1;
    }
    this.b.a(this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/google/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */