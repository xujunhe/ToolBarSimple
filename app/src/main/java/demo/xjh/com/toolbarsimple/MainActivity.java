package demo.xjh.com.toolbarsimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 *
 *
 * 创建Toolbar
 *
 * 作者：许俊和 on 16-2-29 17:53
 */
public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myToolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        CharSequence title = item.getTitle();
        System.out.print("点击返回按钮："+itemId+"标题："+title);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView)MenuItemCompat.getActionView(menuItem);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider myShareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent myShareIntent = new Intent(Intent.ACTION_SEND);
        myShareIntent.setType("image/*");
        myShareIntent.putExtra(Intent.EXTRA_STREAM, "");
        myShareActionProvider.setShareIntent(myShareIntent);
        return true;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"设置",Toast.LENGTH_LONG).show();
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                Toast.makeText(getApplicationContext(),"点击图标",Toast.LENGTH_LONG).show();
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return true;

        }

    }
}
