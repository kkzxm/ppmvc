<template>
  <div class="index-menu">
    <n-split
      direction="horizontal"
      :resize-trigger-size="10"
      :default-size="0.2"
      :min="0.2"
    >
      <template #1>
        <n-space vertical style="margin: 0.5rem">
          <n-input v-model:value="filterMenu" placeholder="搜索" />
          <n-button
            block
            type="info"
            @click="addTop"
            :disabled="page.show"
            >添加顶层菜单
          </n-button>
          <n-tree
            block-node
            show-line
            :data="data.menuTreeList"
            key-field="id"
            label-field="name"
            expand-on-click
            :node-props="nodeProps"
            :render-suffix="suffixF"
            :pattern="filterMenu"
            :show-irrelevant-nodes="false"
          />
        </n-space>
      </template>
      <template #2>
        <n-space vertical style="margin: 0.5rem">
          <n-collapse-transition :show="page.show">
            <menu-form></menu-form>
          </n-collapse-transition>
          <menu-content></menu-content>
        </n-space>
      </template>
      <template #resize-trigger>
        <div
          :style="{
            height: '100%',
            backgroundColor: '#727272',
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            borderRadius: '8px',
            margin: '0 0.2rem',
          }"
        ></div>
      </template>
    </n-split>
  </div>
</template>

<script lang="ts">
import { mapState } from 'pinia'
import menu_tree_buttons from './menu-tree-buttons.vue'
import { menuStore } from './menuStore'
import { type TreeOption } from 'naive-ui'
import { h } from 'vue'
import MenuForm from './form/menu-form.vue'
import { routerObj } from '@/api/routerApi'
import MenuContent from '@/views/content/routerMenu/content/menu-content.vue'

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/4 01:21
 */
export default {
  name: 'router-menu',
  components: { MenuContent, MenuForm, menu_tree_buttons },
  data() {
    return { filterMenu: '' }
  },
  methods: {
    addTop(){
      this.page.setShowForm();
      this.page.setTree()
    },
    // 事件绑定
    nodeProps({ option }: { option: TreeOption }) {
      let onClick = () => {
        this.page.setTree(option)
      }
      return {
        onClick,
        // 右键菜单
        /*onContextmenu(e: MouseEvent): void {
          e.preventDefault()
        },*/
      }
    },
    // 后缀
    suffixF(info: { option: TreeOption; checked: boolean; selected: boolean }) {
      return h(menu_tree_buttons, {
        thisMenu: info.option,
      })
    },
    init() {
      routerObj.getList({}).then(res => {
        this.data.initStore(res.data)
      })
    },
  },
  created() {
    this.init()
  },
  mounted() {},
  computed: {
    ...mapState(menuStore, ['page', 'data']),
  },
}
</script>

<style lang="less" scoped>
.index-menu {
}
</style>
