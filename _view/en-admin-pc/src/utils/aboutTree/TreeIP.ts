import type { strNum } from '@/utils/sType'
import type { ATree } from '@/utils/aboutTree/Tree'

export class TreeIP<T extends ATree> {
  private idTreeMap: Map<strNum, T> = new Map<strNum, T>()
  private pidChildesMap: Map<strNum, Set<T>> = new Map<strNum, Set<T>>()
  /*
  a:[strNum,T] = [];
  b:[strNum,...T[]] = [];
   */

  /*
  c:[strNum,strNum,T,...T[]] = []
  */
  constructor(...list: T[]) {
    this.addTree(...list)
  }

  /**
   * 删除树
   * 删除的需要先看一眼是否有子集,有就不删,
   * 否则会出现空集
   */
  delTree(...list: T[]) {
    for (let tree of list) {
      // 父项(兄弟)
      let par: Set<T> | undefined = this.pidChildesMap.get(tree.pid)
      // 子集合
      let child: Set<T> | undefined = this.pidChildesMap.get(tree.id)
      // 有子不删
      if (child && child.size != 0) continue

      // 只删自己
      this.idTreeMap.delete(tree.id)
      // 脱离
      par?.delete(tree)
    }
  }

  /**
   * 添加树
   *
   * 以后加盐:一个在自己手里,一个id,一个pid
   * 三个形成一个值,加到数据库中,
   *
   *
   * @param list
   */
  addTree(...list: T[]) {
    for (let tree of list) {
      // 一个装自己
      this.idTreeMap.set(tree.id, tree)
      // 一个装到父集中(相当于分类)
      let chSet: Set<T> = this.pidChildesMap.get(tree.pid) || new Set<T>()
      this.pidChildesMap.set(tree.pid, chSet.add(tree))
    }
  }

  /**
   * 根据id找树
   * @param id
   */
  getTreeById(id: strNum) {
    return this.idTreeMap.get(id)
  }

  /**
   * 根据父id 找到子集合
   * @param pid
   */
  getChildesBypId(pid: strNum) {
    return this.pidChildesMap.get(pid)
  }

  /**
   * 得到树形结构
   * @param rootId
   */
  getTreeData(rootId?: strNum) {
    let treeData: T[] = []
    for (const [id, tree] of this.idTreeMap) {
      // 根节点
      if (tree.pid === rootId || !tree.pid) {
        treeData.push(tree)
      }
      let treeSet = this.getChildesBypId(id) || []
      tree.children.length = 0
      tree.children.push(...treeSet)
    }
    return treeData
  }
}
