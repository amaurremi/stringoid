package com.google.gson.internal;

class Streams$AppendableWriter$CurrentWrite
  implements CharSequence
{
  char[] chars;
  
  public char charAt(int paramInt)
  {
    return this.chars[paramInt];
  }
  
  public int length()
  {
    return this.chars.length;
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new String(this.chars, paramInt1, paramInt2 - paramInt1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/Streams$AppendableWriter$CurrentWrite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */