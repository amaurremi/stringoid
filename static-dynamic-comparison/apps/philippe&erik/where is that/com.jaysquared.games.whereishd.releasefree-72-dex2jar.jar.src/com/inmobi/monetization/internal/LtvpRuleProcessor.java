package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.abstraction.IGetLtvpRuleRequestListener;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;
import java.util.HashMap;

public class LtvpRuleProcessor
  implements IGetLtvpRuleRequestListener
{
  private ServiceProvider a = ServiceProvider.getInstance();
  
  public static LtvpRuleProcessor getInstance()
  {
    return new LtvpRuleProcessor();
  }
  
  public void dispatchLtvpRule()
  {
    Log.internal("[InMobi]-[Monetization]", "Fetching LTVP Rule");
    GetLtvpRulesRequest localGetLtvpRulesRequest = new GetLtvpRulesRequest();
    this.a.getLtvpRule(localGetLtvpRulesRequest, this);
  }
  
  public ActionsRule getLtvpRuleConfig(long paramLong)
  {
    ActionsRule.MEDIATION.getValue();
    LtvpRuleCache localLtvpRuleCache = LtvpRuleCache.getInstance(InternalSDKUtil.getContext());
    if ((localLtvpRuleCache.getHardExpiryForLtvpRule() <= System.currentTimeMillis()) || (localLtvpRuleCache.getHardExpiryForLtvpRule() == 0L))
    {
      Log.internal("[InMobi]-[Monetization]", "Hard Expiry or 1st rule fetch. Default mediation. Fetching Rule");
      dispatchLtvpRule();
      localLtvpRuleCache.clearLtvpRuleCache();
      return ActionsRule.MEDIATION;
    }
    if (localLtvpRuleCache.getSoftExpiryForLtvpRule() <= System.currentTimeMillis())
    {
      Log.internal("[InMobi]-[Monetization]", "Soft Expiry. Default mediation. Fetching Rule");
      dispatchLtvpRule();
    }
    for (int i = localLtvpRuleCache.getLtvpRule(paramLong);; i = localLtvpRuleCache.getLtvpRule(paramLong))
    {
      return ActionsRule.a(i);
      Log.internal("[InMobi]-[Monetization]", "Valid rule");
    }
  }
  
  public void onLtvpGetRuleFailed(GetLtvpRulesRequest paramGetLtvpRulesRequest, LtvpErrorCode paramLtvpErrorCode)
  {
    Log.internal("[InMobi]-[Monetization]", "Ltvp Rule error" + paramLtvpErrorCode.toString());
  }
  
  public void onLtvpGetRuleSucceeded(GetLtvpRulesRequest paramGetLtvpRulesRequest, GetLtvpRulesResponse paramGetLtvpRulesResponse)
  {
    Log.internal("[InMobi]-[Monetization]", "Ltvp Rule received" + paramGetLtvpRulesResponse.getRules().toString());
    LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).setLtvpRuleConfig(paramGetLtvpRulesResponse);
  }
  
  public static enum ActionsRule
  {
    int a;
    
    static
    {
      ACTIONS_TO_MEDIATION = new ActionsRule("ACTIONS_TO_MEDIATION", 2, 2);
    }
    
    private ActionsRule(int paramInt)
    {
      this.a = paramInt;
    }
    
    static ActionsRule a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return MEDIATION;
      case 1: 
        return NO_ADS;
      case 2: 
        return ACTIONS_TO_MEDIATION;
      }
      return ACTIONS_ONLY;
    }
    
    public int getValue()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/LtvpRuleProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */