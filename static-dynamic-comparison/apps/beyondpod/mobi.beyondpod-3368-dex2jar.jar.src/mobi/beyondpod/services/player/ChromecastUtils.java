package mobi.beyondpod.services.player;

import android.content.res.Resources;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.services.player.impl.ChromecastDevice;

public class ChromecastUtils
{
  public static String buildCastingToTitle(String paramString)
  {
    if (ChromecastDevice.IsConnected())
    {
      String str2 = BeyondPodApplication.GetInstance().getResources().getString(R.string.cc_casting_to, new Object[] { BeyondPodApplication.GetInstance().ChromecastDevice().ConnectedDeviceName(), paramString });
      String str1 = str2;
      if (!StringUtils.IsNullOrEmpty(paramString)) {
        str1 = String.format("%s • %s", new Object[] { str2, paramString });
      }
      return str1;
    }
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/ChromecastUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */