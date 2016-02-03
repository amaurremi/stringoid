package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class ExceptionHandlerTable
  implements IExceptionHandlerTable
{
  private List m_exceptions;
  
  ExceptionHandlerTable(int paramInt)
  {
    if (paramInt < 0) {}
    for (ArrayList localArrayList = new ArrayList();; localArrayList = new ArrayList(paramInt))
    {
      this.m_exceptions = localArrayList;
      return;
    }
  }
  
  public int add(Exception_info paramException_info)
  {
    int i = this.m_exceptions.size();
    this.m_exceptions.add(paramException_info);
    return i;
  }
  
  public Object clone()
  {
    try
    {
      ExceptionHandlerTable localExceptionHandlerTable = (ExceptionHandlerTable)super.clone();
      int j = this.m_exceptions.size();
      localExceptionHandlerTable.m_exceptions = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localExceptionHandlerTable.m_exceptions.add(((Exception_info)this.m_exceptions.get(i)).clone());
        i += 1;
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public Exception_info get(int paramInt)
  {
    return (Exception_info)this.m_exceptions.get(paramInt);
  }
  
  public long length()
  {
    return (this.m_exceptions.size() << 3) + 2;
  }
  
  public Exception_info set(int paramInt, Exception_info paramException_info)
  {
    return (Exception_info)this.m_exceptions.set(paramInt, paramException_info);
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
      get(i).writeInClassFormat(paramUDataOutputStream);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/ExceptionHandlerTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */