package co.edu.ufps.domicilios_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Domi extends AppCompatActivity {

    private Button btnGoMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_domi);
        this.btnGoMenu = findViewById(R.id.btnMenu);
    }



}
