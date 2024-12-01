plugins {
    `java-library`
    `maven-publish`
    id("com.google.protobuf") version "0.9.4"
}

group = "com.dunkware.part"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    api("com.google.protobuf:protobuf-java:3.25.1")
    api("com.google.protobuf:protobuf-java-util:3.25.1")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }

    generateProtoTasks {
        all().configureEach {
            plugins {
                // No java plugin configuration here as it's handled by the java-library plugin
            }
        }
    }
}

sourceSets {
    main {
        proto {
            srcDir("src/main/proto")
        }
        java {
            srcDir(layout.buildDirectory.dir("generated/source/proto/main/java"))
        }
    }
}

tasks.named<JavaCompile>("compileJava") {
    dependsOn("generateProto")
}

tasks.clean {
    delete(layout.buildDirectory.dir("generated"))
}

tasks.withType<Copy> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            version = project.version.toString()
        }
    }
    repositories {
        maven {
            name = "nexus"
            url = uri(if (version.toString().endsWith("SNAPSHOT"))
                "https://nexus.dunkware.net/repository/maven-snapshots/"
            else
                "https://nexus.dunkware.net/repository/maven-releases/")
            credentials {
                username = project.findProperty("nexusUsername") as String? ?: System.getenv("NEXUS_USERNAME")
                password = project.findProperty("nexusPassword") as String? ?: System.getenv("NEXUS_PASSWORD")
            }
        }
    }
}