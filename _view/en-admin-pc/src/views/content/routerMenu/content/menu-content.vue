<template>
  <div class="menuContent">
    <n-card v-if="page.pTree" :title="page.pTree.name">
      {{ page.pTree.path }}
      <n-divider />
      <router-link :to="{ name: 'word' }" append>1122</router-link>
      <!--子标签-->
      <n-space>
        <n-tag v-for="child in page.pTree.children" :key="child.id"
          >{{ child.name }}
        </n-tag>
      </n-space>
    </n-card>
  </div>
</template>

<script lang="ts">
import { mapState } from 'pinia'
import { menuStore } from '../menuStore'



/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/11 02:49
 */
export default {
  name: 'menu-content',
  data() {
    return {
      //
    }
  },
  created() {
    console.log(this.page.pTree)
  },
  methods: {},
  computed: {
    ...mapState(menuStore, ['data', 'page']),
  },
}
</script>

<style lang="less">
.menuContent {
}
</style>
