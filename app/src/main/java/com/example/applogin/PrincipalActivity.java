package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    Button btnlogout;
    TextView txtBienvenida;
    Spinner spn;

    @Override
    public  void  onBackPressed(){
        super.onBackPressed();
        this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_principal);
        
        btnlogout=(Button)findViewById(R.id.btnlogout);
        txtBienvenida=(TextView)findViewById(R.id.txtwelcome);
        spn=(Spinner)findViewById(R.id.spinner);

        String name = getIntent().getStringExtra("nombre").toUpperCase();
        boolean privi= getIntent().getBooleanExtra("privilegio",false);

        txtBienvenida.setText("Bienvenido usuario: "+name);

        if(privi = true){
            Toast.makeText(this, "Eres administrador", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show();

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnlogout == v){
                    Intent intent = new Intent(PrincipalActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
