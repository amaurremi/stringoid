package com.jiubang.core.util;

import java.io.File;
import java.io.FilenameFilter;

class ErrorReporter$2
  implements FilenameFilter
{
  ErrorReporter$2(ErrorReporter paramErrorReporter) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith("_stk.txt");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/ErrorReporter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */