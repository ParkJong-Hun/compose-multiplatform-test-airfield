package infrastructure.device

import AndroidPlatform
import domain.entity.Platform

actual fun getPlatform(): Platform = AndroidPlatform()