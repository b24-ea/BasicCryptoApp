package com.aldanmaz.berkretrofit.service

import com.aldanmaz.berkretrofit.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //GET , POST , UPDATE , DELETE

    //http://api.nomics.com/v1/
    // prices?key=7745f4f66ada27e886675f80143c527d935454c1

    @GET("prices?key=7745f4f66ada27e886675f80143c527d935454c1")
    fun getData(): Observable<List<CryptoModel>>

// fun getData(): Call<List<CryptoModel>>

}