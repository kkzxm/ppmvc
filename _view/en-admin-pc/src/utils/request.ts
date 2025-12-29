import axios from 'axios'

const service = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
})

// 请求拦截
service.interceptors.request.use(
  config => {
    return config
  },
  error => {
    Promise.reject(error)
  },
)

// 响应拦截
service.interceptors.response.use(
  response => {
    return response.data
  },
  error => {},
)

export const method = {
  get: function (url: string, params: object) {
    return service.get(url, { params })
  },
  post: function (url: string, data: object) {
    return service.post(url, data)
  },
  delete: function (url: string, data: object) {
    return service.delete(url, { data })
  },
  put: function (url: string, data: object) {
    return service.put(url, { data })
  },
}
