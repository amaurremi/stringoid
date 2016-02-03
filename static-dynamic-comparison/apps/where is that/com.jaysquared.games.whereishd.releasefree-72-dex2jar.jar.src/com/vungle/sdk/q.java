package com.vungle.sdk;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

final class q
  implements Runnable
{
  String a = null;
  
  q(VungleAdvert paramVungleAdvert) {}
  
  public final Runnable a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public final void run()
  {
    String str = this.a;
    if ((str == null) || (str.length() == 0))
    {
      Log.e("VungleAdvertCTA", "CTA is either null or empty.");
      return;
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str));
      localIntent.addFlags(268435456);
      this.b.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      if (str.toLowerCase().startsWith("amzn://"))
      {
        Log.e("VungleAdvertCTA", "Clicked, but Amazon Appstore was not available.");
        Toast.makeText(this.b, "Amazon AppStore needs to be installed for this link to work.", 1).show();
        return;
      }
      Log.e("VungleAdvertCTA", "Clicked, but could not find an activity to service the CTA.");
      Toast.makeText(this.b, "We encountered an error while trying to open that link. Sorry 'bout that! :X", 1).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */