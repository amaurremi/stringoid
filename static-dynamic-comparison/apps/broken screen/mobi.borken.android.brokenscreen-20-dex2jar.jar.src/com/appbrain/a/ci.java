package com.appbrain.a;

import cmn.h;
import com.appbrain.e.a.e;
import com.appbrain.e.j.m;
import com.appbrain.e.j.m.a;

final class ci
  implements Runnable
{
  ci(cg.a parama, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    int j = 0;
    Object localObject = j.m.j();
    String[] arrayOfString = this.a.split(",");
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      if (h.a(cg.a.access$000(this.d), str)) {
        ((j.m.a)localObject).b(str);
      }
      i += 1;
    }
    arrayOfString = this.b.split(",");
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      ((j.m.a)localObject).a(arrayOfString[i]);
      i += 1;
    }
    ((j.m.a)localObject).c(this.c);
    try
    {
      localObject = c.a(cg.a.access$000(this.d)).a(((j.m.a)localObject).d());
      if (localObject != null) {
        cj.a(cg.a.access$000(this.d), ((a.e)localObject).h());
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */