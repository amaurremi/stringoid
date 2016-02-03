package com.google.android.gms.internal;

public enum b
{
  private final String eC;
  
  static
  {
    bA = new b("CAMPAIGN_TRACK", 31, "campaign_track");
    bB = new b("CATEGORY", 32, "category");
    bC = new b("CHECK_VALIDATION", 33, "check_validation");
    bD = new b("CLEAR_PERSISTENT_DATA_LAYER_PREFIX", 34, "clear_data_layer_prefix");
    bE = new b("CLICK_ID", 35, "click_id");
    bF = new b("CLIENT_INFO", 36, "client_info");
    bG = new b("COMPANY", 37, "company");
    bH = new b("COMPONENT", 38, "component");
    bI = new b("CONTENT_DESCRIPTION", 39, "content_description");
    bJ = new b("CONTENT_GROUP", 40, "content_group");
    bK = new b("CONVERSION_ID", 41, "conversion_id");
    bL = new b("COOKIE_DOMAIN", 42, "cookie_domain");
    bM = new b("COOKIE_EXPIRATION", 43, "cookie_expiration");
    bN = new b("COOKIE_NAME", 44, "cookie_name");
    bO = new b("COOKIE_PATH", 45, "cookie_path");
    bP = new b("COOKIE_PATH_COPY", 46, "cookie_path_copy");
    bQ = new b("COUNTRY", 47, "country");
    bR = new b("CURRENCY_CODE", 48, "currency_code");
    bS = new b("CUSTOM_VARS", 49, "custom_vars");
    bT = new b("CUSTOMER_ID", 50, "customer_id");
    bU = new b("DATA_LAYER_VERSION", 51, "data_layer_version");
    bV = new b("DATA_PROVIDER_ID", 52, "data_provider_id");
    bW = new b("DEBUG", 53, "debug");
    bX = new b("DECORATE_FORM", 54, "decorate_form");
    bY = new b("DECORATE_FORMS_AUTO_LINK", 55, "decorate_forms_auto_link");
    bZ = new b("DECORATE_LINK", 56, "decorate_link");
    ca = new b("DEFAULT_PAGES", 57, "default_pages");
    cb = new b("DEFAULT_VALUE", 58, "default_value");
    cc = new b("DEPENDENCIES", 59, "dependencies");
    cd = new b("DETECT_FLASH", 60, "detect_flash");
    ce = new b("DETECT_TITLE", 61, "detect_title");
    cf = new b("DIMENSION", 62, "dimension");
    cg = new b("DOMAIN_NAME", 63, "domain_name");
    ch = new b("DOUBLE_CLICK", 64, "double_click");
    ci = new b("ECOMMERCE_MACRO_DATA", 65, "ecommerce_macro_data");
    cj = new b("ECOMMERCE_USE_DATA_LAYER", 66, "ecommerce_use_data_layer");
    ck = new b("ELEMENT", 67, "element");
    cl = new b("EMAIL", 68, "email");
    cm = new b("EMPLOYEE_RANGE", 69, "employee_range");
    cn = new b("ENABLE_ECOMMERCE", 70, "enable_ecommerce");
    co = new b("ESCAPE", 71, "escape");
    cp = new b("EVENT_ACTION", 72, "event_action");
    cq = new b("EVENT_CATEGORY", 73, "event_category");
    cr = new b("EVENT_LABEL", 74, "event_label");
    cs = new b("EVENT_VALUE", 75, "event_value");
    ct = new b("EXCEPTION_DESCRIPTION", 76, "exception_description");
    cu = new b("EXCEPTION_FATAL", 77, "exception_fatal");
    cv = new b("FIELDS_TO_SET", 78, "fields_to_set");
    cw = new b("FORM_OBJECT", 79, "form_object");
    cx = new b("FUNCTION", 80, "function");
    cy = new b("FUNCTION_CALL_NAME", 81, "function_call_macro_name");
    cz = new b("GROUP", 82, "group");
    cA = new b("HIT_CALLBACK", 83, "hit_callback");
    cB = new b("HTML", 84, "html");
    cC = new b("ID", 85, "id");
    cD = new b("IGNORED_ORGANIC", 86, "ignored_organic");
    cE = new b("IGNORED_REF", 87, "ignored_ref");
    cF = new b("IGNORE_CASE", 88, "ignore_case");
    cG = new b("INPUT", 89, "input");
    cH = new b("INPUT_FORMAT", 90, "input_format");
    cI = new b("INSTANCE_NAME", 91, "instance_name");
    cJ = new b("INSTANCE_LABEL", 92, "instance_label");
    cK = new b("INTERVAL", 93, "interval");
    cL = new b("ITEM_SEPARATOR", 94, "item_separator");
    cM = new b("JAVASCRIPT", 95, "javascript");
    cN = new b("KEYWORD", 96, "keyword");
    cO = new b("KEY_VALUE_SEPARATOR", 97, "key_value_separator");
    cP = new b("LABEL", 98, "label");
    cQ = new b("LANGUAGE", 99, "language");
    cR = new b("LIMIT", 100, "limit");
    cS = new b("LINK", 101, "link");
    cT = new b("LINK_BY_POST", 102, "link_by_post");
    cU = new b("LINK_ID", 103, "link_id");
    cV = new b("LIVE_ONLY", 104, "live_only");
    cW = new b("LOCAL_GIF_PATH", 105, "local_gif_path");
    cX = new b("LOCATION", 106, "location");
    cY = new b("MAP", 107, "map");
    cZ = new b("MAX", 108, "max");
    da = new b("MIN", 109, "min");
    db = new b("METRIC", 110, "metric");
    dc = new b("NAME", 111, "name");
    dd = new b("NAMESPACE_CODE", 112, "namespace_code");
    de = new b("NAMESPACE_ID", 113, "namespace_id");
    df = new b("NAMESPACE_VALUE", 114, "namespace_value");
    dg = new b("NONINTERACTION", 115, "noninteraction");
    dh = new b("NOT_DEFAULT_MACRO", 116, "not_default_macro");
    di = new b("NO_PADDING", 117, "no_padding");
    dj = new b("NUMBER", 118, "number");
    dk = new b("OPTOUT", 119, "optout");
    dl = new b("ORDER", 120, "order");
    dm = new b("ORDER_ID", 121, "order_id");
    dn = new b("ORDER_VALUE", 122, "order_value");
    do = new b("ORDINAL", 123, "ordinal");
    dp = new b("ORGANIC", 124, "organic");
    dq = new b("OUTPUT_FORMAT", 125, "output_format");
    dr = new b("PAGE", 126, "page");
    ds = new b("PAGE_PATH", 127, "page_path");
    dt = new b("PARTITION", 128, "partition");
    du = new b("PIXEL", 129, "pixel");
    dv = new b("PLATFORM", 130, "platform");
    dw = new b("PRICES", 131, "prices");
    dx = new b("PRIORITY", 132, "priority");
    dy = new b("PRODUCT", 133, "product");
    dz = new b("PRODUCT_ID", 134, "product_id");
    dA = new b("PRODUCT_IDS", 135, "product_ids");
    dB = new b("PUSH_AFTER_EVALUATE", 136, "push_after_evaluate");
    dC = new b("QUANTITY", 137, "quantity");
    dD = new b("QUERY_KEY", 138, "query_key");
    dE = new b("REFERRER", 139, "referrer");
    dF = new b("REFERRER_OVERRIDE", 140, "referrer_override");
    dG = new b("REVENUE", 141, "revenue");
    dH = new b("SAMPLE_RATE", 142, "sample_rate");
    dI = new b("SEND_HITS_TO_GOOGLE", 143, "send_hits_to_google");
    dJ = new b("SESSION_CONTROL", 144, "session_control");
    dK = new b("SESSION_COOKIE_TIMEOUT", 145, "session_cookie_timeout");
    dL = new b("SITE_SPEED_SAMPLE_RATE", 146, "site_speed_sample_rate");
    dM = new b("SOCIAL_ACTION", 147, "social_action");
    dN = new b("SOCIAL_ACTION_TARGET", 148, "social_action_target");
    dO = new b("SOCIAL_NETWORK", 149, "social_network");
    dP = new b("SOCIAL_USE_DATA_LAYER", 150, "social_use_data_layer");
    dQ = new b("SERVER_SIDE", 151, "server_side");
    dR = new b("STANDARD_INDUSTRIAL_CLASSIFICATION", 152, "standard_industrial_classification");
    dS = new b("STRIP_WWW", 153, "strip_www");
    dT = new b("TAG_ID", 154, "tag_id");
    dU = new b("TARGET_URL", 155, "target_url");
    dV = new b("TIMING_CATEGORY", 156, "timing_category");
    dW = new b("TIMING_LABEL", 157, "timing_label");
    dX = new b("TIMING_SAMPLE_RATE", 158, "timing_sample_rate");
    dY = new b("TIMING_VALUE", 159, "timing_value");
    dZ = new b("TIMING_VAR", 160, "timing_var");
    ea = new b("TITLE", 161, "title");
    eb = new b("TRACK_APPVIEW", 162, "track_appview");
    ec = new b("TRACK_EVENT", 163, "track_event");
    ed = new b("TRACK_EXCEPTION", 164, "track_exception");
    ee = new b("TRACK_SOCIAL", 165, "track_social");
    ef = new b("TRACK_TIMING", 166, "track_timing");
    eg = new b("TRACK_TRANSACTION", 167, "track_transaction");
    eh = new b("TRACKER_NAME", 168, "tracker_name");
    ei = new b("TRANSACTION_DATALAYER_MAP", 169, "transaction_datalayer_map");
    ej = new b("TRANSACTION_ID", 170, "transaction_id");
    ek = new b("TRANSACTION_ITEM_DATALAYER_MAP", 171, "transaction_item_datalayer_map");
    el = new b("TRANSACTION_VARIABLE", 172, "transaction_variable");
    em = new b("TYPE", 173, "type");
    en = new b("UNREPEATABLE", 174, "unrepeatable");
    eo = new b("URL", 175, "url");
    ep = new b("USE_DATA_LAYER", 176, "use_data_layer");
    eq = new b("USE_HASH", 177, "use_hash");
    er = new b("USE_IFRAME", 178, "use_iframe");
    es = new b("USE_IMAGE_TAG", 179, "use_image_tag");
    et = new b("USE_POSTSCRIBE", 180, "use_postscribe");
    eu = new b("USER_ID", 181, "user_id");
    ev = new b("USER_VARIABLE", 182, "user_variable");
    ew = new b("VALUE", 183, "value");
    ex = new b("VALUE_IN_DOLLARS", 184, "value_in_dollars");
    ey = new b("VISITOR_COOKIE_TIMEOUT", 185, "visitor_cookie_timeout");
    ez = new b("WAIT_FOR_TAGS", 186, "wait_for_tags");
  }
  
  private b(String paramString)
  {
    this.eC = paramString;
  }
  
  public String toString()
  {
    return this.eC;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */