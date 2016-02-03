package com.flurry.android;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class w
{
  private static String d = "FlurryAgent";
  private FlurryAds Q;
  
  w(FlurryAds paramFlurryAds)
  {
    this.Q = paramFlurryAds;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return paramString2.equals("%{" + paramString1 + "}");
  }
  
  final String a(cz paramcz, AdUnit paramAdUnit, String paramString1, String paramString2)
  {
    if (a("fids", paramString2))
    {
      paramcz = 0 + ":" + this.Q.getPhoneId();
      db.c(d, "Replacing param fids with: " + paramcz);
      paramAdUnit = paramString1.replace(paramString2, bd.p(paramcz));
    }
    do
    {
      do
      {
        return paramAdUnit;
        if (a("sid", paramString2))
        {
          paramcz = String.valueOf(this.Q.L());
          db.c(d, "Replacing param sid with: " + paramcz);
          return paramString1.replace(paramString2, bd.p(paramcz));
        }
        if (a("lid", paramString2))
        {
          paramcz = String.valueOf(paramcz.getIndex());
          db.c(d, "Replacing param lid with: " + paramcz);
          return paramString1.replace(paramString2, bd.p(paramcz));
        }
        if (a("guid", paramString2))
        {
          paramcz = paramcz.at();
          db.c(d, "Replacing param guid with: " + paramcz);
          return paramString1.replace(paramString2, bd.p(paramcz));
        }
        if (a("ats", paramString2))
        {
          paramcz = String.valueOf(System.currentTimeMillis());
          db.c(d, "Replacing param ats with: " + paramcz);
          return paramString1.replace(paramString2, bd.p(paramcz));
        }
        if (a("apik", paramString2))
        {
          paramcz = FlurryAds.w();
          db.c(d, "Replacing param apik with: " + paramcz);
          return paramString1.replace(paramString2, bd.p(paramcz));
        }
        if (a("hid", paramString2))
        {
          paramcz = paramAdUnit.getAdSpace().toString();
          db.c(d, "Replacing param hid with: " + paramcz);
          return paramString1.replace(paramString2, bd.p(paramcz));
        }
        if (a("eso", paramString2))
        {
          paramcz = Long.toString(System.currentTimeMillis() - this.Q.L());
          db.c(d, "Replacing param eso with: " + paramcz);
          return paramString1.replace(paramString2, bd.p(paramcz));
        }
        if (!a("uc", paramString2)) {
          break;
        }
        paramAdUnit = this.Q.O().entrySet().iterator();
        Map.Entry localEntry;
        for (paramcz = ""; paramAdUnit.hasNext(); paramcz = paramcz + "c_" + bd.p((String)localEntry.getKey()) + "=" + bd.p((String)localEntry.getValue()) + "&") {
          localEntry = (Map.Entry)paramAdUnit.next();
        }
        db.c(d, "Replacing param uc with: " + paramcz);
        paramString1 = paramString1.replace(paramString2, paramcz);
        paramAdUnit = paramString1;
      } while (!paramcz.equals(""));
      paramAdUnit = paramString1;
    } while (paramString1.length() <= 0);
    return paramString1.substring(0, paramString1.length() - 1);
    db.c(d, "Unknown param: " + paramString2);
    return paramString1.replace(paramString2, "");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */