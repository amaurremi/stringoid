package com.flurry.org.codehaus.jackson.impl;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;

public abstract interface Indenter
{
  public abstract boolean isInline();
  
  public abstract void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/impl/Indenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */