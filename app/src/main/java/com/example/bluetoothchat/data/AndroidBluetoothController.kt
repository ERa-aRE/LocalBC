package com.example.bluetoothchat.data

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import com.example.bluetoothchat.domain.chat.BluetoothController
import com.example.bluetoothchat.domain.chat.BluetoothDeviceDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


@SuppressLint("MissingPermission")
class AndroidBluetoothController(
    private val context:Context
):BluetoothController {
    init {
        updatePairedDevices()
    }
    private val bluetoothManager by lazy{
        context.getSystemService(BluetoothManager::class.java)
    }
    private val bluetoothAdapter by lazy{
        bluetoothManager?.adapter
    }
    private val _scannedDevices = MutableStateFlow<List<BluetoothDeviceDomain>>(emptyList())
    override val scannedDevices: StateFlow<List<BluetoothDeviceDomain>>
        get() = _scannedDevices.asStateFlow()

    private val _pairedDevices = MutableStateFlow<List<BluetoothDeviceDomain>>(emptyList())
    override val pairedDevices: StateFlow<List<BluetoothDeviceDomain>>
        get() = _pairedDevices.asStateFlow()

    override fun startDiscovery() {
        TODO("Not yet implemented")
    }

    override fun stopDiscovery() {
        TODO("Not yet implemented")
    }

    override fun release() {
        TODO("Not yet implemented")
    }
    private fun updatePairedDevices(){
        if(!hasPermission(Manifest.permission.BLUETOOTH_CONNECT)){
            return
        }
        bluetoothAdapter
            ?.bondedDevices
            ?.map{
                it.toBluetoothDeviceDomain()
            }
            ?.also{
                devices->
                _pairedDevices.update { devices }
            }
    }

    private fun hasPermission(permission:String):Boolean{
        return context.checkSelfPermission(permission)==PackageManager.PERMISSION_GRANTED
    }
}