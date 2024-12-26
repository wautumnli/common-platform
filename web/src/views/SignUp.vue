<template>
  <div class="register-container">
    <el-card class="register-card">
      <h2 class="register-title">注册</h2>
      <el-form ref="registerForm" :model="registerForm" :rules="rules">
        <el-form-item prop="username">
          <el-input
            v-model="registerForm.username"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item prop="nickName">
          <el-input
            v-model="registerForm.nickName"
            placeholder="请输入昵称"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="registerForm.password"
            type="password"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword">
          <el-input
            v-model="registerForm.confirmPassword"
            type="password"
            placeholder="请确认密码"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            @click="register"
            :loading="loading"
            class="register-button"
            >注册</el-button
          >
        </el-form-item>
      </el-form>
      <div class="extra-links">
        <el-link type="primary" @click="login">已有账号?登录</el-link>
      </div>
    </el-card>
  </div>
</template>
  
  
<script>
import { register } from "@/api/account";
import { SUCCESS_CODE } from "@/constants";
export default {
  name: "SignUp",
  data() {
    return {
      registerForm: {
        username: "",
        nickName: "",
        password: "",
        confirmPassword: "",
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        nickName: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, message: "密码长度不能少于6位", trigger: "blur" },
        ],
        confirmPassword: [
          { required: true, message: "请确认密码", trigger: "blur" },
          { validator: this.validateConfirmPassword, trigger: "blur" },
        ],
      },
      loading: false,
    };
  },
  methods: {
    register() {
      this.$refs.registerForm.validate(async (valid) => {
        if (valid) {
          this.loading = true;

          try {
            const { code, msg } = await register(this.registerForm);
            if (code === SUCCESS_CODE) {
              this.$message.success(msg);
              this.$router.push('/sign-in')
            }
          } catch (error) {
            this.$message.error(error.response.data.msg);
          } finally {
            this.loading = false;
          }
        } else {
          return false;
        }
      });
    },
    validateConfirmPassword(rule, value, callback) {
      if (value !== this.registerForm.password) {
        callback(new Error("两次输入的密码不一致"));
      } else {
        callback();
      }
    },
    login() {
      this.$router.push("/sign-in");
    },
  },
};
</script>
  
<style scoped>
body,
html {
  margin: 0;
  padding: 0;
  height: 100%;
}

.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(to right, #3498db, #9b59b6);
}

.register-card {
  width: 300px;
}

.register-title {
  text-align: center;
  margin-bottom: 20px;
}

.register-button {
  width: 100%;
}

.extra-links {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}
</style>
  