package co.edu.ufps.domicilios_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuRestaurant extends AppCompatActivity {

    private Button btnGoMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restaurant);
        this.btnGoMenu = findViewById(R.id.btnMenu);

    }

}