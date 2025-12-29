<template>
  <div class="index-con">
    <n-layout has-sider class="lay-big">
      <n-layout-sider
        collapse-mode="transform"
        :collapsed-width="0"
        :width="240"
        :native-scrollbar="false"
        show-trigger="bar"
        bordered
      >
        <left-aside></left-aside>
      </n-layout-sider>
      <n-layout class="lay-right">
        <n-layout-header class="lay-header" bordered>header</n-layout-header>
        <n-layout-content
          class="lay-con"
          content-style="padding: 0.5rem;"
          :native-scrollbar="false"
          bordered
        >
          <RouterView />
        </n-layout-content>
        <n-layout-footer bordered>footer</n-layout-footer>
      </n-layout>
    </n-layout>
  </div>
</template>

<script lang="ts">
import leftAside from './left-aside.vue'

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/11/4 00:49
 */
export default {
  name: 'index',
  components: { leftAside },
  data() {
    return {
      //
    }
  },
  methods: {
    init() {},
  },
  created() {
    this.init()
  },
}
</script>

<style lang="less">
@filled: 100vh;
@headerH: 7vh;
.index-con {
  height: @filled;

  .lay-big {
    .lay-right {
      height: @filled;

      .lay-header {
        height: @headerH;
      }

      .lay-con {
        height: (@filled - @headerH)-5rem;
      }
    }

    .side-left {
      height: @filled;
    }
  }
}
</style>
