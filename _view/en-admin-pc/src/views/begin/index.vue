<template>
  <div class="start">
    <n-button type="success" @click="toStart"> 加载内容/转发到start</n-button>
  </div>
</template>

<script lang="ts">
/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/4 00:25
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
    toStart() {
      this.$router.push('/start')
    },
  },
  created() {
    this.init()
  },
}
</script>

<style lang="less">
.start {
}
</style>
