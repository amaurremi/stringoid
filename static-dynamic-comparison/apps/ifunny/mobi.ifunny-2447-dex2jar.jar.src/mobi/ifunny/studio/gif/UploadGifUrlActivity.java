package mobi.ifunny.studio.gif;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import mobi.ifunny.f;

public class UploadGifUrlActivity
        extends f {
    private EditText o;

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903176);
        this.o = ((EditText) findViewById(2131493342));
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820567, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        paramMenuItem = this.o.getText().toString();
        if (TextUtils.isEmpty(paramMenuItem)) {
            Toast.makeText(this, 2131690118, 0).show();
            return true;
        }
        if (!paramMenuItem.startsWith("http")) {
            Toast.makeText(this, 2131690121, 0).show();
            return true;
        }
        Intent localIntent = new Intent();
        localIntent.setData(Uri.parse(paramMenuItem));
        setResult(-1, localIntent);
        finish();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/UploadGifUrlActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */