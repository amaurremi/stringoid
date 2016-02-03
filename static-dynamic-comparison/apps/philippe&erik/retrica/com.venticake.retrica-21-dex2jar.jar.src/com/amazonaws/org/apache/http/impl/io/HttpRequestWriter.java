package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import com.amazonaws.org.apache.http.message.LineFormatter;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpRequestWriter
  extends AbstractMessageWriter<HttpRequest>
{
  public HttpRequestWriter(SessionOutputBuffer paramSessionOutputBuffer, LineFormatter paramLineFormatter, HttpParams paramHttpParams)
  {
    super(paramSessionOutputBuffer, paramLineFormatter, paramHttpParams);
  }
  
  protected void writeHeadLine(HttpRequest paramHttpRequest)
  {
    this.lineFormatter.formatRequestLine(this.lineBuf, paramHttpRequest.getRequestLine());
    this.sessionBuffer.writeLine(this.lineBuf);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/HttpRequestWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */