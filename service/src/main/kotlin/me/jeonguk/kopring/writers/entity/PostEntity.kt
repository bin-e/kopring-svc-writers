package me.jeonguk.kopring.writers.entity

import me.jeonguk.kopring.writers.domain.Post
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "posts")
@EntityListeners(AuditingEntityListener::class)
class PostEntity(
//    val no: Long
) {

    @Id
    @GeneratedValue
    val id = 0L

    @Column(length = 63)
    var title = ""

    @Column(columnDefinition = "text")
    var contents = ""

    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.MIN

    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.MIN

    @CreatedBy
    @Column(updatable = false)
    var createdBy = ""

    @LastModifiedBy
    var lastModifiedBy = ""

    fun toPostSimple() = Post.PostSimple(this.id, 0, this.title, this.contents)
    fun toPostDetail() = Post.PostDetail(this.id, 0, this.title, this.contents)
        .also {
            it.createdAt = this.createdAt
            it.createdBy = this.createdBy
            it.updatedAt = this.updatedAt
            it.lastModifiedBy = this.lastModifiedBy
        }

}