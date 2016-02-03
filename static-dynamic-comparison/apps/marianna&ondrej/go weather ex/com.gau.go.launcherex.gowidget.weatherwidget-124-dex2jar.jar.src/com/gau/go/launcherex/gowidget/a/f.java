package com.gau.go.launcherex.gowidget.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public class f
{
  private final Intent a;
  
  public f(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("'intent' can not be NULL or empty");
    }
    if (!paramIntent.getBooleanExtra("getjar", false)) {
      throw new IllegalArgumentException("'intent' must be a Getjar Intent");
    }
    this.a = paramIntent;
  }
  
  public Intent a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof f))) {}
    while (hashCode() != paramObject.hashCode()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = this.a.getExtras().keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("=");
      localObject = this.a.getExtras().get((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(localObject.toString());
      }
      localStringBuilder.append(",");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */