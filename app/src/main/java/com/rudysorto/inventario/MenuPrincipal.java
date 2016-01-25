package com.rudysorto.inventario;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rudysorto.inventario.adaptadores.AppsAdapter;
import com.rudysorto.inventario.appFuerzaVentas.ActivityAppFuerzaVentas;
import com.rudysorto.inventario.entitys.AppMoviles;
import com.rudysorto.inventario.webservices.WebServiceEJB;

import java.util.ArrayList;


public class MenuPrincipal extends Activity  {

    public TextView lblUid;
    ListView listadeApps;
    AppsAdapter myadapter;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);



        Intent intent = getIntent();
         bundle = intent.getExtras();



        String[] myTaskParams = {  bundle.getString("uid") };
       // myAsyncTask = new myAsyncTask ().execute(myTaskParams);
        AsyncCallListaApp asyncListaApp = new AsyncCallListaApp();
        asyncListaApp.execute(myTaskParams);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_principal, menu);
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



    private class AsyncCallListaApp extends AsyncTask<String, Void, ArrayList<AppMoviles>> {


        @Override
        protected ArrayList<AppMoviles> doInBackground(String... params) {
            String atuid = params[0];
            ArrayList<AppMoviles> appList = (ArrayList<AppMoviles>) WebServiceEJB.invokeHelloWorldWSReload(atuid, "selectLike");

// Attach the adapter to a ListView
          //  listadeApps.setAdapter(adapter);

            return  appList;
        }
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(ArrayList<AppMoviles> aVoid) {

            LlenarListadeApps(aVoid);
        }

    }//fin asyncTask

    public void LlenarListadeApps(ArrayList<AppMoviles> aVoid){
        listadeApps = (ListView) findViewById(R.id.listapps);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
     //   myadapter = new AppsAdapter(MenuPrincipal.this, aVoid);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        // Assign adapter to ListView
        listadeApps.setAdapter(myadapter);



        /*
        // ListView Item Click Listener
        listadeApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listadeApps.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });*/
    }



    public void LlamarApp(int idAppMovil){

        switch (idAppMovil){

            case 3:
                Intent i = new Intent(getApplicationContext(), ActivityAppFuerzaVentas.class);
                i.putExtra("uid",  bundle.getString("uid"));
                i.putExtra("idAppMovil", idAppMovil);
                startActivity(i);
                break;
        }


    }




    }


