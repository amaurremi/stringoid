package com.appbrain.a;

import cmn.x;
import com.appbrain.e.at;
import com.appbrain.e.au;
import com.appbrain.e.h;

final class ad
  implements Runnable
{
  ad(ab paramab, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    int j = 0;
    Object localObject = at.j();
    String[] arrayOfString = this.a.split(",");
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      if (x.a(ab.access$000(this.d), str)) {
        ((au)localObject).b(str);
      }
      i += 1;
    }
    arrayOfString = this.b.split(",");
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      ((au)localObject).a(arrayOfString[i]);
      i += 1;
    }
    ((au)localObject).c(this.c);
    try
    {
      localObject = av.a(ab.access$000(this.d)).a(((au)localObject).d());
      if (localObject != null) {
        ae.a(ab.access$000(this.d), ((h)localObject).h());
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */