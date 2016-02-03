package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.io.BufferInfo;
import com.amazonaws.org.apache.http.io.HttpTransportMetrics;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import com.amazonaws.org.apache.http.util.ByteArrayBuffer;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractSessionInputBuffer
  implements BufferInfo, SessionInputBuffer
{
  private static final Charset ASCII = Charset.forName("US-ASCII");
  private boolean ascii = true;
  private byte[] buffer;
  private int bufferlen;
  private int bufferpos;
  private CharBuffer cbuf;
  private Charset charset;
  private CharsetDecoder decoder;
  private InputStream instream;
  private ByteArrayBuffer linebuffer = null;
  private int maxLineLen = -1;
  private HttpTransportMetricsImpl metrics;
  private int minChunkLimit = 512;
  private CodingErrorAction onMalformedInputAction;
  private CodingErrorAction onUnMappableInputAction;
  
  private int appendDecoded(CharArrayBuffer paramCharArrayBuffer, ByteBuffer paramByteBuffer)
  {
    int i = 0;
    if (!paramByteBuffer.hasRemaining()) {
      return 0;
    }
    if (this.decoder == null)
    {
      this.decoder = this.charset.newDecoder();
      this.decoder.onMalformedInput(this.onMalformedInputAction);
      this.decoder.onUnmappableCharacter(this.onUnMappableInputAction);
    }
    if (this.cbuf == null) {
      this.cbuf = CharBuffer.allocate(1024);
    }
    this.decoder.reset();
    while (paramByteBuffer.hasRemaining()) {
      i += handleDecodingResult(this.decoder.decode(paramByteBuffer, this.cbuf, true), paramCharArrayBuffer, paramByteBuffer);
    }
    int j = handleDecodingResult(this.decoder.flush(this.cbuf), paramCharArrayBuffer, paramByteBuffer);
    this.cbuf.clear();
    return i + j;
  }
  
  private int handleDecodingResult(CoderResult paramCoderResult, CharArrayBuffer paramCharArrayBuffer, ByteBuffer paramByteBuffer)
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.cbuf.flip();
    int i = this.cbuf.remaining();
    while (this.cbuf.hasRemaining()) {
      paramCharArrayBuffer.append(this.cbuf.get());
    }
    this.cbuf.compact();
    return i;
  }
  
  private int lineFromLineBuffer(CharArrayBuffer paramCharArrayBuffer)
  {
    int k = this.linebuffer.length();
    int i = k;
    if (k > 0)
    {
      int j = k;
      if (this.linebuffer.byteAt(k - 1) == 10) {
        j = k - 1;
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (this.linebuffer.byteAt(j - 1) == 13) {
          i = j - 1;
        }
      }
    }
    if (this.ascii) {
      paramCharArrayBuffer.append(this.linebuffer, 0, i);
    }
    for (;;)
    {
      this.linebuffer.clear();
      return i;
      i = appendDecoded(paramCharArrayBuffer, ByteBuffer.wrap(this.linebuffer.buffer(), 0, i));
    }
  }
  
  private int lineFromReadBuffer(CharArrayBuffer paramCharArrayBuffer, int paramInt)
  {
    int j = this.bufferpos;
    this.bufferpos = (paramInt + 1);
    int i = paramInt;
    if (paramInt > 0)
    {
      i = paramInt;
      if (this.buffer[(paramInt - 1)] == 13) {
        i = paramInt - 1;
      }
    }
    paramInt = i - j;
    if (this.ascii)
    {
      paramCharArrayBuffer.append(this.buffer, j, paramInt);
      return paramInt;
    }
    return appendDecoded(paramCharArrayBuffer, ByteBuffer.wrap(this.buffer, j, paramInt));
  }
  
  private int locateLF()
  {
    int i = this.bufferpos;
    while (i < this.bufferlen)
    {
      if (this.buffer[i] == 10) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected HttpTransportMetricsImpl createTransportMetrics()
  {
    return new HttpTransportMetricsImpl();
  }
  
  protected int fillBuffer()
  {
    if (this.bufferpos > 0)
    {
      i = this.bufferlen - this.bufferpos;
      if (i > 0) {
        System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, i);
      }
      this.bufferpos = 0;
      this.bufferlen = i;
    }
    int i = this.bufferlen;
    int j = this.buffer.length;
    j = this.instream.read(this.buffer, i, j - i);
    if (j == -1) {
      return -1;
    }
    this.bufferlen = (i + j);
    this.metrics.incrementBytesTransferred(j);
    return j;
  }
  
  public HttpTransportMetrics getMetrics()
  {
    return this.metrics;
  }
  
  protected boolean hasBufferedData()
  {
    return this.bufferpos < this.bufferlen;
  }
  
  protected void init(InputStream paramInputStream, int paramInt, HttpParams paramHttpParams)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Input stream may not be null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Buffer size may not be negative or zero");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    this.instream = paramInputStream;
    this.buffer = new byte[paramInt];
    this.bufferpos = 0;
    this.bufferlen = 0;
    this.linebuffer = new ByteArrayBuffer(paramInt);
    this.charset = Charset.forName(HttpProtocolParams.getHttpElementCharset(paramHttpParams));
    this.ascii = this.charset.equals(ASCII);
    this.decoder = null;
    this.maxLineLen = paramHttpParams.getIntParameter("http.connection.max-line-length", -1);
    this.minChunkLimit = paramHttpParams.getIntParameter("http.connection.min-chunk-limit", 512);
    this.metrics = createTransportMetrics();
    this.onMalformedInputAction = HttpProtocolParams.getMalformedInputAction(paramHttpParams);
    this.onUnMappableInputAction = HttpProtocolParams.getUnmappableInputAction(paramHttpParams);
  }
  
  public int length()
  {
    return this.bufferlen - this.bufferpos;
  }
  
  public int read()
  {
    while (!hasBufferedData()) {
      if (fillBuffer() == -1) {
        return -1;
      }
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferpos;
    this.bufferpos = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      paramInt1 = 0;
    }
    do
    {
      return paramInt1;
      if (hasBufferedData())
      {
        paramInt2 = Math.min(paramInt2, this.bufferlen - this.bufferpos);
        System.arraycopy(this.buffer, this.bufferpos, paramArrayOfByte, paramInt1, paramInt2);
        this.bufferpos += paramInt2;
        return paramInt2;
      }
      if (paramInt2 <= this.minChunkLimit) {
        break;
      }
      paramInt2 = this.instream.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    this.metrics.incrementBytesTransferred(paramInt2);
    return paramInt2;
    while (!hasBufferedData()) {
      if (fillBuffer() == -1) {
        return -1;
      }
    }
    paramInt2 = Math.min(paramInt2, this.bufferlen - this.bufferpos);
    System.arraycopy(this.buffer, this.bufferpos, paramArrayOfByte, paramInt1, paramInt2);
    this.bufferpos += paramInt2;
    return paramInt2;
  }
  
  public int readLine(CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("Char array buffer may not be null");
    }
    int j = 1;
    int k = 0;
    if (j != 0)
    {
      int i = locateLF();
      int m;
      if (i != -1)
      {
        if (this.linebuffer.isEmpty()) {
          return lineFromReadBuffer(paramCharArrayBuffer, i);
        }
        j = this.bufferpos;
        this.linebuffer.append(this.buffer, this.bufferpos, i + 1 - j);
        this.bufferpos = (i + 1);
        i = 0;
        m = k;
      }
      for (;;)
      {
        j = i;
        k = m;
        if (this.maxLineLen <= 0) {
          break;
        }
        j = i;
        k = m;
        if (this.linebuffer.length() < this.maxLineLen) {
          break;
        }
        throw new IOException("Maximum line length limit exceeded");
        if (hasBufferedData())
        {
          i = this.bufferlen;
          k = this.bufferpos;
          this.linebuffer.append(this.buffer, this.bufferpos, i - k);
          this.bufferpos = this.bufferlen;
        }
        k = fillBuffer();
        i = j;
        m = k;
        if (k == -1)
        {
          i = 0;
          m = k;
        }
      }
    }
    if ((k == -1) && (this.linebuffer.isEmpty())) {
      return -1;
    }
    return lineFromLineBuffer(paramCharArrayBuffer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/AbstractSessionInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */