package com.skplanet.tad.v2.controller;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class f
  extends DefaultHandler
{
  final String A = "AdTextColor";
  final String B = "ThumbnailImgUrl";
  final String C = "Url";
  final String D = "Popup";
  final String E = "RowSpan";
  final String F = "ColSpan";
  final String G = "CallNum";
  final String H = "Url";
  final String I = "MediaType";
  final String J = "Url";
  final String K = "Url";
  final String L = "MediaType";
  final String M = "idx";
  final String N = "Type";
  final String O = "Sz";
  private Map P = new HashMap();
  private Map Q = new HashMap();
  private com.skplanet.tad.v2.content.a R = new com.skplanet.tad.v2.content.a();
  private int S = 0;
  final String a = "Cookie";
  final String b = "Rolling";
  final String c = "Period";
  final String d = "RollCtrl";
  final String e = "DurTime";
  final String f = "NewSDKVer";
  final String g = "NewSDKUrl";
  final String h = "Banner";
  final String i = "BnrUrl";
  final String j = "TextInfo";
  final String k = "NotifyUrl";
  final String l = "LandingIconUrl";
  final String m = "WEB";
  final String n = "CALL";
  final String o = "MEDIA";
  final String p = "APPDL";
  final String q = "PLAYER";
  final String r = "Subset";
  final String s = "BannerType";
  final String t = "AdType";
  final String u = "idx";
  final String v = "AdsID";
  final String w = "Title";
  final String x = "ADText";
  final String y = "BgColor";
  final String z = "TitleColor";
  
  public f()
  {
    this.P.put("Cookie", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 1);
      }
    });
    this.P.put("Rolling", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 2);
      }
    });
    this.P.put("DurTime", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 4);
      }
    });
    this.P.put("Period", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 3);
      }
    });
    this.P.put("RollCtrl", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 5);
      }
    });
    this.P.put("BnrUrl", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 6);
      }
    });
    this.P.put("NotifyUrl", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 7);
      }
    });
    this.P.put("TextInfo", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.this.a(paramAnonymousAttributes);
      }
    });
    this.P.put("Banner", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this).k(paramAnonymousAttributes.getValue("AdsID"));
        if (paramAnonymousAttributes.getValue("AdType").equals("WEB"))
        {
          f.a(f.this).a(a.a.a);
          if (!paramAnonymousAttributes.getValue("BannerType").equals("Image")) {
            break label205;
          }
          f.a(f.this).a(com.skplanet.tad.v2.content.a.a.a);
        }
        label205:
        do
        {
          return;
          if (paramAnonymousAttributes.getValue("AdType").equals("CALL"))
          {
            f.a(f.this).a(a.a.d);
            break;
          }
          if (paramAnonymousAttributes.getValue("AdType").equals("MEDIA"))
          {
            f.a(f.this).a(a.a.b);
            break;
          }
          if (paramAnonymousAttributes.getValue("AdType").equals("APPDL"))
          {
            f.a(f.this).a(a.a.c);
            break;
          }
          if (!paramAnonymousAttributes.getValue("AdType").equals("PLAYER")) {
            break;
          }
          f.a(f.this).a(a.a.e);
          break;
          if (paramAnonymousAttributes.getValue("BannerType").equals("Text"))
          {
            f.a(f.this).a(com.skplanet.tad.v2.content.a.a.b);
            return;
          }
        } while (!paramAnonymousAttributes.getValue("BannerType").equals("Popup"));
        f.a(f.this).a(com.skplanet.tad.v2.content.a.a.c);
      }
    });
    this.P.put("Subset", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this, 8);
      }
    });
    this.P.put("CALL", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this).l(paramAnonymousAttributes.getValue("CallNum"));
      }
    });
    this.P.put("WEB", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this).l(paramAnonymousAttributes.getValue("Url"));
        if (paramAnonymousAttributes.getValue("Popup").equals("T")) {
          f.a(f.this).a(true);
        }
        while (!paramAnonymousAttributes.getValue("Popup").equals("F")) {
          return;
        }
        f.a(f.this).a(false);
      }
    });
    this.P.put("MEDIA", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this).l(paramAnonymousAttributes.getValue("Url"));
      }
    });
    this.P.put("APPDL", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this).l(paramAnonymousAttributes.getValue("Url"));
      }
    });
    this.P.put("PLAYER", new a()
    {
      public void a(Attributes paramAnonymousAttributes)
      {
        f.a(f.this).l(paramAnonymousAttributes.getValue("Url"));
      }
    });
  }
  
  /* Error */
  public com.skplanet.tad.v2.content.a a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 293	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 297	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   11: invokevirtual 303	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   14: astore_3
    //   15: new 305	java/io/StringReader
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 308	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: aload_0
    //   28: invokeinterface 314 2 0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: new 316	org/xml/sax/InputSource
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 319	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   44: invokeinterface 323 2 0
    //   49: aload 4
    //   51: astore_1
    //   52: aload_2
    //   53: ifnull +12 -> 65
    //   56: aload_2
    //   57: invokevirtual 328	java/io/Reader:close	()V
    //   60: aload_0
    //   61: getfield 256	com/skplanet/tad/v2/controller/f:R	Lcom/skplanet/tad/v2/content/a;
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_1
    //   72: ldc_w 330
    //   75: aload_3
    //   76: invokevirtual 334	java/lang/Exception:toString	()Ljava/lang/String;
    //   79: invokestatic 339	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload 4
    //   85: astore_1
    //   86: aload_2
    //   87: ifnull -22 -> 65
    //   90: aload_2
    //   91: invokevirtual 328	java/io/Reader:close	()V
    //   94: aload_0
    //   95: getfield 256	com/skplanet/tad/v2/controller/f:R	Lcom/skplanet/tad/v2/content/a;
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +15 -> 120
    //   108: aload_1
    //   109: invokevirtual 328	java/io/Reader:close	()V
    //   112: aload_0
    //   113: getfield 256	com/skplanet/tad/v2/controller/f:R	Lcom/skplanet/tad/v2/content/a;
    //   116: astore_1
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: aload_2
    //   121: athrow
    //   122: astore_1
    //   123: aconst_null
    //   124: areturn
    //   125: astore_2
    //   126: goto -22 -> 104
    //   129: astore_1
    //   130: aconst_null
    //   131: areturn
    //   132: astore_3
    //   133: goto -63 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	f
    //   0	136	1	paramString	String
    //   6	85	2	localObject1	Object
    //   101	20	2	localObject2	Object
    //   125	1	2	localObject3	Object
    //   14	22	3	localXMLReader	org.xml.sax.XMLReader
    //   67	9	3	localException1	Exception
    //   132	1	3	localException2	Exception
    //   1	83	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   7	24	67	java/lang/Exception
    //   7	24	101	finally
    //   108	117	119	java/io/IOException
    //   56	65	122	java/io/IOException
    //   26	33	125	finally
    //   35	49	125	finally
    //   72	83	125	finally
    //   90	99	129	java/io/IOException
    //   26	33	132	java/lang/Exception
    //   35	49	132	java/lang/Exception
  }
  
  protected void a(Attributes paramAttributes)
  {
    if (this.R == null) {}
    while ((this.R != null) && (this.R.n() == com.skplanet.tad.v2.content.a.a.a)) {
      return;
    }
    String str = paramAttributes.getValue("Title");
    this.R.g(str);
    if (a(str)) {
      com.skplanet.tad.common.a.c("[ParserAdResponse]there is no Title");
    }
    str = paramAttributes.getValue("ADText");
    this.R.h(str);
    if (a(str)) {
      com.skplanet.tad.common.a.c("[ParserAdResponse]there is no Body");
    }
    str = paramAttributes.getValue("ThumbnailImgUrl");
    this.R.i(str);
    if (a(str)) {
      com.skplanet.tad.common.a.c("[ParserAdResponse]there is no ThumbnailImgUrl");
    }
    str = paramAttributes.getValue("BgColor");
    if (TextUtils.isEmpty(str))
    {
      this.R.c(0);
      str = paramAttributes.getValue("TitleColor");
      if (!TextUtils.isEmpty(str)) {
        break label238;
      }
      this.R.a(Color.argb(255, 28, 28, 28));
    }
    for (;;)
    {
      paramAttributes = paramAttributes.getValue("AdTextColor");
      if (!TextUtils.isEmpty(paramAttributes)) {
        break label295;
      }
      this.R.a(Color.argb(255, 50, 50, 50));
      return;
      try
      {
        i1 = Integer.parseInt(str);
        this.R.c(i1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1 = 0;
        }
      }
      label238:
      this.R.a(Color.argb(255, Integer.valueOf(localException.substring(0, 2), 16).intValue(), Integer.valueOf(localException.substring(2, 4), 16).intValue(), Integer.valueOf(localException.substring(4), 16).intValue()));
    }
    label295:
    this.R.b(Color.argb(255, Integer.valueOf(paramAttributes.substring(0, 2), 16).intValue(), Integer.valueOf(paramAttributes.substring(2, 4), 16).intValue(), Integer.valueOf(paramAttributes.substring(4), 16).intValue()));
  }
  
  public boolean a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    while (paramCharSequence.toString().trim().length() <= 0) {
      return true;
    }
    return false;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    paramArrayOfChar = String.valueOf(paramArrayOfChar, paramInt1, paramInt2);
    switch (this.S)
    {
    case 2: 
    case 3: 
    case 5: 
    default: 
      return;
    case 1: 
      this.R.j(paramArrayOfChar);
      return;
    case 4: 
      this.R.a(Long.parseLong(paramArrayOfChar) * 1000L);
      return;
    case 6: 
      this.R.f(paramArrayOfChar);
      return;
    case 7: 
      this.R.a(paramArrayOfChar);
      return;
    }
    this.R.m(paramArrayOfChar);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    paramString1 = (a)this.Q.get(paramString2);
    if (paramString1 != null) {
      paramString1.a(null);
    }
    this.S = 0;
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    paramString1 = (a)this.P.get(paramString2);
    if (paramString1 != null) {
      paramString1.a(paramAttributes);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(Attributes paramAttributes);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/controller/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */