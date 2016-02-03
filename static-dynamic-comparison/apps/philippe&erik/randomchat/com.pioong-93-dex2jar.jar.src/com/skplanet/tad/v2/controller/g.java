package com.skplanet.tad.v2.controller;

import com.skplanet.tad.common.a;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class g
  extends DefaultHandler
{
  private static final g e = new g();
  private Map a = new HashMap();
  private Map b = new HashMap();
  private String c;
  private int d = -1;
  
  private g()
  {
    this.a.put("Cookie", new a()
    {
      public void a()
      {
        g.a(g.this);
      }
    });
    this.b.put("Cookie", new a()
    {
      public void a()
      {
        g.b(g.this);
      }
    });
  }
  
  public static final g b()
  {
    return e;
  }
  
  private void c()
  {
    this.d = 1;
  }
  
  private void d()
  {
    this.d = -1;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = paramString2;
    try
    {
      paramString2 = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
      paramString2.setContentHandler(this);
      paramString2.parse(new InputSource(new StringReader(paramString1)));
      return;
    }
    catch (Throwable paramString1)
    {
      a.d("[ParserAdResponse]E0074: failed to parse data:");
    }
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    switch (this.d)
    {
    default: 
      return;
    }
    this.c = String.valueOf(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    paramString1 = (a)this.b.get(paramString2);
    if (paramString1 != null) {
      paramString1.a();
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    paramString1 = (a)this.a.get(paramString2);
    if (paramString1 != null) {
      paramString1.a();
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/controller/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */