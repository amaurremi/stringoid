package com.fasterxml.jackson.databind.util;

import java.util.Collection;

public abstract interface Provider<T>
{
  public abstract Collection<T> provide();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */