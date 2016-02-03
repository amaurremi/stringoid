package com.vungle.publisher;

import java.lang.reflect.Method;

final class dp
{
  final Method a;
  final ds b;
  final Class<?> c;
  String d;
  
  dp(Method paramMethod, ds paramds, Class<?> paramClass)
  {
    this.a = paramMethod;
    this.b = paramds;
    this.c = paramClass;
  }
  
  private void a()
  {
    try
    {
      if (this.d == null)
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        localStringBuilder.append(this.a.getDeclaringClass().getName());
        localStringBuilder.append('#').append(this.a.getName());
        localStringBuilder.append('(').append(this.c.getName());
        this.d = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof dp))
    {
      a();
      paramObject = (dp)paramObject;
      ((dp)paramObject).a();
      return this.d.equals(((dp)paramObject).d);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */