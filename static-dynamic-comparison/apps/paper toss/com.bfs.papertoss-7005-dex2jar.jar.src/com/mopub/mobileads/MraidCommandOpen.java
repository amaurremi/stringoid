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
    this.mView.getBrowserController().open(str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidCommandOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */