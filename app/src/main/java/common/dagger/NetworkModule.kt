package common.dagger
import com.spanpatte.thelatestmovies.BuildConfig
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
            .baseUrl(BuildConfig.TMDB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}