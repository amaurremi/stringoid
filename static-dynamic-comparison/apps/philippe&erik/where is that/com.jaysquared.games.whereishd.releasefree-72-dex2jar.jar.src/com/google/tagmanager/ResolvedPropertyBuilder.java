package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

abstract interface ResolvedPropertyBuilder
{
  public abstract ValueBuilder createPropertyValueBuilder(TypeSystem.Value paramValue);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ResolvedPropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */