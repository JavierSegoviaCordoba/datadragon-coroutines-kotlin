# DataDragon Wrapper for Kotlin
Features:
- It uses Retrofit
- Kotlin Coroutine compatible

## Implementation
TODO upload to bintray

## Usage
- First of all, you can check a lot of examples inside [Kotlin test folder](/src/test/kotlin).
- To access to all functions:
```kotlin
val dataDragon = DataDragon()
```
### API

#### Version
```kotlin
val versionList = dataDragon.getVersionLists()
```

### CDN
- Almost all [cdn](/src/test/kotlin/cdn) functions have the default parameters `version = lasVersion` and `locale = Locale.EN_US`.

#### Champion
```kotlin
val graves = dataDragon.getChampion("Graves") // Last patch version, Locale.EN_US
val azir = dataDragon.getChampion("Azir", locale = Locale.ES_ES) // Locale.ES_ES (Spanish)
val yasuo = dataDragon.getChampion("Yasuo", "9.5.1", Locale.ES_ES) // Specific version (9.5.1), Locale.ES_ES (Spanish)
```
-  Each Champion is a request to the server, so check `championList` and `championFullList` if you don't want to do multiple requests.

#### ChampionFullList
```kotlin
val championFullList = dataDragon.getChampionFullList() // Last patch version, Locale.EN_US
```
- It retrieves a list of `Champion` with a lot of information, for a list with less information check championList

#### ChampionList
```kotlin
val championList = dataDragon.getChampionList() // Last patch version, Locale.EN_US
```

## TODO
- Add all functions