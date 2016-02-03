package com.e.a.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

class o
  implements InvocationHandler
{
  private final List a;
  private boolean b;
  private String c;
  
  public o(List paramList)
  {
    this.a = paramList;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    Class localClass = paramMethod.getReturnType();
    paramObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramObject = q.b;
    }
    if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
      return Boolean.valueOf(true);
    }
    if ((str.equals("unsupported")) && (Void.TYPE == localClass))
    {
      this.b = true;
      return null;
    }
    if ((str.equals("protocols")) && (paramObject.length == 0)) {
      return this.a;
    }
    if ((str.equals("selectProtocol")) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] == null) || ((paramObject[0] instanceof List))))
    {
      paramObject = (List)paramObject[0];
      this.c = ((String)this.a.get(0));
      return this.c;
    }
    if ((str.equals("protocolSelected")) && (paramObject.length == 1))
    {
      this.c = ((String)paramObject[0]);
      return null;
    }
    return paramMethod.invoke(this, (Object[])paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */