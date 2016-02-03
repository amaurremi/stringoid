package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.ResolvedProperty;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

class DebugResolvedPropertyBuilder
  implements ResolvedPropertyBuilder
{
  private Debug.ResolvedProperty resolvedProperty;
  
  public DebugResolvedPropertyBuilder(Debug.ResolvedProperty paramResolvedProperty)
  {
    this.resolvedProperty = paramResolvedProperty;
  }
  
  public ValueBuilder createPropertyValueBuilder(TypeSystem.Value paramValue)
  {
    paramValue = DebugValueBuilder.copyImmutableValue(paramValue);
    this.resolvedProperty.value = paramValue;
    return new DebugValueBuilder(paramValue);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugResolvedPropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */