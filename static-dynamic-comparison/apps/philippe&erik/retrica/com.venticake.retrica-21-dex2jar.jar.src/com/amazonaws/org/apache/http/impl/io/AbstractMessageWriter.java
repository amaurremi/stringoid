package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderIterator;
import com.amazonaws.org.apache.http.HttpMessage;
import com.amazonaws.org.apache.http.io.HttpMessageWriter;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import com.amazonaws.org.apache.http.message.BasicLineFormatter;
import com.amazonaws.org.apache.http.message.LineFormatter;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractMessageWriter<T extends HttpMessage>
  implements HttpMessageWriter<T>
{
  protected final CharArrayBuffer lineBuf;
  protected final LineFormatter lineFormatter;
  protected final SessionOutputBuffer sessionBuffer;
  
  public AbstractMessageWriter(SessionOutputBuffer paramSessionOutputBuffer, LineFormatter paramLineFormatter, HttpParams paramHttpParams)
  {
    if (paramSessionOutputBuffer == null) {
      throw new IllegalArgumentException("Session input buffer may not be null");
    }
    this.sessionBuffer = paramSessionOutputBuffer;
    this.lineBuf = new CharArrayBuffer(128);
    if (paramLineFormatter != null) {}
    for (;;)
    {
      this.lineFormatter = paramLineFormatter;
      return;
      paramLineFormatter = BasicLineFormatter.DEFAULT;
    }
  }
  
  public void write(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("HTTP message may not be null");
    }
    writeHeadLine(paramT);
    paramT = paramT.headerIterator();
    while (paramT.hasNext())
    {
      Header localHeader = paramT.nextHeader();
      this.sessionBuffer.writeLine(this.lineFormatter.formatHeader(this.lineBuf, localHeader));
    }
    this.lineBuf.clear();
    this.sessionBuffer.writeLine(this.lineBuf);
  }
  
  protected abstract void writeHeadLine(T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/AbstractMessageWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */