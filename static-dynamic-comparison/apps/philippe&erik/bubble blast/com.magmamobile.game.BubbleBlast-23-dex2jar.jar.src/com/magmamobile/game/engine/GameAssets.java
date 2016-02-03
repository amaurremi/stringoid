package com.magmamobile.game.engine;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public final class GameAssets
{
  public static String getText(String paramString)
  {
    try
    {
      paramString = Game.getContext().getAssets().open(paramString);
      byte[] arrayOfByte = new byte[paramString.available()];
      paramString.read(arrayOfByte);
      paramString.close();
      paramString = new String(arrayOfByte, "utf-8");
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameAssets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */