package dev.ronnie.imageloaderdagger2.presentation.viewmodels
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.ronnie.imageloaderdagger2.dataa.repository.Repository
import javax.inject.Inject


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/
class LoginViewModel @Inject constructor(private val repository: Repository, app: Application) :
    AndroidViewModel(app) {
    }
