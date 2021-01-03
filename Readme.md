


# Remote Image for Jetpack Compose



#### Library that helps to load images and show from network in Jetpack Compose

# Installation

Add this to project level build.gradle
```
allprojects {
    repositories {
        ...
        maven { url 'https://dl.bintray.com/agarasul/RemoteImage' }
    }
}
```

Then add this to app level build.gradle


```
dependencies {
    ...
    implementation 'dev.rasul:remoteimage:1.0.1'
}
```

# Usage 

```kotlin
RemoteImage(
    url = newsItem.urlToImage,
    contentScale = ContentScale.Crop,
    modifier = Modifier.height(200.dp),
    error = {
        Text(text = "Could not load image")
    },
    loading = {
        CircularProgressIndicator(
            strokeWidth = 2.dp,
            modifier = Modifier.size(16.dp)
        )
    }
)
```

# Example application 

![RemoteImage Demo](sample_video.gif)


License
----
```
Copyright 2019 Rasul Aghakishiyev

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


