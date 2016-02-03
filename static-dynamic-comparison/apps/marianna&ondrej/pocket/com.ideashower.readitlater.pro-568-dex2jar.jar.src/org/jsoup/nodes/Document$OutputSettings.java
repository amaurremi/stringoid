package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.jsoup.helper.Validate;

public class Document$OutputSettings
  implements Cloneable
{
  private Charset charset = Charset.forName("UTF-8");
  private CharsetEncoder charsetEncoder = this.charset.newEncoder();
  private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
  private int indentAmount = 1;
  private boolean outline = false;
  private boolean prettyPrint = true;
  
  public Charset charset()
  {
    return this.charset;
  }
  
  public OutputSettings charset(String paramString)
  {
    charset(Charset.forName(paramString));
    return this;
  }
  
  public OutputSettings charset(Charset paramCharset)
  {
    this.charset = paramCharset;
    this.charsetEncoder = paramCharset.newEncoder();
    return this;
  }
  
  public OutputSettings clone()
  {
    try
    {
      OutputSettings localOutputSettings = (OutputSettings)super.clone();
      localOutputSettings.charset(this.charset.name());
      localOutputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
      return localOutputSettings;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  CharsetEncoder encoder()
  {
    return this.charsetEncoder;
  }
  
  public OutputSettings escapeMode(Entities.EscapeMode paramEscapeMode)
  {
    this.escapeMode = paramEscapeMode;
    return this;
  }
  
  public Entities.EscapeMode escapeMode()
  {
    return this.escapeMode;
  }
  
  public int indentAmount()
  {
    return this.indentAmount;
  }
  
  public OutputSettings indentAmount(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool);
      this.indentAmount = paramInt;
      return this;
    }
  }
  
  public OutputSettings outline(boolean paramBoolean)
  {
    this.outline = paramBoolean;
    return this;
  }
  
  public boolean outline()
  {
    return this.outline;
  }
  
  public OutputSettings prettyPrint(boolean paramBoolean)
  {
    this.prettyPrint = paramBoolean;
    return this;
  }
  
  public boolean prettyPrint()
  {
    return this.prettyPrint;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/nodes/Document$OutputSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */