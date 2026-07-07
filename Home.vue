<template>
  <el-container style="height:100vh">
    <!-- 左侧侧边栏 -->
    <el-aside width="200px" style="background:#fff">
      <el-menu router>
        <el-menu-item index="/home">数据仪表盘</el-menu-item>
        <el-menu-item index="/home/club">社团管理</el-menu-item>
        <el-menu-item @click="logout">退出登录</el-menu-item>
      </el-menu>
    </el-aside>

    <!-- 右侧主区域 -->
    <el-container>
      <!-- 顶部头部 -->
      <el-header style="background:#fff; line-height: 60px; padding: 0 20px; font-size: 16px;">
        欢迎：{{ userStore.username }}
      </el-header>
      <!-- 子路由页面渲染区 -->
      <el-main style="padding: 0;">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { useUserStore } from '../stores/user'
const router = useRouter()
const userStore = useUserStore()

// 页面加载恢复登录状态
userStore.initUser()

// 退出登录（不刷新页面）
const logout = () => {
  userStore.logout()
  router.push('/login')
}
</script>

<style scoped>
.el-header {
  border-bottom: 1px solid #e6e6e6;
}
.el-aside {
  border-right: 1px solid #e6e6e6;
}
</style>