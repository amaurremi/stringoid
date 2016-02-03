package com.venticake.retrica.view.album;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.opengles.GL11;

final class RenderView$TextureReference
  extends WeakReference<Texture>
{
  public final DirectLinkedList.Entry<TextureReference> activeListEntry = new DirectLinkedList.Entry(this);
  public final GL11 gl;
  public final int textureId;
  
  public RenderView$TextureReference(Texture paramTexture, GL11 paramGL11, ReferenceQueue paramReferenceQueue, int paramInt)
  {
    super(paramTexture, paramReferenceQueue);
    this.textureId = paramInt;
    this.gl = paramGL11;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/RenderView$TextureReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */