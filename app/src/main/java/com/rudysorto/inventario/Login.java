package com.rudysorto.inventario;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends ActionBarActivity {

    Button btnLogin;
    EditText edtUsuario;
    EditText edtPassword;
    public String resultado;
    public String usuario, password;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsuario.getText().length() != 0  && edtUsuario.getText().toString() != "" && edtPassword.getText().length() != 0 && edtPassword.getText().toString() != "") {
                    AsyncCallLoginWs task = new AsyncCallLoginWs();
                   task.execute();
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese sus credenciales", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    private class AsyncCallLoginWs extends AsyncTask<Void, Void, String>{
        @Override
        protected String doInBackground(Void... params) {
           return WebService.invokeLoginWS(usuario, password , "login");

        }


        @Override
        protected void onPreExecute() {
            usuario = edtUsuario.getText().toString();
            password = edtPassword.getText().toString();

          //  super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String aVoid) {
            //super.onPostExecute(aVoid);
            if(aVoid.equals("OK")){
                Toast.makeText(getApplicationContext(), "Bienvenido a la Movil APP PAILL", Toast.LENGTH_LONG).show();
                pasarAPrincipal();
            }else if(aVoid.equals("ERR")) {
                Toast.makeText(getApplicationContext(), "Sus credenciales no son correctas", Toast.LENGTH_LONG).show();
            }
           // Toast.makeText(getApplicationContext(), aVoid, Toast.LENGTH_LONG).show()
        }
    }

    public void pasarAPrincipal(){
        Intent i = new Intent(getApplicationContext(), MenuPrincipal.class);
        i.putExtra("uid", edtUsuario.getText().toString());
        startActivity(i);

    }
}
