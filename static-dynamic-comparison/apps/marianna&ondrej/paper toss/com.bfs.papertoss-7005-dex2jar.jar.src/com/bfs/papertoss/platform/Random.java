package com.bfs.papertoss.platform;

import java.io.PrintStream;

public class Random
{
  public static void main(String[] paramArrayOfString)
  {
    for (;;)
    {
      System.out.println(randomf(1.0F, 2.0F));
    }
  }
  
  public static float randomf(float paramFloat1, float paramFloat2)
  {
    return (float)(Math.random() * (paramFloat2 - paramFloat1) + paramFloat1);
  }
  
  public static int randomi(int paramInt1, int paramInt2)
  {
    return (int)(Math.random() * 2.147483647E9D) % (paramInt2 - paramInt1 + 1) + paramInt1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/platform/Random.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */