package com.vladium.emma.data;

import java.io.Serializable;

public final class SessionData
  implements ISessionData, Serializable
{
  private final ICoverageData m_cdata;
  private final IMetaData m_mdata;
  
  public SessionData(IMetaData paramIMetaData, ICoverageData paramICoverageData)
  {
    if (paramIMetaData == null) {
      throw new IllegalArgumentException("null input: mdata");
    }
    if (paramICoverageData == null) {
      throw new IllegalArgumentException("null input: cdata");
    }
    this.m_mdata = paramIMetaData;
    this.m_cdata = paramICoverageData;
  }
  
  public ICoverageData getCoverageData()
  {
    return this.m_cdata;
  }
  
  public IMetaData getMetaData()
  {
    return this.m_mdata;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/SessionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */