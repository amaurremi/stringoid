package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

class NoopResolvedFunctionCallBuilder
  implements ResolvedFunctionCallBuilder
{
  public ResolvedPropertyBuilder createResolvedPropertyBuilder(String paramString)
  {
    return new NoopResolvedPropertyBuilder();
  }
  
  public void setFunctionResult(TypeSystem.Value paramValue) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/NoopResolvedFunctionCallBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */