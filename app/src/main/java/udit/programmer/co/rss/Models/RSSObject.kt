package udit.programmer.co.rss.Models

data class RSSObject(
    val status: String,
    val feed: Feed,
    val items: List<Item>
)