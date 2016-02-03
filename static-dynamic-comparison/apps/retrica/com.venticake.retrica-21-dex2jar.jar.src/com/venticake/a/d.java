package com.venticake.a;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class d
  extends AsyncTask<String, Void, String>
{
  private d(a parama) {}
  
  protected String a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localStringBuffer.toString();
      }
      Object localObject1 = paramVarArgs[i];
      try
      {
        Object localObject2 = new DefaultHttpClient();
        HttpParams localHttpParams = ((DefaultHttpClient)localObject2).getParams();
        HttpConnectionParams.setConnectionTimeout(localHttpParams, 4000);
        HttpConnectionParams.setSoTimeout(localHttpParams, 4000);
        localObject1 = new BufferedReader(new InputStreamReader(((DefaultHttpClient)localObject2).execute(new HttpGet((String)localObject1)).getEntity().getContent()));
        for (;;)
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 == null) {
            break;
          }
          localStringBuffer.append((String)localObject2);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i += 1;
      }
    }
  }
  
  protected void a(String paramString)
  {
    Log.d("spad", "onPostExcute: " + paramString);
    if ((paramString == null) || (paramString.length() < 1)) {
      return;
    }
    if (a.a(this.a, paramString))
    {
      if (a.a(this.a) != null)
      {
        a.a(this.a).a();
        a.a(this.a, null);
        return;
      }
      Log.d("spad", "No ctUpdateCallback");
      return;
    }
    Log.d("spad", "Parsing ERROR");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */