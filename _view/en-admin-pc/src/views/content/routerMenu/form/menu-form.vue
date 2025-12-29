<template>
  <div class="MenuForm">
    <n-form
      ref="formRef"
      label-width="auto"
      :model="menu"
      :rules="rules"
      label-placement="left"
      :size="size"
    >
      <n-form-item label="父菜单:" show-require-mark v-if="page.pTree">
        <n-input v-model:value="page.pTree.name" disabled />
      </n-form-item>
      <n-form-item label="菜单名:" show-require-mark>
        <n-input v-model:value="menu.name" placeholder="输入菜单名" />
      </n-form-item>
      <n-form-item label="菜单路径:" show-require-mark>
        <n-input v-model:value="menu.path" placeholder="输入菜单路径" />
      </n-form-item>

      <n-form-item>
        <n-button @click="Submit">提交</n-button>
        <n-button @click="Cancel">取消</n-button>
      </n-form-item>
    </n-form>
  </div>
</template>

<script lang="ts">
import { mapState } from 'pinia'
import { menuStore } from '../menuStore.js'
import { routerObj } from '@/api/routerApi'
import type { RouterMenu } from '@/pojo/RouterMenu'

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/8 00:24
 */
export default {
  name: 'MenuForm',
  data() {
    return {
      // 表单的数据绑定对象
      menu: {} as RouterMenu,
      rules: {},
      size: 'small',
    }
  },
  methods: {
    Submit() {
      this.menu.pid = this.page.pTree?.id
      routerObj.add(this.menu).then(res => {
        this.data.changeMenuList(res.data)
      })
      this.page.setShowForm()
    },
    Cancel() {
      this.menu.pid = ''
      this.page.setShowForm()
    },
  },
  computed: {
    ...mapState(menuStore, ['page', 'data']),
  },
}
</script>

<style lang="less">
.MenuForm {
}
</style>
