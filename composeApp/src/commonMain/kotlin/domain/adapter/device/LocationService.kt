package domain.adapter.device

import domain.entity.Coordinate
import kotlinx.coroutines.flow.Flow

interface LocationService {
    suspend fun getCurrentLocation(): Flow<Coordinate>
}