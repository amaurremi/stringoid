package com.magmamobile.game.engine;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEx
  extends DataOutputStream
{
  public OutputStreamEx(File paramFile)
    throws FileNotFoundException
  {
    super(new FileOutputStream(paramFile));
  }
  
  public OutputStreamEx(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public final void writeLString(String paramString)
    throws IOException
  {
    if (paramString == null)
    {
      writeShort(0);
      return;
    }
    paramString = paramString.getBytes();
    writeShort(paramString.length);
    write(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/OutputStreamEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */