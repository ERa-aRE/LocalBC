package com.example.bluetoothchat.presentation

import com.example.bluetoothchat.domain.chat.BluetoothDevice
import com.example.bluetoothchat.domain.chat.BluetoothDeviceDomain

data class BluetoothUiState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
)