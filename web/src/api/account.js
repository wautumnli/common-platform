import {base} from "@/utils/api";


export const login = (data) => {
    return base({
        url: '/account/login',
        data
    })
}

export const register = (data) => {
    return base({
        url: '/account/register',
        data
    })
}