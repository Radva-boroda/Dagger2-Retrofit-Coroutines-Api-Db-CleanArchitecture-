package dev.ronnie.imageloaderdagger2.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dev.ronnie.imageloaderdagger2.data.model.ImagesResponse
import dev.ronnie.imageloaderdagger2.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/
class WelcomeFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel()
