package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class az
{
  public static List<String> a(JSONObject paramJSONObject, String paramString)
    throws JSONException
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
  
  public static void a(Context paramContext, String paramString1, cj paramcj, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramcj.is.fN).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", ck.iu).replaceAll("@gw_seqnum@", paramcj.hu);
        paramList = str2;
        if (paramcj.gb != null) {
          paramList = str2.replaceAll("@gw_adnetid@", paramcj.gb.fD).replaceAll("@gw_allocid@", paramcj.gb.fF);
        }
        new cr(paramContext, paramString1, paramList).start();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */