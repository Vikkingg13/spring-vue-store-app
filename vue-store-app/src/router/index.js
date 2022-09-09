import {createRouter, createWebHistory} from 'vue-router'
import Home from '@/views/Home.vue'
import Products from '@/views/Products.vue'
import Product from '@/views/Product.vue'
import Orders from '@/views/Orders.vue'
import Order from '@/views/Order.vue'
import ProductNew from '@/views/ProductNew.vue'
import ProductEdit from '@/views/ProductEdit.vue'
import OrderEdit from '@/views/OrderEdit.vue'

const routes = [
    {path: '/', name: 'Home', component: Home},
    {path: '/products', name: 'Products', component: Products},
    {path: '/product/:id', name: 'Product', component: Product},
    {path: '/orders', name: 'Orders', component: Orders},
    {path: '/order/:id', name: 'Order', component: Order},
    {path: '/product/new', name: 'ProductNew', component: ProductNew},
    {path: '/product/edit/:id', name: 'ProductEdit', component: ProductEdit},
    {path: '/order/edit/:id', name: 'OrderEdit', component: OrderEdit}

]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router