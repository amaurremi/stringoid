package com.fasterxml.jackson.databind.cfg;

public abstract interface ConfigFeature
{
  public abstract boolean enabledByDefault();
  
  public abstract int getMask();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/cfg/ConfigFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */