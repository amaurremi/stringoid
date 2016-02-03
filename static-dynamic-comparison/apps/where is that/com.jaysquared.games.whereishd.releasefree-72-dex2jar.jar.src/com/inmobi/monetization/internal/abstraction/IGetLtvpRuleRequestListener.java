package com.inmobi.monetization.internal.abstraction;

import com.inmobi.monetization.internal.GetLtvpRulesRequest;
import com.inmobi.monetization.internal.GetLtvpRulesResponse;
import com.inmobi.monetization.internal.LtvpErrorCode;

public abstract interface IGetLtvpRuleRequestListener
{
  public abstract void onLtvpGetRuleFailed(GetLtvpRulesRequest paramGetLtvpRulesRequest, LtvpErrorCode paramLtvpErrorCode);
  
  public abstract void onLtvpGetRuleSucceeded(GetLtvpRulesRequest paramGetLtvpRulesRequest, GetLtvpRulesResponse paramGetLtvpRulesResponse);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/abstraction/IGetLtvpRuleRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */