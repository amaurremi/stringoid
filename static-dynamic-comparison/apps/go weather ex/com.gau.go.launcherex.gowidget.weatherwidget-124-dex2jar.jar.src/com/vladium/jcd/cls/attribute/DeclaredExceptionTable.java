package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.lib.UDataOutputStream;
import com.vladium.util.IntVector;
import java.io.IOException;

final class DeclaredExceptionTable
  implements IDeclaredExceptionTable
{
  private IntVector m_exceptions;
  
  DeclaredExceptionTable(int paramInt)
  {
    if (paramInt < 0) {}
    for (IntVector localIntVector = new IntVector();; localIntVector = new IntVector(paramInt))
    {
      this.m_exceptions = localIntVector;
      return;
    }
  }
  
  public int add(int paramInt)
  {
    int i = this.m_exceptions.size();
    this.m_exceptions.add(paramInt);
    return i;
  }
  
  public Object clone()
  {
    try
    {
      DeclaredExceptionTable localDeclaredExceptionTable = (DeclaredExceptionTable)super.clone();
      localDeclaredExceptionTable.m_exceptions = ((IntVector)this.m_exceptions.clone());
      return localDeclaredExceptionTable;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public int get(int paramInt)
  {
    return this.m_exceptions.get(paramInt);
  }
  
  public long length()
  {
    return this.m_exceptions.size() + 1 << 1;
  }
  
  public int set(int paramInt1, int paramInt2)
  {
    return this.m_exceptions.set(paramInt1, paramInt2);
  }
  
  public int size()
  {
    return this.m_exceptions.size();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    int j = this.m_exceptions.size();
    paramUDataOutputStream.writeU2(j);
    int i = 0;
    while (i < j)
    {
      paramUDataOutputStream.writeU2(get(i));
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/DeclaredExceptionTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */