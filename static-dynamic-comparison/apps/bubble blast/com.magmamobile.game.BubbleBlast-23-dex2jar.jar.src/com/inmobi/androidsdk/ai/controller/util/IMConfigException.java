package com.inmobi.androidsdk.ai.controller.util;

public final class IMConfigException
  extends Exception
{
  public static final int MISSING_ACTIVITY_DECLARATION = -2;
  public static final int MISSING_CONFIG_CHANGES = -3;
  public static final int MISSING_CONFIG_KEYBOARD = -4;
  public static final int MISSING_CONFIG_KEYBOARDHIDDEN = -5;
  public static final int MISSING_CONFIG_ORIENTATION = -6;
  public static final int MISSING_CONFIG_SCREENSIZE = -7;
  public static final int MISSING_CONFIG_SMALLEST_SCREENSIZE = -8;
  public static final int MISSING_PERMISSION = -1;
  private static final long serialVersionUID = 1L;
  private int a;
  
  IMConfigException(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getExceptionCode()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("IMConfigException : ");
    switch (this.a)
    {
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
      continue;
      localStringBuffer.append("IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
      continue;
      localStringBuffer.append("App does not have INTERNET permissions. Please provide INTERNET permissions");
      continue;
      localStringBuffer.append("Missing Config keyboard from android:configChangesof IMBRowserActivity");
      continue;
      localStringBuffer.append("Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
      continue;
      localStringBuffer.append("Missing Config orientation from android:configChangesof IMBRowserActivity");
      continue;
      localStringBuffer.append("Missing Config screenSize from android:configChangesof IMBRowserActivity");
      continue;
      localStringBuffer.append("Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/util/IMConfigException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */