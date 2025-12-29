<template>
  <n-space v-show="!page.show">
    <n-popconfirm v-model:show="delShow">
      <template #trigger>
        <!--外-->
        <n-button type="error" size="tiny"> 删除节点</n-button>
      </template>
      <template #icon>
        <n-icon color="red">
          <HandIcon />
        </n-icon>
      </template>
      <!--内?确定?-->
      <template #action>
        <n-button size="tiny" @click="delMenuNode" type="error"> 删除</n-button>
        <n-button size="tiny" @click="delShow = false" type="primary">
          取消
        </n-button>
      </template>
    </n-popconfirm>

    <n-button type="primary" size="tiny" @click="addMenuChild"
      >添加子项
    </n-button>
  </n-space>
</template>

<script lang="ts">
/**
 * 菜单树后缀
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/4 03:57
 */
import { mapState } from 'pinia'
import { menuStore } from '@/views/content/routerMenu/menuStore'
import { MdHand as HandIcon } from '@vicons/ionicons4'
import { routerObj } from '@/api/routerApi'

export default {
  name: 'menu-tree-buttons',
  components: { HandIcon },
  props: ['thisMenu'],
  data() {
    return {
      delShow: false,
    }
  },
  methods: {
    delMenuNode() {
      routerObj.del({ id: this.thisMenu.id }).then(res => {
        this.data.changeMenuList(this.thisMenu, true)
        this.page.setTree()
        this.page.setShowForm(false)
      })
    },
    addMenuChild() {
      this.page.setShowForm()
    },
    init() {},
  },
  computed: {
    ...mapState(menuStore, ['data', 'page']),
  },
  created() {
    this.init()
  },
}
</script>

<style lang="less">
.menu-drawer {
}
</style>
