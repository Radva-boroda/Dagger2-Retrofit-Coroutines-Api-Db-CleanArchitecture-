package dev.ronnie.imageloaderdagger2.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.ronnie.imageloaderdagger2.presentation.fragments.LoginFragment
import dev.ronnie.imageloaderdagger2.presentation.fragments.PicturesFragment
import dev.ronnie.imageloaderdagger2.presentation.fragments.WelcomeFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeWelcomeFragment(): WelcomeFragment

    @ContributesAndroidInjector
    abstract fun contributePictureFragment(): PicturesFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}
