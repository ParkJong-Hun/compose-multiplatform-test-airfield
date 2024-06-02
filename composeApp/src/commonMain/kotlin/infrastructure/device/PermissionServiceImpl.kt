package infrastructure.device

import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.PermissionsController
import domain.entity.PermissionDeniedAlwaysException
import domain.entity.PermissionDeniedException
import domain.gateway.device.PermissionService
import infrastructure.mapper.asDataModel
import infrastructure.mapper.asEntity
import domain.entity.Permission as DomainPermission
import domain.entity.PermissionState as DomainPermissionState

class PermissionServiceImpl(
    private val permissionsController: PermissionsController
) : PermissionService {
    override suspend fun requestPermission(permission: DomainPermission) {
        try {
            permissionsController.providePermission(permission.asDataModel())
        } catch (deniedAlways: DeniedAlwaysException) {
            throw PermissionDeniedAlwaysException(permission)
        } catch (denied: DeniedException) {
            throw PermissionDeniedException(permission)
        }
    }

    override suspend fun checkPermission(permission: DomainPermission): DomainPermissionState {
        return permissionsController.getPermissionState(permission.asDataModel()).asEntity()
    }
}