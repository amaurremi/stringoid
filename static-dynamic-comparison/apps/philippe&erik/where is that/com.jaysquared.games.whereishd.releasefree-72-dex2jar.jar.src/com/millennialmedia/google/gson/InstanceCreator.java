package com.millennialmedia.google.gson;

import java.lang.reflect.Type;

public abstract interface InstanceCreator<T>
{
  public abstract T createInstance(Type paramType);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/google/gson/InstanceCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */