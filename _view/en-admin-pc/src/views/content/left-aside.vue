<template>
  <div class="left-aside">
    <n-menu
      :collapsed="false"
      :collapsed-width="64"
      :options="data.menuTreeList"
      :render-label="renderMenuLabel"
      label-field="name"
      key-field="id"
    />
  </div>
</template>

<script lang="ts">
import { mapState } from 'pinia'
import { menuStore } from '@/views/content/routerMenu/menuStore'
import type { MenuOption } from 'naive-ui'
import { h } from 'vue'

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/13 00:38
 */
export default {
  name: 'index',
  data() {
    return {
      // 登录表单的数据绑定对象
    }
  },
  methods: {
    renderMenuLabel(option: MenuOption) {
      if ('path' in option) {
        return h('a', { href: 'content/' + option.path }, option.name as string)
      }
    },
  },
  computed: {
    ...mapState(menuStore, ['page', 'data']),
  },
}
</script>

<style lang="less">
.left-aside {
}
</style>
