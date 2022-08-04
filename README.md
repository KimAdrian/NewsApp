![Build](https://github.com/KimAdrian/NewsApp/actions/workflows/build.yml/badge.svg)
<p align="center">
<img src="images/news_icon.png" height=150px width=150px alt ="newsLogo"/>
</p>
<p align="center">
<img  src="https://img.shields.io/badge/-ANDROID-006CBC?logo=android&logoColor=white&style=for-the-badge">
<img  src="https://img.shields.io/badge/-KOTLIN-006CBC?logo=kotlin&logoColor=white&style=for-the-badge">

</p>

## NewsApp


A minimalistic news app built with MVVM architecture that consumes newsapi.org rest api

Min Api Level: 21 [Android 5.0](https://developer.android.com/studio/releases/platforms)

Build System : [Gradle](https://gradle.org/)

## Screenshots

| <img src="images/newsLoading.jpg"/> | <img src="images/newsLoaded.jpg"/> | <img src="images/errorOccured.jpg"/> |
|---|---|---|

## Setup Guide
After cloning the repo:

1. Register at [newsapi.org](https://newsapi.org) to get an api key.
2. Add the api key to `local.properties` file.
```
apiKey="YOUR_API_KEY"
```
3. Build and install the app.

<b>Disclaimer: </b>If you encounter any problems while adding the api key, use this [reference](https://gist.github.com/loftywaif002/f2ebe2024ad73d6a579285dcba250465).

## Libraries

- [Retrofit2](https://square.github.io/retrofit/) : A type-safe HTTP client for Android and Java.
- [Moshi](https://github.com/square/moshi) : A modern JSON library for Android, Java and Kotlin. It makes it easy to parse JSON into Java and Kotlin classes.
- [Glide](https://github.com/bumptech/glide) : A fast and efficient open source media management and image loading framework.
- [Lifecycle-livedata-ktx](https://androidx.tech/artifacts/lifecycle/lifecycle-livedata-ktx/) : Kotlin extensions for 'livedata' artifact.
