package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtusu, edtpass;
    Button btnlgoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusu = (EditText)findViewById(R.id.txtusuario);
        edtpass = (EditText)findViewById(R.id.txtpassword);
        btnlgoin = (Button)findViewById(R.id.btnlogin);


        btnlgoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String usu = edtusu.getText().toString();
             String pass = edtpass.getText().toString();

             Validate(edtusu.getText().toString(),edtpass.getText().toString());
            }
        });

    }
    public void Validate(String usuario,String pass){

        if (pass.equals("123")) {

            Intent intent = new Intent(MainActivity.this,PrincipalActivity.class);

            boolean priv = false;

                if (usuario.equals("admin")){
                    priv = true;
                }

            intent.putExtra("nombre",usuario);
            intent.putExtra("privilegio",priv);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Usuario o contraseña no existe", Toast.LENGTH_SHORT).show();
        }

    }


}