package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.Schema;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

public abstract interface FileReader<D>
  extends Iterator<D>, Iterable<D>, Closeable
{
  public abstract Schema getSchema();
  
  public abstract D next(D paramD)
    throws IOException;
  
  public abstract boolean pastSync(long paramLong)
    throws IOException;
  
  public abstract void sync(long paramLong)
    throws IOException;
  
  public abstract long tell()
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/FileReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */