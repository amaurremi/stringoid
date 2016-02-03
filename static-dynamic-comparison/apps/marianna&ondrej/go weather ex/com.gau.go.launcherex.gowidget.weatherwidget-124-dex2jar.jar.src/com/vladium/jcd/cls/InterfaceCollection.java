package com.vladium.jcd.cls;

import com.vladium.jcd.lib.UDataOutputStream;
import com.vladium.util.IntVector;
import java.io.IOException;

final class InterfaceCollection
  implements IInterfaceCollection
{
  private IntVector m_interfaces;
  
  InterfaceCollection(int paramInt)
  {
    if (paramInt < 0) {}
    for (IntVector localIntVector = new IntVector();; localIntVector = new IntVector(paramInt))
    {
      this.m_interfaces = localIntVector;
      return;
    }
  }
  
  public void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject)
  {
    paramIClassDefVisitor.visit(this, paramObject);
  }
  
  public int add(int paramInt)
  {
    int i = this.m_interfaces.size();
    this.m_interfaces.add(paramInt);
    return i;
  }
  
  public Object clone()
  {
    try
    {
      InterfaceCollection localInterfaceCollection = (InterfaceCollection)super.clone();
      localInterfaceCollection.m_interfaces = ((IntVector)this.m_interfaces.clone());
      return localInterfaceCollection;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public int get(int paramInt)
  {
    return this.m_interfaces.get(paramInt);
  }
  
  public int set(int paramInt1, int paramInt2)
  {
    return this.m_interfaces.set(paramInt1, paramInt2);
  }
  
  public int size()
  {
    return this.m_interfaces.size();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    int j = this.m_interfaces.size();
    paramUDataOutputStream.writeU2(j);
    int i = 0;
    while (i < j)
    {
      paramUDataOutputStream.writeU2(get(i));
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/InterfaceCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */