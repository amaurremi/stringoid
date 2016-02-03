package com.google.tagmanager;

class EventEvaluator
{
  private final ResourceUtil.ExpandedResource mResource;
  private final Runtime mRuntime;
  
  public EventEvaluator(Runtime paramRuntime, ResourceUtil.ExpandedResource paramExpandedResource)
  {
    if (paramRuntime == null) {
      throw new NullPointerException("runtime cannot be null");
    }
    this.mRuntime = paramRuntime;
    if (paramExpandedResource != paramRuntime.getResource()) {
      throw new IllegalArgumentException("resource must be the same as the resource in runtime");
    }
    this.mResource = paramRuntime.getResource();
  }
  
  void evaluateEvent(String paramString)
  {
    throw new UnsupportedOperationException("this code not yet written");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/EventEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */