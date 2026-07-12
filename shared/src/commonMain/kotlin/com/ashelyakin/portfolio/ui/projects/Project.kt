package com.ashelyakin.portfolio.ui.projects

/**
 * Модель проекта для страниц "Все проекты" и "Страница проекта".
 */
data class Project(
    val id: String,
    val title: String,
    val category: String,
    val shortDescription: String,
    val fullDescription: String,
    val tags: List<String>,
    val images: List<String>,
    val year: String,
)

val sampleProjects: List<Project> = listOf(
    Project(
        id = "subaru",
        title = "My Subaru",
        category = "Mobile Apps",
        shortDescription = "Персональный трекер тренировок с синхронизацией Google Fit",
        fullDescription = "FitTrack — приложение для отслеживания тренировок и активности. " +
            "Поддерживает синхронизацию с Google Fit, локальное хранение истории через Room " +
            "и построено по паттерну MVVM с чётким разделением слоёв данных и UI.",
        tags = listOf("Kotlin", "Room", "MVVM", "Google Fit"),
        images = listOf(
            "files/subaru/1.png",
            "files/subaru/2.png",
            "files/subaru/3.png",
            "files/subaru/4.png",
            "files/subaru/5.png",
        ),
        year = "2025",
    ),
    Project(
        id = "recipebox",
        title = "RecipeBox",
        category = "Mobile Apps",
        shortDescription = "Каталог рецептов с офлайн-доступом и умным поиском",
        fullDescription = "RecipeBox хранит коллекцию рецептов пользователя локально и позволяет " +
            "искать по ингредиентам даже без подключения к сети. Использует Retrofit для синхронизации " +
            "и Firebase для авторизации.",
        tags = listOf("Kotlin", "Retrofit", "Firebase"),
        images = emptyList(),
        year = "2024",
    ),
    Project(
        id = "komposeui",
        title = "KomposeUI",
        category = "Libraries",
        shortDescription = "Библиотека переиспользуемых Compose-компонентов",
        fullDescription = "KomposeUI — открытая библиотека готовых Compose Multiplatform компонентов: " +
            "кнопки, чипы, карточки и типографика, следующие единой дизайн-системе.",
        tags = listOf("Compose Multiplatform", "Kotlin"),
        images = emptyList(),
        year = "2025",
    ),
    Project(
        id = "opentracker",
        title = "OpenTracker CLI",
        category = "Open Source",
        shortDescription = "Консольная утилита для трекинга времени разработки",
        fullDescription = "Небольшая CLI-утилита на Kotlin для учёта времени, потраченного на задачи, " +
            "с экспортом отчётов в CSV/Markdown.",
        tags = listOf("Kotlin", "CLI", "Coroutines"),
        images = emptyList(),
        year = "2023",
    ),
)
