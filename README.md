# MovieApp

<img src="https://github.com/furkanakak/MovieApp/assets/80040232/8df6cc48-e11c-46c0-b5b2-0d6566716f9f" width="250">
<img src="https://github.com/furkanakak/MovieApp/assets/80040232/2a554503-197d-452b-82b1-05edd48872d6" width="250">


## Overview
MovieApp is a dynamic mobile application that utilizes TheMovieDB API to display a list of movies and their details. Designed to operate efficiently both online and offline, it fetches data from the API when connected to the internet and retrieves cached data from a local database when offline, ensuring uninterrupted user experience. The application supports pagination, seamlessly integrating data fetched both from remote servers and cached locally.

## Technologies Used
- **MVVM Architecture**: Structuring the app using the Model-View-ViewModel (MVVM) pattern to manage data flow and application logic efficiently.
- **Retrofit & OkHttp**: Handling network operations for consuming RESTful services, optimized for robustness and performance.
- **Room**: Utilizing SQLite for local data persistence and efficient caching. This setup allows for quick data access and minimizes dependency on network connectivity.
- **Hilt - Dagger**: Implementing dependency injection to decouple the construction of objects from their usage, making the app more modular and testable.
- **Navigation Component**: Simplifying in-app navigation, enhancing the user interface with predictable and consistent user interactions.
- **Gson**: Parsing JSON data with minimal overhead, integrated seamlessly into the data management layers of the app.
- **Glide**: Efficient image loading and caching, improving the performance and responsiveness of the app by handling image resources smartly.
- **Kotlin Coroutines**: Managing asynchronous tasks, making the handling of concurrent operations smooth and efficient.
- **Kotlin Flow & ViewModel**: Utilizing Flow for reactive data streaming and ViewModel to maintain data across configuration changes, directing UI updates accurately.

## Features
- Movie Listings: Browse through a list of movies with options to load more on demand.
- Caching: Automatic data caching to provide a seamless user experience during offline access.
- Seamless Pagination: Integrated pagination that works uniformly with both remote and cached data sources.


## Getting Started
To run MovieApp, clone the repository and open it in Android Studio. Ensure you have the latest version of Android Studio and the Android SDK setup for the best experience.


```bash
git clone https://github.com/furkanakak/MovieApp.git 
```



## License

```bash
MIT License

Copyright (c) 2024 furkan akalın

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
