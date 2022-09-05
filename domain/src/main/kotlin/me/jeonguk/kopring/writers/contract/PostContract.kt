package me.jeonguk.kopring.writers.contract

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import me.jeonguk.kopring.writers.domain.Post
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Api(tags = ["게시글"])
interface PostContract {

    @ApiOperation("게시글 등록")
    @PostMapping("/posts", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createPost(@RequestBody req: Post.PostCreateReq): Post.PostSimple

    @ApiOperation("게시글 목록")
    @GetMapping("/posts", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun list(req: Post.PostListReq): List<Post.PostSimple>

    @ApiOperation("게시글 상세 조회")
    @GetMapping("/posts/{postId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getDetail(@PathVariable postId: Long): Post.PostDetail

    @ApiOperation("게시글 갱신")
    @PutMapping("/posts/{postId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updatePost(
        @PathVariable postId: Long,
        @RequestBody req: Post.PostUpdateReq
    ): Post.PostDetail

    @ApiOperation("게시글 삭제")
    @DeleteMapping("/posts/{postId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deletePost(@PathVariable postId: Long): Long

}