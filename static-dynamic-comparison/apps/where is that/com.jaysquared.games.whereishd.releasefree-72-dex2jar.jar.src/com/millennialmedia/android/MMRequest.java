package com.millennialmedia.android;

import android.location.Location;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MMRequest
{
  public static final String EDUCATION_ASSOCIATES = "associates";
  public static final String EDUCATION_BACHELORS = "bachelors";
  public static final String EDUCATION_DOCTORATE = "doctorate";
  public static final String EDUCATION_HIGH_SCHOOL = "highschool";
  public static final String EDUCATION_IN_COLLEGE = "incollege";
  public static final String EDUCATION_MASTERS = "masters";
  public static final String EDUCATION_OTHER = "other";
  public static final String EDUCATION_SOME_COLLEGE = "somecollege";
  public static final String ETHNICITY_ASIAN = "asian";
  public static final String ETHNICITY_BLACK = "black";
  public static final String ETHNICITY_HISPANIC = "hispanic";
  public static final String ETHNICITY_INDIAN = "indian";
  public static final String ETHNICITY_MIDDLE_EASTERN = "middleeastern";
  public static final String ETHNICITY_NATIVE_AMERICAN = "nativeamerican";
  public static final String ETHNICITY_OTHER = "other";
  public static final String ETHNICITY_PACIFIC_ISLANDER = "pacificislander";
  public static final String ETHNICITY_WHITE = "white";
  public static final String GENDER_FEMALE = "female";
  public static final String GENDER_MALE = "male";
  public static final String GENDER_OTHER = "other";
  public static final String KEY_AGE = "age";
  public static final String KEY_CHILDREN = "children";
  public static final String KEY_EDUCATION = "education";
  public static final String KEY_ETHNICITY = "ethnicity";
  public static final String KEY_GENDER = "gender";
  public static final String KEY_HEIGHT = "hsht";
  public static final String KEY_INCOME = "income";
  public static final String KEY_KEYWORDS = "keywords";
  public static final String KEY_MARITAL_STATUS = "marital";
  public static final String KEY_ORIENTATION = "orientation";
  public static final String KEY_POLITICS = "politics";
  public static final String KEY_VENDOR = "vendor";
  public static final String KEY_WIDTH = "hswd";
  public static final String KEY_ZIP_CODE = "zip";
  public static final String MARITAL_DIVORCED = "divorced";
  public static final String MARITAL_ENGAGED = "engaged";
  public static final String MARITAL_MARRIED = "married";
  public static final String MARITAL_OTHER = "other";
  public static final String MARITAL_RELATIONSHIP = "relationship";
  public static final String MARITAL_SINGLE = "single";
  public static final String ORIENTATION_BISEXUAL = "bisexual";
  public static final String ORIENTATION_GAY = "gay";
  public static final String ORIENTATION_OTHER = "other";
  public static final String ORIENTATION_STRAIGHT = "straight";
  static Location location;
  String age = null;
  String children = null;
  String education = null;
  String ethnicity = null;
  String gender = null;
  String income = null;
  String keywords = null;
  String marital = null;
  String orientation = null;
  String politics = null;
  private Map<String, String> values = new HashMap();
  String vendor = null;
  String zip = null;
  
  public static Location getUserLocation()
  {
    return location;
  }
  
  static void insertLocation(Map<String, String> paramMap)
  {
    if (location != null)
    {
      paramMap.put("lat", Double.toString(location.getLatitude()));
      paramMap.put("long", Double.toString(location.getLongitude()));
      if (location.hasAccuracy())
      {
        paramMap.put("ha", Float.toString(location.getAccuracy()));
        paramMap.put("va", Float.toString(location.getAccuracy()));
      }
      if (location.hasSpeed()) {
        paramMap.put("spd", Float.toString(location.getSpeed()));
      }
      if (location.hasBearing()) {
        paramMap.put("brg", Float.toString(location.getBearing()));
      }
      if (location.hasAltitude()) {
        paramMap.put("alt", Double.toString(location.getAltitude()));
      }
      paramMap.put("tslr", Long.toString(location.getTime()));
      paramMap.put("loc", "true");
      paramMap.put("lsrc", location.getProvider());
      return;
    }
    paramMap.put("loc", "false");
  }
  
  public static void setUserLocation(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    location = paramLocation;
  }
  
  void getUrlParams(Map<String, String> paramMap)
  {
    Iterator localIterator = this.values.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap.put(localEntry.getKey(), localEntry.getValue());
    }
    if (this.age != null) {
      paramMap.put("age", this.age);
    }
    if (this.children != null) {
      paramMap.put("children", this.children);
    }
    if (this.education != null) {
      paramMap.put("education", this.education);
    }
    if (this.ethnicity != null) {
      paramMap.put("ethnicity", this.ethnicity);
    }
    if (this.gender != null) {
      paramMap.put("gender", this.gender);
    }
    if (this.income != null) {
      paramMap.put("income", this.income);
    }
    if (this.keywords != null) {
      paramMap.put("keywords", this.keywords);
    }
    if (this.marital != null) {
      paramMap.put("marital", this.marital);
    }
    if (this.orientation != null) {
      paramMap.put("orientation", this.orientation);
    }
    if (this.politics != null) {
      paramMap.put("politics", this.politics);
    }
    if (this.vendor != null) {
      paramMap.put("vendor", this.vendor);
    }
    if (this.zip != null) {
      paramMap.put("zip", this.zip);
    }
  }
  
  public MMRequest put(String paramString1, String paramString2)
  {
    if (paramString1.equals("age"))
    {
      this.age = paramString2;
      return this;
    }
    if (paramString1.equals("children"))
    {
      this.children = paramString2;
      return this;
    }
    if (paramString1.equals("education"))
    {
      this.education = paramString2;
      return this;
    }
    if (paramString1.equals("ethnicity"))
    {
      this.ethnicity = paramString2;
      return this;
    }
    if (paramString1.equals("gender"))
    {
      this.gender = paramString2;
      return this;
    }
    if (paramString1.equals("income"))
    {
      this.income = paramString2;
      return this;
    }
    if (paramString1.equals("keywords"))
    {
      this.keywords = paramString2;
      return this;
    }
    if (paramString1.equals("marital"))
    {
      this.marital = paramString2;
      return this;
    }
    if (paramString1.equals("orientation"))
    {
      this.orientation = paramString2;
      return this;
    }
    if (paramString1.equals("politics"))
    {
      this.politics = paramString2;
      return this;
    }
    if (paramString1.equals("vendor"))
    {
      this.vendor = paramString2;
      return this;
    }
    if (paramString1.equals("zip"))
    {
      this.zip = paramString2;
      return this;
    }
    if (paramString2 != null)
    {
      this.values.put(paramString1, paramString2);
      return this;
    }
    this.values.remove(paramString1);
    return this;
  }
  
  public void setAge(String paramString)
  {
    this.age = paramString;
  }
  
  public void setChildren(String paramString)
  {
    this.children = paramString;
  }
  
  public void setEducation(String paramString)
  {
    this.education = paramString;
  }
  
  public void setEthnicity(String paramString)
  {
    this.ethnicity = paramString;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setIncome(String paramString)
  {
    this.income = paramString;
  }
  
  public void setKeywords(String paramString)
  {
    this.keywords = paramString;
  }
  
  public void setMarital(String paramString)
  {
    this.marital = paramString;
  }
  
  public void setMetaValues(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public void setOrientation(String paramString)
  {
    this.orientation = paramString;
  }
  
  public void setPolitics(String paramString)
  {
    this.politics = paramString;
  }
  
  public void setVendor(String paramString)
  {
    this.vendor = paramString;
  }
  
  public void setZip(String paramString)
  {
    this.zip = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */