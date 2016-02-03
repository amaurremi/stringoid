package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.util.BufferAllocator;
import com.amazonaws.javax.xml.stream.util.ThreadLocalBufferAllocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import java.io.InputStream;
import java.io.Reader;

public class Entity$ScannedEntity
  extends Entity
{
  public char[] ch = null;
  public int columnNumber = 1;
  public int count;
  public String encoding;
  public XMLResourceIdentifier entityLocation;
  public int fBufferSize = 8192;
  public int fLastCount;
  public int fTotalCountTillLastLoad;
  public boolean isExternal;
  public int lineNumber = 1;
  public boolean literal;
  public boolean mayReadChunks;
  public int position;
  public Reader reader;
  public InputStream stream;
  public String version;
  
  public Entity$ScannedEntity(String paramString1, XMLResourceIdentifier paramXMLResourceIdentifier, InputStream paramInputStream, Reader paramReader, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.name = paramString1;
    this.entityLocation = paramXMLResourceIdentifier;
    this.stream = paramInputStream;
    this.reader = paramReader;
    this.encoding = paramString2;
    this.literal = paramBoolean1;
    this.mayReadChunks = paramBoolean2;
    this.isExternal = paramBoolean3;
    if (paramBoolean3) {}
    for (int i = this.fBufferSize;; i = 1024)
    {
      this.ch = ThreadLocalBufferAllocator.getBufferAllocator().getCharBuffer(i);
      if (this.ch == null) {
        this.ch = new char[i];
      }
      return;
    }
  }
  
  public void close()
  {
    ThreadLocalBufferAllocator.getBufferAllocator().returnCharBuffer(this.ch);
    this.ch = null;
    this.reader.close();
  }
  
  public final boolean isExternal()
  {
    return this.isExternal;
  }
  
  public final boolean isUnparsed()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("name=\"" + this.name + '"');
    localStringBuffer.append(",ch=" + new String(this.ch));
    localStringBuffer.append(",position=" + this.position);
    localStringBuffer.append(",count=" + this.count);
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/Entity$ScannedEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */