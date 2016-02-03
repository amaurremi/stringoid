package com.adfonic.android.ormma;

public class ExpandProperties
{
  private static final String HEIGHT = "height";
  private static final String IS_MODAL = "isModal";
  private static final String LOCK_ORIENTATION = "lockOrientation";
  private static final String USE_CUSTOM_CLOSE = "useCustomClose";
  private static final String WIDTH = "width";
  private int height;
  private boolean isModal;
  private boolean lockOrientation;
  private boolean useCustomClose;
  private int width;
  
  public ExpandProperties() {}
  
  public ExpandProperties(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      paramString = paramString.replace("{", "").replace("}", "").split(",");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split(":");
        if (arrayOfString.length == 2) {
          setProperty(arrayOfString, arrayOfString[0].replace("\"", "").trim());
        }
        i += 1;
      }
    }
  }
  
  private boolean parseBoolean(String[] paramArrayOfString)
  {
    return Boolean.parseBoolean(paramArrayOfString[1].replace("\"", "").trim());
  }
  
  private int parseInt(String[] paramArrayOfString)
  {
    return Integer.parseInt(paramArrayOfString[1].replace("\"", "").trim());
  }
  
  private void setProperty(String[] paramArrayOfString, String paramString)
  {
    if ("width".equalsIgnoreCase(paramString)) {
      setWidth(parseInt(paramArrayOfString));
    }
    do
    {
      return;
      if ("height".equalsIgnoreCase(paramString))
      {
        setHeight(parseInt(paramArrayOfString));
        return;
      }
      if ("useCustomClose".equalsIgnoreCase(paramString))
      {
        setUseCustomClose(parseBoolean(paramArrayOfString));
        return;
      }
      if ("isModal".equalsIgnoreCase(paramString))
      {
        setModal(parseBoolean(paramArrayOfString));
        return;
      }
    } while (!"lockOrientation".equalsIgnoreCase(paramString));
    setLockOrientation(parseBoolean(paramArrayOfString));
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isLockOrientation()
  {
    return this.lockOrientation;
  }
  
  public boolean isModal()
  {
    return this.isModal;
  }
  
  public boolean isUseCustomClose()
  {
    return this.useCustomClose;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setLockOrientation(boolean paramBoolean)
  {
    this.lockOrientation = paramBoolean;
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.isModal = paramBoolean;
  }
  
  public void setUseCustomClose(boolean paramBoolean)
  {
    this.useCustomClose = paramBoolean;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public String toJson()
  {
    return "{\"width\":" + this.width + ",\"height\":" + this.height + ",\"useCustomClose\":" + this.useCustomClose + ",\"isModal\":" + this.isModal + ",\"lockOrientation\":" + this.lockOrientation + "}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/ormma/ExpandProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */