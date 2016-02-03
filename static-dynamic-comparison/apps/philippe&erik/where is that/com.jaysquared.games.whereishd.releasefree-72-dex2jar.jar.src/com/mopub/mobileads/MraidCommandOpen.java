package com.mopub.mobileads;

import java.util.Map;

class MraidCommandOpen
  extends MraidCommand
{
  MraidCommandOpen(Map<String, String> paramMap, MraidView paramMraidView)
  {
    super(paramMap, paramMraidView);
  }
  
  void execute()
  {
    String str = getStringFromParamsForKey("url");
    if (str == null)
    {
      this.mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.OPEN, "Url can not be null.");
      return;
    }
    this.mView.getBrowserController().open(str);
  }
  
  protected boolean isCommandDependentOnUserClick(MraidView.PlacementType paramPlacementType)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidCommandOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */