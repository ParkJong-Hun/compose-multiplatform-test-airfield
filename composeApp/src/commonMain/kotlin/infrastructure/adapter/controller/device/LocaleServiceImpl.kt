package infrastructure.adapter.controller.device

import domain.entity.Locale
import domain.adapter.device.LocaleService

class LocaleServiceImpl : LocaleService {
    override fun getLocale(): Locale = Locale.fromLanguageCode(getLocale)
}