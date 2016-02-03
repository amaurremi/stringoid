package com.venticake.retrica.view.album;

public final class StringTexture$Config
{
  public static final int ALIGN_BOTTOM = 4;
  public static final int ALIGN_HCENTER = 0;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  public static final int ALIGN_TOP = 3;
  public static final int ALIGN_VCENTER = 5;
  public static final Config DEFAULT_CONFIG_SCALED = new Config();
  public static final Config DEFAULT_CONFIG_TRUNCATED = new Config(1);
  private static final int FADE_WIDTH = 30;
  public static final int OVERFLOW_CLIP = 0;
  public static final int OVERFLOW_ELLIPSIZE = 1;
  public static final int OVERFLOW_FADE = 2;
  public static final int SIZE_BOUNDS_TO_TEXT = 2;
  public static final int SIZE_EXACT = 0;
  public static final int SIZE_TEXT_TO_BOUNDS = 1;
  public float a = 1.0F;
  public float b = 1.0F;
  public boolean bold = false;
  public float fontSize = 20.0F;
  public float g = 1.0F;
  public int height = 32;
  public boolean italic = false;
  public int overflowMode = 2;
  public float r = 1.0F;
  public int shadowRadius = (int)Gallery.PIXEL_DENSITY * 4;
  public int sizeMode = 2;
  public boolean strikeThrough = false;
  public boolean underline = false;
  public int width = 256;
  public int xalignment = 1;
  public int yalignment = 5;
  
  public StringTexture$Config() {}
  
  public StringTexture$Config(float paramFloat, int paramInt1, int paramInt2)
  {
    this.fontSize = paramFloat;
    this.width = paramInt1;
    this.height = paramInt2;
    this.sizeMode = 0;
  }
  
  public StringTexture$Config(int paramInt)
  {
    this.sizeMode = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/StringTexture$Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */