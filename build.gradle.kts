import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    application
}
group = "org.calc"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("org.calc.MainKt")
}

tasks.jar {
    manifest {
        attributes(
            "Implementation-Title" to "kfraction",
            "Implementation-Version" to version,
            "Main-Class" to "org.calc.MainKt",
        )
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    from(sourceSets.main.get().output)
//    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

val run: JavaExec by tasks
run.standardInput = System.`in`


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"

}