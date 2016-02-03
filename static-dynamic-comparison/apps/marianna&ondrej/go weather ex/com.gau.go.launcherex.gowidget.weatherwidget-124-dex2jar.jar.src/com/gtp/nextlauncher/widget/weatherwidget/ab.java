package com.gtp.nextlauncher.widget.weatherwidget;

import android.opengl.GLES20;
import com.go.gl.graphics.RenderContext;
import com.go.gl.graphics.Renderable;
import com.go.gl.graphics.Texture;
import com.go.gl.graphics.TextureShader;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

class ab
  implements Renderable
{
  ab(aa paramaa) {}
  
  public void run(long paramLong, RenderContext arg3)
  {
    TextureShader localTextureShader = (TextureShader)???.shader;
    if ((localTextureShader == null) || (!localTextureShader.bind())) {}
    while ((???.texture == null) || (!???.texture.bind())) {
      return;
    }
    localTextureShader.setMatrix(???.matrix, 0);
    localTextureShader.setAlpha(???.alpha);
    synchronized (this.a)
    {
      aa.a(this.a).position(0);
      aa.b(this.a).position(0);
      aa.c(this.a).position(0);
      localTextureShader.setPosition(aa.a(this.a), 3);
      localTextureShader.setTexCoord(aa.b(this.a), 2);
      GLES20.glDrawElements(4, aa.d(this.a), 5123, aa.c(this.a));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */