package org.codehaus.jackson.impl;

import org.codehaus.jackson.JsonGenerator;

public abstract interface Indenter
{
  public abstract boolean isInline();
  
  public abstract void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/impl/Indenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */