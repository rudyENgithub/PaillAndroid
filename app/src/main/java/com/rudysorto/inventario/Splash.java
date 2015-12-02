package com.rudysorto.inventario;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.ProgressBar;


public class Splash extends Activity {

    // create an instance of ProgressBar
    ProgressBar prgLoading;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prgLoading = (ProgressBar) findViewById(R.id.prgLoading);
        prgLoading.setProgress(progress);

        // run progressbar via asynctask
        new Loading().execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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

    public class Loading extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {}

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub

            // create progress bar loading
            while(progress < 100){
                try {
                    Thread.sleep(1000);
                    progress += 30;
                    prgLoading.setProgress(progress);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub

            // when progressbar finish call HomeActivity class
            Intent i = new Intent(Splash.this, Login.class);
            startActivity(i);
        }
    }
}
