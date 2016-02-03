package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.crittercism.app.Crittercism;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
  extends j
{
  public String c = new String();
  public JSONArray d = new JSONArray();
  public JSONArray e = new JSONArray();
  public JSONObject f = new JSONObject();
  
  public m()
  {
    this.a = a.c.d;
    this.b = new Vector();
  }
  
  private static m a(JSONObject paramJSONObject)
  {
    m localm = new m();
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
          if (!localJSONObject.has("crashes")) {
            break label138;
          }
          paramJSONObject = localJSONObject.getJSONArray("crashes");
          i = 0;
          if (i >= paramJSONObject.length()) {}
        }
        catch (Exception paramJSONObject)
        {
          try
          {
            int i;
            localm.a(paramJSONObject.getJSONObject(i));
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
            new StringBuilder("Exception in SdkCrashes.fromJSON: ").append(localException.getClass().getName()).toString();
            continue;
          }
        }
      }
      return localm;
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
      return "critter_pendingcrashes_" + str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = new String();
      }
    }
  }
  
  public static m c()
  {
    m localm = new m();
    Object localObject3 = new JSONObject();
    try
    {
      Object localObject5 = Crittercism.a().n().getSharedPreferences("com.crittercism.crashes", 0);
      localObject1 = new JSONObject(((SharedPreferences)localObject5).getString(a(), new JSONObject().toString()));
      try
      {
        localObject5 = ((SharedPreferences)localObject5).edit();
        ((SharedPreferences.Editor)localObject5).remove(a());
        localObject3 = localObject1;
        if (((SharedPreferences.Editor)localObject5).commit()) {
          break label120;
        }
        throw new Exception("failed to remove crashes from Shared Preferences");
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
    new StringBuilder("Exception in SdkCrashes.readFromDisk(): ").append(localException2.getClass().getName()).toString();
    localObject4 = localObject1;
    try
    {
      localObject1 = a((JSONObject)localObject4);
      return (m)localObject1;
    }
    catch (Exception localException1)
    {
      return localm;
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    int i = paramThrowable.toString().indexOf(":");
    if (i >= 0) {}
    for (Object localObject = paramThrowable.toString().substring(0, i);; localObject = paramThrowable.getClass().getName())
    {
      this.c = ((String)localObject);
      localObject = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
      paramThrowable.printStackTrace(localPrintWriter);
      for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause())
      {
        this.c = paramThrowable.getClass().getName();
        paramThrowable.printStackTrace(localPrintWriter);
      }
    }
    paramThrowable = localObject.toString();
    this.d = new JSONArray();
    paramThrowable = paramThrowable.split("\n");
    i = 0;
    while (i < paramThrowable.length)
    {
      this.d.put(paramThrowable[i]);
      i += 1;
    }
  }
  
  public final JSONObject b()
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
          localJSONObject2.put("crashes", localObject);
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
  
  public final void d()
  {
    Iterator localIterator = Thread.getAllStackTraces().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      JSONObject localJSONObject = new JSONObject();
      Object localObject1 = (Thread)((Map.Entry)localObject2).getKey();
      try
      {
        if (((Thread)localObject1).getId() != Thread.currentThread().getId())
        {
          localJSONObject.put("name", ((Thread)localObject1).getName());
          localJSONObject.put("id", ((Thread)localObject1).getId());
          localJSONObject.put("state", ((Thread)localObject1).getState().name());
          localObject1 = new JSONArray();
          localObject2 = (StackTraceElement[])((Map.Entry)localObject2).getValue();
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            new StringBuilder("  ").append(localObject3).toString();
            ((JSONArray)localObject1).put(localObject3);
            i += 1;
          }
          localJSONObject.put("stacktrace", localObject1);
          this.e.put(localJSONObject);
        }
      }
      catch (Exception localException)
      {
        new StringBuilder("Problem with setBackgroundThreads(): ").append(localException.getClass().getName()).toString();
      }
    }
  }
  
  public final void g()
  {
    FutureTask localFutureTask = new FutureTask(new Callable()
    {
      private static String a()
      {
        try
        {
          Crittercism.a().p();
          String str = d.a(Crittercism.a().n(), "breadcrumbsFileString");
          return str;
        }
        catch (Exception localException)
        {
          new StringBuilder("Exception in setBreadcrumbs.call: ").append(localException.getClass().getName()).toString();
        }
        return null;
      }
    });
    Object localObject1 = Executors.newFixedThreadPool(10);
    try
    {
      ((ExecutorService)localObject1).execute(localFutureTask);
      for (localObject1 = null; !localFutureTask.isDone(); localObject1 = (String)localFutureTask.get(2500L, TimeUnit.MILLISECONDS)) {}
      String str;
      Object localObject2;
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      str = null;
      if (str == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.f = new JSONObject(str);
        if (!this.f.has("current_session")) {}
        try
        {
          this.f.put("current_session", new JSONArray());
          this.f.put("previous_session", new JSONArray());
          return;
        }
        catch (JSONException localJSONException)
        {
          this.f = new JSONObject();
        }
        localException1 = localException1;
        new StringBuilder("Exception in setBreadcrumbs: ").append(localException1.getClass().getName()).toString();
        localObject2 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          this.f = new JSONObject();
          new StringBuilder("Exception making breadcrumbs in SdkCrashes.setBreadcrumbs: ").append(localException2.getClass().getName()).toString();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */