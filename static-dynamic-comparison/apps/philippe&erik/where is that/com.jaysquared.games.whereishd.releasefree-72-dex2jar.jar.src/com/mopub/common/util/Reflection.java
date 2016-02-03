package com.mopub.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection
{
  public static boolean classFound(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString) {}
    return false;
  }
  
  public static Method getDeclaredMethodWithTraversal(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
    throws NoSuchMethodException
  {
    while (paramClass != null) {
      try
      {
        Method localMethod = paramClass.getDeclaredMethod(paramString, paramVarArgs);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramClass = paramClass.getSuperclass();
      }
    }
    throw new NoSuchMethodException();
  }
  
  public static class MethodBuilder
  {
    private Class<?> mClass;
    private final Object mInstance;
    private boolean mIsAccessible;
    private boolean mIsStatic;
    private final String mMethodName;
    private List<Class<?>> mParameterClasses;
    private List<Object> mParameters;
    
    public MethodBuilder(Object paramObject, String paramString)
    {
      this.mInstance = paramObject;
      this.mMethodName = paramString;
      this.mParameterClasses = new ArrayList();
      this.mParameters = new ArrayList();
      if (paramObject != null) {}
      for (paramObject = paramObject.getClass();; paramObject = null)
      {
        this.mClass = ((Class)paramObject);
        return;
      }
    }
    
    public <T> MethodBuilder addParam(Class<T> paramClass, T paramT)
    {
      this.mParameterClasses.add(paramClass);
      this.mParameters.add(paramT);
      return this;
    }
    
    public Object execute()
      throws Exception
    {
      Object localObject = new Class[this.mParameterClasses.size()];
      localObject = (Class[])this.mParameterClasses.toArray((Object[])localObject);
      localObject = Reflection.getDeclaredMethodWithTraversal(this.mClass, this.mMethodName, (Class[])localObject);
      if (this.mIsAccessible) {
        ((Method)localObject).setAccessible(true);
      }
      Object[] arrayOfObject = this.mParameters.toArray();
      if (this.mIsStatic) {
        return ((Method)localObject).invoke(null, arrayOfObject);
      }
      return ((Method)localObject).invoke(this.mInstance, arrayOfObject);
    }
    
    public MethodBuilder setAccessible()
    {
      this.mIsAccessible = true;
      return this;
    }
    
    public MethodBuilder setStatic(Class<?> paramClass)
    {
      this.mIsStatic = true;
      this.mClass = paramClass;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */