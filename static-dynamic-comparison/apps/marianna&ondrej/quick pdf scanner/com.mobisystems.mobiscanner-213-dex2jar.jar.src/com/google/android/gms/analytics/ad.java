package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class ad<T extends ac>
{
  Context mContext;
  a<T> nz;
  
  public ad(Context paramContext, a<T> parama)
  {
    this.mContext = paramContext;
    this.nz = parama;
  }
  
  private T a(XmlResourceParser paramXmlResourceParser)
  {
    for (;;)
    {
      try
      {
        paramXmlResourceParser.next();
        i = paramXmlResourceParser.getEventType();
        if (i == 1) {
          continue;
        }
        if (paramXmlResourceParser.getEventType() == 2)
        {
          str1 = paramXmlResourceParser.getName().toLowerCase();
          if (!str1.equals("screenname")) {
            continue;
          }
          str1 = paramXmlResourceParser.getAttributeValue(null, "name");
          str2 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            this.nz.g(str1, str2);
          }
        }
      }
      catch (XmlPullParserException paramXmlResourceParser)
      {
        j.Z("Error parsing tracker configuration file: " + paramXmlResourceParser);
        return this.nz.lp();
        if (!str1.equals("bool")) {
          continue;
        }
        String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
        str1 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        bool = TextUtils.isEmpty(str1);
        if (bool) {
          continue;
        }
        try
        {
          bool = Boolean.parseBoolean(str1);
          this.nz.c(str2, bool);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          j.Z("Error parsing bool configuration value: " + str1);
        }
        continue;
      }
      catch (IOException paramXmlResourceParser)
      {
        int i;
        j.Z("Error parsing tracker configuration file: " + paramXmlResourceParser);
        continue;
        if (!str1.equals("integer")) {
          continue;
        }
        String str3 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str1 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str3)) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(str1);
        if (bool) {
          continue;
        }
        try
        {
          i = Integer.parseInt(str1);
          this.nz.b(str3, i);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          j.Z("Error parsing int configuration value: " + str1);
        }
        continue;
      }
      i = paramXmlResourceParser.next();
      continue;
      if (!str1.equals("string")) {
        continue;
      }
      str1 = paramXmlResourceParser.getAttributeValue(null, "name");
      str2 = paramXmlResourceParser.nextText().trim();
      if ((!TextUtils.isEmpty(str1)) && (str2 != null)) {
        this.nz.h(str1, str2);
      }
    }
  }
  
  public T bf(int paramInt)
  {
    try
    {
      ac localac = a(this.mContext.getResources().getXml(paramInt));
      return localac;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      j.D("inflate() called with unknown resourceId: " + localNotFoundException);
    }
    return null;
  }
  
  public static abstract interface a<U extends ac>
  {
    public abstract void b(String paramString, int paramInt);
    
    public abstract void c(String paramString, boolean paramBoolean);
    
    public abstract void g(String paramString1, String paramString2);
    
    public abstract void h(String paramString1, String paramString2);
    
    public abstract U lp();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */