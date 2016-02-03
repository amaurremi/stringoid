package com.pocket.tts;

import android.speech.tts.TextToSpeech;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public abstract class e
{
  private static final Object a = new Object();
  private static final Comparator b = new Comparator()
  {
    public int a(Locale paramAnonymousLocale1, Locale paramAnonymousLocale2)
    {
      return paramAnonymousLocale1.getDisplayName().compareTo(paramAnonymousLocale2.getDisplayName());
    }
  };
  
  private static int a(TextToSpeech paramTextToSpeech, Locale paramLocale)
  {
    try
    {
      int i = paramTextToSpeech.isLanguageAvailable(paramLocale);
      return i;
    }
    catch (Throwable paramTextToSpeech)
    {
      com.ideashower.readitlater.util.e.a(paramTextToSpeech);
    }
    return -2;
  }
  
  public static ArrayList a(TextToSpeech paramTextToSpeech)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = Locale.getAvailableLocales();
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      Object localObject3 = localObject2[i];
      switch (a(paramTextToSpeech, (Locale)localObject3))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        String str = ((Locale)localObject3).getLanguage();
        if (((HashMap)localObject1).get(str) == null)
        {
          ((HashMap)localObject1).put(str, new Locale(((Locale)localObject3).getLanguage()));
          continue;
          str = ((Locale)localObject3).getLanguage() + "_" + ((Locale)localObject3).getCountry();
          if (((HashMap)localObject1).get(str) == null) {
            ((HashMap)localObject1).put(str, new Locale(((Locale)localObject3).getLanguage(), ((Locale)localObject3).getCountry()));
          }
          localObject3 = ((Locale)localObject3).getLanguage();
          if ((((HashMap)localObject1).get(localObject3) instanceof Locale))
          {
            ((HashMap)localObject1).put(localObject3, a);
            continue;
            str = ((Locale)localObject3).toString();
            if (((HashMap)localObject1).get(str) == null) {
              ((HashMap)localObject1).put(str, localObject3);
            }
            str = ((Locale)localObject3).getLanguage();
            if ((((HashMap)localObject1).get(str) instanceof Locale)) {
              ((HashMap)localObject1).put(str, a);
            }
            localObject3 = ((Locale)localObject3).getLanguage() + "_" + ((Locale)localObject3).getCountry();
            if ((((HashMap)localObject1).get(localObject3) instanceof Locale)) {
              ((HashMap)localObject1).put(localObject3, a);
            }
          }
        }
      }
    }
    paramTextToSpeech = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((((Map.Entry)localObject2).getValue() instanceof Locale)) {
        paramTextToSpeech.add((Locale)((Map.Entry)localObject2).getValue());
      }
    }
    Collections.sort(paramTextToSpeech, b);
    return paramTextToSpeech;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */