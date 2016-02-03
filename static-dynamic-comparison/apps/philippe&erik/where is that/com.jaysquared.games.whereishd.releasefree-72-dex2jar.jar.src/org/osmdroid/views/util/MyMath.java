package org.osmdroid.views.util;

public class MyMath
{
  public static int getNextSquareNumberAbove(float paramFloat)
  {
    int k = 0;
    int j = 1;
    int i = 1;
    for (;;)
    {
      if (j > paramFloat) {
        return k;
      }
      k = i;
      j *= 2;
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/util/MyMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */