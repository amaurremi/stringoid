package com.getjar.sdk.rewards;

public enum GooglePlayLaunchReason
{
  private static final String _SupportedReasons;
  
  static
  {
    CHECKOUT = new GooglePlayLaunchReason("CHECKOUT", 1);
    NONE = new GooglePlayLaunchReason("NONE", 2);
    $VALUES = new GooglePlayLaunchReason[] { REDEEM, CHECKOUT, NONE };
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < values().length)
    {
      localStringBuilder.append(values()[i].name());
      if (i < values().length) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    _SupportedReasons = localStringBuilder.toString();
  }
  
  private GooglePlayLaunchReason() {}
  
  public static String getSupportedReasons()
  {
    return _SupportedReasons;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GooglePlayLaunchReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */