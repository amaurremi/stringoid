package com.magmamobile.game.BubbleBlast.utils.solutions.parsers;

import android.os.SystemClock;
import com.magmamobile.game.BubbleBlast.utils.solutions.Solution;
import com.magmamobile.game.BubbleBlast.utils.solutions.SolutionItem;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.parser.JSonParser;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonBBSolution
  extends JSonParser
{
  public static Solution loadItems(String paramString, List<NameValuePair> paramList)
    throws JSONException
  {
    float f = (float)SystemClock.currentThreadTimeMillis();
    Solution localSolution = new Solution();
    try
    {
      paramString = sendJSonRequestPost(paramString, paramList);
      if (!paramString.equals(""))
      {
        paramString = new JSONObject(paramString);
        extractJsonNames(paramString, "root", true);
        localSolution.hasSolution = paramString.getBoolean("hasSolution");
        localSolution.solutionCount = paramString.getInt("SolutionCount");
        paramString = paramString.getJSONArray("solutions");
        paramList = new SolutionItem[paramString.length()];
        i = 0;
        if (i >= paramString.length())
        {
          localSolution.solutions = paramList;
          paramString = localSolution;
          MCommon.Log_w("JSON Parse time : " + ((float)SystemClock.currentThreadTimeMillis() - f) / 1000.0F + " sec");
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        paramString.printStackTrace();
        paramString = "";
        continue;
        JSONObject localJSONObject = paramString.getJSONObject(i);
        paramList[i] = new SolutionItem();
        paramList[i].packNum = localJSONObject.getInt("PackNum");
        paramList[i].levelNum = localJSONObject.getInt("LevelNum");
        paramList[i].touches = localJSONObject.getInt("Touches");
        paramList[i].solution = localJSONObject.getString("Solution");
        i += 1;
        continue;
        paramString = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/utils/solutions/parsers/JSonBBSolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */