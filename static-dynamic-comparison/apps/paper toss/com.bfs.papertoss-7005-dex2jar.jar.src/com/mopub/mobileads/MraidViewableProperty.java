package com.mopub.mobileads;

class MraidViewableProperty
  extends MraidProperty
{
  private final boolean mViewable;
  
  MraidViewableProperty(boolean paramBoolean)
  {
    this.mViewable = paramBoolean;
  }
  
  public static MraidViewableProperty createWithViewable(boolean paramBoolean)
  {
    return new MraidViewableProperty(paramBoolean);
  }
  
  public String toJsonPair()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("viewable: ");
    if (this.mViewable) {}
    for (String str = "true";; str = "false") {
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidViewableProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */