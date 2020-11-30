package co.edu.ufps.domicilios_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SalesCart extends AppCompatActivity {

    private Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_cart);
    }

    public void goAddress(View view) {
        Intent intent = new Intent(this, DireccionActivity.class);
        startActivity(intent);
    }
}