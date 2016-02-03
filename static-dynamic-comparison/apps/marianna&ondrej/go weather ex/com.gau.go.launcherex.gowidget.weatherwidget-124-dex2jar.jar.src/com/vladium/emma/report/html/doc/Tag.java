package com.vladium.emma.report.html.doc;

public abstract class Tag
  implements IContent
{
  public static final Tag A;
  public static final Tag BODY;
  public static final Tag CAPTION;
  public static final Tag H1;
  public static final Tag H2;
  public static final Tag H3;
  public static final Tag H4;
  public static final Tag H5;
  public static final Tag H6;
  public static final Tag HEAD;
  public static final Tag HR;
  public static final Tag HTML = new TagImpl("HTML");
  public static final Tag[] Hs = { H1, H2, H3, H4, H4, H6 };
  public static final Tag LINK;
  public static final Tag META;
  public static final Tag P;
  public static final Tag SPAN;
  public static final Tag STYLE;
  public static final Tag TABLE;
  public static final Tag TD;
  public static final Tag TH;
  public static final Tag TITLE;
  public static final Tag TR;
  
  static
  {
    HEAD = new TagImpl("HEAD");
    BODY = new TagImpl("BODY");
    META = new TagImpl("META");
    STYLE = new TagImpl("STYLE");
    TITLE = new TagImpl("TITLE");
    H1 = new TagImpl("H1");
    H2 = new TagImpl("H2");
    H3 = new TagImpl("H3");
    H4 = new TagImpl("H4");
    H5 = new TagImpl("H5");
    H6 = new TagImpl("H6");
    LINK = new TagImpl("LINK");
    A = new TagImpl("A");
    TABLE = new TagImpl("TABLE");
    CAPTION = new TagImpl("CAPTION");
    TH = new TagImpl("TH");
    TR = new TagImpl("TR");
    TD = new TagImpl("TD");
    HR = new TagImpl("HR");
    P = new TagImpl("P");
    SPAN = new TagImpl("SPAN");
  }
  
  public abstract String getName();
  
  private static final class TagImpl
    extends Tag
  {
    private final String m_name;
    
    TagImpl(String paramString)
    {
      this.m_name = paramString;
    }
    
    public void emit(HTMLWriter paramHTMLWriter)
    {
      paramHTMLWriter.write(this.m_name);
    }
    
    public String getName()
    {
      return this.m_name;
    }
    
    public String toString()
    {
      return this.m_name;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */