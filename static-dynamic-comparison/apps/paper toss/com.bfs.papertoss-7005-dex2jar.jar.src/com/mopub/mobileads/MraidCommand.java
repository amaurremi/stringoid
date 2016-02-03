package com.mopub.mobileads;

import java.util.Map;

abstract class MraidCommand
{
  protected Map<String, String> mParams;
  protected MraidView mView;
  
  MraidCommand(Map<String, String> paramMap, MraidView paramMraidView)
  {
    this.mParams = paramMap;
    this.mView = paramMraidView;
  }
  
  abstract void execute();
  
  protected boolean getBooleanFromParamsForKey(String paramString)
  {
    return "true".equals(this.mParams.get(paramString));
  }
  
  protected float getFloatFromParamsForKey(String paramString)
  {
    if ((String)this.mParams.get(paramString) == null) {
      return 0.0F;
    }
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException paramString) {}
    return 0.0F;
  }
  
  protected int getIntFromParamsForKey(String paramString)
  {
    paramString = (String)this.mParams.get(paramString);
    if (paramString == null) {
      return -1;
    }
    try
    {
      int i = Integer.parseInt(paramString, 10);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  protected String getStringFromParamsForKey(String paramString)
  {
    return (String)this.mParams.get(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */