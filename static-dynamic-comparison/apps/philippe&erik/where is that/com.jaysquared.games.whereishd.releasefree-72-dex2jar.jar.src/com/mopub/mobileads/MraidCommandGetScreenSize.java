package com.mopub.mobileads;

import java.util.Map;

class MraidCommandGetScreenSize
  extends MraidCommand
{
  MraidCommandGetScreenSize(Map<String, String> paramMap, MraidView paramMraidView)
  {
    super(paramMap, paramMraidView);
  }
  
  void execute()
  {
    this.mView.getDisplayController().getScreenSize();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidCommandGetScreenSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */