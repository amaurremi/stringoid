package com.amazon.inapp.purchasing;

import java.util.Collection;

class Validator
{
  static void validateNotEmpty(Collection<? extends Object> paramCollection, String paramString)
  {
    if (paramCollection.isEmpty()) {
      throw new IllegalArgumentException(paramString + " must not be empty");
    }
  }
  
  static void validateNotNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException(paramString + " must not be null");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/Validator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */