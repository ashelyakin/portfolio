package com.ashelyakin.portfolio.ui.projects

import androidx.compose.ui.graphics.Color
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Модель проекта для страниц "Все проекты" и "Страница проекта".
 */
data class Project(
    val id: String,
    val title: String,
    val category: ProjectCategory,
    val shortDescription: String,
    val descriptionMdPath: String,
    val images: List<String>,
    val coverBackgroundColor: Color = PortfolioColors.ImagePlaceholder,
    val cover: String?,
)

enum class ProjectCategory(val strName: String){
    ALL("All"),
    MOBILE_APPS("Mobile Apps"),
    DESKTOP_APPS("Desktop apps"),
    LIBRARIES("Libraries"),
    MEETUPS("Meetups")
}

val sampleProjects: List<Project> = listOf(
    Project(
        id = "cubicVision",
        title = "Cubic Vision",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-плеер для digital signage: реклама в реальном времени, киоски и медиа-экраны",
        descriptionMdPath = "files/cubic_vision/description.md",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "cubicMetrica",
        title = "Cubic Metrica",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-приложение компьютерного зрения, которое в реальном времени определяет аудиторию перед цифровым рекламным экраном: пол, возраст, эмоции и фактическое количество людей.",
        descriptionMdPath = "files/cubic_metrica/description.md",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "cubicMetricaControl",
        title = "Cubic Metrica Control",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-приложение для прямого подключения к Cubic Metrica по локальной сети.",
        descriptionMdPath = "files/cubic_metrica_control/description.md",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "subaru",
        title = "My Subaru",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Приложение для владельцев автомобилей Subaru. Онлайн-магазин, личный кабинет, гарантийная книжка, сервисная история, программа лояльности и другое",
        descriptionMdPath = "files/subaru_pro/description.md",
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
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Приложение для сотрудников дилерской сети Subaru для работы с актуальными сервисными заказ-нарядами и работы с клиентами сервисных центров",
        descriptionMdPath = "files/subaru/description.md",
        images = listOf(
            "files/subaru_pro/1.png",
            "files/subaru_pro/2.png",
            "files/subaru_pro/3.png"
        ),
        cover = "files/subaru_pro/logo.png",
        coverBackgroundColor = PortfolioColors.SubaruBackground,
    ),
    Project(
        id = "benefitty",
        title = "Benefitty",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-приложение для получения кешбэков и выгод: хранит бонусные и банковские карты, даёт доступ к картам лояльности друзей и блогеров, начисляет кешбэк за чеки и покупки у партнёров.",
        descriptionMdPath = "files/benefitty/description.md",
        images = listOf(
            "files/subaru_pro/1.png",
            "files/subaru_pro/2.png",
            "files/subaru_pro/3.png"
        ),
        cover = "files/subaru_pro/logo.png",
        coverBackgroundColor = PortfolioColors.SubaruBackground,
    ),
    Project(
        id = "benefittyСashier",
        title = "Benefitty для кассира",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "KMP приложение кассира, которое начисляет баллы программы лояльности за покупки и списывает их в счёт скидки.",
        descriptionMdPath = "files/benefitty_сashier/description.md",
        images = listOf(
            "files/benefitty_сashier/1.png",
            "files/benefitty_сashier/2.png",
            "files/benefitty_сashier/3.png",
            "files/benefitty_сashier/4.png"
        ),
        cover = "files/benefitty_сashier/cover.png",
        coverBackgroundColor = PortfolioColors.SubaruBackground,
    ),
    Project(
        id = "cubicAutoSetup",
        title = "Cubic Auto Setup",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-сервис первоначальной настройки сети на root headless-устройствах, которые работают в торговых залах без монитора и клавиатуры",
        descriptionMdPath = "files/cubic_auto_setup/description.md",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "ledController",
        title = "LED Controller",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        descriptionMdPath = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "roomBooking",
        title = "Room Booking",
        category = ProjectCategory.LIBRARIES,
        shortDescription = "Библиотека поставляющая виджет бронирования переговорных комнат для Cubic Vision",
        descriptionMdPath = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "libAdb",
        title = "Lib ADB",
        category = ProjectCategory.LIBRARIES,
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        descriptionMdPath = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
                "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "testRunner",
        title = "Test Runner",
        category = ProjectCategory.DESKTOP_APPS,
        shortDescription = "Десктопное приложение, которое управляет полным циклом прогонов автотестов Android-плеера Cubic Vision",
        descriptionMdPath = "files/test_runner/description.md",
        images = emptyList(),
        cover = "",
    ),
    Project(
        id = "cubicMetricaMeetup",
        title = "Cubic Metrica Meetup",
        category = ProjectCategory.MEETUPS,
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        descriptionMdPath = "files/cubic_metrica_meetup/description.md",
        images = generateFilePaths(1..17, prefix = "files/cubic_metrica_meetup/", suffix = ".JPG"),
        cover = "files/cubic_metrica_meetup/cover.jpg",
    ),
    Project(
        id = "testRunnerMeetup",
        title = "Test Runner Meetup",
        category = ProjectCategory.MEETUPS,
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        descriptionMdPath = "files/test_runner_meetup/description.md",
        images = generateFilePaths(1..17, prefix = "files/test_runner_meetup/", suffix = ".JPG"),
        cover = "files/test_runner_meetup/cover.jpg",
    ),
)

fun generateFilePaths(range: IntRange, prefix: String = "", suffix: String = ""): List<String> {
    return range.map { "$prefix$it$suffix" }
}
