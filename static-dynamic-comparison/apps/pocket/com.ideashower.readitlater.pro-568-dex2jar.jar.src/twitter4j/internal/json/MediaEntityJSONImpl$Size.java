package twitter4j.internal.json;

import twitter4j.MediaEntity.Size;
import twitter4j.internal.org.json.JSONObject;

class MediaEntityJSONImpl$Size
  implements MediaEntity.Size
{
  private static final long serialVersionUID = 8681853416159361581L;
  int height;
  int resize;
  int width;
  
  MediaEntityJSONImpl$Size(JSONObject paramJSONObject)
  {
    this.width = paramJSONObject.getInt("w");
    this.height = paramJSONObject.getInt("h");
    if ("fit".equals(paramJSONObject.getString("resize"))) {}
    for (int i = 100;; i = 101)
    {
      this.resize = i;
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Size)) {
        return false;
      }
      paramObject = (Size)paramObject;
      if (this.height != ((Size)paramObject).height) {
        return false;
      }
      if (this.resize != ((Size)paramObject).resize) {
        return false;
      }
    } while (this.width == ((Size)paramObject).width);
    return false;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getResize()
  {
    return this.resize;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    return (this.width * 31 + this.height) * 31 + this.resize;
  }
  
  public String toString()
  {
    return "Size{width=" + this.width + ", height=" + this.height + ", resize=" + this.resize + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/MediaEntityJSONImpl$Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */