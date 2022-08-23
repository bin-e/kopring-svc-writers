package me.jeonguk.kopring.writers.service

import me.jeonguk.kopring.writers.domain.Post
import me.jeonguk.kopring.writers.entity.PostEntity
import me.jeonguk.kopring.writers.repository.PostRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository
) {

    fun addPost(req: Post.PostCreateReq) =
        postRepository.save(PostEntity().apply {
            this.title = req.title
            this.contents = req.contents
        }).toPostSimple()

    fun listSimple(req: Post.PostListReq) =
        postRepository.findAll()
            .map { it.toPostSimple() }

    fun getDetail(postId: Long) =
        postRepository.findById(postId)
            .orElseThrow { NotFoundException() }
            .toPostDetail()

    @Transactional
    fun update(postId: Long, req: Post.PostUpdateReq) =
        postRepository.findById(postId)
            .orElseThrow { NotFoundException() }
            .apply {
                this.title = req.title
                this.contents = req.contents
            }.toPostDetail()

    fun delete(postId: Long): Long =
        postRepository.findById(postId)
            .orElseThrow { NotFoundException() }
            .also {
                postRepository.delete(it)
            }.id

}