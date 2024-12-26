import createAxiosInstance from './axiosFactory';
import router from '../router';

export const base = createAxiosInstance('/api/base');
export const account = createAxiosInstance('/api/account');

// 请求拦截器
account.interceptors.request.use(
    (config) => {
        // 从本地存储获取 token
        const token = localStorage.getItem('token')
        if (!token) {
            // 如果没有 token，跳转到登录页
            router.push('/sign-in').then(r => r)
            return Promise.reject('No token, please login')
        }
        // 如果有 token，添加到请求头
        config.headers['Authorization'] = `Bearer ${token}`
        return config
    },
    (error) => Promise.reject(error)
);