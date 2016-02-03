package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.util.z_T4JInternalStringUtil;

public final class OEmbedRequest
  implements Serializable
{
  private static final long serialVersionUID = -4330607167106242987L;
  private OEmbedRequest.Align align = OEmbedRequest.Align.NONE;
  private boolean hideMedia = true;
  private boolean hideThread = true;
  private String lang;
  private int maxWidth;
  private boolean omitScript = false;
  private String[] related = new String[0];
  private final long statusId;
  private final String url;
  
  public OEmbedRequest(long paramLong, String paramString)
  {
    this.statusId = paramLong;
    this.url = paramString;
  }
  
  private void appendParameter(String paramString, long paramLong, List paramList)
  {
    if (0L <= paramLong) {
      paramList.add(new HttpParameter(paramString, String.valueOf(paramLong)));
    }
  }
  
  private void appendParameter(String paramString1, String paramString2, List paramList)
  {
    if (paramString2 != null) {
      paramList.add(new HttpParameter(paramString1, paramString2));
    }
  }
  
  public OEmbedRequest HideMedia(boolean paramBoolean)
  {
    this.hideMedia = paramBoolean;
    return this;
  }
  
  public OEmbedRequest HideThread(boolean paramBoolean)
  {
    this.hideThread = paramBoolean;
    return this;
  }
  
  public OEmbedRequest MaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
    return this;
  }
  
  public OEmbedRequest align(OEmbedRequest.Align paramAlign)
  {
    this.align = paramAlign;
    return this;
  }
  
  HttpParameter[] asHttpParameterArray()
  {
    ArrayList localArrayList = new ArrayList(12);
    appendParameter("id", this.statusId, localArrayList);
    appendParameter("url", this.url, localArrayList);
    appendParameter("maxwidth", this.maxWidth, localArrayList);
    localArrayList.add(new HttpParameter("hide_media", this.hideMedia));
    localArrayList.add(new HttpParameter("hide_thread", this.hideThread));
    localArrayList.add(new HttpParameter("omit_script", this.omitScript));
    localArrayList.add(new HttpParameter("align", this.align.name().toLowerCase()));
    if (this.related.length > 0) {
      appendParameter("related", z_T4JInternalStringUtil.join(this.related), localArrayList);
    }
    appendParameter("lang", this.lang, localArrayList);
    return (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (OEmbedRequest)paramObject;
      if (this.hideMedia != ((OEmbedRequest)paramObject).hideMedia) {
        return false;
      }
      if (this.hideThread != ((OEmbedRequest)paramObject).hideThread) {
        return false;
      }
      if (this.maxWidth != ((OEmbedRequest)paramObject).maxWidth) {
        return false;
      }
      if (this.omitScript != ((OEmbedRequest)paramObject).omitScript) {
        return false;
      }
      if (this.statusId != ((OEmbedRequest)paramObject).statusId) {
        return false;
      }
      if (this.align != ((OEmbedRequest)paramObject).align) {
        return false;
      }
      if (this.lang != null)
      {
        if (this.lang.equals(((OEmbedRequest)paramObject).lang)) {}
      }
      else {
        while (((OEmbedRequest)paramObject).lang != null) {
          return false;
        }
      }
      if (!Arrays.equals(this.related, ((OEmbedRequest)paramObject).related)) {
        return false;
      }
      if (this.url == null) {
        break;
      }
    } while (this.url.equals(((OEmbedRequest)paramObject).url));
    for (;;)
    {
      return false;
      if (((OEmbedRequest)paramObject).url == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int m = 1;
    int i2 = 0;
    int i3 = (int)(this.statusId ^ this.statusId >>> 32);
    int i;
    int i4;
    int j;
    label51:
    int k;
    label60:
    label67:
    int n;
    if (this.url != null)
    {
      i = this.url.hashCode();
      i4 = this.maxWidth;
      if (!this.hideMedia) {
        break label168;
      }
      j = 1;
      if (!this.hideThread) {
        break label173;
      }
      k = 1;
      if (!this.omitScript) {
        break label178;
      }
      if (this.align == null) {
        break label184;
      }
      n = this.align.hashCode();
      label83:
      if (this.related == null) {
        break label190;
      }
    }
    label168:
    label173:
    label178:
    label184:
    label190:
    for (int i1 = Arrays.hashCode(this.related);; i1 = 0)
    {
      if (this.lang != null) {
        i2 = this.lang.hashCode();
      }
      return (i1 + (n + ((k + (j + ((i + i3 * 31) * 31 + i4) * 31) * 31) * 31 + m) * 31) * 31) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label60;
      m = 0;
      break label67;
      n = 0;
      break label83;
    }
  }
  
  public OEmbedRequest lang(String paramString)
  {
    this.lang = paramString;
    return this;
  }
  
  public OEmbedRequest omitScript(boolean paramBoolean)
  {
    this.omitScript = paramBoolean;
    return this;
  }
  
  public OEmbedRequest related(String[] paramArrayOfString)
  {
    this.related = paramArrayOfString;
    return this;
  }
  
  public void setAlign(OEmbedRequest.Align paramAlign)
  {
    this.align = paramAlign;
  }
  
  public void setHideMedia(boolean paramBoolean)
  {
    this.hideMedia = paramBoolean;
  }
  
  public void setHideThread(boolean paramBoolean)
  {
    this.hideThread = paramBoolean;
  }
  
  public void setLang(String paramString)
  {
    this.lang = paramString;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
  }
  
  public void setOmitScript(boolean paramBoolean)
  {
    this.omitScript = paramBoolean;
  }
  
  public void setRelated(String[] paramArrayOfString)
  {
    this.related = paramArrayOfString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("OEmbedRequest{statusId=").append(this.statusId).append(", url='").append(this.url).append('\'').append(", maxWidth=").append(this.maxWidth).append(", hideMedia=").append(this.hideMedia).append(", hideThread=").append(this.hideThread).append(", omitScript=").append(this.omitScript).append(", align=").append(this.align).append(", related=");
    if (this.related == null) {}
    for (Object localObject = null;; localObject = Arrays.asList(this.related)) {
      return localObject + ", lang='" + this.lang + '\'' + '}';
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/OEmbedRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */