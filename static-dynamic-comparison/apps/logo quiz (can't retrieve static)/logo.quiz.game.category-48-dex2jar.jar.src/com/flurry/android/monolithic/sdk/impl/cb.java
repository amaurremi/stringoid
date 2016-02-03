package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.List;

public class cb
  implements ca
{
  private static final String a = cb.class.getSimpleName();
  private br b;
  
  private void a()
  {
    try
    {
      if (this.b != null)
      {
        this.b.a(true);
        this.b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, List<AdUnit> paramList)
  {
    if (paramInt2 < 2) {
      a(paramString, paramList);
    }
  }
  
  public void a(String paramString, List<AdUnit> paramList)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.b;
        if (localObject != null) {
          return;
        }
        if ((paramList == null) || (paramList.size() == 0) || (((AdUnit)paramList.get(0)).d().size() == 0)) {
          break label232;
        }
        if (((AdFrame)((AdUnit)paramList.get(0)).d().get(0)).e() != null) {
          break label188;
        }
      }
      finally {}
      if (i != 0)
      {
        localObject = FlurryAdSize.BANNER_BOTTOM;
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder().append("Starting AsyncAdTask from EnsureCacheNotEmpty size: ");
        if (paramList != null)
        {
          paramList = Integer.toString(paramList.size());
          ja.a(3, str, paramList);
          paramList = FlurryAdModule.getInstance();
          paramList.getClass();
          this.b = new br(paramList, paramString, null, false, (FlurryAdSize)localObject, new cc(this));
          this.b.a();
          continue;
          label188:
          i = 0;
          continue;
        }
      }
      else
      {
        localObject = ab.b(((AdFrame)((AdUnit)paramList.get(0)).d().get(0)).e());
        continue;
      }
      paramList = "";
      continue;
      label232:
      int i = 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */