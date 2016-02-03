package com.magmamobile.game.engine;

public final class BackgroundMusic
{
  private static int current = -1;
  private static boolean playing = false;
  private static float volume = 2.0F;
  
  public static Music getMusic()
  {
    if (current >= 0) {
      return Game.getMusic(current);
    }
    return null;
  }
  
  public static float getVolume()
  {
    return volume;
  }
  
  public static void pause()
  {
    if (current != -1) {
      Game.getMusic(current).pause();
    }
  }
  
  public static void play()
  {
    play(current);
  }
  
  public static void play(int paramInt)
  {
    Music localMusic1;
    if (paramInt != -1)
    {
      localMusic1 = Game.getMusic(paramInt);
      if (localMusic1 != null) {
        break label15;
      }
    }
    label15:
    int i;
    do
    {
      return;
      i = current;
      current = paramInt;
    } while ((current == paramInt) && (localMusic1.isPlaying()));
    if (i != -1)
    {
      Music localMusic2 = Game.getMusic(i);
      if (localMusic2 != null) {
        localMusic2.stop();
      }
    }
    playing = true;
    localMusic1.setVolume(volume);
    localMusic1.play();
  }
  
  protected static void reset()
  {
    current = -1;
    playing = false;
  }
  
  public static void resume()
  {
    if (current != -1)
    {
      if (playing) {
        Game.getMusic(current).resume();
      }
    }
    else {
      return;
    }
    Game.getMusic(current).play();
  }
  
  public static void setvolume(float paramFloat)
  {
    volume = paramFloat;
    Music localMusic = getMusic();
    if (localMusic != null) {
      localMusic.setVolume(paramFloat);
    }
  }
  
  public static void stop()
  {
    if (current != -1)
    {
      Game.getMusic(current).stop();
      playing = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/BackgroundMusic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */