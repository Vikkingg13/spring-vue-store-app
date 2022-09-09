<script>
import ProductList from '@/components/ProductList.vue'
import axios from 'axios';

const API_URL = 'http://localhost:8080/orders/'
const API_URL_PRODUCTS = 'http://localhost:8080/products/order/'

export default {
    data() {
        return {
            order: {},
            products: []
        };
    },
    mounted() {
        this.getData();
        this.getProducts();
    },
    methods: {
        getData() {
            const url = API_URL + this.$route.params.id;
            axios.get(url)
            .then(res => this.order = res.data)
        },

        getProducts() {
            const url = API_URL_PRODUCTS + this.$route.params.id;
            axios.get(url)
            .then(res => this.products = res.data)
        },

        submit() {
            const url = API_URL + this.$route.params.id;
            axios.put(url, 
            {"customerName": this.order.customerName, "customerPhone": this.order.customerPhone,
             "status": this.order.status});
        },

        show(id) {
            this.$router.push("/product/" + id);
        },

        remove(id) {
            axios.delete(API_URL, {params : { "orderId": this.$route.params.id, "productId": id }});
            this.getProducts();
        }
    },
    components: { ProductList }
}
</script>    

<template>
    <h2>Редактировать заказ</h2>
    <div>
        <p><input v-model="order.customerName" placeholder="Имя покупателя"/></p>
        <p><input v-model="order.customerPhone" placeholder="Номер покупателя"/></p>
        <p><select v-model="order.status">
            <option disabled value="">Выберите статус заказа</option>
            <option>CREATED</option>
            <option>CONFIRMED</option>
            <option>SENT</option>
            <option>DELIVERED</option>
        </select>
        </p>
        <p><button @click="submit">Сохранить</button></p>
    </div>

    <div class="list">
    <h3>Товары в заказе</h3>
        <ProductList
            :products="products"
            showButton
            removeButton
            @show-product="show"
            @remove-product="remove"
        ></ProductList>
    </div>
</template>