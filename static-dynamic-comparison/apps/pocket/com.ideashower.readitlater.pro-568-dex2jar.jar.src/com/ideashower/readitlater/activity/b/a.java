package com.ideashower.readitlater.activity.b;

import android.content.res.Resources;
import java.util.ArrayList;

public class a
{
  private static ArrayList a;
  
  public static ArrayList a(Resources paramResources)
  {
    if ((a == null) || (a.size() == 0))
    {
      a = new ArrayList();
      b localb = new b("save", paramResources.getString(2131493422), "learnmore_1save_%formfactor%", paramResources.getString(2131493421));
      a.add(localb);
      localb = new b("sync", paramResources.getString(2131493424), "learnmore_3lineup_%formfactor%", paramResources.getString(2131493423));
      a.add(localb);
      localb = new b("app", paramResources.getString(2131493420), "learnmore_2apps_%formfactor%", paramResources.getString(2131493419));
      a.add(localb);
      paramResources = new b("view", paramResources.getString(2131493426), "learnmore_4view_%formfactor%", paramResources.getString(2131493425));
      a.add(paramResources);
    }
    return a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */