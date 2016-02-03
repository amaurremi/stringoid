package com.getjar.sdk.comm;

import android.content.Context;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.ReportUsageData;
import com.getjar.sdk.data.ReportUsageData.UsageType;
import com.getjar.sdk.data.usage.UsageManager;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.rewards.AdvertisingIdHelper;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportUsageProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20140721";
  private static volatile ReportUsageProxy _Instance = null;
  private static final String _URL_TEMPLATE_APPLICATION_REPORT_USAGE = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$suser/devices/%2$s/apps/report_usage?version=", "20140721" });
  
  private String appUsageDataToJson(ReportUsageData paramReportUsageData)
  {
    JSONObject localJSONObject1;
    Object localObject;
    JSONObject localJSONObject2;
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("usage_type", paramReportUsageData.getUsageType().name());
        localJSONObject1.put("event_timestamp", Utility.epochToISO8601(paramReportUsageData.getEventTimestamp()));
        localJSONArray = new JSONArray();
        localIterator = paramReportUsageData.getAppMetadata().keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("key", localObject);
        localObject = paramReportUsageData.getAppMetadata().get(localObject);
        if (localObject != null)
        {
          localJSONObject2.put("value", localObject);
          localJSONArray.put(localJSONObject2);
        }
        else
        {
          localJSONObject2.put("value", JSONObject.NULL);
        }
      }
      catch (JSONException paramReportUsageData)
      {
        throw new CommunicationException(paramReportUsageData);
      }
    }
    localJSONObject1.put("app_metadata", localJSONArray);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramReportUsageData.getTrackingMetadata().keySet().iterator();
    if (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("key", localObject);
      localObject = paramReportUsageData.getTrackingMetadata().get(localObject);
      if (localObject != null) {
        localJSONObject2.put("value", localObject);
      }
      for (;;)
      {
        localJSONArray.put(localJSONObject2);
        break;
        localJSONObject2.put("value", JSONObject.NULL);
      }
    }
    localJSONObject1.put("tracking_metadata", localJSONArray);
    paramReportUsageData = localJSONObject1.toString();
    return paramReportUsageData;
  }
  
  private List<ReportUsageData> filterAppUsageDataList(Context paramContext, List<ReportUsageData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ReportUsageData localReportUsageData = (ReportUsageData)paramList.next();
      if (((StringUtility.isNullOrEmpty(localReportUsageData.getPackageName())) || (!UsageManager.getInstance(paramContext).shouldFilterFromUsage(localReportUsageData.getPackageName()))) && (!UsageManager.getInstance(paramContext).shouldFilterTypeFromUsage(localReportUsageData.getUsageType()))) {
        localArrayList.add(localReportUsageData);
      }
    }
    return localArrayList;
  }
  
  public static ReportUsageProxy getInstance()
  {
    if (_Instance == null) {
      makeTheInstance();
    }
    return _Instance;
  }
  
  private static void makeTheInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new ReportUsageProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.USER;
  }
  
  public Operation reportApplicationUsage(CommContext paramCommContext, List<ReportUsageData> paramList)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("The required parameter 'appUsageList' was not provided");
    }
    if (paramList.size() <= 0) {
      throw new IllegalArgumentException("The required parameter 'appUsageList' contains no data");
    }
    Object localObject = filterAppUsageDataList(paramCommContext.getApplicationContext(), paramList);
    Logger.d(Area.USAGE.value() | Area.COMM.value(), "Filtered usage records to report from %1$d to %2$d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() <= 0) {
      return null;
    }
    paramList = new StringBuilder("");
    localObject = ((List)localObject).iterator();
    paramList.append("[");
    while (((Iterator)localObject).hasNext()) {
      try
      {
        paramList.append(appUsageDataToJson((ReportUsageData)((Iterator)localObject).next()));
        if (((Iterator)localObject).hasNext()) {
          paramList.append(",");
        }
      }
      catch (Exception localException)
      {
        Logger.e(Area.USAGE.value() | Area.COMM.value(), localException, "appUsageDataToJson() failed", new Object[0]);
      }
    }
    paramList.append("]");
    localObject = new HashMap(1);
    ((Map)localObject).put("app_usage_data", paramList.toString());
    paramList = new HashMap(1);
    AdvertisingIdHelper.getInstance(paramCommContext.getApplicationContext()).addDataToMap(paramList);
    try
    {
      ((Map)localObject).put("device_ad_data", Utility.mapToJsonString(paramList));
      AuthManager.initialize(paramCommContext.getApplicationContext());
      AuthManager.getInstance().waitOnAuth();
    }
    catch (JSONException paramList)
    {
      for (;;)
      {
        try
        {
          paramList = String.format(Locale.US, _URL_TEMPLATE_APPLICATION_REPORT_USAGE, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.report_usage.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(AuthManager.getInstance().getUserDeviceId(), "UTF-8") });
          return makeAsyncPOSTRequestForJson("reportApplicationUsage", Operation.Priority.LOW, paramCommContext, paramList, (Map)localObject, null, null, true, true, false);
        }
        catch (UnsupportedEncodingException paramCommContext)
        {
          throw new CommunicationException(paramCommContext);
        }
        paramList = paramList;
        Logger.e(Area.USAGE.value() | Area.COMM.value(), paramList, "mapToJsonString() failed", new Object[0]);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/ReportUsageProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */