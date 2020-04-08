<template>
  <el-container class="home_container">
    <el-header style="background-color: #4fb8ff">
      <div style="color: #fff; font-size: 22px; display: inline;"> X 博客</div>
    </el-header>
    <el-container>
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router :default-openeds="['0','1']">
          <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
            <template slot="title"><i :class="item.iconClass"></i> {{item.name}} </template>
            <el-menu-item
              v-for="(item2,index2) in item.children"
                          v-if="item2.show"
                          :index="item2.path"
                          :class="$route.path==item2.path ? 'is-active':''">
              <i :class="item2.iconClass"></i>
              {{item2.name}}
            </el-menu-item>

          </el-submenu>
        </el-menu>
      </el-aside>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: "Index"
  }
</script>

<style scoped>
  .home_container {
    height: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
  }
</style>
