package com.mopub.mobileads;

import java.util.Map;

class MraidCommandExpand
  extends MraidCommand
{
  MraidCommandExpand(Map<String, String> paramMap, MraidView paramMraidView)
  {
    super(paramMap, paramMraidView);
  }
  
  void execute()
  {
    int j = getIntFromParamsForKey("w");
    int k = getIntFromParamsForKey("h");
    String str = getStringFromParamsForKey("url");
    boolean bool1 = getBooleanFromParamsForKey("shouldUseCustomClose");
    boolean bool2 = getBooleanFromParamsForKey("lockOrientation");
    int i = j;
    if (j <= 0) {
      i = this.mView.getDisplayController().mScreenWidth;
    }
    j = k;
    if (k <= 0) {
      j = this.mView.getDisplayController().mScreenHeight;
    }
    this.mView.getDisplayController().expand(str, i, j, bool1, bool2);
  }
  
  protected boolean isCommandDependentOnUserClick(MraidView.PlacementType paramPlacementType)
  {
    switch (paramPlacementType)
    {
    default: 
      return super.isCommandDependentOnUserClick(paramPlacementType);
    case ???: 
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidCommandExpand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */