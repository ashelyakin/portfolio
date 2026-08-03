package com.ashelyakin.portfolio.ui.projects

import androidx.compose.ui.graphics.Color
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Модель проекта для страниц "Все проекты" и "Страница проекта".
 */
data class Project(
    val id: String,
    val title: String,
    val category: String,
    val shortDescription: String,
    val fullDescription: String,
    val images: List<String>,
    val coverBackgroundColor: Color = PortfolioColors.ImagePlaceholder,
    val cover: String?,
)

val sampleProjects: List<Project> = listOf(
    Project(
        id = "subaru",
        title = "My Subaru",
        category = "Mobile Apps",
        shortDescription = "Данное приложение является помощником для владельцев автомобилей Subaru.",
        fullDescription = "FitTrack — приложение для отслеживания тренировок и активности. " +
            "Поддерживает синхронизацию с Google Fit, локальное хранение истории через Room " +
            "и построено по паттерну MVVM с чётким разделением слоёв данных и UI.",
        images = listOf(
            "files/subaru/1.png",
            "files/subaru/2.png",
            "files/subaru/3.png",
            "files/subaru/4.png",
            "files/subaru/5.png",
        ),
        cover = "files/subaru/logo.png",
        coverBackgroundColor = PortfolioColors.SubaruBackground,
    ),
    Project(
        id = "subaruPro",
        title = "Subaru Professional",
        category = "Mobile Apps",
        shortDescription = "Каталог рецептов с офлайн-доступом и умным поиском",
        fullDescription = "Мобильное приложение Subaru Professional  для сотрудников дилерской сети SUBARU " +
                "для работы с актуальными сервисными заказ-нарядами и работы с клиентами официальных сервисных центров SUBARU.",
        images = listOf(
            "files/subaru_pro/1.png",
            "files/subaru_pro/2.png",
            "files/subaru_pro/3.png"
        ),
        cover = "files/subaru_pro/logo.png",
        coverBackgroundColor = PortfolioColors.SubaruBackground,
    ),
    Project(
        id = "cubicVision",
        title = "Cubic Vision",
        category = "Mobile Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
            "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "cubicMetrica",
        title = "Cubic Metrica",
        category = "Mobile Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "cubicMetricaControl",
        title = "Cubic Metrica Control",
        category = "Mobile Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "cubicAutoSetup",
        title = "Cubic Auto Setup",
        category = "Mobile Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "ledController",
        title = "LED Controller",
        category = "Mobile Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "takee",
        title = "Takee",
        category = "Mobile Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "roomBooking",
        title = "Room Booking",
        category = "Libraries",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "libAdb",
        title = "Lib ADB",
        category = "Libraries",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "testRunner",
        title = "Test Runner",
        category = "Desktop Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "remoteDesktop",
        title = "ScreenStreamer/RemoteController",
        category = "Desktop Apps",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "cubicMetricaMeetup",
        title = "Cubic Metrica Meetup",
        category = "Meetups",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "testRunnerMeetup",
        title = "Test Runner Meetup",
        category = "Meetups",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
)
