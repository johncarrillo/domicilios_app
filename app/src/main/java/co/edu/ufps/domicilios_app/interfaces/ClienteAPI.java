package co.edu.ufps.domicilios_app.interfaces;

import java.util.List;

import co.edu.ufps.domicilios_app.models.Cliente;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClienteAPI {

    @GET("cliente/listar")
    public Call<List<Cliente>> listarClientes();
}
