package com.example.appfinalunisinu.ui.campus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.appfinalunisinu.R;
import com.example.appfinalunisinu.databinding.FragmentCampusBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.CameraPosition;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;



public class CampusFragment extends Fragment implements OnMapReadyCallback {

    private FragmentCampusBinding binding;
    private GoogleMap googleMap;
    private MapView mapView;

    private DrawerLayout drawerLayout;











    private final LatLng block7 = new LatLng(8.768104, -75.887335);
    private final LatLng block2 = new LatLng(8.767594, -75.885543);
    private final LatLng block1 = new LatLng(8.767445, -75.885577);

    private List<Amigos> listaAmigos = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCampusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mapView = binding.mapView;
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        listaAmigos.add(new Amigos("Eduardo De La Hoz", 104462));



        Button button1 = root.findViewById(R.id.button1);
        Button button2 = root.findViewById(R.id.button2);
        Button button3 = root.findViewById(R.id.button3);

        button1.setOnClickListener(v -> moveCamera(block7));

        button2.setOnClickListener(v -> moveCamera(block2));

        button3.setOnClickListener(v -> moveCamera(block1));

        ImageButton buttonInterrogation1 = root.findViewById(R.id.buttoninterrogation1);
        buttonInterrogation1.setOnClickListener(v -> showInfoDialog(R.layout.dialog_info));
        ImageButton buttonInterrogation2 = root.findViewById(R.id.buttoninterrogation2);
        buttonInterrogation2.setOnClickListener(v -> showInfoDialog(R.layout.dialog_info_bloque2));
        ImageButton buttonInterrogation3 = root.findViewById(R.id.buttoninterrogation3);
        buttonInterrogation3.setOnClickListener(v -> showInfoDialog(R.layout.dialog_info_bloque_derecho));


        ImageButton buttonAmigos = root.findViewById(R.id.amigos);
        buttonAmigos.setOnClickListener(v -> {
            if (drawerLayout != null){
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });








        return root;

    }







    private void showInfoDialog(int layoutId) {
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(layoutId);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button closeButton = dialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> dialog.dismiss());
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);


        button1.setOnClickListener(v -> moveCamera(block7));

        button2.setOnClickListener(v -> moveCamera(block2));

        button3.setOnClickListener(v -> moveCamera(block1));

        drawerLayout = view.findViewById(R.id.drawerLayout);

        RecyclerView amigosRecyclerView = view.findViewById(R.id.amigosRecyclerView);
        amigosRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        AmigosAdapter amigosAdapter = new AmigosAdapter(listaAmigos);
        amigosRecyclerView.setAdapter(amigosAdapter);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {


        googleMap = map;
        googleMap.addMarker(new MarkerOptions().position(block7).title("Bloque 7"));
        googleMap.addMarker(new MarkerOptions().position(block2).title("Bloque 2"));
        googleMap.addMarker(new MarkerOptions().position(block1).title("Bloque 1"));

        LatLng initialLocation = new LatLng(8.767572, -75.885955);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(initialLocation)
                .zoom(16)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    private void moveCamera(LatLng location) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(location)
                .zoom(18)
                .build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }



}

