package com.fasterxml.jackson.databind.util;

public abstract class ViewMatcher
{
  public static ViewMatcher construct(Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null) {
      return ViewMatcher.Empty.instance;
    }
    switch (paramArrayOfClass.length)
    {
    default: 
      return new ViewMatcher.Multi(paramArrayOfClass);
    case 0: 
      return ViewMatcher.Empty.instance;
    }
    return new ViewMatcher.Single(paramArrayOfClass[0]);
  }
  
  public abstract boolean isVisibleForView(Class<?> paramClass);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ViewMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */