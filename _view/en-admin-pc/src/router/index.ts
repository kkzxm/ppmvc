import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: () => import('@/views/begin/index.vue'),
    },
    {
      path: '/start',
      name: 'start',
      component: () => import('@/views/begin/start.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login/index.vue'),
    },
    {
      path: '/content',
      name: 'content',
      component: () => import('@/views/content/index.vue'),
      children: [
        {
          path: '',
          name: 'router-menu',
          component: () => import('@/views/content/routerMenu/index.vue'),
        },
        {
          path: 'word',
          name: 'word',
          component: () => import('@/views/content/en/word.vue'),
        },
      ],
    },
  ],
})

export default router
