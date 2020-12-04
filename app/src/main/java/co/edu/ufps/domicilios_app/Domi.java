package co.edu.ufps.domicilios_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Domi extends AppCompatActivity implements Prueba {

    private Button btnGoMenu;
    private Button btnVerMas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_domi);
        this.btnGoMenu = findViewById(R.id.btnMenu);
        this.btnVerMas = findViewById(R.id.button2);

        /*btnVerMas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "asdasd", Toast.LENGTH_SHORT).show();
                System.out.println("ASD");
            }
        });*/

    }

    public void verMasBtn(View view) {
        Toast.makeText(getApplicationContext(), "asdasd", Toast.LENGTH_SHORT).show();
        System.out.println("ASD");
    }


    @Override
    public void metodo() {

    }
}
