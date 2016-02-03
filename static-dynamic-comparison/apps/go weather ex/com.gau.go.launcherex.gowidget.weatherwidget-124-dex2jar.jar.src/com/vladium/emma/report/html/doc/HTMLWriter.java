package com.vladium.emma.report.html.doc;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.util.IConstants;
import java.io.IOException;
import java.io.Writer;

public final class HTMLWriter
{
  private Writer m_out;
  
  public HTMLWriter(Writer paramWriter)
  {
    if (paramWriter == null) {
      throw new IllegalArgumentException("null input: out");
    }
    this.m_out = paramWriter;
  }
  
  public void close()
  {
    if (this.m_out != null) {}
    try
    {
      this.m_out.close();
      this.m_out = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public void eol()
  {
    if (this.m_out != null) {}
    try
    {
      this.m_out.write(IConstants.EOL);
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", localIOException);
    }
  }
  
  public void flush()
  {
    if (this.m_out != null) {}
    try
    {
      this.m_out.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", localIOException);
    }
  }
  
  public void write(char paramChar)
  {
    if (this.m_out != null) {}
    try
    {
      this.m_out.write(paramChar);
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", localIOException);
    }
  }
  
  public void write(String paramString)
  {
    if (this.m_out != null) {}
    try
    {
      this.m_out.write(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/HTMLWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */