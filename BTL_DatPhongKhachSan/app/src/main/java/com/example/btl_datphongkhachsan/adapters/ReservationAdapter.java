package com.example.btl_datphongkhachsan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btl_datphongkhachsan.R;
import com.example.btl_datphongkhachsan.models.Reservation;
import java.util.List;
import java.util.Locale;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ViewHolder> {

    private List<Reservation> reservationList;

    public ReservationAdapter(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Reservation res = reservationList.get(position);
        holder.tvBookingID.setText("BOOKING ID: #CRT-" + res.getReservationID());
        holder.tvBookingRoomType.setText(res.getRoomType() + " Room");
        holder.tvBookingPrice.setText(String.format(Locale.getDefault(), "%,.0f VNĐ", res.getTotalAmount()));
        holder.tvBookingStatus.setText(res.getStatus());
        holder.tvBookingCheckIn.setText(formatDate(res.getCheckIn()));
        holder.tvBookingCheckOut.setText(formatDate(res.getCheckOut()));
    }

    private String formatDate(String dateStr) {
        if (dateStr == null || dateStr.length() < 10) return dateStr;
        return dateStr.substring(0, 10);
    }

    @Override
    public int getItemCount() {
        return reservationList == null ? 0 : reservationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBookingID, tvBookingRoomType, tvBookingPrice, tvBookingStatus, tvBookingCheckIn, tvBookingCheckOut;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBookingID = itemView.findViewById(R.id.tvBookingID);
            tvBookingRoomType = itemView.findViewById(R.id.tvBookingRoomType);
            tvBookingPrice = itemView.findViewById(R.id.tvBookingPrice);
            tvBookingStatus = itemView.findViewById(R.id.tvBookingStatus);
            tvBookingCheckIn = itemView.findViewById(R.id.tvBookingCheckIn);
            tvBookingCheckOut = itemView.findViewById(R.id.tvBookingCheckOut);
        }
    }
}