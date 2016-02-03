package com.vungle.publisher;

import com.vungle.publisher.log.Logger;
import java.util.Locale;
import java.util.TimeZone;

public final class az
  implements bd
{
  public final String a()
  {
    try
    {
      String str = Locale.getDefault().getISO3Language();
      return str;
    }
    catch (Exception localException)
    {
      Logger.i("VungleDevice", "3 letter language code does not exist");
    }
    return "";
  }
  
  public final String b()
  {
    return TimeZone.getDefault().getID();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */