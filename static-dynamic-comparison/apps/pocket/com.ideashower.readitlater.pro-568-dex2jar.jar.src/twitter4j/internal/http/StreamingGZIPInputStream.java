package twitter4j.internal.http;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;

final class StreamingGZIPInputStream
  extends GZIPInputStream
{
  private final InputStream wrapped;
  
  public StreamingGZIPInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
    this.wrapped = paramInputStream;
  }
  
  public int available()
  {
    return this.wrapped.available();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/http/StreamingGZIPInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */