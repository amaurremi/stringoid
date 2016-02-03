package com.mopub.mobileads;

class MraidStateProperty
  extends MraidProperty
{
  private final MraidView.ViewState mViewState;
  
  MraidStateProperty(MraidView.ViewState paramViewState)
  {
    this.mViewState = paramViewState;
  }
  
  public static MraidStateProperty createWithViewState(MraidView.ViewState paramViewState)
  {
    return new MraidStateProperty(paramViewState);
  }
  
  public String toJsonPair()
  {
    return "state: '" + this.mViewState.toString().toLowerCase() + "'";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidStateProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */