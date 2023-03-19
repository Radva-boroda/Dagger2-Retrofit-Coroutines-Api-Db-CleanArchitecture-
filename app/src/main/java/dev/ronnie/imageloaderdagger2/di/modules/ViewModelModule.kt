package dev.ronnie.imageloaderdagger2.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.LoginFragmentViewModel
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesFragmentViewModel
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.ViewModelFactory
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.WelcomeFragmentViewModel
import kotlin.reflect.KClass

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WelcomeFragmentViewModel::class)
    abstract fun bindWelcomeFragmentViewModel(welcomeFragmentViewModel: WelcomeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PicturesFragmentViewModel::class)
    abstract fun bindPicturesFragmentViewModel(picturesFragmentViewModel: PicturesFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginFragmentViewModel::class)
    abstract fun bindLoginFragmentViewModel(loginFragmentViewModel: LoginFragmentViewModel): ViewModel


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
