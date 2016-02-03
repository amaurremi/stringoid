package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpMessage;
import com.amazonaws.org.apache.http.ParseException;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.io.HttpMessageParser;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.message.BasicLineParser;
import com.amazonaws.org.apache.http.message.LineParser;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractMessageParser<T extends HttpMessage>
  implements HttpMessageParser<T>
{
  private final List<CharArrayBuffer> headerLines;
  protected final LineParser lineParser;
  private final int maxHeaderCount;
  private final int maxLineLen;
  private T message;
  private final SessionInputBuffer sessionBuffer;
  private int state;
  
  public AbstractMessageParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpParams paramHttpParams)
  {
    if (paramSessionInputBuffer == null) {
      throw new IllegalArgumentException("Session input buffer may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    this.sessionBuffer = paramSessionInputBuffer;
    this.maxHeaderCount = paramHttpParams.getIntParameter("http.connection.max-header-count", -1);
    this.maxLineLen = paramHttpParams.getIntParameter("http.connection.max-line-length", -1);
    if (paramLineParser != null) {}
    for (;;)
    {
      this.lineParser = paramLineParser;
      this.headerLines = new ArrayList();
      this.state = 0;
      return;
      paramLineParser = BasicLineParser.DEFAULT;
    }
  }
  
  public static Header[] parseHeaders(SessionInputBuffer paramSessionInputBuffer, int paramInt1, int paramInt2, LineParser paramLineParser)
  {
    Object localObject = paramLineParser;
    if (paramLineParser == null) {
      localObject = BasicLineParser.DEFAULT;
    }
    return parseHeaders(paramSessionInputBuffer, paramInt1, paramInt2, (LineParser)localObject, new ArrayList());
  }
  
  public static Header[] parseHeaders(SessionInputBuffer paramSessionInputBuffer, int paramInt1, int paramInt2, LineParser paramLineParser, List<CharArrayBuffer> paramList)
  {
    int j = 0;
    if (paramSessionInputBuffer == null) {
      throw new IllegalArgumentException("Session input buffer may not be null");
    }
    if (paramLineParser == null) {
      throw new IllegalArgumentException("Line parser may not be null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("Header line list may not be null");
    }
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      if (localObject1 == null) {
        localObject1 = new CharArrayBuffer(64);
      }
      while ((paramSessionInputBuffer.readLine((CharArrayBuffer)localObject1) == -1) || (((CharArrayBuffer)localObject1).length() < 1))
      {
        paramSessionInputBuffer = new Header[paramList.size()];
        paramInt1 = j;
        while (paramInt1 < paramList.size())
        {
          localObject1 = (CharArrayBuffer)paramList.get(paramInt1);
          try
          {
            paramSessionInputBuffer[paramInt1] = paramLineParser.parseHeader((CharArrayBuffer)localObject1);
            paramInt1 += 1;
          }
          catch (ParseException paramSessionInputBuffer)
          {
            int i;
            throw new ProtocolException(paramSessionInputBuffer.getMessage());
          }
        }
        ((CharArrayBuffer)localObject1).clear();
      }
      if (((((CharArrayBuffer)localObject1).charAt(0) == ' ') || (((CharArrayBuffer)localObject1).charAt(0) == '\t')) && (localObject2 != null))
      {
        i = 0;
        for (;;)
        {
          if (i < ((CharArrayBuffer)localObject1).length())
          {
            int k = ((CharArrayBuffer)localObject1).charAt(i);
            if ((k == 32) || (k == 9)) {}
          }
          else
          {
            if ((paramInt2 <= 0) || (((CharArrayBuffer)localObject2).length() + 1 + ((CharArrayBuffer)localObject1).length() - i <= paramInt2)) {
              break;
            }
            throw new IOException("Maximum line length limit exceeded");
          }
          i += 1;
        }
        ((CharArrayBuffer)localObject2).append(' ');
        ((CharArrayBuffer)localObject2).append((CharArrayBuffer)localObject1, i, ((CharArrayBuffer)localObject1).length() - i);
      }
      while ((paramInt1 > 0) && (paramList.size() >= paramInt1))
      {
        throw new IOException("Maximum header count exceeded");
        paramList.add(localObject1);
        Object localObject3 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    return paramSessionInputBuffer;
  }
  
  public T parse()
  {
    switch (this.state)
    {
    default: 
      throw new IllegalStateException("Inconsistent parser state");
    }
    try
    {
      this.message = parseHead(this.sessionBuffer);
      this.state = 1;
      Object localObject = parseHeaders(this.sessionBuffer, this.maxHeaderCount, this.maxLineLen, this.lineParser, this.headerLines);
      this.message.setHeaders((Header[])localObject);
      localObject = this.message;
      this.message = null;
      this.headerLines.clear();
      this.state = 0;
      return (T)localObject;
    }
    catch (ParseException localParseException)
    {
      throw new ProtocolException(localParseException.getMessage(), localParseException);
    }
  }
  
  protected abstract T parseHead(SessionInputBuffer paramSessionInputBuffer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/AbstractMessageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */