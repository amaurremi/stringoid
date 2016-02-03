package com.bluebird.mobile.tools.timecounter;

import android.util.Log;
import com.bluebird.mobile.tools.counter.CounterService;

public class MaxCurrencyAmountCondition
  implements FireEventCondition
{
  private CounterService counterService;
  private int maxCurrencyAmount;
  
  public MaxCurrencyAmountCondition(CounterService paramCounterService, int paramInt)
  {
    this.counterService = paramCounterService;
    this.maxCurrencyAmount = paramInt;
  }
  
  public boolean canBeFired()
  {
    if (this.counterService.getCurrent() <= this.maxCurrencyAmount) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("BTC", "MaxCurrencyAmountCondition condition - can be fired: " + bool + "(maxCurrencyAmount=" + this.maxCurrencyAmount + ")");
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/timecounter/MaxCurrencyAmountCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */