package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class i
  extends AsyncTask<Object, Void, Void>
{
  private i(d paramd) {}
  
  public Void a(Object... paramVarArgs)
  {
    int i = 0;
    List localList = (List)paramVarArgs[0];
    Object localObject2 = (String)paramVarArgs[1];
    for (;;)
    {
      try
      {
        paramVarArgs = d.a(this.a).openFileOutput((String)localObject2, 0);
        localObject2 = Xml.newSerializer();
        int j;
        g localg;
        ((XmlSerializer)localObject2).endTag(null, "historical-records");
      }
      catch (FileNotFoundException paramVarArgs)
      {
        try
        {
          ((XmlSerializer)localObject2).setOutput(paramVarArgs, null);
          ((XmlSerializer)localObject2).startDocument("UTF-8", Boolean.valueOf(true));
          ((XmlSerializer)localObject2).startTag(null, "historical-records");
          j = localList.size();
          if (i >= j) {
            break label213;
          }
          localg = (g)localList.remove(0);
          ((XmlSerializer)localObject2).startTag(null, "historical-record");
          ((XmlSerializer)localObject2).attribute(null, "activity", localg.a.flattenToString());
          ((XmlSerializer)localObject2).attribute(null, "time", String.valueOf(localg.b));
          ((XmlSerializer)localObject2).attribute(null, "weight", String.valueOf(localg.c));
          ((XmlSerializer)localObject2).endTag(null, "historical-record");
          i += 1;
          continue;
          paramVarArgs = paramVarArgs;
          Log.e(d.d(), "Error writing historical recrod file: " + (String)localObject2, paramVarArgs);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.e(d.d(), "Error writing historical recrod file: " + d.b(this.a), localIllegalArgumentException);
          d.a(this.a, true);
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Log.e(d.d(), "Error writing historical recrod file: " + d.b(this.a), localIllegalStateException);
          d.a(this.a, true);
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IOException localIOException)
        {
          Log.e(d.d(), "Error writing historical recrod file: " + d.b(this.a), localIOException);
          d.a(this.a, true);
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        finally
        {
          d.a(this.a, true);
          if (paramVarArgs == null) {
            break label446;
          }
        }
        return null;
      }
      label213:
      ((XmlSerializer)localObject2).endDocument();
      d.a(this.a, true);
      if (paramVarArgs != null) {
        try
        {
          paramVarArgs.close();
          return null;
        }
        catch (IOException paramVarArgs)
        {
          return null;
        }
      }
    }
    try
    {
      paramVarArgs.close();
      label446:
      throw ((Throwable)localObject1);
    }
    catch (IOException paramVarArgs)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */