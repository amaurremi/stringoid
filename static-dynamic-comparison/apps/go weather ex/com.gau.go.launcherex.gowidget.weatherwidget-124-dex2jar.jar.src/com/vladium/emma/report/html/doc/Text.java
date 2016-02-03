package com.vladium.emma.report.html.doc;

import com.vladium.util.Strings;

public final class Text
  implements IContent
{
  private final boolean m_nbsp;
  private final String m_text;
  
  public Text(String paramString, boolean paramBoolean)
  {
    this.m_text = paramString;
    this.m_nbsp = paramBoolean;
  }
  
  public void emit(HTMLWriter paramHTMLWriter)
  {
    if (this.m_text != null)
    {
      if (this.m_nbsp) {
        paramHTMLWriter.write(Strings.HTMLEscapeSP(this.m_text));
      }
    }
    else {
      return;
    }
    paramHTMLWriter.write(Strings.HTMLEscape(this.m_text));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */