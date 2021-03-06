package com.rudysorto.inventario;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rudysorto.inventario.webservices.WebService;


public class Login extends Activity {

    Button btnLogin;
    EditText edtUsuario;
    EditText edtPassword;
    public String resultado;
    public String usuario, password;
    ProgressBar prgLoadinglogin;
    GlobalVar globalVariable;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        globalVariable = (GlobalVar) getApplicationContext();
        ActionBar bar = getActionBar();

        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.header)));
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        bar.setTitle(R.string.app_name);
        bar.setIcon(R.drawable.ic_drawer);
        prgLoadinglogin = (ProgressBar) findViewById(R.id.prgLoadinglogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNetworkAvailable(getApplicationContext())) {
                    if (edtUsuario.getText().length() != 0 && edtUsuario.getText().toString() != "" && edtPassword.getText().length() != 0 && edtPassword.getText().toString() != "") {
                        AsyncCallLoginWs task = new AsyncCallLoginWs();
                        task.execute();
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.sincredenciales, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.sininter, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public static boolean isNetworkAvailable(Context ct)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) ct.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }


    private class AsyncCallLoginWs extends AsyncTask<Void, Void, String>{

        AsyncCallLoginWs(){
            if(!prgLoadinglogin.isShown()){
                prgLoadinglogin.setVisibility(0);
               // txtAlert.setVisibility(8);
            }
        }

        @Override
        protected String doInBackground(Void... params) {
           return WebService.invokeLoginWS(usuario, password, "login");

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
            prgLoadinglogin.setVisibility(8);
            if(aVoid.equals("OK")){
                Toast.makeText(getApplicationContext(), R.string.bienvenidoempresa, Toast.LENGTH_LONG).show();
                pasarAPrincipal();
            }else if(aVoid.equals("ERR")) {
                Toast.makeText(getApplicationContext(),  R.string.credencialesincorrectas , Toast.LENGTH_LONG).show();
            }
            else if(aVoid.equals("SER")) {
                Toast.makeText(getApplicationContext(), R.string.sinws, Toast.LENGTH_LONG).show();
            }
           // Toast.makeText(getApplicationContext(), aVoid, Toast.LENGTH_LONG).show()
        }
    }

    public void pasarAPrincipal(){
        Intent i = new Intent(getApplicationContext(), MenuPrincipalOpciones.class);
       // i.putExtra("uid", edtUsuario.getText().toString());
        globalVariable.setUid(edtUsuario.getText().toString());
        startActivity(i);

    }




}
