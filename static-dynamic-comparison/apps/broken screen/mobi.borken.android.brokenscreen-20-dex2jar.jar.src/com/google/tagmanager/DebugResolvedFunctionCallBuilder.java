package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall;
import com.google.analytics.containertag.proto.Debug.ResolvedProperty;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

class DebugResolvedFunctionCallBuilder
  implements ResolvedFunctionCallBuilder
{
  private Debug.ResolvedFunctionCall resolvedFunctionCall;
  
  public DebugResolvedFunctionCallBuilder(Debug.ResolvedFunctionCall paramResolvedFunctionCall)
  {
    this.resolvedFunctionCall = paramResolvedFunctionCall;
  }
  
  public ResolvedPropertyBuilder createResolvedPropertyBuilder(String paramString)
  {
    Debug.ResolvedProperty localResolvedProperty = new Debug.ResolvedProperty();
    localResolvedProperty.key = paramString;
    this.resolvedFunctionCall.properties = ArrayUtils.appendToArray(this.resolvedFunctionCall.properties, localResolvedProperty);
    return new DebugResolvedPropertyBuilder(localResolvedProperty);
  }
  
  public void setFunctionResult(TypeSystem.Value paramValue)
  {
    this.resolvedFunctionCall.result = DebugValueBuilder.copyImmutableValue(paramValue);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DebugResolvedFunctionCallBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */