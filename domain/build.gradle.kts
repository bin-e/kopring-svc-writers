plugins {
    kotlin("kapt")
    kotlin("plugin.jpa")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

version = "0.0.1"

tasks {
    jar {
        enabled = true
        archiveBaseName.set("kopring-mlt-iktta-domain")
//        archiveVersion.set("0.0.2")
    }

    bootJar {
        enabled = false
    }
}
