package com.inmobi.commons.cache;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalCache
{
  public static final String DEFAULTROOT = "{url:'https://inmobisdk-a.akamaihd.net/sdk/configs/rootConfig.json'}";
  public static final String DEFAULTURL = "https://inmobisdk-a.akamaihd.net/sdk/configs/rootConfig.json";
  public static final String FILENAME = "inmobi.cache";
  static JSONObject a = new JSONObject();
  
  public static JSONObject addToCache(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    synchronized (a)
    {
      if (a.toString().equals("{}")) {
        initRoot();
      }
      a.put(paramString, paramJSONObject);
      b();
      return null;
    }
  }
  
  private static void b()
  {
    new Thread(new a()).start();
  }
  
  private static void c()
  {
    synchronized (a)
    {
      try
      {
        String str = a.toString();
        FileOperations.writeStringToFile(InternalSDKUtil.getContext(), "inmobi.cache", str, false);
        Log.internal("IMCOMMONS_3.7.1", "Saving to persistent memory: " + str);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.internal("IMCOMMONS_3.7.1", "Unable to save all configs to persistent memory", localIOException);
        }
      }
    }
  }
  
  public static JSONObject getCacheForProduct(String paramString)
  {
    if (a.toString().equals("{}")) {
      initRoot();
    }
    try
    {
      paramString = a.getJSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public static JSONObject getRoot()
  {
    return a;
  }
  
  public static void initRoot()
  {
    if (!a.toString().equals("{}")) {}
    for (;;)
    {
      return;
      try
      {
        synchronized (a)
        {
          try
          {
            a = new JSONObject(FileOperations.readFileAsString(InternalSDKUtil.getContext(), "inmobi.cache"));
            if (!a.toString().equals("{}")) {
              continue;
            }
            try
            {
              a = new JSONObject("{url:'https://inmobisdk-a.akamaihd.net/sdk/configs/rootConfig.json'}");
              return;
            }
            catch (JSONException localJSONException1)
            {
              Log.internal("IMCOMMONS_3.7.1", "Default JSON root is unable to parse? What sorcery is this?", localJSONException1);
              return;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              Log.internal("IMCOMMONS_3.7.1", "Unable to read configs from persistent memory", localIOException);
            }
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Log.internal("IMCOMMONS_3.7.1", "Ill formed JSON while parsing from persistent memory", localJSONException2);
        }
      }
    }
  }
  
  public static void reset()
  {
    a = new JSONObject();
    c();
    initRoot();
  }
  
  public static void saveRoot(JSONObject paramJSONObject)
  {
    a = paramJSONObject;
    b();
  }
  
  static final class a
    implements Runnable
  {
    public void run() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/cache/LocalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */