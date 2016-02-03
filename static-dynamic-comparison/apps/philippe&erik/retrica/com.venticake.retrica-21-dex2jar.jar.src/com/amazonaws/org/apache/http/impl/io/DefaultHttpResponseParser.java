package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseFactory;
import com.amazonaws.org.apache.http.NoHttpResponseException;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.message.LineParser;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class DefaultHttpResponseParser
  extends AbstractMessageParser<HttpResponse>
{
  private final CharArrayBuffer lineBuf;
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
    this.lineBuf.clear();
    if (paramSessionInputBuffer.readLine(this.lineBuf) == -1) {
      throw new NoHttpResponseException("The target server failed to respond");
    }
    paramSessionInputBuffer = new ParserCursor(0, this.lineBuf.length());
    paramSessionInputBuffer = this.lineParser.parseStatusLine(this.lineBuf, paramSessionInputBuffer);
    return this.responseFactory.newHttpResponse(paramSessionInputBuffer, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/DefaultHttpResponseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */