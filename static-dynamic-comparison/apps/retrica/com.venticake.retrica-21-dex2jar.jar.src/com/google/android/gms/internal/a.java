package com.google.android.gms.internal;

public enum a
{
  private final String name;
  
  static
  {
    A = new a("CONSTANT", 6, "_c");
    B = new a("COOKIE", 7, "_k");
    C = new a("CUSTOM_VAR", 8, "_v");
    D = new a("CONTAINER_VERSION", 9, "_ctv");
    E = new a("DEBUG_MODE", 10, "_dbg");
    F = new a("DEVICE_NAME", 11, "_dn");
    G = new a("DEVICE_TYPE", 12, "_dt");
    H = new a("DOM_ELEMENT", 13, "_d");
    I = new a("EVENT", 14, "_e");
    J = new a("FUNCTION_CALL", 15, "_func");
    K = new a("JS_GLOBAL", 16, "_j");
    L = new a("LANGUAGE", 17, "_l");
    M = new a("OS_VERSION", 18, "_ov");
    N = new a("PLATFORM", 19, "_p");
    O = new a("RANDOM", 20, "_r");
    P = new a("REFERRER", 21, "_f");
    Q = new a("RESOLUTION", 22, "_rs");
    R = new a("RUNTIME_VERSION", 23, "_rv");
    S = new a("SDK_VERSION", 24, "_sv");
    T = new a("SIMPLE_MAP", 25, "_smm");
    U = new a("TIME", 26, "_t");
    V = new a("URL", 27, "_u");
    W = new a("ADWORDS_CLICK_REFERRER", 28, "_awcr");
    X = new a("DEVICE_ID", 29, "_did");
    Y = new a("ENCODE", 30, "_enc");
    Z = new a("GTM_VERSION", 31, "_gtmv");
    aa = new a("HASH", 32, "_hsh");
    ab = new a("INSTALL_REFERRER", 33, "_ir");
    ac = new a("JOINER", 34, "_jn");
    ad = new a("MOBILE_ADWORDS_UNIQUE_ID", 35, "_awid");
    ae = new a("REGEX_GROUP", 36, "_reg");
    af = new a("DATA_LAYER_WRITE", 37, "_dlw");
    ag = new a("REGEX", 38, "_re");
    ah = new a("STARTS_WITH", 39, "_sw");
    ai = new a("ENDS_WITH", 40, "_ew");
    aj = new a("CONTAINS", 41, "_cn");
    ak = new a("EQUALS", 42, "_eq");
    al = new a("LESS_THAN", 43, "_lt");
    am = new a("LESS_EQUALS", 44, "_le");
    an = new a("GREATER_THAN", 45, "_gt");
    ao = new a("GREATER_EQUALS", 46, "_ge");
    ap = new a("ARBITRARY_PIXEL", 47, "_img");
    aq = new a("ARBITRARY_HTML", 48, "_html");
    ar = new a("GOOGLE_TAG_MANAGER", 49, "_gtm");
    as = new a("GOOGLE_ANALYTICS", 50, "_ga");
    at = new a("ADWORDS_CONVERSION", 51, "_awct");
    au = new a("SMART_PIXEL", 52, "_sp");
    av = new a("FLOODLIGHT_COUNTER", 53, "_flc");
    aw = new a("FLOODLIGHT_SALES", 54, "_fls");
    ax = new a("BIZO_INSIGHT", 55, "_bzi");
    ay = new a("QUANTCAST_MEASUREMENT", 56, "_qcm");
    az = new a("TARGUS_ADVISOR", 57, "_ta");
  }
  
  private a(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */