package com.example.nclships.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.nclships.model.CruiseShip
import com.example.nclships.ui.theme.NCLShipsTheme
import com.example.nclships.util.SHIP_BLISS
import com.example.nclships.util.SHIP_ESCAPE
import com.example.nclships.util.SHIP_SKY
import com.example.nclships.util.ShipState
import com.example.nclships.viewmodel.CruiseShipViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<CruiseShipViewModel>()

        setContent {
            NCLShipsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PickAShipScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun PickAShipScreen(viewModel: CruiseShipViewModel) {
    val shipState = viewModel.shipState.value
    Column {
        ShipInfo(shipState = shipState)
        Row {
            Button(onClick = { viewModel.getSelectedShip(SHIP_SKY) }) {
                Text(text = SHIP_SKY)
            }
            Button(onClick = { viewModel.getSelectedShip(SHIP_BLISS) }) {
                Text(text = SHIP_BLISS)
            }
            Button(onClick = { viewModel.getSelectedShip(SHIP_ESCAPE) }) {
                Text(text = SHIP_ESCAPE)
            }
        }
    }
}

@Composable
fun ShipInfo(shipState: ShipState) {
    shipState.ship?.let { cruiseShip ->
        Column {
            Text(text = "Ship Name: ${cruiseShip.shipName}")
            Text(text = "Passenger Capacity: ${cruiseShip.shipFacts.passengerCapacity}")
            Text(text = "Crew: ${cruiseShip.shipFacts.crew}")
            Text(text = "Inaugural Date: ${cruiseShip.shipFacts.inauguralDate}")
        }
    }
}