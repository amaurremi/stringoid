package com.bfs.papertoss.cpp;

import com.bfs.papertoss.vector.v4f;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TextureMgr
{
  ConcurrentHashMap<String, TextureInfo> m_textures = new ConcurrentHashMap();
  
  public void cleanup()
  {
    Iterator localIterator = this.m_textures.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TextureInfo localTextureInfo = (TextureInfo)this.m_textures.get(str);
      if (localTextureInfo.ref_count < 1)
      {
        localTextureInfo.texture.delete();
        this.m_textures.remove(str);
      }
    }
  }
  
  public Texture get(String paramString)
  {
    TextureInfo localTextureInfo2 = (TextureInfo)this.m_textures.get(paramString);
    TextureInfo localTextureInfo1 = localTextureInfo2;
    if (localTextureInfo2 == null)
    {
      localTextureInfo1 = new TextureInfo(null);
      this.m_textures.put(paramString, localTextureInfo1);
    }
    if (localTextureInfo1.texture == null) {
      localTextureInfo1.texture = new Texture(paramString);
    }
    localTextureInfo1.ref_count += 1;
    return localTextureInfo1.texture;
  }
  
  public Texture getText(String paramString1, String paramString2, int paramInt1, int paramInt2, v4f paramv4f, int paramInt3, float paramFloat)
  {
    String str = paramString1 + paramString2 + paramInt2 + paramv4f.x + paramv4f.y + paramv4f.z + paramv4f.w + paramInt3;
    TextureInfo localTextureInfo2 = (TextureInfo)this.m_textures.get(str);
    TextureInfo localTextureInfo1 = localTextureInfo2;
    if (localTextureInfo2 == null)
    {
      localTextureInfo1 = new TextureInfo(null);
      this.m_textures.put(str, localTextureInfo1);
    }
    if (localTextureInfo1.texture == null) {
      localTextureInfo1.texture = new Texture(paramString1, paramString2, paramInt1, paramInt2, paramv4f, paramInt3, paramFloat);
    }
    localTextureInfo1.ref_count += 1;
    return localTextureInfo1.texture;
  }
  
  public void release(Texture paramTexture)
  {
    Iterator localIterator = this.m_textures.values().iterator();
    while (localIterator.hasNext())
    {
      TextureInfo localTextureInfo = (TextureInfo)localIterator.next();
      if (localTextureInfo.texture == paramTexture) {
        localTextureInfo.ref_count -= 1;
      }
    }
  }
  
  private class TextureInfo
  {
    int ref_count = 0;
    Texture texture = null;
    
    private TextureInfo() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/TextureMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */