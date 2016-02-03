package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

class MraidBrowserController
  extends MraidAbstractController
{
  private static final String LOGTAG = "MraidBrowserController";
  
  MraidBrowserController(MraidView paramMraidView)
  {
    super(paramMraidView);
  }
  
  protected void open(String paramString)
  {
    Log.d("MraidBrowserController", "Opening in-app browser: " + paramString);
    Object localObject = getView();
    if (((MraidView)localObject).getOnOpenListener() != null) {
      ((MraidView)localObject).getOnOpenListener().onOpen((MraidView)localObject);
    }
    localObject = getView().getContext();
    Intent localIntent = new Intent((Context)localObject, MraidBrowser.class);
    localIntent.putExtra("extra_url", paramString);
    localIntent.addFlags(268435456);
    ((Context)localObject).startActivity(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidBrowserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */