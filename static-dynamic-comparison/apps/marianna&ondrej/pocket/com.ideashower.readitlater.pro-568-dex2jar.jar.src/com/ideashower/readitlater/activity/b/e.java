package com.ideashower.readitlater.activity.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.ideashower.readitlater.a.g;
import java.util.Locale;

public class e
{
  public static d a(int paramInt)
  {
    d locald = new d(paramInt);
    Resources localResources = g.c().getResources();
    Locale localLocale = localResources.getConfiguration().locale;
    String str;
    switch (paramInt)
    {
    case 3: 
    default: 
      return locald;
    case 0: 
      str = localResources.getString(2131493818);
      if (localLocale.equals(Locale.US)) {}
      for (paramInt = 2131493816;; paramInt = 2131493817)
      {
        locald.a("see_apps", str, localResources.getString(paramInt), null, "", "gsf_from_apps_%formfactor%", false, "", "");
        return locald;
      }
    case 6: 
      locald.a("browsers", localResources.getString(2131493809), localResources.getString(2131493808), localResources.getString(2131493807), "emailBrowserInstructions", "http://assets.getpocket.com/images/walkthrough/android/computer-%formfactor%.jpg", true, "", "");
      return locald;
    case 1: 
      locald.a("welcome", localResources.getString(2131493821), localResources.getString(2131493820), localResources.getString(2131493819), "", "hi", false, "", "");
      return locald;
    case 2: 
      locald.a("welcome", localResources.getString(2131493831), localResources.getString(2131493829), null, null, "hi", false, "", "");
      str = localResources.getString(2131493818);
      if (localLocale.equals(Locale.US)) {}
      for (paramInt = 2131493816;; paramInt = 2131493817)
      {
        locald.a("see_apps", str, localResources.getString(paramInt), localResources.getString(2131493815), "showExternalAndroidBrowserPage", "gsf_from_apps_%formfactor%", false, "", "");
        locald.a("browsers", localResources.getString(2131493809), localResources.getString(2131493808), localResources.getString(2131493807), "emailBrowserInstructions", "http://assets.getpocket.com/images/walkthrough/android/computer-%formfactor%.jpg", false, "", "");
        locald.a("finished", localResources.getString(2131493812), localResources.getString(2131493811), localResources.getString(2131493810), "closeAllPages", "learnmore_1save_%formfactor%", false, "", "");
        return locald;
      }
    case 4: 
      locald.a("save", localResources.getString(2131493835), localResources.getString(2131493834), null, null, "learnmore_1save_%formfactor%", false, "", "");
      str = localResources.getString(2131493838);
      if (localLocale.equals(Locale.US))
      {
        paramInt = 2131493836;
        locald.a("sync", str, localResources.getString(paramInt), "", "", "learnmore_3lineup_%formfactor%", false, "", "");
        locald.a("apps", localResources.getString(2131493833), localResources.getString(2131493832), "", "", "learnmore_2apps_%formfactor%", false, "", "");
        str = localResources.getString(2131493841);
        if (!localLocale.equals(Locale.US)) {
          break label496;
        }
      }
      label496:
      for (paramInt = 2131493839;; paramInt = 2131493840)
      {
        locald.a("view", str, localResources.getString(paramInt), "", "", "learnmore_4view_%formfactor%", false, "", "");
        return locald;
        paramInt = 2131493837;
        break;
      }
    }
    locald.a("welcome5", localResources.getString(2131493828), localResources.getString(2131493827), "", "", "update_tour_%formfactor%0", false, "", "");
    locald.a("rediscover", localResources.getString(2131493814), localResources.getString(2131493813), "", "", "update_tour_%formfactor%1", false, "", "");
    locald.a(new c[] { new c("suggestions_phone", localResources.getString(2131493824), localResources.getString(2131493822), "", "", "update_tour_%formfactor%2", false, "", ""), new c("suggestions_tablet", localResources.getString(2131493824), localResources.getString(2131493823), "", "", "update_tour_%formfactor%2", false, "", "") });
    locald.a("unified_navigation", localResources.getString(2131493826), localResources.getString(2131493825), "", "", "update_tour_%formfactor%3", false, "", "");
    locald.a(true);
    return locald;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */