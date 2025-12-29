<template>
  <div class="start">
    <n-button @click="toLogin"> 登录</n-button>
    <n-button @click="toCon"> 内容</n-button>
  </div>
</template>

<script lang="ts">
/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/4 00:26
 */
export default {
  name: 'start',
  data() {
    return {
      //
    }
  },
  methods: {
    init() {},
    toLogin() {
      this.$router.push('/login')
    },
    toCon() {
      this.$router.push('/content')
    },
  },
  created() {
    this.init()
  },
}
</script>

<style lang="less">
.index {
}
</style>
