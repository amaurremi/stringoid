package com.vladium.emma.report;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;
import com.vladium.util.IProperties;

public abstract interface IReportGenerator
{
  public abstract void cleanup();
  
  public abstract String getType();
  
  public abstract void process(IMetaData paramIMetaData, ICoverageData paramICoverageData, SourcePathCache paramSourcePathCache, IProperties paramIProperties)
    throws EMMARuntimeException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/IReportGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */