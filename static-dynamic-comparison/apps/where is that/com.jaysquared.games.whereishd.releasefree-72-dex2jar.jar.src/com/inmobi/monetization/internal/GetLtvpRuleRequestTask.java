package com.inmobi.monetization.internal;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.abstraction.IGetLtvpRuleRequestListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetLtvpRuleRequestTask
  implements Runnable
{
  private GetLtvpRulesRequest a;
  private IGetLtvpRuleRequestListener b;
  private final int c = 60000;
  private final int d = -1;
  
  GetLtvpRuleRequestTask(GetLtvpRulesRequest paramGetLtvpRulesRequest, IGetLtvpRuleRequestListener paramIGetLtvpRuleRequestListener)
  {
    this.a = paramGetLtvpRulesRequest;
    this.b = paramIGetLtvpRuleRequestListener;
  }
  
  public void run()
  {
    try
    {
      Object localObject2 = new URL(AnalyticsInitializer.getConfigParams().getEndPoints().getRulesUrl());
      Object localObject1 = new DefaultHttpClient();
      localObject2 = localObject2 + "?" + this.a.getEncodedRequestParams();
      Log.debug("[InMobi]-[Monetization]", "Getting LTVP rule: " + (String)localObject2);
      localObject2 = new HttpGet((String)localObject2);
      Object localObject3 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject3, 60000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject3, 60000);
      ((DefaultHttpClient)localObject1).setParams((HttpParams)localObject3);
      localObject1 = ((DefaultHttpClient)localObject1).execute((HttpUriRequest)localObject2);
      long l1;
      long l2;
      long l3;
      if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
      {
        localObject1 = new JSONObject(EntityUtils.toString(((HttpResponse)localObject1).getEntity()));
        if (!((JSONObject)localObject1).getBoolean("success"))
        {
          int i = ((JSONObject)localObject1).getInt("error_code");
          localObject1 = ((JSONObject)localObject1).getString("error_message");
          Log.debug("[InMobi]-[Monetization]", "Received LTVP rule fetch failure: " + i + " : " + (String)localObject1);
          if (this.b != null) {
            this.b.onLtvpGetRuleFailed(this.a, new LtvpErrorCode(i, (String)localObject1));
          }
        }
        else
        {
          JSONObject localJSONObject = ((JSONObject)localObject1).getJSONObject("response");
          Log.debug("[InMobi]-[Monetization]", "Received LTVP rule fetch success: " + localJSONObject.toString());
          localObject1 = new GetLtvpRulesResponse();
          localObject2 = localJSONObject.getString("rule_id");
          l1 = localJSONObject.getLong("ts");
          localObject3 = localJSONObject.getJSONObject("exp");
          l2 = ((JSONObject)localObject3).getLong("se");
          l3 = ((JSONObject)localObject3).getLong("he");
          localObject3 = new HashMap();
          localJSONObject = localJSONObject.getJSONObject("rules");
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((HashMap)localObject3).put(str, Integer.valueOf(localJSONObject.getInt(String.valueOf(str))));
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.debug("[InMobi]-[Monetization]", "Received LTVP rule fetch exception", localException);
      if (this.b != null)
      {
        this.b.onLtvpGetRuleFailed(this.a, new LtvpErrorCode(-1, "Ltvp rule server unreachable"));
        return;
        localException.setRuleId((String)localObject2);
        localException.setTimeStamp(l1);
        localException.setSoftExpiry(l2);
        localException.setHardExpiry(l3);
        localException.setRules((HashMap)localObject3);
        if (this.b != null) {
          this.b.onLtvpGetRuleSucceeded(this.a, localException);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/GetLtvpRuleRequestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */