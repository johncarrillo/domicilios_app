package co.edu.ufps.domicilios_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import co.edu.ufps.domicilios_app.R;
import co.edu.ufps.domicilios_app.models.Cliente;

public class ClienteAdapter extends ArrayAdapter {

    private Context context;
    private List<Cliente> empresas;

    public ClienteAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.empresas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.item_view_business, parent, false);

        TextView txtNombreCliente = (TextView) rowView.findViewById(R.id.nombre);
        TextView txtDireccionCliente = (TextView) rowView.findViewById(R.id.direccion);
        TextView txtTelefonoCliente = (TextView) rowView.findViewById(R.id.telefono);

        txtNombreCliente.setText(String.format("Nombre: %s", empresas.get(position).getNombre()));
        txtDireccionCliente.setText(String.format("Direccion: %s", empresas.get(position).getDireccion()));
        txtTelefonoCliente.setText(String.format("Telefono: %s", empresas.get(position).getCelular()));
        return rowView;
    }
}
