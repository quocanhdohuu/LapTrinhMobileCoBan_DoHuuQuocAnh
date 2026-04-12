package com.example.btl_datphongkhachsan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btl_datphongkhachsan.R;
import com.example.btl_datphongkhachsan.models.RoomType;
import java.util.List;

public class RoomTypeAdapter extends RecyclerView.Adapter<RoomTypeAdapter.ViewHolder> {

    private List<RoomType> roomTypeList;

    public RoomTypeAdapter(List<RoomType> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_available_room_type, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RoomType roomType = roomTypeList.get(position);
        holder.tvRoomName.setText(roomType.getName());
        holder.tvRoomDesc.setText("Capacity: " + roomType.getCapacity() + " - Available: " + roomType.getAvailableRooms());
        holder.tvPrice.setText("$" + roomType.getDefaultPrice() + " / night");
        
        // Image loading could be added here (e.g., using Glide or Picasso)
    }

    @Override
    public int getItemCount() {
        return roomTypeList == null ? 0 : roomTypeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRoomName, tvRoomDesc, tvPrice;
        ImageView ivRoomImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRoomName = itemView.findViewById(R.id.tvRoomName);
            tvRoomDesc = itemView.findViewById(R.id.tvRoomDesc);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivRoomImage = itemView.findViewById(R.id.ivRoomImage);
        }
    }
}