package com.magmamobile.game.engine;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public final class Debug
{
  public static final boolean DEBUG_ACTIVITY = false;
  public static final boolean DEBUG_ADS = false;
  public static final boolean DEBUG_APPLICATION = false;
  public static final boolean DEBUG_ATLASMANAGER = false;
  public static final boolean DEBUG_ENGINE = false;
  public static final boolean DEBUG_LAYER = false;
  public static final boolean DEBUG_LAYERMANAGER = false;
  public static final boolean DEBUG_MORE_STACK = false;
  public static final boolean DEBUG_MUSIC = false;
  public static final boolean DEBUG_NODE = false;
  public static final boolean DEBUG_RENDERER = false;
  public static final boolean DEBUG_REPORT = false;
  public static final boolean DEBUG_SENSOR = false;
  public static final boolean DEBUG_SOUND = false;
  public static final boolean DEBUG_SURFACE = false;
  public static final boolean DEBUG_TEXT = false;
  public static final boolean DEBUG_TRACKER = false;
  private static final String LOG_NAME = "-= Engine =-";
  public static Paint focusRect;
  public static Paint labelPaint = new Paint();
  
  static
  {
    labelPaint.setColor(-16776961);
    labelPaint.setStyle(Paint.Style.STROKE);
    labelPaint.setStrokeWidth(1.0F);
    focusRect = new Paint();
    focusRect.setColor(-2130771713);
  }
  
  public static final void d(String paramString)
  {
    Log.d("-= Engine =-", getInfo() + paramString);
  }
  
  public static final void e(String paramString)
  {
    Log.e("-= Engine =-", getInfo() + paramString);
  }
  
  private static final String getInfo()
  {
    StackTraceElement localStackTraceElement = Thread.currentThread().getStackTrace()[4];
    String str = localStackTraceElement.getFileName();
    if (str == null) {
      return "";
    }
    return "[" + str + ":" + localStackTraceElement.getLineNumber() + "] ";
  }
  
  public static final void i(String paramString)
  {
    Log.i("-= Engine =-", getInfo() + paramString);
  }
  
  public static final void v(String paramString)
  {
    Log.v("-= Engine =-", getInfo() + paramString);
  }
  
  public static final void w(String paramString)
  {
    Log.w("-= Engine =-", getInfo() + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Debug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */