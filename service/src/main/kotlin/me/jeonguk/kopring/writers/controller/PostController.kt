package me.jeonguk.kopring.writers.controller

import me.jeonguk.kopring.writers.contract.PostContract
import me.jeonguk.kopring.writers.domain.Post
import me.jeonguk.kopring.writers.service.PostService
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val postService: PostService
) : PostContract {

    override fun createPost(req: Post.PostCreateReq): Post.PostSimple = postService.addPost(req)

    // TODO: 필터링 추가
    override fun list(req: Post.PostListReq): List<Post.PostSimple> = postService.listSimple(req)

    override fun getDetail(postId: Long): Post.PostDetail = postService.getDetail(postId)

    override fun updatePost(postId: Long, req: Post.PostUpdateReq): Post.PostDetail =
        postService.update(postId, req)

    override fun deletePost(postId: Long): Long = postService.delete(postId)

}