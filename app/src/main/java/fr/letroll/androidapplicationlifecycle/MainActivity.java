package fr.letroll.androidapplicationlifecycle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        report("onCreate enter");
        super.onCreate(savedInstanceState);
        report("super.onCreate done");

        setContentView(R.layout.activity_main);
        report("setContentView done");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportFragmentManager().addOnBackStackChangedListener(new BackStackListener());

        tv = (TextView)findViewById(R.id.tv);

        report("onCreate exit");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public MainActivity()
    {
        report("constructor");
    }

    private void report(String txt){
        Log.i(TAG,txt);
        if(tv!=null)tv.append(txt+"\n");
    }

    @Override
    protected void onDestroy()
    {
        report("onDestroy enter");
        super.onDestroy();
        report("onDestroy exit");
    }


    @Override
    protected void onPause()
    {
        report("onPause enter");
        super.onPause();
        report("onPause exit");
    }


    @Override
    protected void onResume()
    {
        report("onResume enter");
        super.onResume();
        report("onResume exit");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        report("onSaveInstanceState enter");
        super.onSaveInstanceState(outState);
        report("onSaveInstanceState exit");
    }


    @Override
    protected void onStart()
    {
        report("onStart enter");
        super.onStart();
        report("onStart exit");
    }


    @Override
    protected void onStop()
    {
        report("onStop enter");
        super.onStop();
        report("onStop exit");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        report("onRestoreInstanceState enter");
        super.onRestoreInstanceState(savedInstanceState);
        report("onRestoreInstanceState exit");
    }

    private class BackStackListener implements FragmentManager.OnBackStackChangedListener
    {
        @Override
        public void onBackStackChanged()
        {
            report("onBackStackChanged");


            FragmentManager fm = MainActivity.this.getSupportFragmentManager();
            if (fm.getBackStackEntryCount() == 0)
            {
                report("back stack empty");
            }else report("back stack count:"+fm.getBackStackEntryCount());
        }
    }
}
