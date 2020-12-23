package co.edu.ufps.domicilios_app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import co.edu.ufps.domicilios_app.MenuRestaurant;
import co.edu.ufps.domicilios_app.R;
import co.edu.ufps.domicilios_app.ui.slideshow.SlideshowFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button btnMenu;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // View v = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        btnMenu=(Button)root.findViewById(R.id.btnMenu);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        /*btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMenu();
            }
        });*/
        return root;

    }

    public void goMenu(View view) {
        System.out.println("545");
        Fragment fragment = new SlideshowFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_slideshow, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        FragmentTransaction t = this.getFragmentManager().beginTransaction();
        Fragment mFrag = new SlideshowFragment();
        t.replace(R.id.nav_home, mFrag);
        t.commit();
    }
}