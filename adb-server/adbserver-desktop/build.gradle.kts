plugins {
    kotlin
    application
}

dependencies {
    implementation(libs.kotlinStdlib)
    implementation(libs.kotlinCli)
    implementation(projects.adbServer.adbserverCommon)
    implementation(projects.adbServer.adbserverCommandTypes)
    implementation(projects.adbServer.adbserverConnection)
    implementation(projects.adbServer.adbserverDesktopDeviceConnection)
}

setProperty("mainClassName", "com.kaspersky.adbserver.desktop.MainKt")

tasks.jar.configure {
    manifest {
        attributes["Main-Class"] = "com.kaspersky.adbserver.desktop.MainKt"
    }
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}
