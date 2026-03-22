package com.example.btl_mobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    private Context context;
    private List<Booking> bookingList;

    public BookingAdapter(Context context, List<Booking> bookingList) {
        this.context = context;
        this.bookingList = bookingList;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_booking, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        Booking booking = bookingList.get(position);
        holder.tvRoomName.setText(booking.getRoomName());
        holder.tvDate.setText(booking.getDateRange());
        holder.tvStatus.setText("Trạng thái: " + booking.getStatus());

        holder.btnDetail.setOnClickListener(v -> {
            context.startActivity(new Intent(context, BookingDetailActivity.class));
        });

        holder.btnCancel.setOnClickListener(v -> {
            // Mock cancel logic
        });
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView tvRoomName, tvDate, tvStatus;
        Button btnCancel, btnDetail;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRoomName = itemView.findViewById(R.id.tvBookingRoomName);
            tvDate = itemView.findViewById(R.id.tvBookingDate);
            tvStatus = itemView.findViewById(R.id.tvBookingStatus);
            btnCancel = itemView.findViewById(R.id.btnCancel);
            btnDetail = itemView.findViewById(R.id.btnDetail);
        }
    }
}
