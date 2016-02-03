package mobi.beyondpod.rsscore.helpers;

public class Version
{
  int _Build;
  int _Major;
  int _Minor;
  int _Revision;
  
  public Version(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._Major = paramInt1;
    this._Minor = paramInt2;
    this._Build = paramInt3;
    this._Revision = paramInt4;
  }
  
  public Version(String paramString)
  {
    paramString = paramString.split("\\.");
    if ((paramString.length > 1) && (paramString.length < 5))
    {
      if (paramString.length > 0) {
        this._Major = StringUtils.TryParseIntFromString(paramString[0], Integer.valueOf(0)).intValue();
      }
      if (paramString.length > 1) {
        this._Minor = StringUtils.TryParseIntFromString(paramString[1], Integer.valueOf(0)).intValue();
      }
      if (paramString.length > 2) {
        this._Build = StringUtils.TryParseIntFromString(paramString[2], Integer.valueOf(0)).intValue();
      }
      if (paramString.length > 3) {
        this._Revision = StringUtils.TryParseIntFromString(paramString[3], Integer.valueOf(0)).intValue();
      }
    }
  }
  
  public static int Compare(Version paramVersion1, Version paramVersion2)
  {
    if (paramVersion1 == paramVersion2) {}
    do
    {
      return 0;
      if ((paramVersion1 != null) && (paramVersion2 == null)) {
        return 1;
      }
      if ((paramVersion1 == null) && (paramVersion2 != null)) {
        return -1;
      }
      if (paramVersion1._Major > paramVersion2._Major) {
        return 1;
      }
      if (paramVersion1._Major < paramVersion2._Major) {
        return -1;
      }
      if (paramVersion1._Minor > paramVersion2._Minor) {
        return 1;
      }
      if (paramVersion1._Minor < paramVersion2._Minor) {
        return -1;
      }
      if (paramVersion1._Build > paramVersion2._Build) {
        return 1;
      }
      if (paramVersion1._Build < paramVersion2._Build) {
        return -1;
      }
      if (paramVersion1._Revision > paramVersion2._Revision) {
        return 1;
      }
    } while (paramVersion1._Revision >= paramVersion2._Revision);
    return -1;
  }
  
  public boolean IsZero()
  {
    return (this._Major == 0) && (this._Minor == 0) && (this._Build == 0) && (this._Revision == 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof Version)) {
        return false;
      }
      paramObject = (Version)paramObject;
      if (this._Build != ((Version)paramObject)._Build) {
        return false;
      }
      if (this._Major != ((Version)paramObject)._Major) {
        return false;
      }
      if (this._Minor != ((Version)paramObject)._Minor) {
        return false;
      }
    } while (this._Revision == ((Version)paramObject)._Revision);
    return false;
  }
  
  public int hashCode()
  {
    return (((this._Build + 31) * 31 + this._Major) * 31 + this._Minor) * 31 + this._Revision;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this._Major)).append(".").append(this._Minor).append(".").append(this._Build);
    if (this._Revision != 0) {}
    for (String str = "." + this._Revision;; str = "") {
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */