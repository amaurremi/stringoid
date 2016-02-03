package com.millennialmedia.android;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMDemographic
{
  public static final String EDUCATION_ASSOCIATE = "associate";
  public static final String EDUCATION_BACHELORS = "bachelors";
  public static final String EDUCATION_HIGH_SCHOOL = "highschool";
  public static final String EDUCATION_IN_COLLEGE = "incollege";
  public static final String EDUCATION_MASTERS = "masters";
  public static final String EDUCATION_PHD = "phd";
  public static final String EDUCATION_PROFESSIONAL = "professional";
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
  public static final String KEY_AGE = "age";
  public static final String KEY_CHILDREN = "children";
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_INCOME = "income";
  public static final String KEY_KEYWORDS = "keywords";
  public static final String KEY_POLITICS = "politics";
  public static final String KEY_VENDOR = "vendor";
  public static final String KEY_WIDTH = "width";
  public static final String KEY_ZIP = "zip";
  public static final String MARITAL_DIVORCED = "divorced";
  public static final String MARITAL_ENGAGED = "engaged";
  public static final String MARITAL_MARRIED = "married";
  public static final String MARITAL_RELATIONSHIP = "relationship";
  public static final String MARITAL_SINGLE = "single";
  public static final String ORIENTATION_BISEXUAL = "bisexual";
  public static final String ORIENTATION_GAY = "gay";
  public static final String ORIENTATION_STRAIGHT = "straight";
  public String education;
  public String ethnicity;
  public String gender;
  public String marital;
  public String orientation;
  private HashMap<String, String> values = new HashMap();
  
  void getUrlParams(Map<String, String> paramMap)
  {
    Iterator localIterator = this.values.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap.put(localEntry.getKey(), localEntry.getValue());
    }
    if (this.gender != null) {
      paramMap.put("gender", this.gender);
    }
    if ((this.marital != null) && ((this.marital.equals("single")) || (this.marital.equals("married")) || (this.marital.equals("divorced")) || (this.marital.equals("engaged")) || (this.marital.equals("relationship")))) {
      paramMap.put("marital", this.marital);
    }
    if (this.ethnicity != null) {
      paramMap.put("ethnicity", this.ethnicity);
    }
    if ((this.orientation != null) && ((this.orientation.equals("straight")) || (this.orientation.equals("gay")) || (this.orientation.equals("bisexual")))) {
      paramMap.put("orientation", this.orientation);
    }
    if (this.education != null) {
      paramMap.put("edu", this.education);
    }
  }
  
  public void put(String paramString1, String paramString2)
  {
    if (paramString1.equals("gender"))
    {
      this.gender = paramString2;
      return;
    }
    if (paramString1.equals("ethnicity"))
    {
      this.ethnicity = paramString2;
      return;
    }
    if (paramString1.equals("marital"))
    {
      this.marital = paramString2;
      return;
    }
    if (paramString1.equals("orientation"))
    {
      this.orientation = paramString2;
      return;
    }
    if (paramString1.equals("education"))
    {
      this.education = paramString2;
      return;
    }
    if (paramString2 != null)
    {
      this.values.put(paramString1, paramString2);
      return;
    }
    this.values.remove(paramString1);
  }
  
  String toQueryString()
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.gender != null) && ((this.gender.equals("male")) || (this.gender.equals("female")))) {
      localStringBuilder.append("&gender=" + URLEncoder.encode(this.gender, "UTF-8"));
    }
    if ((this.ethnicity != null) && ((this.ethnicity.equals("white")) || (this.ethnicity.equals("black")) || (this.ethnicity.equals("hispanic")) || (this.ethnicity.equals("asian")) || (this.ethnicity.equals("indian")) || (this.ethnicity.equals("middleeastern")) || (this.ethnicity.equals("nativeamerican")) || (this.ethnicity.equals("pacificislander")) || (this.ethnicity.equals("other")))) {
      localStringBuilder.append("&ethnicity=" + URLEncoder.encode(this.ethnicity, "UTF-8"));
    }
    if ((this.marital != null) && ((this.marital.equals("single")) || (this.marital.equals("married")) || (this.marital.equals("divorced")) || (this.marital.equals("engaged")) || (this.marital.equals("relationship")))) {
      localStringBuilder.append("&marital=" + this.marital);
    }
    if ((this.orientation != null) && ((this.orientation.equals("straight")) || (this.orientation.equals("gay")) || (this.orientation.equals("bisexual")))) {
      localStringBuilder.append("&orientation=" + this.orientation);
    }
    if ((this.education != null) && ((this.education.equals("highschool")) || (this.education.equals("incollege")) || (this.education.equals("somecollege")) || (this.education.equals("associate")) || (this.education.equals("bachelors")) || (this.education.equals("masters")) || (this.education.equals("phd")) || (this.education.equals("professional")))) {
      localStringBuilder.append("&edu=" + URLEncoder.encode(this.education, "UTF-8"));
    }
    Iterator localIterator = this.values.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(String.format("&%s=%s", new Object[] { URLEncoder.encode((String)localEntry.getKey()), URLEncoder.encode((String)localEntry.getValue()) }));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMDemographic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */