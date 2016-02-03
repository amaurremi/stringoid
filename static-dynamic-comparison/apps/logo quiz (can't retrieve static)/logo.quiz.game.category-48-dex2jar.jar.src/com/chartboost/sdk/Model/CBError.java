package com.chartboost.sdk.Model;

public final class CBError
{
  private a a;
  private String b;
  private boolean c;
  
  public CBError(a parama, String paramString)
  {
    this.a = parama;
    this.b = paramString;
    this.c = true;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public CBImpressionError b()
  {
    switch (1.a[this.a.ordinal()])
    {
    default: 
      return CBImpressionError.NETWORK_FAILURE;
    case 1: 
    case 2: 
      return CBImpressionError.INTERNAL;
    }
    return CBImpressionError.INTERNET_UNAVAILABLE;
  }
  
  public static enum CBClickError
  {
    static
    {
      AGE_GATE_FAILURE = new CBClickError("AGE_GATE_FAILURE", 2);
      NO_HOST_ACTIVITY = new CBClickError("NO_HOST_ACTIVITY", 3);
    }
    
    private CBClickError() {}
  }
  
  public static enum CBImpressionError
  {
    static
    {
      FIRST_SESSION_INTERSTITIALS_DISABLED = new CBImpressionError("FIRST_SESSION_INTERSTITIALS_DISABLED", 4);
      NETWORK_FAILURE = new CBImpressionError("NETWORK_FAILURE", 5);
      NO_AD_FOUND = new CBImpressionError("NO_AD_FOUND", 6);
      SESSION_NOT_STARTED = new CBImpressionError("SESSION_NOT_STARTED", 7);
    }
    
    private CBImpressionError() {}
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Model/CBError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */