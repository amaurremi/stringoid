package com.flurry.android.monolithic.sdk.impl;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l
{
  private static final String a = l.class.getSimpleName();
  
  public static List<m> a(DataInput paramDataInput)
    throws IOException
  {
    if (46586 != paramDataInput.readUnsignedShort()) {
      throw new IOException("Unexpected data format");
    }
    return b(paramDataInput);
  }
  
  public static void a(List<m> paramList, DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeShort(46586);
    b(paramList, paramDataOutput);
    paramDataOutput.writeShort(0);
  }
  
  private static List<m> b(DataInput paramDataInput)
  {
    localArrayList = new ArrayList();
    try
    {
      for (;;)
      {
        if (1 != paramDataInput.readUnsignedShort()) {
          return localArrayList;
        }
        localArrayList.add(new m(paramDataInput));
      }
      return localArrayList;
    }
    catch (IOException paramDataInput)
    {
      ja.a(3, a, "unable to read adLog: ", paramDataInput);
    }
  }
  
  private static void b(List<m> paramList, DataOutput paramDataOutput)
  {
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (m)localIterator.next();
        try
        {
          paramDataOutput.writeShort(1);
          paramList.a(paramDataOutput);
        }
        catch (IOException paramDataOutput)
        {
          ja.a(3, a, "unable to write adLog with GUID: " + paramList.b(), paramDataOutput);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */