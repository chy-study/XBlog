<template>
  <el-tabs v-model="activeName" @tab-click="handleClick" type="border-card" style="width: 60%">
    <el-tab-pane label="全部文章" name="allBlogs"><blogTags  statu="0" v-if='isAllBlogs'></blogTags></el-tab-pane>
    <el-tab-pane label="已发表" name="publicBlogs"><blogTags  statu="1" v-if='isPublicBlogs'></blogTags></el-tab-pane>
    <el-tab-pane label="草稿箱" name="draftBlogs"><blogTags  statu="2" v-if='isDraftBlogs'></blogTags></el-tab-pane>
    <el-tab-pane label="回收站" name="recycleBlogs"><blogTags  statu="3" v-if='isRecycleBlogs'></blogTags></el-tab-pane>
  </el-tabs>
</template>

<script>
    import BlogTagss from "./BlogTags";
    export default {
      name: "BlogSelect",
      data() {
        return {
          // 默认第一个Tab
          activeName: 'allBlogs',
          isAllBlogs: true,
          isPublicBlogs: false,
          isDraftBlogs: false,
          isRecycleBlogs: false
        }
      },
      methods: {
        handleClick(tab) {
          if (tab.name === 'allBlogs') {
            this.isAllBlogs = true
            this.isPublicBlogs = false
            this.isDraftBlogs = false
            this.isRecycleBlogs = false
          } else if (tab.name === 'publicBlogs') {
            this.isAllBlogs = false
            this.isPublicBlogs = true
            this.isDraftBlogs = false
            this.isRecycleBlogs = false
          } else if (tab.name === 'draftBlogs') {
            this.isAllBlogs = false
            this.isPublicBlogs = false
            this.isDraftBlogs = true
            this.isRecycleBlogs = false
          } else if (tab.name === 'recycleBlogs') {
            this.isAllBlogs = false
            this.isPublicBlogs = false
            this.isDraftBlogs = false
            this.isRecycleBlogs = true
          }
        }
      },
        components: {
        'blogTags': BlogTagss
      }
    }
</script>

<style scoped>

</style>
