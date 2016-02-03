package com.vungle.publisher.ad;

import android.content.Context;
import android.content.Intent;
import com.vungle.publisher.VungleService;
import com.vungle.publisher.inject.annotations.VungleServiceClass;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AdPreparer
{
  @Inject
  public Context a;
  @VungleServiceClass
  @Inject
  Class b;
  
  public final Intent a()
  {
    return new Intent(VungleService.PREPARE_AD_ACTION, null, this.a, this.b);
  }
  
  public final void a(String paramString)
  {
    Logger.d("VunglePrepare", "sending prepare ad request: " + paramString);
    Intent localIntent = a();
    localIntent.putExtra("adId", paramString);
    this.a.startService(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ad/AdPreparer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */