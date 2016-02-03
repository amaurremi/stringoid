package com.vladium.emma.report.html.doc;

public final class TextContent
  implements IContent
{
  private final String m_text;
  
  public TextContent(String paramString)
  {
    this.m_text = paramString;
  }
  
  public void emit(HTMLWriter paramHTMLWriter)
  {
    if (this.m_text != null) {
      paramHTMLWriter.write(this.m_text);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/TextContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */