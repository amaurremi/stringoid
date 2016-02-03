package com.gau.go.launcherex.gowidget.weather.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q
{
  public static final float[] a = { 0.67F, 3.58F, 7.62F, 12.32F, 17.92F, 24.19F, 31.14F, 38.53F, 46.59F, 54.88F, 63.84F, 73.03F, 82.89F, 92.97F, 103.49F, 114.25F, 125.67F };
  private static final float[] b = { 0.4F, 2.2F, 5.6F, 9.8F, 14.9F, 20.1F, 27.5F, 33.5F, 41.8F, 49.2F, 59.3F, 67.1F, 73.2F };
  
  public static int a(double paramDouble)
  {
    int i = 0;
    if (paramDouble < 0.0D) {
      i = 55536;
    }
    while (paramDouble < a[0]) {
      return i;
    }
    if (paramDouble < a[1]) {
      return 1;
    }
    if (paramDouble < a[2]) {
      return 2;
    }
    if (paramDouble < a[3]) {
      return 3;
    }
    if (paramDouble < a[4]) {
      return 4;
    }
    if (paramDouble < a[5]) {
      return 5;
    }
    if (paramDouble < a[6]) {
      return 6;
    }
    if (paramDouble < a[7]) {
      return 7;
    }
    if (paramDouble < a[8]) {
      return 8;
    }
    if (paramDouble < a[9]) {
      return 9;
    }
    if (paramDouble < a[10]) {
      return 10;
    }
    if (paramDouble < a[11]) {
      return 11;
    }
    if (paramDouble < a[12]) {
      return 12;
    }
    if (paramDouble < a[13]) {
      return 13;
    }
    if (paramDouble < a[14]) {
      return 14;
    }
    if (paramDouble < a[15]) {
      return 15;
    }
    if (paramDouble < a[16]) {
      return 16;
    }
    return 17;
  }
  
  public static int a(float paramFloat)
  {
    return Math.round(paramFloat);
  }
  
  public static int a(int paramInt)
  {
    return a((float)(paramInt / 1.8D));
  }
  
  public static String a(float paramFloat, int paramInt)
  {
    if (paramFloat <= -10000.0F) {
      return "--";
    }
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    return localNumberFormat.format(e(paramFloat));
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "--";
    }
    try
    {
      float f = Float.parseFloat(paramString.split(" ")[0]);
      paramString = NumberFormat.getNumberInstance();
      paramString.setMaximumFractionDigits(1);
      paramString.setMinimumFractionDigits(1);
      paramString = paramString.format(f * 1.61D);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "--";
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramString;
    }
    if (paramInt1 == 1) {
      return n(paramString);
    }
    return m(paramString);
  }
  
  public static float b(float paramFloat)
  {
    return Math.round(paramFloat * 10.0F) / 10.0F;
  }
  
  public static float b(float paramFloat, int paramInt)
  {
    String str = a(paramFloat, paramInt);
    if (str.equals("--")) {
      return -10000.0F;
    }
    try
    {
      paramFloat = DecimalFormat.getInstance().parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static int b(int paramInt)
  {
    return a((float)(paramInt * 1.8D));
  }
  
  public static String b(String paramString)
  {
    return a(paramString);
  }
  
  public static float c(float paramFloat)
  {
    if (paramFloat == -10000.0F) {
      return -10000.0F;
    }
    return (paramFloat - 32.0F) * 5.0F / 9.0F;
  }
  
  public static float c(float paramFloat, int paramInt)
  {
    paramFloat = (float)(paramFloat * 1.61D);
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static float c(int paramInt)
  {
    return b[paramInt];
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return "--";
    }
    try
    {
      float f = Float.parseFloat(paramString.split(" ")[0]);
      paramString = NumberFormat.getNumberInstance();
      paramString.setMaximumFractionDigits(1);
      paramString.setMinimumFractionDigits(1);
      paramString = paramString.format(f * 0.4464D);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "--";
  }
  
  public static float d(float paramFloat)
  {
    return 9.0F * paramFloat / 5.0F + 32.0F;
  }
  
  public static float d(float paramFloat, int paramInt)
  {
    return c(paramFloat, paramInt);
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return "--";
    }
    try
    {
      int i = a(Float.parseFloat(paramString.split(" ")[0]));
      paramString = i + "";
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "--";
  }
  
  private static float e(float paramFloat)
  {
    return (paramFloat - 32.0F) * 5.0F / 9.0F;
  }
  
  public static float e(float paramFloat, int paramInt)
  {
    paramFloat = (float)(paramFloat * 0.4464D);
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return "--";
    }
    try
    {
      float f = Float.parseFloat(paramString.split(" ")[0]);
      paramString = NumberFormat.getNumberInstance();
      paramString.setMaximumFractionDigits(1);
      paramString.setMinimumFractionDigits(1);
      paramString = paramString.format(f * 0.8679D);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "--";
  }
  
  public static float f(float paramFloat, int paramInt)
  {
    paramFloat = (float)(paramFloat * 0.8679D);
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String f(String paramString)
  {
    Object localObject = Pattern.compile("([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+))\\s*[sS]").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (((Matcher)localObject).find())
    {
      MatchResult localMatchResult = ((Matcher)localObject).toMatchResult();
      ((Matcher)localObject).appendReplacement(localStringBuffer, localMatchResult.group(1) + " °F");
    }
    localObject = Pattern.compile("([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+))\\s*(?:\\xB0F|\\xB0|F)");
    if (localStringBuffer.toString().equals("")) {}
    for (;;)
    {
      paramString = ((Pattern)localObject).matcher(paramString);
      localStringBuffer = new StringBuffer();
      while (paramString.find())
      {
        localObject = paramString.toMatchResult();
        paramString.appendReplacement(localStringBuffer, ((MatchResult)localObject).group(1) + " °F");
      }
      paramString = localStringBuffer.toString();
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static String g(float paramFloat, int paramInt)
  {
    if (paramFloat <= -10000.0F) {
      return "--";
    }
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    return localNumberFormat.format(c(paramFloat));
  }
  
  public static String g(String paramString)
  {
    Object localObject = Pattern.compile("([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+))\\s*[sS]").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (((Matcher)localObject).find())
    {
      String str = g(Float.parseFloat(((Matcher)localObject).toMatchResult().group(1)), 1);
      ((Matcher)localObject).appendReplacement(localStringBuffer, str + " °C");
    }
    localObject = Pattern.compile("([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+))\\s*(?:\\xB0F|\\xB0|F)");
    if (localStringBuffer.toString().equals("")) {}
    for (;;)
    {
      paramString = ((Pattern)localObject).matcher(paramString);
      localStringBuffer = new StringBuffer();
      while (paramString.find())
      {
        localObject = g(Float.parseFloat(paramString.toMatchResult().group(1)), 1);
        paramString.appendReplacement(localStringBuffer, (String)localObject + " °C");
      }
      paramString = localStringBuffer.toString();
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static String h(float paramFloat, int paramInt)
  {
    if (paramFloat <= -10000.0F) {
      return "--";
    }
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    return localNumberFormat.format(d(paramFloat));
  }
  
  public static String h(String paramString)
  {
    Object localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*to\\s*(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (((Matcher)localObject1).find())
    {
      Object localObject2 = ((Matcher)localObject1).toMatchResult();
      String str = a(((MatchResult)localObject2).group(1));
      localObject2 = a(((MatchResult)localObject2).group(2));
      ((Matcher)localObject1).appendReplacement(localStringBuffer, str + " to " + (String)localObject2 + " kph");
    }
    localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]");
    if (localStringBuffer.toString().equals("")) {}
    for (;;)
    {
      paramString = ((Pattern)localObject1).matcher(paramString);
      localStringBuffer = new StringBuffer();
      while (paramString.find())
      {
        localObject1 = a(paramString.toMatchResult().group(1));
        paramString.appendReplacement(localStringBuffer, (String)localObject1 + " kph");
      }
      paramString = localStringBuffer.toString();
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static float i(float paramFloat, int paramInt)
  {
    paramFloat = (float)(paramFloat * 1.609344D);
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String i(String paramString)
  {
    Object localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*to\\s*(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (((Matcher)localObject1).find())
    {
      Object localObject2 = ((Matcher)localObject1).toMatchResult();
      String str = b(((MatchResult)localObject2).group(1));
      localObject2 = b(((MatchResult)localObject2).group(2));
      ((Matcher)localObject1).appendReplacement(localStringBuffer, str + " to " + (String)localObject2 + " km/h");
    }
    localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]");
    if (localStringBuffer.toString().equals("")) {}
    for (;;)
    {
      paramString = ((Pattern)localObject1).matcher(paramString);
      localStringBuffer = new StringBuffer();
      while (paramString.find())
      {
        localObject1 = b(paramString.toMatchResult().group(1));
        paramString.appendReplacement(localStringBuffer, (String)localObject1 + " km/h");
      }
      paramString = localStringBuffer.toString();
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static float j(float paramFloat, int paramInt)
  {
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(0.4912F * paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String j(String paramString)
  {
    Object localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*to\\s*(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (((Matcher)localObject1).find())
    {
      Object localObject2 = ((Matcher)localObject1).toMatchResult();
      String str = c(((MatchResult)localObject2).group(1));
      localObject2 = c(((MatchResult)localObject2).group(2));
      ((Matcher)localObject1).appendReplacement(localStringBuffer, str + " to " + (String)localObject2 + " m/s");
    }
    localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]");
    if (localStringBuffer.toString().equals("")) {}
    for (;;)
    {
      paramString = ((Pattern)localObject1).matcher(paramString);
      localStringBuffer = new StringBuffer();
      while (paramString.find())
      {
        localObject1 = c(paramString.toMatchResult().group(1));
        paramString.appendReplacement(localStringBuffer, (String)localObject1 + " m/s");
      }
      paramString = localStringBuffer.toString();
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static float k(float paramFloat, int paramInt)
  {
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(0.03386F * paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String k(String paramString)
  {
    Matcher localMatcher = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*to\\s*(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]").matcher(paramString);
    Object localObject2 = new StringBuffer();
    if (localMatcher.find())
    {
      Object localObject3 = localMatcher.toMatchResult();
      localObject1 = d(((MatchResult)localObject3).group(1));
      localObject3 = d(((MatchResult)localObject3).group(2));
      if (((String)localObject1).equals(localObject3)) {}
      for (localObject1 = "Lv. " + (String)localObject1;; localObject1 = "Lv. " + (String)localObject1 + " to " + (String)localObject3)
      {
        localMatcher.appendReplacement((StringBuffer)localObject2, (String)localObject1);
        break;
      }
    }
    Object localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]");
    if (((StringBuffer)localObject2).toString().equals("")) {}
    for (;;)
    {
      paramString = ((Pattern)localObject1).matcher(paramString);
      localObject1 = new StringBuffer();
      while (paramString.find())
      {
        localObject2 = d(paramString.toMatchResult().group(1));
        paramString.appendReplacement((StringBuffer)localObject1, "Lv. " + (String)localObject2);
      }
      paramString = ((StringBuffer)localObject2).toString();
    }
    paramString.appendTail((StringBuffer)localObject1);
    return ((StringBuffer)localObject1).toString();
  }
  
  public static float l(float paramFloat, int paramInt)
  {
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(25.4F * paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String l(String paramString)
  {
    Matcher localMatcher = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*to\\s*(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]").matcher(paramString);
    Object localObject2 = new StringBuffer();
    if (localMatcher.find())
    {
      Object localObject3 = localMatcher.toMatchResult();
      localObject1 = e(((MatchResult)localObject3).group(1));
      localObject3 = e(((MatchResult)localObject3).group(2));
      if (((String)localObject1).equals(localObject3)) {}
      for (localObject1 = (String)localObject1 + " knots";; localObject1 = (String)localObject1 + " to " + (String)localObject3 + " knots")
      {
        localMatcher.appendReplacement((StringBuffer)localObject2, (String)localObject1);
        break;
      }
    }
    Object localObject1 = Pattern.compile("(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*[mM][pP][hH]");
    if (((StringBuffer)localObject2).toString().equals("")) {}
    for (;;)
    {
      paramString = ((Pattern)localObject1).matcher(paramString);
      localObject1 = new StringBuffer();
      while (paramString.find())
      {
        localObject2 = e(paramString.toMatchResult().group(1));
        paramString.appendReplacement((StringBuffer)localObject1, (String)localObject2 + " knots");
      }
      paramString = ((StringBuffer)localObject2).toString();
    }
    paramString.appendTail((StringBuffer)localObject1);
    return ((StringBuffer)localObject1).toString();
  }
  
  public static float m(float paramFloat, int paramInt)
  {
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(0.003386F * paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String m(String paramString)
  {
    if (!r.a(paramString)) {
      return "--";
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i <= 55536) {
        return "--";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = 55536;
      }
    }
    return g(i, 0);
  }
  
  public static float n(float paramFloat, int paramInt)
  {
    NumberFormat localNumberFormat = DecimalFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    String str = localNumberFormat.format(33.86F * paramFloat);
    try
    {
      paramFloat = localNumberFormat.parse(str).floatValue();
      return paramFloat;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return -10000.0F;
  }
  
  public static String n(String paramString)
  {
    if (!r.a(paramString)) {
      return "--";
    }
    int i = 55536;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    if (i >= 10000) {
      return "--";
    }
    return h(i, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */