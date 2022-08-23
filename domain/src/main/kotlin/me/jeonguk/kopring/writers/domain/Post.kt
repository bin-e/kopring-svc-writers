package me.jeonguk.kopring.writers.domain

import java.time.LocalDateTime

object Post {

    open class PostBase(
        var postId: Long,
        var no: Long,
        var title: String,
        var contents: String
    )

    open class PostSimple(
        postId: Long,
        no: Long,
        title: String,
        contents: String
    ) : PostBase(postId, no, title, contents) {

    }

    class PostDetail(
        postId: Long,
        no: Long,
        title: String,
        contents: String
    ) : PostSimple(postId, no, title, contents) {
        var createdAt: LocalDateTime = LocalDateTime.MIN
        var updatedAt: LocalDateTime = LocalDateTime.MIN
        var createdBy = ""
        var lastModifiedBy = ""
    }

    class PostCreateReq(
        var title: String,
        var contents: String
    )

    class PostListReq(
        var postId: Long,
        var title: String
    )

    class PostUpdateReq(
        var title: String,
        var contents: String
    )

}