package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

final class ViewMatcher$Empty
  extends ViewMatcher
  implements Serializable
{
  static final Empty instance = new Empty();
  
  public boolean isVisibleForView(Class<?> paramClass)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ViewMatcher$Empty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */