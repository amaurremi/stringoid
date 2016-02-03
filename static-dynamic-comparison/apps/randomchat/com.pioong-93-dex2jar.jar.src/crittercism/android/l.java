package crittercism.android;

import android.content.Context;
import com.crittercism.app.Crittercism;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends j
{
  public l()
  {
    this.a = a.c.g;
    this.b = new Vector();
  }
  
  public static l c()
  {
    l locall = new l();
    try
    {
      Object localObject2 = Crittercism.a().n();
      Object localObject1 = ((Context)localObject2).getFilesDir().getAbsolutePath() + "/" + Crittercism.a().v();
      localObject2 = ((Context)localObject2).getPackageName();
      if ((localObject2 != null) && (!((String)localObject2).equals("")))
      {
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists())
        {
          localObject2 = ((File)localObject1).list(new a(".dmp"));
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            Vector localVector = new Vector();
            int i = 0;
            while (i < localObject2.length)
            {
              new StringBuilder("filename = ").append(((File)localObject1).getAbsolutePath()).append("/").append(localObject2[i]).toString();
              localVector.add(((File)localObject1).getAbsolutePath() + "/" + localObject2[i]);
              i += 1;
            }
            locall.a(localVector);
          }
        }
      }
      return locall;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return locall;
  }
  
  public final JSONObject a()
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
          localJSONObject2.put("app_state", Crittercism.a().o().d());
          localJSONObject2.put("num_ndk_crashes", this.b.size());
          localJSONObject2.put("filenames", localObject);
          localJSONObject2.put("filename_prefix", "ndk_crash_");
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
  
  public final void b()
  {
    try
    {
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          new StringBuilder("deleting filename: ").append(str).toString();
          new File(str).delete();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static final class a
    implements FilenameFilter
  {
    private String a = new String();
    
    public a(String paramString)
    {
      if (paramString != null) {
        this.a = paramString;
      }
    }
    
    public final boolean accept(File paramFile, String paramString)
    {
      return paramString.endsWith(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */