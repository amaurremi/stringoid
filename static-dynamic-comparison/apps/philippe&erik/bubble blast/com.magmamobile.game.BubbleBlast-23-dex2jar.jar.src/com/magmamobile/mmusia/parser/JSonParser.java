package com.magmamobile.mmusia.parser;

import android.os.SystemClock;
import com.magmamobile.mmusia.MCommon;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class JSonParser
{
  protected static SimpleDateFormat formaterDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
  public static DefaultHttpClient http;
  private static ArrayList<String> tmpApiLst;
  private static boolean verbose = false;
  
  static
  {
    tmpApiLst = new ArrayList();
  }
  
  public static void extractJsonArrayNames(JSONArray paramJSONArray, String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        return;
      }
      try
      {
        extractJsonNames(paramJSONArray.getJSONObject(i), paramString, true);
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public static void extractJsonNames(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    if (!verbose) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramJSONObject.names().length())
      {
        Object localObject1 = "";
        for (;;)
        {
          try
          {
            localObject2 = paramString + "/" + paramJSONObject.names().getString(i);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException2)
          {
            Object localObject2;
            continue;
          }
          try
          {
            localObject2 = paramJSONObject.get(paramJSONObject.names().getString(i));
            if ((localObject2 instanceof JSONObject))
            {
              if (!tmpApiLst.contains(localObject1))
              {
                tmpApiLst.add(localObject1);
                MCommon.Log_d((String)localObject1);
              }
              extractJsonNames((JSONObject)localObject2, (String)localObject1, true);
            }
            else if ((localObject2 instanceof JSONStringer))
            {
              MCommon.Log_d(localObject1 + "/[StringER]");
            }
          }
          catch (JSONException localJSONException1)
          {
            MCommon.Log_e(localObject1 + " ERROR");
            localJSONException1.printStackTrace();
          }
        }
        if ((localJSONException1 instanceof JSONTokener))
        {
          MCommon.Log_d(localObject1 + "/[Token]");
        }
        else if ((localJSONException1 instanceof JSONArray))
        {
          if (!tmpApiLst.contains(localObject1 + "/[Array]"))
          {
            tmpApiLst.add(localObject1 + "/[Array]");
            MCommon.Log_d(localObject1 + "/[Array]");
          }
          extractJsonArrayNames((JSONArray)localJSONException1, (String)localObject1);
        }
        else if ((localJSONException1 instanceof String))
        {
          if (!tmpApiLst.contains(localObject1 + "/[String]"))
          {
            tmpApiLst.add(localObject1 + "/[String]");
            MCommon.Log_d(localObject1 + "/[String]");
          }
        }
        else if ((localJSONException1 instanceof Integer))
        {
          if (!tmpApiLst.contains(localObject1 + "/[int]"))
          {
            tmpApiLst.add(localObject1 + "/[int]");
            MCommon.Log_d(localObject1 + "/[int]");
          }
        }
        else if ((localJSONException1 instanceof Boolean))
        {
          if (!tmpApiLst.contains(localObject1 + "/[bool]"))
          {
            tmpApiLst.add(localObject1 + "/[bool]");
            MCommon.Log_d(localObject1 + "/[bool]");
          }
        }
        else if ((localJSONException1 instanceof Long))
        {
          if (!tmpApiLst.contains(localObject1 + "/[long]"))
          {
            tmpApiLst.add(localObject1 + "/[long]");
            MCommon.Log_d(localObject1 + "/[long]");
          }
        }
        else if ((localJSONException1 instanceof Double))
        {
          if (!tmpApiLst.contains(localObject1 + "/[double]"))
          {
            tmpApiLst.add(localObject1 + "/[double]");
            MCommon.Log_d(localObject1 + "/[double]");
          }
        }
        else if (localJSONException1.toString() != "null")
        {
          MCommon.Log_d("OULALA !!! C'est quoi ce truc ? : " + (String)localObject1 + " / " + localJSONException1.toString());
        }
        i += 1;
      }
    }
  }
  
  public static String sendJSonRequest(String paramString)
    throws Exception
  {
    return sendJSonRequest(paramString, true);
  }
  
  public static String sendJSonRequest(String paramString, boolean paramBoolean)
    throws Exception
  {
    float f = (float)SystemClock.currentThreadTimeMillis();
    if (http == null)
    {
      localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
      http = new DefaultHttpClient((HttpParams)localObject);
    }
    Object localObject = new HttpGet(paramString);
    ((HttpGet)localObject).addHeader("Accept-Encoding", "gzip, deflate");
    HttpResponse localHttpResponse = http.execute((HttpUriRequest)localObject);
    localObject = localHttpResponse.getEntity().getContent();
    MCommon.Log_i("sendJSonRequest :: " + paramString);
    paramString = (String)localObject;
    if (localHttpResponse.getHeaders("Content-Encoding").length > 0)
    {
      paramString = (String)localObject;
      if (localHttpResponse.getHeaders("Content-Encoding")[0].getValue().toLowerCase().equals("gzip")) {
        paramString = new GZIPInputStream((InputStream)localObject);
      }
    }
    MCommon.Log_w("JSON Feed load time : " + ((float)SystemClock.currentThreadTimeMillis() - f) / 1000.0F + " sec");
    return MCommon.generateString(paramString);
  }
  
  public static String sendJSonRequestPost(String paramString, List<NameValuePair> paramList)
    throws Exception
  {
    return sendJSonRequestPost(paramString, paramList, true);
  }
  
  public static String sendJSonRequestPost(String paramString, List<NameValuePair> paramList, boolean paramBoolean)
    throws Exception
  {
    float f = (float)SystemClock.currentThreadTimeMillis();
    if (http == null)
    {
      localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
      http = new DefaultHttpClient((HttpParams)localObject);
    }
    Object localObject = new HttpPost(paramString);
    ((HttpPost)localObject).addHeader("Accept-Charset", "UTF-8");
    ((HttpPost)localObject).setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
    ((HttpPost)localObject).addHeader("Accept-Encoding", "gzip, deflate");
    localObject = http.execute((HttpUriRequest)localObject);
    paramList = ((HttpResponse)localObject).getEntity().getContent();
    MCommon.Log_i("sendJSonRequest :: " + paramString);
    paramString = paramList;
    if (((HttpResponse)localObject).getHeaders("Content-Encoding").length > 0)
    {
      paramString = paramList;
      if (localObject.getHeaders("Content-Encoding")[0].getValue().toLowerCase().equals("gzip")) {
        paramString = new GZIPInputStream(paramList);
      }
    }
    MCommon.Log_w("JSON Feed load time : " + ((float)SystemClock.currentThreadTimeMillis() - f) / 1000.0F + " sec");
    return MCommon.generateString(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/parser/JSonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */