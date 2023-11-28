# Kimia Deskercise [Android]: SDK Integration Guide
This SDK can be integrated into Android applications to administer desk-based exercises, targeted at office workers



## Table of Contents
1. [Features](#Features)  
<!-- 2. [Releases](#paragraph1)   -->
    
3. [Installation](#Installation)  
    1. [Requirement](#Requirements)  
    2. [Configuration](#Configuration)  


## Features
Desk-based Exercises

Deskercise provides 3 exercise models for users to choose from, depending on the amount of time the user has for their workout

![image info](assets/gif1.gif)
![image info](assets/gif2.gif)

## Installation

```
buildscript {

    repositories {
        mavenCentral()
    }
}


implementation 'com.kinexcs:move-sdk:<version>'
```

### Requirements
- Android 6.0 (API level 23) and above
- Java JDK 1.8+
- Android Gradle Plugin 8.1.0+
- Gradle 8.1-rc-2+

### Configuration


## Getting Started

### Integration
Step 1: Setup the key into manifest.xml

```
<meta-data
            android:name="com.kinexcs.move"
            android:value="<your key>" />
```

Step 2: On the Application, setup: 

```

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MoveSDK.init(this)
    }
}
```

Step 3: 


```

private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { r ->
            val result = MoveSDK.handleResult(r.resultCode, r.data)
            result.exception?.let {
                // show error here
                Toast.makeText(this, it.message.orEmpty(), Toast.LENGTH_SHORT).show()
            }
            result.detail?.let { detail: SessionDetail ->
                // success data here
            }
        }

val moveSdk = MoveSDK()

launcher.launch(moveSdk.getIntent5MinutesExercise(this, getRandom()))

```