package com.vladium.emma.data;

import com.vladium.util.IConstants;
import com.vladium.util.IntObjectMap;
import com.vladium.util.IntSet;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

public final class MethodDescriptor
  implements IConstants, IMetadataConstants, Serializable
{
  private final int[][] m_blockMap;
  private final int[] m_blockSizes;
  private final String m_descriptor;
  private final int m_firstLine;
  private IntObjectMap m_lineMap;
  private final String m_name;
  private final int m_status;
  
  public MethodDescriptor(String paramString1, String paramString2, int paramInt1, int[] paramArrayOfInt, int[][] paramArrayOfInt1, int paramInt2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("null input: name");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("null input: descriptor");
    }
    if ((paramInt1 & 0xE) == 0)
    {
      int i = paramArrayOfInt.length;
      this.m_blockSizes = paramArrayOfInt;
      if ((paramInt1 & 0xF) == 0)
      {
        if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length == 0)) {
          throw new IllegalArgumentException("null or empty input: blockMap");
        }
        this.m_blockMap = paramArrayOfInt1;
        this.m_firstLine = paramInt2;
      }
    }
    for (;;)
    {
      this.m_name = paramString1;
      this.m_descriptor = paramString2;
      this.m_status = paramInt1;
      return;
      this.m_blockMap = ((int[][])null);
      this.m_firstLine = 0;
      continue;
      this.m_blockSizes = null;
      this.m_blockMap = ((int[][])null);
      this.m_firstLine = 0;
    }
  }
  
  static MethodDescriptor readExternal(DataInput paramDataInput)
    throws IOException
  {
    String str1 = paramDataInput.readUTF();
    String str2 = paramDataInput.readUTF();
    int k = paramDataInput.readInt();
    Object localObject = null;
    int[][] arrayOfInt2 = (int[][])null;
    int j = 0;
    int[][] arrayOfInt1 = arrayOfInt2;
    int i = j;
    if ((k & 0xE) == 0)
    {
      int[] arrayOfInt = DataFactory.readIntArray(paramDataInput);
      localObject = arrayOfInt;
      arrayOfInt1 = arrayOfInt2;
      i = j;
      if ((k & 0xF) == 0)
      {
        j = paramDataInput.readInt();
        arrayOfInt1 = new int[j][];
        i = 0;
        while (i < j)
        {
          arrayOfInt1[i] = DataFactory.readIntArray(paramDataInput);
          i += 1;
        }
        i = paramDataInput.readInt();
        localObject = arrayOfInt;
      }
    }
    return new MethodDescriptor(str1, str2, k, (int[])localObject, arrayOfInt1, i);
  }
  
  static void writeExternal(MethodDescriptor paramMethodDescriptor, DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeUTF(paramMethodDescriptor.m_name);
    paramDataOutput.writeUTF(paramMethodDescriptor.m_descriptor);
    int i = paramMethodDescriptor.m_status;
    paramDataOutput.writeInt(i);
    if ((i & 0xE) == 0)
    {
      DataFactory.writeIntArray(paramMethodDescriptor.m_blockSizes, paramDataOutput);
      if ((i & 0xF) == 0)
      {
        int[][] arrayOfInt = paramMethodDescriptor.m_blockMap;
        int j = arrayOfInt.length;
        paramDataOutput.writeInt(j);
        i = 0;
        while (i < j)
        {
          DataFactory.writeIntArray(arrayOfInt[i], paramDataOutput);
          i += 1;
        }
        paramDataOutput.writeInt(paramMethodDescriptor.m_firstLine);
      }
    }
  }
  
  public int getBlockCount()
  {
    return this.m_blockSizes.length;
  }
  
  public int[][] getBlockMap()
  {
    return this.m_blockMap;
  }
  
  public int[] getBlockSizes()
  {
    return this.m_blockSizes;
  }
  
  public String getDescriptor()
  {
    return this.m_descriptor;
  }
  
  public int getFirstLine()
  {
    return this.m_firstLine;
  }
  
  public IntObjectMap getLineMap()
  {
    Object localObject = this.m_lineMap;
    if (localObject != null) {
      return (IntObjectMap)localObject;
    }
    if ((this.m_status & 0xF) == 0)
    {
      IntObjectMap localIntObjectMap = new IntObjectMap();
      int[][] arrayOfInt = this.m_blockMap;
      int i = 0;
      int k = arrayOfInt.length;
      while (i < k)
      {
        int[] arrayOfInt1 = arrayOfInt[i];
        if (arrayOfInt1 != null)
        {
          int m = arrayOfInt1.length;
          j = 0;
          while (j < m)
          {
            int n = arrayOfInt1[j];
            IntSet localIntSet = (IntSet)localIntObjectMap.get(n);
            localObject = localIntSet;
            if (localIntSet == null)
            {
              localObject = new IntSet();
              localIntObjectMap.put(n, localObject);
            }
            ((IntSet)localObject).add(i);
            j += 1;
          }
        }
        i += 1;
      }
      localObject = localIntObjectMap.keys();
      i = 0;
      int j = localObject.length;
      while (i < j)
      {
        k = localObject[i];
        localIntObjectMap.put(k, ((IntSet)localIntObjectMap.get(k)).values());
        i += 1;
      }
      this.m_lineMap = localIntObjectMap;
      return localIntObjectMap;
    }
    return null;
  }
  
  public String getName()
  {
    return this.m_name;
  }
  
  public int getStatus()
  {
    return this.m_status;
  }
  
  public boolean hasLineNumberInfo()
  {
    return (this.m_status & 0xF) == 0;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  public String toString(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString + "method [" + this.m_name + "] descriptor:");
    if ((this.m_status & 0xF) == 0)
    {
      int i = 0;
      int j;
      while (i < this.m_blockMap.length)
      {
        localStringBuffer.append(EOL);
        localStringBuffer.append(paramString + "  " + "block " + i + " (" + this.m_blockSizes[i] + " instrs) : ");
        arrayOfInt1 = this.m_blockMap[i];
        j = 0;
        while (j < arrayOfInt1.length)
        {
          if (j != 0) {
            localStringBuffer.append(", ");
          }
          localStringBuffer.append(arrayOfInt1[j]);
          j += 1;
        }
        i += 1;
      }
      localStringBuffer.append(EOL);
      localStringBuffer.append(paramString + "  " + "---");
      int[] arrayOfInt1 = this.m_lineMap.keys();
      i = 0;
      while (i < arrayOfInt1.length)
      {
        localStringBuffer.append(EOL);
        localStringBuffer.append(paramString + "  " + "line " + arrayOfInt1[i] + ": ");
        int[] arrayOfInt2 = (int[])this.m_lineMap.get(arrayOfInt1[i]);
        j = 0;
        while (j < arrayOfInt2.length)
        {
          if (j != 0) {
            localStringBuffer.append(", ");
          }
          localStringBuffer.append(arrayOfInt2[j]);
          j += 1;
        }
        i += 1;
      }
    }
    localStringBuffer.append(" <no line info>");
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/MethodDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */