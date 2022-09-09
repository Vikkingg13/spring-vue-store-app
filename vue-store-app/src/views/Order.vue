<script>
import ProductList from '@/components/ProductList.vue'
import axios from 'axios';
const API_URL_ORDER = 'http://localhost:8080/orders/'
const API_URL_PRODUCTS = 'http://localhost:8080/products/order/'

export default {
    data() {
        return {
            order: {},
            products: []
        }
    },

    mounted() {
        this.getOrder();
        this.getProducts();
    },
    
    methods: {
        getOrder() {
            const url = API_URL_ORDER + this.$route.params.id;
            axios.get(url)
            .then(res => this.order = res.data)
        },

        getProducts() {
            const url = API_URL_PRODUCTS + this.$route.params.id;
            axios.get(url)
            .then(res => this.products = res.data)
        },

        show(id) {
            this.$router.push("/product/" + id)
        }
    },
    
    components: {ProductList}
}

</script>

<template>
    <h2>Заказ</h2>
    <div class="data">
        <p>ID: {{ this.order.id }}</p>
        <p>Имя покупателя: {{ this.order.customerName }}</p>
        <p>Номер покупателя: {{ this.order.customerPhone }}</p>
        <p>Статус заказа: {{ this.order.status }}</p>
    </div>

    <div class="list">
        <h3>Товары в заказе</h3>
        <ProductList
        :products="products"
        showButton
        @show-product="show"
        ></ProductList>
    </div>    
</template>

<style>
    .list {
        margin-top: 50px;
    }
</style>


