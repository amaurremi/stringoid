package com.appflood.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appflood.b.b;
import com.appflood.e.j;
import com.appflood.e.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class h
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      if ((!j.a(d.w)) && (!j.a(d.y)))
      {
        paramContext = new HashMap();
        JSONObject localJSONObject = new JSONObject();
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          Iterator localIterator = paramIntent.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject = paramIntent.get(str);
            try
            {
              localJSONObject.put(str, localObject);
            }
            catch (Throwable localThrowable) {}
          }
        }
        paramContext.put("data", k.d(localJSONObject.toString()));
        new b(d.y, paramContext).f();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      j.a(paramContext, "onReceiver");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */