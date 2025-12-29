import { method } from '@/utils/request'

export const ge = function (par: object) {
  return method.get('/word/add', par )
}
