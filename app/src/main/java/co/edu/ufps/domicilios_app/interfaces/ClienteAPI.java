package co.edu.ufps.domicilios_app.interfaces;

import java.util.List;

import co.edu.ufps.domicilios_app.models.Cliente;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClienteAPI {

    @GET("cliente/listar")
    public Call<List<Cliente>> listarClientes();

    @POST("cliente/registrar")
    Call<ResponseBody> createBussine(@Body Cliente cliente) ;


}
