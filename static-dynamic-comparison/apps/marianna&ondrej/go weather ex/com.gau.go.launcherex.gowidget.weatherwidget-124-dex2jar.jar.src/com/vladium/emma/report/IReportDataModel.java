package com.vladium.emma.report;

import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;

public abstract interface IReportDataModel
{
  public abstract IReportDataView getView(int paramInt);
  
  public static abstract class Factory
  {
    public static IReportDataModel create(IMetaData paramIMetaData, ICoverageData paramICoverageData)
    {
      return new ReportDataModel(paramIMetaData, paramICoverageData);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/IReportDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */