package com.example.prachi.project;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//import com.abhiandroid.GoogleMaps.googlemaps.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    private GoogleMap mMap;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);


        dl = findViewById(R.id.maps);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.profile: {
                        Toast.makeText(MapsActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.home: {
                        Intent home = new Intent(MapsActivity.this, MapsActivity.class);
                        startActivity(home);
                        break;
                    }
                    case R.id.booking_history: {
                        Intent booking = new Intent(MapsActivity.this, Booking_History.class);
                        startActivity(booking);
                        break;
                    }
                    case R.id.settings: {
                        Intent setting = new Intent(MapsActivity.this, Setting.class);
                        startActivity(setting);
                        break;
                    }
                    case R.id.help: {
                        Intent help = new Intent(MapsActivity.this, Help.class);
                        startActivity(help);
                        break;
                    }
                    default:
                        return true;
                }


                return true;
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker arg0) {
                if(arg0 != null && arg0.getTitle().equals("Pacific Mall")){
                    Intent intent1 = new Intent(MapsActivity.this, Card.class);
                    startActivity(intent1);}

                if(arg0 != null && arg0.getTitle().equals("IGI Airport")){
                    Intent intent2 = new Intent(MapsActivity.this, Card.class);
                    startActivity(intent2);}

                if(arg0 != null && arg0.getTitle().equals("Metro Station")){
                    Intent intent3 = new Intent(MapsActivity.this, SeatSelection.class);
                    startActivity(intent3);}

                if(arg0 != null && arg0.getTitle().equals("JIMS Parking")){
                    Intent intent4 = new Intent(MapsActivity.this, SeatSelection.class);
                    startActivity(intent4); }
                if(arg0 != null && arg0.getTitle().equals("Shastri Park Metro Station")){
                    Intent intent5 = new Intent(MapsActivity.this, SeatSelection.class);
                    startActivity(intent5);}
                if(arg0 != null && arg0.getTitle().equals("Janak Puri District Centre")){
                    Intent intent6 = new Intent(MapsActivity.this, SeatSelection.class);
                    startActivity(intent6);}
                if(arg0 != null && arg0.getTitle().equals("DLF Mall of India")){
                    Intent intent7 = new Intent(MapsActivity.this, Card.class);
                    startActivity(intent7);}

                if(arg0 != null && arg0.getTitle().equals("NSP Metro Station")){
                    Intent intent8 = new Intent(MapsActivity.this, SeatSelection.class);
                    startActivity(intent8); }

                if(arg0 != null && arg0.getTitle().equals("New Delhi Railway Station")){
                    Intent intent9 = new Intent(MapsActivity.this, SeatSelection.class);
                    startActivity(intent9); }
            }
        });
        LatLng india = new LatLng(28.642735, 77.106266);
        LatLng india2 = new LatLng(28.554604, 77.088355);
        LatLng india3 = new LatLng(28.641632, 77.221839);
        LatLng india4 = new LatLng(28.718855, 77.109049);
        LatLng india5 = new LatLng(28.6683042, 77.2502519);
        LatLng india6 = new LatLng(28.6297213, 77.0800721);
        LatLng india7 = new LatLng(28.5673683, 77.3209237);
        LatLng india8 = new LatLng(28.6937902, 77.1529732);
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india)
                .title("Pacific Mall")
                .snippet("Tap here to Park Car"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india2)
                .title("IGI Airport")
                .snippet("Tap here to Park Car"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india3)
                .title("New Delhi Railway Station")
                .snippet("Tap here to Park Car"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india4)
                .title("JIMS Parking")
                .snippet("Tap here to Park Car"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india5)
                .title("Shastri Park Metro Station")
                .snippet("Tap here to Park Car"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india6)
                .title("Janak Puri District Centre")
                .snippet("Tap here to Park Car"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india7)
                .title("DLF Mall of India")
                .snippet("Tap here to Park Car"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.parkin))
                .position(india8)
                .title("NSP Metro Station")
                .snippet("Tap here to Park Car"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india2));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india4));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india5));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india6));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india7));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india8));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                    mLocationRequest, this);
        }
    }


    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
   //Showing Current Location Marker on Map
      LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(new Criteria(), true);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location locations = locationManager.getLastKnownLocation(provider);
        List<String> providerList = locationManager.getAllProviders();
        if (null != locations && null != providerList && providerList.size() > 0) {
            double longitude = locations.getLongitude();
            double latitude = locations.getLatitude();
            Geocoder geocoder = new Geocoder(getApplicationContext(),
                    Locale.getDefault());
            try {
                List<Address> listAddresses = geocoder.getFromLocation(latitude,
                        longitude, 1);
                if (null != listAddresses && listAddresses.size() > 0) {
                    String state = listAddresses.get(0).getAdminArea();
                    String country = listAddresses.get(0).getCountryName();
                    String subLocality = listAddresses.get(0).getSubLocality();
                    markerOptions.title("" + latLng + "," + subLocality + "," + state
                            + "," + country);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       // mCurrLocationMarker = mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,
                    this);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "permission denied",
                            Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                int position = (int) (marker.getTag());
                //Using position get Value from arraylist
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}
