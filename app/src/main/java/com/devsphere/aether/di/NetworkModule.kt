package com.devsphere.aether.di

import com.devsphere.aether.data.remote.api.AirQualityApi
import com.devsphere.aether.data.remote.api.GeocodingApi
import com.devsphere.aether.data.remote.api.NowcastApi
import com.devsphere.aether.data.remote.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL_WEATHER = "https://api.open-meteo.com/v1/"
    private const val BASE_URL_GEOCODING = "https://geocoding-api.open-meteo.com/v1/"

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    @Named("weatherRetrofit")
    fun provideWeatherRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_WEATHER)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    @Named("geocodingRetrofit")
    fun provideGeocodingRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_GEOCODING)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideWeatherApi(
        @Named("weatherRetrofit") retrofit: Retrofit
    ): WeatherApi = retrofit.create(WeatherApi::class.java)

    @Provides
    @Singleton
    fun provideNowcastApi(
        @Named("weatherRetrofit") retrofit: Retrofit
    ): NowcastApi = retrofit.create(NowcastApi::class.java)

    @Provides
    @Singleton
    fun provideAirQualityApi(
        @Named("weatherRetrofit") retrofit: Retrofit
    ): AirQualityApi = retrofit.create(AirQualityApi::class.java)

    @Provides
    @Singleton
    fun provideGeocodingApi(
        @Named("geocodingRetrofit") retrofit: Retrofit
    ): GeocodingApi = retrofit.create(GeocodingApi::class.java)
}
