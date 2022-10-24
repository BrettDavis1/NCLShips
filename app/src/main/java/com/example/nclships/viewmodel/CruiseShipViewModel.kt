package com.example.nclships.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.nclships.repo.CruiseShipRepository
import com.example.nclships.util.ShipState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CruiseShipViewModel : ViewModel() {

    private val _shipState = mutableStateOf(ShipState())
    val shipState: State<ShipState> = _shipState

   fun getSelectedShip(ship: String) {
       viewModelScope.launch(Dispatchers.IO) {
           val cruiseShip = CruiseShipRepository.getCruiseShipResponse(ship)?.body()
           _shipState.value = shipState.value.copy(
               ship = cruiseShip
           )
       }
   }
}