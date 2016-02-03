package a;

import java.util.Date;

public class c
{
  public static long a(Date paramDate)
  {
    if (paramDate == null) {
      return 0L;
    }
    return (System.currentTimeMillis() - paramDate.getTime()) / 1000L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */