package com.example.coincapapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.coincapapp.models.User
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    private val _loginResult = MutableStateFlow<Result<Unit>>(Result.success(Unit))
    val loginResult: StateFlow<Result<Unit>> = _loginResult

    private val _user = MutableStateFlow<User?>(null)
    val user : StateFlow<User?> = _user

    fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _loginResult.value = Result.success(Unit)
                    val loggedUser = auth.currentUser
                    _user.value = User(id = loggedUser?.uid, email = loggedUser?.email)
                } else {
                    _loginResult.value = Result.failure(task.exception ?: Exception("Error"))
                }
            }
    }

    fun logout() {
        auth.signOut()
        _user.value = null
    }
}