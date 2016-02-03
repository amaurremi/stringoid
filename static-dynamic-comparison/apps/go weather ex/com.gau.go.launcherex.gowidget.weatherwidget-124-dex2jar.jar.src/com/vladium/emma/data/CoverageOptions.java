package com.vladium.emma.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

public final class CoverageOptions
  implements Serializable
{
  private final boolean m_doSUIDCompensation;
  private final boolean m_excludeBridgeMethods;
  private final boolean m_excludeSyntheticMethods;
  
  CoverageOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.m_excludeSyntheticMethods = paramBoolean1;
    this.m_excludeBridgeMethods = paramBoolean2;
    this.m_doSUIDCompensation = paramBoolean3;
  }
  
  static CoverageOptions readExternal(DataInput paramDataInput)
    throws IOException
  {
    return new CoverageOptions(paramDataInput.readBoolean(), paramDataInput.readBoolean(), paramDataInput.readBoolean());
  }
  
  static void writeExternal(CoverageOptions paramCoverageOptions, DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeBoolean(paramCoverageOptions.m_excludeSyntheticMethods);
    paramDataOutput.writeBoolean(paramCoverageOptions.m_excludeBridgeMethods);
    paramDataOutput.writeBoolean(paramCoverageOptions.m_doSUIDCompensation);
  }
  
  public boolean doSUIDCompensation()
  {
    return this.m_doSUIDCompensation;
  }
  
  public boolean excludeBridgeMethods()
  {
    return this.m_excludeBridgeMethods;
  }
  
  public boolean excludeSyntheticMethods()
  {
    return this.m_excludeSyntheticMethods;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/CoverageOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */