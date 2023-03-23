package dev.ronnie.imageloaderdagger2.presentation.viewmodels
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.ronnie.imageloaderdagger2.api.repository.Repository
import javax.inject.Inject


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/
class LoginFragmentViewModel @Inject constructor(private val repository: Repository, app: Application) :
    AndroidViewModel(app) {

    }
