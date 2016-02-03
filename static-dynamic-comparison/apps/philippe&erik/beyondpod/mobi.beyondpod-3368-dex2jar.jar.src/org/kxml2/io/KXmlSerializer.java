package org.kxml2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

public class KXmlSerializer
  implements XmlSerializer
{
  private int auto;
  private int depth;
  private String[] elementStack = new String[12];
  private String encoding;
  private boolean[] indent = new boolean[4];
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private boolean pending;
  private boolean unicode;
  private Writer writer;
  
  private final void check(boolean paramBoolean)
    throws IOException
  {
    if (!this.pending) {
      return;
    }
    this.depth += 1;
    this.pending = false;
    if (this.indent.length <= this.depth)
    {
      localObject = new boolean[this.depth + 4];
      System.arraycopy(this.indent, 0, localObject, 0, this.depth);
      this.indent = ((boolean[])localObject);
    }
    this.indent[this.depth] = this.indent[(this.depth - 1)];
    int i = this.nspCounts[(this.depth - 1)];
    if (i < this.nspCounts[this.depth])
    {
      this.writer.write(32);
      this.writer.write("xmlns");
      if (!"".equals(this.nspStack[(i * 2)]))
      {
        this.writer.write(58);
        this.writer.write(this.nspStack[(i * 2)]);
      }
      while ((!"".equals(getNamespace())) || ("".equals(this.nspStack[(i * 2 + 1)])))
      {
        this.writer.write("=\"");
        writeEscaped(this.nspStack[(i * 2 + 1)], 34);
        this.writer.write(34);
        i += 1;
        break;
      }
      throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
    }
    if (this.nspCounts.length <= this.depth + 1)
    {
      localObject = new int[this.depth + 8];
      System.arraycopy(this.nspCounts, 0, localObject, 0, this.depth + 1);
      this.nspCounts = ((int[])localObject);
    }
    this.nspCounts[(this.depth + 1)] = this.nspCounts[this.depth];
    Writer localWriter = this.writer;
    if (paramBoolean) {}
    for (Object localObject = " />";; localObject = ">")
    {
      localWriter.write((String)localObject);
      return;
    }
  }
  
  private final String getPrefix(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    int i = this.nspCounts[(this.depth + 1)] * 2 - 2;
    Object localObject;
    int j;
    if (i >= 0) {
      if ((this.nspStack[(i + 1)].equals(paramString)) && ((paramBoolean1) || (!this.nspStack[i].equals(""))))
      {
        localObject = this.nspStack[i];
        j = i + 2;
        label72:
        if (j >= this.nspCounts[(this.depth + 1)] * 2) {
          break label279;
        }
        if (this.nspStack[j].equals(localObject)) {
          localObject = null;
        }
      }
    }
    label178:
    label279:
    for (;;)
    {
      if (localObject != null)
      {
        return (String)localObject;
        j += 1;
        break label72;
      }
      i -= 2;
      break;
      if (!paramBoolean2) {
        return null;
      }
      if ("".equals(paramString))
      {
        localObject = "";
        paramBoolean1 = this.pending;
        this.pending = false;
        setPrefix((String)localObject, paramString);
        this.pending = paramBoolean1;
        return (String)localObject;
      }
      localObject = new StringBuffer().append("n");
      i = this.auto;
      this.auto = (i + 1);
      String str = i;
      i = this.nspCounts[(this.depth + 1)] * 2 - 2;
      for (;;)
      {
        localObject = str;
        if (i >= 0)
        {
          if (str.equals(this.nspStack[i])) {
            localObject = null;
          }
        }
        else
        {
          if (localObject == null) {
            break label178;
          }
          break;
        }
        i -= 2;
      }
    }
  }
  
  private final void writeEscaped(String paramString, int paramInt)
    throws IOException
  {
    int i = 0;
    if (i < paramString.length())
    {
      int j = paramString.charAt(i);
      switch (j)
      {
      default: 
        label92:
        if ((j >= 32) && (j != 64) && ((j < 127) || (this.unicode))) {
          this.writer.write(j);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == -1)
        {
          this.writer.write(j);
        }
        else
        {
          this.writer.write("&#" + j + ';');
          continue;
          this.writer.write("&amp;");
          continue;
          this.writer.write("&gt;");
          continue;
          this.writer.write("&lt;");
          continue;
          if (j != paramInt) {
            break label92;
          }
          Writer localWriter = this.writer;
          if (j == 34) {}
          for (String str = "&quot;";; str = "&apos;")
          {
            localWriter.write(str);
            break;
          }
          this.writer.write("&#" + j + ";");
        }
      }
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    if (!this.pending) {
      throw new IllegalStateException("illegal position for attribute");
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    if ("".equals(str))
    {
      paramString1 = "";
      this.writer.write(32);
      if (!"".equals(paramString1))
      {
        this.writer.write(paramString1);
        this.writer.write(58);
      }
      this.writer.write(paramString2);
      this.writer.write(61);
      if (paramString3.indexOf('"') != -1) {
        break label146;
      }
    }
    label146:
    for (int i = 34;; i = 39)
    {
      this.writer.write(i);
      writeEscaped(paramString3, i);
      this.writer.write(i);
      return this;
      paramString1 = getPrefix(str, false, true);
      break;
    }
  }
  
  public void cdsect(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write("<![CDATA[");
    this.writer.write(paramString);
    this.writer.write("]]>");
  }
  
  public void comment(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write("<!--");
    this.writer.write(paramString);
    this.writer.write("-->");
  }
  
  public void docdecl(String paramString)
    throws IOException
  {
    this.writer.write("<!DOCTYPE");
    this.writer.write(paramString);
    this.writer.write(">");
  }
  
  public void endDocument()
    throws IOException
  {
    while (this.depth > 0) {
      endTag(this.elementStack[(this.depth * 3 - 3)], this.elementStack[(this.depth * 3 - 1)]);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
    throws IOException
  {
    if (!this.pending) {
      this.depth -= 1;
    }
    if (((paramString1 == null) && (this.elementStack[(this.depth * 3)] != null)) || ((paramString1 != null) && (!paramString1.equals(this.elementStack[(this.depth * 3)]))) || (!this.elementStack[(this.depth * 3 + 2)].equals(paramString2))) {
      throw new IllegalArgumentException("</{" + paramString1 + "}" + paramString2 + "> does not match start");
    }
    if (this.pending)
    {
      check(true);
      this.depth -= 1;
    }
    for (;;)
    {
      this.nspCounts[(this.depth + 1)] = this.nspCounts[this.depth];
      return this;
      if (this.indent[(this.depth + 1)] != 0)
      {
        this.writer.write("\r\n");
        int i = 0;
        while (i < this.depth)
        {
          this.writer.write("  ");
          i += 1;
        }
      }
      this.writer.write("</");
      paramString1 = this.elementStack[(this.depth * 3 + 1)];
      if (!"".equals(paramString1))
      {
        this.writer.write(paramString1);
        this.writer.write(58);
      }
      this.writer.write(paramString2);
      this.writer.write(62);
    }
  }
  
  public void entityRef(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write(38);
    this.writer.write(paramString);
    this.writer.write(59);
  }
  
  public void flush()
    throws IOException
  {
    check(false);
    this.writer.flush();
  }
  
  public int getDepth()
  {
    if (this.pending) {
      return this.depth + 1;
    }
    return this.depth;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString)) {
      return this.indent[this.depth];
    }
    return false;
  }
  
  public String getName()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.elementStack[(getDepth() * 3 - 1)];
  }
  
  public String getNamespace()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.elementStack[(getDepth() * 3 - 3)];
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getPrefix(paramString, false, paramBoolean);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString.toString());
    }
  }
  
  public Object getProperty(String paramString)
  {
    throw new RuntimeException("Unsupported property");
  }
  
  public void ignorableWhitespace(String paramString)
    throws IOException
  {
    text(paramString);
  }
  
  public void processingInstruction(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write("<?");
    this.writer.write(paramString);
    this.writer.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString))
    {
      this.indent[this.depth] = paramBoolean;
      return;
    }
    throw new RuntimeException("Unsupported Feature");
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException();
    }
    if (paramString == null) {}
    for (paramOutputStream = new OutputStreamWriter(paramOutputStream);; paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString))
    {
      setOutput(paramOutputStream);
      this.encoding = paramString;
      if ((paramString != null) && (paramString.toLowerCase().startsWith("utf"))) {
        this.unicode = true;
      }
      return;
    }
  }
  
  public void setOutput(Writer paramWriter)
  {
    this.writer = paramWriter;
    this.nspCounts[0] = 2;
    this.nspCounts[1] = 2;
    this.nspStack[0] = "";
    this.nspStack[1] = "";
    this.nspStack[2] = "xml";
    this.nspStack[3] = "http://www.w3.org/XML/1998/namespace";
    this.pending = false;
    this.auto = 0;
    this.depth = 0;
    this.unicode = false;
  }
  
  public void setPrefix(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (str.equals(getPrefix(paramString1, true, false))) {
      return;
    }
    paramString2 = this.nspCounts;
    int i = this.depth + 1;
    int j = paramString2[i];
    paramString2[i] = (j + 1);
    i = j << 1;
    if (this.nspStack.length < i + 1)
    {
      paramString2 = new String[this.nspStack.length + 16];
      System.arraycopy(this.nspStack, 0, paramString2, 0, i);
      this.nspStack = paramString2;
    }
    this.nspStack[i] = str;
    this.nspStack[(i + 1)] = paramString1;
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    throw new RuntimeException("Unsupported Property:" + paramObject);
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
    throws IOException
  {
    this.writer.write("<?xml version='1.0' ");
    if (paramString != null)
    {
      this.encoding = paramString;
      if (paramString.toLowerCase().startsWith("utf")) {
        this.unicode = true;
      }
    }
    if (this.encoding != null)
    {
      this.writer.write("encoding='");
      this.writer.write(this.encoding);
      this.writer.write("' ");
    }
    Writer localWriter;
    if (paramBoolean != null)
    {
      this.writer.write("standalone='");
      localWriter = this.writer;
      if (!paramBoolean.booleanValue()) {
        break label129;
      }
    }
    label129:
    for (paramString = "yes";; paramString = "no")
    {
      localWriter.write(paramString);
      this.writer.write("' ");
      this.writer.write("?>");
      return;
    }
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    if (this.indent[this.depth] != 0)
    {
      this.writer.write("\r\n");
      i = 0;
      while (i < this.depth)
      {
        this.writer.write("  ");
        i += 1;
      }
    }
    int j = this.depth * 3;
    Object localObject;
    if (this.elementStack.length < j + 3)
    {
      localObject = new String[this.elementStack.length + 12];
      System.arraycopy(this.elementStack, 0, localObject, 0, j);
      this.elementStack = ((String[])localObject);
    }
    if (paramString1 == null)
    {
      localObject = "";
      if ("".equals(paramString1)) {
        i = this.nspCounts[this.depth];
      }
    }
    else
    {
      for (;;)
      {
        if (i >= this.nspCounts[(this.depth + 1)]) {
          break label209;
        }
        if (("".equals(this.nspStack[(i * 2)])) && (!"".equals(this.nspStack[(i * 2 + 1)])))
        {
          throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
          localObject = getPrefix(paramString1, true, true);
          break;
        }
        i += 1;
      }
    }
    label209:
    String[] arrayOfString = this.elementStack;
    int i = j + 1;
    arrayOfString[j] = paramString1;
    this.elementStack[i] = localObject;
    this.elementStack[(i + 1)] = paramString2;
    this.writer.write(60);
    if (!"".equals(localObject))
    {
      this.writer.write((String)localObject);
      this.writer.write(58);
    }
    this.writer.write(paramString2);
    this.pending = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
    throws IOException
  {
    check(false);
    this.indent[this.depth] = false;
    writeEscaped(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    text(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/org/kxml2/io/KXmlSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */