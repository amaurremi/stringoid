package com.google.analytics.tracking.android;

import java.text.DecimalFormat;

class MetaModelInitializer
{
  private static final MetaModel.Formatter BOOLEAN_FORMATTER = new MetaModel.Formatter()
  {
    public String format(String paramAnonymousString)
    {
      if (Utils.safeParseBoolean(paramAnonymousString)) {
        return "1";
      }
      return "0";
    }
  };
  private static final MetaModel.Formatter UP_TO_TWO_DIGIT_FLOAT_FORMATTER = new MetaModel.Formatter()
  {
    private final DecimalFormat floatFormat = new DecimalFormat("0.##");
    
    public String format(String paramAnonymousString)
    {
      return this.floatFormat.format(Utils.safeParseDouble(paramAnonymousString));
    }
  };
  
  public static void set(MetaModel paramMetaModel)
  {
    paramMetaModel.addField("apiVersion", "v", null, null);
    paramMetaModel.addField("libraryVersion", "_v", null, null);
    paramMetaModel.addField("anonymizeIp", "aip", "0", BOOLEAN_FORMATTER);
    paramMetaModel.addField("trackingId", "tid", null, null);
    paramMetaModel.addField("hitType", "t", null, null);
    paramMetaModel.addField("sessionControl", "sc", null, null);
    paramMetaModel.addField("adSenseAdMobHitId", "a", null, null);
    paramMetaModel.addField("usage", "_u", null, null);
    paramMetaModel.addField("title", "dt", null, null);
    paramMetaModel.addField("referrer", "dr", null, null);
    paramMetaModel.addField("language", "ul", null, null);
    paramMetaModel.addField("encoding", "de", null, null);
    paramMetaModel.addField("page", "dp", null, null);
    paramMetaModel.addField("screenColors", "sd", null, null);
    paramMetaModel.addField("screenResolution", "sr", null, null);
    paramMetaModel.addField("viewportSize", "vp", null, null);
    paramMetaModel.addField("javaEnabled", "je", "1", BOOLEAN_FORMATTER);
    paramMetaModel.addField("flashVersion", "fl", null, null);
    paramMetaModel.addField("clientId", "cid", null, null);
    paramMetaModel.addField("campaignName", "cn", null, null);
    paramMetaModel.addField("campaignSource", "cs", null, null);
    paramMetaModel.addField("campaignMedium", "cm", null, null);
    paramMetaModel.addField("campaignKeyword", "ck", null, null);
    paramMetaModel.addField("campaignContent", "cc", null, null);
    paramMetaModel.addField("campaignId", "ci", null, null);
    paramMetaModel.addField("gclid", "gclid", null, null);
    paramMetaModel.addField("dclid", "dclid", null, null);
    paramMetaModel.addField("gmob_t", "gmob_t", null, null);
    paramMetaModel.addField("eventCategory", "ec", null, null);
    paramMetaModel.addField("eventAction", "ea", null, null);
    paramMetaModel.addField("eventLabel", "el", null, null);
    paramMetaModel.addField("eventValue", "ev", null, null);
    paramMetaModel.addField("nonInteraction", "ni", "0", BOOLEAN_FORMATTER);
    paramMetaModel.addField("socialNetwork", "sn", null, null);
    paramMetaModel.addField("socialAction", "sa", null, null);
    paramMetaModel.addField("socialTarget", "st", null, null);
    paramMetaModel.addField("appName", "an", null, null);
    paramMetaModel.addField("appVersion", "av", null, null);
    paramMetaModel.addField("description", "cd", null, null);
    paramMetaModel.addField("appId", "aid", null, null);
    paramMetaModel.addField("appInstallerId", "aiid", null, null);
    paramMetaModel.addField("transactionId", "ti", null, null);
    paramMetaModel.addField("transactionAffiliation", "ta", null, null);
    paramMetaModel.addField("transactionShipping", "ts", null, null);
    paramMetaModel.addField("transactionTotal", "tr", null, null);
    paramMetaModel.addField("transactionTax", "tt", null, null);
    paramMetaModel.addField("currencyCode", "cu", null, null);
    paramMetaModel.addField("itemPrice", "ip", null, null);
    paramMetaModel.addField("itemCode", "ic", null, null);
    paramMetaModel.addField("itemName", "in", null, null);
    paramMetaModel.addField("itemCategory", "iv", null, null);
    paramMetaModel.addField("itemQuantity", "iq", null, null);
    paramMetaModel.addField("exDescription", "exd", null, null);
    paramMetaModel.addField("exFatal", "exf", "1", BOOLEAN_FORMATTER);
    paramMetaModel.addField("timingVar", "utv", null, null);
    paramMetaModel.addField("timingValue", "utt", null, null);
    paramMetaModel.addField("timingCategory", "utc", null, null);
    paramMetaModel.addField("timingLabel", "utl", null, null);
    paramMetaModel.addField("sampleRate", "sf", "100", UP_TO_TWO_DIGIT_FLOAT_FORMATTER);
    paramMetaModel.addField("customDimension", "cd", null, null);
    paramMetaModel.addField("customMetric", "cm", null, null);
    paramMetaModel.addField("contentGrouping", "cg", null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/MetaModelInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */