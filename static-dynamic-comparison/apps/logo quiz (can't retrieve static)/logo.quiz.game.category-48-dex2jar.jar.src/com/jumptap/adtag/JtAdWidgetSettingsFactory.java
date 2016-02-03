package com.jumptap.adtag;

public class JtAdWidgetSettingsFactory
{
  private static JtAdWidgetSettings widgetSettings = null;
  
  public static JtAdWidgetSettings createWidgetSettings()
  {
    if (widgetSettings == null)
    {
      widgetSettings = new JtAdWidgetSettings();
      return widgetSettings;
    }
    return widgetSettings.copy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/JtAdWidgetSettingsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */