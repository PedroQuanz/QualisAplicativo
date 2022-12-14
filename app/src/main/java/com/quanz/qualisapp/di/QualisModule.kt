package com.quanz.qualisapp.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.quanz.qualisapp.db.QualisDatabase
import com.quanz.qualisapp.db.dao.QualisDao
import com.quanz.qualisapp.repository.QualisRepository
import com.quanz.qualisapp.repository.QualisRepositoryImpl
import com.quanz.qualisapp.service.QualisAppService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class QualisModule {

    companion object {

        private const val DATABASE_NAME = "QUALIS_DATABASE_NAME"
        private const val BASE_URL = "https://qualis.ic.ufmt.br/"

        @Provides
        fun montaRetrofit(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

            return Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
        }

        @Provides
        fun providesQualisDao(database: QualisDatabase): QualisDao = database.qualisDao()

        @Provides
        @Singleton
        fun proveDB(@ApplicationContext context: Context): QualisDatabase {
            return databaseBuilder(
                context,
                QualisDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        @Provides
        @Singleton
        fun provideQualisAppService(retrofit: Retrofit): QualisAppService =
            retrofit.create(QualisAppService::class.java)
    }

    @Binds
    abstract fun bindQualisRepository(impl: QualisRepositoryImpl): QualisRepository
}