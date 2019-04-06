package datadragon.model.cdn.champion

data class Recommended(
    val champion: String,
    val title: String,
    val map: String,
    val mode: String,
    val priority: Boolean,
    val type: String,
    val customTag: String?,
    val requiredPerk: String?,
    val sortrank: Double,
    val extenOrnnPage: Boolean,
    val extensionPage: Boolean,
    val useObviousCheckmark: Boolean,
    val customPanel: Any?,
    val customPanelCurrencyType: Any?,
    val customPanelBuffCurrencyName: Any?,
    val blocks: List<Block>
)