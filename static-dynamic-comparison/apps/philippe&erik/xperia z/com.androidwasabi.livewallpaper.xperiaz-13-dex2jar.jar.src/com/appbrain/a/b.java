package com.appbrain.a;

import android.content.Intent;

final class b
{
  public final int a;
  public final int b;
  
  private b(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static b a()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Exception().getStackTrace();
    StringBuffer localStringBuffer = new StringBuffer();
    String str = a(a.class.getName());
    int j = arrayOfStackTraceElement.length;
    Object localObject1 = "";
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      Object localObject2 = localObject1;
      if (!a(localStackTraceElement.getClassName()).equals(str))
      {
        localStringBuffer.append(localStackTraceElement.toString());
        localObject2 = localObject1;
        if (((String)localObject1).length() == 0) {
          localObject2 = localStackTraceElement.toString();
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return new b(((String)localObject1).hashCode(), localStringBuffer.hashCode());
  }
  
  public static b a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new b(-1, -1);
    }
    return new b(paramIntent.getIntExtra("hash_last", -1), paramIntent.getIntExtra("hash", -1));
  }
  
  private static String a(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public final void b(Intent paramIntent)
  {
    paramIntent.putExtra("hash_last", this.a);
    paramIntent.putExtra("hash", this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */