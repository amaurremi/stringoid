package com.magmamobile.game.BubbleBlast.utils.solutions;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.magmamobile.game.BubbleBlast.modCommon;
import java.util.Date;

public class modSolution
{
  public static boolean alreadyAskedSolution(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefsol" + paramString, false);
  }
  
  public static boolean canAskSolution(Context paramContext)
  {
    long l = lastAskedSolution(paramContext);
    if (l == 0L) {}
    do
    {
      return true;
      modCommon.Log_d(l + "/" + (new Date().getTime() - 86400000L));
      modCommon.Log_d(new Date(l).toLocaleString() + "/" + new Date(new Date().getTime() - 86400000L).toLocaleString());
      modCommon.Log_d(l - (new Date().getTime() - 86400000L));
    } while (l < new Date().getTime() - 86400000L);
    return false;
  }
  
  public static long lastAskedSolution(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("prefLastAskedSolution", 0L);
  }
  
  public static void setAskedSolutionDate(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("prefLastAskedSolution", new Date().getTime());
    paramContext.putBoolean("prefsol" + paramString, true);
    paramContext.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/utils/solutions/modSolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */