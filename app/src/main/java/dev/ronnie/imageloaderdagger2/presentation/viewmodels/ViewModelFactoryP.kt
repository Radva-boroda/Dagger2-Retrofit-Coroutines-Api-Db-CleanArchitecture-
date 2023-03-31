//package dev.ronnie.imageloaderdagger2.presentation.viewmodels
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import dev.ronnie.imageloaderdagger2.api.repository.Repository
//
//class ViewModelFactoryP constructor(private val repository: Repository): ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return if (modelClass.isAssignableFrom(PicturesFragmentViewModel::class.java)) {
//            PicturesFragmentViewModel(this.repository) as T
//        } else {
//            throw IllegalArgumentException("ViewModel Not Found")
//        }
//    }
//}

