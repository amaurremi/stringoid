package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.Schema;
import java.io.IOException;

public abstract interface DatumWriter<D>
{
  public abstract void setSchema(Schema paramSchema);
  
  public abstract void write(D paramD, Encoder paramEncoder)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/DatumWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */