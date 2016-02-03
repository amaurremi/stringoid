package com.jiubang.core.util;

import com.gtp.a.a.b.c;

final class ErrorReporter$ReportsSenderWorker
  extends Thread
{
  private String mBody = null;
  private String mReportFileName = null;
  
  ErrorReporter$ReportsSenderWorker(ErrorReporter paramErrorReporter) {}
  
  public void run()
  {
    try
    {
      ErrorReporter.access$100(this.this$0, ErrorReporter.access$000(this.this$0), this.mReportFileName, this.mBody);
      return;
    }
    catch (Exception localException)
    {
      c.b("ACRA", "", this);
    }
  }
  
  void setCommentReportFileName(String paramString)
  {
    this.mReportFileName = paramString;
  }
  
  void setCustomComment(String paramString)
  {
    this.mBody = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/ErrorReporter$ReportsSenderWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */