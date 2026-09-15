plugins {
    id("com.android.library") version "9.4.0"
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

dependencies {
    testImplementation("junit:junit:4.13.2")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.github.Dhruuvil"
                artifactId = "MyLibrary"
                version = "1.0.1"
            }
        }
    }
}