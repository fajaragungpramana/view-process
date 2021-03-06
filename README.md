# Android View Process
[![](https://jitpack.io/v/fajaragungpramana/view-process.svg)](https://jitpack.io/#fajaragungpramana/view-process)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
</br>
</br>
Library for android. ViewProcess is like shimmer.

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allProjects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add the dependency:
```gradle
dependencies {
	implementation 'com.github.fajaragungpramana:view-process:0.0.4'
}
```

## Usage
Define a view in your layout file:
```xml
<?xml version="1.0" encoding="utf-8"?>
<com.github.fajaragungpramana.viewprocess.ViewProcess
        android:id="@+id/view_process"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:viewProcessColor="#EBEBEB"
	app:viewProcessRadius="0dp" />
```

To start view process.
```kotlin
viewProcess.start              
```

To stop view process.
```kotlin
viewProcess.stop
```

## Preview
I'am sorry GIF preview is not smooth. The original on Android is smooth, thank you.
</br>
</br>
<a href="url"><img src="https://github.com/fajaragungpramana/assets/blob/master/ViewProcess/ViewProcess.gif" align="left" height="640" width="320" ></a>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

## Documentation
Attribute for ViewProcess
| Attribute Name | Default Value | Description |
|----------------|---------------|-------------|
| viewProcessColor | #EBEBEB | Set background color view process |
| viewProcessRadius | null | Set corner radius view process |

## License
Copyright 2021 Fajar Agung Pramana

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
