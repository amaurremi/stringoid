package com.getjar.sdk.logging;

import android.content.Context;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;

class BufferingAppender
  extends AppenderBase
{
  private static volatile int _ApproximateBufferSize = 0;
  private static Object _ConfigurationLock = new Object();
  private static BufferingAppender _Instance = null;
  private static Object _InstanceLock = new Object();
  private static ConcurrentLinkedQueue<LogMessage> _LogBuffer;
  private static final int _MaxBufferSize = 1024;
  
  static
  {
    _ApproximateBufferSize = 0;
    _LogBuffer = new ConcurrentLinkedQueue();
  }
  
  private BufferingAppender()
  {
    super(false, 2, Area.ALL.value());
  }
  
  protected static BufferingAppender getInstance()
  {
    if (_Instance == null) {}
    synchronized (_InstanceLock)
    {
      if (_Instance == null) {
        _Instance = new BufferingAppender();
      }
      return _Instance;
    }
  }
  
  public static Collection<LogMessage> getLogBuffer()
  {
    return Collections.unmodifiableCollection(_LogBuffer);
  }
  
  public void configureAppender(Context arg1)
  {
    logInternal(2, "BufferingAppender: configureAppender() START");
    synchronized (_ConfigurationLock)
    {
      logInternal(2, "BufferingAppender: configureAppender() FINISHED");
      return;
    }
  }
  
  public void log(LogMessage paramLogMessage)
  {
    if (paramLogMessage == null) {
      throw new IllegalArgumentException("'logMessage' cannot be NULL");
    }
    if ((isLevelActive(paramLogMessage.getLevel())) && (isAreaActive(paramLogMessage.getAreas())))
    {
      _LogBuffer.add(paramLogMessage);
      for (_ApproximateBufferSize += 1; _ApproximateBufferSize > 1024; _ApproximateBufferSize -= 1) {
        _LogBuffer.remove();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/logging/BufferingAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */