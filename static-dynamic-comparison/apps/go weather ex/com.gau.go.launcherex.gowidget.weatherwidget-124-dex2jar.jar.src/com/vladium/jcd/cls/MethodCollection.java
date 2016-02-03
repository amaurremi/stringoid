package com.vladium.jcd.cls;

import com.vladium.jcd.lib.UDataOutputStream;
import com.vladium.util.IntVector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class MethodCollection
  implements IMethodCollection
{
  private List m_methods;
  
  MethodCollection(int paramInt)
  {
    if (paramInt < 0) {}
    for (ArrayList localArrayList = new ArrayList();; localArrayList = new ArrayList(paramInt))
    {
      this.m_methods = localArrayList;
      return;
    }
  }
  
  public void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject)
  {
    paramIClassDefVisitor.visit(this, paramObject);
  }
  
  public int add(Method_info paramMethod_info)
  {
    int i = this.m_methods.size();
    this.m_methods.add(paramMethod_info);
    return i;
  }
  
  public Object clone()
  {
    try
    {
      MethodCollection localMethodCollection = (MethodCollection)super.clone();
      int j = this.m_methods.size();
      localMethodCollection.m_methods = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localMethodCollection.m_methods.add(((Method_info)this.m_methods.get(i)).clone());
        i += 1;
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public Method_info get(int paramInt)
  {
    return (Method_info)this.m_methods.get(paramInt);
  }
  
  public int[] get(ClassDef paramClassDef, String paramString)
  {
    if (paramClassDef == null) {
      throw new IllegalArgumentException("null input: cls");
    }
    int j = this.m_methods.size();
    IntVector localIntVector = new IntVector(j);
    int i = 0;
    while (i < j)
    {
      if (((Method_info)this.m_methods.get(i)).getName(paramClassDef).equals(paramString)) {
        localIntVector.add(i);
      }
      i += 1;
    }
    return localIntVector.values();
  }
  
  public Method_info remove(int paramInt)
  {
    return (Method_info)this.m_methods.remove(paramInt);
  }
  
  public Method_info set(int paramInt, Method_info paramMethod_info)
  {
    return (Method_info)this.m_methods.set(paramInt, paramMethod_info);
  }
  
  public int size()
  {
    return this.m_methods.size();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    int j = this.m_methods.size();
    paramUDataOutputStream.writeU2(j);
    int i = 0;
    while (i < j)
    {
      get(i).writeInClassFormat(paramUDataOutputStream);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/MethodCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */