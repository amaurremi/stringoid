package org.jsoup;

import java.util.Collection;
import org.jsoup.parser.Parser;

public abstract interface Connection$Request
  extends Connection.Base
{
  public abstract Collection data();
  
  public abstract Request data(Connection.KeyVal paramKeyVal);
  
  public abstract Request followRedirects(boolean paramBoolean);
  
  public abstract boolean followRedirects();
  
  public abstract Request ignoreContentType(boolean paramBoolean);
  
  public abstract boolean ignoreContentType();
  
  public abstract Request ignoreHttpErrors(boolean paramBoolean);
  
  public abstract boolean ignoreHttpErrors();
  
  public abstract int maxBodySize();
  
  public abstract Request maxBodySize(int paramInt);
  
  public abstract Request parser(Parser paramParser);
  
  public abstract Parser parser();
  
  public abstract int timeout();
  
  public abstract Request timeout(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/Connection$Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */