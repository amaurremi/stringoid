package com.gtp.go.weather.sharephoto.award;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gtp.go.weather.sharephoto.b.d;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

class p
  extends AsyncTask
{
  private p(k paramk) {}
  
  protected void a(int[] paramArrayOfInt)
  {
    boolean bool = false;
    k localk = this.a;
    if (paramArrayOfInt[0] == 1) {
      bool = true;
    }
    k.a(localk, bool, paramArrayOfInt[1]);
  }
  
  protected int[] a(Void... paramVarArgs)
  {
    int k = 1;
    int[] arrayOfInt = new int[2];
    Object localObject = com.gtp.go.weather.sharephoto.b.a.c.a(k.d(this.a), new String[] { String.valueOf("user_award_id") }, null, null);
    arrayOfInt[1] = ((List)localObject).size();
    if (arrayOfInt[1] > 0) {
      i = 1;
    }
    for (;;)
    {
      paramVarArgs = k.c(this.a).getString("key_has_read_user_award_ids", "");
      int j = i;
      if (!TextUtils.isEmpty(paramVarArgs)) {}
      try
      {
        paramVarArgs = new JSONArray(paramVarArgs);
        m = paramVarArgs.length();
        localObject = ((List)localObject).iterator();
        j = i;
      }
      catch (JSONException paramVarArgs)
      {
        for (;;)
        {
          try
          {
            int m;
            if (((Iterator)localObject).hasNext())
            {
              locald = (d)((Iterator)localObject).next();
              i = 0;
              if (i >= m) {
                continue;
              }
            }
          }
          catch (JSONException paramVarArgs)
          {
            d locald;
            long l1;
            long l2;
            continue;
            i = 1;
            continue;
          }
          try
          {
            l1 = locald.a();
            l2 = paramVarArgs.getLong(i);
            if (l1 == l2)
            {
              i = 0;
              if (i == 0) {
                continue;
              }
              j = i;
              if (j == 0) {
                continue;
              }
              i = k;
              arrayOfInt[0] = i;
              return arrayOfInt;
              i = 0;
              break;
            }
            i += 1;
            continue;
          }
          catch (JSONException paramVarArgs)
          {
            i = 1;
            continue;
          }
          paramVarArgs = paramVarArgs;
          j = i;
          if (com.gtp.a.a.b.c.a())
          {
            paramVarArgs.printStackTrace();
            j = i;
          }
          continue;
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */