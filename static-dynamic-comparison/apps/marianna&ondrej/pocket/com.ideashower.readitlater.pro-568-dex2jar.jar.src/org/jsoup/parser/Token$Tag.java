package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

abstract class Token$Tag
  extends Token
{
  Attributes attributes;
  private String pendingAttributeName;
  private StringBuilder pendingAttributeValue;
  boolean selfClosing = false;
  protected String tagName;
  
  Token$Tag()
  {
    super(null);
  }
  
  private final void ensureAttributeValue()
  {
    if (this.pendingAttributeValue == null) {
      this.pendingAttributeValue = new StringBuilder();
    }
  }
  
  void appendAttributeName(char paramChar)
  {
    appendAttributeName(String.valueOf(paramChar));
  }
  
  void appendAttributeName(String paramString)
  {
    if (this.pendingAttributeName == null) {}
    for (;;)
    {
      this.pendingAttributeName = paramString;
      return;
      paramString = this.pendingAttributeName.concat(paramString);
    }
  }
  
  void appendAttributeValue(char paramChar)
  {
    ensureAttributeValue();
    this.pendingAttributeValue.append(paramChar);
  }
  
  void appendAttributeValue(String paramString)
  {
    ensureAttributeValue();
    this.pendingAttributeValue.append(paramString);
  }
  
  void appendAttributeValue(char[] paramArrayOfChar)
  {
    ensureAttributeValue();
    this.pendingAttributeValue.append(paramArrayOfChar);
  }
  
  void appendTagName(char paramChar)
  {
    appendTagName(String.valueOf(paramChar));
  }
  
  void appendTagName(String paramString)
  {
    if (this.tagName == null) {}
    for (;;)
    {
      this.tagName = paramString;
      return;
      paramString = this.tagName.concat(paramString);
    }
  }
  
  void finaliseTag()
  {
    if (this.pendingAttributeName != null) {
      newAttribute();
    }
  }
  
  Attributes getAttributes()
  {
    return this.attributes;
  }
  
  boolean isSelfClosing()
  {
    return this.selfClosing;
  }
  
  String name()
  {
    if (this.tagName.length() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isFalse(bool);
      return this.tagName;
    }
  }
  
  Tag name(String paramString)
  {
    this.tagName = paramString;
    return this;
  }
  
  void newAttribute()
  {
    if (this.attributes == null) {
      this.attributes = new Attributes();
    }
    if (this.pendingAttributeName != null) {
      if (this.pendingAttributeValue != null) {
        break label83;
      }
    }
    label83:
    for (Attribute localAttribute = new Attribute(this.pendingAttributeName, "");; localAttribute = new Attribute(this.pendingAttributeName, this.pendingAttributeValue.toString()))
    {
      this.attributes.put(localAttribute);
      this.pendingAttributeName = null;
      if (this.pendingAttributeValue != null) {
        this.pendingAttributeValue.delete(0, this.pendingAttributeValue.length());
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/Token$Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */