package com.mopub.common.factories;

import com.mopub.common.util.Reflection.MethodBuilder;

public class MethodBuilderFactory
{
  protected static MethodBuilderFactory instance = new MethodBuilderFactory();
  
  public static Reflection.MethodBuilder create(Object paramObject, String paramString)
  {
    return instance.internalCreate(paramObject, paramString);
  }
  
  @Deprecated
  public static void setInstance(MethodBuilderFactory paramMethodBuilderFactory)
  {
    instance = paramMethodBuilderFactory;
  }
  
  protected Reflection.MethodBuilder internalCreate(Object paramObject, String paramString)
  {
    return new Reflection.MethodBuilder(paramObject, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/factories/MethodBuilderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */