package com.gau.go.launcherex.gowidget.language;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

public class b
  extends Resources
{
  private String a;
  private Resources b;
  
  public b(Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    try
    {
      localObject = Resources.class.getDeclaredField("mCompatibilityInfo");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramResources);
      if (localObject != null)
      {
        Field localField = Resources.class.getDeclaredField("mCompatibilityInfo");
        localField.setAccessible(true);
        localField.set(this, localObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
      }
    }
    paramResources = paramResources.getDisplayMetrics();
    localObject = getDisplayMetrics();
    if (paramResources.density != ((DisplayMetrics)localObject).density) {
      updateConfiguration(getConfiguration(), paramResources);
    }
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
  }
  
  public void a(String paramString, Resources paramResources)
  {
    this.a = paramString;
    this.b = paramResources;
  }
  
  public String[] getStringArray(int paramInt)
  {
    if (this.b != null)
    {
      Object localObject1 = getResourceEntryName(paramInt);
      try
      {
        int i = this.b.getIdentifier((String)localObject1, "array", this.a);
        localObject1 = this.b.getStringArray(i);
        if (localObject1 != null) {
          return (String[])localObject1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    return super.getStringArray(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    if (this.b != null)
    {
      Object localObject1 = getResourceEntryName(paramInt);
      try
      {
        int i = this.b.getIdentifier((String)localObject1, "string", this.a);
        localObject1 = this.b.getText(i);
        if (localObject1 != null) {
          return (CharSequence)localObject1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    return super.getText(paramInt);
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    if (this.b != null)
    {
      Object localObject1 = getResourceEntryName(paramInt);
      try
      {
        int i = this.b.getIdentifier((String)localObject1, "array", this.a);
        localObject1 = this.b.getStringArray(i);
        if (localObject1 != null) {
          return (CharSequence[])localObject1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    return super.getTextArray(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */