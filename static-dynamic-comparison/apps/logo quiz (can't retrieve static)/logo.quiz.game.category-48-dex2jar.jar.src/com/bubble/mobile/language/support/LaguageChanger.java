package com.bubble.mobile.language.support;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class LaguageChanger
{
  public static final String SELECTED_LANGUAGE = "SELECTED_LANGUAGE";
  private Activity activity;
  private LocaleCodes currentLanguage;
  private List<LocaleCodes> localeCodes = new ArrayList();
  
  public LaguageChanger(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.localeCodes = LanguageUtils.getLocaleCodes(paramActivity.getApplicationContext());
  }
  
  public void changeLanguage(int paramInt, boolean paramBoolean)
  {
    Object localObject = getLocaleCodeByPos(paramInt);
    Resources localResources = this.activity.getApplicationContext().getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    Configuration localConfiguration = localResources.getConfiguration();
    if (((LocaleCodes)localObject).getCountryCode() != null) {}
    for (localConfiguration.locale = new Locale(((LocaleCodes)localObject).getCode().toLowerCase(), ((LocaleCodes)localObject).getCountryCode().toUpperCase());; localConfiguration.locale = new Locale(((LocaleCodes)localObject).getCode().toLowerCase()))
    {
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      localObject = PreferenceManager.getDefaultSharedPreferences(this.activity).edit();
      ((SharedPreferences.Editor)localObject).putInt("SELECTED_LANGUAGE", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public LocaleCodes getCurrentLaguage()
  {
    int j;
    if (this.currentLanguage == null)
    {
      this.currentLanguage = ((LocaleCodes)this.localeCodes.get(0));
      j = PreferenceManager.getDefaultSharedPreferences(this.activity).getInt("SELECTED_LANGUAGE", -1);
      i = j;
      if (j <= -1) {}
    }
    try
    {
      this.currentLanguage = ((LocaleCodes)this.localeCodes.get(j));
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        Iterator localIterator;
        i = -1;
      }
    }
    if (i == -1)
    {
      str1 = Locale.getDefault().getCountry();
      str2 = Locale.getDefault().getLanguage();
      localIterator = this.localeCodes.iterator();
      while (localIterator.hasNext())
      {
        LocaleCodes localLocaleCodes = (LocaleCodes)localIterator.next();
        if ((localLocaleCodes.getCode().equals(str2.toLowerCase())) || (localLocaleCodes.getCode().equals(str1.toLowerCase()))) {
          this.currentLanguage = localLocaleCodes;
        }
      }
    }
    return this.currentLanguage;
  }
  
  public Drawable[] getLanguageImages()
  {
    Drawable[] arrayOfDrawable = new Drawable[this.localeCodes.size()];
    int i = 0;
    Iterator localIterator = this.localeCodes.iterator();
    while (localIterator.hasNext())
    {
      arrayOfDrawable[i] = ((LocaleCodes)localIterator.next()).getFlagImageRes();
      i += 1;
    }
    return arrayOfDrawable;
  }
  
  public LocaleCodes getLocaleCodeByPos(int paramInt)
  {
    return (LocaleCodes)this.localeCodes.get(paramInt);
  }
  
  public List<LocaleCodes> getLocaleCodes()
  {
    return this.localeCodes;
  }
  
  public boolean isEnglishLanguage()
  {
    return getCurrentLaguage().getCode().toUpperCase().equals("EN");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/mobile/language/support/LaguageChanger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */