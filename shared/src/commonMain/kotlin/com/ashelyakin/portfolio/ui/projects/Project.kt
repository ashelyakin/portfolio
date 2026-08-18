package com.ashelyakin.portfolio.ui.projects

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
    val coverContentScale: ContentScale = ContentScale.Crop,
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
        images = generateFilePaths(2..7, prefix = "files/cubic_vision/", suffix = ".jpg"),
        cover = "files/cubic_vision/cover.jpg",
    ),
    Project(
        id = "cubicMetrica",
        title = "Cubic Metrica",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-приложение компьютерного зрения, которое в реальном времени определяет аудиторию перед цифровым рекламным экраном: пол, возраст, эмоции и фактическое количество людей",
        descriptionMdPath = "files/cubic_metrica/description.md",
        images = generateFilePaths(1..1, prefix = "files/cubic_metrica/", suffix = ".jpg"),
        cover = "files/cubic_metrica/cover.jpg",
    ),
    Project(
        id = "subaru",
        title = "My Subaru",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Приложение для владельцев автомобилей Subaru. Онлайн-магазин, личный кабинет, гарантийная книжка, сервисная история, программа лояльности и другое",
        descriptionMdPath = "files/subaru/description.md",
        images = generateFilePaths(1..5, prefix = "files/subaru/", suffix = ".png"),
        cover = "files/subaru/cover.png",
        coverBackgroundColor = PortfolioColors.SubaruBackground,
    ),
    Project(
        id = "subaruPro",
        title = "Subaru Professional",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Приложение для сотрудников дилерской сети Subaru для работы с актуальными сервисными заказ-нарядами и работы с клиентами сервисных центров",
        descriptionMdPath = "files/subaru_pro/description.md",
        images = generateFilePaths(1..3, prefix = "files/subaru_pro/", suffix = ".png"),
        cover = "files/subaru_pro/cover.png",
        coverBackgroundColor = PortfolioColors.SubaruBackground,
    ),
    Project(
        id = "cubicMetricaControl",
        title = "Cubic Metrica Control",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-приложение для прямого подключения к Cubic Metrica по локальной сети.",
        descriptionMdPath = "files/cubic_metrica_control/description.md",
        images = generateFilePaths(1..2, prefix = "files/cubic_metrica_control/", suffix = ".jpg"),
        cover = "files/cubic_metrica_control/cover.jpg",
    ),
    Project(
        id = "testRunner",
        title = "Test Runner",
        category = ProjectCategory.DESKTOP_APPS,
        shortDescription = "Десктопное приложение, которое управляет полным циклом прогонов автотестов Android-плеера Cubic Vision",
        descriptionMdPath = "files/test_runner/description.md",
        images = generateFilePaths(1..4, prefix = "files/test_runner/", suffix = ".jpg"),
        cover = "files/test_runner/cover.jpg",
    ),
    Project(
        id = "benefitty",
        title = "Benefitty",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-приложение для получения кешбэков и выгод: хранит бонусные и банковские карты, даёт доступ к картам лояльности друзей и блогеров, начисляет кешбэк за чеки и покупки у партнёров",
        descriptionMdPath = "files/benefitty/description.md",
        images = generateFilePaths(1..5, prefix = "files/benefitty/", suffix = ".jpg"),
        cover = "files/benefitty/cover.jpg",
    ),
    Project(
        id = "benefittyСashier",
        title = "Benefitty для кассира",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "KMP приложение кассира, которое начисляет баллы программы лояльности за покупки и списывает их в счёт скидки",
        descriptionMdPath = "files/benefitty_сashier/description.md",
        images = generateFilePaths(1..4, prefix = "files/benefitty_сashier/", suffix = ".png"),
        cover = "files/benefitty_сashier/cover.jpg",
    ),
    Project(
        id = "roomBooking",
        title = "Room Booking",
        category = ProjectCategory.LIBRARIES,
        shortDescription = "Android-библиотека, поставляющая виджет бронирования переговорных комнат для Cubic Vision",
        descriptionMdPath = "files/room_booking/description.md",
        images = generateFilePaths(1..6, prefix = "files/room_booking/", suffix = ".png"),
        cover = "files/room_booking/cover.png",
    ),
    Project(
        id = "libAdb",
        title = "Lib ADB",
        category = ProjectCategory.LIBRARIES,
        shortDescription = "Android-библиотека, которая даёт приложению права на установку APK и перезагрузку устройства без root и без системной подписи",
        descriptionMdPath = "files/lib_adb/description.md",
        images = generateFilePaths(1..5, prefix = "files/lib_adb/", suffix = ".JPG"),
        cover = "files/lib_adb/cover.png",
    ),
    Project(
        id = "cubicAutoSetup",
        title = "Cubic Auto Setup",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-сервис первоначальной настройки сети на root headless-устройствах, которые работают в торговых залах без монитора и клавиатуры",
        descriptionMdPath = "files/cubic_auto_setup/description.md",
        images = emptyList(),
        cover = "files/cubic_auto_setup/cover.jpg",
    ),
    Project(
        id = "ledController",
        title = "LED Controller",
        category = ProjectCategory.MOBILE_APPS,
        shortDescription = "Android-приложение, которое управляет светодиодной подсветкой корпуса на устройствах",
        descriptionMdPath = "files/led_controller/description.md",
        images = generateFilePaths(1..2, prefix = "files/led_controller/", suffix = ".jpeg"),
        cover = "files/led_controller/cover.jpeg",
    ),
    Project(
        id = "cubicMetricaMeetup",
        title = "Cubic Metrica Meetup",
        category = ProjectCategory.MEETUPS,
        shortDescription = "Выступление о развитии Cubic Metrica — Android-приложения определяющего характеристики аудитории перед экраном с помощью компьютерного зрения.",
        descriptionMdPath = "files/cubic_metrica_meetup/description.md",
        images = generateFilePaths(1..17, prefix = "files/cubic_metrica_meetup/", suffix = ".JPG"),
        cover = "files/cubic_metrica_meetup/cover.jpg",
    ),
    Project(
        id = "testRunnerMeetup",
        title = "Test Runner Meetup",
        category = ProjectCategory.MEETUPS,
        shortDescription = "Выступление о разработке Test Runner — desktop-инструмента для автоматизации тестирования Android-приложений",
        descriptionMdPath = "files/test_runner_meetup/description.md",
        images = generateFilePaths(1..17, prefix = "files/test_runner_meetup/", suffix = ".JPG"),
        cover = "files/test_runner_meetup/cover.jpg",
    ),
)

fun generateFilePaths(range: IntRange, prefix: String = "", suffix: String = ""): List<String> {
    return range.map { "$prefix$it$suffix" }
}
