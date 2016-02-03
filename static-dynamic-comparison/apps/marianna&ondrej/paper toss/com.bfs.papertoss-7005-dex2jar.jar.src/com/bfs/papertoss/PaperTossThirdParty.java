package com.bfs.papertoss;

import android.annotation.SuppressLint;
import com.backflipstudios.android.debug.BFSDebug;
import java.util.HashMap;

public class PaperTossThirdParty
{
  public static final String FLURRY_API_KEY = "WAJQV9CWNGIK5DKA8L17";
  public static final String GOOGLE_ANALYTICS_PHONE_KEY = "UA-29101149-2";
  public static final String GOOGLE_ANALYTICS_TABLET_KEY = "UA-29101149-8";
  public static final String PAPAYA_API_KEY = "pyCrdU2lUSQ7CeJg";
  public static HashMap<String, String> s_ad_keys = null;
  
  @SuppressLint({"DefaultLocale"})
  public static String query(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (s_ad_keys == null)
    {
      s_ad_keys = new HashMap();
      s_ad_keys.put("MOPUB_GOOGLE_PHONE_MENU_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUYq-DWEgw");
      s_ad_keys.put("MOPUB_GOOGLE_PHONE_GAMEPLAY_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUYzp3fEgw");
      s_ad_keys.put("MOPUB_GOOGLE_PHONE_STARTUP_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUYkrXfEgw");
      s_ad_keys.put("MOPUB_GOOGLE_PHONE_GAMEPLAY_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUY5__bEgw");
      s_ad_keys.put("MOPUB_GOOGLE_TABLET_MENU_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUYjvzXEgw");
      s_ad_keys.put("MOPUB_GOOGLE_TABLET_GAMEPLAY_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUY3tvaEgw");
      s_ad_keys.put("MOPUB_GOOGLE_TABLET_STARTUP_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUY4L3SEgw");
      s_ad_keys.put("MOPUB_GOOGLE_TABLET_GAMEPLAY_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUYra3SEgw");
      s_ad_keys.put("MOPUB_AMAZON_PHONE_MENU_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUY2qjoEww");
      s_ad_keys.put("MOPUB_AMAZON_PHONE_GAMEPLAY_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUYp6PvEww");
      s_ad_keys.put("MOPUB_AMAZON_PHONE_STARTUP_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUY6bjtEww");
      s_ad_keys.put("MOPUB_AMAZON_PHONE_GAMEPLAY_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUYivPxEww");
      s_ad_keys.put("MOPUB_AMAZON_TABLET_MENU_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUYg8T0Eww");
      s_ad_keys.put("MOPUB_AMAZON_TABLET_GAMEPLAY_BANNER", "agltb3B1Yi1pbmNyDQsSBFNpdGUYyJD2Eww");
      s_ad_keys.put("MOPUB_AMAZON_TABLET_STARTUP_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUY_Zf4Eww");
      s_ad_keys.put("MOPUB_AMAZON_TABLET_GAMEPLAY_INTERSTITIAL", "agltb3B1Yi1pbmNyDQsSBFNpdGUYzrf4Eww");
    }
    paramString1 = paramString1.toUpperCase() + '_' + paramString2.toUpperCase() + '_' + paramString3.toUpperCase() + '_' + paramString4.toUpperCase();
    if (s_ad_keys.containsKey(paramString1))
    {
      paramString2 = (String)s_ad_keys.get(paramString1);
      BFSDebug.d("Successfully queried key for " + paramString1 + " : " + paramString2);
      return paramString2;
    }
    BFSDebug.e("Failed to query key for " + paramString1);
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/PaperTossThirdParty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */