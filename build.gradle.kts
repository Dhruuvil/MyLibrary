plugins {
    id("com.android.library") version "9.4.0"
    id("org.jetbrains.kotlin.android") version "2.2.10"
    id("maven-publish")
}

android {
    namespace = "com.example.mylibrary"
    compileSdk = 37

    defaultConfig {
        minSdk = 23
    }

    publishing {
        singleVariant("release")
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.github.Dhruuvil"
                artifactId = "MyLibrary"
                version = "1.0.0"
            }
        }
    }
}
