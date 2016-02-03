package com.vladium.emma.report;

public abstract interface IReportDataView
{
  public static final int HIER_CLS_VIEW = 0;
  public static final int HIER_SRC_VIEW = 1;
  
  public abstract IItem getRoot();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/IReportDataView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */