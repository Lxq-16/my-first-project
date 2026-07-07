<template>
  <div class="login">
    <el-card style="width:450px;margin:100px auto">
      <h2 style="text-align:center;margin-bottom:20px">社团管理系统登录</h2>
      <el-form :model="form" :rules="rules" ref="loginRef" @submit.prevent="login">
        <el-form-item label="账号" prop="username">
          <el-input v-model="form.username" placeholder="请输入账号" />
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" type="password" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" native-type="submit" block>登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { useUserStore } from '../stores/user'
import { loginApi } from '../api/user'

const router = useRouter()
const userStore = useUserStore()
const loginRef = ref(null)
const form = ref({ username: 'admin', password: '123' })
const rules = ref({
  username: [{ required: true, message: '请输入账号', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
})

const login = async () => {
  await loginRef.value.validate(async valid => {
    if (!valid) return
    const res = await loginApi(form.value)
    if (res.code === 200) {
      userStore.login(res.data.username)
      ElMessage.success(res.msg)
      router.push('/home')
    } else {
      ElMessage.error(res.msg)
    }
  })
}
</script>

<style scoped>
.login {
  background-color: #f5f7fa;
  height: 100vh;
}
</style>