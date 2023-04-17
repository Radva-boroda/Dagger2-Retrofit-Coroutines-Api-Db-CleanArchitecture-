package dev.ronnie.imageloaderdagger2.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.ronnie.imageloaderdagger2.presentation.fragments.FragmentLogin
import dev.ronnie.imageloaderdagger2.presentation.fragments.FragmentPictures
import dev.ronnie.imageloaderdagger2.presentation.fragments.FragmentWelcome

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeWelcomeFragment(): FragmentWelcome

    @ContributesAndroidInjector
    abstract fun contributePictureFragment(): FragmentPictures

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): FragmentLogin
}
