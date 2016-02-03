package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter
  implements Closeable, Flushable
{
  private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
  private static final String[] REPLACEMENT_CHARS = new String[''];
  private String deferredName;
  private boolean htmlSafe;
  private String indent;
  private boolean lenient;
  private final Writer out;
  private String separator;
  private boolean serializeNulls;
  private final List<JsonScope> stack = new ArrayList();
  
  static
  {
    int i = 0;
    while (i <= 31)
    {
      REPLACEMENT_CHARS[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    REPLACEMENT_CHARS[34] = "\\\"";
    REPLACEMENT_CHARS[92] = "\\\\";
    REPLACEMENT_CHARS[9] = "\\t";
    REPLACEMENT_CHARS[8] = "\\b";
    REPLACEMENT_CHARS[10] = "\\n";
    REPLACEMENT_CHARS[13] = "\\r";
    REPLACEMENT_CHARS[12] = "\\f";
    HTML_SAFE_REPLACEMENT_CHARS = (String[])REPLACEMENT_CHARS.clone();
    HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
    HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
    HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
    HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
    HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
  }
  
  public JsonWriter(Writer paramWriter)
  {
    this.stack.add(JsonScope.EMPTY_DOCUMENT);
    this.separator = ":";
    this.serializeNulls = true;
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    this.out = paramWriter;
  }
  
  private void beforeName()
  {
    JsonScope localJsonScope = peek();
    if (localJsonScope == JsonScope.NONEMPTY_OBJECT) {
      this.out.write(44);
    }
    while (localJsonScope == JsonScope.EMPTY_OBJECT)
    {
      newline();
      replaceTop(JsonScope.DANGLING_NAME);
      return;
    }
    throw new IllegalStateException("Nesting problem: " + this.stack);
  }
  
  private void beforeValue(boolean paramBoolean)
  {
    switch (JsonWriter.1.$SwitchMap$com$google$gson$stream$JsonScope[peek().ordinal()])
    {
    default: 
      throw new IllegalStateException("Nesting problem: " + this.stack);
    case 1: 
      if (!this.lenient) {
        throw new IllegalStateException("JSON must have only one top-level value.");
      }
    case 2: 
      if ((!this.lenient) && (!paramBoolean)) {
        throw new IllegalStateException("JSON must start with an array or an object.");
      }
      replaceTop(JsonScope.NONEMPTY_DOCUMENT);
      return;
    case 3: 
      replaceTop(JsonScope.NONEMPTY_ARRAY);
      newline();
      return;
    case 4: 
      this.out.append(',');
      newline();
      return;
    }
    this.out.append(this.separator);
    replaceTop(JsonScope.NONEMPTY_OBJECT);
  }
  
  private JsonWriter close(JsonScope paramJsonScope1, JsonScope paramJsonScope2, String paramString)
  {
    JsonScope localJsonScope = peek();
    if ((localJsonScope != paramJsonScope2) && (localJsonScope != paramJsonScope1)) {
      throw new IllegalStateException("Nesting problem: " + this.stack);
    }
    if (this.deferredName != null) {
      throw new IllegalStateException("Dangling name: " + this.deferredName);
    }
    this.stack.remove(this.stack.size() - 1);
    if (localJsonScope == paramJsonScope2) {
      newline();
    }
    this.out.write(paramString);
    return this;
  }
  
  private void newline()
  {
    if (this.indent == null) {}
    for (;;)
    {
      return;
      this.out.write("\n");
      int i = 1;
      while (i < this.stack.size())
      {
        this.out.write(this.indent);
        i += 1;
      }
    }
  }
  
  private JsonWriter open(JsonScope paramJsonScope, String paramString)
  {
    beforeValue(true);
    this.stack.add(paramJsonScope);
    this.out.write(paramString);
    return this;
  }
  
  private JsonScope peek()
  {
    int i = this.stack.size();
    if (i == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    return (JsonScope)this.stack.get(i - 1);
  }
  
  private void replaceTop(JsonScope paramJsonScope)
  {
    this.stack.set(this.stack.size() - 1, paramJsonScope);
  }
  
  private void string(String paramString)
  {
    int j = 0;
    if (this.htmlSafe) {}
    int m;
    int i;
    int n;
    int k;
    for (String[] arrayOfString = HTML_SAFE_REPLACEMENT_CHARS;; arrayOfString = REPLACEMENT_CHARS)
    {
      this.out.write("\"");
      m = paramString.length();
      i = 0;
      for (;;)
      {
        if (i >= m) {
          break label153;
        }
        n = paramString.charAt(i);
        if (n >= 128) {
          break;
        }
        String str2 = arrayOfString[n];
        str1 = str2;
        if (str2 != null) {
          break label101;
        }
        k = j;
        i += 1;
        j = k;
      }
    }
    if (n == 8232) {}
    for (String str1 = "\\u2028";; str1 = "\\u2029")
    {
      label101:
      if (j < i) {
        this.out.write(paramString, j, i - j);
      }
      this.out.write(str1);
      k = i + 1;
      break;
      k = j;
      if (n != 8233) {
        break;
      }
    }
    label153:
    if (j < m) {
      this.out.write(paramString, j, m - j);
    }
    this.out.write("\"");
  }
  
  private void writeDeferredName()
  {
    if (this.deferredName != null)
    {
      beforeName();
      string(this.deferredName);
      this.deferredName = null;
    }
  }
  
  public JsonWriter beginArray()
  {
    writeDeferredName();
    return open(JsonScope.EMPTY_ARRAY, "[");
  }
  
  public JsonWriter beginObject()
  {
    writeDeferredName();
    return open(JsonScope.EMPTY_OBJECT, "{");
  }
  
  public void close()
  {
    this.out.close();
    int i = this.stack.size();
    if ((i > 1) || ((i == 1) && (this.stack.get(i - 1) != JsonScope.NONEMPTY_DOCUMENT))) {
      throw new IOException("Incomplete document");
    }
    this.stack.clear();
  }
  
  public JsonWriter endArray()
  {
    return close(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, "]");
  }
  
  public JsonWriter endObject()
  {
    return close(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, "}");
  }
  
  public void flush()
  {
    if (this.stack.isEmpty()) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.out.flush();
  }
  
  public final boolean getSerializeNulls()
  {
    return this.serializeNulls;
  }
  
  public final boolean isHtmlSafe()
  {
    return this.htmlSafe;
  }
  
  public boolean isLenient()
  {
    return this.lenient;
  }
  
  public JsonWriter name(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (this.deferredName != null) {
      throw new IllegalStateException();
    }
    if (this.stack.isEmpty()) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.deferredName = paramString;
    return this;
  }
  
  public JsonWriter nullValue()
  {
    if (this.deferredName != null)
    {
      if (this.serializeNulls) {
        writeDeferredName();
      }
    }
    else
    {
      beforeValue(false);
      this.out.write("null");
      return this;
    }
    this.deferredName = null;
    return this;
  }
  
  public final void setHtmlSafe(boolean paramBoolean)
  {
    this.htmlSafe = paramBoolean;
  }
  
  public final void setIndent(String paramString)
  {
    if (paramString.length() == 0)
    {
      this.indent = null;
      this.separator = ":";
      return;
    }
    this.indent = paramString;
    this.separator = ": ";
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    this.lenient = paramBoolean;
  }
  
  public final void setSerializeNulls(boolean paramBoolean)
  {
    this.serializeNulls = paramBoolean;
  }
  
  public JsonWriter value(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramDouble);
    }
    writeDeferredName();
    beforeValue(false);
    this.out.append(Double.toString(paramDouble));
    return this;
  }
  
  public JsonWriter value(long paramLong)
  {
    writeDeferredName();
    beforeValue(false);
    this.out.write(Long.toString(paramLong));
    return this;
  }
  
  public JsonWriter value(Number paramNumber)
  {
    if (paramNumber == null) {
      return nullValue();
    }
    writeDeferredName();
    String str = paramNumber.toString();
    if ((!this.lenient) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
    }
    beforeValue(false);
    this.out.append(str);
    return this;
  }
  
  public JsonWriter value(String paramString)
  {
    if (paramString == null) {
      return nullValue();
    }
    writeDeferredName();
    beforeValue(false);
    string(paramString);
    return this;
  }
  
  public JsonWriter value(boolean paramBoolean)
  {
    writeDeferredName();
    beforeValue(false);
    Writer localWriter = this.out;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/stream/JsonWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */