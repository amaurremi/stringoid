package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser
  implements ExceptionParser
{
  private final TreeSet<String> includedPackages = new TreeSet();
  
  public StandardExceptionParser(Context paramContext, Collection<String> paramCollection)
  {
    setIncludedPackages(paramContext, paramCollection);
  }
  
  protected StackTraceElement getBestStackTraceElement(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable == null) || (paramThrowable.length == 0)) {
      return null;
    }
    int j = paramThrowable.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = paramThrowable[i];
      String str = localStackTraceElement.getClassName();
      Iterator localIterator = this.includedPackages.iterator();
      while (localIterator.hasNext()) {
        if (str.startsWith((String)localIterator.next())) {
          return localStackTraceElement;
        }
      }
      i += 1;
    }
    return paramThrowable[0];
  }
  
  protected Throwable getCause(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  public String getDescription(String paramString, Throwable paramThrowable)
  {
    return getDescription(getCause(paramThrowable), getBestStackTraceElement(getCause(paramThrowable)), paramString);
  }
  
  protected String getDescription(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getSimpleName());
    if (paramStackTraceElement != null)
    {
      String[] arrayOfString = paramStackTraceElement.getClassName().split("\\.");
      String str = "unknown";
      paramThrowable = str;
      if (arrayOfString != null)
      {
        paramThrowable = str;
        if (arrayOfString.length > 0) {
          paramThrowable = arrayOfString[(arrayOfString.length - 1)];
        }
      }
      localStringBuilder.append(String.format(" (@%s:%s)", new Object[] { paramThrowable, paramStackTraceElement.getMethodName() }));
    }
    if (paramString != null) {
      localStringBuilder.append(String.format(" {%s}", new Object[] { paramString }));
    }
    return localStringBuilder.toString();
  }
  
  public void setIncludedPackages(Context paramContext, Collection<String> paramCollection)
  {
    this.includedPackages.clear();
    Object localObject = new HashSet();
    if (paramCollection != null) {
      ((Set)localObject).addAll(paramCollection);
    }
    int i;
    if (paramContext != null) {
      try
      {
        paramCollection = paramContext.getApplicationContext().getPackageName();
        this.includedPackages.add(paramCollection);
        paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramCollection, 15).activities;
        if (paramContext != null)
        {
          int j = paramContext.length;
          i = 0;
          while (i < j)
          {
            ((Set)localObject).add(paramContext[i].packageName);
            i += 1;
          }
        }
        paramContext = ((Set)localObject).iterator();
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.i("No package found");
      }
    }
    if (paramContext.hasNext())
    {
      paramCollection = (String)paramContext.next();
      i = 1;
      localObject = this.includedPackages.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramCollection.startsWith(str)) {
            break label215;
          }
          if (str.startsWith(paramCollection)) {
            this.includedPackages.remove(str);
          }
        }
        if (i == 0) {
          break;
        }
        this.includedPackages.add(paramCollection);
        break;
        label215:
        i = 0;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/StandardExceptionParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */