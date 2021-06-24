import Vue from 'vue'
import App from './App'
import xflSelect from './components/xfl-select/xfl-select.vue';
			Vue.component('xfl-select', xflSelect);

Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
