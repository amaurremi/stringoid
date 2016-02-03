package com.flurry.org.codehaus.jackson.map.util;

import java.util.Collection;

public abstract interface Provider<T>
{
  public abstract Collection<T> provide();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/util/Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */