package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.io.BufferInfo;
import com.amazonaws.org.apache.http.io.HttpTransportMetrics;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import com.amazonaws.org.apache.http.util.ByteArrayBuffer;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractSessionOutputBuffer
  implements BufferInfo, SessionOutputBuffer
{
  private static final Charset ASCII = Charset.forName("US-ASCII");
  private static final byte[] CRLF = { 13, 10 };
  private boolean ascii = true;
  private ByteBuffer bbuf;
  private ByteArrayBuffer buffer;
  private Charset charset;
  private CharsetEncoder encoder;
  private HttpTransportMetricsImpl metrics;
  private int minChunkLimit = 512;
  private CodingErrorAction onMalformedInputAction;
  private CodingErrorAction onUnMappableInputAction;
  private OutputStream outstream;
  
  private void handleEncodingResult(CoderResult paramCoderResult)
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.bbuf.flip();
    while (this.bbuf.hasRemaining()) {
      write(this.bbuf.get());
    }
    this.bbuf.compact();
  }
  
  private void writeEncoded(CharBuffer paramCharBuffer)
  {
    if (!paramCharBuffer.hasRemaining()) {
      return;
    }
    if (this.encoder == null)
    {
      this.encoder = this.charset.newEncoder();
      this.encoder.onMalformedInput(this.onMalformedInputAction);
      this.encoder.onUnmappableCharacter(this.onUnMappableInputAction);
    }
    if (this.bbuf == null) {
      this.bbuf = ByteBuffer.allocate(1024);
    }
    this.encoder.reset();
    while (paramCharBuffer.hasRemaining()) {
      handleEncodingResult(this.encoder.encode(paramCharBuffer, this.bbuf, true));
    }
    handleEncodingResult(this.encoder.flush(this.bbuf));
    this.bbuf.clear();
  }
  
  protected HttpTransportMetricsImpl createTransportMetrics()
  {
    return new HttpTransportMetricsImpl();
  }
  
  public void flush()
  {
    flushBuffer();
    this.outstream.flush();
  }
  
  protected void flushBuffer()
  {
    int i = this.buffer.length();
    if (i > 0)
    {
      this.outstream.write(this.buffer.buffer(), 0, i);
      this.buffer.clear();
      this.metrics.incrementBytesTransferred(i);
    }
  }
  
  public HttpTransportMetrics getMetrics()
  {
    return this.metrics;
  }
  
  protected void init(OutputStream paramOutputStream, int paramInt, HttpParams paramHttpParams)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Input stream may not be null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Buffer size may not be negative or zero");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    this.outstream = paramOutputStream;
    this.buffer = new ByteArrayBuffer(paramInt);
    this.charset = Charset.forName(HttpProtocolParams.getHttpElementCharset(paramHttpParams));
    this.ascii = this.charset.equals(ASCII);
    this.encoder = null;
    this.minChunkLimit = paramHttpParams.getIntParameter("http.connection.min-chunk-limit", 512);
    this.metrics = createTransportMetrics();
    this.onMalformedInputAction = HttpProtocolParams.getMalformedInputAction(paramHttpParams);
    this.onUnMappableInputAction = HttpProtocolParams.getUnmappableInputAction(paramHttpParams);
  }
  
  public int length()
  {
    return this.buffer.length();
  }
  
  public void write(int paramInt)
  {
    if (this.buffer.isFull()) {
      flushBuffer();
    }
    this.buffer.append(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if ((paramInt2 > this.minChunkLimit) || (paramInt2 > this.buffer.capacity()))
    {
      flushBuffer();
      this.outstream.write(paramArrayOfByte, paramInt1, paramInt2);
      this.metrics.incrementBytesTransferred(paramInt2);
      return;
    }
    if (paramInt2 > this.buffer.capacity() - this.buffer.length()) {
      flushBuffer();
    }
    this.buffer.append(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeLine(CharArrayBuffer paramCharArrayBuffer)
  {
    int j = 0;
    if (paramCharArrayBuffer == null) {
      return;
    }
    if (this.ascii)
    {
      int i = paramCharArrayBuffer.length();
      while (i > 0)
      {
        int k = Math.min(this.buffer.capacity() - this.buffer.length(), i);
        if (k > 0) {
          this.buffer.append(paramCharArrayBuffer, j, k);
        }
        if (this.buffer.isFull()) {
          flushBuffer();
        }
        j += k;
        i -= k;
      }
    }
    writeEncoded(CharBuffer.wrap(paramCharArrayBuffer.buffer(), 0, paramCharArrayBuffer.length()));
    write(CRLF);
  }
  
  public void writeLine(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.length() > 0)
    {
      if (this.ascii)
      {
        int i = 0;
        while (i < paramString.length())
        {
          write(paramString.charAt(i));
          i += 1;
        }
      }
      writeEncoded(CharBuffer.wrap(paramString));
    }
    write(CRLF);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/AbstractSessionOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */