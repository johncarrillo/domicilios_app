package co.edu.ufps.domicilios_app.ui.domi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import co.edu.ufps.domicilios_app.DetallePedido;
import co.edu.ufps.domicilios_app.Domi;
import co.edu.ufps.domicilios_app.Prueba;
import co.edu.ufps.domicilios_app.R;
import co.edu.ufps.domicilios_app.ui.gallery.GalleryViewModel;

public class DomiFragment extends Fragment {

    private DomiViewModel domiViewModel;
    private Prueba prueba;
private Domi domi;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //domi= (Domi)getActivity();
        domiViewModel =
                new ViewModelProvider(this).get(DomiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_domi, container, false);

        Button button =root.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  domi.verMasBtn(v);
               Intent intent = new Intent(getContext(),DetallePedido.class);
               startActivity(intent);
               getActivity().finish();
            }
        });
        //final TextView textView = root.findViewById(R.id.text_gallery);
        domiViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        return root;

    }


}
