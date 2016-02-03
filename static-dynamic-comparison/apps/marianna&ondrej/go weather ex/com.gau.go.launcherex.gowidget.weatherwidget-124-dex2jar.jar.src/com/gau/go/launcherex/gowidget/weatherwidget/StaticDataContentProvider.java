package com.gau.go.launcherex.gowidget.weatherwidget;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.gau.go.gostaticsdk.c.a;

public class StaticDataContentProvider
  extends ContentProvider
{
  public static Uri a;
  private static UriMatcher b = new UriMatcher(-1);
  private a c;
  
  static
  {
    a = new Uri.Builder().scheme("content").authority("com.gau.go.launcherex.gowidget.weatherwidget.staticsdkprovider").appendPath("data").build();
    b.addURI("com.gau.go.launcherex.gowidget.weatherwidget.staticsdkprovider", "data", 1);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    switch (b.match(paramUri))
    {
    }
    for (paramUri = (Uri)localObject;; paramUri = a.a)
    {
      if (paramUri == null) {
        break label62;
      }
      try
      {
        int i = this.c.a(paramUri, paramString, paramArrayOfString);
        return i;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
      }
    }
    label62:
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (b.match(paramUri))
    {
    }
    for (String str = null; str != null; str = a.a) {
      try
      {
        long l = this.c.a(str, paramContentValues);
        if (l <= 0L) {
          break;
        }
        return paramUri;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
      }
    }
    return null;
  }
  
  public boolean onCreate()
  {
    this.c = new a(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    switch (b.match(paramUri))
    {
    }
    for (paramUri = null;; paramUri = a.a)
    {
      if (paramUri == null) {
        break label59;
      }
      try
      {
        paramUri = this.c.a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
        return paramUri;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
      }
    }
    label59:
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    switch (b.match(paramUri))
    {
    }
    for (paramUri = (Uri)localObject;; paramUri = a.a)
    {
      if (paramUri == null) {
        break label64;
      }
      try
      {
        int i = this.c.a(paramUri, paramContentValues, paramString, paramArrayOfString);
        return i;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
      }
    }
    label64:
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weatherwidget/StaticDataContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */