package com.gtp.go.weather.sharephoto.award;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gtp.go.weather.sharephoto.b.a;
import com.gtp.go.weather.sharephoto.b.d;
import java.util.List;

class e
  extends AsyncTask
{
  e(c paramc, com.gtp.go.weather.sharephoto.b.b paramb) {}
  
  protected com.gtp.go.weather.sharephoto.b.b a(com.gtp.go.weather.sharephoto.b.b... paramVarArgs)
  {
    Object localObject = paramVarArgs[0];
    paramVarArgs = new com.gtp.go.weather.sharephoto.b.b();
    paramVarArgs.a(((com.gtp.go.weather.sharephoto.b.b)localObject).a());
    paramVarArgs.b(((com.gtp.go.weather.sharephoto.b.b)localObject).b());
    a locala = new a();
    locala.a(((com.gtp.go.weather.sharephoto.b.b)localObject).d().a());
    paramVarArgs.a(locala);
    u.a(locala);
    if (!TextUtils.isEmpty(locala.b()))
    {
      long l1 = c.e(this.b).a();
      long l2 = ((com.gtp.go.weather.sharephoto.b.b)localObject).a();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("apk_pic_path", locala.b());
      com.gtp.go.weather.sharephoto.b.a.b.a(c.f(this.b), (ContentValues)localObject, "user_award_id=? and award_id=?", new String[] { String.valueOf(l1), String.valueOf(l2) });
    }
    return paramVarArgs;
  }
  
  protected void a(com.gtp.go.weather.sharephoto.b.b paramb)
  {
    c.g(this.b).remove(this.a.d().a());
    if ((this.a.a() == paramb.a()) && (this.a.b() == paramb.b()))
    {
      this.a.d().b(paramb.d().b());
      c.d(this.b).notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */