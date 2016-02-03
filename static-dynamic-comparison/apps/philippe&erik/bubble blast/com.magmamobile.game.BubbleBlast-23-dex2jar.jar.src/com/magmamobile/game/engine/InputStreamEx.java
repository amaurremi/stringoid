package com.magmamobile.game.engine;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx
  extends DataInputStream
{
  public InputStreamEx(File paramFile)
    throws FileNotFoundException
  {
    super(new FileInputStream(paramFile));
  }
  
  public InputStreamEx(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public InputStreamEx(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    super(paramInputStream);
    skip(paramInt);
  }
  
  public final byte[] readBytes(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    read(arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  public final int[] readInt(int paramInt)
    throws IOException
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return arrayOfInt;
      }
      arrayOfInt[i] = readInt();
      i += 1;
    }
  }
  
  public final String readLString()
    throws IOException
  {
    int i = readShort();
    if (i == 0) {
      return "";
    }
    byte[] arrayOfByte = new byte[i];
    read(arrayOfByte, 0, i);
    return new String(arrayOfByte);
  }
  
  public final String readString(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    read(arrayOfByte, 0, paramInt);
    return new String(arrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/InputStreamEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */