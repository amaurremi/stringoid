package com.flurry.org.codehaus.jackson.io;

import com.flurry.org.codehaus.jackson.SerializableString;
import com.flurry.org.codehaus.jackson.util.CharTypes;

public abstract class CharacterEscapes
{
  public static final int ESCAPE_CUSTOM = -2;
  public static final int ESCAPE_NONE = 0;
  public static final int ESCAPE_STANDARD = -1;
  
  public static int[] standardAsciiEscapesForJSON()
  {
    int[] arrayOfInt1 = CharTypes.get7BitOutputEscapes();
    int[] arrayOfInt2 = new int[arrayOfInt1.length];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
    return arrayOfInt2;
  }
  
  public abstract int[] getEscapeCodesForAscii();
  
  public abstract SerializableString getEscapeSequence(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/io/CharacterEscapes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */