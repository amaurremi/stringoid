package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

public final class TypeAdapters
{
  public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
  public static final TypeAdapter<BigInteger> BIG_INTEGER;
  public static final TypeAdapter<BitSet> BIT_SET;
  public static final TypeAdapterFactory BIT_SET_FACTORY;
  public static final TypeAdapter<Boolean> BOOLEAN;
  public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
  public static final TypeAdapterFactory BOOLEAN_FACTORY;
  public static final TypeAdapter<Number> BYTE;
  public static final TypeAdapterFactory BYTE_FACTORY;
  public static final TypeAdapter<Calendar> CALENDAR;
  public static final TypeAdapterFactory CALENDAR_FACTORY;
  public static final TypeAdapter<Character> CHARACTER;
  public static final TypeAdapterFactory CHARACTER_FACTORY;
  public static final TypeAdapter<Class> CLASS = new TypeAdapters.1();
  public static final TypeAdapterFactory CLASS_FACTORY = newFactory(Class.class, CLASS);
  public static final TypeAdapter<Number> DOUBLE;
  public static final TypeAdapterFactory ENUM_FACTORY = newEnumTypeHierarchyFactory();
  public static final TypeAdapter<Number> FLOAT;
  public static final TypeAdapter<InetAddress> INET_ADDRESS;
  public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
  public static final TypeAdapter<Number> INTEGER;
  public static final TypeAdapterFactory INTEGER_FACTORY;
  public static final TypeAdapter<JsonElement> JSON_ELEMENT;
  public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
  public static final TypeAdapter<Locale> LOCALE;
  public static final TypeAdapterFactory LOCALE_FACTORY;
  public static final TypeAdapter<Number> LONG;
  public static final TypeAdapter<Number> NUMBER;
  public static final TypeAdapterFactory NUMBER_FACTORY;
  public static final TypeAdapter<Number> SHORT;
  public static final TypeAdapterFactory SHORT_FACTORY;
  public static final TypeAdapter<String> STRING;
  public static final TypeAdapter<StringBuffer> STRING_BUFFER;
  public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
  public static final TypeAdapter<StringBuilder> STRING_BUILDER;
  public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
  public static final TypeAdapterFactory STRING_FACTORY;
  public static final TypeAdapterFactory TIMESTAMP_FACTORY;
  public static final TypeAdapter<URI> URI;
  public static final TypeAdapterFactory URI_FACTORY;
  public static final TypeAdapter<URL> URL;
  public static final TypeAdapterFactory URL_FACTORY;
  public static final TypeAdapter<UUID> UUID;
  public static final TypeAdapterFactory UUID_FACTORY;
  
  static
  {
    BIT_SET = new TypeAdapters.2();
    BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
    BOOLEAN = new TypeAdapters.3();
    BOOLEAN_AS_STRING = new TypeAdapters.4();
    BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
    BYTE = new TypeAdapters.5();
    BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
    SHORT = new TypeAdapters.6();
    SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
    INTEGER = new TypeAdapters.7();
    INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
    LONG = new TypeAdapters.8();
    FLOAT = new TypeAdapters.9();
    DOUBLE = new TypeAdapters.10();
    NUMBER = new TypeAdapters.11();
    NUMBER_FACTORY = newFactory(Number.class, NUMBER);
    CHARACTER = new TypeAdapters.12();
    CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
    STRING = new TypeAdapters.13();
    BIG_DECIMAL = new TypeAdapters.14();
    BIG_INTEGER = new TypeAdapters.15();
    STRING_FACTORY = newFactory(String.class, STRING);
    STRING_BUILDER = new TypeAdapters.16();
    STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
    STRING_BUFFER = new TypeAdapters.17();
    STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
    URL = new TypeAdapters.18();
    URL_FACTORY = newFactory(URL.class, URL);
    URI = new TypeAdapters.19();
    URI_FACTORY = newFactory(URI.class, URI);
    INET_ADDRESS = new TypeAdapters.20();
    INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
    UUID = new TypeAdapters.21();
    UUID_FACTORY = newFactory(UUID.class, UUID);
    TIMESTAMP_FACTORY = new TypeAdapters.22();
    CALENDAR = new TypeAdapters.23();
    CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
    LOCALE = new TypeAdapters.24();
    LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
    JSON_ELEMENT = new TypeAdapters.25();
    JSON_ELEMENT_FACTORY = newFactory(JsonElement.class, JSON_ELEMENT);
  }
  
  public static TypeAdapterFactory newEnumTypeHierarchyFactory()
  {
    return new TypeAdapters.26();
  }
  
  public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> paramTypeToken, TypeAdapter<TT> paramTypeAdapter)
  {
    return new TypeAdapters.27(paramTypeToken, paramTypeAdapter);
  }
  
  public static <TT> TypeAdapterFactory newFactory(Class<TT> paramClass, TypeAdapter<TT> paramTypeAdapter)
  {
    return new TypeAdapters.28(paramClass, paramTypeAdapter);
  }
  
  public static <TT> TypeAdapterFactory newFactory(Class<TT> paramClass1, Class<TT> paramClass2, TypeAdapter<? super TT> paramTypeAdapter)
  {
    return new TypeAdapters.29(paramClass1, paramClass2, paramTypeAdapter);
  }
  
  public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> paramClass, Class<? extends TT> paramClass1, TypeAdapter<? super TT> paramTypeAdapter)
  {
    return new TypeAdapters.30(paramClass, paramClass1, paramTypeAdapter);
  }
  
  public static <TT> TypeAdapterFactory newTypeHierarchyFactory(Class<TT> paramClass, TypeAdapter<TT> paramTypeAdapter)
  {
    return new TypeAdapters.31(paramClass, paramTypeAdapter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/internal/bind/TypeAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */