import { defineStore } from 'pinia'
import { RouterMenu } from '@/pojo/RouterMenu'
import { TreeIP } from '@/utils/aboutTree/TreeIP'

export const menuStore = defineStore('menu', () => {
  /**
   * 页面数据
   */
  let tree: {
    menuList: RouterMenu[]
    treeIp: TreeIP<RouterMenu>
    /**开始就把数据替换掉*/
    initStore: (list: []) => void
    /**重新加载数据*/
    reload: () => void
    /**更新*/
    changeMenuList: (menu: RouterMenu, isDel?: boolean) => void
  } = {
    menuList: [],
    treeIp: new TreeIP(),
    initStore(list: []) {
      this.treeIp.addTree(...list)
      this.reload()
    },
    reload() {
      this.menuList = this.treeIp.getTreeData()
    },
    changeMenuList(menu: RouterMenu, isDel?: boolean) {
      isDel ? this.treeIp.delTree(menu) : this.treeIp.addTree(menu)
      this.reload()
    },
  }

  /**
   * 页面变化
   */
  let form: {
    /**显示*/
    display: boolean
    /**父项*/
    pTree: RouterMenu | undefined
    /**显示隐藏form*/
    setDisplay: (flag?: boolean) => void
    setTree: (menu?: any) => void
  } = {
    display: false,
    pTree: undefined,
    setDisplay(flag?: boolean) {
      flag === undefined
        ? (this.display = !this.display)
        : (this.display = flag)
    },
    setTree(menu?: any) {
      this.pTree = menu
    },
  }

  return { tree, form }
})
