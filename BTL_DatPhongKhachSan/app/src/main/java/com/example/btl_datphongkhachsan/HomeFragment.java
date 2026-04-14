package com.example.btl_datphongkhachsan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btl_datphongkhachsan.adapters.RoomTypeAdapter;
import com.example.btl_datphongkhachsan.api.RetrofitClient;
import com.example.btl_datphongkhachsan.models.RoomType;
import com.example.btl_datphongkhachsan.models.SearchAvailableRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private TextView tvCheckIn, tvCheckOut;
    private EditText etGuests, etRooms;
    private RecyclerView rvAvailableRoomTypes, rvOurSuites;
    private RoomTypeAdapter availabilityAdapter, suitesAdapter;
    private List<RoomType> availableRoomTypes = new ArrayList<>();
    private List<RoomType> allRoomTypes = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvCheckIn = view.findViewById(R.id.tvCheckIn);
        tvCheckOut = view.findViewById(R.id.tvCheckOut);
        etGuests = view.findViewById(R.id.etGuests);
        etRooms = view.findViewById(R.id.etRooms);
        rvAvailableRoomTypes = view.findViewById(R.id.rvAvailableRoomTypes);
        rvOurSuites = view.findViewById(R.id.rvOurSuites);
        Button btnCheckAvailability = view.findViewById(R.id.btnCheckAvailability);

        // Setup DatePickers
        view.findViewById(R.id.tvCheckIn).setOnClickListener(v -> showDatePicker(tvCheckIn));
        view.findViewById(R.id.tvCheckOut).setOnClickListener(v -> showDatePicker(tvCheckOut));

        // Setup RecyclerView for Availability
        availabilityAdapter = new RoomTypeAdapter(availableRoomTypes);
        rvAvailableRoomTypes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvAvailableRoomTypes.setAdapter(availabilityAdapter);

        // Setup RecyclerView for Our Suites
        suitesAdapter = new RoomTypeAdapter(allRoomTypes);
        rvOurSuites.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvOurSuites.setAdapter(suitesAdapter);

        btnCheckAvailability.setOnClickListener(v -> performSearch());

        // Load all room types for Our Suites
        loadAllRoomTypes();

        return view;
    }

    private void showDatePicker(TextView textView) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year1, monthOfYear, dayOfMonth) -> {
            String selectedDate = String.format(Locale.getDefault(), "%d-%02d-%02d", year1, (monthOfYear + 1), dayOfMonth);
            textView.setText(selectedDate);
        }, year, month, day);
        datePickerDialog.show();
    }

    private void loadAllRoomTypes() {
        RetrofitClient.getApiService().getAllRoomTypes().enqueue(new Callback<List<RoomType>>() {
            @Override
            public void onResponse(Call<List<RoomType>> call, Response<List<RoomType>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    allRoomTypes.clear();
                    allRoomTypes.addAll(response.body());
                    suitesAdapter.notifyDataSetChanged();
                } else {
                    Log.e("HOME_FRAGMENT", "Error loading all room types: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<RoomType>> call, Throwable t) {
                Log.e("API_ERROR", "Failed to load all room types: " + t.getMessage());
            }
        });
    }

    private void performSearch() {
        String checkIn = tvCheckIn.getText().toString();
        String checkOut = tvCheckOut.getText().toString();
        
        int guests = 1;
        int rooms = 1;
        try {
            guests = Integer.parseInt(etGuests.getText().toString());
            rooms = Integer.parseInt(etRooms.getText().toString());
        } catch (NumberFormatException e) {
            Log.e("HOME_FRAGMENT", "Invalid input for guests or rooms");
        }

        SearchAvailableRequest request = new SearchAvailableRequest(checkIn, checkOut, guests, rooms);

        RetrofitClient.getApiService().searchAvailable(request).enqueue(new Callback<List<RoomType>>() {
            @Override
            public void onResponse(Call<List<RoomType>> call, Response<List<RoomType>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    availableRoomTypes.clear();
                    availableRoomTypes.addAll(response.body());
                    availabilityAdapter.notifyDataSetChanged();
                    
                    if (availableRoomTypes.isEmpty()) {
                        Toast.makeText(getContext(), "Không có phòng trống cho yêu cầu này", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Lỗi khi lấy dữ liệu phòng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RoomType>> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
                Toast.makeText(getContext(), "Lỗi kết nối server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}