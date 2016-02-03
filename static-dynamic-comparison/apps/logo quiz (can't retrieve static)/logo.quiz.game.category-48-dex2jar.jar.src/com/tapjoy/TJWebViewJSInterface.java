package com.tapjoy;

import android.os.AsyncTask;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJWebViewJSInterface
{
  private static final String TAG = "TJWebViewJSInterface";
  TJWebViewJSInterfaceNotifier notifier;
  WebView webView;
  
  public TJWebViewJSInterface(WebView paramWebView, TJWebViewJSInterfaceNotifier paramTJWebViewJSInterfaceNotifier)
  {
    this.webView = paramWebView;
    this.notifier = paramTJWebViewJSInterfaceNotifier;
  }
  
  public void callback(ArrayList<?> paramArrayList, String paramString1, String paramString2)
  {
    try
    {
      callbackToJavaScript(new JSONArray(paramArrayList), paramString1, paramString2);
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public void callback(Map<?, ?> paramMap, String paramString1, String paramString2)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(new JSONObject(paramMap));
      callbackToJavaScript(localJSONArray, paramString1, paramString2);
      return;
    }
    catch (Exception paramMap)
    {
      TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + paramMap.toString());
      paramMap.printStackTrace();
    }
  }
  
  public void callbackToJavaScript(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("arguments", paramObject);
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localJSONObject.put("method", paramString1);
      }
      paramObject = new JSONObject();
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        ((JSONObject)paramObject).put("callbackId", paramString2);
      }
      ((JSONObject)paramObject).put("data", localJSONObject);
      paramObject = "javascript:AndroidWebViewJavascriptBridge._handleMessageFromAndroid('" + paramObject + "');";
      new LoadJSTask(this.webView).execute(new String[] { paramObject });
      TapjoyLog.i("TJWebViewJSInterface", "sendToJS: " + (String)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + ((Exception)paramObject).toString());
      ((Exception)paramObject).printStackTrace();
    }
  }
  
  public void dispatchMethod(String paramString)
  {
    TapjoyLog.i("TJWebViewJSInterface", "dispatchMethod params: " + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getJSONObject("data").getString("method");
      TapjoyLog.i("TJWebViewJSInterface", "method: " + str);
      if (this.notifier != null) {
        this.notifier.dispatchMethod(str, paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private class LoadJSTask
    extends AsyncTask<String, Void, String>
  {
    WebView webView;
    
    public LoadJSTask(WebView paramWebView)
    {
      this.webView = paramWebView;
    }
    
    protected String doInBackground(String... paramVarArgs)
    {
      return paramVarArgs[0];
    }
    
    protected void onPostExecute(String paramString)
    {
      if (this.webView != null) {
        this.webView.loadUrl(paramString);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJWebViewJSInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */