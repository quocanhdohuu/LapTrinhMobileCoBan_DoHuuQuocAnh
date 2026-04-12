package com.example.btl_datphongkhachsan.api;

import com.example.btl_datphongkhachsan.models.LoginRequest;
import com.example.btl_datphongkhachsan.models.LoginResponse;
import com.example.btl_datphongkhachsan.models.RegisterRequest;
import com.example.btl_datphongkhachsan.models.RegisterResponse;
import com.example.btl_datphongkhachsan.models.RoomType;
import com.example.btl_datphongkhachsan.models.SearchAvailableRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/login/customer")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("api/login/register-customer")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("api/get-room-types/search-available")
    Call<List<RoomType>> searchAvailable(@Body SearchAvailableRequest request);
}