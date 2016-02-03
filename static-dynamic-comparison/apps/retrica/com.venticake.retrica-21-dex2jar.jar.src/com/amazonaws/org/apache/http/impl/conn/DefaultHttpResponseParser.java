package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseFactory;
import com.amazonaws.org.apache.http.NoHttpResponseException;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.impl.io.AbstractMessageParser;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.message.LineParser;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class DefaultHttpResponseParser
  extends AbstractMessageParser<HttpResponse>
{
  private final CharArrayBuffer lineBuf;
  private final Log log = LogFactory.getLog(getClass());
  private final HttpResponseFactory responseFactory;
  
  public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpResponseFactory paramHttpResponseFactory, HttpParams paramHttpParams)
  {
    super(paramSessionInputBuffer, paramLineParser, paramHttpParams);
    if (paramHttpResponseFactory == null) {
      throw new IllegalArgumentException("Response factory may not be null");
    }
    this.responseFactory = paramHttpResponseFactory;
    this.lineBuf = new CharArrayBuffer(128);
  }
  
  protected HttpResponse parseHead(SessionInputBuffer paramSessionInputBuffer)
  {
    int i = 0;
    for (;;)
    {
      this.lineBuf.clear();
      int j = paramSessionInputBuffer.readLine(this.lineBuf);
      if ((j == -1) && (i == 0)) {
        throw new NoHttpResponseException("The target server failed to respond");
      }
      ParserCursor localParserCursor = new ParserCursor(0, this.lineBuf.length());
      if (this.lineParser.hasProtocolVersion(this.lineBuf, localParserCursor))
      {
        paramSessionInputBuffer = this.lineParser.parseStatusLine(this.lineBuf, localParserCursor);
        return this.responseFactory.newHttpResponse(paramSessionInputBuffer, null);
      }
      if ((j == -1) || (reject(this.lineBuf, i))) {
        throw new ProtocolException("The server failed to respond with a valid HTTP response");
      }
      if (this.log.isDebugEnabled()) {
        this.log.debug("Garbage in response: " + this.lineBuf.toString());
      }
      i += 1;
    }
  }
  
  protected boolean reject(CharArrayBuffer paramCharArrayBuffer, int paramInt)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/DefaultHttpResponseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */