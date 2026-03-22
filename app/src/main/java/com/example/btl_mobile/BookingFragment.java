package com.example.btl_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BookingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking, container, false);

        RecyclerView rvBookings = view.findViewById(R.id.rvBookings);
        rvBookings.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Phòng Deluxe", "20/03 - 22/03", "Đã đặt"));
        bookings.add(new Booking("Phòng VIP", "10/03 - 12/03", "Đã ở"));

        BookingAdapter adapter = new BookingAdapter(getContext(), bookings);
        rvBookings.setAdapter(adapter);

        return view;
    }
}
