package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.util.IntentUtils;
import com.mopub.mobileads.util.Utils;

class MoPubBrowserController
  extends MraidAbstractController
{
  private static final String LOGTAG = "MoPubBrowserController";
  private Context mContext;
  
  MoPubBrowserController(MraidView paramMraidView)
  {
    super(paramMraidView);
    this.mContext = paramMraidView.getContext();
  }
  
  private boolean isWebSiteUrl(String paramString)
  {
    return (paramString.startsWith("http://")) || (paramString.startsWith("https://"));
  }
  
  private boolean launchApplicationUrl(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    return Utils.executeIntent(getMraidView().getContext(), paramString, "Unable to open intent.");
  }
  
  protected void open(String paramString)
  {
    Log.d("MoPubBrowserController", "Opening url: " + paramString);
    Object localObject = getMraidView();
    if (((MraidView)localObject).getMraidListener() != null) {
      ((MraidView)localObject).getMraidListener().onOpen((MraidView)localObject);
    }
    if ((!isWebSiteUrl(paramString)) && (IntentUtils.canHandleApplicationUrl(this.mContext, paramString)))
    {
      launchApplicationUrl(paramString);
      return;
    }
    localObject = new Intent(this.mContext, MoPubBrowser.class);
    ((Intent)localObject).putExtra("URL", paramString);
    ((Intent)localObject).addFlags(268435456);
    this.mContext.startActivity((Intent)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MoPubBrowserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */