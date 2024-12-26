import axios from "axios";
import {ElNotification} from "element-plus";
import {BAD_REQUEST_CODE, INTERNAL_SERVER_ERROR_CODE} from "@/constants";


function createErrorNotification(msg, defaultMsg) {
    return ElNotification({
        title: '错误',
        message: msg ? msg : defaultMsg,
        type: 'error',
        duration: 5000
    });
}

function createAxiosInstance(baseURL, defaultMethod = 'post') {
    const instance = axios.create({
        baseURL,
        method: defaultMethod
    });

    instance.interceptors.response.use(
        response => {
            // 只返回数据部分
            return response.data;
        },
        error => {
            let status = error.response.status;
            let {msg} = error.response.data;
            switch (status) {
                case BAD_REQUEST_CODE: {
                    createErrorNotification(msg, '请求参数错误');
                    break;
                }
                case INTERNAL_SERVER_ERROR_CODE: {
                    createErrorNotification(msg, '服务器内部错误, 请稍后再试');
                    break;
                }
            }
            if (error.response) {
                return Promise.resolve(error.response.data);
            }
            return Promise.reject(error);
        }
    );

    return instance;
}

export default createAxiosInstance;