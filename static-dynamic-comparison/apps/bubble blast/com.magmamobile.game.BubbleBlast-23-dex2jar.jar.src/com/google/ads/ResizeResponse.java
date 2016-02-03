package com.google.ads;

import java.util.Map;

class ResizeResponse
  implements AdResponse
{
  private static boolean validateExpandDirection(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return ((paramInt1 > 0) || (paramInt2 > 0) || (paramInt3 > 0) || (paramInt4 > 0)) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0);
  }
  
  public void run(Map<String, String> paramMap, GoogleAdView paramGoogleAdView)
  {
    String str1 = (String)paramMap.get("width");
    String str2 = (String)paramMap.get("height");
    String str3 = (String)paramMap.get("left");
    String str4 = (String)paramMap.get("right");
    String str5 = (String)paramMap.get("top");
    paramMap = (String)paramMap.get("bottom");
    if (str1 != null) {}
    label100:
    int k;
    label112:
    int m;
    label124:
    int n;
    label136:
    int i1;
    label199:
    label205:
    label211:
    label217:
    label225:
    do
    {
      try
      {
        int i = Integer.parseInt(str1);
        int j;
        if (str1 != null)
        {
          j = Integer.parseInt(str2);
          if (str3 == null) {
            break label199;
          }
          k = Integer.parseInt(str3);
          if (str4 == null) {
            break label205;
          }
          m = Integer.parseInt(str4);
          if (str5 == null) {
            break label211;
          }
          n = Integer.parseInt(str5);
          if (paramMap == null) {
            break label217;
          }
        }
        for (i1 = Integer.parseInt(paramMap);; i1 = 0)
        {
          if ((i == paramGoogleAdView.getAdWidth()) && (j == paramGoogleAdView.getAdHeight())) {
            break label225;
          }
          if (paramGoogleAdView.isExpanded()) {
            paramGoogleAdView.closeAdImmediately();
          }
          paramGoogleAdView.resize(i, j);
          return;
          i = paramGoogleAdView.getAdWidth();
          break;
          j = paramGoogleAdView.getAdHeight();
          break label100;
          k = 0;
          break label112;
          m = 0;
          break label124;
          n = 0;
          break label136;
        }
        if (!paramGoogleAdView.isExpanded()) {
          continue;
        }
      }
      catch (NumberFormatException paramMap)
      {
        return;
      }
      if ((k == 0) && (m == 0) && (n == 0) && (i1 == 0))
      {
        paramGoogleAdView.retractAd();
        return;
      }
    } while ((paramGoogleAdView.isExpanded()) || (!validateExpandDirection(n, i1, k, m)));
    paramGoogleAdView.expandAd(n, i1, k, m);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/ResizeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */