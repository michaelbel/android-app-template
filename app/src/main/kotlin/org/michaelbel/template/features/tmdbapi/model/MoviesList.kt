package org.michaelbel.template.features.tmdbapi.model

enum class MoviesList(val sorting: String) {
    NOW_PLAYING("now_playing"),
    POPULAR("popular"),
    TOP_RATED("top_rated"),
    UPCOMING("upcoming")
}