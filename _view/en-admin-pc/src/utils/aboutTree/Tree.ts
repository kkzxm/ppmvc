import type { ot, strNum } from '@/utils/sType'

/**
 * 树类
 */
interface Tree<D = strNum> {
  id: D
  pid: D
  children: Array<Tree<D>>

  /*
    /!**
     * 清空
     *!/
    clear(): void

    /!**
     * 添加(可多个)
     * @param objList
     *!/
    addChild(...objList: ot<D>[]): boolean

    /!**
     * 删除(可多个)
     * @param idList
     *!/
    delChild(...idList: D[]): boolean

    /!**
     * 查找子项
     * @param childId 子项id
     *!/
    getChild(childId: D): Array<Tree<D>>[]
  */
}

export abstract class ATree<D = strNum> implements Tree<D> {
  id: D
  pid: D
  readonly children: Tree<D>[] = []

  constructor(obj: ot<D>) {
    this.id = obj.id
    this.pid = obj.pid
  }

  /**
   * 以后再说
   */
  /*
  clear(): void

  addChild(...objList: ot<D>[]): boolean

  delChild(...idList: D[]): boolean

  getChild(childId: D): Array<Tree<D>>[]
  */
}
