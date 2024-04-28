package com.example.hellojava.ui.dashboard;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hellojava.R;
import com.example.hellojava.databinding.FragmentDashboardBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DashboardFragment extends Fragment implements LocationListener {

    Location lastLocation;

    LocationManager locationManager;

    public TextInputEditText locationLatitudeInfo;



    public TextInputEditText locationLongitudeInfo;
    public TextInputEditText locationInfo;
    

    public  FragmentDashboardBinding binding;

    Location currentLocation;
    public String currentLocationInfo;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);




        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        locationLongitudeInfo = root.findViewById(R.id.locationLongitudeInfo);
        locationLatitudeInfo = root.findViewById(R.id.locationLatitudeInfo);
        locationInfo = root.findViewById(R.id.locationInfo);
        return root;
    }




    @Override
    public void onStart() {
        startLocation();
        onLocationInfo();
        onLocationToAddress(lastLocation);
        super.onStart();

    }

    @Override
    public void onStop() {

        super.onStop();
    }

    private void startLocation()
    {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, this);

        lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);





    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onLocationChanged(Location location) {

        String msg = "Updated Location:" +
                Double.toString(location.getLatitude()) + "," +
                Double.toString(location.getLongitude());
        Log.e(TAG, msg);

        lastLocation = location;
        if (lastLocation != null) {
            String stringLong= Double.toString(location.getLongitude());
            String stringLat= Double.toString(location.getLatitude());
            locationLatitudeInfo.setText(stringLat);
            locationLongitudeInfo.setText(stringLong);
        } else {
            Log.e(TAG, "LocationManager is null");

        }


    }


    public String onLocationToAddress(Location location){

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Geocoder geocoder;
        List<Address> addresses;
        Locale finnish = new Locale("fi", "FI");
        geocoder = new Geocoder(getContext(), finnish);

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent maxResults
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String address = addresses.get(0).getAddressLine(0); // getAddressLine returns a line of the address
        // numbered by the given index
        String city = addresses.get(0).getLocality();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();

        Log.e(TAG, "onLocationToAddress: " + address + ", " + city + ", " + country + ", " + postalCode);
        return address;

    }
    public void onLocationInfo()
    {

        String s = onLocationToAddress(lastLocation);
        Log.d(TAG, "onLocationInfo: " + s);
        if (lastLocation != null) {

            locationInfo.setText(s);
        } else {
            Log.e(TAG, "LocationManager1 is null");

        }
    }
}