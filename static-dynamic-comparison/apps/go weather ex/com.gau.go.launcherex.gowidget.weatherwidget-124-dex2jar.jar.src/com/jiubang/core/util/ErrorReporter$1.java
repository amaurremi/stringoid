package com.jiubang.core.util;

import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

class ErrorReporter$1
  extends Thread
{
  ErrorReporter$1(ErrorReporter paramErrorReporter) {}
  
  public void run()
  {
    Looper.prepare();
    Toast.makeText(ErrorReporter.access$000(this.this$0), ErrorReporter.access$200(this.this$0).getInt("RES_TOAST_TEXT"), 1).show();
    Looper.loop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/ErrorReporter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */