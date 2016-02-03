package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

final class ViewMatcher$Single
  extends ViewMatcher
  implements Serializable
{
  private final Class<?> _view;
  
  public ViewMatcher$Single(Class<?> paramClass)
  {
    this._view = paramClass;
  }
  
  public boolean isVisibleForView(Class<?> paramClass)
  {
    return (paramClass == this._view) || (this._view.isAssignableFrom(paramClass));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ViewMatcher$Single.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */