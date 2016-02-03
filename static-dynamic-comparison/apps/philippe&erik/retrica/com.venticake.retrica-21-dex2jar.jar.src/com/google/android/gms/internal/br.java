package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class br
{
  public static List<String> a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramString.add(paramJSONObject.getString(i));
        i += 1;
      }
      return Collections.unmodifiableList(paramString);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, ef paramef, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramef.rz.nw).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", eh.rQ).replaceAll("@gw_seqnum@", paramef.qa);
        paramList = str2;
        if (paramef.nM != null) {
          paramList = str2.replaceAll("@gw_adnetid@", paramef.nM.nl).replaceAll("@gw_allocid@", paramef.nM.nn);
        }
        new es(paramContext, paramString1, paramList).start();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */