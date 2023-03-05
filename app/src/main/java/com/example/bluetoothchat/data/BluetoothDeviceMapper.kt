package com.example.bluetoothchat.data

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.example.bluetoothchat.domain.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain():BluetoothDeviceDomain{

    return BluetoothDeviceDomain(
        name = name ,
        address = address
    )
}