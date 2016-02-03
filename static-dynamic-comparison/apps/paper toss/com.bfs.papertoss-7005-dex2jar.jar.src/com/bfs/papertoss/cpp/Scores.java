package com.bfs.papertoss.cpp;

import com.bfs.papertoss.platform.SaveData;

public class Scores
{
  public static void init() {}
  
  private static String keyForLevel(int paramInt)
  {
    return "level_" + paramInt + "_best";
  }
  
  private static String oldStyleKey(int paramInt)
  {
    return "level_" + paramInt;
  }
  
  public static int readBest(int paramInt)
  {
    return SaveData.obfuscatedRead(0, keyForLevel(paramInt));
  }
  
  public static int readSubmitted(int paramInt)
  {
    return SaveData.read(0, oldStyleKey(paramInt), "submitted");
  }
  
  public static void saveBest(int paramInt1, int paramInt2)
  {
    SaveData.obfuscatedWrite(paramInt1, keyForLevel(paramInt2));
    SaveData.save();
  }
  
  public static void saveSubmitted(int paramInt1, int paramInt2)
  {
    SaveData.write(Integer.valueOf(paramInt1), oldStyleKey(paramInt2), "submitted");
    SaveData.save();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/Scores.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */