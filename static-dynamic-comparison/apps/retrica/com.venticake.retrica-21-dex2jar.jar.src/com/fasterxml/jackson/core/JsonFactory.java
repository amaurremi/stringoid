package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.net.URL;

public class JsonFactory
  implements Serializable
{
  protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = ;
  protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();
  protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
  private static final SerializableString DEFAULT_ROOT_VALUE_SEPARATOR = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
  protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef = new ThreadLocal();
  protected int _factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
  protected int _generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
  protected InputDecorator _inputDecorator;
  protected ObjectCodec _objectCodec;
  protected int _parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
  protected final transient BytesToNameCanonicalizer _rootByteSymbols = BytesToNameCanonicalizer.createRoot();
  protected final transient CharsToNameCanonicalizer _rootCharSymbols = CharsToNameCanonicalizer.createRoot();
  protected SerializableString _rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
  
  public JsonFactory()
  {
    this(null);
  }
  
  public JsonFactory(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
  }
  
  protected IOContext _createContext(Object paramObject, boolean paramBoolean)
  {
    return new IOContext(_getBufferRecycler(), paramObject, paramBoolean);
  }
  
  @Deprecated
  protected JsonParser _createJsonParser(InputStream paramInputStream, IOContext paramIOContext)
  {
    return new ByteSourceJsonBootstrapper(paramIOContext, paramInputStream).constructParser(this._parserFeatures, this._objectCodec, this._rootByteSymbols, this._rootCharSymbols, isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES), isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES));
  }
  
  protected JsonParser _createParser(InputStream paramInputStream, IOContext paramIOContext)
  {
    return _createJsonParser(paramInputStream, paramIOContext);
  }
  
  public BufferRecycler _getBufferRecycler()
  {
    Object localObject1 = (SoftReference)_recyclerRef.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (BufferRecycler)((SoftReference)localObject1).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new BufferRecycler();
        _recyclerRef.set(new SoftReference(localObject2));
      }
      return (BufferRecycler)localObject2;
    }
  }
  
  protected InputStream _optimizedStreamFromURL(URL paramURL)
  {
    if ("file".equals(paramURL.getProtocol()))
    {
      String str = paramURL.getHost();
      if ((str == null) || (str.length() == 0)) {
        return new FileInputStream(paramURL.getPath());
      }
    }
    return paramURL.openStream();
  }
  
  public final JsonFactory configure(JsonParser.Feature paramFeature, boolean paramBoolean)
  {
    if (paramBoolean) {
      return enable(paramFeature);
    }
    return disable(paramFeature);
  }
  
  public JsonParser createJsonParser(InputStream paramInputStream)
  {
    IOContext localIOContext = _createContext(paramInputStream, false);
    InputStream localInputStream = paramInputStream;
    if (this._inputDecorator != null) {
      localInputStream = this._inputDecorator.decorate(localIOContext, paramInputStream);
    }
    return _createParser(localInputStream, localIOContext);
  }
  
  public JsonParser createJsonParser(URL paramURL)
  {
    IOContext localIOContext = _createContext(paramURL, true);
    InputStream localInputStream = _optimizedStreamFromURL(paramURL);
    paramURL = localInputStream;
    if (this._inputDecorator != null) {
      paramURL = this._inputDecorator.decorate(localIOContext, localInputStream);
    }
    return _createParser(paramURL, localIOContext);
  }
  
  public JsonParser createParser(InputStream paramInputStream)
  {
    return createJsonParser(paramInputStream);
  }
  
  public JsonFactory disable(JsonParser.Feature paramFeature)
  {
    this._parserFeatures &= (paramFeature.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public JsonFactory enable(JsonParser.Feature paramFeature)
  {
    this._parserFeatures |= paramFeature.getMask();
    return this;
  }
  
  public ObjectCodec getCodec()
  {
    return this._objectCodec;
  }
  
  public final boolean isEnabled(JsonFactory.Feature paramFeature)
  {
    return (this._factoryFeatures & paramFeature.getMask()) != 0;
  }
  
  public JsonFactory setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/JsonFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */