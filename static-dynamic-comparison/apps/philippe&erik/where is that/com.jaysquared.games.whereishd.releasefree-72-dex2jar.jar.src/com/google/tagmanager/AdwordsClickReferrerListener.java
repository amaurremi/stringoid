package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

class AdwordsClickReferrerListener
  implements DataLayer.Listener
{
  private final Context context;
  
  public AdwordsClickReferrerListener(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void changed(Map<Object, Object> paramMap)
  {
    Object localObject2 = paramMap.get("gtm.url");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramMap = paramMap.get("gtm");
      localObject1 = localObject2;
      if (paramMap != null)
      {
        localObject1 = localObject2;
        if ((paramMap instanceof Map)) {
          localObject1 = ((Map)paramMap).get("url");
        }
      }
    }
    if ((localObject1 == null) || (!(localObject1 instanceof String))) {}
    do
    {
      return;
      paramMap = Uri.parse((String)localObject1).getQueryParameter("referrer");
    } while (paramMap == null);
    InstallReferrerUtil.addClickReferrer(this.context, paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/AdwordsClickReferrerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */