package com.mopub.mobileads;

import java.util.Map;

class MraidCommandGetResizeProperties
  extends MraidCommand
{
  MraidCommandGetResizeProperties(Map<String, String> paramMap, MraidView paramMraidView)
  {
    super(paramMap, paramMraidView);
  }
  
  void execute()
  {
    this.mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_RESIZE_PROPERTIES, "Unsupported action getResizeProperties.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidCommandGetResizeProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */