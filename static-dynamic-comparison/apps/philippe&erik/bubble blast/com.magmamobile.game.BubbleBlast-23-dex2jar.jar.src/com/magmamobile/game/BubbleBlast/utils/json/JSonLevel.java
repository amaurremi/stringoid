package com.magmamobile.game.BubbleBlast.utils.json;

import android.os.SystemClock;
import com.magmamobile.game.BubbleBlast.engine.levels.LevelInfo;
import com.magmamobile.game.BubbleBlast.modCommon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonLevel
  extends JSonParser
{
  public static LevelInfo[] loadItems(int paramInt)
    throws JSONException
  {
    float f = (float)SystemClock.currentThreadTimeMillis();
    LevelInfo[] arrayOfLevelInfo = null;
    JSONArray localJSONArray;
    int i;
    try
    {
      Object localObject = getJSonLocalFile(paramInt);
      if (!((String)localObject).equals(""))
      {
        localObject = new JSONObject((String)localObject);
        extractJsonNames((JSONObject)localObject, "root", true);
        localObject = ((JSONObject)localObject).getJSONArray("levels");
        arrayOfLevelInfo = new LevelInfo[((JSONArray)localObject).length()];
        paramInt = 0;
        if (paramInt < ((JSONArray)localObject).length()) {}
      }
      else
      {
        modCommon.Log_w("JSON Parse time : " + ((float)SystemClock.currentThreadTimeMillis() - f) / 1000.0F + " sec");
        return arrayOfLevelInfo;
      }
    }
    catch (Exception localException)
    {
      String str;
      for (;;)
      {
        localException.printStackTrace();
        str = "";
      }
      JSONObject localJSONObject = str.getJSONObject(paramInt);
      localJSONArray = localJSONObject.getJSONArray("items");
      arrayOfLevelInfo[paramInt] = new LevelInfo();
      arrayOfLevelInfo[paramInt].toucheMax = localJSONObject.getInt("touchmax");
      arrayOfLevelInfo[paramInt].items = new int[localJSONArray.length()];
      i = 0;
    }
    for (;;)
    {
      if (i >= localJSONArray.length())
      {
        paramInt += 1;
        break;
      }
      arrayOfLevelInfo[paramInt].items[i] = Integer.valueOf(localJSONArray.getInt(i)).intValue();
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/utils/json/JSonLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */