package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.MutableDebug.ResolvedProperty;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

class DebugResolvedFunctionCallBuilder
  implements ResolvedFunctionCallBuilder
{
  private MutableDebug.ResolvedFunctionCall resolvedFunctionCall;
  
  public DebugResolvedFunctionCallBuilder(MutableDebug.ResolvedFunctionCall paramResolvedFunctionCall)
  {
    this.resolvedFunctionCall = paramResolvedFunctionCall;
  }
  
  public ResolvedPropertyBuilder createResolvedPropertyBuilder(String paramString)
  {
    MutableDebug.ResolvedProperty localResolvedProperty = this.resolvedFunctionCall.addProperties();
    localResolvedProperty.setKey(paramString);
    return new DebugResolvedPropertyBuilder(localResolvedProperty);
  }
  
  public void setFunctionResult(TypeSystem.Value paramValue)
  {
    this.resolvedFunctionCall.setResult(DebugValueBuilder.copyImmutableValue(paramValue));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugResolvedFunctionCallBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */