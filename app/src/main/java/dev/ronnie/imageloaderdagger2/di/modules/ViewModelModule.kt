package dev.ronnie.imageloaderdagger2.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.LoginViewModel
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesViewModel
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.ViewModelFactory
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.WelcomeViewModel
import kotlin.reflect.KClass

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    abstract fun bindWelcomeViewModel(welcomeViewModel: WelcomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PicturesViewModel::class)
    abstract fun bindPicturesViewModel(picturesViewModel: PicturesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
