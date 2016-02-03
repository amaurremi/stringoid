package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

final class ViewMatcher$Multi
  extends ViewMatcher
  implements Serializable
{
  private final Class<?>[] _views;
  
  public ViewMatcher$Multi(Class<?>[] paramArrayOfClass)
  {
    this._views = paramArrayOfClass;
  }
  
  public boolean isVisibleForView(Class<?> paramClass)
  {
    boolean bool2 = false;
    int j = this._views.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        Class localClass = this._views[i];
        if ((paramClass == localClass) || (localClass.isAssignableFrom(paramClass))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ViewMatcher$Multi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */