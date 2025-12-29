import { method } from '@/utils/request'

export abstract class BaseApi {
  baseUrl: string

  constructor(baseUrl: string) {
    this.baseUrl = baseUrl
  }

  getList(par: object) {
    return method.get(this.baseUrl + '/list', par)
  }

  add(data: object) {
    return method.post(this.baseUrl + '/add', data)
  }

  del(data: object) {
    return method.post(this.baseUrl + '/delById', data)
  }

  //工厂模式,暂不做
}
