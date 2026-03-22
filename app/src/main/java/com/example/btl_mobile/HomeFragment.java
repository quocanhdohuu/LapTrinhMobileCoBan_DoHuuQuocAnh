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

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView rvRooms = view.findViewById(R.id.rvRooms);
        rvRooms.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Phòng Deluxe", "500.000đ / đêm", 4));
        rooms.add(new Room("Phòng VIP", "900.000đ / đêm", 5));
        rooms.add(new Room("Phòng Standard", "300.000đ / đêm", 3));

        RoomAdapter adapter = new RoomAdapter(getContext(), rooms);
        rvRooms.setAdapter(adapter);

        return view;
    }
}
