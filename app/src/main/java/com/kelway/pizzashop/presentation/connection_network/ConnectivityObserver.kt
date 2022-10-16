package com.kelway.pizzashop.presentation.connection_network

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Flow<StatusConnection>
}