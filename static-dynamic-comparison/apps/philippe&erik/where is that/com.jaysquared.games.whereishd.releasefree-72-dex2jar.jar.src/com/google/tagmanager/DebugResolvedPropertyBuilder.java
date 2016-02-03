package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

class DebugResolvedPropertyBuilder
  implements ResolvedPropertyBuilder
{
  private MutableDebug.ResolvedProperty resolvedProperty;
  
  public DebugResolvedPropertyBuilder(MutableDebug.ResolvedProperty paramResolvedProperty)
  {
    this.resolvedProperty = paramResolvedProperty;
  }
  
  public ValueBuilder createPropertyValueBuilder(TypeSystem.Value paramValue)
  {
    paramValue = DebugValueBuilder.copyImmutableValue(paramValue);
    this.resolvedProperty.setValue(paramValue);
    return new DebugValueBuilder(paramValue);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugResolvedPropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */