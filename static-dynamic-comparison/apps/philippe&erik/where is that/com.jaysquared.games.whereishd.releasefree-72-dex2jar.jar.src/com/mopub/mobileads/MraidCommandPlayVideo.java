package com.mopub.mobileads;

import java.util.Map;

class MraidCommandPlayVideo
  extends MraidCommand
{
  public MraidCommandPlayVideo(Map<String, String> paramMap, MraidView paramMraidView)
  {
    super(paramMap, paramMraidView);
  }
  
  void execute()
  {
    String str = getStringFromParamsForKey("uri");
    if ((str != null) && (!str.equals("")))
    {
      this.mView.getDisplayController().showVideo(str);
      return;
    }
    this.mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.PLAY_VIDEO, "Video can't be played with null or empty URL");
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidCommandPlayVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */