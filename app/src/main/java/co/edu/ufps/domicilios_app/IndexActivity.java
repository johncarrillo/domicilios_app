package co.edu.ufps.domicilios_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import co.edu.ufps.domicilios_app.adapter.EmpresaAdapter;
import co.edu.ufps.domicilios_app.interfaces.BussineAPI;
import co.edu.ufps.domicilios_app.interfaces.ClienteAPI;
import co.edu.ufps.domicilios_app.models.Cliente;
import co.edu.ufps.domicilios_app.models.Empresa;
import co.edu.ufps.domicilios_app.ui.slideshow.SlideshowFragment;
import co.edu.ufps.domicilios_app.util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IndexActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FloatingActionButton floatingActionButton;
    ListView listBussinessView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        floatingActionButton = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goShoppingCar();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.listBussinessView = (ListView) findViewById(R.id.listViewBussiness);
        this.listarClientes();
        this.listBussinessView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("ENTRE");
                Toast.makeText(IndexActivity.this, "Me clickeo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void  listarClientes () {
        Retrofit retrifit = Constant.getRetrofit();
        BussineAPI bussineAPI =  retrifit.create(BussineAPI.class);
        Call<List<Empresa>> call = bussineAPI.listarEmpresa();
        call.enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Empresa> listBusiness = response.body();
                        listBussinessView.setAdapter(new EmpresaAdapter(IndexActivity.this, R.layout.item_view_business, listBusiness));
                        for (Empresa empresa: listBusiness) {
                            System.out.println(empresa.getNombre() + " - " + empresa.getNit()
                                    + " - " + empresa.getDireccion() + " - " + empresa.getImagen());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    Toast.makeText(IndexActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                Toast.makeText(IndexActivity.this, "Error de Conexion", Toast.LENGTH_SHORT);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    public void goShoppingCar() {
        Intent intent = new Intent(this, SalesCart.class);
        startActivity(intent);
    }
    public void goMenu(View view) {
        System.out.println("!<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        Fragment fragment = new SlideshowFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}