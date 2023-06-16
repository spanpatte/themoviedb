package common.dagger


import com.example.thelatestmovies.moviefeature.Configs
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
//Common module for other features as well.
@Module
class NetworkModule {
    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Configs.movieApiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}