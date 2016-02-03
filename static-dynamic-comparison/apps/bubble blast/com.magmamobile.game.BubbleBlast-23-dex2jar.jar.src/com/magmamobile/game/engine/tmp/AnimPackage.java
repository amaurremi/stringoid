package com.magmamobile.game.engine.tmp;

import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GamePak;
import com.magmamobile.game.engine.InputStreamEx;
import java.io.IOException;

public final class AnimPackage
{
  public AnimBag[] bags;
  
  public static final AnimPackage loadFromRes(int paramInt)
  {
    for (;;)
    {
      int k;
      int i;
      try
      {
        AnimPackage localAnimPackage = new AnimPackage();
        localInputStreamEx = GamePak.getStreamEx(paramInt);
        int j = localInputStreamEx.readInt();
        localAnimPackage.bags = new AnimBag[j];
        paramInt = 0;
        if (paramInt >= j)
        {
          localInputStreamEx.close();
          return localAnimPackage;
        }
        localAnimBag = new AnimBag();
        localAnimPackage.bags[paramInt] = localAnimBag;
        localAnimBag.name = localInputStreamEx.readLString();
        k = localInputStreamEx.readInt();
        localAnimBag.frames = new AnimFrame[k];
        i = 0;
      }
      catch (IOException localIOException)
      {
        InputStreamEx localInputStreamEx;
        AnimBag localAnimBag;
        AnimFrame localAnimFrame;
        localIOException.printStackTrace();
        return null;
      }
      localAnimFrame = new AnimFrame();
      localAnimBag.frames[i] = localAnimFrame;
      localAnimFrame.time = localInputStreamEx.readInt();
      localAnimFrame.image = Game.createBitmap(localInputStreamEx.readBytes(localInputStreamEx.readInt()));
      i += 1;
      if (i >= k) {
        paramInt += 1;
      }
    }
  }
  
  public AnimBag get(int paramInt)
  {
    return this.bags[paramInt];
  }
  
  public int getIndexOf(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.bags.length) {
        throw new RuntimeException(paramString);
      }
      if (paramString.equals(this.bags[i].name)) {
        return i;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/AnimPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */