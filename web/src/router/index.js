import {createRouter, createWebHistory} from 'vue-router';


// 导入组件
import SignIn from '@/views/SignIn.vue';
import SignUp from '@/views/SignUp.vue';
import FogotPassword from '@/views/FogotPassword.vue';

const routes = [
    {path: '/sign-in', component: SignIn},
    {path: '/sign-up', component: SignUp},
    {path: '/forgot-password', component: FogotPassword}
];

// 创建路由实例
const router = createRouter({
    history: createWebHistory(),  // 使用 history 模式
    routes
});

router.beforeEach((to, from, next) => {
    const token = localStorage.getItem('token')
    const whiteList = ['/sign-in', '/sign-up', '/forgot-password'];
    if (!token && !whiteList.includes(to.path)) {
        next('/sign-in');
    } else {
        next();
    }
});

export default router;
