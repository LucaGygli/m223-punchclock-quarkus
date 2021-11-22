
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Login.vue'), meta: { requiredRole: "*" } },
      { path: 'home', name: "Home", component: () => import('src/pages/Index.vue')},
      { path: 'users', name: "Users", component: () => import('src/pages/Index.vue')},
      { path: 'Register', name: "Register", component: () => import('pages/Register.vue') }
    ],

  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
