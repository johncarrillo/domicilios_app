package co.edu.ufps.domicilios_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.edu.ufps.domicilios_app.IndexActivity;
import co.edu.ufps.domicilios_app.MainActivity;
import co.edu.ufps.domicilios_app.MenuRestaurant;
import co.edu.ufps.domicilios_app.R;
import co.edu.ufps.domicilios_app.models.Cliente;
import co.edu.ufps.domicilios_app.models.Empresa;

public class EmpresaAdapter extends ArrayAdapter {

    private Context context;
    private List<Empresa> empresas;

    public EmpresaAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.empresas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.item_view_business, parent, false);

        TextView txtBussinessName = (TextView) rowView.findViewById(R.id.bussineName);
        TextView txtBussinessType = (TextView) rowView.findViewById(R.id.bussineType);
        TextView txtBussinessDescription = (TextView) rowView.findViewById(R.id.bussineDescription);
        ImageView imgView = (ImageView) rowView.findViewById(R.id.viewImage);
        Button btnGoMenu = (Button) rowView.findViewById(R.id.btnMenu);
        //TextView txtBussinessImage = (TextView) rowView.findViewById(R.id.bussineImage);

        txtBussinessName.setText(empresas.get(position).getNombre());
        txtBussinessDescription.setText(empresas.get(position).getDescripcion());
        txtBussinessType.setText(empresas.get(position).getTipo());

        Picasso.get()
                .load(empresas.get(position).getImagen())
                .error(R.mipmap.ic_launcher_round)
                .into(imgView);

        return rowView;
    }

}
