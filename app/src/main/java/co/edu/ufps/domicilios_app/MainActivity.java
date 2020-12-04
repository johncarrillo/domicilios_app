package co.edu.ufps.domicilios_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import co.edu.ufps.domicilios_app.interfaces.ClienteAPI;
import co.edu.ufps.domicilios_app.models.Cliente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    TextInputEditText textUser;
    TextInputEditText textPassword;
    Button btnSignIn;
    Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        this.textUser = findViewById(R.id.textLoginUser);
        this.textPassword = findViewById(R.id.textLoginPassword);
        this.btnSignIn = findViewById(R.id.btnSignIn);
        this.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin(textUser.getText().toString(), textPassword.getText().toString());
            }
        });
        this.btnListar = findViewById(R.id.btnListar);
        this.btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hola", Toast.LENGTH_SHORT);
                listarClientes();
            }
        });
    }

    private void  listarClientes () {
        Retrofit retrifit = new Retrofit.Builder().baseUrl("http://192.168.1.3:8081/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ClienteAPI clienteApi =  retrifit.create(ClienteAPI.class);
        Call<List<Cliente>> call = clienteApi.listarClientes();
        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Cliente> listaClientes = response.body();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de Conexion", Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);
    }

    private void signin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Authentication Exitosa.",
                                    Toast.LENGTH_SHORT).show();
                            appIn();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void createUser (View view) {
        Intent intent = new Intent(this, CreateUser.class);
        startActivity(intent);
    }

    public void appIn () {
        Intent intent = new Intent(this, IndexActivity.class);
        startActivity(intent);
    }

}