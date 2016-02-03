package com.amazonaws.javax.xml.stream.xerces.impl.msg;

import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class XMLMessageFormatter
  implements MessageFormatter
{
  private Locale fLocale = null;
  private ResourceBundle fResourceBundle = null;
  
  public String formatMessage(Locale paramLocale, String paramString, Object[] paramArrayOfObject)
  {
    if ((this.fResourceBundle == null) || (paramLocale != this.fLocale))
    {
      if (paramLocale != null)
      {
        this.fResourceBundle = PropertyResourceBundle.getBundle("com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessages", paramLocale);
        this.fLocale = paramLocale;
      }
      if (this.fResourceBundle == null) {
        this.fResourceBundle = PropertyResourceBundle.getBundle("com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessages");
      }
    }
    try
    {
      Object localObject = this.fResourceBundle.getString(paramString);
      paramLocale = (Locale)localObject;
      if (paramArrayOfObject != null) {}
      try
      {
        paramLocale = MessageFormat.format((String)localObject, paramArrayOfObject);
        if (paramLocale == null)
        {
          paramLocale = paramString;
          if (paramArrayOfObject.length > 0)
          {
            localObject = new StringBuffer(paramString);
            ((StringBuffer)localObject).append('?');
            int i = 0;
            for (;;)
            {
              paramLocale = paramString;
              if (i >= paramArrayOfObject.length) {
                break;
              }
              if (i > 0) {
                ((StringBuffer)localObject).append('&');
              }
              ((StringBuffer)localObject).append(String.valueOf(paramArrayOfObject[i]));
              i += 1;
            }
          }
        }
      }
      catch (Exception paramLocale)
      {
        for (;;)
        {
          paramLocale = this.fResourceBundle.getString("FormatFailed");
          paramLocale = paramLocale + " " + this.fResourceBundle.getString(paramString);
        }
      }
      return paramLocale;
    }
    catch (MissingResourceException paramLocale)
    {
      throw new MissingResourceException(paramString, this.fResourceBundle.getString("BadMessageKey"), paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/impl/msg/XMLMessageFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */