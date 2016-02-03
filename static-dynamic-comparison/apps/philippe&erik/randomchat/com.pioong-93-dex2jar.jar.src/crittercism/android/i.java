package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.crittercism.app.Crittercism;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends j
{
  public i()
  {
    this.a = a.c.b;
    this.b = new Vector();
  }
  
  private static i a(JSONObject paramJSONObject)
  {
    i locali = new i();
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("requestData")) {
          localJSONObject = paramJSONObject.getJSONObject("requestData");
        }
      }
      catch (Exception paramJSONObject)
      {
        try
        {
          if (!localJSONObject.has("app_loads")) {
            break label138;
          }
          paramJSONObject = localJSONObject.getJSONArray("app_loads");
          i = 0;
          if (i >= paramJSONObject.length()) {}
        }
        catch (Exception paramJSONObject)
        {
          try
          {
            int i;
            locali.a(paramJSONObject.getJSONObject(i));
            i += 1;
            continue;
            paramJSONObject = paramJSONObject;
            localJSONObject = new JSONObject();
            continue;
            paramJSONObject = paramJSONObject;
            paramJSONObject = new JSONArray();
          }
          catch (Exception localException)
          {
            new StringBuilder("Exception in AppLoads.fromJSON: ").append(localException.getClass().getName()).toString();
            continue;
          }
        }
      }
      return locali;
      label138:
      paramJSONObject = localJSONArray;
    }
  }
  
  public static String a()
  {
    String str1 = new String();
    if (Crittercism.a() != null) {}
    try
    {
      str1 = Crittercism.a().m();
      return "critter_pendingapploads_" + str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = new String();
      }
    }
  }
  
  public static i d()
  {
    i locali = new i();
    Object localObject3 = new JSONObject();
    try
    {
      Object localObject5 = Crittercism.a().n().getSharedPreferences("com.crittercism.loads", 0);
      localObject1 = new JSONObject(((SharedPreferences)localObject5).getString(a(), new JSONObject().toString()));
      try
      {
        localObject5 = ((SharedPreferences)localObject5).edit();
        ((SharedPreferences.Editor)localObject5).remove(a());
        localObject3 = localObject1;
        if (((SharedPreferences.Editor)localObject5).commit()) {
          break label120;
        }
        throw new Exception("failed to remove app loads from Shared Preferences");
      }
      catch (Exception localException2) {}
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Object localObject1;
        label120:
        Object localObject2 = localObject4;
        Object localObject4 = localException3;
      }
    }
    new StringBuilder("Exception in AppLoads.readFromDisk(): ").append(localException2.getClass().getName()).toString();
    localObject4 = localObject1;
    try
    {
      localObject1 = a((JSONObject)localObject4);
      return (i)localObject1;
    }
    catch (Exception localException1)
    {
      return locali;
    }
  }
  
  public final void b()
  {
    JSONObject localJSONObject3 = new JSONObject();
    new JSONObject();
    try
    {
      localJSONObject1 = Crittercism.a().o().a(new boolean[] { false });
      localJSONObject1.put("ts", Crittercism.z());
      try
      {
        localJSONObject3.put("app_state", localJSONObject1);
        localJSONObject3.put("type", a.a.e);
        localJSONObject1 = localJSONObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          JSONObject localJSONObject2;
          Object localObject = null;
        }
      }
      if (localJSONObject1 == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1;
          this.b.add(localJSONObject1);
          return;
        }
        catch (Exception localException3) {}
        localException1 = localException1;
        localJSONObject2 = new JSONObject();
      }
    }
  }
  
  public final JSONObject c()
  {
    JSONObject localJSONObject3 = new JSONObject();
    new JSONObject();
    new JSONArray();
    try
    {
      localObject = new JSONArray(this.b);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject2 = Crittercism.a().o().c();
          localJSONObject2.put("app_loads", localObject);
          localObject = localJSONObject2;
        }
        catch (Exception localException2)
        {
          Object localObject;
          JSONArray localJSONArray;
          JSONObject localJSONObject1 = new JSONObject();
          continue;
        }
        try
        {
          localJSONObject3.put("requestUrl", this.a);
          localJSONObject3.put("requestData", localObject);
          return localJSONObject3;
        }
        catch (Exception localException3) {}
        localException1 = localException1;
        localJSONArray = new JSONArray();
      }
    }
    return new JSONObject();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */