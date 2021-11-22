import { boot } from 'quasar/wrappers'
import axios from 'axios'

export default boot(({ app, store }) => {
  const instance = axios.create({
    baseURL: process.env.API_URL,
    headers: {
      authorization:
        store.getters["auth/JWT"] != null
          ? "Bearer " + store.getters["auth/JWT"]
          : "",
    },
  });
  instance.interceptors.response.use(
    response => {

      return response;
    },
    error => {
     
        return error;
      
    }
  );


  app.config.globalProperties.$axios = axios
  // ^ ^ ^ this will allow you to use this.$axios (for Vue Options API form)
  //       so you won't necessarily have to import axios in each vue file

  app.config.globalProperties.$api = instance
  // ^ ^ ^ this will allow you to use this.$api (for Vue Options API form)
  //       so you can easily perform requests against your app's API
  window.axios = instance
})


