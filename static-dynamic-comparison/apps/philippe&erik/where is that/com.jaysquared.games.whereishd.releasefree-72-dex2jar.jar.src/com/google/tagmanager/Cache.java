package com.google.tagmanager;

abstract interface Cache<K, V>
{
  public abstract V get(K paramK);
  
  public abstract void put(K paramK, V paramV);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */