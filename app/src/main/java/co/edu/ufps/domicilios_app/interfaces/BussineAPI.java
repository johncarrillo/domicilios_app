package co.edu.ufps.domicilios_app.interfaces;

import java.util.List;

import co.edu.ufps.domicilios_app.models.Cliente;
import co.edu.ufps.domicilios_app.models.Empresa;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BussineAPI {

    @GET("empresa/listar")
    public Call<List<Empresa>> listarEmpresa();

}
