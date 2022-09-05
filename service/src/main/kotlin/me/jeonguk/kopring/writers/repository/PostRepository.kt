package me.jeonguk.kopring.writers.repository

import me.jeonguk.kopring.writers.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

//@Repository
interface PostRepository : JpaRepository<PostEntity, Long>