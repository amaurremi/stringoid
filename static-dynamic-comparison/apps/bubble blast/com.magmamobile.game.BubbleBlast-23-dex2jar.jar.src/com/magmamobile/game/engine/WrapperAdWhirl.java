package com.magmamobile.game.engine;

import com.adwhirl.AdWhirlTargeting;

final class WrapperAdWhirl
{
  protected static final void check(AppParameters paramAppParameters)
  {
    if (Package.getPackage("com.adwhirl") != null)
    {
      com.adwhirl.obj.Extra2.extraLinkMarketCustom = paramAppParameters.LINK_MARKET_CUSTOM;
      com.adwhirl.obj.Extra2.kreativeAppID = paramAppParameters.KREACTIVE_APP_ID;
      com.adwhirl.obj.Extra2.googleTestMode = paramAppParameters.GGADS_TESTING;
      com.adwhirl.obj.Extra2.verboselog = paramAppParameters.ADWHIRL_VERBOSE_LOG;
      if ((paramAppParameters.ADWHIRL_DEFAULT_NID != null) && (paramAppParameters.ADWHIRL_DEFAULT_ADMOBKEY != null))
      {
        com.adwhirl.ModCommon.defaultjson = AppParameters.AdWhirl.makeJSON(paramAppParameters.ADWHIRL_DEFAULT_NID, paramAppParameters.ADWHIRL_DEFAULT_ADMOBKEY);
        AdWhirlTargeting.setTestMode(paramAppParameters.ADWHIRL_TESTING_MODE);
        return;
      }
      throw new RuntimeException("ADWHIRL NOT SET !");
    }
    throw new RuntimeException("ADWHIRL NOT LINKED !");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/WrapperAdWhirl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */